package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;

public abstract class SpielObjekt {
  
  private static int sizeX = 31;
  private static int sizeY = 31;
  protected int x;
  protected int y;
  protected Polygon kollisionsFlaeche;
  
<<<<<<< HEAD
=======
  
  /**
   * @param g
   * @throws SlickException
   */
>>>>>>> e5aec1b53c5e4e1f8379afc862d1072415583473
  public abstract void draw(Graphics g) throws SlickException;
  
  /**
   * @param delta
   * @throws SlickException
   */
  public void update(int delta) throws SlickException {
  };
  
  /**
   * @param x
   * @param y
   * @throws SlickException
   */
  public SpielObjekt(int x, int y) throws SlickException {
    this.x = x;
    this.y = y;
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + sizeX, y,
        x + sizeX, y + sizeY, x, y + sizeY });
  }
  
  /**
   * @return
   */
  public int getX() {
    return x;
  }
  
  /**
   * @param x
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * @return
   */
  public int getY() {
    return y;
  }
  
  /**
   * @param y
   */
  public void setY(int y) {
    this.y = y;
  }
  
<<<<<<< HEAD
  public Polygon getkollFlaeche() {
    return kollisionsFlaeche;
  }
  
  public void setKollFlaeche(Polygon Poly) {
=======
  /**
   * @return
   */
  public Polygon getkollFlaeche(){
    return kollisionsFlaeche;
  }
  
  /**
   * @param Poly
   */
  public void setKollFlaeche(Polygon Poly){
>>>>>>> e5aec1b53c5e4e1f8379afc862d1072415583473
    kollisionsFlaeche = Poly;
  }
  
  /**
   * @param spielObjekt
   * @return
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
<<<<<<< HEAD
  public boolean pruefeKollsion(ArrayList<SpielObjekt> spObj) {
    for (int i = 0; i < spObj.size(); i++) {
      if (spObj.get(i).pruefeKollsion(this)) {
        return true;
      }
    }
    return false;
  }
  
=======
  /**
   * @param flaeche
   * @return
   */
>>>>>>> e5aec1b53c5e4e1f8379afc862d1072415583473
  public boolean pruefePolyKollision(Polygon flaeche) {
    return kollisionsFlaeche.intersects(flaeche);
  }
}