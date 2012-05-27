package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import de.game.bomberman.SpielObjekt;

public class Exit extends SpielObjekt {
  
  
  private Image im;
  
  public Exit(int x, int y, String image) throws SlickException {
    super(x, y, image);
    // TODO Auto-generated constructor stub
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + 31, y, x + 31,
        y + 31, x, y + 31 });
    im = new Image(image);
  }
  
  public Exit(int x, int y) {
    super(x, y);
    // TODO Auto-generated constructor stub
  }
  
  public Exit(String image) {
    super(image);
    // TODO Auto-generated constructor stub
  }
  
  public Exit() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    im.draw(x, y);
    
  }
  
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
}
