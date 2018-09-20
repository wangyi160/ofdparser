package ofd.complextype;

public class TextCode {

	private String text; // must
	
	private double x;
	private double y;
	private double[] deltaX;
	private double[] deltaY;
	
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double[] getDeltaX() {
		return deltaX;
	}
	public void setDeltaX(double[] deltaX) {
		this.deltaX = deltaX;
	}
	public double[] getDeltaY() {
		return deltaY;
	}
	public void setDeltaY(double[] deltaY) {
		this.deltaY = deltaY;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
