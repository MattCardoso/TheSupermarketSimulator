package marketClient.controller;

import java.net.Socket;

import marketClient.model.ClientManager;


/**
 * Classe responsavel pela parte Controller da aplicacao do Cliente
 * 
 * @author 	Mateus Abrahao Cardoso
 * @nusp	8658332
 */
public class ClientController {
	private ClientManager _manager;
	
	public ClientController(Socket sock){
		 this._manager = new ClientManager(sock);
	}
	
	public int checkUser(String id, String pw){
		return _manager.checkUser( id,  pw);
	}
	
	public int addUser(String name, String address, String phone, 
			String email, String id, String pw){
		
		return _manager.addUser( name,  address,  phone, 
				 email,  id,  pw);
	}
	

	public String[] getProducts(){
		return _manager.getProducts();
	
	
	}

	public int makePurchase(String name, int prodID){
		return _manager.makePurchase(name, prodID);
	}
	
	
	
	
}
