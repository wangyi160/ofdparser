package ofd.complextype;

public class TextCode {

	private String text; // must
	
	private float x = -1;
	private float y = -1;
	private float[] deltaX;
	private float[] deltaY;
	
	
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
	public float[] getDeltaX() {
		return deltaX;
	}
	public void setDeltaX(float[] deltaX) {
		this.deltaX = deltaX;
	}
	public float[] getDeltaY() {
		return deltaY;
	}
	public void setDeltaY(float[] deltaY) {
		this.deltaY = deltaY;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
