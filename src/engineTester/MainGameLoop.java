package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import renderEngine.RawModel;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DisplayManager.createDisplay(); // Creates the window/display to render the game
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		  float[] vertices = {
				    -0.5f, 0.5f, 0f,
				    -0.5f, -0.5f, 0f,
				    0.5f, -0.5f, 0f,
				    0.5f, -0.5f, 0f,
				    0.5f, 0.5f, 0f,
				    -0.5f, 0.5f, 0f
				  };
		
		  RawModel model = loader.loadToVAO(vertices);
		  
		while (!Display.isCloseRequested()) {
			renderer.prepare(); // call this every frame to load the cube
			// game logic
			renderer.render(model);
			DisplayManager.updateDisplay(); // Update the display every frame
			
		}
		
		loader.cleanUp(); // Clean up once the game closes
		DisplayManager.closeDisplay(); // Closes the display
		
	}

}
