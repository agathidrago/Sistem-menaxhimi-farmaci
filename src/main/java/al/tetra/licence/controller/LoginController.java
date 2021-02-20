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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/login.fxml")
public class LoginController implements Initializable {
	@Autowired
	private PerdoruesService perdoruesService;

	@FXML
	private BorderPane borderPaneLogin;
	@FXML
	private AnchorPane anchorPaneLeft;
	@FXML
	private AnchorPane anchorPaneRight;
	@FXML
	private ImageView logInImage;
	@FXML
	private Label logInLabel;
	@FXML
	private Label usernameLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Button autentifikohuButton;
	
	Stage stage1=null;

	@Override
	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/login.png");
		Image image = new Image(file.getPath(), 160, 160, false, true);
		logInImage.setImage(image);

	}

	@FXML
	public void autentifikoPerdorues(ActionEvent event) {

		String username = usernameTextField.getText();
		String password = passwordTextField.getText();
	/*	System.err.println(username);
		System.err.println(password);*/
		Perdorues perdorues = perdoruesService.autentifikoPerdorues(username, password);
		//System.err.println(perdorues.toString());
		if (perdorues != null) {
			messageLabel.setText("Useri u autentifikua me sukses !");
			try {
				closeLogInStage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			messageLabel.setText("Kredencialet nuk jane te sakta / useri nuk ekziston");
		}

	}

	@FXML
	public void closeLogInStage() throws IOException {
		/*Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);*/
		stage1=(Stage)autentifikohuButton.getScene().getWindow();
		stage1.close();

		Parent main = FXMLLoader.load(getClass().getResource("/fxml/editPerdorues.fxml"));
		Scene sceneMain = new Scene(main);
		Stage stage = new Stage();
		
		stage.setTitle("Sistemi i menaxhimit te farmacise");
		stage.setScene(sceneMain);
		stage.sizeToScene();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOnCloseRequest(e -> Platform.exit());
		stage.show();

		
		/*scene.getWindow().fireEvent(new WindowEvent(scene.getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
		stage1.close();
*/
		/*stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent e) {
				context.close();
				Platform.exit();
				System.exit(0);
			}
		});*/

	}

}
