

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) throws ClassNotFoundException {

	
		/*
		 * Okay so, There should be one Server and two Clients
		 * Each Client will be either player 1 or player 2
		 * The server will be only the middle software who sends/receives
		 * coordinates. 
		 * 
		 * Each player has a screen and sends/receives the coordinates of their X,Y position
		 * And the coordinates of the ball will be located in the server
		 * The coordinates of each player will be located on each client machine
		 * 
		 * */
 
	 try{
		 	Socket sock = new Socket("localhost", 5550);

		 	ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
		 	ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
		

		 	System.out.println("Sending Messages to the Server...");
		 	System.out.println("Connecting to "+ sock.getInetAddress()+ " and port "+sock.getPort());
		 	System.out.println("Local Address :"+sock.getLocalAddress()+" Port:"+sock.getLocalPort());
		 	
		 	outstream.writeObject(new MessageObject(REQUEST_TYPE.START));
		 	 System.out.println("Client -> START");
		 	 
		 	MessageObject message = (MessageObject) instream.readObject();
		 	if(message.getREQUEST() == REQUEST_TYPE.WAITING) {
		 		System.out.println("Server -> WAITING");
		 		new Application(instream,outstream);
		 		
		 	}
		 	
			Runtime.getRuntime().addShutdownHook(new Thread() 
		    { 
		      public void run() 
		      { 
		    	  	try {
		    	  		outstream.writeObject(new MessageObject(REQUEST_TYPE.END));
		    	  		System.out.println("Client -> END");
						instream.close();
						outstream.close();
						sock.close();
						System.out.println("Connection Closing...");
		    	  	} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      } 
		    }); 

		 	
	 }
	 catch (IOException ex){
		 System.out.println("Connection Refused!!!");
		 
	 } 
	 
	 
	}
}
	