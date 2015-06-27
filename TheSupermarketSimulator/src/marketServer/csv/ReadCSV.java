package marketServer.csv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;


import marketProduct.Product;
import marketUser.User;



public class ReadCSV {

	public static ArrayList<User> ReadCSVBook()
	{
		ArrayList<User> list = new ArrayList<User>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/marketCSV/data/marketUsers.csv"));
	        String data;
	        while((data = br.readLine()) != null) 
	            list.add(new User(data));
	        
	        br.close();
		}
		catch(IOException ex){}
		
		return list;
	}
	

	
	public static ArrayList<Product> ReadCSVUsers()
	{
		ArrayList<Product> list = new ArrayList<Product>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/marketCSV/data/marketProducts.csv"));
	        String data;
	        while((data = br.readLine()) != null)
	           	list.add(new Product(data));
	        
	        br.close();
		}
		catch(IOException ex){ex.printStackTrace();}
		
		return list;
	}

}
