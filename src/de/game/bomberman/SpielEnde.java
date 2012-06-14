package de.game.bomberman;

import org.newdawn.slick.*;
import de.game.bomberman.SpielObjekt;

/**
 * ## Die Klasse SpielEnde gibt das "Game Over" nach jedem Spiel aus.
 * Dieses Fenster wird hier erstellt und hier auch veraendert.
 * In dieser Klasse ist die Methode setGameOver() und sowohl ihr Getter als auch ihr Setter. 
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
   * @param height steht fuer die Hoehe des SpielEnde-Fenster
   * @param width steht fuer die Breite des SpielEnde-Fenster
   * ## Der Konstruktor SpielEnde erstellt das Fenster am Ende eines jeden Spiels mit dem Schriftzug
   * "Game Over". Dazu gibt er Parameter vor, die die Hoehe und die Breite des Fenster
   * anpassen. Die Farbe des Fenster wird mit Color() angepasst.
   * Transparent steht fuer die Charakteristik, wie das Fenster aussieht. 
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
   * @param isGameOver set isGameOver
   * ## Der Setter isGameOver prueft durch boolean, ob er angezeigt werden soll.
   * # Bspw. durch ESC oder betreten eines Exit-Felds.
   */
  public void setGameOver(boolean isGameOver) {
    this.isGameOver = isGameOver;
  }
  
  /**
   * @return isGameOver
   * ## Ist der Rueckgabewert, dass das Spiel zuende ist und isGameOver() Methode ausgefuehrt werden kann/soll.
   */
  public boolean isGameOver() {
    return isGameOver;
  }
}