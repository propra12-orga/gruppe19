package de.game.bomberman.tcp;

import java.io.*;
import java.net.*;

public class BomberClient {
    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;
      while(true){
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 2343);

        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Ready");
        sentence = in.readLine();
        out.writeBytes(sentence + '\n');
        modifiedSentence = in.readLine();
        System.out.println(modifiedSentence);
         
        clientSocket.close();
       }
      
    }
}
