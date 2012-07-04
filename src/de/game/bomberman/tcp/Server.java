package de.game.bomberman.tcp;

import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    
    boolean ende = false;
    
    //InputStreamReader converter = new InputStreamReader(System.in);
    //BufferedReader in = new BufferedReader(converter);
    
    try {
      
      ServerSocket srvr = new ServerSocket(1234); //
      Socket skt = srvr.accept();
      System.out.println("Server Connected.\n");
      
      PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
      
      while (ende != true) {
        
        // out.print(in.readLine());
        out.print("Test");
        
      }
      
    }
    
    catch (Exception e) {
      System.out.print("Whoops! It didn't work!\n");
    }
    
  }
}