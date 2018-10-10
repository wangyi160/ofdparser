package ofd.complextype;

import ofd.simpletype.Box;

public class ImageObject extends Block
{
	private String resourceId; // must
	private Box boundary; // must
	
	private String id;
	private float miterLimit = -1;
	private double[] ctm;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public Box getBoundary() {
		return boundary;
	}
	public void setBoundary(Box boundary) {
		this.boundary = boundary;
	}
	public float getMiterLimit() {
		return miterLimit;
	}
	public void setMiterLimit(float miterLimit) {
		this.miterLimit = miterLimit;
	}
	public double[] getCtm() {
		return ctm;
	}
	public void setCtm(double[] ctm) {
		this.ctm = ctm;
	}
	
	
}
