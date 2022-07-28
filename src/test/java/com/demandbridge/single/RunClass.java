package com.demandbridge.single;

import com.demandbridge.single.pages.FTPDownloadDB;
import org.testng.annotations.Test;

public class RunClass {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void runClassTest(){

        // new MailosaurCheck().mailosaurCheckTest();
        // FTPDownloadDemo.main();
        FTPDownloadDB.main();
        // CreateFile.main();
        // WriteToFile.main();
        // FileRead.main();

    }
}
