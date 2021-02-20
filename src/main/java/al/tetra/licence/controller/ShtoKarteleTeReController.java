package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import al.tetra.licence.entity.Perdorues;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
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
	
	@FXML
	private MenuBar menuShtoKarteleTeRe;
	@FXML
	private Label shtoKarteleTeReLabel;
	@FXML
	private ImageView imageShtoKarteleTeRe;
	@FXML
	private TextField emriIPacientitTextField;
	@FXML
	private Button SearchButton;
	@FXML
	private Label emriLabel;
	@FXML
	private TextField emriTextField;
	@FXML
	private Label moshaLabel;
	@FXML
	private TextField moshaTextField;
	@FXML
	private Label semundjaLabel;
	@FXML
	private TextField semundjaTextField;
	@FXML
	private Label ilaceLabel;
	@FXML
	private TextField ilaceTextField;
	@FXML
	private Button ruajButton;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 200, 160, false, true);
		imageShtoKarteleTeRe.setImage(image);
	}
	/*@FXML
	public void closeShikoKartele() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/shtoKarteleTeRe.fxml"));
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);

		Parent main = FXMLLoader.load(getClass().getResource("/fxml/leshoRecete.fxml"));
		Scene sceneMain = new Scene(main);
		Stage stage = new Stage();

		stage.setTitle("Sistemi i menaxhimit te farmacise");
		stage.setScene(sceneMain);
		stage.sizeToScene();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOnCloseRequest(e -> Platform.exit());
		stage.show();
		scene.getWindow().fireEvent(new WindowEvent(scene.getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
		stage1.close();
	}*/
}
