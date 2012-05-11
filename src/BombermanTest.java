import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class BombermanTest extends BasicGame {

	private float playerX = 20;
	private float playerY = 20;
	private TiledMap map;
	private Animation player;

	public BombermanTest() {
		super("BOMBASTISCHER MANN");
	}

	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		SpriteSheet sheet = new SpriteSheet("res/bomberman1.png", 32, 32);
		map = new TiledMap("res/testmap2.tmx");
		player = new Animation();
		player.setAutoUpdate(true);
		for (int frame = 0; frame < 3; frame++) {
			player.addFrame(sheet.getSprite(frame, 0), 150);
		}
	}

	// Steuerung (Very Basic!)

	public void update(GameContainer container, int delta) {
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
			playerX--;
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) {
			playerX++;
		}
		if (container.getInput().isKeyDown(Input.KEY_UP)) {
			playerY--;
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) {
			playerY++;
		}
	}

	public void render(GameContainer container, Graphics g) {
		map.render(0, 0);
		g.drawAnimation(player, playerX, playerY);
	}

	public static void main(String[] argv) throws SlickException {
		AppGameContainer container = new AppGameContainer(new BombermanTest(),
				640, 480, true);
		container.start();
	}
}