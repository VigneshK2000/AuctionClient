package auctionclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import client.Message;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ClientAuctionView extends Application{
	
	private static String host = "127.0.0.1";
	private BufferedReader fromServer;
	private PrintWriter toServer;
	
    @FXML
    private AnchorPane main_pane;
    
    //FXML RadioButtons
    @FXML private RadioButton Item1_btn;
    @FXML private RadioButton Item2_btn;
    @FXML private RadioButton Item3_btn;
    @FXML private RadioButton Item4_btn;
    @FXML private RadioButton Item5_btn;

    //FXML Text
    @FXML private Text Items_text;
    @FXML private Text Description_text;
    @FXML private Text MinPrice_text;
    @FXML private Text Item1Price_text;
    @FXML private Text Item2Price_text;
    @FXML private Text Item3Price_text;
    @FXML private Text Item4Price_text;
    @FXML private Text Item5Price_text;
    @FXML private Text TimeRemaining_text;

    @FXML private TextArea EnterBid_area;

    @FXML private Button SubmitBit_btn;
    
    ToggleGroup group;


    @FXML
    void Item1Selected(ActionEvent event) {

    }

    @FXML
    void Item2Selected(ActionEvent event) {

    }

    @FXML
    void Item3Selected(ActionEvent event) {

    }

    @FXML
    void Item4Selected(ActionEvent event) {

    }

    @FXML
    void Item5Selected(ActionEvent event) {
    	
    	

    }
    
    @FXML
    void BidSubmitted(ActionEvent event) {
    	System.out.println("Submitted bid");
    	System.out.println(group.getSelectedToggle());
    	sendToServer(group.getSelectedToggle().toString() + "Entered bid amound: $" + EnterBid_area.getText());
    }
    
    @FXML
    public void initialize() {
    	
    	group = new ToggleGroup();
    	Item1_btn.setToggleGroup(group);
    	Item2_btn.setToggleGroup(group);
    	Item3_btn.setToggleGroup(group);
    	Item4_btn.setToggleGroup(group);
    	Item5_btn.setToggleGroup(group);
    	
    	try {
			setUpNetworking();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = null;
		try {
			//root = FXMLLoader.load(getClass().getResource("WorldLayout.fxml"));
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/auctionclient/AuctionGraphics.fxml"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}
    
	public void setUpNetworking() throws Exception {
	    @SuppressWarnings("resource")
	    Socket socket = new Socket(host, 4242);
	    System.out.println("Connecting to... " + socket);
	    fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    toServer = new PrintWriter(socket.getOutputStream());
//	    Thread readerThread = new Thread(new Runnable() {
//		      @Override
//		      public void run() {
//		        String input;
//		        try {
//		          while ((input = fromServer.readLine()) != null) {
//		            System.out.println("From server: " + input);
//		            processRequest(input);
//		          }
//		        } catch (Exception e) {
//		          e.printStackTrace();
//		        }
//		      }
//		    });
//		
//		    Thread writerThread = new Thread(new Runnable() {
//		      @Override
//		      public void run() {
//		        while (true) {
//		        	System.out.println("7");
//		          String input = consoleInput.nextLine();
//		          String[] variables = input.split(",");
//		          Message request = new Message(variables[0], variables[1], Integer.valueOf(variables[2]));
//		          GsonBuilder builder = new GsonBuilder();
//		          Gson gson = builder.create();
//		          sendToServer(gson.toJson(request));
//		        }
//		      }
//		    });
//		
//		    readerThread.start();
//		    writerThread.start();
	}
	
	public void sendToServer(String string) {
		
		toServer.println(string);
		toServer.flush();
		
	}
	
	  protected void processRequest(String input) {
		  System.out.println("Processing request");
	    return;
	  }

}
