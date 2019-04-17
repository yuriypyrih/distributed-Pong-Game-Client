

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) throws ClassNotFoundException {

	
 
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
	