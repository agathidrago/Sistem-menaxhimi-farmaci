package al.tetra.licence.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Certificate;
import al.tetra.licence.util.CommandLineUtil;
import al.tetra.licence.util.SignUtil;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Service("certificateService")
public class CertificateService {

	private String keyStoreType = "PKCS12";

	@Autowired
	private CommandLineUtil cmd;

	public X509Certificate validateCertificate(Certificate cert) {

		try {
			SignUtil.getSignKey(keyStoreType, cert.getFileLocation(), cert.getPass(), cert.getAlias(),
					cert.getKeyPass());
			X509Certificate x = SignUtil.getSignCert(keyStoreType, cert.getFileLocation(), cert.getPass(),
					cert.getAlias(), cert.getKeyPass());
			
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getCause().getMessage());
		}
		return null;

	}

	public void extractcertificate(File file, PasswordField password, ImageView open_folder,
			javafx.scene.control.Label gen_success) throws IOException, URISyntaxException {

		String certName = file.getName();
		String certPath = file.getPath();
		String certDir = file.getParent();
		String certNameWOExt = certName.substring(0, certName.lastIndexOf('.'));
		Image folder_ico = new Image(getClass().getResource("/images/folderIco.png").toURI().toString());

		ProcessBuilder pb = new ProcessBuilder(CommandLineUtil.openssl, "pkcs12", "-in", certPath, "-out",
				certDir + "\\" + certNameWOExt + ".crt", "-clcerts", "-nokeys", "-password",
				"pass:" + password.getText());
		//System.err.println("krijoi crt");
		try {

			Process shell = pb.start();
			int error = shell.waitFor();
			shell.destroy();
			if (error == 0) {
				//System.err.println("krijoi key");
				pb = new ProcessBuilder(CommandLineUtil.openssl, "pkcs12", "-in", certPath, "-out",
						certDir + "\\" + certNameWOExt + ".key", "-nocerts", "--nodes", "-password",
						"pass:" + password.getText());

				shell = pb.start();
				InputStream shellIn = shell.getInputStream();
				String response = IOUtils.toString(shellIn, "UTF-8");
				System.out.println(response);
				shellIn.close();
				shell.destroy();

			}

			if (error == 0) {
				//System.err.println("krijoi cert");
				pb = new ProcessBuilder(CommandLineUtil.openssl, "pkcs12", "-export", "-out",
						certDir + "\\" + certNameWOExt + "Extracted.p12", "-inkey", certDir + "\\" + certNameWOExt + ".key",
						"-in", certDir + "\\" + certNameWOExt + ".crt", "-password", "pass:" + password.getText());
				System.err.println(certDir+" certDir");
				shell = pb.start();
				InputStream shellIn = shell.getInputStream();
				String response = IOUtils.toString(shellIn, "UTF-8");
				System.out.println(response);
				shellIn.close();
				shell.destroy();
			}

		} catch (IOException ex) {
			System.out.println("failed");
		} catch (InterruptedException ex) {

		}

		open_folder.setVisible(true);
		open_folder.setImage(folder_ico);

		open_folder.setOnMouseClicked(e -> {
			try {
				Runtime.getRuntime().exec("explorer.exe /select," + certPath);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		gen_success.setVisible(true);

		Files.deleteIfExists(Paths.get(certDir + "\\" + certNameWOExt + ".crt"));
		Files.deleteIfExists(Paths.get(certDir + "\\" + certNameWOExt + ".key"));

	}
}
