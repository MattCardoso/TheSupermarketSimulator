package marketServer.controller;

import java.util.ArrayList;

import marketCommon.Constants;
import marketCommon.Product;
import marketCommon.User;
import marketServer.model.MarketManager;

/**
 * @author 	Mateus Abrahao Cardoso
 * @nusp	8658332
 */
public class MarketController {
	
	private MarketManager _manager;
	
	public MarketController(){
		this._manager = new MarketManager();
	}
	
	public int checkUser(String user, String pw){
		int ret = Constants.SUCCESS;
		return ret;
	}

	public int addUser(String name, String address, String phone, String email, String id, String pw){
		int ret = Constants.SUCCESS;
		if(_manager.getUserList().stream().anyMatch(p -> p.getID().equals(id)))
			ret = Constants.ERROR_SAME_ID;
		else if(_manager.getUserList().stream().anyMatch(u -> u.getEmail().equals(email)))
			ret = Constants.ERROR_SAME_EMAIL;
		else
			_manager.add(new User(name,address,phone,email,id,pw));
		
		return ret;
	}
	
	public int addProduct(String name, int price, String provider, String cbb, int qntt){
		int ret = Constants.SUCCESS;
		
		if(_manager.getProductList().stream().anyMatch(p -> p.getName().equals(name)))
			ret = Constants.ERROR_SAME_NAME;
		else
			_manager.add(new Product(name, price, provider, cbb, qntt));
		
		return ret;
	}
	
	
	public ArrayList<Product> getAllProductList(){
		return _manager.getProductList();
	}
	
}
