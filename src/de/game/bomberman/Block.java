package de.game.bomberman;

import org.newdawn.slick.*;

public class Block extends SpielObjekt {
  
  private boolean zerstoerbar = false;
  
  /**
   * @return the zerstoerbar
   */
  public boolean isZerstoerbar() {
    return zerstoerbar;
  }
  
  /**
   * @param zerstoerbar the zerstoerbar to set
   */
  public void setZerstoerbar(boolean zerstoerbar) {
    this.zerstoerbar = zerstoerbar;
  }
  
  /**
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * @throws SlickException
   */
  public Block(int x, int y) throws SlickException {
    super(x, y);
  }
  
  /**
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * @param zerstoerbar ;prüft ob Block zerstoerbar ist
   * @throws SlickException
   */
  public Block(int x, int y, boolean zerstoerbar) throws SlickException {
    super(x,y);
    this.zerstoerbar = zerstoerbar;
  }
  
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    
  }
  
}