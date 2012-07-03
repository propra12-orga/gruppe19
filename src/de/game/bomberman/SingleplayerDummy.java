package de.game.bomberman;

import java.util.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SingleplayerDummy extends BasicGameState {
  
  int stateID = 2;
  
//KONSTRUKTOR:
  
 public SingleplayerDummy(int stateID) {
   this.stateID = stateID;
 }
 
 public int getID() {
     return stateID;
 }


 public void init(GameContainer container, StateBasedGame sb) throws SlickException {
    // TODO Auto-generated method stub    
  }


 public void render(GameContainer container, StateBasedGame sb, Graphics g) throws SlickException {
    g.drawString("Hier kommt der Singleplayermodus gegen die KI hin", 150, 300);    
  }


 public void update(GameContainer container, StateBasedGame sb, int arg1) throws SlickException {
    // TODO Auto-generated method stub
    if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
      sb.enterState(0);     
  }

 }
}
