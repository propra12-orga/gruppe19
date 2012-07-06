package de.game.bomberman;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
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
  private String[] options = new String[] { "Fullscreen",
      "Music ON","Sound Effects ON", "Hide FPS", "Credits", "Back"};
  // Der Index der ausgewaehlten Option
  private int selected;
  private StateBasedGame game;
  private GameContainer container;
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
  public void keyPressed(int key, char c) {
    game.getContainer().getInput().clearKeyPressedRecord();
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
          try {
            if (container.isFullscreen()){
              container.setFullscreen(false);
              options[selected]="Fullscreen";
            }else{
              container.setFullscreen(true);
              options[selected]="Windowed";
            }
          } catch (SlickException e) {
            e.printStackTrace();
          }
          break;
        case 1:
          if (container.isMusicOn()) {
            container.setMusicOn(false);
            options[selected]="Music OFF";
          } else {
            container.setMusicOn(true);
            options[selected]="Music ON";
          }
          break;
        case 2:
          if (container.isSoundOn()) {
            container.setSoundOn(false);
            options[selected]="Sound Effects OFF";
          } else {
            container.setSoundOn(true);
            options[selected]="Sound Effects ON";
          }
          break;
        case 3:
          if (container.isShowingFPS()) {
            container.setShowFPS(false);
            options[selected]="Show FPS";
          } else {
            container.setShowFPS(true);
            options[selected]="Hide FPS";
          }
          
          break;
          
        case 4:
          game.enterState(Credits.stateID, new FadeOutTransition(Color.black),
              new FadeInTransition(Color.black));
          break;   
          
        case 5:
          game.enterState(MainMenu.stateID, new FadeOutTransition(Color.black),
              new FadeInTransition(Color.black));
          break;  
          
      }
    }
  }
}
