package marketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientThread implements Runnable
{
	private ObjectInputStream inFromServer;
	private static Socket socketServer;
	private ObjectOutputStream outToServer; 
	
	public ClientThread(Socket client) throws UnknownHostException, IOException
	{
		socketServer = client;
        inFromServer = new ObjectInputStream(socketServer.getInputStream());
        outToServer = new ObjectOutputStream(socketServer.getOutputStream());
	}

	public void run()
	{
		System.out.println("Conexão bem sucedida!");
	}
	
	public void CloseConnection() throws IOException
	{
		socketServer.close();
	}
	
	public void PrintStorageList() throws ClassNotFoundException, IOException
	{
		ArrayList<String> ls = new ArrayList<String>();
		ls = (ArrayList<String>) inFromServer.readObject();
		
		for(String a : ls)
			System.out.println(a);
	}
	
	public void SendObject() throws IOException
	{
		outToServer.writeObject("Sabrina, it works!!");
	}

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException
	{
		Socket Server = new Socket("127.0.0.1", 12345);
		ClientThread c = new ClientThread(Server);
		
        Thread t = new Thread(c);
        t.start();
        
        c.SendObject();
        c.CloseConnection();
	}
}