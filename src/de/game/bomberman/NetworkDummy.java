package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class NetworkDummy extends BasicGameState {
  
  int stateID = 4;

//KONSTRUKTOR:
  
 public NetworkDummy(int stateID) {
   this.stateID = stateID;
 }
 
 public int getID() {
     return stateID;
 }

  @Override
  public void init(GameContainer container, StateBasedGame game)
      throws SlickException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void render(GameContainer container, StateBasedGame game, Graphics g)
      throws SlickException {
    g.drawString("Hier kommt die Netzwerk Klasse hin!", 250, 300);
    
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int delta)
      throws SlickException {
    // TODO Auto-generated method stub
    
  }

  
  
  
}
