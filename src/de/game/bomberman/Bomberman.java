package de.game.bomberman;

import java.util.*;
import org.newdawn.slick.*;

public class Bomberman extends BasicGame {
  
  public static MapAnalyzer map;
  private Player Player1;
  public static List<Bombe> Bomben = new ArrayList<Bombe>();
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
    for (SpielObjekt bomb : Bomben) {
      bomb.draw(g);
    }
    exit.draw(g);
    Player1.draw(g);
    if (ende.isGameOver()) {
      ende.draw(g);
    }
  }
  
  
  
  // INIT BLOCK:
  
  @Override
  public void init(GameContainer container) throws SlickException {
    // TODO Auto-generated method stub
    
    map = new MapAnalyzer("res/testmap2.tmx");
    Player1 = new Player(32, 32, "res/bomberman1.png");
    
    exit = new Exit(544, 416, "res/Exit.png");
    Font fontGameOver = new AngelCodeFont("res/fonts/game_over_font.fnt",
        new Image("res/fonts/game_over_font.png"));
    ende = new SpielEnde(container.getHeight(), container.getWidth(),
        fontGameOver);
    
  }
  
  // UPDATE BLOCK:
  
  @Override
  public void update(GameContainer container, int arg1) throws SlickException {
    // TODO Auto-generated method stub
    
    if (!ende.isGameOver()) {
      Player1.update(arg1);
      Player1.update(arg1); // zweimal, so bewegt sich Bomberman schneller
      for (int i = 0; i < Bomben.size(); i++) {
        Bombe bomb = Bomben.get(i);
        bomb.update(arg1);
        if (bomb.isBombIsDead()) {
          Bomben.remove(bomb);
        }
      }
      
     // if (explosion.pruefeKollsion(Player1)){
     //   ende.setGameOver(true);
     // }
      
      if (container.getInput().isKeyDown(Player1.getLeft())) {
        Player1.setXtendency(false);
        if ((Player1.getX() % 32) == 0) {
          Player1.move(-1, 0);
        }
      }
      
      if (container.getInput().isKeyDown(Player1.getRight())) {
        Player1.setXtendency(true);
        if ((Player1.getX() % 32) == 0) {
          Player1.move(+1, 0);
        }
      }
      
      if (container.getInput().isKeyDown(Player1.getUp())) {
        Player1.setYtendency(false);
        if ((Player1.getY() % 32) == 0) {
          Player1.move(0, -1);
        }
      }
      
      if (container.getInput().isKeyDown(Player1.getDown())) {
        Player1.setYtendency(true);
        if ((Player1.getY() % 32) == 0) {
          Player1.move(0, +1);
        }
      }
      
      if (container.getInput().isKeyPressed(Player1.getBomb())) {
        
        
        // Eigentlich müsste jetzt ein sound abgespielt werden :(
        
        Sound fx = new Sound("res/sfx/sfxtest.wav");
        fx.play();
        
        System.out.println("test");

        float BombX;
        float BombY;
        boolean kollision = false;
        BombX = Math.round(Player1.getX() / 32.);
        BombY = Math.round(Player1.getY() / 32.);
        BombX *= 32.;
        BombY *= 32.;
        Bombe tmpBomb = new Bombe((int) BombX, (int) BombY, "res/bomb.png");
        for (int i = 0; i < Bomben.size(); i++) {
          Bombe bomb = Bomben.get(i);
          kollision = bomb.pruefeKollsion(tmpBomb);
          if (kollision == true) {
            break;
          }
        }
        if (kollision == false) {
          Bomben.add(tmpBomb);
        }
      }
      
      if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)
          || exit.pruefeKollsion(Player1)) {
        ende.setGameOver(true);
      }
    } else {
      if (container.getInput().isKeyPressed(Input.KEY_N)) {
        container.exit();
      }
      if (container.getInput().isKeyPressed(Input.KEY_Y)) {
        Player1.setX(32);
        Player1.setY(32);
        Player1.kollisionsFlaeche.setX(32);
        Player1.kollisionsFlaeche.setY(32);
        ende.setGameOver(false);
      }
    }
  }
  
  // /**
  // * @param args
  // * @throws SlickException
  // */
  // public static void main(String[] args) throws SlickException {
  // // TODO Auto-generated method stub
  // AppGameContainer container = new AppGameContainer(new Bomberman());
  // container.setDisplayMode(640, 480, false);
  // container.setClearEachFrame(false);
  // container.setMinimumLogicUpdateInterval(25);
  // container.start();
  // }
}
