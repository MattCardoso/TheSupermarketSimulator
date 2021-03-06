package marketClient.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import javafx.beans.value.ChangeListener;
import marketClient.controller.ClientController;
import marketServer.controller.MarketController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientView 
{
	@FXML	
	TextField ClientName_TextField, ClientAddress_TextField, ClientPhone_TextField, ClientMail_TextField, 
				ClientID_TextField, ClientPassword_TextField, ClientQuantity_TextField, ClientUserLogin_TextField, 
				ClientPasswordLogin_TextField, ClientIP_TextField, ClientPort_TextField;
	
	@FXML
	Button ClientCadastrar_Button, ClientAddToCar_Button, ClientOrder_Button, ClientListProducts_Button, 
			ClientLogin_Button;
	
	@FXML
	TextArea ClientItensToBy_TextArea, ClientItensAdded_TextArea;
	
	@FXML
	ListView<?> ClientListProducts_ListView;
	
	@FXML
	Tab ClientCadastro_Tab, ClientBuyProd_Tab, ClientListProd_Tab, ClientLogin_Tab;
	
	ClientController _control;
	
	@FXML
	private void initialize()
	{
		
		
		
		ClientCadastro_Tab.setDisable(true);
		ClientBuyProd_Tab.setDisable(true);
		ClientListProd_Tab.setDisable(true);
		ClientLogin_Tab.setDisable(false);
		
		ClientItensToBy_TextArea.setEditable(false);
	//	ClientItensAdded_TextArea.setEditable(false);

	//	ClientController ctrl = new ClientController(MainClient.conexao);
//		int ProtocolMessage = -1000;

		ClientCadastrar_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE CADASTRO");
			int ret = 100000;
	//		ret = ctrl.addUser(ClientName_TextField.getText(), ClientAddress_TextField.getText(),
		//			ClientPhone_TextField.getText(),ClientMail_TextField.getText(),
			//				ClientID_TextField.getText(), ClientPassword_TextField.getText());
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
		
		ClientLogin_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE LOGIN");
//			String user = ClientID_TextField.getText();
//			String pw = ClientPassword_TextField.getText();
//			MainClient.host = ClientIP_TextField.getText();
//			MainClient.port = ClientPort_TextField.getText();
//			int resp =-19000;
//			try {
//				MainClient.conexao = new Socket(MainClient.host, Integer.parseInt(MainClient.port));
//				MainClient.inFromServer = new ObjectInputStream(MainClient.conexao.getInputStream());
//				MainClient.outToServer = new ObjectOutputStream(MainClient.conexao.getOutputStream());
//				this._control = new ClientController(MainClient.conexao);
//			} catch (IOException e) {
//				System.out.println("Erro ao conectar com o servidor");
//				e.printStackTrace();
//			}
//			resp = _control.checkUser(user, pw);
//			System.out.println(resp + "PORRRRAAAAAAAAAAAAAAA");
			//Se o login for bem sucedido
			ClientCadastro_Tab.setDisable(false);
			ClientBuyProd_Tab.setDisable(false);
			ClientListProd_Tab.setDisable(false);
			ClientLogin_Tab.setDisable(true);
		});
		
		//ClientItensAdded_TextArea.setText("Sabrina");
		
	/*	ClientItensAdded_TextArea.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
		        // this will run whenever text is changed
		    }
		});
			
			
			
			
			if(ClientItensAdded_TextArea.getText() != "")
				ClientItensAdded_TextArea.setDisable(true);
			else
				ClientItensAdded_TextArea.setDisable(false);
		});*/
	}
	
}
