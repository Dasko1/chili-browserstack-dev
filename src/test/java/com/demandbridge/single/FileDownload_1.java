package com.demandbridge.single;

import java.io.*;
import java.net.MalformedURLException;

// Main class
public class FileDownload_1 {

    // Main driver method
    public static void main(String args) throws MalformedURLException {

        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();
        System.out.println("\nThe Order Number from ChiliApprovalsEdit.java is: " + printOrderNumber);

        // Getting the file by creating object of File class
        File f = new File("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1.xml");

        // Checking if the specified file exists or not
        if (f.exists())
            // Show if the file exists
            System.out.println("\nThe file exists!");
        else
            // Show if the file does not exist!
            System.out.println("The file does not exist.");
    }
}