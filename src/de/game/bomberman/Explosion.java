package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Explosion extends SpielObjekt {
  
  private static String imPath = "/res/explosion.png";
  private Image im;  
  private int counter=100;
  
  /**
   * @param x Koordinate der Explosion
   * @param y Koordinate der Exlplosion
   * @throws SlickException
   */
  public Explosion(int x, int y) throws SlickException {
    super(x, y);
    im = new Image(imPath);
  }
  
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    im.draw(x,y);
  }
  
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  @Override
  public void update(int delta) throws SlickException {
    counter-=1;
  }
  
  //Zaehler
  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }
}
