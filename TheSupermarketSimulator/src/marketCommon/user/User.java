package marketCommon.user;

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
		this.setName(values[0]);
		this.setAddress(values[1]);
		this.setPhone(values[2]);
		this.setEmail(values[3]);
		this.setID(values[4]);
		this.setPassword(values[5]);
	}

	public User(String name, String address, String phone, String email,
			String id, String pw) {
		this.setName(name);
		this.setAddress(address);
		this.setEmail(email);
		this.setPhone(phone);
		this.setID(id);
		this.setPassword(pw);
		
	}

	public String getName() 					{return _name;}
	public void setName(String _name)			{this._name = _name;}

	public String getAddress() 					{return _address;}
	public void setAddress(String _address) 	{this._address = _address;}
		
	public String getPhone() 					{return _phone;}
	public void setPhone(String _phone) 		{this._phone = _phone;}

	public String getEmail() 					{return _email;}
	public void setEmail(String _email) 		{this._email = _email;}

	public String getID() 						{return _id;}
	public void setID(String _id) 				{this._id = _id;}

	public String getPassword() 				{return _password;}
	public void setPassword(String _password) 	{this._password = _password;}
	
//	public String toString(){
//		return "" + _name + "," + _address + "," + _phone + "," + _email +
//				"," + _id + "," + _password; // + "," _quantity; 
//	}
	
}
