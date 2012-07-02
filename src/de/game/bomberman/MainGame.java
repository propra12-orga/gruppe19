
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
    public static final int TUTORIALSTATE          = 1;
    public static final int GAMEPLAYSTATICSTATE    = 2; 
    public static final int GAMEPLAYRANDOMSTATE    = 3;  
    public static final int NETWORKSTATE           = 4;  
    public static final int OPTIONSTATE            = 5;  
    public MainGame()
    {
        super("BOMBERMAN");
 

        this.addState(new MainMenu(MAINMENUSTATE));   // State fuer das Menu hinzugefuegt
        this.addState(new Tutorial(TUTORIALSTATE));       // State fuer Tutorial hinzugefuegt
        this.addState(new StaticMap(GAMEPLAYSTATICSTATE));       // State fuer das eigentliche Spiel mit statischen Maps hinzugefuegt
        this.addState(new RandomMap(GAMEPLAYRANDOMSTATE));       // State fuer das eigentliche Spiel mit zufaelligen Maps hinzugefuegt
        this.addState(new NetworkDummy(NETWORKSTATE));       // State fuer den Netzwerkmodus hinzugefuegt
        this.addState(new Options(OPTIONSTATE));       // State fuer das Optionsmenue hinzugefuegt
        this.enterState(MAINMENUSTATE);                    // Das Menu wird als erstes aufgerufen

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
        this.getState(TUTORIALSTATE).init(gameContainer, this);
        this.getState(GAMEPLAYSTATICSTATE).init(gameContainer, this);
        this.getState(GAMEPLAYRANDOMSTATE).init(gameContainer, this);
        this.getState(NETWORKSTATE).init(gameContainer, this);
        this.getState(OPTIONSTATE).init(gameContainer, this);
    }
}