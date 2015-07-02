package marketClient.view;


import marketClient.view.*;
import marketCommon.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainClient extends Application {
	
	static Socket conexao;
//	static ObjectInputStream inFromServer;
//	static ObjectOutputStream outToServer;
	static String host,port;
	
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
		
		
		String[] hostpath = new String[2];
		try{
			BufferedReader br = new BufferedReader(new FileReader("src/marketClient/view/hostpath.txt"));
	        hostpath = br.readLine().split(":");
//	        System.out.println("[0] - "+ hostpath[0] +" [1] - "+ hostpath[1]);
	        br.close();
		}catch(IOException ex){}
		
		try {
			conexao =  new Socket(hostpath[0],Integer.parseInt(hostpath[1]));
		} catch (NumberFormatException e) {
			System.out.println("Erro para conectar no server");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.out.println("Erro para conectar no server");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro para conectar no server");
			e.printStackTrace();
		}
		
		
		launch(args);
			

			
	}
	
	public MainClient()
	{}
}
