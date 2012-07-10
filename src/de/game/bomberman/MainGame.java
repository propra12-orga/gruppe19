package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * Die Mainmethode in dieser Klasse gibt den Startschuss fuer das Spiel Bomberman.
 * Es werden FPS eingestellt unter denen das Spiel laeuft und das Fenster eingestellt; 800x 600.
 */
public class MainGame extends StateBasedGame {
  
  /**
   * Das Spiel kann starten! Hier wird dem Konstruktor "Bomberman" übergeben.
   */
  public MainGame() {
    super("Bomberman");
  }
  
  /* 
   * @see org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.GameContainer)
   */
  public void initStatesList(GameContainer container) {
    this.addState(new MainMenu());   // State fuer das Menu hinzugefuegt
    this.addState(new Tutorial());       // State fuer Tutorial hinzugefuegt
    this.addState(new SingleplayerDummy());       // State fuer Tutorial hinzugefuegt
    this.addState(new StaticMap());       // State fuer das eigentliche Spiel mit statischen Maps hinzugefuegt
    this.addState(new RandomMap());       // State fuer das eigentliche Spiel mit zufaelligen Maps hinzugefuegt
    this.addState(new NetworkDummy());       // State fuer den Netzwerkmodus hinzugefuegt
    this.addState(new Options());   // State fuer das Optionsmenue hinzugefuegt
    this.addState(new MultiplayerOptions());   // State fuer das Optionsmenue hinzugefuegt
    this.addState(new Credits());   // State fuer das Anzeigen der Credits
  }
  
  /**
   * Die Main Methode;
   * Hier wird das Spiel aus aufgerufen und gestartet. 
   * Die Frames per Second werden auf 58 gesetzt, das Display/ Fenster wird auf die Groesse 800x 600
   * eingestellt und der Befehl das Spiel zu starten wird gegeben.
   * 
   * @param argv
   */
  public static void main(String[] argv) {
    try {
      AppGameContainer container = new AppGameContainer(new MainGame());
      container.setTargetFrameRate(58);
      container.setDisplayMode(800, 600, false);
      container.start();
    } catch (SlickException e) {
      e.printStackTrace();
    }
  }
}