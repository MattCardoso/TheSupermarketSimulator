package marketServer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class marketServerController 
{
	@FXML
	TextField ServerProdName_TextField, ServerProdPrice_TextField, ServerProdBestBef_TextField, 
				ServerProdSuplier_TextField, ServerQuantity_TextField;
	
	@FXML
	Button ServerCadastrar_Button, ServerSaveQty_Button;
	
	@FXML
	ListView<?> ServerListStorage_ListView, ServerStorageProd_ListView, ServerSoldOutProd_ListView;
	
}
