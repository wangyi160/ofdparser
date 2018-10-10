package mytest;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import text.TextUtil;


public class PDFFonts {
	public static void main(String[] args) throws IOException {
		
		String dest="xmlfiles/txt2.pdf";
		
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);	
        
                
        pdf.setDefaultPageSize(new PageSize(210, 297));
        		
        PdfFont f1 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,0", PdfEncodings.IDENTITY_H, false);
        
        PdfFont f2 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/TIMES.TTF", PdfEncodings.IDENTITY_H, false);
        PdfFont f3 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/CALIBRI.TTF", PdfEncodings.IDENTITY_H, false);
        PdfFont f4 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/ARIALBD.TTF", PdfEncodings.IDENTITY_H, false);
        PdfFont f5 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/WINGDING.TTF", PdfEncodings.IDENTITY_H, true);
        PdfFont f6 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/ARIAL.TTF", PdfEncodings.IDENTITY_H, false);
        PdfFont f7 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/TIMESBD.TTF", PdfEncodings.IDENTITY_H, false);
        PdfFont f8 = PdfFontFactory.createFont("C:/WINDOWS/Fonts/SIMHEI.TTF", PdfEncodings.IDENTITY_H, false);
        
        PdfFont f9 = PdfFontFactory.createFont("D:/OFD2PDF/tnrbd.ttf", PdfEncodings.IDENTITY_H, true);
        
        //PdfFont f9 = PdfFontFactory.createFont("src/main/resources/fonts/font_1.otf", PdfEncodings.UTF8, true);
        
        document.add(new Paragraph("你好啊").setFont(f1).setItalic().setBold().setFontSize((float) 9.14));
        document.add(new Paragraph("1111").setFont(f9).setFontSize((float) 9.14));
        document.add(new Paragraph("1234").setFont(f2).setFontSize((float) 8.14));
        document.add(new Paragraph("QWER").setFont(f3).setFontSize((float) 8.14));
        document.add(new Paragraph("ASDF").setFont(f4).setFontSize((float) 8.14));
        
                
//        List list=new List();
//        list.setListSymbol(new Text("\uEF8398").setFont(f5));
//        document.add(list);
        
        document.add(new Paragraph("").setFont(f5).setFontSize((float) 8.14));
        document.add(new Paragraph("").setFont(f5).setFontSize((float) 8.14));
        
        
        document.add(new Paragraph("ZXCV").setFont(f6).setFontSize((float) 8.14));
        document.add(new Paragraph("TYUI").setFont(f7).setFontSize((float) 8.14));
        document.add(new Paragraph("你不好啊").setFont(f8).setFontSize((float) 8.14));
        
        //document.add(new Paragraph("ICStrusted").setFont(f9).setFontSize((float) 8.14));
        
        
        document.close();
	}
}
