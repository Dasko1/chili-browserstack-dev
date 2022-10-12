package com.demandbridge.single;

import com.jcraft.jsch.*;

public class SFTPClientDB {

    private String host = "ftp.demandbridge.com";
    private int port = 22;
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

    public static void main() throws JSchException, SftpException{

        String downloadPath = "C:\\Users\\ADaskalopoulos\\Downloads\\";
        SFTPClientDB sftpClientDB = new SFTPClientDB();

        sftpClientDB.connect();
        sftpClientDB.download("/home/ftptest/00-X0040C-1.xml", downloadPath);
        sftpClientDB.download("/home/ftptest/00-X0040C-1_doc_highres.pdf", downloadPath);
        sftpClientDB.disconnect();
    }

}
