package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import de.game.bomberman.SpielObjekt;

/**
 * In der Klasse "Exit" wird die optische Beendigung des Hauptspiels erstellt. In diesem Sinne der Ausgang des Hauptspiels. 
 */
public class PowerUP extends SpielObjekt {
  
  private Image im;
  private int type=0;
  private int speed, bombcount, bombradius;
  
  /**
   * Auf diese Koordinaten wird der Ausgang im Spiel geladen.
   * @param x Koordinate des Ausgangs
   * @param y Koordinate des Ausgangs
   * @throws SlickException
   */
  public PowerUP(int x, int y, int type, int speed, int bombcount, int bombradius) throws SlickException {
    super(x, y);
    this.setType(type);
    
    switch (type) {
      case 0:
        im = new Image("res/pup_bomb.png");
        break;
      case 1:
        im = new Image("res/pup_bombradius.png");
        break;
      case 2:
        im = new Image("res/pup_speed.png");
        break;
      default:
        break;
    }
    
    this.speed = speed;
    this.bombcount = bombcount;
    this.bombradius = bombradius;
      
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + 31, y, x + 31,
        y + 31, x, y + 31 });
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    
    // Hier wird das Image vom Ausgang gezeichnet, indem es die zuvor eingegebenen Koordinaten x, y uebernimmt
    im.draw(x, y);
    
  }
  
  /* 
   * @see de.game.bomberman.SpielObjekt#pruefeKollsion(de.game.bomberman.SpielObjekt)
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }

  /**
   * @return the type
   */
  public int getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(int type) {
    this.type = type;
  }

  /**
   * @return the bombradius
   */
  public int getBombradius() {
    return bombradius;
  }

  /**
   * @param bombradius the bombradius to set
   */
  public void setBombradius(int bombradius) {
    this.bombradius = bombradius;
  }

  /**
   * @return the speed
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * @param speed the speed to set
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * @return the bombcount
   */
  public int getBombcount() {
    return bombcount;
  }

  /**
   * @param bombcount the bombcount to set
   */
  public void setBombcount(int bombcount) {
    this.bombcount = bombcount;
  }
  
}
