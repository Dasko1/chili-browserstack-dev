package com.demandbridge.single;

import com.jcraft.jsch.*;

public class SFTPClient {

    private String host = "test.rebex.net";
    private int port = 22;
    private Session session = null;

    public SFTPClient() {

    }

    public void connect() throws JSchException {
        JSch jsch = new JSch();

        session = jsch.getSession("demo", host, port);
        session.setPassword("password");

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

        SFTPClient sftpClient = new SFTPClient();

        sftpClient.connect();
        sftpClient.download("/pub/example/readme.txt", "C:\\Users\\ADaskalopoulos\\Downloads\\readme.txt");
        sftpClient.disconnect();
    }
}

