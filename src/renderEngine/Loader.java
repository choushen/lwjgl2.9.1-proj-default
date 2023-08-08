package renderEngine;

import java.nio.FloatBuffer;
import java.util.List;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

/*
 * A class to load a 3D model into memory by storing positional data about the model in a VAO 
 */

import org.lwjgl.opengl.GL30;

public class Loader {

	// PROPERTIES
	
	private List<Integer> _vaos = new ArrayList<Integer>();
	private List<Integer> _vbos = new ArrayList<Integer>();
	
	
	// METHODS
	
	/*
	 * Creates and binds the VAO
	 */
	private int createVAO() 
	{
		int vaoID = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vaoID);
		return vaoID;
	}
	
	
	/*
	 * Adds the VBO to the VAO
	 */
	private void storeDataInAttributeList(int attributeNumber, float[] data) 
	{
		int vboID = GL15.glGenBuffers();
		_vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInFloatBuffer(data); // Create a float buffer with our data in it
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);// Store the float buffer into the VBO
		GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0); // attribute number (position in the list): attributeNumber, the size (3 because there are 3 vertices, type of data: float, normalise data: false, distance between vertices (anything between them), offset (should it start at the beginning of the data?)
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	
	/*
	 * Unbinds the VAO once we're done with it
	 */
	private void unbindVAO() 
	{
		GL30.glBindVertexArray(0); // Currently the attribute number is set to 0
	}
	
a
	/*
	 * Convert float array data into a float buffer
	 */
	private FloatBuffer storeDataInFloatBuffer(float[] data) 
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data); // add the data to the buffer
		buffer.flip(); // prepares the buffer to be read from
		return buffer; // returns the buffer to be stored into the VBO
	}
	
	
	// Takes positions of the models vertices
	public RawModel loadToVAO(float[] positions) {
		int vaoID = createVAO(); // create the VAO and get the ID
		_vaos.add(vaoID);
		storeDataInAttributeList(0, positions);
		unbindVAO();
		return new RawModel(vaoID, positions.length/3); // each vertex has 3 floats so divide by 3
	}
	
	public void cleanUp()
	{
		for(int vao:_vaos) 
		{
			GL30.glDeleteVertexArrays(vao);
		}
		
		for(int vbo:_vbos) 
		{
			GL15.glDeleteBuffers(vbo);
		}
		
	}
	
}
