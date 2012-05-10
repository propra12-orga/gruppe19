import org.lwjgl.LWJGLException;
import org.lwjgl.input.*;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.*;

public class Main {

    public void start() {
        try {
        Display.setTitle("Bomberman");
	    Display.setDisplayMode(new DisplayMode(640, 480));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}      
        
        while (!Display.isCloseRequested()) {
        
	    pollInput();
	    Display.update();
	}

	Display.destroy();
    }

    public void pollInput() {
		
        if (Mouse.isButtonDown(0)) {
	    int x = Mouse.getX();
	    int y = Mouse.getY();
			
	    System.out.println("Mausklick bei X: " + x + " Y: " + y);
	}
		
		
	while (Keyboard.next()) {
	    if (Keyboard.getEventKeyState()) {
	        if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
		    System.out.println("Up Key gedrueckt");
		}
		if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
		    System.out.println("Down Key gedrueckt");
		}
		if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
		    System.out.println("Left Key gedrueckt");
		}
		if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT){
			System.out.println("Right Key gedrueckt");
		}
	    } else {
	        if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
		    System.out.println("Up Key losgelassen");
	        }
	    	if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
		    System.out.println("Down Key losgelassen");
		    }
		    if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
		    System.out.println("Left Key losgelassen");
		    }
		    if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT){
		    System.out.println("Right Key losgelassen");
		    }
	    }
	}
	
    }

    public static void main(String[] argv) {
        Main game = new Main();
	game.start();
    }
}