package marketServer.mail;

//import java.util.ArrayList;

public class ServerMail {
	// 	classe para enviar os emails dos clientes
	//	
	private String _toClient;
	private String _sender;
	private final String _fromPassword;
	
	public ServerMail(String to, String password){
		this._fromPassword = password;
		this._toClient = to;
	}
	
	// classe para montar os emails dos clientes 
	private String mountMessage( String products){
		
		String email = "Prezado Sr. "+ _toClient +", \nGostariamos de informar que os itens a seguir "
				+ "já estão disponiveis: \n"; 
//		for (String str : products) {
//			email += str + "\n";
//		}
		return email;
	}
	
	public String toString(){
		String ret = "string do mauntMessage" +_fromPassword +"," + _sender + "," + mountMessage("asdad");
		
		return ret;
	}
	
}
 