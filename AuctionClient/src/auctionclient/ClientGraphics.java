package auctionclient;

//import com.gluonhq.charm.glisten.control.TextField;
//import javafx.scene.control.TextField;
//import java.awt.event.ActionEvent;
import java.io.IOException;


//import org.omg.CORBA.INITIALIZE;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClientGraphics extends Application{
	
		@FXML
	    private AnchorPane main_pane;

	    @FXML
	    private Text welcome_text;

	    @FXML
	    private Text username_text;

	    @FXML
	    private TextArea username_input_text;

	    @FXML
	    private Button submit_info;

	    @FXML
	    public void submit_info_pressed() {
	    	String username;
	    	System.out.println("Pressed button!");
	    	System.out.println("Welcome " + username_input_text.getText());
	    	username = username_input_text.getText();

	    	Platform.exit();
	    }

		@Override
		public void start(Stage primaryStage) throws Exception {
			AnchorPane root = null;
			try {
				//root = FXMLLoader.load(getClass().getResource("WorldLayout.fxml"));
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/auctionclient/LoginGraphics.fxml"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
		}

}
