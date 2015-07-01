package marketServer;

import java.io.IOException;
import java.net.Socket;

public class ServerThread implements Runnable 
{
	private Socket _client;

	public ServerThread(Socket client)
	{	_client = client;	}

	public void run()
	{
		try
		{
			System.out.println("Nova conexao com o cliente " + this._client.getInetAddress().getHostAddress());
			this._client.close();
		} 
		catch(IOException ex) {}
	}
}
