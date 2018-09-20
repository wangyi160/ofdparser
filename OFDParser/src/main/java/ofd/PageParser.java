package ofd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import dom.DomUtil;
import ofd.complextype.Block;
import ofd.complextype.Color;
import ofd.complextype.EventType;
import ofd.complextype.Layer;
import ofd.complextype.LayerType;
import ofd.complextype.OFD;
import ofd.complextype.OutlineElem;
import ofd.complextype.Page;
import ofd.complextype.PageArea;
import ofd.complextype.PageNode;
import ofd.complextype.TextCode;
import ofd.complextype.TextObject;
import ofd.simpletype.Box;
import text.TextUtil;
import xml.XMLUtil;

public class PageParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		Page page=makePage("ofdunzipfiles/ReaderManual/Doc_0/Pages/Page_4/Content.xml");
		
		TextObject to5=null;//=(TextObject)page.getContent().get(0).getPageBlocks().get(5);
		
		for(int i=0;i<page.getContent().get(0).getPageBlocks().size();i++)
		{
			to5=(TextObject)page.getContent().get(0).getPageBlocks().get(i);
			
			if(to5.getId().equals("551"))
			{
				String utf8=to5.getTextCode().get(0).getText();
				
				String unicode=TextUtil.utf8ToUnicode(utf8);
				
				System.out.println(unicode);
			}
			
		}
		
		//System.out.println(to5.getTextCode().get(0).getText());		
		
		//System.out.println(page.getContent().get(0).getPageBlocks().get(3));
	}
	
	public static final String docNS = "http://www.ofdspec.org";
	
	public static Page makePage(String baseLoc) throws ParserConfigurationException, SAXException, IOException
	{
		Page page=new Page();
		
		Document document = XMLUtil.getDocument(baseLoc);  
		Element e = document.getDocumentElement();
		
		//System.out.println(e.getNodeName());
		
		List<Node> list = DomUtil.getElementsByTagNameNS(e, docNS, "Area");  
		page.setArea(DocumentParser.makePageArea( list.get(0)));
		
		list = DomUtil.getElementsByTagNameNS(e, docNS, "Content");
		
		if(list.size()>0)
		{
			list = DomUtil.getElementsByTagNameNS(list.get(0), docNS, "Layer");  
			List<Layer> content=new ArrayList<>();
			for(int i=0;i<list.size();i++)
			{
				Layer layer=makeLayer( list.get(i));
				content.add(layer);
			}
			
			page.setContent(content);
		}
		
				
		return page;
	}

	private static Layer makeLayer(Node node)
	{
		
		Layer layer=new Layer();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		if(attrMap.getNamedItem("Type")!=null)
		{
			if(attrMap.getNamedItem("Type").getNodeValue().equals("Body"))
				layer.setType(LayerType.Body);
			else if(attrMap.getNamedItem("Type").getNodeValue().equals("Foregrounnd"))
				layer.setType(LayerType.Foreground);
			else 
				layer.setType(LayerType.Background);
		}
			
		if(attrMap.getNamedItem("DrawParam")!=null)
			layer.setDrawParam(attrMap.getNamedItem("DrawParam").getNodeValue());
		
		Set<String> tagNames=new HashSet<String>();
		tagNames.add("TextObject");
		tagNames.add("PathObject");
		tagNames.add("ImageObject");
		tagNames.add("CompositeObject");
		tagNames.add("PageBlock");
		
		
		List<Node> list = DomUtil.getElementsByTagNameNS(node, docNS, tagNames);
		List<Block> blocks=new ArrayList<>();
		for(int i=0;i<list.size();i++)
		{
			Block block=null;
			
			if(list.get(i).getNodeName().indexOf("TextObject")>0)
			{
				block=makeTextObject(list.get(i));
			}
			blocks.add(block);
		}
		
		layer.setPageBlocks(blocks);
		
		return layer;
		
	}
	
	private static TextObject makeTextObject(Node node)
	{
		
		TextObject textObject=new TextObject();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		textObject.setBoundary(new Box(attrMap.getNamedItem("Boundary").getTextContent()));
		textObject.setFont(attrMap.getNamedItem("Font").getTextContent());
		textObject.setSize(Double.parseDouble(attrMap.getNamedItem("Size").getTextContent()));
		
		// MITERLIMIT attr
		if(attrMap.getNamedItem("MiterLimit")!=null)
			textObject.setMiterLimit(Double.parseDouble(attrMap.getNamedItem("MiterLimit").getTextContent()));
		
		// ID attr
		if(attrMap.getNamedItem("ID")!=null)
			textObject.setId(attrMap.getNamedItem("ID").getTextContent());
		
		// TEXTCODE
		List<Node> list = DomUtil.getElementsByTagNameNS(node, docNS, "TextCode");  
		List<TextCode> textCodes=new ArrayList<>();
		
		for(int i=0;i<list.size();i++)
		{
			TextCode textCode=makeTextCode(list.get(i));
			textCodes.add(textCode);
		}
		
		textObject.setTextCode(textCodes);
		
		// FILLCOLOR
		list = DomUtil.getElementsByTagNameNS(node, docNS, "FillColor");  
		if(list.size()>0)
		{
			textObject.setFillColor(makeColor(list.get(0)));
		}
		
		
		
		return textObject;
		
	}
	
	private static TextCode makeTextCode(Node node)
	{
		TextCode textCode=new TextCode();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		textCode.setText(node.getTextContent());
		
		if(attrMap.getNamedItem("X")!=null)
			textCode.setX(Double.parseDouble(attrMap.getNamedItem("X").getTextContent()));
		
		if(attrMap.getNamedItem("Y")!=null)
			textCode.setY(Double.parseDouble(attrMap.getNamedItem("Y").getTextContent()));
		
		if(attrMap.getNamedItem("DeltaX")!=null)
		{
			String[] parts=attrMap.getNamedItem("DeltaX").getTextContent().split(" ");
			double[] deltaX=new double[parts.length];
			
			for(int i=0;i<parts.length;i++)
			{
				deltaX[i]=Double.parseDouble(parts[i]);
			}
			
			textCode.setDeltaX(deltaX);
		}
		
		if(attrMap.getNamedItem("DeltaY")!=null)
		{
			String[] parts=attrMap.getNamedItem("DeltaY").getTextContent().split(" ");
			double[] deltaY=new double[parts.length];
			
			for(int i=0;i<parts.length;i++)
			{
				deltaY[i]=Double.parseDouble(parts[i]);
			}
			
			textCode.setDeltaY(deltaY);
		}
			
		
		return textCode;
	}
	
	private static Color makeColor(Node node)
	{
		Color color=new Color();
		
		NamedNodeMap attrMap=node.getAttributes();
		
		if(attrMap.getNamedItem("Value")!=null)
		{
			String[] parts=attrMap.getNamedItem("Value").getTextContent().split(" ");
			int[] value=new int[parts.length];
			
			for(int i=0;i<parts.length;i++)
			{
				value[i]=Integer.parseInt(parts[i]);
			}
			
			color.setValue(value);
		}
		
		if(attrMap.getNamedItem("ColorSpace")!=null)
		{
			color.setColorSpace(attrMap.getNamedItem("ColorSpace").getTextContent());
		}
		
		return color;
	}
	
}












