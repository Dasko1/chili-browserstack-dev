package com.demandbridge.single.pages;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.*;

public class FTPDownloadDemo {

    public static void main() {

        String server = "test.rebex.net";
        int port = 21;
        String user = "demo";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String remoteFile1 = "/pub/example/readme.txt";
            File downloadFile1 = new File("C:\\Users\\ADaskalopoulos\\Downloads\\readme.txt");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally
        {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}