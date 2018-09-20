package ofd.complextype;

import java.util.List;

public class Layer {

	private LayerType type = LayerType.Body;
	private String drawParam;
	private List<Block> pageBlocks;
	
	
	public LayerType getType() {
		return type;
	}
	public void setType(LayerType type) {
		this.type = type;
	}
	public String getDrawParam() {
		return drawParam;
	}
	public void setDrawParam(String drawParam) {
		this.drawParam = drawParam;
	}
	public List<Block> getPageBlocks() {
		return pageBlocks;
	}
	public void setPageBlocks(List<Block> pageBlocks) {
		this.pageBlocks = pageBlocks;
	}
	
	
	
}
