package ofd.complextype;

import java.util.List;

import ofd.simpletype.Box;

public class TextObject extends Block {

	private Box boundary; //must 
	
	private String font; // must
	private float size; // must
	private List<TextCode> textCode; // must
			
	private float miterLimit = -1;
	private Color fillColor;
	private String id;
	
	
	public TextObject()
	{
		this.type="CT_Text";
		
		// 默认fillcolor为rgb，000
		fillColor=new Color();
		float[] value= {0,0,0};
		fillColor.setValue(value);
		fillColor.setColorSpace(new ColorSpace());
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


	public float getSize() {
		return size;
	}


	public void setSize(float size) {
		this.size = size;
	}


	public List<TextCode> getTextCode() {
		return textCode;
	}


	public void setTextCode(List<TextCode> textCode) {
		this.textCode = textCode;
	}


	public float getMiterLimit() {
		return miterLimit;
	}


	public void setMiterLimit(float miterLimit) {
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
