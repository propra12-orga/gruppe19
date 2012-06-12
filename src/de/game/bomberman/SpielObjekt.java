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
  
  /**
   * @param g ist Grafik, wird ueberall verwendet
   * @throws SlickException
   */
  public abstract void draw(Graphics g) throws SlickException;
  
  /**
   * @param delta
   * @throws SlickException
   */
  public void update(int delta) throws SlickException {
  };
  
  /**
   * @param x Koordinate des SpielObjekts
   * @param y Koordinate des SpielObjekts
   * @throws SlickException
   */
  public SpielObjekt(int x, int y) throws SlickException {
    this.x = x;
    this.y = y;
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + sizeX, y,
        x + sizeX, y + sizeY, x, y + sizeY });
  }
  
  /**
   * @return x
   */
  public int getX() {
    return x;
  }
  
  /**
   * @param x setzt x
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * @return y
   */
  public int getY() {
    return y;
  }
  
  /**
   * @param y set y
   */
  public void setY(int y) {
    this.y = y;
  }
  
  /**
   * @return kollisionsFlaeche
   */
  public Polygon getkollFlaeche() {
    return kollisionsFlaeche;
  }
  
  /**
   * @param Poly set Poly
   */
  public void setKollFlaeche(Polygon Poly) {
    kollisionsFlaeche = Poly;
  }
  
  /**
   * @param spielObjekt preuft Kollision SpielObjekt
   * @return kollisionsFlaeche
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
  /**
   * @param spObj Arrayliste des SpielObjekts
   * @return objKoll
   */
  public ArrayList<SpielObjekt> pruefeKollsion(ArrayList<SpielObjekt> spObj) {
    ArrayList<SpielObjekt> objKoll = new ArrayList<SpielObjekt>();
    for (SpielObjekt obj : spObj) {
      if (obj != null) {
        if (obj.pruefeKollsion(this)) {
          objKoll.add(obj);
        }
      }
    }
    return objKoll;
  }
  
  /**
   * @param flaeche prueft Poly-Kollision
   * @return kollisionsFlache
   */
  public boolean pruefePolyKollision(Polygon flaeche) {
    return kollisionsFlaeche.intersects(flaeche);
  }
}