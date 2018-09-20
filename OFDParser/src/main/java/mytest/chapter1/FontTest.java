package mytest.chapter1;

import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class FontTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String dest="pdffiles/chapter1/1.pdf";
		
	    PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
	    Document document = new Document(pdf);
	    PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
	    PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
	    Text title =
	        new Text("The Strange Case of Dr. Jekyll and Mr. Hyde").setFont(bold);
	    Text author = new Text("Robert Louis Stevenson").setFont(font);
	    Paragraph p = new Paragraph().add(title).add(" by ").add(author);
	    document.add(p);
	    document.close();
		
	}

}
