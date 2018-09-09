package ofd.complextype;

import java.util.List;
import java.util.Set;

public class Document {

	private CommonData commonData;
	private Set<Page> pages;
	
	private Set<OutlineElem> outlines;
	private Set<Permission> permissions;
	
	private List<Action> actions;
	private Set<Preference> vPreferences;
	
	private Set<Bookmark> bookmarks;
	private String annotations;
	private String customTags;
	private String attachments;
	private String extensions;
	
}
