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
@FxmlView("/fxml/perditesoIlac.fxml")

public class PerditesoIlac implements Initializable{
	@FXML
	private MenuBar perditesoIlacMenuBar;
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
    private TextField cmimiTextField1;
    @FXML
    private Button fshiButton;
    @FXML
    private Button ruajButton;
    @FXML
    private ImageView perditesoIlaceImage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("C:/Users/CRS/Desktop/ilacee.jpg");
		Image image = new Image(file.getPath(), 160, 160, false, true);
		perditesoIlaceImage.setImage(image);
	}
	@FXML
	public void closePerditesoIlace() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/perditesoIlac.fxml"));
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);

		Parent main = FXMLLoader.load(getClass().getResource("/fxml/______.fxml"));
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
