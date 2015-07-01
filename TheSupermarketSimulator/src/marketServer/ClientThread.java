package marketServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread implements Runnable
{
	private Socket _client;
	
	public ClientThread(Socket client)
	{
		_client = client;
	}

	public void run()
	{
		System.out.println("Conexão bem sucedida!");

		try
		{	this._client.close();	} 
		catch(IOException ex) {}
		
	}

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket socket = new Socket("127.0.0.1", 12345);

		ClientThread c = new ClientThread(socket);
        Thread t = new Thread(c);
        t.start();
	}
}