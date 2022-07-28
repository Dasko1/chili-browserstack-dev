// Set line number in l.11 to find a specif line in the file.
package com.demandbridge.single.pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {

    public static void main() {
        int n = 0; // The line number
        try{
            String line = Files.readAllLines(Paths.get("filename.txt")).get(n);
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

}
