package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.glass.ui.MenuBar;

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
@FxmlView("/fxml/shikoKartele.fxml")

public class ShikoKarteleController implements Initializable {
	@Autowired
	private PerdoruesService perdoruesService;
	
	@FXML
	private MenuBar menuShikoKartele;
	@FXML
	private Pane shikoKartele;
	@FXML
	private ImageView imageShikoKartele;
	@FXML
	private Label shikoKarteleLabel;
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
	private TextField semundjeTextField;
	@FXML
	private Label ilaceLabel;
	@FXML
	private TextField ilaceTextField;
	@FXML
	private Button shtoKarteleButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("C:/Users/CRS/Desktop/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 160, 160, false, true);
		imageShikoKartele.setImage(image);
	}
	@FXML
	public void closeShikoKartele() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/shikoKartele.fxml"));
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);

		Parent main = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
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
	}
}
