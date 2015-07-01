package marketServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConfiguration
{	
	static ArrayList<PrintStream> _psClients;
	static ServerSocket server;

	public static void main(String[] args) throws IOException
	{
		server = new ServerSocket(12345);
		System.out.println("Porta do servidor aberta em 12345!");

		while(true)
		{
			Socket client = server.accept();
			System.out.println("Conexão aceita!!!");
			
			ServerThread st = new ServerThread(client);
			
			Thread t = new Thread(st);

			t.start();
		}
	}
	
	public void CloseServer() throws IOException
	{
		server.close();
	}
}
