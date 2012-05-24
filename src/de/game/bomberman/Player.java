package de.game.bomberman;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import de.game.bomberman.SpielObjekt;

public class Player extends SpielObjekt {
  
  private boolean Xtendency, Ytendency;
  private Animation animation;
  private int left, right, up, down, bomb;
  
  public Player(int x, int y, String image) throws SlickException {
    super(x, y, image);
    animation = new Animation();
    SpriteSheet sheet = new SpriteSheet("res/bomberman1.png", 32, 32);
    animation.setAutoUpdate(true);
    for (int frame = 0; frame < 3; frame++) {
      animation.addFrame(sheet.getSprite(frame, 0), 150);
    }
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
  
  @Override
  public void draw(Graphics g) {
    // image.drawCentered(x, y);
    g.drawAnimation(animation, x, y);
    if (Bomberman.debug) {
      g.draw(kollisionsFlaeche);
      g.drawString("X:" + getX() + " Y:" + getY(), 32, 460);
    }
  }
  
  public boolean pruefeKollsion(SpielObjekt spielObjekt) {
    return kollisionsFlaeche.contains(spielObjekt.getX(), spielObjekt.getY());
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
