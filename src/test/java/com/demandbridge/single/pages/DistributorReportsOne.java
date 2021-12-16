package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DistributorReportsOne {

    public void distributorReportsOneTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)")
                .shouldBe(Condition.visible);
        // Distributor Reports Section; First, open the Distributor Reports dropdown.
        $(By.id("dl0~8")).shouldBe(Condition.visible).click();
        $(By.id("dl1~8~34")).shouldBe(Condition.visible).click();                  // Open Change Administrator Passwords
        $("#detailsTitle_top").shouldBe(Condition.visible);
        $(By.id("dl1~8~35")).shouldBe(Condition.visible).click();                  // Open new tab: Outstanding Manager Approvals
        // switchTo().window("Outstanding Manager Approvals");
        $("html body table tbody tr td img").shouldBe(Condition.image);
        switchTo().defaultContent();                                                // Event Log
        $("#p1\\~8\\~36").shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Event Log"));
        $(By.id("p1~8~37")).shouldBe(Condition.visible).click();                    // QNet Users On System: see questions
        switchTo().defaultContent();
        Selenide.closeWindow();
    }
}
