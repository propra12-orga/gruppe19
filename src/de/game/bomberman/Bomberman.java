package de.game.bomberman;

import java.util.*;
import org.newdawn.slick.*;

public class Bomberman extends BasicGame {
  private Player Player1;
  private List<Bombe> Bomben = new ArrayList<Bombe>();
  public static BlockMap map;
  static final boolean debug = true;
  private Exit exit;
  private SpielEnde ende;
  
  public Bomberman(String title) {
    super(title);
    // TODO Auto-generated constructor stub
  }
  
  public Bomberman() {
    // TODO Auto-generated constructor stub
    super("BOMBASTISCHER MANN");
  }
  
  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {
    // TODO Auto-generated method stub
    container.setVSync(true);
    BlockMap.tmap.render(0, 0);
    for (SpielObjekt bomb : Bomben) {
      bomb.draw(g);
    }
    exit.draw(g);
    Player1.draw(g);
    if (ende.isGameOver()) {
      ende.draw(g);
    }
  }
  
  @Override
  public void init(GameContainer container) throws SlickException {
    // TODO Auto-generated method stub
    map = new BlockMap("res/testmap2.tmx");
    Player1 = new Player(32, 32, "res/bomberman1.png");
    exit = new Exit(544, 416, "res/Exit.png");
    Font fontGameOver = new AngelCodeFont("res/fonts/game_over_font.fnt",
        new Image("res/fonts/game_over_font.png"));
    ende = new SpielEnde(container.getHeight(), container.getWidth(),
        fontGameOver);
  }
  
  @Override
  public void update(GameContainer container, int arg1) throws SlickException {
    // TODO Auto-generated method stub
    
    if (!ende.isGameOver()) {
      Player1.update(arg1);
      for(int i=0;i<Bomben.size();i++){
        Bombe bomb = Bomben.get(i);
        bomb.update(arg1);
        if( bomb.isExplode()){
          Bomben.remove(bomb);
        }
      }
      
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
        if (((Player1.getX() % 32) == 0) && ((Player1.getY() % 32) == 0)) {
          Bombe NeueBombe = new Bombe(Player1.getX(), Player1.getY(),
              "res/bomb.png");
          Bomben.add(NeueBombe);
        }
      }
      
      if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)
          || exit.pruefeKollsion(Player1)) {
        ende.setGameOver(true);
      }
    } else {
      if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
        System.exit(0);
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
