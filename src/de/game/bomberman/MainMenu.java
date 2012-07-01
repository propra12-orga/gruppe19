package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class MainMenu extends BasicGameState {
 
    int stateID = 0; // Die stateID fuer das Menu
    
    Image background = null;
    Image tutorial = null;
    Image startGamestaticMap = null;
    Image startGamerandomMap = null;
    Image startGameNetwork = null;
    Image options = null;
    Image exitOption = null;
    
    float menuX = 320; // Position der Auswahlmöglichkeiten (Start und Ende) im Menü - X Pixel nach rechts...
    float menuY = 290; // und Y Pixel nach unten
 
    MainMenu( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    public void init(GameContainer container, StateBasedGame sb) throws SlickException {
        
        // Menu-Bild laden und Auswahlbild deklarieren + laden
        
        background = new Image("res/menubackground.jpg");
        Image menuOptions = new Image("res/menuoptions.png"); // Ein Bild fuer sechs Auswahlmoeglichkeiten
                         //  menuOptions.getSubImage(x, y, width, height)
        tutorial           = menuOptions.getSubImage(0, 5, 200, 300);  //Tutorial Option aus Auswahlbild laden
        
        startGamestaticMap = menuOptions.getSubImage(0, 55, 200, 300);  // Start-Static Option aus Auswahlbild laden
        
        startGamerandomMap = menuOptions.getSubImage(0, 95, 200, 300); // Start-Random Option aus Auswahlbild laden
        
        startGameNetwork   = menuOptions.getSubImage(0, 145, 200, 300); // Netzwerk Option aus Auswahlbild laden
        
        options            = menuOptions.getSubImage(0, 195, 200, 300); // Option aus Auswahlbild laden 
         
        exitOption         = menuOptions.getSubImage(0, 245, 200, 300); // Ende-Option aus Auswahbild laden
    }
 
    public void render(GameContainer container, StateBasedGame sb, Graphics gc1) throws SlickException {
        // Hintergrund rendern und Variablen für die Auswahl deklarieren
        background.draw(0, 0);
        // Auswahl-Bilder in die richtigen Positionen legen
        tutorial.draw(menuX, menuY+5);
        startGamestaticMap.draw(menuX, menuY+55); 
        startGamerandomMap.draw(menuX, menuY+95);
        startGameNetwork.draw(menuX, menuY+145);
        options.draw(menuX, menuY+195);
        exitOption.draw(menuX, menuY+245);
    }
 
    public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
 

Input input = container.getInput();
 
int mouseX = input.getMouseX();
int mouseY = input.getMouseY();
 
boolean insideTutorial = false;
boolean insideStartStaticGame = false;
boolean insideStartRandomGame = false;
boolean insideStartNetwork = false;
boolean insideOption = false;
boolean insideExit = false;
 
// Zeige der Maus, wo Start bzw. Ende Auswahl liegen

if( ( mouseX >= menuX && mouseX <= menuX + 153) &&
    ( mouseY >= menuY+5 && mouseY <= menuY+40 ) )
    {insideTutorial = true; }
else if( ( mouseX >= menuX && mouseX <= menuX+ 120) &&
    ( mouseY >= menuY+60 && mouseY <= menuY+90 ) )
    {insideStartStaticGame = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 170) &&
    ( mouseY >= menuY+115 && mouseY <= menuY+140 ) )
    {insideStartRandomGame = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 170) &&
    ( mouseY >= menuY+160 && mouseY <= menuY+190 ) )
    {insideStartNetwork = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 160) &&
    ( mouseY >= menuY+205 && mouseY <= menuY+240 ) )
    {insideOption = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 88) &&
    ( mouseY >= menuY+250 && mouseY <= menuY+290 ) )
    {insideExit = true;}

// Mausklick führt zur Ausführung von Start bzw. Ende
// !!! Zur Zeit schließt das Fenster auch dann, wenn man auf keine der beiden Optionen klickt !!!


if(insideTutorial){
  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 1 gewechselt, das Tutorial startet
    
    sb.enterState(1);              
  }
}

if(insideStartStaticGame){
 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 2 gewechselt, das eigentliche Spiel startet mit statischer Map
    
    sb.enterState(2);              
  }
}

if(insideStartRandomGame){

 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 3 gewechselt, das eigentliche Spiel startet mit zufaelliger Map
    
    sb.enterState(3);  
  }
}

if(insideStartNetwork){

  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 4 gewechselt, der Netzwerkmodus startet
    
    sb.enterState(4);              
  }
}

if(insideOption){

  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 5 gewechselt, das Optionsmenue wird aufgerufen
    
    sb.enterState(5);              
  }
}
 
if(insideExit){
  
//bei Mausklick wird Spiel beendet
  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
    container.exit();

}
        
    }
 
}