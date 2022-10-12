package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DistributorReportsTwo {

    public void distributorReportsTwoTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $(By.id("dl0~8")).shouldBe(Condition.visible).click();                          // Open Administrator dropdown
        // $(By.id("dl1~8~38")).shouldBe(Condition.visible).click();                    // Qnet Users On System CSV
        // open("https://qnet.e-quantum2k.com/~support2/cgi-bin/qnet-site-setup.cgi");
        // open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        // $(By.id("dl0~8")).shouldBe(Condition.visible).click();                       // Open Administrator dropdown
        $(By.id("dl1~8~38")).shouldBe(Condition.visible).click();                       // Qnet Users On System CSV
        $("#detailsTitle_top").shouldBe(Condition.text("QNet Users On System CSV"));
        $(By.id("dl1~8~39")).shouldBe(Condition.visible).click();                       // View/Delete Retail Users
        Selenide.sleep(1000);
        switchTo().window(1);
        Selenide.sleep(1000);
        $("body > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1)").shouldBe(Condition.text("Qnet Retail Users Report"));
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        $(By.id("dl1~8~40")).shouldBe(Condition.visible).click();                       // QNet Stats Report
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("QNet Stats Report"));
        $(By.id("dl1~8~41")).click();                                                   // Order Summary Report
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Order Summary Report"));
        $(By.id("dl1~8~42")).click();                                                   // Budget Adjustments
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Budget Adjustments"));
        $(By.id("dl1~8~43")).click();                                                   // Invoice Manager
        switchTo().window(1);
        $(By.cssSelector("body > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1)")).shouldBe(Condition.text("Invoice Manager."));
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        $(By.id("dl1~8~44")).click();                                                // Gift Certificates
        switchTo().window(1);
        Selenide.sleep(1500);
        $(By.className("dsBody")).shouldBe(Condition.text("Gift Certificates"));
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        $(By.id("dl1~8~45")).click();                                                // RFQ Report
        $("#detailsTitle_top").shouldBe(Condition.text("RFQ Report"));
        $(By.id("dl1~8~46")).click();                                                // Statistics Report
        switchTo().window(1);
        $(By.cssSelector("body > table:nth-child(7) > tbody > tr:nth-child(1) > td:nth-child(1)")).shouldBe(Condition.text("Statistics Dashboard."));
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        $(By.id("dl1~8~89")).click();                                                // Digital Library all assets by client
        $("#detailsTitle_top").shouldBe(Condition.text("Digital Library all assets by client"));
        $(By.id("dl1~8~77")).click();                                               // Manager Approval Status
        $("#detailsTitle_top").shouldBe(Condition.text("Manager Approval Status Report"));
        $(By.id("dl1~8~92")).click();                                               // Manager Approval Profile Summary
        switchTo().window(1);
        $(By.id("rpt-title")).shouldBe(Condition.text("Manager Report Summary"));
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        $(By.id("dl1~8~99")).click();                                                // Custom Lists Summary
        $("#detailsTitle_top").shouldBe(Condition.text("Custom Lists Summary"));
    }
}
