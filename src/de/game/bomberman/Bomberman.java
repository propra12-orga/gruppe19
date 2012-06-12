package de.game.bomberman;

import java.util.*;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class Bomberman extends BasicGame {
  
  protected TiledMap karte;
  protected ArrayList<SpielObjekt> player = new ArrayList<SpielObjekt>();
  protected ArrayList<SpielObjekt> bomben = new ArrayList<SpielObjekt>();
  protected ArrayList<SpielObjekt> Mauer = new ArrayList<SpielObjekt>();
  protected ArrayList<SpielObjekt> explosion = new ArrayList<SpielObjekt>();
  protected Exit exit;
  protected SpielEnde ende;
  
  protected boolean debug = false;
  
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
  
  /*
   * (non-Javadoc)
   * 
   * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer,
   * org.newdawn.slick.Graphics)
   */
  @Override
  public void render(GameContainer container, Graphics g) throws SlickException {
    // TODO Auto-generated method stub
    
    container.setVSync(true);
    float scaleX = (float) container.getWidth()
        / (float) (karte.getWidth() * karte.getTileWidth());
    float scaleY = (float) container.getHeight()
        / (float) (karte.getHeight() * karte.getTileHeight());
    g.scale(scaleX, scaleY);
    karte.render(0, 0);
    
    for (SpielObjekt bomb : bomben) {
      bomb.draw(g);
    }
    exit.draw(g);
    for (SpielObjekt pl : player) {
      pl.draw(g);
    }
    for (SpielObjekt exp : explosion) {
      exp.draw(g);
    }
    ende.draw(g);
  }
  
  // INIT BLOCK:
  
  @Override
  public void init(GameContainer container) throws SlickException {
    // TODO Auto-generated method stub
    
    // Hier wird die Musik
    // geladen...
    Music music = new Music("res/Music/test.ogg");
    // ... und im Loop abgespielt
    music.loop();
    
    initMap("res/testmap2.tmx");
    player.add(0, new Player(32, 32, 1));
    player.add(1, new Player(544, 32, 2));
    ((Player) player.get(0)).setKeys(Input.KEY_LEFT, Input.KEY_RIGHT,
        Input.KEY_UP, Input.KEY_DOWN, Input.KEY_SPACE);
    ((Player) player.get(1)).setKeys(Input.KEY_A, Input.KEY_D, Input.KEY_W,
        Input.KEY_S, Input.KEY_LCONTROL);
    exit = new Exit(544, 416);
    ende = new SpielEnde(container.getHeight(), container.getWidth());
  }
  
  // UPDATE BLOCK:
  
  @Override
  public void update(GameContainer container, int arg1) throws SlickException {
    // TODO Auto-generated method stub
    if (player.isEmpty()) {
      ende.setGameOver(true);
    }
    if (ende.isGameOver()) {
      if (container.getInput().isKeyPressed(Input.KEY_N)) {
        container.exit();
      }
      if (container.getInput().isKeyPressed(Input.KEY_Y)) {
        restartGame(container);
      }
    } else {
      for (int i = 0; i < bomben.size(); i++) {
        Bombe bomb = (Bombe) bomben.get(i);
        bomb.update(arg1);
        if (bomb.isExplode()) {
          buildExplodeArray(bomb);
          bomben.remove(bomb);
        }
      }
      for (int i = 0; i < explosion.size(); i++) {
        Explosion expl = (Explosion) explosion.get(i);
        expl.update(arg1);
        ArrayList<SpielObjekt> deadPl = expl.pruefeKollsion(player);
        for (SpielObjekt dPL : deadPl) {
          player.remove(dPL);
        }
        if (expl.getCounter() <= 0) {
          explosion.remove(i);
        }
      }
      
      for (SpielObjekt expl : explosion) {
        expl.update(arg1);
      }
      for (int i = 0; i < player.size(); i++) {
        Player pl = (Player) player.get(i);
        pl.update(arg1, Mauer);
        
        if (container.getInput().isKeyDown(pl.getLeft())) {
          pl.setXtendency(false);
          if ((pl.getX() % 32) == 0) {
            pl.move(-1, 0, Mauer);
          }
        }
        
        if (container.getInput().isKeyDown(pl.getRight())) {
          pl.setXtendency(true);
          if ((pl.getX() % 32) == 0) {
            pl.move(+1, 0, Mauer);
          }
        }
        if (container.getInput().isKeyDown(pl.getUp())) {
          pl.setYtendency(false);
          if ((pl.getY() % 32) == 0) {
            pl.move(0, -1, Mauer);
          }
        }
        
        if (container.getInput().isKeyDown(pl.getDown())) {
          pl.setYtendency(true);
          if ((pl.getY() % 32) == 0) {
            pl.move(0, +1, Mauer);
          }
        }
        
        if (container.getInput().isKeyPressed(pl.getBomb())) {
          float BombX;
          float BombY;
          BombX = (float) (Math.round(pl.getX() / 32.) * 32.);
          BombY = (float) (Math.round(pl.getY() / 32.) * 32.);
          Bombe tmpBomb = new Bombe((int) BombX, (int) BombY);
          if (tmpBomb.pruefeKollsion(bomben).isEmpty()) {
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
  
  private void buildExplodeArray(SpielObjekt spObj) throws SlickException {
    Bombe bomb = (Bombe) spObj;
    Explosion expll, explr;
    ArrayList<SpielObjekt> kollision = new ArrayList<SpielObjekt>();
    boolean xr = true;
    boolean xl = true;
    boolean yr = true;
    boolean yl = true;
    
    explosion.add(new Explosion(bomb.getX(), bomb.getY()));
    // Prüfe Mauer Kollision
    for (int x = 0; x <= bomb.getExplodeRadius(); x++) {
      for (int y = 0; y <= bomb.getExplodeRadius(); y++) {
        if ((-x < 0 && y == 0 && xl == true)
            || (x == 0 && -y < 0 && yl == true)) {
          expll = new Explosion(bomb.getX() - x * 32, bomb.getY() - y * 32);
          
          kollision.clear();
          kollision = expll.pruefeKollsion(Mauer);
          kollision.addAll(expll.pruefeKollsion(bomben));
          if (kollision.isEmpty()) { 
            explosion.add(expll);
          } else {
            for (SpielObjekt koll : kollision) {
              if(koll instanceof Block){
                if (((Block) koll).isZerstoerbar()) {
                  explosion.add(expll);
                  Mauer.remove(koll);
                }  
              } else if (koll instanceof Bombe){
                ((Bombe)koll).setExplode(true);
              }
              
              if (-x < 0 && y == 0)
                xl = false;
              if (-y < 0 && x == 0)
                yl = false;
              
            }
          }
        }
        if ((x > 0 && y == 0 && xr == true) || (x == 0 && y > 0 && yr == true)) {
          explr = new Explosion(bomb.getX() + x * 32, bomb.getY() + y * 32);
          kollision.clear();
          kollision = explr.pruefeKollsion(Mauer);
          kollision.addAll(explr.pruefeKollsion(bomben));
          if (kollision.isEmpty()) {
            explosion.add(explr);
          } else {
            for (SpielObjekt koll : kollision) {
              if(koll instanceof Block){
                if (((Block) koll).isZerstoerbar()) {
                  explosion.add(explr);
                  Mauer.remove(koll);
                }  
              } else if (koll instanceof Bombe){
                ((Bombe)koll).setExplode(true);
              }
              
              if (x > 0 && y == 0)
                xr = false;
              if (y > 0 && x == 0)
                yr = false;
              
            }
          }
          
        }
      }
    }
    
    // expl.add(new Explosion(x, y));
    //
    // // Explosionen in x-Richtung
    // for(int i=1;i<=ExplodeRadius;i++){
    // expl.add(new Explosion(x+32*i, y));
    // expl.add(new Explosion(x-32*i, y));
    // }
    //
    // // Explosionen in y-Richtung
    // for(int i=1;i<=ExplodeRadius;i++){
    // expl.add(new Explosion(x, y+32*i));
    // expl.add(new Explosion(x, y-32*i));
    // }
  }
  
  private void restartGame(GameContainer container) throws SlickException {
    player.clear();
    bomben.clear();
    Mauer.clear();
    ende = null;
    exit = null;
    karte = null;
    init(container);
  }
  
  public void initMap(String ref) throws SlickException {
    
    karte = new TiledMap(ref, "res");
    
    for (int x = 0; x < karte.getWidth(); x++) {
      for (int y = 0; y < karte.getHeight(); y++) {
        final int tileID = karte.getTileId(x, y, 0);
        switch (tileID) {
          case 2:
            Mauer.add(new Block(x * 32, y * 32, true));
            break;
          case 17:
            Mauer.add(new Block(x * 32, y * 32, false));
            break;
          default:
            break;
        }
      }
    }
  }
}
