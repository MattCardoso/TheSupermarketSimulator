/**
 * 
 */
package marketServer.model;

import java.util.ArrayList;

import marketProduct.Product;
import marketServer.csv.ReadCSV;

/**
 * @author Mateus
 *
 */

public class ProductManager {
	private ArrayList<Product> _products;
	
	
	public ProductManager(){
		this._products = ReadCSV.ReadCSVProducts();
	}
	
	public void  add(Product p){
		_products.add(p);
	}
	
	public void updateQuantity(String prodName, int newQntt){
		for (Product prod : _products) {
			if(prod.getName().equals(prodName))
				prod.setQuantity(newQntt);
			
		}
	}
	
	public ArrayList<Product> getProductList(){
		return this._products;
	}
	
	public Product getProduct(String pname){
		Product ret = null;
		for (Product prd : _products) {
			if(prd.getName().equals(pname))
				ret = prd;
		}
		return ret;
	}
	
	
}
