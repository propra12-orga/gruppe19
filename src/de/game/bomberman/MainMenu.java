package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
/**
 * ??????????????????????????????????????????????????????????????????????????????????????
 *
 */
public class MainMenu extends BasicGameState {
 
   //Die stateID fuer das Menu
    int stateID = 0; 
    
    Image background = null;
    Image tutorial = null;
    Image Singleplayer = null;
    Image startGamestaticMap = null;
    Image startGamerandomMap = null;
    Image startGameNetwork = null;
    Image options = null;
    Image exitOption = null;
    
   // Position der Auswahlmoeglichkeiten (Start und Ende) im Menü - X Pixel nach rechts
    float menuX = 310;
   // und Y Pixel nach unten 
    float menuY = 250; 
 
    
    /**
     * @param stateID
     */
    MainMenu( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    
    /* 
     * @see org.newdawn.slick.state.BasicGameState#getID()
     */
    @Override
    public int getID() {
        return stateID;
    }
 
    /* 
     * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
     */
    public void init(GameContainer container, StateBasedGame sb) throws SlickException {
        
        // Menu-Bild laden und Auswahlbild deklarieren + laden
        
        background = new Image("res/menubackground.jpg");
     // Ein Bild fuer sechs Auswahlmoeglichkeiten
        Image menuOptions = new Image("res/ButtonImage2.png");
     
     // menuOptions.getSubImage(x, y, width, height)
        tutorial           = menuOptions.getSubImage(0, 5, 275, 350);  // Tutorial Option aus Auswahlbild laden
        
        Singleplayer       = menuOptions.getSubImage(0, 55, 275, 350);  // Singleplayer Option aus Auswahlbild laden
        
        startGamestaticMap = menuOptions.getSubImage(0, 102, 275, 350);  // Start-Static Option aus Auswahlbild laden
        
        startGamerandomMap = menuOptions.getSubImage(0, 151, 275, 350); // Start-Random Option aus Auswahlbild laden
        
        startGameNetwork   = menuOptions.getSubImage(0, 198, 275, 350); // Netzwerk Option aus Auswahlbild laden
        
        options            = menuOptions.getSubImage(0, 245, 275, 350); // Option aus Auswahlbild laden 
         
        exitOption         = menuOptions.getSubImage(0, 295, 275, 350); // Ende-Option aus Auswahbild laden
    }
 
    /* 
     * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    public void render(GameContainer container, StateBasedGame sb, Graphics gc1) throws SlickException {
        // Hintergrund rendern und Variablen für die Auswahl deklarieren
        background.draw(0, 0);
        
        // Auswahl-Bilder in die richtigen Positionen legen
        tutorial.draw(menuX, menuY+5);
        Singleplayer.draw(menuX, menuY+55);
        startGamestaticMap.draw(menuX, menuY+102); 
        startGamerandomMap.draw(menuX, menuY+151);
        startGameNetwork.draw(menuX, menuY+198);
        options.draw(menuX, menuY+245);
        exitOption.draw(menuX, menuY+295);
    }
 
    /* 
     * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
     */
    public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
 

Input input = container.getInput();
 
int mouseX = input.getMouseX();
int mouseY = input.getMouseY();
 
boolean insideTutorial = false;
boolean insideSingleplayer = false;
boolean insideStartStaticGame = false;
boolean insideStartRandomGame = false;
boolean insideStartNetwork = false;
boolean insideOption = false;
boolean insideExit = false;
 
// Zeige der Maus, wo Start bzw. Ende Auswahl liegen

if( ( mouseX >= menuX && mouseX <= menuX + 143) &&
    ( mouseY >= menuY+5 && mouseY <= menuY+40 ) )
    {insideTutorial = true; }
else if( ( mouseX >= menuX && mouseX <= menuX+ 250) &&
    ( mouseY >= menuY+55 && mouseY <= menuY+95 ) )
    {insideSingleplayer = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 113) &&
    ( mouseY >= menuY+101 && mouseY <= menuY+135 ) )
    {insideStartStaticGame = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 163) &&
    ( mouseY >= menuY+150 && mouseY <= menuY+183 ) )
    {insideStartRandomGame = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 168) &&
    ( mouseY >= menuY+198 && mouseY <= menuY+231 ) )
    {insideStartNetwork = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 151) &&
    ( mouseY >= menuY+245 && mouseY <= menuY+287 ) )
    {insideOption = true;}
else if( ( mouseX >= menuX && mouseX <= menuX+ 76) &&
    ( mouseY >= menuY+293 && mouseY <= menuY+326 ) )
    {insideExit = true;}



if(insideTutorial){
  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 1 gewechselt, das Tutorial startet
    
    sb.enterState(1);              
  }
}

if(insideSingleplayer){
  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 2 gewechselt, das eigentliche Spiel startet im Singleplayer
    
    sb.enterState(2);              
  }
}

if(insideStartStaticGame){
 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 3 gewechselt, das eigentliche Spiel startet mit statischer Map
    
    sb.enterState(3);              
  }
}

if(insideStartRandomGame){

 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 4 gewechselt, das eigentliche Spiel startet mit zufaelliger Map
    
    sb.enterState(4);  
  }
}

if(insideStartNetwork){

  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 5 gewechselt, der Netzwerkmodus startet
    
    sb.enterState(5);              
  }
}

if(insideOption){

  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
//bei Mausklick wird in den State 6 gewechselt, das Optionsmenue wird aufgerufen
    
    sb.enterState(6);              
  }
}
 
if(insideExit){
  
//bei Mausklick wird Spiel beendet
  
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
    container.exit();

}
        
    }
 
}