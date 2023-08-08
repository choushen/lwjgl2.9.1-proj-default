package renderEngine;

/*
 * Class to represent a 3D model stored in memory
 */

public class RawModel {

	private int _vaoID; // ID to target later
	private int _vertexCount; // Number of vertices of the model
	
	
	// Create a simple constructor and initialise the variables
	public RawModel(int vaoID, int vertexCount)
	{
		this._vaoID = vaoID;
		this._vertexCount = vertexCount;
	}


	public int get_vaoID() {
		return _vaoID;
	}


	public int get_vertexCount() {
		return _vertexCount;
	}
	
	
	
}
