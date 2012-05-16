import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class BombermanTest extends BasicGame {
  
  public static void main(String[] argv) throws SlickException {
    final AppGameContainer container = new AppGameContainer(
        new BombermanTest(), 640, 480, false);
    container.start();
  }
  
  private float playerX = 32;
  private float playerY = 32;
  @SuppressWarnings("unused")
  private BlockMap map;
  private Animation player;
  private Polygon playerPoly;
  private boolean Xtendency, Ytendency;
  
  Boolean debug = true; // True um zusätzliche Infos anzuzeigen.
  
  public BombermanTest() {
    super("BOMBASTISCHER MANN");
  }
  
  /*
   * Bewegung von Bombi! Inklusive Kollisionsabfrage
   */
  
  public boolean entityCollisionWith() throws SlickException {
    
    for (int i = 0; i < BlockMap.entities.size(); i++) {
      
      final Block entity1 = (Block) BlockMap.entities.get(i);
      
      if (playerPoly.intersects(entity1.poly)) {
        return true;
      }
    }
    return false;
  }
  
  // Steuerung (Very Basic!)
  
  @Override
  public void init(GameContainer container) throws SlickException {
    container.setVSync(true);
    final SpriteSheet sheet = new SpriteSheet("res/bomberman1.png", 32, 32);
    map = new BlockMap("res/testmap2.tmx");
    player = new Animation();
    player.setAutoUpdate(true);
    for (int frame = 0; frame < 3; frame++) {
      player.addFrame(sheet.getSprite(frame, 0), 150);
    }
    
    playerPoly = new Polygon(new float[] { playerX, playerY, playerX + 31,
        playerY, playerX + 31, playerY + 31, playerX, playerY + 31 });
  }
  
  public void moveplayer(float x, float y) throws SlickException {
    final float Xtemp = playerX;
    final float Ytemp = playerY;
    
    playerX = x;
    playerY = y;
    playerPoly.setX(playerX);
    playerPoly.setY(playerY);
    
    if (entityCollisionWith()) {
      playerX = Xtemp;
      playerY = Ytemp;
      playerPoly.setX(playerX);
      playerPoly.setY(playerY);
    }
  }
  
  @Override
  public void render(GameContainer container, Graphics g) {
    BlockMap.tmap.render(0, 0);
    g.drawAnimation(player, playerX, playerY);
    g.draw(playerPoly);
    if (debug) {
      g.drawString("X:" + playerX + " Y:" + playerY, 32, 460);
      try {
        if (entityCollisionWith()) {
          g.drawString("Coll: False", 256, 460);
        } else {
          g.drawString("Coll: True", 256, 460);
        }
      } catch (final SlickException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
  }
  
  @Override
  public void update(GameContainer container, int delta) throws SlickException {
    
    /*
     * MAGNETISMUS:
     * 
     * Wenn der Player sich an einer nicht durch 32 teilbaren XYPosition
     * befindet wird er solange bewegt bis er eine erreicht. Die Richtung in die
     * er sich bewegt wird dabei von Xtendency bzw. Ytendency bestimmt.
     */
    
    if ((playerX % 32) != 0) {// Für X
      if (Xtendency) {
        moveplayer(playerX + 1, playerY);
      } else {
        moveplayer(playerX - 1, playerY);
      }
    }
    
    if ((playerY % 32) != 0) {// Für Y
      if (Ytendency) {
        moveplayer(playerX, playerY + 1);
      } else {
        moveplayer(playerX, playerY - 1);
      }
    }

    if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
      Xtendency = false;
      if ((playerX % 32) == 0) {
        moveplayer(playerX - 1, playerY);
      }
    }
    
    if (container.getInput().isKeyDown(Input.KEY_RIGHT)) {
      Xtendency = true;
      if ((playerX % 32) == 0) {
        moveplayer(playerX + 1, playerY);
      }
    }
    
    if (container.getInput().isKeyDown(Input.KEY_UP)) {
      Ytendency = false;
      if ((playerX % 32) == 0) {
        moveplayer(playerX, playerY - 1);
      }
    }
    
    if (container.getInput().isKeyDown(Input.KEY_DOWN)) {
      Ytendency = true;
      if ((playerX % 32) == 0) {
        moveplayer(playerX, playerY + 1);
      }
    }
    
    if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) { // Esc beendet
      // Spiel
      System.exit(0);
    }
  }
}