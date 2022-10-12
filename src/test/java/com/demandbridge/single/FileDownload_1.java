package com.demandbridge.single;

// Java Program to Illustrate exists() method of File Class

// Importing input output classes
import java.io.*;

// Main class
public class FileDownload_1 {

    // Main driver method
    public static void main(String args)
    {
        // Getting the file by creating object of File class
        File f = new File("C:\\Users\\ADaskalopoulos\\Downloads\\00-X0040C-1.xml");

        // Checking if the specified file exists or not
        if (f.exists())
            // Show if the file exists
            System.out.println("The file exists!");
        else
            // Show if the file does not exist!
            System.out.println("The file does not exist.");
    }
}
