
   // Diese Klasse enthaelt die Main Methode und startet das Spiel in 800x600


package de.game.bomberman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
 
public class MainGame extends StateBasedGame {
 
    public static final int MAINMENUSTATE          = 0;  
    public static final int GAMEPLAYSTATE          = 1;  
    public MainGame()
    {
        super("BOMBERMAN");
 
        this.addState(new MainMenuState(MAINMENUSTATE));   // State fuer das Menu hinzugefuegt
        this.addState(new Bomberman(GAMEPLAYSTATE));       // State fuer das eigentliche Spiel hinzugefuegt
        this.enterState(MAINMENUSTATE);                    // Das Menu wird als erstes aufgerufen
    }
 
    public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new MainGame());
 
         app.setDisplayMode(800, 600, false); // Wird auf 800x600 im Fenstermodus gesetzt
         app.start();
    }
 
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
 
        this.getState(MAINMENUSTATE).init(gameContainer, this);
        this.getState(GAMEPLAYSTATE).init(gameContainer, this);
    }
}