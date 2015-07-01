package marketClient.view;

import marketClient.controller.ClientController;
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
		ClientController ctrl = new ClientController(MainClient.conexao);
		int ProtocolMessage = -1000;
		ClientCadastrar_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE CADASTRO");
			int ret = 100000;
			ret = ctrl.addUser(ClientName_TextField.getText(), ClientAddress_TextField.getText(),
					ClientPhone_TextField.getText(),ClientMail_TextField.getText(),
							ClientID_TextField.getText(), ClientPassword_TextField.getText());
			System.out.println("Erro: "+ ret);
			
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
