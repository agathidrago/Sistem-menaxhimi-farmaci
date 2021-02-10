package al.tetra.licence.service;

import org.springframework.stereotype.Component;

import al.tetra.licence.util.EncryptionUtil;
import javafx.scene.control.TextField;

@Component
public class PasswordService {

	public void generatePassword(TextField showPass,TextField inputPass) {
	
		String getPassString = inputPass.getText();
		String password = EncryptionUtil.encrypt(getPassString);
		showPass.setVisible(true);
		showPass.setText(password);  
		//return password;
		
	}
	
	public void decryptPassword(TextField showPass,TextField inputPass) {
		
		String getPassString = inputPass.getText();
		String password = EncryptionUtil.decrypt(getPassString);
		showPass.setVisible(true);
		showPass.setText(password);
		
	}

	public void clearPassword(TextField showPass, TextField inputPass) {
		showPass.clear();
		inputPass.clear(); 

	}

}
