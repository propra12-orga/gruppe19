package de.game.bomberman;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Die Klasse "MainMenu" stellt das Hauptmenue des Spiels auf.
 * In dieser Klasse werden die Menuepunkte geschrieben und ins Fenster gezeichnet.
 * Musik und das Hintergrundbild werden geladen und es wird eine neue StateID zugeteilt.
 * Die Farbe der Menupunkte wird hier eingestellt.
 * Au�erdem steht hier die Erkennung des Druecken der Tasten durch den Spieler.
 */
public class MainMenu extends BasicGameState {
  
  Image background = null;
  // Die stateID fuer das Menu
  public static final int stateID = 0;
  private Font font;
  // Die Auswahlmoeglichkeiten
  private String[] options = new String[] { "Tutorial", "Singleplayer",
      "Multiplayer", "Options", "Exit" };
  // Der Index der ausgewaehlten Option
  private int selected;
  private StateBasedGame game;
  private Sound fx = null;
  
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
    fx = new Sound("res/sfx/SelectSound.wav");
    font = new AngelCodeFont("res/fonts/demo2.fnt", "res/fonts/demo2_00.tga");
    
    // Hier wird die Musik
    // geladen...
    Music music = new Music("res/Music/test.ogg");
    // ... und im Loop abgespielt
    music.loop();

  }
  
  /**
   * @see org.newdawn.slick.state.BasicGameState#render(org.newdawn.slick.GameContainer,
   *      org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
   */
  public void render(GameContainer container, StateBasedGame game, Graphics g) {
    // Hintergrund rendern
    background.draw(0, 0);
    g.setFont(font);
    
    for (int i = 0; i < options.length; i++) {
      if (selected == i) {
        g.setColor(Color.red);
      } else {
        g.setColor(Color.white);
      }
      g.drawString(options[i], 400 - (font.getWidth(options[i]) / 2),
          230 + (i * 50));
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
      fx.play();
      selected++;
      if (selected >= options.length) {
        selected = 0;
      }
    }
    if (key == Input.KEY_UP) {
      fx.play();
      selected--;
      if (selected < 0) {
        selected = options.length - 1;
      }
    }
    if (key == Input.KEY_ENTER) {
      switch (selected) {
        case 0:
          enterStateAndreinit(Tutorial.stateID);
          break;
        case 1:
          enterStateAndreinit(SingleplayerDummy.stateID);
          break;
        case 2:
          game.enterState(MultiplayerOptions.stateID, new FadeOutTransition(
              Color.black), new FadeInTransition(Color.black));
          break;
        case 3:
          game.enterState(Options.stateID, new FadeOutTransition(Color.black),
              new FadeInTransition(Color.black));
          break;
        case 4:
          game.getContainer().exit();
          break;
        default:
          System.out.println("FEHLER - Return to MAIN MENU");
          game.enterState(MainMenu.stateID, new FadeOutTransition(Color.black,100),
              new FadeInTransition(Color.black));
          
      }
    }
  }
  
  /**
   * Durch die Auswahl im MainMenu wird der Spieler - je nachdem was er ausgewaehlt hat - 
   * in einen anderen State des Spiels gebracht.
   * FadeOutTransition ist fuer ein fluessiges Uebergehen der States zustaendig.
   * @param stateID
   */
  private void enterStateAndreinit(int stateID) {
    try {
      game.getState(stateID).init(game.getContainer(), game);
    } catch (SlickException e) {
      
      e.printStackTrace();
    }
    game.enterState(stateID, new FadeOutTransition(Color.black),
        new FadeInTransition(Color.black));
  }
}
