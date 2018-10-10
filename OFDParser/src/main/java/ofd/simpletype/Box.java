package ofd.simpletype;

public class Box {

	private float x;
	private float y;
	private float width;
	private float height;
	
	public Box(String boxString)
	{
		String[] parts=boxString.split(" ");
		
		this.x=Float.parseFloat(parts[0]);
		this.y=Float.parseFloat(parts[1]);
		this.width=Float.parseFloat(parts[2]);
		this.height=Float.parseFloat(parts[3]);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	
	
}
