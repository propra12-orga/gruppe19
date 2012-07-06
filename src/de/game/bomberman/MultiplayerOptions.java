package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * ?????????????????????????????????????????????????????????????????????????????
 *
 */
public class MultiplayerOptions extends BasicGameState {
  
  Image background = null;
  //Die stateID fuer das Menu
  private Font font;
  // Die Auswahlmoeglichkeiten
  private String[] options = new String[] {"Random Map","Classic Map","Network","Back"};
  // Der Index der ausgewaehlten Option
  private int selected;
  private StateBasedGame game;
  StateBasedGame sb;
  
  public static final int stateID = 7;

//KONSTRUKTOR:
  
 
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
    g.setColor(Color.white);
    
    for (int i=0;i<options.length;i++) {
        g.drawString(options[i], 400 - (font.getWidth(options[i])/2), 400+(i*50));
        if (selected == i) {
            g.drawRect(200,390+(i*50),400,50);
        }
    }
}

/**
 * @see org.newdawn.slick.state.BasicGameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
 */

public void update(GameContainer container, StateBasedGame game, int delta) {    
}


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
        game.enterState(RandomMap.stateID, new FadeOutTransition(Color.black),
            new FadeInTransition(Color.black));  
        break;
      case 1:
        game.enterState(StaticMap.stateID, new FadeOutTransition(Color.black),
            new FadeInTransition(Color.black)); 
        break;
      case 2:           
        game.enterState(NetworkDummy.stateID, new FadeOutTransition(Color.black),
            new FadeInTransition(Color.black));
        break;   
      case 3:           
        game.enterState(MainMenu.stateID, new FadeOutTransition(Color.black),
            new FadeInTransition(Color.black));
        break;            
    }
  }
}
  }

  
  
  
