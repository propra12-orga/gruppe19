package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import de.game.bomberman.SpielObjekt;

public class Exit extends SpielObjekt {
  
  static private String imPath = "res/Exit.png"; 
  private Image im;
  
  /**
   * @param x
   * @param y
   * @throws SlickException
   */
  public Exit(int x, int y) throws SlickException {
    super(x, y);
    // TODO Auto-generated constructor stub
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + 31, y, x + 31,
        y + 31, x, y + 31 });
    im = new Image(imPath);
  }
  
  @Override
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    im.draw(x, y);
    
  }
  
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#pruefeKollsion(de.game.bomberman.SpielObjekt)
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
}
