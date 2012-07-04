package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * ?????????????????????????????????????????????????????????????????????????????
 *
 */
public class NetworkDummy extends BasicGameState {
  
  public static final int stateID = 5;

//KONSTRUKTOR:
  
 
public int getID() {
     return stateID;
 }

@Override
  /* 
   * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
   */
  public void init(GameContainer container, StateBasedGame sb)
      throws SlickException {
    
    
  }

@Override
  /* 
   * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
   */
  public void render(GameContainer container, StateBasedGame sb, Graphics g)
      throws SlickException {
    g.drawString("Netzwerkmodus ist in Arbeit, ESC um ins Menu zurueckzukehren", 150, 300);
    
  }

@Override
  /* 
   * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
   */
  public void update(GameContainer container, StateBasedGame sb, int delta)
      throws SlickException {
    
    if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
      sb.enterState(0);  
    }
  }

  
  
  
}
