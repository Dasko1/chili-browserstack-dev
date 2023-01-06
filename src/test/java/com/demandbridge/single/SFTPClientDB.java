package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import com.demandbridge.single.pages.FileRead;
import com.demandbridge.single.pages.PrettyPrintXMLInJava;
import com.jcraft.jsch.*;

import java.net.MalformedURLException;

import static com.demandbridge.single.pages.PrettyPrintXMLInJava.*;

public class SFTPClientDB {

    private final String host = "ftp.demandbridge.com";
    private final int port = 22;
    private Session session = null;

    public SFTPClientDB() {
    }

    public void connect() throws JSchException {
        JSch jsch = new JSch();

        session = jsch.getSession("ftptest", host, port);
        session.setPassword("j7U6Tys9M9");

        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
    }

    public void download (String source, String destination) throws JSchException, SftpException {
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.get(source, destination);
        sftpChannel.exit();
    }

    public void disconnect() {
        if (session != null) {
            session.disconnect();
        }
    }

    public static void main() throws Exception {

        // Generate the Order Number & put into the variable printOrderNumber, then download the files into the Downloads folder:ll.48-57
        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();
        System.out.println("\nThe Order Number from ChiliApprovalsEdit.java is: " + printOrderNumber + "\n");

        String downloadPath = "C:\\Users\\ADaskalopoulos\\Downloads\\";
        SFTPClientDB sftpClientDB = new SFTPClientDB();

        sftpClientDB.connect();
        sftpClientDB.download("/home/ftptest/" + printOrderNumber + "-1.xml", downloadPath);
        sftpClientDB.download("/home/ftptest/" + printOrderNumber + "-1_doc_highres.pdf", downloadPath);
        sftpClientDB.disconnect();

        // Verify & delete the downloaded files!
        // FileDownload_1.main("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1.xml");
        // FileDownload_3.main("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1_doc_highres.pdf");
    }
}
