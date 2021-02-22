package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.service.PerdoruesService;
import io.micrometer.core.instrument.util.StringUtils;
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
@FxmlView("/fxml/editPerdoruesPane.fxml")
public class PerdoruesController {
	@Autowired
	private PerdoruesService perdoruesService;
	@FXML
	private MenuBar menuShtoKarteleTeRe;
	@FXML
	private Menu fileMenu;
	@FXML
	private MenuItem mbyllMenuItem1;
	@FXML
	private Menu pacientMenu;
	@FXML
	private MenuItem regjistroPacientMenuItem1;
	@FXML
	private MenuItem shikoKarteleMenuItem2;
	@FXML
	private MenuItem shtoKarteleTeReMenuItem3;
	@FXML
	private Menu receteMenu;
	@FXML
	private MenuItem leshoReceteMenuItem1;
	@FXML
	private Menu ilacMenu;
	@FXML
	private MenuItem perditesoIlacMenuItem1;
	@FXML
	private MenuItem shitIlacMenuItem2;
	@FXML
	private Menu sherbimeMenu;
	@FXML
	private MenuItem editoPerdoruesMenuItem1;
	@FXML
	private MenuItem shtoPerdoruesMenuItem2;
	@FXML
	private MenuBar menuBar;
	@FXML
	private Menu skedariMenu;
	@FXML
	private MenuItem mbyllMenu;
	@FXML
	private Pane mainPane;
	@FXML
	private Pane passPane;
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
	private TextField addressTextField;
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

		Perdorues p = perdoruesService.updatePerdorues(emerField.getText(), emailField.getText(),
				usernameField.getText(), addressTextField.getText(), new Long(1));
		if (p != null) {
			messageLabel.setText("User u updatua me sukses !");
		}

	}

	@FXML
	public void updateFjalekalim(ActionEvent event) {
		Perdorues p = perdoruesService.getPerodruesTeLoguar();
		System.err.println(p.getFjalekalim());
		if ((!p.getFjalekalim().equals(oldPassField.getText())) || StringUtils.isBlank(oldPassField.getText())) {
			messageLabel.setText("Fjalekalimi nuk eshte i sakte ");
		} else if (!confirmPassField.getText().equals(newPassField.getText())) {
			messageLabel.setText("Fjalekalimi nuk perputhet ! ");
		} else {
			p = perdoruesService.updateFjalekalim(newPassField.getText());
			if (p != null)
				messageLabel.setText("Fjalekalimi u ndryshua me sukses! ");
		}
	}
	@FXML
	public void showPassPane(ActionEvent event) {
		passPane.setVisible(true);
	}

}
