package de.game.bomberman.tcp;

import java.io.*;
import java.net.*;

class Client {
  public static void main(String args[]) {
    try {
      
      //versucht, sich  mitm Serversocket auf der IP-Adresse 127.0.0.1 per Port 1234 zu connecten
      Socket skt = new Socket("127.0.0.1", 1234);
      
      //Input-Stream wird hier bereitgestellt
      BufferedReader in = new BufferedReader(new InputStreamReader(
          skt.getInputStream()));
      
      while(in.readLine() != "bye"){
      //Wenn er sich erfolgreich connecten konnte, wird sofort dieser Text ausgegeben
      System.out.print("Received string: '");
      
      
        //Wenn Buffered-Reader nicht bereit ist, wird vom Client aus nichts gemacht...
        while (!in.ready()) {
        }
        
        System.out.println(in.readLine()); // Read one line and output it
        
        System.out.print("'\n");
        
        in.close();
        
      
      }
    } catch (Exception e) {
      System.out.print("Whoops! It didn't work!\n");
    }
  }
}