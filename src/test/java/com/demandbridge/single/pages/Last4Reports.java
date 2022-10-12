package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Last4Reports {

    @Test
    public void last4ReportsTest(){

        // Available Invoices
        Selenide.sleep(1500);
        $(By.id("dl0~36")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $("body > table > tbody:nth-child(2) > tr > td:nth-child(3)").shouldBe(Condition.text("SPARKS"));
        Selenide.sleep(2000);

        // Custom Reports
        switchTo().defaultContent();
        Selenide.sleep(2500);
        $(By.id("dl0~37")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $("body > table > tbody:nth-child(2) > tr > td:nth-child(1) > a").shouldBe(Condition.text("Inventory Analysis Report"));

        // Available Statements
        switchTo().defaultContent();
        Selenide.sleep(1500);
        $(By.id("dl0~38")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $("body > table > tbody:nth-child(2) > tr > td:nth-child(1) > a").shouldBe(Condition.text("Statement"));

        // Summary Bill Reports
        switchTo().defaultContent();
        Selenide.sleep(1500);
        $(By.id("dl0~43")).shouldBe(Condition.visible).click();
        switchTo().defaultContent();
        Selenide.sleep(2500);
    }
}
