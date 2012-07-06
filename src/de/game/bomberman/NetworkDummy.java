package de.game.bomberman;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import de.game.bomberman.MainMenu;

/**
 * Die Klasse "NetworkDummy" ist fuer das Netzwerk im Spiel verantwortlich.
 * In dieser Klasse werden die Menuepunkte "Host, Join, Back" geschrieben und ins Fenster gezeichnet.
 * In NetworkDummy wird der Hintergrund fuer NetworkDummy geladen und ein neuer State zugeordnet.
 * Außerdem steht hier die Erkennung des Druecken der Tasten durch den Spieler.
 */
public class NetworkDummy extends BasicGameState {
  
  Image background = null;
  // Die stateID fuer das Menu
  public static final int stateID = 5;
  private Font font;
  // Die Auswahlmoeglichkeiten
  private String[] options = new String[] { "Host", "Join", "Back" };
  // Der Index der ausgewaehlten Option
  private int selected;
  private StateBasedGame game;
  private GameContainer container;
  private String ip;
  private String prompt;
  
  public int getID() {
    return stateID;
  }
  
  /**
   * @see org.newdawn.slick.state.BasicGameState#init(org.newdawn.slick.GameContainer,
   *      org.newdawn.slick.state.StateBasedGame)
   */
  public void init(GameContainer container, StateBasedGame game)
      throws SlickException {
    background = new Image("res/menubackground.jpg");
    this.game = game;
    this.container = container;
    ip = "";
    prompt = "Enter target IP adress to join:";
    font = new AngelCodeFont("res/fonts/demo2.fnt", "res/fonts/demo2_00.tga");
  }
  
  /**
   * @see org.newdawn.slick.state.BasicGameState#render(org.newdawn.slick.GameContainer,
   *      org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
   */
  public void render(GameContainer container, StateBasedGame game, Graphics g) {
    // Hintergrund rendern
    background.draw(0, 0);
    g.setFont(font);
    g.setColor(Color.white);
    g.drawString(ip, 300, 500);
    g.drawString(prompt, 250, 450);
    
    for (int i = 0; i < options.length; i++) {
      g.drawString(options[i], 400 - (font.getWidth(options[i]) / 2),
          250 + (i * 50));
      if (selected == i) {
        g.drawRect(200, 240 + (i * 50), 400, 50);
      }
    }
  }
  
  /**
   * @see org.newdawn.slick.state.BasicGameState#update(org.newdawn.slick.GameContainer,
   *      org.newdawn.slick.state.StateBasedGame, int)
   */
  public void update(GameContainer container, StateBasedGame game, int delta) {
  }
  
  /**
   * @see org.newdawn.slick.state.BasicGameState#keyReleased(int, char)
   */
  public void keyReleased(int key, char c) {
    
    if (key == Input.KEY_DOWN) {
      selected++;
      if (selected >= options.length) {
        selected = 0;
      }
    }
    if (key == Input.KEY_UP) {
      selected--;
      if (selected < 0) {
        selected = options.length - 1;
      }
    } else {
      ip = this.parseIP(ip, key);
    }
    if (key == Input.KEY_ENTER) {
      switch (selected) {
        case 0:
          // while(key != Input.KEY_ESCAPE){
          ip = "";
          prompt = "Waiting for responding client...";
          // }
          break;
        case 1:
          // while(key != Input.KEY_ESCAPE){
          
          prompt = "Connecting to server...";
          
          // }
          break;
        case 2:
          game.enterState(MultiplayerOptions.stateID, new FadeOutTransition(Color.black),
              new FadeInTransition(Color.black));
          break;
      }
    }
    
  }
  
  /**
   * Hier wird die Tastenerkennung von 0 bis 9 und zusaetzlich die Taste "Back" und der "." erkannt und auch als solche aufgeschrieben.
   * Damit wird erreicht, dass nur die Zahlen und der Punkt aufgeschrieben werden koennen - da ja eine IP Adresse lediglich Zahlen und Punkte 
   * aufweist. Durch "Back" wird ein Loeschen durch unbeabsichtigte Tastendruecke moeglich.
   * @param input
   * @param c
   * @return
   */
  public String parseIP(String input, int c) {
    
    if (Input.KEY_0 == c) {
      input = input + '0';
    }
    if (Input.KEY_1 == c) {
      input = input + '1';
    }
    if (Input.KEY_2 == c) {
      input = input + '2';
    }
    if (Input.KEY_3 == c) {
      input = input + '3';
    }
    if (Input.KEY_4 == c) {
      input = input + '4';
    }
    if (Input.KEY_5 == c) {
      input = input + '5';
    }
    if (Input.KEY_6 == c) {
      input = input + '6';
    }
    if (Input.KEY_7 == c) {
      input = input + '7';
    }
    if (Input.KEY_8 == c) {
      input = input + '8';
    }
    if (Input.KEY_9 == c) {
      input = input + '9';
    }
    if (Input.KEY_PERIOD == c) {
      input = input + '.';
    }
    if (Input.KEY_BACK == c && !input.isEmpty()) {
      input = input.substring(0, ip.length() - 1);
    }
    return input;
    
  }
  
}
