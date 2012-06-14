package de.game.bomberman;

import org.newdawn.slick.*;

/**
 * @author Aenderungen durch Ilgar (JavaDoc-Kommentare);
 *  ## Die Klasse Block ist fuer die Erstellung der Bloecke in dem Spiel zustaendig. 
 *  Hier stehen die Methoden und Konstruktoren, in denen in anderen Klassen drauf zugegriffen wird.
 */
public class Block extends SpielObjekt {
  
  private boolean zerstoerbar = false;
  private static String imPath = "/res/wand.png";
  private static String imPath2 = "/res/wand2.png";
  private Image im; 
  
  /**
   * @return zerstoerbar
   * ## Methode untersucht ob ein Block zerstoerbar ist oder nicht.
   */
  public boolean isZerstoerbar() {
    return zerstoerbar;
  }
  
  /**
   * @param zerstoerbar zerstoerbar to set 
   * ## Setzt Bloecke auf zerstoerbar.
   */
  public void setZerstoerbar(boolean zerstoerbar) {
    this.zerstoerbar = zerstoerbar;
  }
  
  /**
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * ## Mit diesen Koordinaten wird die Grundmauer um das ganze Spiel gebaut.
   * @throws SlickException
   */
  public Block(int x, int y) throws SlickException {
    super(x, y);
  }
  
  /**
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * ## Mit diesen Koordinaten werden die zerstoerbaren Bloecke gebaut. Der Boolean-typ markiert die zerstoerbaren Bloecke.
   * @param zerstoerbar ;pr�ft ob Block zerstoerbar ist
   * @throws SlickException
   */
  public Block(int x, int y, boolean zerstoerbar) throws SlickException {
    super(x,y);
    this.zerstoerbar = zerstoerbar;
    if (zerstoerbar == true){
    im = new Image(imPath);}
    if (zerstoerbar == false){
    im = new Image(imPath2);}
    }
  
  
  @Override
  /*
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    im.draw(x,y);
  }
  
}