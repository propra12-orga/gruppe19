package de.game.bomberman;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import de.game.bomberman.SpielObjekt;

public class Bombe extends SpielObjekt {
  
  private int time = 5000;
  private int size = 12;
  private Image im;
  private int counter;
  private boolean explode;
  
  public Bombe(int x, int y, String image) throws SlickException {
    super(x, y, image);
    // TODO Auto-generated constructor stub
    im = new Image(image);
    explode = false;
    counter = 0;
  }
  
  public Bombe(int x, int y) {
    super(x, y);
    // TODO Auto-generated constructor stub
  }
  
  public Bombe(String image) {
    super(image);
    // TODO Auto-generated constructor stub
  }
  
  public Bombe() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    im.draw(x, y);
  }
  
  public int getTime() {
    return time;
  }
  
  public void setTime(int time) {
    this.time = time;
  }
  
  public int getRadius() {
    return size;
  }
  
  public void setRadius(int size) {
    this.size = size;
  }
  
  public boolean isExplode() {
    return explode;
  }
  
  public void setExplode(boolean explode) {
    this.explode = explode;
  }
  
  @Override
  public void update(int delta) {
    counter+=1;
    if(counter==100){
      setExplode(true);
    }
  };
  
}
