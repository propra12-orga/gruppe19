package de.game.bomberman;

//Diese Klasse enthaelt das Optionsmenu

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * Die Klasse "Options" enthaelt das Optionsmenu. ??????????????????????????????????????ßß
 *
 */
public class Options extends BasicGameState {
  
  int stateID = 6;
  
  Image background = null;
  Image Fullscreen = null;
  Image Windowed = null;
  Image Music = null;
  Image ON = null;
  Image OFF = null;
  Image Vsync = null;
  Image ShowFPS = null;
  Image Credits = null;
  Image Back = null;
  
  float menuX = 310; // Position der Auswahlmoeglichkeiten (Start und Ende) im Menue - X Pixel nach recht
  float menuY = 250; // und Y Pixel nach unten

//KONSTRUKTOR:
  
 /**
 * @param stateID
 */
public Options(int stateID) {
   this.stateID = stateID;
 }
 
 /* 
 * @see org.newdawn.slick.state.BasicGameState#getID()
 */
public int getID() {
     return stateID;
 }
 


  /* 
   * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
   */
  public void init(GameContainer container, StateBasedGame sb) throws SlickException {
    
    // Menu-Bild laden und Auswahlbild deklarieren + laden
    
    background = new Image("res/menubackground.jpg");
    Image menuOptions = new Image("res/Options3.png"); // Ein Bild fuer mehrere Auswahlmoeglichkeiten
                     //  menuOptions.getSubImage(x, y, width, height)
    Fullscreen     = menuOptions.getSubImage(0, 8, 300, 350);  //Fullscreen Option aus Auswahlbild laden
    
    Windowed       = menuOptions.getSubImage(0, 56, 300, 350);  // Windowed Option aus Auswahlbild laden
    
    Music          = menuOptions.getSubImage(0, 103, 300, 350); // Music Option aus Auswahlbild laden
    
    ON             = menuOptions.getSubImage(142, 103, 300, 350); // ON aus Auswahlbild laden
    
    OFF            = menuOptions.getSubImage(215, 103, 300, 350); // OFF aus Auswahlbild laden 
     
    Vsync       = menuOptions.getSubImage(0, 152, 300, 350); // Vsync aus Auswahbild laden
    
    ShowFPS        = menuOptions.getSubImage(0, 201, 300, 350); // Show FPS aus Auswahbild laden
    
    Credits        = menuOptions.getSubImage(0, 247, 300, 350); // Credits aus Auswahbild laden
    
    Back           = menuOptions.getSubImage(0, 296, 300, 350); // Back aus Auswahbild laden
}
    

  /* 
   * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
   */
  public void render(GameContainer container, StateBasedGame sb, Graphics gc1) throws SlickException {
    // Hintergrund rendern und Variablen für die Auswahl deklarieren
    background.draw(0, 0);
    // Auswahl-Bilder in die richtigen Positionen bringen
    Fullscreen.draw(menuX, menuY+8);
    Windowed.draw(menuX, menuY+56); 
    Music.draw(menuX, menuY+103);
    ON.draw(menuX+142, menuY+103);
    OFF.draw(menuX+215, menuY+103);
    Vsync.draw(menuX, menuY+152);
    ShowFPS.draw(menuX, menuY+201);
    Credits.draw(menuX, menuY+247);
    Back.draw(menuX, menuY+296);
}

  
  /* 
   * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
   */
  public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
    
    Input input = container.getInput();
     
    int mouseX = input.getMouseX();
    int mouseY = input.getMouseY();
     
    boolean insideFullscreen = false;
    boolean insideWindowed = false;
    boolean insideMusic = false;
    boolean insideON = false;
    boolean insideOFF = false;
    boolean insideVsync = false;  
    boolean insideFPS = false;  
    boolean insideCredits = false;  
    boolean insideBack = false;
    
    
      
    
    if( ( mouseX >= menuX && mouseX <= menuX + 201) &&
        ( mouseY >= menuY+7 && mouseY <= menuY+42 ) )
        {insideFullscreen = true; }
    else if( ( mouseX >= menuX && mouseX <= menuX+ 206) &&
        ( mouseY >= menuY+55 && mouseY <= menuY+89 ) )
        {insideWindowed = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 125) &&
        ( mouseY >= menuY+104 && mouseY <= menuY+136 ) )
        {insideMusic = true;}
    else if( ( mouseX >= menuX+142 && mouseX <= menuX+ 200) &&
        ( mouseY >= menuY+104 && mouseY <= menuY+136 ) )
        {insideON = true;}
    else if( ( mouseX >= menuX+216 && mouseX <= menuX+ 291) &&
        ( mouseY >= menuY+104 && mouseY <= menuY+136 ) )
        {insideOFF = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 257) &&
        ( mouseY >= menuY+151 && mouseY <= menuY+192 ) )
        {insideVsync = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 193) &&
        ( mouseY >= menuY+200 && mouseY <= menuY+233 ) )
        {insideFPS = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 142) &&
        ( mouseY >= menuY+247 && mouseY <= menuY+281 ) )
        {insideCredits = true;}
    else if( ( mouseX >= menuX && mouseX <= menuX+ 100) &&
        ( mouseY >= menuY+295 && mouseY <= menuY+330 ) )
        {insideBack = true;}
    
    
    if(insideFullscreen){            
        
        if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
          
        //bei Mausklick wird Spiel im Fullscreen Modus ausgefuehrt
         
          container.setFullscreen(true);
      }
    
    if(insideWindowed){
      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
        
      //bei Mausklick wird Spiel im Fenstermodus ausgefuehrt
        
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
     
    if(insideVsync){
      
    //bei Mausklick wird die Systemzeit angezeigt aufgerufen
      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
        if (container.isVSyncRequested())
        {
          container.setVSync(false);
          container.sleep(100);
        }
        else
          container.setVSync(true);
          container.sleep(100);
        }
        
      
    
    if(insideFPS){
      
    //bei Mausklick wird der FPS counter angezeigt
      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
        if (container.isShowingFPS())
        {
          container.setShowFPS(false); 
          container.sleep(100);
        }         
         else 
          container.setShowFPS(true);
          container.sleep(100);
        }
    
    if(insideCredits){
      
    
      
      if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
        
      //bei Mausklick werden die Credits angezeigt (kommt noch)
        
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
