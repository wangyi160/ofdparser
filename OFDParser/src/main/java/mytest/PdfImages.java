package mytest;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

public class PdfImages {

	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
		// TODO Auto-generated method stub

		String dest="xmlfiles/img.pdf";
		String imgSrc="ofdunzipfiles/ReaderManual/Doc_0/Res/image.jpg";
		
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);	
                        
        pdf.setDefaultPageSize(new PageSize(210, 297));
        
        PdfPage page = pdf.addNewPage();
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        
        //Image img1 = new Image(ImageDataFactory.create(imgSrc));
        PdfImageXObject pdfImageObject=new PdfImageXObject(ImageDataFactory.create(imgSrc));
        
        pdfCanvas.addXObject(pdfImageObject, new Rectangle(59.27f, 297-(74.68f+66.38f), 91.36f, 66.38f));
        
        pdf.close();
		
	}

}
