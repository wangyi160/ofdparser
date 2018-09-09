package ofd.complextype;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class DocInfo {

	private String docID; //
	private String title; // 
	private String author;
	private String subject; 
	private String abstract2;
	private Date creationDate; //
	private Date modDate; //
	private String docUsage;
	private String cover;
	private Set<String> keywords;
	private String creator; //
	private String creatorVersion;
	//private Set<CustomData> customDatas;
	
	
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAbstract2() {
		return abstract2;
	}
	public void setAbstract2(String abstract2) {
		this.abstract2 = abstract2;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getDocUsage() {
		return docUsage;
	}
	public void setDocUsage(String docUsage) {
		this.docUsage = docUsage;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Set<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreatorVersion() {
		return creatorVersion;
	}
	public void setCreatorVersion(String creatorVersion) {
		this.creatorVersion = creatorVersion;
	}
	
	
}
