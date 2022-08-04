package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.demandbridge.BrowserStackTest;
import com.demandbridge.single.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationReportsOne extends BrowserStackTest {

    @Test
    public void automationReportsOneTest(){

        // Go to page and push Reports link. The below URL is EQC, the new one.
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=adaskalopoulos@demandbridge.com&Passwd=reds2");
        // Push Reports element
        $(By.id("eqcNavReports")).shouldBe(Condition.visible).click();

        // Run tests
        new UserReportsAllowance().userReportsAllowanceTest();
        new UserReportsAllowanceBalance().userReportsAllowanceBalanceTest();
        new UserReportsAllowanceReport().UserReportsAllowanceReportTest();
        new UserReportsGiftCertificate().userReportsGiftCertificateTest();
        new UserReportsRFQ().userReportsRFQTest();
        new Last4Reports().last4ReportsTest();


        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            // wait.until(ExpectedConditions.urlContains("qnet-rtps.cgi"));
            wait.until(ExpectedConditions.urlContains("qnet-rpts.cgi"));
            markTestStatus("passed", "Yaay, Report Details Reviewed!",driver);
            markTestStatus("passed","Yaay the URL contains qnet-rpts.cgi!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed", "The Title is not EQ Commerce",driver);
            markTestStatus("failed","The URL does not contain qnet-rpts.cgi",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}
