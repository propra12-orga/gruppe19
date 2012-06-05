package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;

public abstract class SpielObjekt {
  
  private static int sizeX = 31;
  private static int sizeY = 31;
  protected int x;
  protected int y;
  protected Polygon kollisionsFlaeche;
  
  
  public abstract void draw(Graphics g) throws SlickException;
  
  public void update(int delta) throws SlickException {
  };
  
  public SpielObjekt(int x, int y) throws SlickException {
    this.x = x;
    this.y = y;
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + sizeX, y, x + sizeX,
        y + sizeY, x, y + sizeY });
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public int getY() {
    return y;
  }
  
  public void setY(int y) {
    this.y = y;
  } 
  
  public Polygon getkollFlaeche(){
    return kollisionsFlaeche;
  }
  
  public void setKollFlaeche(Polygon Poly){
    kollisionsFlaeche = Poly;
  }
  
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.contains(this.x,this.y);
  }
  
  public boolean pruefePolyKollision(Polygon flaeche) {
    return kollisionsFlaeche.contains(flaeche.getX(),flaeche.getY());
  }
}