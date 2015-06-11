package marketUser;

public class User {
	private String _name;
	private String _address;
	private String _phone;
	private String _email;
	private String _id;
	private String _password;
	
	// Contrutor usado para criar os usuários atraves do arquivo .csv
	public User(String csv){
		String[] values = csv.split(",");
		this._name = values[0];
		this._address = values[1];
		this._phone = values[2];
		this._email = values[3];
		this._id = values[4];
		this._password = values[5];
	}
	
	public String toString(){
		return "" + _name + "," + _address + "," + _phone + "," + _email +
				"," + _id + "," + _password; // + "," _quantity; 
	}
	
}
