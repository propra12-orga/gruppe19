package stateBasedGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class MainMenuState extends BasicGameState {
 
    int stateID = 0; // Das is später die State ID, die das StateBasedGame benötigt
    
    Image background = null;
    Image startGameOption = null;
    Image exitOption = null;
    
    float menuX = 0; // Position der Auswahlmöglichkeiten (Start und Ende) im Menü
    float menuY = 400;
    float scaleStep = 0.0001f;
 
    float startGameScale = 1;
    float exitScale = 1;
 
    MainMenuState( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        // Menu-Bild laden und Auswahlbild deklarieren + laden
        
        background = new Image("res/menubackground.jpg");
        Image menuOptions = new Image("res/menuoptions.png"); // Zur Zeit ein Bild für Zwei Auswahlmöglichkeiten
         
        startGameOption = menuOptions.getSubImage(0, 0, 377, 71); // Start-Option aus Auswahlbilds laden
         
        exitOption = menuOptions.getSubImage(0, 71, 377, 71); // Ende-Option aus Auswahbild laden
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gc1) throws SlickException {
        // Hintergrund rendern und Variablen für die Auswahl deklarieren
        background.draw(0, 0);
        // Auswahl-Bilder in die richtigen Positionen legen
        startGameOption.draw(menuX, menuY, startGameScale); 
        exitOption.draw(menuX, menuY+80, exitScale);
        // Auswahl wird vergrößert, wenn Maus raufzeigt
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
 

Input input = gc.getInput();
 
int mouseX = input.getMouseX();
int mouseY = input.getMouseY();
 
boolean insideStartGame = false;
boolean insideExit = false;
 
// Zeige der Maus, wo Start bzw. Ende Auswahl liegen

if( ( mouseX >= menuX && mouseX <= menuX + startGameOption.getWidth()) &&
    ( mouseY >= menuY && mouseY <= menuY + startGameOption.getHeight()) ){
    insideStartGame = true;
}else if( ( mouseX >= menuX && mouseX <= menuX+ exitOption.getWidth()) &&
          ( mouseY >= menuY+80 && mouseY <= menuY+80 + exitOption.getHeight()) ){
    insideExit = true;
}

// Mausklick führt zur Ausführung von Start bzw. Ende
// !!! Zur Zeit schließt das Fenster auch dann, wenn man auf keine der beiden Optionen klickt !!!

if(insideStartGame){
  if(startGameScale < 1.05f)
    startGameScale += scaleStep * delta;
 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
/* 
 *    Hier fehlt ne enterState Methode aus nem StateBasedGame
 *    ??.enterState(Game.GAMEPLAYSTATE);
 */ 
  }
}else{
  if(startGameScale > 1.0f)
    startGameScale -= scaleStep * delta;
 
  if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
    gc.exit();
}
 
if(insideExit)
{
   if(exitScale < 1.05f)
     exitScale +=  scaleStep * delta;
}else{
  if(exitScale > 1.0f)
    exitScale -= scaleStep * delta;
}
        
    }
 
}