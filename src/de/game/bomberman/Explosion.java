package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Explosion extends SpielObjekt {
  
  private static String imPath = "/res/explosion.png";
  private Image im;
  public ArrayList<Object> expb;
  
  
  /**
   * @param x
   * @param y
   * @throws SlickException
   */
  public Explosion(int x, int y) throws SlickException {
    super(x, y);
    
    expb = new ArrayList<Object>();
    expb.add(new Block(x, y));
    
    try {
      im = new Image(imPath);
    } catch (SlickException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // TODO Auto-generated constructor stub
  }
  
  @Override
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    im.draw(x,y);
  }
  
}
