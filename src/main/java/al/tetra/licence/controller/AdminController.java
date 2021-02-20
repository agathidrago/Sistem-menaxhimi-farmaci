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
import javafx.scene.control.MenuButton;
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
@FxmlView("/fxml/admin.fxml")
public class AdminController implements Initializable {
	@Autowired
	private PerdoruesService perdoruesService;
	@FXML
	private Pane adminPane;
	@FXML
	private MenuButton adminMenuButton;
	@FXML
	private MenuItem mbyllMenuItem;
	@FXML
	private Label firstNameLabel;
	@FXML
	private TextField emerTextField;
	@FXML
	private Label lastNameLabel;
	@FXML
	private TextField mbiemerTextField;
	@FXML
	private Label mobileLabel;
	@FXML
	private TextField telefonTextField;
	@FXML
	private Label emailLabel;
	@FXML
	private TextField emailTextField;
	@FXML
	private Label addressLabel;
	@FXML
	private TextField addressTextField;
	@FXML
	private Label genderLabel;
	@FXML
	private RadioButton gjiniaMashkullRadioButton;
	@FXML
	private RadioButton gjiniaFemerRadioButton;
	@FXML
	private Label usernameLabel;
	@FXML
	private TextField usernameTextField;
	@FXML
	private Label paswwordLabel;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label confirmPaswwordLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private PasswordField confirmPasswordTextField;	
	@FXML
	private TextField roliTextField;
	@FXML
	private Button registerButton;
	@FXML
	private ImageView imageAdmin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 200, 160, false, true);
		imageAdmin.setImage(image);

	}

/*	@FXML
	public void closeAdminPage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);

		Parent main = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
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
	
	@FXML
	public void shtoPerdorues(ActionEvent event) {
		System.err.println("hyri");
		RadioButton selected=null;
		if(gjiniaFemerRadioButton.isSelected()) {
			selected=gjiniaFemerRadioButton;
		}else {
			selected=gjiniaMashkullRadioButton;
		}
		Perdorues p= perdoruesService.shtoPerdoruesTeRi(emerTextField.getText(), mbiemerTextField.getText(), roliTextField.getText(), telefonTextField.getText(), emailTextField.getText(), addressTextField.getText(), selected.getText(), usernameTextField.getText(), passwordField.getText(),confirmPasswordTextField.getText(),messageLabel);
		if(p!=null) {
			messageLabel.setText("Useri u krijua me sukses");
			registerButton.setDisable(true);	
		}
		
		
	}
}
