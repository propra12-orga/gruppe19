package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import de.game.bomberman.SpielObjekt;

/**
 * ## In der Klasse Exit erstellen wir den Ausgang im Spiel. 
 */
public class Exit extends SpielObjekt {
  
  static private String imPath = "res/Exit.png"; 
  private Image im;
  
  /**
   * @param x Koordinate des Exits
   * @param y Koordinate des Exits
   * ## Auf diese Koordinaten wird Exit im Spiel geladen.
   * # Das Image von Exit wird geladen.
   * @throws SlickException
   */
  public Exit(int x, int y) throws SlickException {
    super(x, y);
    
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + 31, y, x + 31,
        y + 31, x, y + 31 });
    im = new Image(imPath);
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    
    /*
     * Hier wird das Image von exit gezeichnet, indem es die Koordinaten uebernimmt.
     */
    im.draw(x, y);
    
  }
  
  /* 
   * @see de.game.bomberman.SpielObjekt#pruefeKollsion(de.game.bomberman.SpielObjekt)
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
}
