// Set line number in l.11 to find a specif line in the file.
package com.demandbridge.single.pages;

import com.demandbridge.single.LoginPageGeneric;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {

    public static void main() throws MalformedURLException {

        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();

        int edited_line = 54; // The line number look for, read and print out.
        try{
            String line = Files.readAllLines(Paths.get("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1.xml")).get(edited_line);
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }

        // This deletes the file to not clutter up the Downloads folder.  Everyone should hate a cluttered Downloads folder.
        File existingFile = new File("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1.xml");

        if (existingFile.exists() && existingFile.isFile()) {
            existingFile.delete();
            System.out.println("\nThe XML file has been deleted!");
        }

        // This deletes the file to not clutter up the Downloads folder.  Everyone should hate a cluttered Downloads folder.
        File existingFile1 = new File("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1.xml");

        if (existingFile1.exists() && existingFile1.isFile()) {
            existingFile1.delete();
            System.out.println("\nThe high res PDF file has been deleted!");
        }
    }
}
