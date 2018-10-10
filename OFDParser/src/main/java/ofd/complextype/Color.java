package ofd.complextype;

public class Color {

	private float[] value;
	private ColorSpace colorSpace=new ColorSpace(); // 对应res中的colorspace ID, 默认RGB
	
	public float[] getValue() {
		return value;
	}
	public void setValue(float[] value) {
		this.value = value;
	}
	public ColorSpace getColorSpace() {
		return colorSpace;
	}
	public void setColorSpace(ColorSpace colorSpace) {
		this.colorSpace = colorSpace;
	}
	
	
	
	
}
