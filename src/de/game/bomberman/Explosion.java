package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @author Aenderungen durch Ilgar (JavaDoc-Kommentare);
 * ## Die Klasse Explosion ist fuer die Explosion im Spiel zustaendig.
 * In ihr wird die Explosion geladen und gezeichnet.
 * Der Counter der Explosion, also der Regler, wann die Explosion stattfindet
 * ist auch in dieser Klasse implementiert.
 *
 */
public class Explosion extends SpielObjekt {
  
  private static String imPath = "/res/explosion.png";
  private Image im;  
  private int counter=100;
  
  /**
   * @param x Koordinate der Explosion
   * @param y Koordinate der Explosion
   * ## Hier wird die Explosion erstellt.
   * # Das Image der Explosion wird hier geladen. 
   * Durch die update() Methode wird der Counter,
   * der zu Beginn bei 100 liegt, dekrementiert.
   * @throws SlickException
   */
  public Explosion(int x, int y) throws SlickException {
    super(x, y);
    im = new Image(imPath);
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    /*
     * Hier wird das Image der Explosion gezeichnet
     */
    im.draw(x,y);
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  public void update(int delta) throws SlickException {
    counter-=1;
  }
  
  //Zaehler
  /**
   * @return counter
   * ## Das ist der Getter. Er bekommt den Counter.
   */
  public int getCounter() {
    return counter;
  }

  /**
   * @param counter to set
   * ## Das ist der Setter des Counters. Er setzt den Counter.
   */
  public void setCounter(int counter) {
    this.counter = counter;
  }
}
