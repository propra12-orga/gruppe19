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
  private static final String GAME_OVER = "Try Again?" + "\n" + "      Y/N";
  
  public SpielEnde(int height, int width) throws SlickException {
    super(height, width);
    this.height = height;
    this.width = width;
    transparent = new Color(Color.black);
    transparent.a = 0.8f;
    textWidth = fontGameOver.getWidth(GAME_OVER);
    textHeight = fontGameOver.getHeight(GAME_OVER);
    
  }
  
  @Override
  public void draw(Graphics g) {
    if (isGameOver()) {
      g.setColor(transparent);
      g.fillRect(0, 0, width, height);
      g.setColor(Color.white);
      g.setFont(fontGameOver);
      g.drawString(GAME_OVER, (width / 2) - (textWidth / 2), ((height / 2))
          + 100 - textHeight);
    }
  }
  
  public void setGameOver(boolean isGameOver) {
    this.isGameOver = isGameOver;
  }
  
  public boolean isGameOver() {
    return isGameOver;
  }
}