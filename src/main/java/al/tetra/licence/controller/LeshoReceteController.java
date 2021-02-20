package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.glass.ui.Menu;
import com.sun.glass.ui.MenuBar;
import com.sun.glass.ui.MenuItem;
import com.sun.glass.ui.View;

import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.entity.Recete;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
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
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/leshoRecete.fxml")
public class LeshoReceteController implements Initializable {
	@Autowired
	private PerdoruesService perdoruesService;
	@Autowired
	private MjekuService mjekuService;
	@FXML
	private Label faqeKryesoreMjekuLabel;
	@FXML
	private MenuBar menuLeshoRecete;
	@FXML
	private Menu fileMenu;
	@FXML
	private MenuItem mbyllMenu;
	@FXML
	private Menu pacientMenu;
	@FXML
	private MenuItem regjistroPacientMenuItem;
	@FXML
	private MenuItem shikoKarteleMenuItem;
	@FXML
	private MenuItem shtoKarteleTeReMenuItem;
	@FXML
	private Menu receteMenu;
	@FXML
	private MenuItem leshoReceteMenuItem;
	@FXML
	private Menu sherbimeMenu;
	@FXML
	private MenuItem editoPerdoruesMenuItem;
	@FXML
	private ImageView imageRecete;
	@FXML
	private Pane leshoRecetePane;
	@FXML
	private AnchorPane leshoReceteAnchorPane;
	@FXML
	private Label emerPacientiLabel;
	@FXML
	private Label ilaceLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private Label mjekuLabel;
	@FXML
	private TextField emerPacientiTextField;
	@FXML
	private TextField mjekuTextField;
	@FXML
	private TextArea ilaceTextArea;
	@FXML
	private Button ruajButton;
	@FXML
	private Label leshoReceteLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("/images/doctor-clinic.jpg");
		Image image = new Image(file.getPath(), 200, 160, false, true);
		imageRecete.setImage(image);
	}
/*	@FXML
	public void closeShikoKartele() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/leshoRecete.fxml"));
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
	public void shtoRecete(ActionEvent event) {
		System.err.println("hyri");		
		Recete r= mjekuService.leshoRecete(emerPacientiTextField.getText(), ilaceTextArea.getText(), mjekuTextField.getText());
		if(r!=null) {
			messageLabel.setText("Receta u krijua me sukses");
			//registerButton.setDisable(true);	
		}
		
		
	}
}
