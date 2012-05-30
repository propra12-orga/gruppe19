/*
 * Hier sollten wir testen, wie wir ein StateBasedGame realisieren können.
 * Es fehlt unbedingt eine richtige Benutzung der "enterState" Funktion in der MainMenuState Klasse!
 * Unser Programm sollten wir so abändern, dass es auf ein StateBasedGame basiert, anstelle eines "BasicGames"
 * Aber zuerst noch die Meilensteine nachholen! ;)
 */

package stateBasedGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class Bomberman extends StateBasedGame {
 
    public static final int MAINMENUSTATE          = 0;
    public static final int GAMEPLAYSTATE          = 1;
 
    public Bomberman()
    {
        super("BOMBERMAN");
 
        this.addState(new MainMenuState(MAINMENUSTATE));
        this.addState(new GameplayState(GAMEPLAYSTATE));
        this.enterState(MAINMENUSTATE);
    }
 
    public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new Bomberman());
 
         app.setDisplayMode(800, 600, false);
         app.start();
    }
 
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
 
        this.getState(MAINMENUSTATE).init(gameContainer, this);
        this.getState(GAMEPLAYSTATE).init(gameContainer, this);
    }
}