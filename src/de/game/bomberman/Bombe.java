package de.game.bomberman;

import org.newdawn.slick.*;

/**
 * ## Die Klasse Bombe ist fuer das Erstellen der Bombe im Spiel notwendig.
 * Hier steht Image der Bombe, ihr Radius, die Eigenschaft, ob die Bombe explodiert ist oder nicht
 * und der Zaehler der Bombe fuer die Explosion.
 */
public class Bombe extends SpielObjekt {
  
    //Image der Bombe
  private static String imPath = "res/bomb.png";
    //Radius der Explosion
  private int ExplodeRadius = 5;                            
  private Image im;
    //regelt die Zeit, wann Bomben explodieren: counter += 1: if counter==200 --> Bombe explodiert
  private int counter;                                      
  private boolean explode;
  
  /**
   * @return the ExplodeRadius
   * ## Der Explosionsradius prueft die Felder, wohin die Explosion sich ausbreiten kann
   * und breitet sich dann in diese aus.
   */
  public int getExplodeRadius() {
    return ExplodeRadius;
  }

  /**
   * @param ExplodeRadius the explodeRadius to set
   * ## Der Setter fuer explodeRadius.
   */
  public void setExplodeRadius(int explodeRadius) {
    ExplodeRadius = explodeRadius;
  }
  
  
  /**
   * @param x Koordinate der Bombe
   * @param y Koordinate der Bombe
   * ## Mit diesen Koordinaten wird die Bombe im Spiel plaziert. Weiterhin wird hier das Image der Bombe geladen.
   * Der Counter wird gleichzeitig auf 0 gesetzt.
   * # In der draw() Methode wird dann das Image auf die Koordinaten x, y gesetzt, falls die Bombe nicht explodiert ist.
   * # in der update() Methode wird dann der Zaehler der Bombe stetig erhoeht, bis 200, welches dann die Bombe mit dem Setter
   * auf true setzt -- Explosion!
   * @throws SlickException
   */
  public Bombe(int x, int y) throws SlickException {
    super(x, y);
    im = new Image(imPath);
    explode = false;
    counter = 0;
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    if(!explode) im.draw(x, y);
  }

  /**
   * @return explode
   * ## Gibt explode zurueck, dh gibt false aus. "false" steht fuer neutral -- Bombe nicht explodiert.
   * In der update() Methode wird dann der Setter, falls er aufgerufen wird, explode auf true setzen -- Explosion!
   */
  public boolean isExplode() {
    return explode;
  }
  
  /**
   * @param explode to set
   * ## Der Setter fuer explode.
   */
  public void setExplode(boolean explode) {
    this.explode = explode;
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  public void update(int delta) throws SlickException {
    counter+=1;
    if(counter==200){
      setExplode(true);
    }
  }
}
