package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import de.game.bomberman.SpielObjekt;

public class Player extends SpielObjekt {
  
  private boolean Xtendency, Ytendency;
  
  int zeile = 0;
  int spalte = 0; // Zur Auswahl der Animationsphasen im Spritesheet
  
  private SpriteSheet p1sheet = new SpriteSheet("res/charsets/player1.png", 32, 32);
  private int left, right, up, down, bomb;
  
  public Player(int x, int y, String image) throws SlickException {
    super(x, y, image);
    
    kollisionsFlaeche = new Polygon(new float[] { x, y, x + 31, y, x + 31,
        y + 31, x, y + 31 });
    setLeft(Input.KEY_LEFT);
    setRight(Input.KEY_RIGHT);
    setUp(Input.KEY_UP);
    setDown(Input.KEY_DOWN);
    setBomb(Input.KEY_SPACE);
  }
  
  @Override
  public void update(int delta) {
    if ((x % 32) != 0) {// F?r X
      if (Xtendency) {
        move(1, 0);
      } else {
        move(-1, 0);
      }
    }
    if ((y % 32) != 0) {// F?r Y
      if (Ytendency) {
        move(0, 1);
      } else {
        move(0, -1);
      }
    }
  }
  
  public void move(int x, int y) {
    moveplayer(this.x + x, this.y + y);
  }
  
  private void moveplayer(int x, int y) {
    int Xtemp = this.x;
    int Ytemp = this.y;
    
    this.x = x;
    this.y = y;
    kollisionsFlaeche.setX(x);
    kollisionsFlaeche.setY(y);
    
    if (entityCollisionWith()) {
      this.x = Xtemp;
      this.y = Ytemp;
      kollisionsFlaeche.setX(this.x);
      kollisionsFlaeche.setY(this.y);
      if (Xtemp != this.x) {
        Xtendency = !Xtendency;
      } else if (Ytemp != this.y) {
        Ytendency = !Ytendency;
      }
    }
  }
  
  private boolean entityCollisionWith() {
    
    for (int i = 0; i < Bomberman.map.entities.size(); i++) {
      Block entity1 = (Block) Bomberman.map.entities.get(i);
      if (kollisionsFlaeche.intersects(entity1.getkollFlaeche())) {
        return true;
      }
    }
    return false;
  }
  
  // Explosion-Tod
  
  private boolean expbCollisionWith() {
    
    for (int i = 0; i < Bomberman.Bomben.expb.size(); i++) {
      Block entity1 = (Block) Bomberman.Bomben.expb.get(i);
      if (kollisionsFlaeche.intersects(entity1.getkollFlaeche())) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public void draw(Graphics g) {
    
    /*
     * Anhand der Playerposition und Tendenz wird entschieden welche
     * Animationsphase gezeichnet wird. Als erstes checken wir in welche
     * Richtung wir laufen:
     */
    
    if (y % 32 != 0) { // Wenn Vertikalbewegung
    
      if (Ytendency == true) { // wenn Richtung Norden
      
        zeile = 0;
        
        spalte = (y % 64) / 8; // die y achse wird also in 8 Pixel große
                               // abschnitte
                               // geteilt denen jeweils eine Animationsphase
                               // zugewiesen
                               // wird.
        
        System.out.println(spalte);
        
      } else { // wenn Richtung Süden (quasi wie Norden)
        zeile = 2;
        spalte = 7 - ((y % 64) / 8); // die "7-" ist weil die spalten von rechts
                                     // gewählt werden.
      }
      
    }
    
    if (x % 32 != 0) { // Wenn Vertikalbewegung (nochmal ähnlich)
    
      zeile = 1;
      
      if (Xtendency == true) { // Westen
      
        spalte = (x % 64) / 16; // Die ersten 4 Spalten
        
      } else { // Osten
      
        spalte = ((3 - (x % 64) / 16) + 4); // "3-" siehe Süden, "+4": zweite 4
                                            // Spalten
        
      }
    }
    
    /*
     * Hier sollte noch ne Idle-Ani rein (Zeile 3) Dafür müsste ich theoretisch
     * checken ob der Player auf einem Feldmittelpunkt steht und ob keine
     * (relevante) Taste gedrückt ist. Falls das der Fall ist starte ich
     * abhängig von der Richtung in die der Player schaut die entsprechende
     * Animation. Aber jetzt erstmal Heia! :)
     */
    
    g.drawImage(p1sheet.getSprite(spalte, zeile), x, y);
    if (Bomberman.debug) {
      g.draw(kollisionsFlaeche);
      g.drawString("X:" + getX() + " Y:" + getY(), 32, 460);
    }
  }
  
  public boolean isXtendency() {
    return Xtendency;
  }
  
  public void setXtendency(boolean xtendency) {
    Xtendency = xtendency;
  }
  
  public boolean isYtendency() {
    return Ytendency;
  }
  
  public void setYtendency(boolean ytendency) {
    Ytendency = ytendency;
  }
  
  public int getUp() {
    return up;
  }
  
  public void setUp(int up) {
    this.up = up;
  }
  
  public int getLeft() {
    return left;
  }
  
  public void setLeft(int left) {
    this.left = left;
  }
  
  public int getDown() {
    return down;
  }
  
  public void setDown(int down) {
    this.down = down;
  }
  
  public int getRight() {
    return right;
  }
  
  public void setRight(int right) {
    this.right = right;
  }
  
  public int getBomb() {
    return bomb;
  }
  
  public void setBomb(int bomb) {
    this.bomb = bomb;
  }
}

/*
 * CODE VOR DER ÄNDERUNG!!!
 * 
 * 
 * package de.game.bomberman;
 * 
 * import org.newdawn.slick.*; import org.newdawn.slick.geom.*; import
 * de.game.bomberman.SpielObjekt;
 * 
 * public class Player extends SpielObjekt {
 * 
 * private boolean Xtendency, Ytendency; private Animation animation; private
 * int left, right, up, down, bomb;
 * 
 * public Player(int x, int y, String image) throws SlickException { super(x, y,
 * image); animation = new Animation(); SpriteSheet sheet = new
 * SpriteSheet("res/bomberman1.png", 32, 32); animation.setAutoUpdate(true); for
 * (int frame = 0; frame < 3; frame++) {
 * animation.addFrame(sheet.getSprite(frame, 0), 150); } kollisionsFlaeche = new
 * Polygon(new float[] { x, y, x + 31, y, x + 31, y + 31, x, y + 31 });
 * setLeft(Input.KEY_LEFT); setRight(Input.KEY_RIGHT); setUp(Input.KEY_UP);
 * setDown(Input.KEY_DOWN); setBomb(Input.KEY_SPACE); }
 * 
 * @Override public void update(int delta) { if ((x % 32) != 0) {// F?r X if
 * (Xtendency) { move(1, 0); } else { move(-1, 0); } } if ((y % 32) != 0) {//
 * F?r Y if (Ytendency) { move(0, 1); } else { move(0, -1); } } }
 * 
 * public void move(int x, int y) { moveplayer(this.x + x, this.y + y); }
 * 
 * private void moveplayer(int x, int y) { int Xtemp = this.x; int Ytemp =
 * this.y;
 * 
 * this.x = x; this.y = y; kollisionsFlaeche.setX(x); kollisionsFlaeche.setY(y);
 * 
 * if (entityCollisionWith()) { this.x = Xtemp; this.y = Ytemp;
 * kollisionsFlaeche.setX(this.x); kollisionsFlaeche.setY(this.y); if (Xtemp !=
 * this.x) { Xtendency = !Xtendency; } else if (Ytemp != this.y) { Ytendency =
 * !Ytendency; } } }
 * 
 * private boolean entityCollisionWith() {
 * 
 * for (int i = 0; i < Bomberman.map.entities.size(); i++) { Block entity1 =
 * (Block) Bomberman.map.entities.get(i); if
 * (kollisionsFlaeche.intersects(entity1.getkollFlaeche())) { return true; } }
 * return false; }
 * 
 * @Override public void draw(Graphics g) { // image.drawCentered(x, y);
 * g.drawAnimation(animation, x, y); if (Bomberman.debug) {
 * g.draw(kollisionsFlaeche); g.drawString("X:" + getX() + " Y:" + getY(), 32,
 * 460); } }
 * 
 * public boolean isXtendency() { return Xtendency; }
 * 
 * public void setXtendency(boolean xtendency) { Xtendency = xtendency; }
 * 
 * public boolean isYtendency() { return Ytendency; }
 * 
 * public void setYtendency(boolean ytendency) { Ytendency = ytendency; }
 * 
 * public int getUp() { return up; }
 * 
 * public void setUp(int up) { this.up = up; }
 * 
 * public int getLeft() { return left; }
 * 
 * public void setLeft(int left) { this.left = left; }
 * 
 * public int getDown() { return down; }
 * 
 * public void setDown(int down) { this.down = down; }
 * 
 * public int getRight() { return right; }
 * 
 * public void setRight(int right) { this.right = right; }
 * 
 * public int getBomb() { return bomb; }
 * 
 * public void setBomb(int bomb) { this.bomb = bomb; } }
 */