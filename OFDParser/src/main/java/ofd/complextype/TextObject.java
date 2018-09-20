package ofd.complextype;

import java.util.List;

import ofd.simpletype.Box;

public class TextObject extends Block {

	private Box boundary; //must 
	
	private String font; // must
	private double size; // must
	private List<TextCode> textCode; // must
			
	private double miterLimit;
	private Color fillColor;
	private String id;
	
	
	public TextObject()
	{
		this.type="CT_Text";
	}


	public Box getBoundary() {
		return boundary;
	}


	public void setBoundary(Box boundary) {
		this.boundary = boundary;
	}


	public String getFont() {
		return font;
	}


	public void setFont(String font) {
		this.font = font;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double size) {
		this.size = size;
	}


	public List<TextCode> getTextCode() {
		return textCode;
	}


	public void setTextCode(List<TextCode> textCode) {
		this.textCode = textCode;
	}


	public double getMiterLimit() {
		return miterLimit;
	}


	public void setMiterLimit(double miterLimit) {
		this.miterLimit = miterLimit;
	}


	public Color getFillColor() {
		return fillColor;
	}


	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
