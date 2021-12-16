package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Setup {

    public void setupTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)")
                .shouldBe(Condition.visible);
        $(By.id("dl0~2")).shouldBe(Condition.visible).click();                      // Open Setup dropdown
        $(By.id("p1~2~80")).shouldBe(Condition.visible).click();                    // Site Options
        $("#detailsTitle_top").shouldBe(Condition.text("Site Options"));
        $(By.id("p1~2~12")).shouldBe(Condition.visible).click();                    // Category Min/Max setup
        $("#detailsTitle_top").shouldBe(Condition.text("Category Min/Max setup"));
        $(By.id("p1~2~13")).click();                                                // Unit Code Alias Editor
        $("#detailsTitle_top").shouldBe(Condition.text("Unit Code Alias Editor"));
        $(By.id("p1~2~14")).click();                                                // Target Sales
        $("#detailsTitle_top").shouldBe(Condition.text("Target Sales"));
        $(By.id("p1~2~33")).click();                                                // Merchant Accounts
        $("#detailsTitle_top").shouldBe(Condition.text("Merchant Accounts"));
        $(By.id("p1~2~71")).click();                                                // Select Distributor Setup Shortcuts
        $("#detailsTitle_top").shouldBe(Condition.text("Select Distributor Setup Shortcuts"));
        Selenide.sleep(1000);
    }
}
