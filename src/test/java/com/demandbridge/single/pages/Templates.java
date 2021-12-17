package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Templates {

    public void templatesTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $(By.id("p0~4")).shouldBe(Condition.visible).click();                               // Open Template dropdown
        $(By.id("p1~4~28")).shouldBe(Condition.visible).click();                            // Q-Design
        // $(By.id("detailsTitle_top")).shouldBe(Condition.text("SAP Setup"));
        switchTo().window("DISTRIBUTOR SETUP - QuantumNet Q-design");
        $("body > table:nth-child(22) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(2)")
                .shouldBe(Condition.text("Template List"));
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~4~98")).click();
        switchTo().window("QDesign");
        $(By.id("primary_nav_wrap")).shouldBe(Condition.visible);
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
        $(By.id("p1~4~29")).click();                                                        // Artwork Links
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Artwork Links"));
    }
}
