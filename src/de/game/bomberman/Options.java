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
    //Die stateID fuer das Menu
    public static final int stateID = 6;
    private Font font;
    // Die Auswahlmoeglichkeiten
    private String[] options = new String[] {"Fullscreen","Windowed","Music: ON OFF","Limit Framerate","Show FPS","Credits","Back"};
    // Der Index der ausgewaehlten Option
    private int selected;
    private StateBasedGame game;
    private GameContainer container;
    
    
    public int getID() {
      return stateID;
    }
         

    /**
     * @see org.newdawn.slick.state.BasicGameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
     */
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
      background = new Image("res/menubackground.jpg");
      this.game = game;
      this.container = container;
      font = new AngelCodeFont("res/fonts/demo2.fnt","res/fonts/demo2_00.tga");
    }

    /**
     * @see org.newdawn.slick.state.BasicGameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
     */
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
         // Hintergrund rendern
        background.draw(0, 0);
        g.setFont(font);
        g.setColor(Color.white);
        
        for (int i=0;i<options.length;i++) {
            g.drawString(options[i], 400 - (font.getWidth(options[i])/2), 250+(i*50));
            if (selected == i) {
                g.drawRect(200,240+(i*50),400,50);
            }
        }
    }

    /**
     * @see org.newdawn.slick.state.BasicGameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
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
              container.setFullscreen(true);
            } catch (SlickException e) {
              e.printStackTrace();
            }
            break;
          case 1:
            try {
              container.setFullscreen(false);
            } catch (SlickException e) {
              e.printStackTrace();
            } 
            break;
          case 2:           
            if (container.isMusicOn())
            {
              container.setMusicOn(false);
            }
            else
            {
              container.setMusicOn(true);
            }
            break;
          case 3:
             container.setTargetFrameRate(58);
            break;
          case 4:   
              if (container.isShowingFPS())
              {
                container.setShowFPS(false);
              }
               else
               {
                container.setShowFPS(true); 
               } 
            break;
          case 5:
            game.enterState(Credits.stateID, new FadeOutTransition(Color.black),
                new FadeInTransition(Color.black)); 
            break;
          case 6:
            game.enterState(MainMenu.stateID, new FadeOutTransition(Color.black),
                new FadeInTransition(Color.black)); 
            break;
          default:
            System.out.println("FEHLER - Return to MAIN MENU");
            game.enterState(Options.stateID, new FadeOutTransition(Color.black),
                new FadeInTransition(Color.black));
            
        }
      }
    }
}
