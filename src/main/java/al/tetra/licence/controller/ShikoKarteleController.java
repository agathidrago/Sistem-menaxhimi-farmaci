package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Pacient;
import al.tetra.licence.entity.Perdorues;
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
@FxmlView("/fxml/shikoKartele.fxml")
public class ShikoKarteleController implements Initializable {
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
	private ImageView imageShikoKartele;
	@FXML
	private Pane shikoKartelePane;
	@FXML
	private Label shikoKarteleLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private TextField pacientiTextField;
	@FXML
	private Button serachButton;
	@FXML
	private Label teDhenatEKartelesSePacientitLabel;
	@FXML
	private Label emriIPacientitLabel;
	@FXML
	private TextField emriPacientitTextField;
	@FXML
	private Label moshaLabel;
	@FXML
	private TextField moshaTextField;
	@FXML
	private Label semundjeLabel;
	@FXML
	private TextArea semundjeTextField;
	@FXML
	private Label ilaceLabel;
	@FXML
	private TextArea ilaceTextField;
	@FXML
	private Button shtoKarteleButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 200, 160, false, true);
		imageShikoKartele.setImage(image);
	}
	/*
	 * @FXML public void closeShikoKartele() throws IOException { Parent root =
	 * FXMLLoader.load(getClass().getResource("/fxml/shikoKartele.fxml")); Scene
	 * scene = new Scene(root); Stage stage1 = new Stage(); stage1.setScene(scene);
	 * 
	 * Parent main = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
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
	public void searchShikoKartele() throws IOException {
		
		String emri = pacientiTextField.getText();
		
		Pacient p = mjekuService.getPacientByName(emri);
		if(p!=null) {
			messageLabel.setVisible(false);
		String ilace = mjekuService.getIlacePacient(p.getId());
		String semundje = mjekuService.getSemundjePacient(p.getId());
		String mosha = "" + p.getMosha();
		emriPacientitTextField.setText(emri);
		moshaTextField.setText(mosha);
		semundjeTextField.setText(semundje);
		ilaceTextField.setText(ilace);
		}else {
			emriPacientitTextField.clear();
			semundjeTextField.clear();
			ilaceTextField.clear();
			moshaTextField.clear();
			messageLabel.setVisible(true);
			messageLabel.setText("Pacienti i kerkuar nuk u gjend !");
		}

	}

}
