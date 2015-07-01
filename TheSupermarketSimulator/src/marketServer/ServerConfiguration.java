package marketServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import marketServer.controller.MarketController;

public class ServerConfiguration implements Runnable
{	
	static ArrayList<PrintStream> _psClients;
	static ServerSocket server;
	private MarketController _control;

	public ServerConfiguration(MarketController ctrl){
		_psClients = new ArrayList<PrintStream>();
		_control = ctrl;
		
	}
	
	public void CloseServer() throws IOException
	{
		server.close();
	}

	@Override
	public void run() {
		
		try {
			server = new ServerSocket(12345);
			System.out.println("Porta do servidor aberta em 12345!");
	
			while(true)	{
				Socket client = server.accept();
				System.out.println("Conexão aceita!!!");
				
				ServerThread st = new ServerThread(client, _control);
				
				Thread t = new Thread(st);
	
				t.start();
				
				_psClients.add(new PrintStream(client.getOutputStream()));
			}
		} catch (IOException e) {
			System.out.println("Erro ao criar conexoes");
			e.printStackTrace();
		}

	}
}
