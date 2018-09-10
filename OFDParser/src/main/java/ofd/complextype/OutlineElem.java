package ofd.complextype;

import java.util.List;

public class OutlineElem {

	private String title; // must
	
	private int count;
	private boolean expanded;
	private List<Action> actions;
	private List<OutlineElem> outlineElem;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public List<OutlineElem> getOutlineElem() {
		return outlineElem;
	}
	public void setOutlineElem(List<OutlineElem> outlineElem) {
		this.outlineElem = outlineElem;
	}
	
	
	
	
}
