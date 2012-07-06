package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import de.game.bomberman.SpielObjekt;

/**
 * In der Klasse "Exit" wird die optische Beendigung des Hauptspiels erstellt. In diesem Sinne der Ausgang des Spiels. 
 */
public class Exit extends SpielObjekt {
  
  static private String imPath = "res/Exit.png"; 
  private Image im;
  
  /**
   * Auf diese Koordinaten wird der Ausgang im Spiel geladen.
   * @param x Koordinate des Ausgangs
   * @param y Koordinate des Ausgangs
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
    
    // Hier wird das Image vom Ausgang gezeichnet, indem es die zuvor eingegebenen Koordinaten x, y uebernimmt
    im.draw(x, y);
    
  }
  
  /* 
   * @see de.game.bomberman.SpielObjekt#pruefeKollsion(de.game.bomberman.SpielObjekt)
   */
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.intersects(spielObjekt.getkollFlaeche());
  }
  
}
