package de.game.bomberman;

import org.newdawn.slick.*;

/**
 *  Die Klasse "Block" ist fuer die Erstellung der Bloecke im Spiel zustaendig.
 *  Hier stehen die Methoden und Konstruktoren, auf die in anderen Klassen zugegriffen wird.
 */
public class Block extends SpielObjekt {
  
  private boolean zerstoerbar = false;
  private static String imPath = "/res/wand.png";
  private static String imPath2 = "/res/wand2.png";
  private Image im; 
  
  /**
   * Methode untersucht ob ein Block zerstoerbar ist oder nicht.
   * @return zerstoerbar
   */
  public boolean isZerstoerbar() {
    return zerstoerbar;
  }
  
  /**
   * Setzt Bloecke auf zerstoerbar.
   * @param zerstoerbar zerstoerbar to set 
   */
  public void setZerstoerbar(boolean zerstoerbar) {
    this.zerstoerbar = zerstoerbar;
  }
  
  /**
   * Mit diesen Koordinaten wird die Grundmauer um das ganze Spiel gebaut.
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * @throws SlickException
   */
  public Block(int x, int y) throws SlickException {
    super(x, y);
  }
  
  /**
   * Mit diesen Koordinaten werden die zerstoerbaren Bloecke gebaut. Der Boolean-typ markiert die zerstoerbaren Bloecke.
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * @param zerstoerbar ;prüft ob Block zerstoerbar ist
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