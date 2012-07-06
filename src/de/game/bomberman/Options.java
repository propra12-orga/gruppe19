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

public class Options extends BasicGameState {
  
  Image background = null;
  // Die stateID fuer das Menu
  public static final int stateID = 6;
  private Font font;
  // Die Auswahlmoeglichkeiten
  private String[] options = new String[] { "fullscreen",
      "Music OFF", "hide FPS", "Credits", "Back" };
  // Der Index der ausgewaehlten Option
  private int selected;
  private StateBasedGame game;
  private GameContainer container;
  
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
          try {
            if (container.isFullscreen()){
              container.setFullscreen(false);
              options[selected]="fullscreen";
            }else{
              container.setFullscreen(true);
              options[selected]="windowed";
            }
          } catch (SlickException e) {
            e.printStackTrace();
          }
          break;
        case 1:
          if (container.isMusicOn()) {
            container.setMusicOn(false);
            options[selected]="music ON";
          } else {
            container.setMusicOn(true);
            options[selected]="music OFF";
          }
          break;
        case 2:
          if (container.isShowingFPS()) {
            container.setShowFPS(false);
            options[selected]="show FPS";
          } else {
            container.setShowFPS(true);
            options[selected]="hide FPS";
          }
          break;
        case 3:
          // game.enterState(Credits.stateID, new
          // FadeOutTransition(Color.black,100),
          // new FadeInTransition(Color.black,100));
          break;
        case 4:
          game.enterState(MainMenu.stateID, new FadeOutTransition(Color.black),
              new FadeInTransition(Color.black));
          break;          
      }
    }
  }
}
