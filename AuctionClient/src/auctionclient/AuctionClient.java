package auctionclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


import javafx.application.Application;


@SuppressWarnings("restriction")
public class AuctionClient {
	
	private static String host = "127.0.0.1";
	private BufferedReader fromServer;
	private PrintWriter toServer;
	//private Scanner consoleInput = new Scanner(System.in);
	
	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		
	    try {
		      //new AuctionClient().setUpNetworking();
		      //Application.launch(ClientGraphics.class, args);
		      Application.launch(ClientAuctionView.class, args);
		      //new LaunchAuctionGUI(args);
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
//	public void setUpNetworking() throws Exception {
//	    @SuppressWarnings("resource")
//	    Socket socket = new Socket(host, 4242);
//	    System.out.println("Connecting to... " + socket);
//	    fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//	    toServer = new PrintWriter(socket.getOutputStream());
//	}
//	
//	public void sendToServer(String string) {
//		
//		toServer.println(string);
//		toServer.flush();
//		
//	}

}
