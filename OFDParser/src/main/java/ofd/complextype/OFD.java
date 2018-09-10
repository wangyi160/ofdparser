package ofd.complextype;

import java.util.Set;

public class OFD {
	
	private String version;
	private String docType;
	private Set<DocBody> docBodies;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Set<DocBody> getDocBodies() {
		return docBodies;
	}
	public void setDocBodies(Set<DocBody> docBodies) {
		this.docBodies = docBodies;
	}
	
	
	
	
		
}
