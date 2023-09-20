package com.demandbridge.single;

import com.demandbridge.BrowserStackTest;
import com.testautomationguru.utility.PDFUtil;

import java.io.IOException;

public class Watermark extends BrowserStackTest {

    public static void main(String[] args) throws IOException {

        PDFUtil pdfUtil = new PDFUtil();
        String getText = pdfUtil.getText("C:\\watermark-test\\COR001.pdf", 1, 1);
        int pageCount = pdfUtil.getPageCount("C:\\watermark-test\\COR004.pdf");
        if (pageCount == 6){
            System.out.println("The flipbook has " + pageCount + " pages!");
        }

        if (getText.contains("Lo wR es P ro of")){
            System.out.println("The watermark is present!");
        }
        else { System.out.println("Test fails: the watermark not present."); }

        if (getText.contains("generic.com")){
            System.out.println("The suffix 'generic.com' is present!");
        }
        else {
            System.out.println("Test fails: the suffix is not present.");
        }
    }
}
