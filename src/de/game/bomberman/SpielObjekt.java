package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;

/**
 * @author Aenderungen durch Ilgar (JavaDoc-Kommentare);
 * ## In der Klasse SpielObjekt werden die Kollisionen mit SpielObjekten in dem Spiel
 * erstellt und verglichen. Es werden Arraylisten von Kollisionen erstellt.
 *
 */
public abstract class SpielObjekt {
  
  private static int sizeX = 31;
  private static int sizeY = 31;
  protected int x;
  protected int y;
  protected Polygon kollisionsFlaeche;
  
  /**
   * @param g ist Grafik, wird ueberall verwendet
   * ## Die Grafik verwenden wir um Images anzuzeigen.
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
   * ## Der Getter
   */
  public int getX() {
    return x;
  }
  
  /**
   * @param x set x
   * ## Der Setter.
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * @return y
   * ## Der Getter.
   */
  public int getY() {
    return y;
  }
  
  /**
   * @param y set y
   * ## Der Setter.
   */
  public void setY(int y) {
    this.y = y;
  }
  
  /**
   * @return kollisionsFlaeche
   * ## Der Getter von kollisionsFlaeche.
   */
  public Polygon getkollFlaeche() {
    return kollisionsFlaeche;
  }
  
  /**
   * @param Poly set Poly
   * ## Der Setter von kollisionsFlaeche.
   */
  public void setKollFlaeche(Polygon Poly) {
    kollisionsFlaeche = Poly;
  }
  
  /**
   * @param spielObjekt preuft Kollision SpielObjekt
   * ## Hier wird geprueft ob eine Kollision mit einem SpielObjekt vorliegt oder nicht.
   * @return kollisionsFlaeche
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
  /**
   * @param spObj Arrayliste des SpielObjekts
   * ## Hier wird eine Arrayliste von SpielObjekten erstellt. Weiterhin wird hier dann auch kontrolliert, 
   * ob eine Kollision mit Gegenstaenden vorliegt.
   * @return objKoll
   * ## falls eine Kollision vorliegt, wird eine neue objKollision erstellt.
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
   * ## Hier wird in der Methode pruefePolyKollision() geprueft, ob mehrere Kollisionen vorliegen.
   * @return kollisionsFlaeche
   * ## Rueckgabewert ist dann die kollisionsFlaeche
   */
  public boolean pruefePolyKollision(Polygon flaeche) {
    return kollisionsFlaeche.intersects(flaeche);
  }
}