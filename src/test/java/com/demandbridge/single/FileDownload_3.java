package com.demandbridge.single;

import java.io.File;
import java.net.MalformedURLException;

// Main class
public class FileDownload_3 {

    // Main driver method
    public static void main(String args) throws MalformedURLException {

        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();

        // Getting the file by creating object of File class
        File f = new File("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1_doc_highres.pdf");

        // Checking if the specified file exists or not
        if (f.exists())
            // Show if the file exists
            System.out.println("\nThe file exists!");
        else
            // Show if the file does not exist!
            System.out.println("The file does not exist.");
    }
}
