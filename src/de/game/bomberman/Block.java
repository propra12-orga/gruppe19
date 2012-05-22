package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class Block extends SpielObjekt {
  
  public Block(int x, int y, int poly[]) {
    super(x, y);
    kollisionsFlaeche = new Polygon(new float[] { x + poly[0], y + poly[1], x + poly[2],
        y + poly[3], x + poly[4], y + poly[5], x + poly[6], y + poly[7], });
    // TODO Auto-generated constructor stub
  }
  
  public Block(int x, int y) {
    super(x, y);
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
