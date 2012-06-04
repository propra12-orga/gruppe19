package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class Block extends SpielObjekt {
  
  public Block(int x, int y) {
    super(x, y);
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + 31, y, x + 31, y + 31, x, y + 31 });
    // TODO Auto-generated constructor stub
  }
  
  public Block(String image) {
    super(image);
    // TODO Auto-generated constructor stub
  }
  
  public Block() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    
  }
  
}
