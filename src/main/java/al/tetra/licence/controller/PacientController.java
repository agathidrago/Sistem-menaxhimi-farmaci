package al.tetra.licence.controller;

import java.io.File;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Pacient;
import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.service.MjekuService;
import al.tetra.licence.service.PerdoruesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/shtoPacient.fxml")
public class PacientController implements Initializable {
	@Autowired
	private PerdoruesService perdoruesService;
	@Autowired
	private MjekuService mjekuService;
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
	private TextField emerTextField;
	@FXML
	private TextField moshaTextField1;
	@FXML
	private TextField telefonTextField;
	@FXML
	private TextField addressTextField;
	@FXML
	private DatePicker datelindjaPicker;
	@FXML
	private RadioButton gjiniaMashkullRadioButton;
	@FXML
	private RadioButton gjiniaFemerRadioButton;
	@FXML
	private Button registerButton;
	@FXML
	private ImageView imageAdmin;
	@FXML
	private Label messageLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 200, 160, false, true);
		imageAdmin.setImage(image);

	}

	@FXML
	public void shtoPerdorues(ActionEvent event) {
		RadioButton selected = null;
		if (gjiniaFemerRadioButton.isSelected()) {
			selected = gjiniaFemerRadioButton;
		} else {
			selected = gjiniaMashkullRadioButton;
		}
		Date date = java.util.Date
				.from(datelindjaPicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Pacient p = mjekuService.shtoPacientTeRi(emerTextField.getText(), Integer.parseInt(moshaTextField1.getText()),
				telefonTextField.getText(), addressTextField.getText(), date, selected.getText(), messageLabel);
		if (p != null) {
			messageLabel.setText("Pacienti u krijua me sukses");
			registerButton.setDisable(true);
		}

	}
}
