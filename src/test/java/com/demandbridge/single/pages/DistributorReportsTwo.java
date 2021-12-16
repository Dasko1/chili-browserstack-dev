package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DistributorReportsTwo {

    public void distributorReportsTwoTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)")
                .shouldBe(Condition.visible);
        $(By.id("dl0~8")).shouldBe(Condition.visible).click();                      // Open Administrator dropdown
        $(By.id("p1~8~38")).shouldBe(Condition.visible).click();                    // Qnet Users On System CSV
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/qnet-site-setup.cgi");
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $(By.id("dl0~8")).shouldBe(Condition.visible).click();                      // Open Administrator dropdown
        $(By.id("p1~8~38")).shouldBe(Condition.visible).click();                    // Qnet Users On System CSV
        $("#detailsTitle_top").shouldBe(Condition.text("QNet Users On System CSV"));
        $(By.id("dl1~8~39")).shouldBe(Condition.visible).click();                   // View/Delete Retail Users
        switchTo().window("Qnet Retail Users Report");
        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1)").shouldBe(Condition.text("Qnet Retail Users Report"));
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~8~40")).shouldBe(Condition.visible).click();                    // QNet Stats Report
        $("#detailsTitle_top").shouldBe(Condition.text("QNet Stats Report"));
        $(By.id("p1~8~41")).click();                                                // Order Summary Report
        $("#detailsTitle_top").shouldBe(Condition.text("Order Summary Report"));
        $(By.id("p1~8~42")).click();                                                // Budget Adjustments
        $("#detailsTitle_top").shouldBe(Condition.text("Budget Adjustments"));
        $(By.id("p1~8~43")).click();                                                // Invoice Manager
        switchTo().window("Invoice Manager");
        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1)").shouldBe(Condition.text("Invoice Manager."));
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~8~44")).click();                                                // Gift Certificates
        switchTo().window("Gift card reset page");
        $(".dsRptTitle").shouldBe(Condition.text("Gift Certificates"));
        $(".dsRptTitle2").shouldBe(Condition.text("[support2] Lori Network V12 Testing Site"));
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~8~45")).click();                                                // RFQ Report
        $("#detailsTitle_top").shouldBe(Condition.text("RFQ Report"));
        $(By.id("p1~8~46")).click();                                                // Statistics Report
        switchTo().window("Statistics Dashboard");
        $("body > table:nth-child(7) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1)").shouldBe(Condition.text("Statistics Dashboard."));
        Selenide.sleep(1500);
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~8~89")).click();                                                // Digital Library all assets by client
        $("#detailsTitle_top").shouldBe(Condition.text("Digital Library all assets by client"));
        $(By.id("p1~8~77")).click();                                               // Manager Approval Status
        $("#detailsTitle_top").shouldBe(Condition.text("Manager Approval Status Report"));
        $(By.id("p1~8~92")).click();                                               // Manager Approval Profile Summary
        switchTo().window("Manager Approval Summary");
        $("#rpt-title").shouldBe(Condition.text("Manager Report Summary"));
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~8~99")).click();                                                // Custom Lists Summary
        $("#detailsTitle_top").shouldBe(Condition.text("Custom Lists Summary"));
        Selenide.sleep(1000);
    }
}
