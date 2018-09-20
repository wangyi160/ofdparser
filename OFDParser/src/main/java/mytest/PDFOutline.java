package mytest;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfOutline;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.navigation.PdfDestination;
import com.itextpdf.kernel.pdf.navigation.PdfExplicitDestination;
import com.itextpdf.layout.Document;

public class PDFOutline {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		String dest="xmlfiles/txt3.pdf";
		
		PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        pdf.setDefaultPageSize(new PageSize(210, 297));
        
        Document document = new Document(pdf);
        PdfPage page1 = pdf.addNewPage();
        PdfPage page2 = pdf.addNewPage();
        PdfPage page = pdf.addNewPage();
        page = pdf.addNewPage();
        page = pdf.addNewPage();
        page = pdf.addNewPage();
        page = pdf.addNewPage();
        page = pdf.addNewPage();
        
        PdfOutline root=pdf.getOutlines(false);
        
        
        String bookmark1="概述";
        PdfOutline outline1 = root.addOutline(bookmark1);
        PdfDestination destination = PdfExplicitDestination.createXYZ(page1,39.16f, 297-25.95f, 1);
        outline1.addDestination(destination);
        outline1.setOpen(false);
        
        String bookmark2="产品简介";
        PdfOutline outline2 = outline1.addOutline(bookmark2);
        destination = PdfExplicitDestination.createXYZ(page1,41.80f, 297-41.89f, 1);
        outline2.addDestination(destination);
        outline2.setOpen(false);
        
        String bookmark3="产品特点";
        PdfOutline outline3 = outline1.addOutline(bookmark3);
        destination = PdfExplicitDestination.createXYZ(page1,41.80f, 297-124.97f, 1);
        outline3.addDestination(destination);
        outline3.setOpen(false);
        
        
        pdf.close();
	}

}
