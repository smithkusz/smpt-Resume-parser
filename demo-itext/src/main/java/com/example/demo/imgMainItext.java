package com.example.demo;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;

/**
 * Simple image example.
 */
public class imgMainItext {
    public static final String DOG = "src/main/resources/img/dog.bmp";
    public static final String FOX = "src/main/resources/img/fox.bmp";
       
    public static final String DEST = "results/chapter01/quick_brown_fox.pdf";
    
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new imgMainItext().createPdf(DEST);
    }
    
    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        
        // Initialize document
        Document document = new Document(pdf);
        
        // Compose Paragraph
        Image fox = new Image(ImageDataFactory.create(FOX));
        Image dog = new Image(ImageDataFactory.create(DOG));
        Paragraph p = new Paragraph("Brown Fox\n ")
                .add(fox)
                .add("\n Cute dog \n ")
                .add(dog);
        // Add Paragraph to document
        document.add(p);
        
        //Close document
        document.close();
    }
}
