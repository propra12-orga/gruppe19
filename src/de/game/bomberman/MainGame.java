
package de.game.bomberman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
 
/**
 * Die Klasse "MainGame" beinhaltet die main-Methode und startet das Spiel.
 * Hier wird das Spielfenster auf 800x600 eingestellt.
 */
public class MainGame extends StateBasedGame {
 
    public static final int MAINMENUSTATE          = 0;  
    public static final int GAMEPLAYSTATE          = 1;  
    public MainGame()
    {
        super("BOMBERMAN");
 
     // State fuer das Menu hinzugefuegt
        this.addState(new MainMenuState(MAINMENUSTATE));
     // State fuer das eigentliche Spiel hinzugefuegt
        this.addState(new Bomberman(GAMEPLAYSTATE));
     // Das Menu wird als erstes aufgerufen
        this.enterState(MAINMENUSTATE);
    }
 
    /**
     * @param args
     * @throws SlickException
     */
    public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new MainGame());
 
      // Wird auf 800x600 im Fenstermodus gesetzt
         app.setDisplayMode(800, 600, false);
      // starten des Spiels
         app.start();
    }
 
    /*
     * @see org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.GameContainer)
     */
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
 
        this.getState(MAINMENUSTATE).init(gameContainer, this);
        this.getState(GAMEPLAYSTATE).init(gameContainer, this);
    }
}