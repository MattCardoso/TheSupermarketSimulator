package marketServer.csv;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import marketProduct.Product;
import marketUser.User;

public class WriteCSV {

	//The comma that separates data in CSV.
	//private static final String COMMA_DELIMITER = ",";
	

	
	public static void WriteCSVUsers(ArrayList<User> list)
	{
		try
		{
			FileWriter fw = new FileWriter("src/marketCSV/data/marketUsers.csv");
			for(User us : list)
			{
				fw.append(us.toString());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}


	public static void WriteCSVProducts(ArrayList<Product> list)
	{
		try
		{
			FileWriter fw = new FileWriter("src/marketCSV/data/marketProducts.csv");
			for(Product pr : list)
			{
				fw.append(pr.toString());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}

}