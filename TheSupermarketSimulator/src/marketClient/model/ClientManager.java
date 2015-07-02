package marketClient.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import marketCommon.Constants;

/**
 * 	Classe responsavel pela parte Model da aplicacao do cliente
 * 
 * @author 	Mateus Abrahao Cardoso
 * @nusp	8658332
 * 
 */

/**
 * Essa Classe se comunica com o Controller do Servidor 
 * 
 */

public class ClientManager {
	private ObjectInputStream 	_inFromServer;
	private static Socket 		_socketServer;
	private ObjectOutputStream	_outToServer; 
	
	
	public ClientManager(Socket client){
		_socketServer = client;
        try {
			_inFromServer = new ObjectInputStream(_socketServer.getInputStream());
	        _outToServer = new ObjectOutputStream(_socketServer.getOutputStream());
		} catch (IOException e) {
        	System.out.println("Erro na conexao do InputStream e OutputStream ");
		}
	}
	
	// Metodo se comunica com o MarketController.checkUser()
	public int checkUser(String id, String pw){
		int ret = Constants.SUCCESS;
		SendObject("checkUser," + id + "," + pw );
		
		try {
			ret = (Integer) _inFromServer.readInt();
		} catch (IOException e) {
			System.out.println("Erro na checagem do User");
			e.printStackTrace();
		}
		return ret;
	}
	
	
	
	// Metodo se comunica com o MarketController.addUser()
	public int addUser(String name, String address, String phone, 
			String email, String id, String pw){
		int ret = Constants.SUCCESS;
		SendObject("addUser," + name + "," + address + ","
				+ phone + "," + email + ","  + id + "," + pw);
		
		try {
			ret = (Integer) _inFromServer.readInt();
		} catch (IOException e) {
			System.out.println("Erro na adicao do User");
			e.printStackTrace();
		}
		return ret;
	}
	
	// Metodo se comunica com o MarketController.getAllProducts()
	public String[] getProducts(){
		String[] ret = null;
		try {
			
			SendObject("getAllProducts");
			
			ret = (String[]) _inFromServer.readObject();
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Erro na leitura do produtos");
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
	// Metodo se comunica com o MarketController.makePurchase()
	public int makePurchase(String name, int prodID){
		int ret = Constants.SUCCESS;
		return ret;
	}
	
	public void SendObject(String command) {
		
		try {
			_outToServer.writeObject(command);
		} catch (IOException e) {
			System.out.println("Erro no envio de um objeto");
			e.printStackTrace();
		}
	}

	
	public void CloseConnection(){
		try {
			_socketServer.close();
		} catch (IOException e) {
			System.out.println("Erro no fechamento do socket");
			e.printStackTrace();
		}
	}
	
}
