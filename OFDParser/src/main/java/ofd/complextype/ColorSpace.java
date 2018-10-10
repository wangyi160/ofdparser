package ofd.complextype;

public class ColorSpace {

	private String type="RGB"; // must
	
	private String id;
	private int bitsPerComponent=8;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBitsPerComponent() {
		return bitsPerComponent;
	}

	public void setBitsPerComponent(int bitsPerComponent) {
		this.bitsPerComponent = bitsPerComponent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	} 
	
	
	
}
