package marketClient.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientView 
{
	@FXML	
	TextField ClientName_TextField, ClientAddress_TextField, ClientPhone_TextField, ClientMail_TextField, 
				ClientID_TextField, ClientPassword_TextField, ClientQuantity_TextField;
	
	@FXML
	Button ClientCadastrar_Button, ClientAddToCar_Button, ClientOrder_Button, ClientListProducts_Button;
	
	@FXML
	TextArea ClientItensToBy_TextArea, ClientItensAdded_TextArea;
	
	@FXML
	ListView<?> ClientListProducts_ListView;
	
	@FXML
	private void initialize()
	{
		ClientCadastrar_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE CADASTRO");
		});
		
		ClientAddToCar_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE ADICIONAR AO CARRINHO");
		});
		
		ClientOrder_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE FINALIZAR COMPRA");
		});
		
		ClientListProducts_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE LISTAR PRODUTOS");
		});
	}
	
}
