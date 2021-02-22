package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Ilace;
import al.tetra.licence.entity.Pacient;
import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.entity.Semundje;
import al.tetra.licence.service.MjekuService;
import al.tetra.licence.service.PerdoruesService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/perditesoIlac.fxml")
public class PerditesoIlac implements Initializable {
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
	private Pane perditesoIlacePane;
	@FXML
	private Label perditesoIlaceLabel;
	@FXML
	private Label emriLabel;
	@FXML
	private TextField kerkoIlacTextField;
	@FXML
	private TextField emriTextField;
	@FXML
	private TextField sasiaTextField;
	@FXML
	private Label sasiaLabel;
	@FXML
	private TextField madhesiaTextField;
	@FXML
	private Label madhesiaLabel;
	@FXML
	private Label meReceteLabel;
	@FXML
	private RadioButton poButton;
	@FXML
	private RadioButton joButton;
	@FXML
	private Button searchButton;
	@FXML
	private DatePicker data;
	@FXML
	private Label dateLabel;
	@FXML
	private Label cmimiLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private TextField cmimiTextField1;
	@FXML
	private TextField cmimiTextField11;
	@FXML
	private Button fshiButton;
	@FXML
	private Button ruajButton;
	private Semundje s;
	private Pacient p;
	private Ilace i;
	@FXML
	private ImageView perditesoIlaceImage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/ilac.jpeg");
		Image image = new Image(file.getPath(), 160, 160, false, true);
		perditesoIlaceImage.setImage(image);
	}

	/*
	 * @FXML public void closePerditesoIlace() throws IOException { Parent root =
	 * FXMLLoader.load(getClass().getResource("/fxml/perditesoIlac.fxml")); Scene
	 * scene = new Scene(root); Stage stage1 = new Stage(); stage1.setScene(scene);
	 * 
	 * Parent main = FXMLLoader.load(getClass().getResource("/fxml/______.fxml"));
	 * Scene sceneMain = new Scene(main); Stage stage = new Stage();
	 * 
	 * stage.setTitle("Sistemi i menaxhimit te farmacise");
	 * stage.setScene(sceneMain); stage.sizeToScene();
	 * stage.initModality(Modality.APPLICATION_MODAL); stage.setOnCloseRequest(e ->
	 * Platform.exit()); stage.show(); scene.getWindow().fireEvent(new
	 * WindowEvent(scene.getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
	 * stage1.close(); }
	 */
	@FXML
	public void searchShikoIlac() throws IOException {

		if (i != null) {
			messageLabel.setText("Ilaci ekziston ne farmaci !");
			emriTextField.setText(i.getEmer());
			sasiaTextField.setText("" + i.getSasia());
			madhesiaTextField.setText("" + i.getMadhesia());
			/*
			 * dateToConvert.toInstant() .atZone(ZoneId.systemDefault()) .toLocalDateTime()
			 */
			data.setValue(i.getDate_furnizimi().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			cmimiTextField1.setText("" + i.getCmimShitje());
			cmimiTextField11.setText("" + i.getCmimBlerje());
			if (i.isVetemMeRecete()) {
				poButton.setSelected(true);
			} else {
				joButton.setSelected(true);
			}
		} else {
			messageLabel.setText("Ilaci i kerkuar nuk ekziston !");
		}
	}

	@FXML
	public void searchIlace() throws IOException {
		i = mjekuService.getIlacByName(kerkoIlacTextField.getText());
		if (i != null)
			searchShikoIlac();
		else {
			messageLabel.setText("Ilaci i kerkuar nuk ekziston !");
		}
	}

	@FXML
	public void updateIlac() throws IOException {
		if (i != null) {
			String emer;
			double sasia, madhesia, cmimSh, cmimB;
			Date date;
			boolean vetemMeRecete;

			if (i.getEmer() != emriTextField.getText()) {
				emer = emriTextField.getText();
			} else {
				emer = i.getEmer();
			}
			if (i.getSasia() != Double.parseDouble(sasiaTextField.getText())) {
				sasia = Double.parseDouble(sasiaTextField.getText());
			} else {
				sasia = i.getSasia();
			}
			if (i.getMadhesia() != Double.parseDouble(madhesiaTextField.getText())) {
				madhesia = Double.parseDouble(madhesiaTextField.getText());
			} else {
				madhesia = i.getMadhesia();
			}
			if (i.getCmimShitje() != Double.parseDouble(cmimiTextField1.getText())) {
				cmimSh = Double.parseDouble(cmimiTextField1.getText());
			} else {
				cmimSh = i.getCmimShitje();
			}
			if (i.getCmimBlerje() != Double.parseDouble(cmimiTextField11.getText())) {
				cmimB = Double.parseDouble(cmimiTextField11.getText());
			} else {
				cmimB = i.getCmimBlerje();
			}
			if (poButton.isSelected()) {
				vetemMeRecete = true;
			} else {
				vetemMeRecete = false;
			}
			if (i.getDate_furnizimi().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() != data.getValue()) {
				date = java.util.Date.from(data.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			} else {
				date = i.getDate_furnizimi();
			}
			i = mjekuService.updateIlac(i.getEmer(), emer, sasia, madhesia, date, cmimSh, cmimB, vetemMeRecete,
					i.getId());
			if (i.getId() != null) {
				messageLabel.setText("Update u krye me sukses !");
			} else {
				messageLabel.setText("Ilaci u shtua me sukses !");

			}
		}
		boolean vetemMeRecete;
		if (poButton.isSelected()) {
			vetemMeRecete = true;
		} else {
			vetemMeRecete = false;
		}
		i = mjekuService.updateIlac(null, emriTextField.getText(), Double.parseDouble(sasiaTextField.getText()),
				Double.parseDouble(madhesiaTextField.getText()),
				java.util.Date.from(data.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				Double.parseDouble(cmimiTextField1.getText()), Double.parseDouble(cmimiTextField11.getText()),
				vetemMeRecete, null);
		messageLabel.setText("Ilaci u shtua me sukses !");
	}

	@FXML
	public void deleteIlac() {
		if (i != null) {
			mjekuService.deleteIlaceById(i.getId());
			emriTextField.clear();
			sasiaTextField.clear();
			madhesiaTextField.clear();
			cmimiTextField1.clear();
			cmimiTextField11.clear();
			poButton.setSelected(false);
			joButton.setSelected(false);
			messageLabel.setText("Fshirja e ilacit u krye me sukses !");
		}

	}
}
