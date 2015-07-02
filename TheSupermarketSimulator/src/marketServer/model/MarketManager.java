/**
 * 
 */
package marketServer.model;

import java.util.ArrayList;

import marketCommon.product.Product;
import marketCommon.user.User;
import marketServer.csv.ReadCSV;

/**
 * @author Mateus
 *
 */

public class MarketManager {
	private ArrayList<Product> 	_products;
	private ArrayList<User>		_users;
	
	
	
	public MarketManager(){
		this._products 	= ReadCSV.ReadCSVProducts();
		this._users 	= ReadCSV.ReadCSVUsers();
	}
	
	public synchronized void add(Product p)		{_products.add(p);}
	public synchronized void add(User u)		{_users.add(u);}
	
	public synchronized void updateQuantity(String prodName, int newQntt){
		for (Product prod : _products) 
			if(prod.getName().equals(prodName))
				prod.setQuantity(newQntt);
	}
	
	public synchronized ArrayList<Product> getProductList()	{return this._products;}
	public synchronized ArrayList<User> getUserList()		{return this._users;}
	
	
	public synchronized String[] getAllProducts(){
		String[] ret = new String[_products.size()];
		for (int i = 0 ; i < _products.size(); i++) {
			ret[i] = _products.get(i).toString();
		}
		return ret;
	}
	
	public synchronized Product getProduct(String pname){
		Product ret = null;
		for (Product prd : _products) 
			if(prd.getName().equals(pname))
				ret = prd;
		return ret;
	}
	
	public synchronized User getUser(String uname){
		User ret = null;
		for (User usr : _users) {
			if(usr.getName().equals(uname))
				ret = usr;
		}
		return ret;
	}
	
	
}
