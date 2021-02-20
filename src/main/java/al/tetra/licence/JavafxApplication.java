package al.tetra.licence;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import net.rgielen.fxweaver.core.FxWeaver;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import al.tetra.licence.controller.AdminController;
import al.tetra.licence.controller.LeshoReceteController;
import al.tetra.licence.controller.LoginController;
import al.tetra.licence.controller.PerdoruesController;
import al.tetra.licence.controller.ShtoKarteleTeReController;


public class JavafxApplication extends Application {

	private ConfigurableApplicationContext context;

	@Override
	public void init() {
		this.context = new SpringApplicationBuilder().sources(Main.class)
				.run(getParameters().getRaw().toArray(new String[0]));

	}

	@Override
	public void start(Stage stage) {
		FxWeaver fxWeaver = context.getBean(FxWeaver.class);
		Parent root = fxWeaver.loadView(LoginController.class);
		Scene scene = new Scene(root);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css"); //(3)
		stage.setTitle("Sistemi i menaxhimit te farmacise");
		//stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/tray.jpeg")));
        stage.getIcons().add(new Image("/images/login.png"));
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setOnCloseRequest(e -> Platform.exit());
		stage.show();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				context.close();
				Platform.exit();
				System.exit(0);
			}
		});
	}
}
