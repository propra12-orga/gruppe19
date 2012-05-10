import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	public void start() {
		try {
			Display.setTitle("Bomberman");
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
		while (!Display.isCloseRequested()) {
			

			
			Display.update();}
		}
		
	
	public static void main(String[] argv) {
		Main displayExample = new Main();
		displayExample.start();
	}
}

