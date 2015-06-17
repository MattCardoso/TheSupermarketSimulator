package marketClient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class marketClientController 
{
	@FXML		//Componentes do Client
	TextField ClientName_TextField, ClientAddress_TextField, ClientPhone_TextField, ClientMail_TextField, 
				ClientID_TextField, ClientPassword_TextField, ClientQuantity_TextField;
	
	@FXML
	Button ClientCadastrar_Button, ClientAddToCar_Button, ClientOrder_Button, ClientListProducts_Button;
	
	@FXML
	TextArea ClientItensToBy_TextArea, ClientItensAdded_TextArea;
	
	@FXML
	ListView<?> ClientListProducts_ListView;
	
}
