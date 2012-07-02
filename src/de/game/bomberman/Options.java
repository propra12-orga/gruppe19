package de.game.bomberman;

//Diese Klasse enthaelt das Optionsmenu

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Options extends BasicGameState {
  
  int stateID = 5;
  
  Image background = null;
  Image Fullscreen = null;
  Image Windowed = null;
  Image Music = null;
  Image ON = null;
  Image OFF = null;
  Image Keyboard = null;
  Image Back = null;
  
  float menuX = 310; // Position der Auswahlmöglichkeiten (Start und Ende) im Menü - X Pixel nach rechts...
  float menuY = 340; // und Y Pixel nach unten

//KONSTRUKTOR:
  
 public Options(int stateID) {
   this.stateID = stateID;
 }
 
 public int getID() {
     return stateID;
 }
 


  public void init(GameContainer container, StateBasedGame sb) throws SlickException {
    
    // Menu-Bild laden und Auswahlbild deklarieren + laden
    
    background = new Image("res/menubackground.jpg");
    Image menuOptions = new Image("res/Options.png"); // Ein Bild fuer mehrere Auswahlmoeglichkeiten
                     //  menuOptions.getSubImage(x, y, width, height)
    Fullscreen           = menuOptions.getSubImage(0, 5, 300, 250);  //Fullscreen Option aus Auswahlbild laden
    
    Windowed = menuOptions.getSubImage(0, 55, 300, 250);  // Windowed Option aus Auswahlbild laden
    
    Music = menuOptions.getSubImage(0, 108, 300, 250); // Music Option aus Auswahlbild laden
    
    ON   = menuOptions.getSubImage(179, 108, 300, 250); // ON aus Auswahlbild laden
    
    OFF            = menuOptions.getSubImage(237, 108, 300, 250); // OFF aus Auswahlbild laden 
     
    Keyboard         = menuOptions.getSubImage(0, 151, 300, 250); // Keyboard aus Auswahbild laden
    
    Back         = menuOptions.getSubImage(0, 199, 300, 250); // Back aus Auswahbild laden
}
    

  public void render(GameContainer container, StateBasedGame sb, Graphics gc1) throws SlickException {
    // Hintergrund rendern und Variablen für die Auswahl deklarieren
    background.draw(0, 0);
    // Auswahl-Bilder in die richtigen Positionen legen
    Fullscreen.draw(menuX, menuY+5);
    Windowed.draw(menuX, menuY+55); 
    Music.draw(menuX, menuY+108);
    ON.draw(menuX+179, menuY+108);
    OFF.draw(menuX+237, menuY+108);
    Keyboard.draw(menuX, menuY+151);
    Back.draw(menuX, menuY+199);
}

  
  public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
    
    Input input = container.getInput();
     
    int mouseX = input.getMouseX();
    int mouseY = input.getMouseY();
     
    boolean insideFullscreen = false;
    boolean insideWindowed = false;
    boolean insideMusic = false;
    boolean insideON = false;
    boolean insideOFF = false;
    boolean insideKeyboard = false;  
    boolean insideBack = false;
    
    
      
    
    if( ( mouseX >= menuX && mouseX <= menuX + 200) &&
        ( mouseY >= menuY+5 && mouseY <= menuY+40 ) )
        {insideFullscreen = true; }
    else if( ( mouseX >= menuX && mouseX <= menuX+ 205) &&
        ( mouseY >= menuY+55 && mouseY <= menuY+85 ) )
        {insideWindowed = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 124) &&
        ( mouseY >= menuY+104 && mouseY <= menuY+134 ) )
        {insideMusic = true;}
    else if( ( mouseX >= menuX+138 && mouseX <= menuX+ 197) &&
        ( mouseY >= menuY+104 && mouseY <= menuY+134 ) )
        {insideON = true;}
    else if( ( mouseX >= menuX+213 && mouseX <= menuX+ 290) &&
        ( mouseY >= menuY+104 && mouseY <= menuY+134 ) )
        {insideOFF = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 186) &&
        ( mouseY >= menuY+150 && mouseY <= menuY+189 ) )
        {insideKeyboard = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 100) &&
        ( mouseY >= menuY+197 && mouseY <= menuY+230 ) )
        {insideBack = true;}
    
    
    if(insideFullscreen){            
        
        if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
          
        //bei Mausklick wird Spiel im Fullscreen Modus ausgefuehrt
         
          container.setFullscreen(true);
      }
    
    if(insideWindowed){
      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
        
      //bei Mausklick wird Spiel im  Fenstermodus ausgefuehrt
        
        container.setFullscreen(false);              
      }
    }

    if(insideMusic){

     
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
        
    //derzeit keine Funktion, nuetzlich wenn bei Klick auf "Music" was passieren soll
        
        ;  
      }
    }

    if(insideON){

      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
        
    //bei Mausklick wird die Musik auf Ein gestellt
        
       container.setMusicOn(true);
        
      }
    }

    if(insideOFF){

      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
        
      //bei Mausklick wird die Musik auf Aus gestellt
        
        container.setMusicOn(false);             
      }
    }
     
    if(insideKeyboard){
      
    
      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
        
      //bei Mausklick wird die Tastaturbelegung aufgerufen (ist in Arbeit)
        
        ;

    }
    
    if(insideBack){
      
      
        
        if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
          
        //bei Mausklick wieder ins Menu gewechselt
          
                
          sb.enterState(0);
          container.sleep(100); 
      }
    
     
   }
  
}  
