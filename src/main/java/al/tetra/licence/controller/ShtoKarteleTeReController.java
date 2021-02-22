package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Ilace;
import al.tetra.licence.entity.Kartele;
import al.tetra.licence.entity.Pacient;
import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.entity.Semundje;
import al.tetra.licence.service.MjekuService;
import al.tetra.licence.service.PerdoruesService;
import io.micrometer.core.instrument.util.StringUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
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
@FxmlView("/fxml/shtoKarteleTeRe.fxml")
public class ShtoKarteleTeReController implements Initializable{
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
	private ImageView imageShtoKarteleTeRe;
	@FXML
	private Pane shtoKarteleTeRePane;
	@FXML
	private AnchorPane shtoKarteleTereAnchorPane;
	@FXML
	private Label shtoKarteleTeReLabel;
	@FXML
	private TextField emriIPacientitTextField;
	@FXML
	private Button SearchButton;
	@FXML
	private Button SearchButton1;
	@FXML
	private Button SearchButton11;
	@FXML
	private Label emriLabel;
	@FXML
	private Label moshaLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private Label semundjaLabel;
	@FXML
	private Label ilaceLabel;
	@FXML
	private TextField emriTextField;
	@FXML
	private TextArea semundjaTextField;
	@FXML
	private TextField moshaTextFild;
	@FXML
	private TextField emerPacientiSearch;
	@FXML
	private TextField semundjeSearch;
	@FXML
	private TextField ilacSearch;
	@FXML
	private TextArea ilaceTextField;
	@FXML
	private Button ruajButton;
	private Semundje s;
	private Pacient p;
	private Ilace i;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 200, 160, false, true);
		imageShtoKarteleTeRe.setImage(image);
	}

	/*
	 * @FXML public void closeShikoKartele() throws IOException { Parent root =
	 * FXMLLoader.load(getClass().getResource("/fxml/shtoKarteleTeRe.fxml")); Scene
	 * scene = new Scene(root); Stage stage1 = new Stage(); stage1.setScene(scene);
	 * 
	 * Parent main =
	 * FXMLLoader.load(getClass().getResource("/fxml/leshoRecete.fxml")); Scene
	 * sceneMain = new Scene(main); Stage stage = new Stage();
	 * 
	 * stage.setTitle("Sistemi i menaxhimit te farmacise");
	 * stage.setScene(sceneMain); stage.sizeToScene();
	 * stage.initModality(Modality.APPLICATION_MODAL); stage.setOnCloseRequest(e ->
	 * Platform.exit()); stage.show(); scene.getWindow().fireEvent(new
	 * WindowEvent(scene.getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
	 * stage1.close(); }
	 */
	@FXML
	public void searchShikoKartele() throws IOException {

		if (p != null) {
			System.err.println("FXML" + p.getEmer());
			emriTextField.setText(p.getEmer());
			moshaTextFild.setText("" + p.getMosha());
		} else {
			messageLabel.setText("Pacienti i kerkuar nuk ekziston !");
		}
		if (s != null) {
			if (StringUtils.isNotBlank(semundjaTextField.getText()))
				semundjaTextField.setText(semundjaTextField.getText() + " ," + s.getEmer());
			else {
				semundjaTextField.setText(s.getEmer());
			}
		} else {
			messageLabel.setText("Semundja nuk ekziston ne bazen e te dhenave !");
		}
		if (i != null) {
			// ilaceTextField.setText(ilaceTextField.getText()+" ,"+i.getEmer());
			if (StringUtils.isNotBlank(ilaceTextField.getText()))
				ilaceTextField.setText(ilaceTextField.getText() + " ," + i.getEmer());
			else {
				ilaceTextField.setText(i.getEmer());
			}
		} else {
			messageLabel.setText("Ilaci nuk ekziston ne bazen e te dhenave !");
		}
		Kartele k = mjekuService.ruajKartele(p.getId(), ilaceTextField.getText(), semundjaTextField.getText());
		if (k != null) {
			messageLabel.setText("Kartela u ruajt me sukses !");
		} else {
			messageLabel.setText("Ndodhi nje problem gjate ruajtes se karteles !");
		}
	}

	@FXML
	public void searchSemundjeKartele() throws IOException {
		s = mjekuService.getSemundjeByName(semundjeSearch.getText());
	}

	@FXML
	public void searchIlaceKartele() throws IOException {
		i = mjekuService.getIlacByName(ilacSearch.getText());
	}

	@FXML
	public void searchPacientByName() throws IOException {
		p = mjekuService.getPacientByName(emerPacientiSearch.getText());
	}

}
