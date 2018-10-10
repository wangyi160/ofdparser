package ofd;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;

import dom.DomUtil;
import ofd.complextype.Color;
import ofd.complextype.ColorSpace;
import ofd.complextype.DocBody;
import ofd.complextype.Font;
import ofd.complextype.MultiMedia;
import ofd.complextype.OFD;
import ofd.complextype.Res;
import xml.XMLUtil;

public class ResourceParser {

	public static final String docNS = "http://www.ofdspec.org";
	
	public static Map<String, PdfFont> fontMap = new HashMap<>();
	public static Map<String, PdfImageXObject> imageMap = new HashMap<>();
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ParseException {
		// TODO Auto-generated method stub
		Res res=makeResource("ofdunzipfiles/ReaderManual/Doc_0/PublicRes.xml");
		
//		for(MultiMedia mm: res.getMultiMedias())
//		{
//			System.out.println(mm.getId()+":"+mm.getMediaFile());
//		}
		for(ColorSpace cs: res.getColorSpaces())
			System.out.println(cs);
		
	}
	
	// 解析ofdxml文件获取OFD结构体信息
	public static Res makeResource(String resxml) throws ParserConfigurationException, SAXException, IOException, ParseException
	{
		Document document = XMLUtil.getDocument(resxml);  
		Element e = document.getDocumentElement();
		
		
		Res res=new Res();
		
		NamedNodeMap attrMap=e.getAttributes();
		
		// baseloc
		res.setBaseLoc(attrMap.getNamedItem("BaseLoc").getNodeValue());
		
		
		List<Node> list = DomUtil.getElementsByTagNameNS(e, docNS, "ColorSpaces");
		List<ColorSpace> colorSpaces=new ArrayList<>();
		
		for(int i=0;i<list.size();i++)
		{
			Node node=list.get(i);
			
			ColorSpace cs=makeColorSpace(node);
			colorSpaces.add(cs);
		}
		
		// colorspaces
		res.setColorSpaces(colorSpaces);
		
		
		list = DomUtil.getElementsByTagNameNS(e, docNS, "Fonts");
		
		if(list.size()>0)
		{
			list = DomUtil.getElementsByTagNameNS(list.get(0), docNS, "Font");
			
			List<Font> fonts=new ArrayList<>();
			
			for(int i=0;i<list.size();i++)
			{
				Node node=list.get(i);
				
				Font font=makeFont(node);
				fonts.add(font);
			}
			
			// fonts
			res.setFonts(fonts);
		}
		
		
		list = DomUtil.getElementsByTagNameNS(e, docNS, "MultiMedias");
		
		if(list.size()>0)
		{
			list = DomUtil.getElementsByTagNameNS(list.get(0), docNS, "MultiMedia");
			
			List<MultiMedia> multiMedias=new ArrayList<>();
			
			for(int i=0;i<list.size();i++)
			{
				Node node=list.get(i);
				
				MultiMedia multiMedia=makeMultiMedia(node);
				multiMedias.add(multiMedia);
			}
			
			// fonts
			res.setMultiMedias(multiMedias);
		}
		
		// 后继处理，生成fontmap和imagemap
		// 宋体
		fontMap.put("宋体", PdfFontFactory.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,0", PdfEncodings.IDENTITY_H, false));
		
		// times new roman
		fontMap.put("Times New Roman", PdfFontFactory.createFont("C:/WINDOWS/Fonts/TIMES.TTF", PdfEncodings.IDENTITY_H, false));
		
		// calibri
		fontMap.put("Calibri", PdfFontFactory.createFont("C:/WINDOWS/Fonts/CALIBRI.TTF", PdfEncodings.IDENTITY_H, false));
		
		// 宋体 bold
		fontMap.put("386", PdfFontFactory.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,0", PdfEncodings.IDENTITY_H, false));
		
		// ARIAL bold
		fontMap.put("Arial Bold", PdfFontFactory.createFont("C:/WINDOWS/Fonts/ARIALBD.TTF", PdfEncodings.IDENTITY_H, false));
		
		// wingdings
		fontMap.put("Wingdings", PdfFontFactory.createFont("C:/WINDOWS/Fonts/WINGDING.TTF", PdfEncodings.IDENTITY_H, false));
		
		// arial
		fontMap.put("Arial", PdfFontFactory.createFont("C:/WINDOWS/Fonts/ARIAL.TTF", PdfEncodings.IDENTITY_H, false));
		
		// times new roman bold
		fontMap.put("Times New Roman Bold", PdfFontFactory.createFont("C:/WINDOWS/Fonts/TIMESBD.TTF", PdfEncodings.IDENTITY_H, false));
		
		// 黑体
		fontMap.put("黑体", PdfFontFactory.createFont("C:/WINDOWS/Fonts/SIMHEI.TTF", PdfEncodings.IDENTITY_H, false));
		
		// 获取文件路径前缀\
		int lastIndex=resxml.lastIndexOf("/");
		String pathPrefix=resxml.substring(0, lastIndex);
		
		for(Font font: res.getFonts())
		{
			//System.out.println(font.getId()+":"+font.getFontName()+","+font.getFontName());
			
			if(font.getFontFile()==null)
			{
				res.getFontMap().put(font.getId(), fontMap.get(font.getFontName()));
			}
			else
			{
				PdfFont pdfFont=PdfFontFactory.createFont(pathPrefix+"/"+res.getBaseLoc()+"/"+font.getFontFile(), PdfEncodings.IDENTITY_H, true);
				res.getFontMap().put(font.getId(), pdfFont);
			}
		}
		
		for(MultiMedia multiMedia: res.getMultiMedias())
		{
			if(multiMedia.getType().equals("Image"))
			{
				PdfImageXObject pdfImageObject=new PdfImageXObject(ImageDataFactory.create(pathPrefix+"/"+res.getBaseLoc()+"/"+multiMedia.getMediaFile()));
				res.getImageMap().put(multiMedia.getId(), pdfImageObject );
			}
		}

		return res;
	}
	
	private static ColorSpace makeColorSpace(Node node) throws ParseException
	{
		ColorSpace colorSpace=new ColorSpace();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		if(attrMap.getNamedItem("ID")!=null)
		{
			colorSpace.setId(attrMap.getNamedItem("ID").getTextContent());
		}
		
		if(attrMap.getNamedItem("Type")!=null)
		{
			colorSpace.setType(attrMap.getNamedItem("Type").getTextContent());
		}
		
		if(attrMap.getNamedItem("BitsPerComponent")!=null)
		{
			colorSpace.setBitsPerComponent(Integer.parseInt(attrMap.getNamedItem("BitsPerComponent").getTextContent()));
		}
		
		return colorSpace;
	}
	
	private static Font makeFont(Node node) throws ParseException
	{
		Font font=new Font();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		font.setFontName(attrMap.getNamedItem("FontName").getTextContent());
		
		if(attrMap.getNamedItem("ID")!=null)
		{
			font.setId(attrMap.getNamedItem("ID").getTextContent());
		}
		
		if(attrMap.getNamedItem("FamilyName")!=null)
		{
			font.setFamilyName(attrMap.getNamedItem("FamilyName").getTextContent());
		}
		
		if(attrMap.getNamedItem("CharSet")!=null)
		{
			font.setCharSet(attrMap.getNamedItem("CharSet").getTextContent());
		}
		
		
		
		return font;
	}
	
	private static MultiMedia makeMultiMedia(Node node) throws ParseException
	{
		MultiMedia multiMedia=new MultiMedia();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		multiMedia.setType(attrMap.getNamedItem("Type").getTextContent());
				
		if(attrMap.getNamedItem("ID")!=null)
		{
			multiMedia.setId(attrMap.getNamedItem("ID").getTextContent());
		}
		
		List<Node> list = DomUtil.getElementsByTagNameNS(node, docNS, "MediaFile");
		
		Node mediaFileNode=list.get(0);
		String mediaFile=mediaFileNode.getTextContent();
		
		multiMedia.setMediaFile(mediaFile);
		
		return multiMedia;
	}

}















