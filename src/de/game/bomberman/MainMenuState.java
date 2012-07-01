package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
/**
 * Die Klasse "MainMenuState" ist fuer das Hauptmenue zustaendig.
 * Hier wird die StateID fuer das Spiel gegeben und die Auswahlmoeglichkeiten 
 * "Spiel starten" sowie "Ende" im Menu gezeigt.
 * Außerdem erfolgt die Auswahl im Menu durch die Maus. Die Erkennung dieser 
 * wird in dieser Klasse geschrieben.
 */
public class MainMenuState extends BasicGameState {
    
   //Die stateID fuer das Menu
    int stateID = 0; 
    
    Image background = null;
    Image startGameOption = null;
    Image exitOption = null;
    
   // Position der Auswahlmöglichkeiten (Start und Ende) im Menü
    float menuX = 0; 
    float menuY = 400;
    float scaleStep = 0.0001f;
 
    float startGameScale = 1;
    float exitScale = 1;
 
    /**
     * Ist fuer die ID des State zustaendig.
     * MainMenuState wird ein Integer Wert gegeben.
     * @param stateID
     */
    MainMenuState( int stateID ) 
    {
       this.stateID = stateID;
    }
 
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
     
       // Ein Bild für Zwei Auswahlmöglichkeiten
        Image menuOptions = new Image("res/menuoptions.png");
         
       // Start-Option aus Auswahlbilds laden
        startGameOption = menuOptions.getSubImage(0, 0, 377, 71);
         
       // Ende-Option aus Auswahbild laden
        exitOption = menuOptions.getSubImage(0, 71, 377, 71); 
    }
 
    /*
     * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    public void render(GameContainer container, StateBasedGame sb, Graphics gc1) throws SlickException {
       // Hintergrund rendern und Variablen für die Auswahl deklarieren
        background.draw(0, 0);
       // Auswahl-Bilder in die richtigen Positionen legen
        startGameOption.draw(menuX, menuY, startGameScale); 
        exitOption.draw(menuX, menuY+80, exitScale);
       // Auswahl wird vergrößert, wenn Maus draufzeigt
    }
 
    
    /*
     * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
     */
    public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
 

      Input input = container.getInput();
 
      int mouseX = input.getMouseX();
      int mouseY = input.getMouseY();
 
      boolean insideStartGame = false;
      boolean insideExit = false;
 
     // Zeige der Maus, wo Start bzw. Ende Auswahl liegen

        if( ( mouseX >= menuX && mouseX <= menuX + startGameOption.getWidth()) &&
            ( mouseY >= menuY && mouseY <= menuY + startGameOption.getHeight()) ){
            insideStartGame = true;
              }
        else if( ( mouseX >= menuX && mouseX <= menuX+ exitOption.getWidth()) &&
                 ( mouseY >= menuY+80 && mouseY <= menuY+80 + exitOption.getHeight()) ){
                   insideExit = true;
              }

         // Mausklick führt zur Ausführung von Start bzw. Ende
         // !!! Zur Zeit schließt das Fenster auch dann, wenn man auf keine der beiden Optionen klickt !!!

        if(insideStartGame){
        if(startGameScale < 1.05f)
          startGameScale += scaleStep * arg1;
 
        if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    
        //bei Mausklick wird in den State 1 gewechselt, das eigentliche Spiel startet
    
            sb.enterState(1);              
            }
        }else{
          
          if(startGameScale > 1.0f)
            startGameScale -= scaleStep * arg1;
 
          if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
            container.exit();
              }
 
          if(insideExit)
         {
       if(exitScale < 1.05f)
         exitScale +=  scaleStep * arg1;
       }else{
         if(exitScale > 1.0f)
           exitScale -= scaleStep * arg1;
       }
        
    }
 
}