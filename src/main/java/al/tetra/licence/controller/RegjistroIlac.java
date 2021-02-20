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
import al.tetra.licence.service.PerdoresService;
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
@FxmlView("/fxml/regjistroIlac.fxml")
public class RegjistroIlac implements Initializable{
	@FXML
	private MenuBar regjistroIlacMenuBar;
	@FXML
	private Menu fileMenu;
	@FXML
	private MenuItem mbyllMenuItem;
	@FXML
	private Menu ilaceMenu;
	@FXML
	private MenuItem regjistroIlacMenuItem;
	@FXML
	private MenuItem perditesoIlacMenuItem;
	@FXML
	private MenuItem shitIlacMenuItem;
	@FXML
	private Menu recetaMenu;
	@FXML
	private MenuItem shikoReceteMenuItem;
	@FXML
	private Menu sherbimeMenu;
	@FXML
	private MenuItem editoPerdoruesMenuItem;
	@FXML
	private MenuItem shtoPerdoruesMenuItem;
	@FXML
	private Pane regjistroIlacPane;
	@FXML
	private Label regjistroIlacLabel;
	@FXML
	private Label emerIlaciTextField;
	@FXML
	private Label madhesiaLabel;
	@FXML
	private TextField emerIaciTextField;
	@FXML
	private TextField madhesiaTextField;
	@FXML
	private Label sasialabel;
	@FXML
	private TextField sasiaTextField;
	@FXML
	private Label dataFurnizimitLabel;
	@FXML
	private Label cmimiBlerjesLabel;
	@FXML
	private Label cmimiShitjeslabel;
	@FXML
	private TextField cmimiBlerjesTextField;
	@FXML
	private TextField cmimiBlerjesTextFiield;
	@FXML
	private Label meRecetelabel;
	@FXML
	private RadioButton poRadioButton;
	@FXML
	private RadioButton joRadioButton;
	@FXML
	private Button ruajButton;
	@FXML
	private DatePicker dataFurnizimit;
	@FXML
	private ImageView regjistroIlacImage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("C:/Users/CRS/Desktop/ilacee.jpg");
		Image image = new Image(file.getPath(), 160, 160, false, true);
		regjistroIlacImage.setImage(image);
		
	}
	@FXML
	public void closeRegjistroIlace() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/regjistroIlac.fxml"));
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);

		Parent main = FXMLLoader.load(getClass().getResource("/fxml/perditesoIlac.fxml"));
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
