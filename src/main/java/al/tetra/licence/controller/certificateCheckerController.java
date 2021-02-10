package al.tetra.licence.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

@Component
@FxmlView("/fxml/certificateChecker.fxml")
public class certificateCheckerController {
	@FXML
	private Button okid;
	@FXML
	private TextField cert_alias;
	@FXML
	private Label l1;
	@FXML
	private Label l2;
	@FXML
	private Label l3;
	@FXML
	private PasswordField cert_pass;
	@FXML
	private Label typeOfAction;
	@FXML
	private Button copy;
	@FXML
	private Button cert_upload;

	// Event Listener on Button[#okid].onAction
	@FXML
	public void setType(ActionEvent event) {
		System.err.println("Setting type...");
	}
	// Event Listener on Button[#copy].onAction
	@FXML
	public void copyCode(ActionEvent event) {
		// TODO Autogenerated
	}
}