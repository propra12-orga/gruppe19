import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Menu extends BasicGameState{   
  
  Image background;
  Image play;
  Image exit;
  int stateID = 0;

  public Menu( int stateID ) 
  {
     this.stateID = stateID;
  }

  public int getID() {
      return stateID;
  }

  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
      //laedt images fuer Bilder und Buttons
      background = new Image("res/menubackground.jpg");
      exit = new Image("res/exitGame.png");
      play = new Image("res/playnow.png");
  }


  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    //Bilder und Buttons mit Position rendern
    background.draw(0,0);
    play.draw(250,100);
    exit.draw(250,200);
  }


  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
     int posX = Mouse.getX();
     int posY = Mouse.getY();
     //abfrage ob Maus auf play button
     if ((posX>250 && posX<461) && (posY>209 && posY<260)){
       if (Mouse.isButtonDown(0)){
         //Spiel wird gestartet
         sbg.enterState(1);
         }
       }
     //abfrage ob Maus auf exit button
     if ((posX>250 && posX<461) && (posY>109 && posY<160)){
       if (Mouse.isButtonDown(0)){
         System.exit(0);
        }
     }
  }

}
