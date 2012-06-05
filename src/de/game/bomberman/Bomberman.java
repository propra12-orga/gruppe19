package de.game.bomberman;

import java.util.*;
import org.newdawn.slick.*;

public class Bomberman extends BasicGame {
  
  public static MapAnalyzer map;
  private static List<Player> player = new ArrayList<Player>();
  private static List<Bombe> bomben = new ArrayList<Bombe>();
  private Exit exit;
  private SpielEnde ende;
  static public Explosion explosion;
  
  static final boolean debug = false;
  
  // KONSTRUKTOREN:
  
  public Bomberman(String title) {
    super(title);
    // TODO Auto-generated constructor stub
  }
  
  public Bomberman() {
    // TODO Auto-generated constructor stub
    super("BOMBASTISCHER MANN");
  }
  
  // RENDER BLOCK:
  
  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {
    // TODO Auto-generated method stub
    
    container.setVSync(true);
    MapAnalyzer.tmap.render(0, 0);
    for (Bombe bomb : bomben) {
      bomb.draw(g);
    }
    exit.draw(g);
    for (Player pl : player) {
      pl.draw(g);
    }
    ende.draw(g);
  }
  
  // INIT BLOCK:
  
  @Override
  public void init(GameContainer container) throws SlickException {
    // TODO Auto-generated method stub
    
    Music music = new Music("res/Music/test.ogg"); // Hier wird die Musik
                                                   // geladen...
    music.loop(); // ... und im Loop abgespielt
    
    map = new MapAnalyzer("res/testmap2.tmx");
    player.add(0, new Player(32, 32, 1));
    player.add(1, new Player(544, 32, 2));
    player.get(0).setKeys(Input.KEY_LEFT, Input.KEY_RIGHT, Input.KEY_UP,
        Input.KEY_DOWN, Input.KEY_SPACE);
    player.get(1).setKeys(Input.KEY_A, Input.KEY_D, Input.KEY_W, Input.KEY_S,
        Input.KEY_LCONTROL);
    exit = new Exit(544, 416);
    ende = new SpielEnde(container.getHeight(), container.getWidth());
  }
  
  // UPDATE BLOCK:
  
  @Override
  public void update(GameContainer container, int arg1) throws SlickException {
    // TODO Auto-generated method stub
    
    if (ende.isGameOver()) {
      if (container.getInput().isKeyPressed(Input.KEY_N)) {
        container.exit();
      }
      if (container.getInput().isKeyPressed(Input.KEY_Y)) {
        restartGame(container);
      }
    } else {
      for (int i = 0; i < bomben.size(); i++) {
        Bombe bomb = bomben.get(i);
        bomb.update(arg1);
        if (bomb.isBombIsDead()) {
          bomben.remove(bomb);
        }
      }
      for (Player pl : player) {
        pl.update(arg1);
        if (container.getInput().isKeyDown(pl.getLeft())) {
          pl.setXtendency(false);
          if ((pl.getX() % 32) == 0) {
            pl.move(-1, 0);
          }
        }
        
        if (container.getInput().isKeyDown(pl.getRight())) {
          pl.setXtendency(true);
          if ((pl.getX() % 32) == 0) {
            pl.move(+1, 0);
          }
        }
        if (container.getInput().isKeyDown(pl.getUp())) {
          pl.setYtendency(false);
          if ((pl.getY() % 32) == 0) {
            pl.move(0, -1);
          }
        }
        
        if (container.getInput().isKeyDown(pl.getDown())) {
          pl.setYtendency(true);
          if ((pl.getY() % 32) == 0) {
            pl.move(0, +1);
          }
        }
        
        if (container.getInput().isKeyPressed(pl.getBomb())) {
          // Eigentlich m�sste jetzt ein sound abgespielt werden :(
          float BombX;
          float BombY;
          boolean kollision = false;
          BombX = (float) (Math.round(pl.getX() / 32.) * 32.);
          BombY = (float) (Math.round(pl.getY() / 32.) * 32.);
          Bombe tmpBomb = new Bombe((int) BombX, (int) BombY);
          for (int i = 0; i < bomben.size(); i++) {
            kollision = bomben.get(i).pruefeKollsion(tmpBomb);
            if (kollision == true) {
              break;
            }
          }
          if (kollision == false) {
            bomben.add(tmpBomb);
            Sound fx = new Sound("res/sfx/sfxtest.wav");
            fx.play();
          }
        }
        
        if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)
            || exit.pruefeKollsion(pl)) {
          ende.setGameOver(true);
        }
      }
    }
  }

  private void restartGame(GameContainer container) throws SlickException {
    player.clear();
    bomben.clear();
    ende = null;
    exit = null;
    map = null;
    init(container);
  }
}