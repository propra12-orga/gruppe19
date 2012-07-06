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

public class Credits extends BasicGameState {
  
    Image background = null;
    //Die stateID fuer das Menu
    public static final int stateID = 9;
    private Font font;
    // Die Auswahlmoeglichkeiten
    private String[] options = new String[] {"Back"};
    // Der Index der ausgewaehlten Option
    private int selected;
    private StateBasedGame game;
    
    
    public int getID() {
      return stateID;
    }
         

    /**
     * @see org.newdawn.slick.state.BasicGameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
     */
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
      background = new Image("res/menubackground.jpg");
      this.game = game;
      font = new AngelCodeFont("res/fonts/demo2.fnt","res/fonts/demo2_00.tga");
    }

    /**
     * @see org.newdawn.slick.state.BasicGameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
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
            540 + (i * 50));
        
         
        }
      g.scale(1.35f, 1.35f);
      g.setColor(Color.red);
      g.drawString("Matthias Engelhardt................???", 80, 130);
      g.drawString("Hiep Dinh..........................???", 80, 170);
      g.drawString("Benjamin Schlueter.................???", 80, 210);
      g.drawString("Ilgar Kara.........................???", 80, 250);
      g.drawString("Dennis-Marco Fanty.................???", 80, 290);
      g.drawString("Viktor Hellwig.....................???", 80, 330);
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
            game.enterState(Options.stateID, new FadeOutTransition(Color.black),
                new FadeInTransition(Color.black));       
            break;
          default:
            System.out.println("FEHLER - Return to MAIN MENU");
            game.enterState(Credits.stateID, new FadeOutTransition(Color.black),
                new FadeInTransition(Color.black));
            
        }
      }
    }
}
