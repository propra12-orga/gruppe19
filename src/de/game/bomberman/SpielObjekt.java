package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;

public abstract class SpielObjekt {
  
  protected int x;
  protected int y;
  protected String image;
  protected Polygon kollisionsFlaeche;
  
  public abstract void draw(Graphics g);
  
  public void update(int delta) {
  };
  
  public SpielObjekt(int x, int y, String image) {
    this(x, y);
    this.image = image;
  }
  
  public SpielObjekt(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public SpielObjekt(String image) {
    this.image = image;
  }
  
  public SpielObjekt() {
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
    return kollisionsFlaeche.contains(flaeche);
  }
}
