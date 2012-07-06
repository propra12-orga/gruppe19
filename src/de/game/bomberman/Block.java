package de.game.bomberman;

import org.newdawn.slick.*;

/**
 *  Die Klasse "Block" ist fuer die Erstellung der Bloecke im Spiel noetig.
 *  Hier stehen die Methoden und Konstruktoren, auf die in anderen Klassen zugegriffen wird.
 */
public class Block extends SpielObjekt {
  
  private static String imPath = "/res/wand.png";
  private static String imPath2 = "/res/wand2.png";
  private Image im; 
  
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
   * Bei true zerstoerbar, bei false nicht.
   * @param x Koordinate des Blocks
   * @param y Koordinate des Blocks
   * @param zerstoerbar ;pr�ft ob Block zerstoerbar ist
   * @throws SlickException
   */
  public Block(int x, int y, boolean destroyable) throws SlickException {
    super(x,y);
    setDestroyable(destroyable);
    if (isDestroyable() == true){
    im = new Image(imPath);}
    if (isDestroyable() == false){
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