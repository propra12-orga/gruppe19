package de.game.bomberman;

import org.newdawn.slick.*;

/**
 * Die Klasse "Bombe" ist fuer das Erstellen der Bombe im Spiel zustaendig.
 * Hier steht Image der Bombe, der Radius der Bombe, die Eigenschaft der Bombe, der Zustand, 
 * ob die Bombe explodiert ist oder nicht und der Zaehler der Bombe fuer die Explosion.
 */
public class Bombe extends SpielObjekt {
  
    //Image der Bombe; wird aus "res" geladen
  private static String imPath = "res/bomb.png";
  
    //Radius der Explosion
  private int ExplodeRadius = 2;                            
  private Image im;
  
  SpriteSheet eggSheet = new SpriteSheet("res/egg.png", 32, 32);
  
    //regelt die Zeit wann Bomben explodieren
  private int counter;                                      
  private boolean explode;
  private Player player;
  
  /**
   * Der Explosionsradius prueft die Felder. 
   * - Entweder die sind frei,
   * dann wird die Explosionsgrafik dorthin gezeichnet; die Explosion "breitet" sich aus.
   * - Oder die sind nicht frei,
   * dann wird dort keine Explosionsgrafik gezeichnet, folglich keine Explosionsausbreitung zu sehen.
   * @return the ExplodeRadius
   */
  public int getExplodeRadius() {
    return ExplodeRadius;
  }

  /**
   * Der Setter fuer explodeRadius.
   * @param ExplodeRadius the explodeRadius to set
   */
  public void setExplodeRadius(int explodeRadius) {
    ExplodeRadius = explodeRadius;
  }
  
  
  /**
   * Mit diesen Koordinaten wird die Bombe im Spiel plaziert. Weiterhin wird hier das Image der Bombe geladen.
   * Der Counter wird gleichzeitig auf 0 gesetzt.
   * In der draw() Methode wird dann das Image auf die Koordinaten x, y gezeichnet.
   * In der update() Methode wird dann der Zaehler der Bombe stetig erhoeht, bis auf Maximum (in diesem Fall 200), welches dann die Bombe durch den Setter
   * auf true setzt --> Explosion!
   * @param x Koordinate der Bombe
   * @param y Koordinate der Bombe
   * @throws SlickException
   */
  public Bombe(int x, int y, Player pl) throws SlickException {
    super(x, y);
    im = new Image(imPath);
    explode = false;
    counter = 0;
    this.setPlayer(pl);
    this.ExplodeRadius = pl.getBombRadius();
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#draw(org.newdawn.slick.Graphics)
   */
  public void draw(Graphics g) {
    if(!explode) im.draw(x, y);
  }

  /**
   * Gibt explode zurueck, dh gibt false aus. "false" steht fuer neutral --> Bombe nicht explodiert.
   * In der update() Methode wird dann der Setter, falls er aufgerufen wird, explode auf true setzen --> Explosion!
   * @return explode
   */
  public boolean isExplode() {
    return explode;
  }
  
  /**
   * Der Setter fuer explode.
   * @param explode to set
   */
  public void setExplode(boolean explode) {
    this.explode = explode;
  }
  
  @Override
  /* 
   * @see de.game.bomberman.SpielObjekt#update(int)
   */
  public void update(int delta) throws SlickException {
    counter+=1;    // counter += 1: if counter==130 --> Bombe explodiert
    
    im = eggSheet.getSprite((counter /16),0);
    
    if(counter==150){
      setExplode(true);
    }
  }

  /**
   * @return the player
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * @param player the player to set
   */
  public void setPlayer(Player player) {
    this.player = player;
  }
}
