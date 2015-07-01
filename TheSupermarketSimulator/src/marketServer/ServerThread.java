package marketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable 
{
	private Socket _client;
	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;

	public ServerThread(Socket client) throws IOException
	{	
		_client = client;	
		outToClient = new ObjectOutputStream(_client.getOutputStream());	
		inFromClient = new ObjectInputStream(_client.getInputStream());
	}
	
	public void StorageList() throws IOException
	{
		ArrayList<String> ls = new ArrayList<String>();
		ls.add("Sabrina");
		ls.add("Faceroli");
		ls.add("Tridico");
		
		outToClient.writeObject(ls);
	}
	
	public void ReceiveObject() throws ClassNotFoundException, IOException
	{
		String a = (String) inFromClient.readObject();
		System.out.println(a);
	}

	public void CloseConnection() throws IOException
	{
		_client.close();
	}
	
	public void run()
	{
		try
		{
			System.out.println("Nova conexao com o cliente " + this._client.getInetAddress().getHostAddress());
			ReceiveObject();
			CloseConnection();
		} 
		catch(IOException ex) {} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
