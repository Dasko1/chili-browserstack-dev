package com.demandbridge.single;

// Extracting Images from a PDF using java
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.testautomationguru.utility.PDFUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class Watermark_1 {
    public static void main(String[] args) throws Exception
    {
        // Existing PDF Document to be Loaded using file io
        File newFile = new File("C:\\watermark-test\\00-X005BS-1_doc_lowres.pdf");
        PDDocument pdfDocument = PDDocument.load(newFile);

        // PDFRenderer class to be Instantiated, i.e. creating its object
        PDFRenderer pdfRenderer = new PDFRenderer(pdfDocument);

        // Rendering an image from the PDF document using BufferedImage class
        BufferedImage img = pdfRenderer.renderImage(3);
        // Writing the extracted image to a new file
        ImageIO.write(img, "JPEG", new File("C:\\watermark-test\\stored-images\\extracted-content.png"));
        System.out.println("Image has been extracted successfully");

        // Closing the PDF document
        pdfDocument.close();

        PDFUtil pdfUtil = new PDFUtil();
        String getText = pdfUtil.getText("C:\\watermark-test\\00-X005BS-1_doc_lowres.pdf", 1, 6);
        int pageCount = pdfUtil.getPageCount("C:\\watermark-test\\00-X005BS-1_doc_lowres.pdf");
        if (pageCount == 6){
            System.out.println("The flipbook has " + pageCount + " pages!");
        }
        if (getText.contains("avalia")){
            System.out.println("The text is present!");
        }
        else {
            System.out.println("Test fails: the text is not present.");
        }
    }
}

