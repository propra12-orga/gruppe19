package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Explosion extends SpielObjekt {
  
  private Image im;
  
  public Explosion(int x, int y, String image) {
    super(x, y, image);
    try {
      im = new Image(image);
    } catch (SlickException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // TODO Auto-generated constructor stub
  }
  
  public Explosion(int x, int y) {
    super(x, y);
    // TODO Auto-generated constructor stub
  }
  
  public Explosion(String image) {
    super(image);
    // TODO Auto-generated constructor stub
  }
  
  public Explosion() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    im.draw(x,y);
  }
  
}
