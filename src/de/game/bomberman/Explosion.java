package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Die Klasse "Explosion" ist fuer die Explosion im Spiel zustaendig.
 * Hier wird die Explosion geladen und gezeichnet.
 * Der Counter der Explosion - zustaendig fuer den Moment der Explosion - 
 * ist ebenfalls in dieser Klasse implementiert.
 * Die Explosion nimmt durch steigende Counter an Explosionsradius zu.
 */
public class Explosion extends SpielObjekt {
  
  private static String imPath = "/res/explosion.png";
  private Image im;  
  private int counter=100;
  
  /**
   * Hier wird die Explosion erstellt.
   * Das Image der Explosion wird hier geladen. 
   * Durch die update() Methode wird der Counter,
   * der zu Beginn bei 100 liegt, dekrementiert.
   * @param x Koordinate der Explosion
   * @param y Koordinate der Explosion
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
   
    // Hier wird das Image der Explosion gezeichnet
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
   * Das ist der Getter. Er bekommt den Counter.
   * @return counter
   */
  public int getCounter() {
    return counter;
  }

  /**
   * Der Setter von Counter. Er setzt den Counter.
   * @param counter to set
   */
  public void setCounter(int counter) {
    this.counter = counter;
  }
}
