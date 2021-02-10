package al.tetra.licence.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

import javafx.event.ActionEvent;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;


@Component
@FxmlView("/fxml/ui3.fxml")
public class FxmlController {

	@FXML
	private Label l1;
	
	@FXML
	private Label l2;
	
	@FXML
	private Label l3;
	
	@FXML
	private TextField tf1;

	@FXML
	private TextField tf2;

	@FXML
	private Label typeOfAction;

	@FXML
	private Button generate;

	@FXML
	private Button validate;

	@FXML
	private Button copy;
	
	@FXML
	private Button okid;
	
	@FXML
	public void login(ActionEvent ev) {
		typeOfAction.setText("Validate");
		tf1.setText("");
		tf2.setText("");
		tf2.setEditable(true);
		copy.setVisible(false);
		
	}

	@FXML
	public void gjenero(ActionEvent event) {
		typeOfAction.setText("Generate");
		tf1.setText("");
		tf2.setText("");
		tf2.setEditable(false);
		copy.setVisible(false);
	}

	@FXML
	public void copyCode(ActionEvent event) {
		String myString = tf2.getText();
		System.err.println("text:: " + myString);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(myString);
		clipboard.setContents(strSel, null);
	}
	

    @FXML
    void setType(ActionEvent event) {
    	switch(typeOfAction.getText()) {
    		case "Generate":
    			try {
    				System.out.println("sgjsg" + event);

    				String serialNumberEncoded = calculateSecurityHash(tf1.getText(), "MD2")
    						+ calculateSecurityHash(tf1.getText(), "MD5") + calculateSecurityHash(tf1.getText(), "SHA1");

    				String serialNumberEncodedSpecific = "" + serialNumberEncoded.charAt(100) + serialNumberEncoded.charAt(50)
    						+ serialNumberEncoded.charAt(32) + serialNumberEncoded.charAt(76) + "-"
    						+ serialNumberEncoded.charAt(73) + serialNumberEncoded.charAt(72) + serialNumberEncoded.charAt(2)
    						+ serialNumberEncoded.charAt(91) + serialNumberEncoded.charAt(47) + "-"
    						+ serialNumberEncoded.charAt(98) + serialNumberEncoded.charAt(65) + serialNumberEncoded.charAt(27)
    						+ serialNumberEncoded.charAt(53) + "-" + serialNumberEncoded.charAt(18)
    						+ serialNumberEncoded.charAt(85) + serialNumberEncoded.charAt(99) + serialNumberEncoded.charAt(15)
    						+ serialNumberEncoded.charAt(102);

    				System.out.println("serialNumber encoded: " + serialNumberEncodedSpecific);
    				copy.setVisible(true);
    				l1.setVisible(true);
    				l2.setVisible(false);
    				l3.setVisible(false);
    				tf2.setText(serialNumberEncodedSpecific);

    			} catch (Exception e) {

    				e.printStackTrace();
    			}
    			break;
    		case "Validate":
    			try {

    				// String serialNumber = "PGUKD0BCYB25MZ";

    				String serialNumberEncoded = calculateSecurityHash(tf1.getText(), "MD2")
    						+ calculateSecurityHash(tf1.getText(), "MD5") + calculateSecurityHash(tf1.getText(), "SHA1");

    				String serialNumberEncodedSpecific = "" + serialNumberEncoded.charAt(100) + serialNumberEncoded.charAt(50)
    						+ serialNumberEncoded.charAt(32) + serialNumberEncoded.charAt(76) + "-"
    						+ serialNumberEncoded.charAt(73) + serialNumberEncoded.charAt(72) + serialNumberEncoded.charAt(2)
    						+ serialNumberEncoded.charAt(91) + serialNumberEncoded.charAt(47) + "-"
    						+ serialNumberEncoded.charAt(98) + serialNumberEncoded.charAt(65) + serialNumberEncoded.charAt(27)
    						+ serialNumberEncoded.charAt(53) + "-" + serialNumberEncoded.charAt(18)
    						+ serialNumberEncoded.charAt(85) + serialNumberEncoded.charAt(99) + serialNumberEncoded.charAt(15)
    						+ serialNumberEncoded.charAt(102);

    				System.out.println("serialNumber encoded: " + serialNumberEncodedSpecific);

    			
    				// String serialNumberCalc = "2cb7-d5922-1fd0-8ec7c";
    				String serialNumberCalc = tf2.getText();

    				System.out.println(" serialNumberCalc: " + serialNumberCalc);

    				l1.setVisible(false);
    				if (serialNumberEncodedSpecific.equals(serialNumberCalc))
    					l2.setVisible(true);
    				else 
    					l3.setVisible(true);

    			} catch (Exception e) {

    				e.printStackTrace();
    			}
    			break;
    	}
    }

	public static String calculateSecurityHash(String stringInput, String algorithmName)
			throws NoSuchAlgorithmException {
		String hexMessageEncode = "";
		byte[] buffer = stringInput.getBytes();
		java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(algorithmName);
		messageDigest.update(buffer);
		byte[] messageDigestBytes = messageDigest.digest();
		for (int index = 0; index < messageDigestBytes.length; index++) {
			int countEncode = messageDigestBytes[index] & 0xff;
			if (Integer.toHexString(countEncode).length() == 1)
				hexMessageEncode = hexMessageEncode + "0";
			hexMessageEncode = hexMessageEncode + Integer.toHexString(countEncode);
		}
		return hexMessageEncode;
	}
}
