package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainGame extends StateBasedGame {
  
  public MainGame() {
    super("State Based Test");
  }
  
  public void initStatesList(GameContainer container) {
    this.addState(new MainMenu());   // State fuer das Menu hinzugefuegt
    this.addState(new Tutorial());       // State fuer Tutorial hinzugefuegt
    this.addState(new SingleplayerDummy());       // State fuer Tutorial hinzugefuegt
    this.addState(new StaticMap());       // State fuer das eigentliche Spiel mit statischen Maps hinzugefuegt
    this.addState(new RandomMap());       // State fuer das eigentliche Spiel mit zufaelligen Maps hinzugefuegt
    this.addState(new NetworkDummy());       // State fuer den Netzwerkmodus hinzugefuegt
    this.addState(new Options());   // State fuer das Optionsmenue hinzugefuegt
    this.addState(new MultiplayerOptions());   // State fuer das Optionsmenue hinzugefuegt
   // this.addState(new Credits());   // State fuer das Anzeigen der Credits
  }
  
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