package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.StateBasedGame;

public class NetworkDummy extends BasicGameState {
  
  int stateID = 5;

//KONSTRUKTOR:
  
 public NetworkDummy(int stateID) {
   this.stateID = stateID;
 }
 
 public int getID() {
     return stateID;
 }

  @Override
  public void init(GameContainer container, StateBasedGame sb)
      throws SlickException {
    
    
  }

  @Override
  public void render(GameContainer container, StateBasedGame sb, Graphics g)
      throws SlickException {
    g.drawString("Netzwerkmodus ist in Arbeit, ESC um ins Menu zurueckzukehren", 150, 300);
    
  }

  @Override
  public void update(GameContainer container, StateBasedGame sb, int delta)
      throws SlickException {
    
    if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
      sb.enterState(0);  
    }
  }

  
  
  
}
