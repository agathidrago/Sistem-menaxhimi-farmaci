package al.tetra.licence;

import javafx.application.Application;

import org.junit.BeforeClass;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		Application.launch(JavafxApplication.class, args);
	}

}
