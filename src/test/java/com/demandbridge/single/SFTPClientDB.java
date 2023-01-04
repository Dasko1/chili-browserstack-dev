package com.demandbridge.single;

import com.jcraft.jsch.*;

import java.net.MalformedURLException;

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

    public static void main() throws JSchException, SftpException, MalformedURLException, InterruptedException {

        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();
        System.out.println("\nThe Order Number from ChiliApprovalsEdit.java is: " + printOrderNumber);

        String downloadPath = "C:\\Users\\ADaskalopoulos\\Downloads\\";
        SFTPClientDB sftpClientDB = new SFTPClientDB();

        // Get Order Number from ChiliApprovalsEdit.java ll.188-93!
        // ChiliApprovalsEdit.ordNum();
        // String orderNum = ChiliApprovalsEdit.x;
        // System.out.println("The order number is: " + orderNum);

        sftpClientDB.connect();
        sftpClientDB.download("/home/ftptest/" + printOrderNumber + "-1.xml", downloadPath);
        sftpClientDB.download("/home/ftptest/" + printOrderNumber + "-1_doc_highres.pdf", downloadPath);
        sftpClientDB.disconnect();
    }
}
