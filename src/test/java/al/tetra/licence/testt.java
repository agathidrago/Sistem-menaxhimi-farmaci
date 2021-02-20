package al.tetra.licence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.service.PasswordService;
import al.tetra.licence.service.PerdoruesService;
import al.tetra.licence.util.CommandLineUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testt {
	
	@Autowired
	private PerdoruesService perdorues;
	
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * @Autowired private RestartUtil restartUtil;
	 */

	public void restart() {
		// Runnable r=null;
		try {
			System.err.println("Running");
			// restartUtil.restartApplication(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//@Test
	public void commands2() {

		ProcessBuilder pb = new ProcessBuilder(CommandLineUtil.openssl, "pkcs12", "-in",
				"H:\\GenCer\\tetra_solutions_new.p12", "-out", "H:\\GenCer\\newOme1.crt", "-clcerts", "-nokeys",
				"-password", "pass:123456");
		try {
			Process shell = pb.start();
			int error = shell.waitFor();
			shell.destroy();
			if (error == 0) {

				pb = new ProcessBuilder(CommandLineUtil.openssl, "pkcs12", "-in", "H:\\GenCer\\tetra_solutions_new.p12",
						"-out", "H:\\GenCer\\newOme1.key", "-nocerts", "--nodes", "-password", "pass:123456");

				shell = pb.start();
				InputStream shellIn = shell.getInputStream();
				String response = IOUtils.toString(shellIn, "UTF-8");
				System.out.println(response);
				shellIn.close();
				shell.destroy();
			}

			if (error == 0) {
				System.err.println("erdhi te if2");
				pb = new ProcessBuilder(CommandLineUtil.openssl, "pkcs12", "-export", "-out", "H:\\GenCer\\newCert.p12",
						"-inkey", "H:\\GenCer\\newOme1.key", "-in", "H:\\GenCer\\newOme1.crt", "-password",
						"pass:123456");
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

	}

	//@Test
	public void getP12Info() throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, IOException {

		KeyStore p12 = KeyStore.getInstance("pkcs12");
		p12.load(new FileInputStream("H:\\GenCer\\tetra_solutions_new.p12"), "123456".toCharArray());
		Enumeration e = p12.aliases();
		while (e.hasMoreElements()) {
			String alias = (String) e.nextElement();
			X509Certificate c = (X509Certificate) p12.getCertificate(alias);
			Principal subject = c.getSubjectDN();
			String subjectArray[] = subject.toString().split(",");
			for (String s : subjectArray) {
				String[] str = s.trim().split("=");
				String key = str[0];
				String value = str[1];
				System.out.println(key + " - " + value);
			}
		}
	}
	
	//@Test
	/*public void whenPasswordGeneratedUsingPassay_thenSuccessful() {
		passwordService.generatePassayPassword();
	}
*/
	
@Test
	@Transactional
	@Rollback(false)

	public void addUser() {
		try {
		Perdorues p=perdorues.updatePerdorues("agathulaaaaaaa", "", "111", new Long(1), new Long(1));
		System.err.println(p.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
