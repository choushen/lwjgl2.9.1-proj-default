package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 144;
	
	
	
	public static void createDisplay() 
	{
		
		
		/*
		 * By creating an OpenGL context with a forward-compatible and core profile, the application is ensuring 
		 * that it is using only the latest and most modern features of OpenGL, while also ensuring that it will 
		 * be compatible with future versions of OpenGL. This can help to ensure that the application will run smoothly 
		 * and efficiently, while also being future-proof
		 * */
		
		ContextAttribs contextAttribs = new ContextAttribs(3, 2); // Takes the version of OpenGL (e.g. 3.2 in this case)
		contextAttribs.withForwardCompatible(true);
		contextAttribs.withProfileCore(true);
		
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), contextAttribs);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Tells OpenGL where in the display it can render the game (top left, top right, bottom left, bottom right)
		GL11.glViewport(0,0, WIDTH, HEIGHT); // Use the whole of the display to render the game
		
	} // createDisplay() end
	
	
	public static void updateDisplay() 
	{
		Display.sync(FPS_CAP); // Synchronises the game to run at a steady FPS
		Display.update();
	}
	
	
	public static void closeDisplay() 
	{
		Display.destroy(); // Closes the display
	}
		
}
