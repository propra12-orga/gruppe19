package de.game.bomberman.tcp;

import java.io.*;
import java.net.*;


public class NewThread extends Thread{

  private Socket socket = null;

  public NewThread(Socket socket) {

      super("NewThread");
      this.socket = socket;
 
  }

  public void run(){
          //Read input and process here
          
  }
          //implement your methods here

}
