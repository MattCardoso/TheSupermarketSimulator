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
	
	public void add(Product p)	{_products.add(p);}
	public void add(User u)		{_users.add(u);}
	
	public void updateQuantity(String prodName, int newQntt){
		for (Product prod : _products) 
			if(prod.getName().equals(prodName))
				prod.setQuantity(newQntt);
	}
	
	public ArrayList<Product> getProductList()	{return this._products;}
	public ArrayList<User> getUserList()		{return this._users;}
	
	
	public Product getProduct(String pname){
		Product ret = null;
		for (Product prd : _products) 
			if(prd.getName().equals(pname))
				ret = prd;
		return ret;
	}
	
	public User getUser(String uname){
		User ret = null;
		for (User usr : _users) {
			if(usr.getName().equals(uname))
				ret = usr;
		}
		return ret;
	}
	
	
}
