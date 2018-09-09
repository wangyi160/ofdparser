package mytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontInfo;



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
        Document document = new Document(pdf);
        
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		
		
        
        document.add(new Paragraph("Hello World!").setFontSize(20));
        document.close();
		
	}

}