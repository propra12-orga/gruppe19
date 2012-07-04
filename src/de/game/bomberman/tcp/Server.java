package de.game.bomberman.tcp;

import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    
    
    
    InputStreamReader converter = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(converter);
    
    try {
      
      //erzeugt einen ServerSocket überm Port 1234, der 15 Sek. auf einer Verbindung wartet
      ServerSocket srvr = new ServerSocket(1234);
      srvr.setSoTimeout(15000); 
      Socket skt = srvr.accept();
      
       while(!skt.isClosed()) 
         skt = srvr.accept();
        
      
      
      System.out.println("Server Connected.\n");
      
      PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
      
     // while (true) {
        
        //out.print(in.readLine());
        out.print(System.in.read());
        
       
        out.close();
        in.close();
        srvr.close();
        
        
        
        
      
        
        
    //  }
      
    }
    
    catch (Exception e) {
      System.out.print("Whoops! It didn't work!\n");
    }
    
  }
}
