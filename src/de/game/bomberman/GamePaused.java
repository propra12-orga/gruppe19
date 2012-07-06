package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * ?????????????????????????????????????????????????????????????????????????????
 * 
 */
public class GamePaused extends BasicGameState {
  
  Image background = null;
  // Die stateID fuer das Menu
  private Font font;
  // Die Auswahlmoeglichkeiten
  private String[] options = new String[] { "Resume", "Restart",
      "Back to Main Menu" };
  // Der Index der ausgewaehlten Option
  private int selected;
  private StateBasedGame game;
  private int prevGameState;
  StateBasedGame sb;
  
  public static final int stateID = 8;
  
  // KONSTRUKTOR:
  public GamePaused(int previousGameState) {
    prevGameState = previousGameState;
  }
  
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
    
    g.drawString("GAME PAUSED", container.getWidth()/2 - (font.getWidth("GAME PAUSED") / 2),180);
    
    for (int i = 0; i < options.length; i++) {
      g.setColor(Color.white);
      if (selected == i) {
        g.setColor(Color.red);
        // g.drawRect(200, 390 + (i * 50), 400, 50);
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
  
  public void keyPressed(int key, char c) {
    switch (key) {
      case Input.KEY_DOWN:
        selected++;
        if (selected >= options.length) {
          selected = 0;
        }
        break;
      case Input.KEY_UP:
        selected--;
        if (selected < 0) {
          selected = options.length - 1;
        }
        break;
      case Input.KEY_ENTER:
        switch (selected) {
          case 1:
            try {
              game.getState(prevGameState).init(game.getContainer(), game);
            } catch (SlickException e) {
              e.printStackTrace();
            }
            // Break weggelassen, um case 0 auch auszuführen ;)
          case 0:
            game.enterState(prevGameState, new FadeOutTransition(Color.black,100),
                new FadeInTransition(Color.black,100));
            break;
          case 2:
            game.enterState(MainMenu.stateID,
                new FadeOutTransition(Color.black,100), new FadeInTransition(
                    Color.black));
            break;
        }
        break;
      case Input.KEY_ESCAPE:
      case Input.KEY_P:
        game.enterState(prevGameState, new FadeOutTransition(Color.black,100),
            new FadeInTransition(Color.black,100));
        break;
      default:
        break;
    }
  }
}
