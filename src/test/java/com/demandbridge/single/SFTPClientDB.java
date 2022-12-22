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

        String downloadPath = "C:\\Users\\ADaskalopoulos\\Downloads\\";
        SFTPClientDB sftpClientDB = new SFTPClientDB();

        // Get Order Number from ChiliApprovalsEdit.java ll.188-93!
        // ChiliApprovalsEdit.ordNum();
        // String orderNum = ChiliApprovalsEdit.x;
        // System.out.println("The order number is: " + orderNum);

        sftpClientDB.connect();
        // sftpClientDB.download("/home/ftptest/00-X004D3-1.xml", downloadPath);                   //USE variable from l.47!!!
        // sftpClientDB.download("/home/ftptest/00-X004D3-1_doc_highres.pdf", downloadPath);       // Same here!
        sftpClientDB.disconnect();
    }
}
