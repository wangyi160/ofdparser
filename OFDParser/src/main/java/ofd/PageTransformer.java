package ofd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.colorspace.PdfColorSpace;
import com.itextpdf.kernel.pdf.colorspace.PdfDeviceCs;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;

import ofd.complextype.Block;
import ofd.complextype.Color;
import ofd.complextype.Document;
import ofd.complextype.ImageObject;
import ofd.complextype.Layer;
import ofd.complextype.Page;
import ofd.complextype.PageArea;
import ofd.complextype.PageNode;
import ofd.complextype.Res;
import ofd.complextype.TextCode;
import ofd.complextype.TextObject;
import ofd.simpletype.Box;

public class PageTransformer {

	public static Map<String, PdfFont> fontMap = new HashMap<>();
	public static Map<String, PdfImageXObject> imageMap = new HashMap<>();
	
	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException, ParseException
	{
		
		
		
		String dest="pdffiles/page1-16.pdf";
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
		
		for(int i=0;i<16;i++)
		{
			
			Res res=ResourceParser.makeResource("ofdunzipfiles/ReaderManual/Doc_0/PublicRes.xml");
			Page page=PageParser.makePage("ofdunzipfiles/ReaderManual/Doc_0/Pages/Page_"+i+"/Content.xml", res);
						
			PdfPage pdfPage=makePdfPage(pdf, page, res);
		}
		
		pdf.close();
	}
	
	public static PdfPage makePdfPage(PdfDocument pdf,Page page, Res res) throws FileNotFoundException
	{
		PdfPage pdfPage = pdf.addNewPage();
		       
        PdfCanvas pdfCanvas = new PdfCanvas(pdfPage);
        
        // 设置页面的大小
        PageArea area=page.getArea();
        Box physicalBox=area.getPhysicalBox();
        pdfPage.setMediaBox(new Rectangle(physicalBox.getX(), physicalBox.getY(), physicalBox.getWidth(), physicalBox.getHeight()));
        
        
        // 遍历layer
        for(Layer layer: page.getContent())
        {
        	// 遍历pageblocks
        	for(Block block: layer.getPageBlocks())
        	{
        		if(block instanceof TextObject)
        		{
        			        			
        			TextObject textObj=(TextObject)block;
        			
        			PdfFont font=res.getFontMap().get(textObj.getFont());
        			float fontSize=textObj.getSize();
        			
        			if(textObj.getFillColor()!=null)
					{
						// 暂时不处理colorspace，默认为RGB
        				PdfColorSpace colorSpace=new PdfDeviceCs.Rgb();
        				
        				// 设置color
        				Color fillColor=textObj.getFillColor();
        				pdfCanvas.setColor(colorSpace, fillColor.getValue(), true);
        				        				
					}
        			
        			// 处理textcode
        			
        			float textX=0;
        			float textY=physicalBox.getHeight();
        			if(textObj.getBoundary()!=null)
        			{
        				textX=textObj.getBoundary().getX();
        				textY=physicalBox.getHeight()-(textObj.getBoundary().getY() + textObj.getBoundary().getHeight() );
        			}
        			
        			for(TextCode textCode: textObj.getTextCode())
        			{
        				float x=textX;
        				float y=textY;
        				float decent=0;
        				
        				if(textCode.getY()>0)
        					decent=fontSize-textCode.getY();
        					
        				
        				if(textCode.getDeltaX()!=null && textCode.getDeltaX().length>0)
        				{
	        				for(int i=0;i<textCode.getText().length();i++)
	        		        {
	        					if(i>0)
	        						x+=textCode.getDeltaX()[i-1];
	        		        		        		        	
	        					pdfCanvas.beginText();
	        					
	        					if(textObj.getMiterLimit()>0)
	        						pdfCanvas.setMiterLimit(textObj.getMiterLimit());
	        					
	        					pdfCanvas.moveText(x, y);
	        								
	        					float rise=font.getDescent(textCode.getText().substring(i, i+1), fontSize);
	        					rise+=decent;
	        					
	        					pdfCanvas.setTextRise(rise);			
	        					pdfCanvas.setFontAndSize(font, fontSize);
	        					pdfCanvas.showText(textCode.getText().substring(i, i+1));
	        					pdfCanvas.endText();
	        					       	
	        		        }
        				}
        				else
        				{
        					pdfCanvas.beginText();
        					
        					if(textObj.getMiterLimit()>0)
        						pdfCanvas.setMiterLimit(textObj.getMiterLimit());
        					
        					pdfCanvas.moveText(x, y);
        								
        					float rise=font.getDescent(textCode.getText(), fontSize);
        					rise+=decent;
        					
        					pdfCanvas.setTextRise(rise);			
        					pdfCanvas.setFontAndSize(font, fontSize);
        					pdfCanvas.showText(textCode.getText());
        					pdfCanvas.endText();
        					       	
        				}
        			}
        			
        			
        		}
        		else if(block instanceof ImageObject)
        		{
        			pdfCanvas.saveState();
        			
        			ImageObject imageObj=(ImageObject)block;
        			
        			PdfImageXObject pdfImageObject = res.getImageMap().get(imageObj.getResourceId());
        			
        			
        			Box boundary=imageObj.getBoundary();
        			Rectangle rect=new Rectangle(boundary.getX(), physicalBox.getHeight()-(boundary.getY()+boundary.getHeight()), 
        					boundary.getWidth(), boundary.getHeight());
        			
        			if(imageObj.getMiterLimit()>0)
						pdfCanvas.setMiterLimit(imageObj.getMiterLimit());
        			
//        			if(imageObj.getCtm()!=null)
//        			{
//        				PdfArray array = new PdfArray(imageObj.getCtm());
////        				double[] darr=new double[] {0.5,0,0,0.5,0,0};
////        				PdfArray array = new PdfArray(darr);
//        				pdfCanvas.concatMatrix(array); 
//        			}
        			
        			pdfCanvas.addXObject(pdfImageObject, rect);
        			pdfCanvas.restoreState();
        		}
        	}
        }
		
		return pdfPage;
	}
}














