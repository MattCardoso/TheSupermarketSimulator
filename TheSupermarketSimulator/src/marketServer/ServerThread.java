package marketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import marketCommon.Product;
import marketServer.controller.MarketController;

public class ServerThread implements Runnable 
{
	private Socket _client;
	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;
	private MarketController _control;

	public ServerThread(Socket client, MarketController ctrl) throws IOException
	{	
		_client = client;	
		outToClient = new ObjectOutputStream(_client.getOutputStream());	
		inFromClient = new ObjectInputStream(_client.getInputStream());
		_control = ctrl;
	}
	
	public void sendStorage() {
		
		
		ArrayList<Product> aux = _control.getAllProductList();
		ArrayList<String> prodStr = new ArrayList<String>(aux.size());
		for (int i = 0; i < aux.size(); i++) {
			prodStr.add(aux.get(i).toString());
		}
		
		try {
			outToClient.writeObject(prodStr);
		} catch (IOException e) {
			System.out.println("Erro ao enviar os produtos");
			e.printStackTrace();
		}
	}
	
	public String ReceiveObject()	{
		String ret = "";
		try {
			ret = (String) inFromClient.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Erro ao receber um objeto no ServerThread");
			e.printStackTrace();
		}
		System.out.println(ret);
		return ret;
	}

	public void sendObject(String command){
		try {
			outToClient.writeObject(command);
		} catch (IOException e) {
			System.out.println("Erro ao enviar objeto no ServerThread");
			e.printStackTrace();
		}
	}
	
	public void CloseConnection() 	{
		try {
			_client.close();
		} catch (IOException e) {
			System.out.println("Erro ao fechar conexao/socket");
			e.printStackTrace();
		}
	}
	
	
	public void run()
	{
		System.out.println("Nova conexao com o cliente " + this._client.getInetAddress().getHostAddress());
		String bruteCommand = "";
		try {
			while((bruteCommand = ReceiveObject()) != null){
				int wtc = -1000;
				String[] detailCommand = bruteCommand.split(",");
				if(detailCommand[0].equals("checkUser")){
					wtc = _control.checkUser(detailCommand[1],detailCommand[2]);
					outToClient.writeInt(wtc);
					
				}else if(detailCommand[0].equals("addUser")){
					wtc = _control.addUser(detailCommand[1], detailCommand[2],
							detailCommand[3], detailCommand[4], detailCommand[5],
							detailCommand[6]);
					outToClient.writeInt(wtc);
				}else if(detailCommand[0].equals("getAllProducts")){
					sendStorage();
				}else if(detailCommand.equals("makePurchase")){
					System.out.println("nao implementado!!!!!!");
				}
			}
		} catch (IOException e) {
			System.out.println("Erro no run do ServerThread");
			e.printStackTrace();
		}
			
	}
}
