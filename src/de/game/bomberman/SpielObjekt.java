package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;

/**
 * Die Klasse "SpielObjekt" ist fuer das Erstellen und Vergleichen von Kollisionen
 * mit Spielobjekten im Spiel zust�ndig.
 * Kollisionen werden durch Arraylisten erstellt.
 */
public abstract class SpielObjekt {
  
  private static int sizeX = 31;
  private static int sizeY = 31;
  protected int x;
  protected int y;
  protected Polygon kollisionsFlaeche;
  
  private boolean visible = false;
  private boolean walkable = false;
  private boolean destroyable = false;
  
  /**
   * @return the visible
   */
  public boolean isVisible() {
    return visible;
  }

  /**
   * @param visible the visible to set
   */
  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  /**
   * @return the walkable
   */
  public boolean isWalkable() {
    return walkable;
  }

  /**
   * @param walkable the walkable to set
   */
  public void setWalkable(boolean walkable) {
    this.walkable = walkable;
  }

  /**
   * @return the destroyable
   */
  public boolean isDestroyable() {
    return destroyable;
  }

  /**
   * @param destroyable the destroyable to set
   */
  public void setDestroyable(boolean destroyable) {
    this.destroyable = destroyable;
  }

  /**
   * "g" ist die Variable fuer die Grafik.
   * Die Grafik verwenden wir um Images anzuzeigen.
   * @param g
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
   * Der Getter von X.
   * @return x
   */
  public int getX() {
    return x;
  }
  
  /**
   * Der Setter von X.
   * @param x set x
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * Der Getter von Y.
   * @return y
   */
  public int getY() {
    return y;
  }
  
  /**
   * Der Setter von Y.
   * @param y set y
   */
  public void setY(int y) {
    this.y = y;
  }
  
  /**
   * Der Getter von kollisionsFlaeche.
   * @return kollisionsFlaeche
   */
  public Polygon getkollFlaeche() {
    return kollisionsFlaeche;
  }
  
  /**
   * Der Setter von kollisionsFlaeche.
   * @param Poly set Poly
   */
  public void setKollFlaeche(Polygon Poly) {
    kollisionsFlaeche = Poly;
  }
  
  /**
   * Hier wird geprueft ob eine Kollision mit einem SpielObjekt vorliegt oder nicht.
   * @param spielObjekt preuft Kollision SpielObjekt
   * @return kollisionsFlaeche
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
  /**
   * Hier wird eine Arrayliste von SpielObjekten erstellt. Weiterhin wird hier dann auch kontrolliert, 
   * ob eine Kollision mit Gegenstaenden vorliegt.
   * Falls eine Kollision vorliegt, wird eine neue objKollision erstellt.
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
   * Hier wird in der Methode pruefePolyKollision() geprueft, ob mehrere Kollisionen vorliegen.
   * @param flaeche prueft Poly-Kollision.
   * Rueckgabewert ist dann die kollisionsFlaeche.
   * @return kollisionsFlaeche
   */
  public boolean pruefePolyKollision(Polygon flaeche) {
    return kollisionsFlaeche.intersects(flaeche);
  }
}