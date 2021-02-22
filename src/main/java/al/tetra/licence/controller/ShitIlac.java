package al.tetra.licence.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.tetra.licence.entity.Ilace;
import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.entity.Recete;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/fxml/shitIlace.fxml")

public class ShitIlac implements Initializable {
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
	private Pane shitIlacePane;
	@FXML
	private Label shitIlaceLabel;
	@FXML
	private Label meReceteLabel;
	@FXML
	private Label messageLabel;
	@FXML
	private RadioButton poRadioButton;
	@FXML
	private RadioButton joRadioButton;
	@FXML
	private TextField kerkoIlacinTextField;
	@FXML
	private Button shtoButton;
	@FXML
	private ImageView shitIlaceImage;
	// Pane Receta
	@FXML
	private Pane recetaPane;
	@FXML
	private TextField kerkoPacientField;
	@FXML
	private TextField emriPacientitField;
	@FXML
	private TextField dateLeshimiField;
	@FXML
	private TextField emriMjekutField;
	@FXML
	private TextArea ilacetRecetaField;
	@FXML
	private Button kerkoButton;

	// Elementet shtese
	@FXML
	private TextArea ilecetListeField;
	@FXML
	private TextField totaliField;
	@FXML
	private Button shitButton;
	@FXML
	private Button fshiReceteField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*
		 * File file = new File("C:/Users/CRS/Desktop/ilacee.jpg"); Image image = new
		 * Image(file.getPath(), 160, 160, false, true); shitIlaceImage.setImage(image);
		 */
	}

	/*
	 * @FXML public void closePerditesoIlace() throws IOException { Parent root =
	 * FXMLLoader.load(getClass().getResource("/fxml/shitIlace.fxml")); Scene scene
	 * = new Scene(root); Stage stage1 = new Stage(); stage1.setScene(scene);
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
	public void poRecete(ActionEvent event) {
		if (poRadioButton.isSelected()) {
			recetaPane.setVisible(true);
			messageLabel.setText("Ju lutem zgjidhni receten perpara se te kryeni veprime te tjera !");
		}
	}

	@FXML
	public void kerkoIlac() {
		if (poRadioButton.isSelected() && StringUtils.isNotBlank(ilacetRecetaField.getText())) {
			String listIlace = "";
			double vlera = 0;
			String[] ilacet = ilacetRecetaField.getText().split(",");
			Ilace i = mjekuService.getIlacByName(kerkoIlacinTextField.getText());
			for (int j = 0; j < ilacet.length; j++) {
				if (i.getEmer().equals(ilacet[j])) {
					if (StringUtils.isBlank(ilecetListeField.getText())) {
						listIlace += i.getEmer();
						ilecetListeField.setText(listIlace);
						vlera = i.getCmimShitje();
						totaliField.setText("" + vlera);

					} else {
						listIlace += "," + i.getEmer();
						ilecetListeField.setText(listIlace);
						vlera += i.getCmimShitje();
						totaliField.setText("" + vlera);
					}
				}
			}
		} else {
			Ilace i = mjekuService.getIlacByName(kerkoIlacinTextField.getText());
			String listIlace = "";
			double vlera = 0;
			if (!i.isVetemMeRecete()) {
				if (StringUtils.isBlank(ilecetListeField.getText())) {
					listIlace += i.getEmer();
					ilecetListeField.setText(listIlace);
					vlera = i.getCmimShitje();
					totaliField.setText("" + vlera);
				} else {
					listIlace += "," + i.getEmer();
					ilecetListeField.setText(listIlace);
					vlera += i.getCmimShitje();
					totaliField.setText("" + vlera);
				}
			}
		}

	}
	@FXML
	public void fshiRecete() {
		Recete r = mjekuService.getReceteByName(kerkoPacientField.getText());
		mjekuService.deleteReceteById(r.getId());
		messageLabel.setText("Receta u fshi me sukses");
	}
	@FXML
	public void shitIlac() {
		if(StringUtils.isNotBlank(ilecetListeField.getText()) &&StringUtils.isNotBlank(totaliField.getText())) {
			messageLabel.setText("Shitja u krye me sukses !");
			ilecetListeField.clear();
			totaliField.clear();
			kerkoPacientField.clear();
			emriPacientitField.clear();
			dateLeshimiField.clear();
			emriMjekutField.clear();
			ilacetRecetaField.clear();
			kerkoIlacinTextField.clear();
			recetaPane.setVisible(false);
			poRadioButton.setSelected(false);
			poRadioButton.setSelected(false);
		}
	}

	@FXML
	public void kerkoPacientRecete() {
		Recete r = mjekuService.getReceteByName(kerkoPacientField.getText());
		emriPacientitField.setText(r.getPacienti());
		dateLeshimiField.setText("" + r.getDateLeshimi());
		Perdorues p = mjekuService.getPerodruesById(r.getMjek());
		emriMjekutField.setText(p.getEmer() + " " + p.getMbiemer());
		ilacetRecetaField.setText(mjekuService.getIlaceByRecete(kerkoPacientField.getText()));
	}

}
