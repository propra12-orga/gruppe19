package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.*;
import de.game.bomberman.SpielObjekt;

public class Player extends SpielObjekt {
  
  private boolean Xtendency, Ytendency;
  
  int zeile = 0;
  int spalte = 0; // Zur Auswahl der Animationsphasen im Spritesheet
  protected SpriteSheet playerSSheet;
  private int left, right, up, down, bomb;
  protected int color = 1;
  
  /**
   * @param x
   * @param y
   * @throws SlickException
   */
  public Player(int x, int y) throws SlickException {
    super(x, y);
  }
  
  /**
   * @param x
   * @param y
   * @param color
   * @throws SlickException
   */
  public Player(int x, int y, int color) throws SlickException {
    super(x, y);
    this.color = color;
    switch (color) {
      case 1:
        playerSSheet = new SpriteSheet("res/charsets/player1.png", 32, 32);
        break;
      case 2:
        playerSSheet = new SpriteSheet("res/charsets/player2.png", 32, 32);
        break;
      case 3:
        playerSSheet = new SpriteSheet("res/charsets/player3.png", 32, 32);
        break;
      case 4:
        playerSSheet = new SpriteSheet("res/charsets/player4.png", 32, 32);
        break;
      default:
        System.out.println("wrong color for player!");
        break;
    }
    if (color == 1) {
      
    }
  }
  
  @Override
  /*
   * (non-Javadoc)
   * 
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  public void update(int delta) {
    
  }
  
  /**
   * @param delta
   * @param spObj
   */
  public void update(int delta, ArrayList<SpielObjekt> spObj) {
    if ((x % 32) != 0) {// Fuer X
      if (Xtendency) {
        move(1, 0, spObj);
      } else {
        move(-1, 0, spObj);
      }
    }
    if ((y % 32) != 0) {// Fuer Y
      if (Ytendency) {
        move(0, 1, spObj);
      } else {
        move(0, -1, spObj);
      }
    }
  }
  
  /**
   * @param x
   * @param y
   * @param spObj
   */
  public void move(int x, int y, ArrayList<SpielObjekt> spObj) {
    int Xtemp = this.x;
    int Ytemp = this.y;
    
    this.x += x;
    this.y += y;
    kollisionsFlaeche.setX(this.x);
    kollisionsFlaeche.setY(this.y);
    
    if (pruefeKollsion(spObj)) {
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
  
  /*
   * (non-Javadoc)
   * 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
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
    
    g.drawImage(playerSSheet.getSprite(spalte, zeile), x, y);
    g.draw(kollisionsFlaeche);
    g.drawString("X:" + getX() + " Y:" + getY(), 32 + (color - 1) * 128, 460);
  }
  
  /**
   * @return
   */
  public boolean isXtendency() {
    return Xtendency;
  }
  
  /**
   * @param xtendency
   */
  public void setXtendency(boolean xtendency) {
    Xtendency = xtendency;
  }
  
  /**
   * @return
   */
  public boolean isYtendency() {
    return Ytendency;
  }
  
  /**
   * @param ytendency
   */
  public void setYtendency(boolean ytendency) {
    Ytendency = ytendency;
  }
  
  /**
   * @return
   */
  public int getUp() {
    return up;
  }
  
  /**
   * @param up
   */
  public void setUp(int up) {
    this.up = up;
  }
  
  /**
   * @return
   */
  public int getLeft() {
    return left;
  }
  
  /**
   * @param left
   */
  public void setLeft(int left) {
    this.left = left;
  }
  
  /**
   * @return
   */
  public int getDown() {
    return down;
  }
  
  /**
   * @param down
   */
  public void setDown(int down) {
    this.down = down;
  }
  
  /**
   * @return
   */
  public int getRight() {
    return right;
  }
  
  /**
   * @param right
   */
  public void setRight(int right) {
    this.right = right;
  }
  
  /**
   * @return
   */
  public int getBomb() {
    return bomb;
  }
  
  /**
   * @param bomb
   */
  public void setBomb(int bomb) {
    this.bomb = bomb;
  }
  
  /**
   * @param left
   * @param right
   * @param up
   * @param down
   * @param bomb
   */
  public void setKeys(int left, int right, int up, int down, int bomb) {
    this.left = left;
    this.right = right;
    this.up = up;
    this.down = down;
    this.bomb = bomb;
  }
}