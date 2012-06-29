package de.game.bomberman;

import org.newdawn.slick.*;
import de.game.bomberman.SpielObjekt;

/**
 * Die Klasse "SpielEnde" ist fuer die Einblendung des "Game Over" nach jedem Spiel zustaendig.
 * Dieses Game Over Fenster wird hier erstellt, dh in dieser Klasse ist die Methode setGameOver() 
 * und sowohl ihr Getter als auch ihr Setter. 
 */
public class SpielEnde extends SpielObjekt {
  
  private int height;
  private int width;
  private int textWidth;
  private int textHeight;
  private Color transparent;
  private Font fontGameOver = new AngelCodeFont("res/fonts/game_over_font.fnt",
                              new Image("res/fonts/game_over_font.png"));
  private boolean isGameOver;
  private static final String GAME_OVER = "Try Again?" + "\n" + "       Y/N";
  
  /**
   * Der Konstruktor SpielEnde erstellt das Fenster am Ende eines jeden Spiels mit dem Schriftzug
   * "Game Over". Dazu gibt er Parameter vor, die die Hoehe und die Breite des Fensters
   * anpassen. Die Farbe des Fensters wird mit Color() angepasst.
   * Transparent steht fuer die Transparenz-charakteristik des Fensters.
   * @param height steht fuer die Hoehe des SpielEnde-Fensters
   * @param width steht fuer die Breite des SpielEnde-Fensters
   * @throws SlickException
   */
  public SpielEnde(int height, int width) throws SlickException {
    super(height, width);
    this.height = height;
    this.width = width;
    // Spezifikation wie das Fenster aussehen soll
    transparent = new Color(Color.black);
    transparent.a = 0.8f;
    //Text Spezizifikation
    textWidth = fontGameOver.getWidth(GAME_OVER);
    textHeight = fontGameOver.getHeight(GAME_OVER);
    
  }
  
  @Override
  /*
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    if (isGameOver()) {
      // Zeichnet das Fenster
      g.setColor(transparent);
      g.fillRect(0, 0, width, height);
      g.setColor(Color.white);
      g.setFont(fontGameOver);
      g.drawString(GAME_OVER, (width / 2) - (textWidth / 2), ((height / 2))
          + 100 - textHeight);
    }
  }
  
  /**
   * Der Setter isGameOver prueft durch den Booleantyp, ob er angezeigt werden soll.
   * Bspw. wird das Fenster durch ESC oder betreten eines Exit-Felds auf true gesetzt und angezeigt.
   * @param isGameOver set isGameOver
   */
  public void setGameOver(boolean isGameOver) {
    this.isGameOver = isGameOver;
  }
  
  /**
   * Ist der Rueckgabewert, dass das Spiel zuende ist und isGameOver() Methode ausgefuehrt werden kann/soll.
   * @return isGameOver
   */
  public boolean isGameOver() {
    return isGameOver;
  }
}