package de.game.bomberman;

import org.newdawn.slick.*;
import de.game.bomberman.SpielObjekt;

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
   * @param height Hoehe des Bildschirms
   * @param width Breite des Bildschrims
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
  /* (non-Javadoc)
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
   */
  public void setGameOver(boolean isGameOver) {
    this.isGameOver = isGameOver;
  }
  
  /**
   * @return isGameOver
   */
  public boolean isGameOver() {
    return isGameOver;
  }
}