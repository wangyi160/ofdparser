package ofd.complextype;

import java.util.Set;

public class OFD {
	
	private String version;
	private String docType;
	private Set<DocBody> docBody;
	
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
	public Set<DocBody> getDocBody() {
		return docBody;
	}
	public void setDocBody(Set<DocBody> docBody) {
		this.docBody = docBody;
	}
	
	
	
		
}
