package mytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontInfo;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;



public class PDF2TextExample {

	private static final String PDF = "src/main/resources/pdf.pdf";
	private static final String TXT = "src/main/resources/txt.txt";

	public static void main(String[] args) {
		
			//generateTxtFromPDF(PDF);
			try {
				generatePDFFromTxt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	

	private static void generatePDFFromTxt() throws IOException {
//		Document pdfDoc = new Document(PageSize.A4);
//		PdfWriter.getInstance(pdfDoc, new FileOutputStream("xmlfiles/txt.pdf"))
//				.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
//		pdfDoc.open();
//		
//		Font myfont = new Font();
//		myfont.setStyle(Font.NORMAL);
//		myfont.setSize(11);
//		pdfDoc.add(new Paragraph("\n"));
//		
//		BufferedReader br = new BufferedReader(new FileReader(filename));
//		String strLine;
//		while ((strLine = br.readLine()) != null) {
//			Paragraph para = new Paragraph(strLine + "\n", myfont);
//			para.setAlignment(Element.ALIGN_JUSTIFIED);
//			pdfDoc.add(para);
//		}
//		
//		pdfDoc.close();
//		br.close();
		
		String dest="xmlfiles/txt.pdf";
		
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
		//pdf.setDefaultPageSize(new PageSize(210, 297));
		
        //Document document = new Document(pdf);
        PdfPage page = pdf.addNewPage();
        page.setMediaBox(new Rectangle(0,0, 210, 297));
        
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        
        float fontsize=9.14f;
        PdfFont f1 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,0", PdfEncodings.IDENTITY_H, false);   
        System.out.println(f1.getWidth("数", fontsize));
        System.out.println(f1.getAscent("数", fontsize));
        System.out.println(f1.getDescent("数", fontsize));
        
        String text="数科阅读器";
        
        float x=41.91f;
        float y=297-78.57f;
        float width=45.80f;
        float height=9.14f;
        float miterlimit=4.23f;
        
        
        Rectangle rect=new Rectangle(0, 0, width, height*5);
        
        Canvas canvas = new Canvas(pdfCanvas, pdf, rect);
        pdfCanvas.rectangle(rect);
        pdfCanvas.stroke();
        
//        Paragraph pg1=new Paragraph("数科阅读器").setFont(f1).setFontSize((float) 9.14);
//        pg1.setFixedLeading(0);
//        pg1.setMultipliedLeading(1);  
//        pg1.setPadding(0);
//        pg1.setVerticalAlignment(VerticalAlignment.TOP);
        
//        pdfCanvas.beginText();
//        pdfCanvas.moveText(x, y);
//        pdfCanvas.setFontAndSize(f1, 9.14f);
//        pdfCanvas.showText("数");
//        pdfCanvas.endText();
//        
//        pdfCanvas.beginText();
//        pdfCanvas.moveText(x+9.14, y);
//        pdfCanvas.setFontAndSize(f1, 9.14f);
//        pdfCanvas.showText("数");
//        pdfCanvas.endText();
        
        
//        pdfCanvas.moveTo(x+9.14, y);
//        pdfCanvas.setFontAndSize(f1, 9.14f);
//        pdfCanvas.showText("科");
        
        
        
        //document.add(pg1);
//        Paragraph pg2=new Paragraph("数科阅读器").setFont(f1).setFontSize((float) 9.14);
//        canvas.add(pg2);
        
        float[] deltaX=new float[] { 0, 9.14f, 9.14f, 9.14f, 9.23f };
        float descent=9.14f-7.87f;
        
        
        
        //x=0;
        for(int i=0;i<text.length();i++)
        {
//        	Paragraph pg1=new Paragraph(text.substring(i, i+1)).setFont(f1).setFontSize((float) 9.14);
        	
        	x+=deltaX[i];
        	
        	
			pdfCanvas.beginText();
			
			pdfCanvas.setMiterLimit(miterlimit);
			
			pdfCanvas.moveText(x, y);
						
			float rise=f1.getDescent(text.substring(i, i+1), fontsize);
			rise+=descent;
			
			pdfCanvas.setTextRise(rise);			
			pdfCanvas.setFontAndSize(f1, fontsize);
			pdfCanvas.showText(text.substring(i, i+1));
			pdfCanvas.endText();
			       	
        }
        
        deltaX=new float[] { 0, 4.57f, 4.57f, 4.57f };
        descent=9.14f-7.87f;
        
        text="(OFD";
        
        x=87.71f;
        y=297-78.57f;
        width=20.66f;
        height=9.14f;
        miterlimit=4.23f;
        
        //x=0;
        for(int i=0;i<text.length();i++)
        {
//        	Paragraph pg1=new Paragraph(text.substring(i, i+1)).setFont(f1).setFontSize((float) 9.14);
        	
        	x+=deltaX[i];
        	
        	
			pdfCanvas.beginText();
			
			pdfCanvas.setMiterLimit(miterlimit);
			
			pdfCanvas.moveText(x, y);
						
			float rise=f1.getDescent(text.substring(i, i+1), fontsize);
			rise+=descent;
			
			pdfCanvas.setTextRise(rise);			
			pdfCanvas.setFontAndSize(f1, fontsize);
			pdfCanvas.showText(text.substring(i, i+1));
			pdfCanvas.endText();
			       	
        }
        
        deltaX=new float[] { 0, 9.14f };
        descent=9.14f-7.87f;
        
        text="版式";
        
        x=108.37f;
        y=297-78.57f;
        width=18.37f;
        height=9.14f;
        miterlimit=4.23f;
        
        //x=0;
        for(int i=0;i<text.length();i++)
        {
//        	Paragraph pg1=new Paragraph(text.substring(i, i+1)).setFont(f1).setFontSize((float) 9.14);
        	
        	x+=deltaX[i];
        	
        	
			pdfCanvas.beginText();
			
			pdfCanvas.setMiterLimit(miterlimit);
			
			pdfCanvas.moveText(x, y);
						
			float rise=f1.getDescent(text.substring(i, i+1), fontsize);
			rise+=descent;
			
			pdfCanvas.setTextRise(rise);			
			pdfCanvas.setFontAndSize(f1, fontsize);
			pdfCanvas.showText(text.substring(i, i+1));
			pdfCanvas.endText();
			       	
        }
        
        deltaX=new float[] { 0, 9.14f, 9.14f, 9.14f};
        descent=9.14f-7.87f;
        
        text="用户手册";
        
        x=86.61f;
        y=297-95.08f;
        width=36.66f;
        height=9.14f;
        miterlimit=4.23f;
        
        //x=0;
        for(int i=0;i<text.length();i++)
        {
//        	Paragraph pg1=new Paragraph(text.substring(i, i+1)).setFont(f1).setFontSize((float) 9.14);
        	
        	x+=deltaX[i];
        	
        	
			pdfCanvas.beginText();
			
			pdfCanvas.setMiterLimit(miterlimit);
			
			pdfCanvas.moveText(x, y);
						
			float rise=f1.getDescent(text.substring(i, i+1), fontsize);
			rise+=descent;
			
			pdfCanvas.setTextRise(rise);			
			pdfCanvas.setFontAndSize(f1, fontsize);
			pdfCanvas.showText(text.substring(i, i+1));
			pdfCanvas.endText();
			       	
        }
        
        deltaX=new float[] { 0, 4.91f};
        descent=4.91f-4.23f;
        fontsize=4.91f;
        
        text="北京";
        
        x=70.36f;
        y=297-243.08f;
        width=9.82f;
        height=4.91f;
        miterlimit=4.23f;
        
        //x=0;
        for(int i=0;i<text.length();i++)
        {
//        	Paragraph pg1=new Paragraph(text.substring(i, i+1)).setFont(f1).setFontSize((float) 9.14);
        	
        	x+=deltaX[i];
        	
        	
			pdfCanvas.beginText();
			
			pdfCanvas.setMiterLimit(miterlimit);
			
			pdfCanvas.moveText(x, y);
						
			float rise=f1.getDescent(text.substring(i, i+1), fontsize);
			rise+=descent;
			
			pdfCanvas.setTextRise(rise);			
			pdfCanvas.setFontAndSize(f1, fontsize);
			pdfCanvas.showText(text.substring(i, i+1));
			pdfCanvas.endText();
			       	
        }
        
        deltaX=new float[] { 0, 4.91f, 5.00f, 4.91f, 4.91f, 5.00f};
        descent=4.91f-4.23f;
        fontsize=4.91f;
        
        text="有限责任公司";
        
        x=109.81f;
        y=297-243.08f;
        width=29.72f;
        height=4.91f;
        miterlimit=4.23f;
        
        //x=0;
        for(int i=0;i<text.length();i++)
        {
//        	Paragraph pg1=new Paragraph(text.substring(i, i+1)).setFont(f1).setFontSize((float) 9.14);
        	
        	x+=deltaX[i];
        	
        	
			pdfCanvas.beginText();
			
			pdfCanvas.setMiterLimit(miterlimit);
			
			pdfCanvas.moveText(x, y);
						
			float rise=f1.getDescent(text.substring(i, i+1), fontsize);
			rise+=descent;
			
			pdfCanvas.setTextRise(rise);			
			pdfCanvas.setFontAndSize(f1, fontsize);
			pdfCanvas.showText(text.substring(i, i+1));
			pdfCanvas.endText();
			       	
        }
                
        //Paragraph pg1=new Paragraph("数科阅读器").setFont(f1).setFontSize((float) 9.14);
        
        
        
        
        pdf.close();
		
	}

}