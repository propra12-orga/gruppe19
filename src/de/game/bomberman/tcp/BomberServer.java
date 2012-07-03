package de.game.bomberman.tcp;
import java.io.*;
import java.net.*;


public class BomberServer {

  public static void main(String[] args) throws IOException {

      ServerSocket serverSocket = null;

      boolean listeningSocket = true;
      try {
          serverSocket = new ServerSocket(2343);
      } catch (IOException e) {
          System.err.println("Could not listen on port: 2343");
      } 

      while(listeningSocket){
          Socket clientSocket = serverSocket.accept();
          NewThread mini = new NewThread(clientSocket);
          mini.start();
      }
      serverSocket.close();       
  }

}
