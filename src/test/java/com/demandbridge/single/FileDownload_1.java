package com.demandbridge.single;

import java.io.File;

public class FileDownload_1 {

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File("C:\\Users\\ADaskalopoulos\\Downloads");
        File[] dir_contents = dir.listFiles();

        if (dir_contents != null) {
            for (File dir_content : dir_contents) {
                if (dir_content.getName().equals(fileName))
                    return true;
            }
        }

        return false;
    }
}
