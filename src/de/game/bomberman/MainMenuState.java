package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class MainMenuState extends BasicGameState {
 
    int stateID = 0; // Die stateID fuer das Menu
    
    Image background = null;
    Image startGamestaticMap = null;
    Image startGamerandomMap = null;
    Image startGameNetwork = null;
    Image options = null;
    Image exitOption = null;
    
    float menuX = 320; // Position der Auswahlmöglichkeiten (Start und Ende) im Menü - X Pixel nach rechts...
    float menuY = 340; // und Y Pixel nach unten
 
    MainMenuState( int stateID ) 
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
        Image menuOptions = new Image("res/menuoptions.png"); // Ein Bild fuer funf Auswahlmoeglichkeiten
                         //  menuOptions.getSubImage(x, y, width, height)
        startGamestaticMap = menuOptions.getSubImage(0, 10, 200, 250);  // Start-Static Option aus Auswahlbild laden
        
        startGamerandomMap = menuOptions.getSubImage(0, 60, 200, 250); // Start-Random Option aus Auswahlbild laden
        
        startGameNetwork   = menuOptions.getSubImage(0, 110, 200, 250); // Netzwerk Option aus Auswahlbild laden
        
        options            = menuOptions.getSubImage(0, 160, 200, 250); // Option aus Auswahlbild laden 
         
        exitOption         = menuOptions.getSubImage(0, 210, 200, 250); // Ende-Option aus Auswahbild laden
    }
 
    public void render(GameContainer container, StateBasedGame sb, Graphics gc1) throws SlickException {
        // Hintergrund rendern und Variablen fuer die Auswahl deklarieren
        background.draw(0, 0);
        // Auswahl-Bilder in die richtigen Positionen legen
        startGamestaticMap.draw(menuX, menuY+10); 
        startGamerandomMap.draw(menuX, menuY+60);
        startGameNetwork.draw(menuX, menuY+110);
        options.draw(menuX, menuY+160);
        exitOption.draw(menuX, menuY+210);
        // Auswahl wird vergroessert, wenn Maus raufzeigt
    }
 
    public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
 

Input input = container.getInput();
 
int mouseX = input.getMouseX();
int mouseY = input.getMouseY();
 
boolean insideStartStaticGame = false;
boolean insideStartRandomGame = false;
boolean insideStartNetwork = false;
boolean insideOption = false;
boolean insideExit = false;
 
// Zeige der Maus, wo Start bzw. Ende Auswahl liegen

if( ( mouseX >= menuX && mouseX <= menuX + 120) &&
    ( mouseY >= menuY+10 && mouseY <= menuY+50 ) )
    {insideStartStaticGame = true; }
else if( ( mouseX >= menuX && mouseX <= menuX+ 170) &&
    ( mouseY >= menuY+55 && mouseY <= menuY+95 ) )
    {insideStartRandomGame = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 170) &&
    ( mouseY >= menuY+100 && mouseY <= menuY+140 ) )
    {insideStartNetwork = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 160) &&
    ( mouseY >= menuY+145 && mouseY <= menuY+195 ) )
    {insideOption = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 88) &&
          ( mouseY >= menuY+190 && mouseY <= menuY+240 ) ){
    insideExit = true;
}

// Mausklick fuehrt zur Ausfuehrung von Start bzw. Ende
// !!! Zur Zeit schließt das Fenster auch dann, wenn man auf keine der beiden Optionen klickt !!!

if(insideStartStaticGame){
 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 1 gewechselt, das eigentliche Spiel startet mit statischer Map
    
    sb.enterState(1);              
  }
}

if(insideStartRandomGame){

 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 2 gewechselt, das eigentliche Spiel startet mit zufaelliger Map
    
    sb.enterState(1);              
  }
}

if(insideStartNetwork){

  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 3 gewechselt, der Netzwerkmodus startet
    
    sb.enterState(1);              
  }
}

if(insideOption){

  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 4 gewechselt, das Optionsmenue wird aufgerufen
    
    sb.enterState(1);              
  }
}
 
if(insideExit)
{
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
    container.exit();

}
        
    }
 
}