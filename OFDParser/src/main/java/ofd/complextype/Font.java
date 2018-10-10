package ofd.complextype;

public class Font {

	private String fontName; // must
	
	private String familyName;
	private String charSet="unicode";
	private String fontFile;
	private String id;
	
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	public String getFontFile() {
		return fontFile;
	}
	public void setFontFile(String fontFile) {
		this.fontFile = fontFile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
