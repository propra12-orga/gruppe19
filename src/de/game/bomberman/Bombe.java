package de.game.bomberman;

import org.newdawn.slick.*;

public class Bombe extends SpielObjekt {
  
    //Image der Bombe
  private static String imPath = "res/bomb.png";
    //Radius
  private int ExplodeRadius = 5;                            
  private Image im;
    //regelt die Zeit, wann Bomben explodieren: counter += 1: if counter==200 --> Bombe explodiert
  private int counter;                                      
  private boolean explode;
  
  /**
   * @return the ExplodeRadius
   */
  public int getExplodeRadius() {
    return ExplodeRadius;
  }

  /**
   * @param ExplodeRadius the explodeRadius to set
   */
  public void setExplodeRadius(int explodeRadius) {
    ExplodeRadius = explodeRadius;
  }
  
  
  /**
   * @param x
   * @param y
   * @throws SlickException
   */
  public Bombe(int x, int y) throws SlickException {
    super(x, y);
    im = new Image(imPath);
    explode = false;
    counter = 0;
  }
  
  @Override
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    if(!explode) im.draw(x, y);
  }

  /**
   * @return
   */
  public boolean isExplode() {
    return explode;
  }
  
  /**
   * @param explode
   */
  public void setExplode(boolean explode) {
    this.explode = explode;
  }
  
  @Override
  /* (non-Javadoc)
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  public void update(int delta) throws SlickException {
    counter+=1;
    if(counter==200){
      setExplode(true);
    }
  }
}