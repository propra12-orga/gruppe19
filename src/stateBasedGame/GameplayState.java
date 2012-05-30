package stateBasedGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/* 
 * Wenn ich's richtig verstanden habe, wird das hier später der Spieleanteil von Bomberman
 */

public class GameplayState extends BasicGameState {
 
    int stateID = 1; // 
 
    GameplayState( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
    @Override
    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
 
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
 
    }
 
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        
        
 
    }
 
}