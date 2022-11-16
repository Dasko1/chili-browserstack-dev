// Set line number in l.11 to find a specif line in the file.
package com.demandbridge.single.pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {

    public static void main() {
        int edited_line = 51; // The line number look for, read and print out.
        try{
            String line = Files.readAllLines(Paths.get("C:\\Users\\ADaskalopoulos\\Downloads\\00-X0049J-1.xml")).get(edited_line);
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
