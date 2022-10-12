package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Last4ReportsCustomReports {

    @Test
    public void last4ReportsCustomReportsTest(){

        // Custom Reports
        Selenide.sleep(2500);
        $(By.linkText("Custom Reports")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $("body > table > tbody:nth-child(2) > tr > td:nth-child(1) > a").shouldBe(Condition.text("Inventory Analysis Report"));

    }
}
