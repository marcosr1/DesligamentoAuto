package application;

import java.io.IOException;


import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;



public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/Sample.fxml"));
			
			Scene scene = new Scene(parent);
			
			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
		
			stage.setScene(scene);
			stage.show();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
