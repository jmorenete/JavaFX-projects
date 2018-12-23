package org.jmorenete.javafx;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
//			BorderPane root = new BorderPane();
//			scene.getStylesheets().add(getClass().getResource("MyScene.fxml").toExternalForm());

			Parent root = FXMLLoader.load(getClass().getResource("MyScene.fxml"));
			Scene scene = new Scene(root,400,400);
			stage.setTitle("Bonjour World");
			stage.setScene(scene);
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
