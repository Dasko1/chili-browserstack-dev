package com.demandbridge.single;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RunClass {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void runClassTest() throws InterruptedException, JSchException, SftpException, MalformedURLException {

        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();

        // new MailosaurCheck().mailosaurCheckTest();
        // FTPDownloadDemo.main();
        // CreateFile.main();
        // WriteToFile.main();

        // FileRead.main();
        // SFTPClient.main();
        // SFTPClientDB.main();
        // FileDownload_1.main("C:\\Users\\ADaskalopoulos\\Downloads\\" + printOrderNumber + "-1.xml");
        FileDownload_3.main("C:\\Users\\ADaskalopoulos\\Downloads\\00-X004D3-1_doc_highres.pdf");
    }
}
