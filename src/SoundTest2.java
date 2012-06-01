import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SoundTest2 extends BasicGame {
  public static void main(String[] args) throws SlickException {
    new AppGameContainer(new SoundTest2(), 800, 600, false).start();
  }
  
  public SoundTest2() {
    super("TestClass");
  }
  
  Sound sound;
  
  public void init(GameContainer c) throws SlickException {
    sound = new Sound("res/sfx/sfxtest.wav");
  }
  
  public void render(GameContainer c, Graphics g) throws SlickException {
    
  }
  
  public void update(GameContainer c, int delta) throws SlickException {
    if (c.getInput().isKeyPressed(Input.KEY_1)) {
      sound.stop();
      sound.play(1f, 1f);
      System.out.println(1);
    } else if (c.getInput().isKeyPressed(Input.KEY_2)) {
      sound.stop();
      sound.play(1f, 0.5f);
      System.out.println(2);
    } else if (c.getInput().isKeyPressed(Input.KEY_3)) {
      sound.stop();
      sound.play(1f, 0.1f);
      System.out.println(3);
    }
  }
}