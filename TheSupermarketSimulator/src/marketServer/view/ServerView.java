package marketServer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ServerView 
{
	@FXML
	TextField ServerProdName_TextField, ServerProdPrice_TextField, ServerProdBestBef_TextField, 
				ServerProdSuplier_TextField, ServerQuantity_TextField;
	
	@FXML
	Button ServerCadastrar_Button, ServerSaveQty_Button;
	
	@FXML
	ListView<?> ServerListStorage_ListView, ServerStorageProd_ListView, ServerSoldOutProd_ListView;
	
	@FXML
	private void initialize()
	{
		ServerCadastrar_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE CADASTRO");
			System.out.println(ServerProdName_TextField.getText() +" "+ ServerProdPrice_TextField.getText()
					+ " " + ServerProdSuplier_TextField.getText());
		});
		
		ServerSaveQty_Button.setOnAction((event) -> {
			System.out.println("OLAR, SOU O BOTÃO DE SALVAR QUANTIDADE");
		});
	}
	
}
