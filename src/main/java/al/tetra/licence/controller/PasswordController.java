package al.tetra.licence.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.service.PasswordService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/generatePassword.fxml")
public class PasswordController {

	@Autowired
	PasswordService passwordService;

	@FXML
	private Button passGen;

	@FXML
	private Button passClear;

	@FXML
	private Button decryptPass;

	@FXML
	private TextField showPass;

	@FXML
	private TextField inputPass;

	@FXML
	public void generatePassword(ActionEvent event) throws URISyntaxException, IOException {

		passwordService.generatePassword(showPass, inputPass);

	}

	@FXML
	public void decryptPassword(ActionEvent event) throws URISyntaxException, IOException {

		passwordService.decryptPassword(showPass, inputPass);

	}

	@FXML
	public void clearPassword(ActionEvent event) throws URISyntaxException, IOException {

		passwordService.clearPassword(showPass, inputPass);

	}

}
