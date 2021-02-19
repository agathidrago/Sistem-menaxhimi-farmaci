package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.service.PerdoresService;
import antlr.StringUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/editPerdorues.fxml")
public class PerdoruesController {
	@Autowired
	private PerdoresService perdoruesService;
	@FXML
	private MenuBar menuBar;
	@FXML
	private Menu skedariMenu;
	@FXML
	private MenuItem mbyllMenu;
	@FXML
	private Pane mainPane;
	@FXML
	private TextField emerField;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField oldPassField;
	@FXML
	private TextField newPassField;
	@FXML
	private TextField confirmPassField;
	@FXML
	private Button saveButton;
	@FXML
	private Button changePassButtoon1;
	@FXML
	private Button changePassButton2;
	@FXML
	private Label messageLabel;

	@FXML
	public void updatePerdorues(ActionEvent event) {
		String username = null;
		String emer = null;
		String email = null;
		if (usernameField != null) {
			username = usernameField.getText();
		} else {
			username = perdoruesService.getPerodruesTeLoguar().getUsername();
		}
		if (emerField != null) {
			emer = emerField.getText();
		} else {
			emer = perdoruesService.getPerodruesTeLoguar().getEmer();
		}
		if (emailField != null) {
			email = emailField.getText();
		} else {
			email = perdoruesService.getPerodruesTeLoguar().getEmail();
			System.err.println("email"+email);
		}
		try {
			
			Perdorues perdorues = perdoruesService.updatePerdorues(emer, email, username,
					perdoruesService.getPerodruesTeLoguar().getId());
			messageLabel.setText("Useri u update-ua me sukses !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
