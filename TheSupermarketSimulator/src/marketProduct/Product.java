package marketProduct;

public class Product {
	private String 	_name;
	private int 	_price;
	private String 	_provider;
	private String 	_cbb; // consume best before -> validade;
	private int 	_qntt; // quantity -> quantidade
//	private int _quantity;
	
	// Construtor usado para criar produtos atraves do arquivo .csv 
	public Product(String csv){
		String[] values = csv.split(",");
		this._name = values[0];
		this._price = Integer.parseInt(values[1]);
		this._provider = values[2];
		this._cbb = values[3];
		this._qntt = Integer.parseInt(values[4]);
	}
	
	
	
	
	public int getQuantity(){return this._qntt;}
	public void setQuantity(int qntt){ this._qntt = qntt;}
	
	public int getPrice(){return _price;}
	public void setPrice(int price){this._price = price;}
	
	public String getName(){return this._name;}
	public void setName(String name){this._name = name;}
	
	public String getProvider(){return this._provider;}
	public void setProvider(String provider){this._provider = provider;}
	
	public String getCbb(){return this._cbb;}
	public void setCbb(String date){this._cbb = date;}
	
	
	
	public String toString(){
		return "" + _name + "," + _price + "," + _provider + "," + _cbb + "," + _qntt; 
	}
}
