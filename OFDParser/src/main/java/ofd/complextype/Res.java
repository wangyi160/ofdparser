package ofd.complextype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;

public class Res {

	private String baseLoc; // must
	
	private List<ColorSpace> colorSpaces;
	private List<Font> fonts;
	private List<MultiMedia> multiMedias;
	
	private Map<String, PdfFont> fontMap = new HashMap<>();
	private Map<String, PdfImageXObject> imageMap = new HashMap<>();
	
	public String getBaseLoc() {
		return baseLoc;
	}
	public void setBaseLoc(String baseLoc) {
		this.baseLoc = baseLoc;
	}
	public List<ColorSpace> getColorSpaces() {
		return colorSpaces;
	}
	public void setColorSpaces(List<ColorSpace> colorSpaces) {
		this.colorSpaces = colorSpaces;
	}
	public List<Font> getFonts() {
		return fonts;
	}
	public void setFonts(List<Font> fonts) {
		this.fonts = fonts;
	}
	public List<MultiMedia> getMultiMedias() {
		return multiMedias;
	}
	public void setMultiMedias(List<MultiMedia> multiMedias) {
		this.multiMedias = multiMedias;
	}
	public Map<String, PdfFont> getFontMap() {
		return fontMap;
	}
	public void setFontMap(Map<String, PdfFont> fontMap) {
		this.fontMap = fontMap;
	}
	public Map<String, PdfImageXObject> getImageMap() {
		return imageMap;
	}
	public void setImageMap(Map<String, PdfImageXObject> imageMap) {
		this.imageMap = imageMap;
	}
	
	
	
	
	
}
