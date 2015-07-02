package marketServer.view;

import java.io.IOException;
import java.util.ArrayList;

import marketCommon.product.Product;
import marketCommon.user.User;
import marketServer.ServerConfiguration;
import marketServer.controller.MarketController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainServer extends Application {
	static ArrayList<Product> _prods = new ArrayList<Product>();
	static ArrayList<User> _users = new ArrayList<User>();
	static MarketController _control = new MarketController();
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("T H E * S U P E R M A R K E T * S I M U L A T O R");
		
		try {
			FXMLLoader loader = new FXMLLoader(MainServer.class.getResource("ServerView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		ServerConfiguration sConf = new ServerConfiguration(_control);
		Thread t = new Thread(sConf);
		t.start();
		
		
		launch(args);
		//Main TODO here.
	}
	
	public MainServer()
	{}
}