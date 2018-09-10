package ofd.complextype;

import ofd.simpletype.Box;

public class PageArea {

	private Box physicalBox; // must
	
	private Box applicationBox;
	private Box contentBox;
	private Box bleedBox;
	
	
	public Box getPhysicalBox() {
		return physicalBox;
	}
	public void setPhysicalBox(Box physicalBox) {
		this.physicalBox = physicalBox;
	}
	public Box getApplicationBox() {
		return applicationBox;
	}
	public void setApplicationBox(Box applicationBox) {
		this.applicationBox = applicationBox;
	}
	public Box getContentBox() {
		return contentBox;
	}
	public void setContentBox(Box contentBox) {
		this.contentBox = contentBox;
	}
	public Box getBleedBox() {
		return bleedBox;
	}
	public void setBleedBox(Box bleedBox) {
		this.bleedBox = bleedBox;
	}
	
	
	
	
	
}
