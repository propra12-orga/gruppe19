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
  private Color transparent;
  private Font font = new AngelCodeFont("res/fonts/game_over_font.fnt",
                              new Image("res/fonts/game_over_font.png"));
  private boolean isGameOver;
  private static final String GAME_OVER = "GAME OVER";
  
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
    transparent = new Color(Color.black);
    transparent.a = 0.8f;    
  }
  
  @Override
  /*
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    if (isGameOver()) {
      width = 640;
      height = 480;
      // Zeichnet das Fenster
      g.setColor(transparent);
      g.fillRect(0, 0, width, height);
      g.setColor(Color.white);
      g.setFont(font);
      g.drawString(GAME_OVER, (width-font.getWidth(GAME_OVER)) / 2, (height-font.getHeight(GAME_OVER)) / 2);
      g.resetFont();
      g.drawString("Press any key to return to main menu.", (width-g.getFont().getWidth("Press any key to return to main menu."))/2, (height-font.getHeight(GAME_OVER))/2+font.getHeight(GAME_OVER));
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