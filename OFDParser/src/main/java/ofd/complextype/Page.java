package ofd.complextype;

import java.util.List;
import java.util.Set;

public class Page {
	
	private PageArea area;
	
	//private Set<TemplatePage> template;
	
	//private String pageRes;
	private List<Layer> content;
	//private List<Action> actions;

	public PageArea getArea() {
		return area;
	}

	public void setArea(PageArea area) {
		this.area = area;
	}

	public List<Layer> getContent() {
		return content;
	}

	public void setContent(List<Layer> content) {
		this.content = content;
	}
	
	
	
	
}
