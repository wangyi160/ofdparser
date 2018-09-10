package ofd.complextype;

import java.util.List;
import java.util.Set;

public class Document {

	private CommonData commonData ; // must
	private List<PageNode> pages; // must
	
	private List<OutlineElem> outlines;
	//private Set<Permission> permissions;

	
	
	//private List<Action> actions;
	//private Set<Preference> vPreferences;
	
	//private Set<Bookmark> bookmarks;
	//private String annotations;
	//private String customTags;
	//private String attachments;
	//private String extensions;
	
	public CommonData getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonData commonData) {
		this.commonData = commonData;
	}

	public List<PageNode> getPages() {
		return pages;
	}

	public void setPages(List<PageNode> pages) {
		this.pages = pages;
	}

	public List<OutlineElem> getOutlines() {
		return outlines;
	}

	public void setOutlines(List<OutlineElem> outlines) {
		this.outlines = outlines;
	}
	
}
