package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.*;
import de.game.bomberman.SpielObjekt;

/**
 * ## Die Klasse Player erstellt den Spieler des Spiels.
 * Im Konstruktor kann man durch hinzufuegen verschiedener Farben meherer
 * unterschiedliche Spieler konstruieren, der Image-Pfad bleibt dabei gleich.
 * Weiterhin wird hier die Steuerung des Spielers implementiert.
 * Der Spieler kann nicht nur in alle 4 Himmelsrichtungen gehen, sondern auch Bomben legen.
 * Die X-,Y-Tendency regelt die Bewegung des Spielers: sie laesst den Spieler
 * solange in eine Richtung gehen bis dieser die Mitte eines Feldes erreicht -- damit wird 
 * erreicht, dass der Spielers des Spiels den Player nicht pixelhaft steuern muss, er also
 * auch im heftigen Spiel nicht an Kanten der Mauern festhaengen bleibt.
 */

public class Player extends SpielObjekt {
  
  private boolean Xtendency, Ytendency;
  
  //Zur Auswahl der Animationsphasen im Spritesheet
  int zeile = 0;
  int spalte = 0; 
  // hiermit kann man spaeter die Farbe des Spielers einfach aendern
  protected SpriteSheet playerSSheet;
  // Steuerungen des Spielers werden als Variablen gesetzt
  private int left, right, up, down, bomb;
  protected int color = 1;
  
  /**
   * @param x Koordinate des Spielers auf der Karte
   * @param y Koordinate des Spielers auf der Karte
   * Dieser Konstruktor ist nicht mehr wirklich noetig.
   * Er bietet nur die Moeglichkeit einen "normal-farbenden" Spieler zu gestalten. 
   * @throws SlickException
   */
  // Spieler Konstruktor nur fuer die Moeglichkeit einen farblosen Spieler zu gestalten
  public Player(int x, int y) throws SlickException {
    super(x, y);
  }
  
  /**
   * @param x Koordinate des Spielers auf der Karte
   * @param y Koordinate des Spielers auf der Karte
   * ## Der Spieler wird auf die Koordinaten der Karte gesetzt.
   * @param color Farbe des Spielers
   * ## Durch color im Konstruktor kann man einfach die verschiedenfarbigen Spieler laden.
   * @throws SlickException
   */
  public Player(int x, int y, int color) throws SlickException {
    super(x, y);
    this.color = color;
    // Farbwechsel; die Farben des Spielers werde initialisiert
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
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  public void update(int delta) {
    
  }
  
  /**
   * @param delta 
   * @param spObj wird geupdated
   * ## hier wird die Arrayliste des SpielObjekts geupdated.
   * Die Bewegung des Spielers vergleicht die X-,Y-Tendency und entscheidet dann,
   * ob der Spieler weitergehen kann, oder nicht.
   */
  public void update(int delta, ArrayList<SpielObjekt> spObj) {
    // fuer X
    if ((x % 32) != 0) {
      if (Xtendency) {
        move(1, 0, spObj);
      } else {
        move(-1, 0, spObj);
      }
    }
    // fuer Y
    if ((y % 32) != 0) {
      if (Ytendency) {
        move(0, 1, spObj);
      } else {
        move(0, -1, spObj);
      }
    }
  }
  
  // Bewegung des Spielers
  /**
   * @param x bewegen auf x-Koordinate
   * @param y bewegen auf y-Koordinate
   * @param spObj ist das SpielObjekt = der Spieler
   * ## Die move() Methode laesst den Spieler durch die Karte spazieren.
   * Sie entscheidet durch Pruefen, ob ein Feld passierbar ist.
   * In pruefeKollision() wird die Bewegung entschieden;
   */
  public void move(int x, int y, ArrayList<SpielObjekt> spObj) {
    int Xtemp = this.x;
    int Ytemp = this.y;
    
    this.x += x;
    this.y += y;
    kollisionsFlaeche.setX(this.x);
    kollisionsFlaeche.setY(this.y);
    
    // Kollisionspruefung
    if (!pruefeKollsion(spObj).isEmpty()) {
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
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    
    /**
     * Anhand der Playerposition und Tendenz wird entschieden welche
     * Animationsphase gezeichnet wird. Als erstes checken wir in welche
     * Richtung wir laufen:
     */
    
    // Wenn Vertikalbewegung
    if (y % 32 != 0) {
    
      // wenn Richtung Norden
      if (Ytendency == true) {
      
        zeile = 0;
        
        // die Y-Achse wird also in 8 Pixel Groesse
        spalte = (y % 64) / 8;
        
        System.out.println(spalte);
        
        // wenn Richtung Sueden (quasi wie Norden)
      } else {
        zeile = 2;
        spalte = 7 - ((y % 64) / 8); 
        // die "7-" ist weil die Spalten von rechts
        // gewaehlt werden
      }
      
    }
    
    // Wenn Vertikalbewegung (nochmal Aehnlich)
    if (x % 32 != 0) {
    
      zeile = 1;
      
      // Westen
      if (Xtendency == true) {
      
        // Die ersten 4 Spalten
        spalte = (x % 64) / 16;
        
      } else {
        // Osten
        spalte = ((3 - (x % 64) / 16) + 4); 
        // "3-" siehe Sueden, "+4": zweite 4
        // Spalten
        
      }
    }
    
    /*
     * Hier sollte noch ne Idle-Ani rein (Zeile 3) Dafuer muesste ich theoretisch
     * checken ob der Player auf einem Feldmittelpunkt steht und ob keine
     * (relevante) Taste gedrueckt ist. Falls das der Fall ist starte ich
     * abhaengig von der Richtung in die der Player schaut die entsprechende
     * Animation. Aber jetzt erstmal Heia! :)
     */
    
    g.drawImage(playerSSheet.getSprite(spalte, zeile), x, y);
    g.draw(kollisionsFlaeche);
    g.drawString("X:" + getX() + " Y:" + getY(), 32 + (color - 1) * 128, 460);
  }
  
  /**
   * @return Xtendency
   */
  public boolean isXtendency() {
    return Xtendency;
  }
  
  /**
   * @param xtendency set xtendency
   * ## Der Setter der X-Tendency, also die Tendenz auf der X-Achse.
   */
  public void setXtendency(boolean xtendency) {
    Xtendency = xtendency;
  }
  
  /**
   * @return Ytendency
   */
  public boolean isYtendency() {
    return Ytendency;
  }
  
  /**
   * @param ytendency set ytendency
   * ## Der Setter der Y-Tendency, also die Tendenz auf der y-Achse.
   */
  public void setYtendency(boolean ytendency) {
    Ytendency = ytendency;
  }
  
  /**
   * @return up
   */
  public int getUp() {
    return up;
  }
  
  /**
   * @param up set up
   * ## Der Setter fuer nach oben.
   */
  public void setUp(int up) {
    this.up = up;
  }
  
  /**
   * @return left
   */
  public int getLeft() {
    return left;
  }
  
  /**
   * @param left set left
   * ## Der Setter fuer nach unten.
   */
  public void setLeft(int left) {
    this.left = left;
  }
  
  /**
   * @return down
   */
  public int getDown() {
    return down;
  }
  
  /**
   * @param down set down
   * ## Der Setter fuer nach unten.
   */
  public void setDown(int down) {
    this.down = down;
  }
  
  /**
   * @return right
   */
  public int getRight() {
    return right;
  }
  
  /**
   * @param right set right
   * ## Der Setter fuer nach rechts.
   */
  public void setRight(int right) {
    this.right = right;
  }
  
  /**
   * @return bomb
   */
  public int getBomb() {
    return bomb;
  }
  
  /**
   * @param bomb set bomb
   * ## Der Setter fuer die Bombe.
   */
  public void setBomb(int bomb) {
    this.bomb = bomb;
  }
  
  /**
   * @param left set left
   * @param right set right
   * @param up set up
   * @param down set down
   * @param bomb set bomb
   * @param ## Die Tastenbelegung wird initialisiert durch setKeys() Methode.
   */
  public void setKeys(int left, int right, int up, int down, int bomb) {
    this.left = left;
    this.right = right;
    this.up = up;
    this.down = down;
    this.bomb = bomb;
  }
}