package mytest.chapter2;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.renderer.CanvasRenderer;
import com.itextpdf.layout.renderer.IRenderer;

 
import java.io.File;
import java.io.IOException;
 
/**
 *
 * @author iText
 */

public class C02E03_CanvasRepeat {
 
    class MyCanvasRenderer extends CanvasRenderer {
 
        protected boolean full = false;
 
        private MyCanvasRenderer(Canvas canvas) {
            super(canvas);
        }
 
        @Override
        public void addChild(IRenderer renderer) {
            super.addChild(renderer);
            full = Boolean.TRUE.equals(getPropertyAsBoolean(Property.FULL));
        }
 
        public boolean isFull() {
            return full;
        }
    }
 
    public static final String DEST = "pdffiles/chapter2/canvas_repeat.pdf";
 
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C02E03_CanvasRepeat().createPdf(DEST);
    }
 
    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
 
        PdfPage page = pdf.addNewPage();
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        Rectangle rectangle = new Rectangle(36, 500, 100, 250);
        pdfCanvas.rectangle(rectangle);
        pdfCanvas.stroke();
        Canvas canvas = new Canvas(pdfCanvas, pdf, rectangle);
        MyCanvasRenderer renderer = new MyCanvasRenderer(canvas);
        canvas.setRenderer(renderer);
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
        Text title = new Text("The Strange Case of Dr. Jekyll and Mr. Hyde").setFont(bold);
        Text author = new Text("Robert Louis Stevenson").setFont(font);
        Paragraph p = new Paragraph().add(title).add(" by ").add(author);
        while (!renderer.isFull())
            canvas.add(p);
 
        //Close document
        pdf.close();
    }
 
}