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
  
  private void enterStateAndreinit(int stateID) {
    try {
      game.getState(stateID).init(game.getContainer(), game);
    } catch (SlickException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    game.enterState(stateID, new FadeOutTransition(Color.black),
        new FadeInTransition(Color.black));
  }
}
