package marketServer.csv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;




import marketCommon.product.Product;
import marketCommon.user.User;



public class ReadCSV {

	public static ArrayList<User> ReadCSVUsers()
	{
		ArrayList<User> list = new ArrayList<User>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/marketServer/csv/data/marketUsers.csv"));
	        String data;
	        while((data = br.readLine()) != null) 
	            list.add(new User(data));
	        
	        br.close();
		}
		catch(IOException ex){}
		
		return list;
	}
	

	
	public static ArrayList<Product> ReadCSVProducts()
	{
		ArrayList<Product> list = new ArrayList<Product>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/marketServer/csv/data/marketProducts.csv"));
	        String data;
	        while((data = br.readLine()) != null)
	           	list.add(new Product(data));
	        
	        br.close();
		}
		catch(IOException ex){ex.printStackTrace();}
		
		return list;
	}

}
