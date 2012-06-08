package de.game.bomberman;

import java.util.*;
import org.newdawn.slick.*;

public class Bombe extends SpielObjekt {
  
//Image der Bombe
  private static String imPath = "res/bomb.png";
  private int ExplodeRadius = 2;                            // Radius
  private Image im;
  private int counter;                                      // regelt die Zeit, wann Bomben explodieren: counter += 1: if counter==200 --> Bombe explodiert
  private boolean explode;
  private boolean BombIsDead;
  private List<Explosion> expl = new ArrayList<Explosion>(); // ArrayListe der Explosion; erstellt ein Array, welches die Weite der Explosion darstellt
  public ArrayList<Object> expb;                                // ????????????????????????????????????
  
  /**
   * @return the ExplodeRadius
   */
  public int getExplodeRadius() {
    return ExplodeRadius;
  }

  /**
   * @param ExplodeRadius the explodeRadius to set
   */
  public void setExplodeRadius(int explodeRadius) {
    ExplodeRadius = explodeRadius;
  }
  
  /**
   * @param x
   * @param y
   * @throws SlickException
   */
  public Bombe(int x, int y) throws SlickException {
    super(x, y);
    im = new Image(imPath);
    explode = false;
    counter = 0;
  }
  
  
  @Override
  public void draw(Graphics g) {
    // TODO Auto-generated method stub
    for (Explosion bombExpl : expl) {
      bombExpl.draw(g);
    }
    if(!explode) im.draw(x, y);
  }

  /**
   * @return
   */
  public boolean isExplode() {
    return explode;
  }
  
  /**
   * @param explode
   */
  public void setExplode(boolean explode) {
    this.explode = explode;
  }
  
  @Override
  public void update(int delta) throws SlickException {
    counter+=1;
    if(counter==200){
      setExplode(true);
      buildExplodeArray(ExplodeRadius);
    } else if(counter==350){
      setBombIsDead(true);
    }
  }

  private void buildExplodeArray(int explodeRadius2) throws SlickException {
    
    expl.add(new Explosion(x, y));
    
    // Explosionen in x-Richtung
    for(int i=1;i<=ExplodeRadius;i++){
      expl.add(new Explosion(x+32*i, y));
      expl.add(new Explosion(x-32*i, y));
    }
    
    // Explosionen in y-Richtung
    for(int i=1;i<=ExplodeRadius;i++){
      expl.add(new Explosion(x, y+32*i));
      expl.add(new Explosion(x, y-32*i));
    }
  }

  /**
   * @return the bombIsDead
   */
  public boolean isBombIsDead() {
    return BombIsDead;
  }

  /**
   * @param bombIsDead the bombIsDead to set
   */
  public void setBombIsDead(boolean bombIsDead) {
    BombIsDead = bombIsDead;
  }

  /**
   * @return the expl
   */
  public List<Explosion> getExpl() {
    return expl;
  }

  /**
   * @param expl the expl to set
   */
  public void setExpl(List<Explosion> expl) {
    this.expl = expl;
  };
  
}