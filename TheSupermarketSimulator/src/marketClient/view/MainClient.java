package marketClient.view;

import marketClient.view.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainClient extends Application {
	
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("T H E * S U P E R M A R K E T * S I M U L A T O R");
		
		try {
			FXMLLoader loader = new FXMLLoader(MainClient.class.getResource("ClientView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		//Main TODO here.
	}
	
	public MainClient()
	{}
}
