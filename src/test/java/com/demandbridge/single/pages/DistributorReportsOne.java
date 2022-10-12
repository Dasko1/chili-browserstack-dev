package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DistributorReportsOne {

    public void distributorReportsOneTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        // Distributor Reports Section; First, open the Distributor Reports dropdown.
        $(By.id("dl0~8")).shouldBe(Condition.visible).click();
        $(By.id("dl1~8~34")).shouldBe(Condition.visible).click();                  // Open Change Administrator Passwords
        $("#detailsTitle_top").shouldBe(Condition.visible);
        $(By.id("dl1~8~35")).shouldBe(Condition.visible).click();                  // Open new tab: Outstanding Manager Approvals
        Selenide.sleep(1000);
        switchTo().window(1);
        $("body > table:nth-child(3) > tbody > tr:nth-child(1) > td:nth-child(1)").shouldBe(Condition.text("Outstanding Manager Approvals"));
        executeJavaScript("window.open('close.html', '_self')");
        Selenide.sleep(1500);
        switchTo().window(0);
        // Event Log
        Selenide.sleep(2500);
        $(By.id("dl1~8~36")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Event Log"));
        Selenide.sleep(1500);
        $(By.id("dl1~8~37")).shouldBe(Condition.visible).click();                    // QNet Users On System: see questions
        switchTo().window("Qnet Users Report");
        Selenide.sleep(1000);
        $("body > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1)").shouldBe(Condition.text("Qnet Users Report"));
        executeJavaScript("window.open('close.html', '_self')");
        Selenide.sleep(1500);
        switchTo().window(0);
    }
}
