// DUMMY KLASSE, WIRD ERSETZT


package de.game.bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class TutorialDummy extends BasicGameState {
  
  int stateID = 1;

//KONSTRUKTOR:
  
 public TutorialDummy(int stateID) {
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
    g.drawString("Hier kommt das Tutorial hin!", 300, 300);
    
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int delta)
      throws SlickException {
    // TODO Auto-generated method stub
    
  }

  
  
  
}
