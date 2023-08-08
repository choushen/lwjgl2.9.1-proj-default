package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/*
 * A class to render a model from the VAO
 */

public class Renderer
{

	
	
	/*
	 * Called once every frame; tells OpenGL to render the game
	 */
	public void prepare()
	{
		GL11.glClearColor(1, 0, 0, 1);// Clears the colour from the last frame
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	
	public void render(RawModel model)
	{
		GL30.glBindVertexArray(model.get_vaoID());
		GL20.glEnableVertexAttribArray(0); // Data is in attribute list 0
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.get_vertexCount()); // Shape to render, where to start, number of vertices
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}
	
}
