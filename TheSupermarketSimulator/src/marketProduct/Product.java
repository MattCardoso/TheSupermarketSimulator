package marketProduct;

public class Product {
	private String _name;
	private int _price;
	private String _provider;
	private String _cbb; // consume best before -> validade;
//	private int _quantity;
	
	// Construtor usado para criar produtos atraves do arquivo .csv 
	public Product(String csv){
		String[] values = csv.split(",");
		this._name = values[0];
		this._price = Integer.parseInt(values[1]);
		this._provider = values[2];
		this._cbb = values[3];
	}
	
	
	public String toString(){
		return "" + _name + "," + _price + "," + _provider + "," + _cbb; // + "," _quantity; 
	}
}
