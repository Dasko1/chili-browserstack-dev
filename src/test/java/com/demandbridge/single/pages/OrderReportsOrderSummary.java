package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsOrderSummary extends BrowserStackTest {

    @Test
    public void orderReportsOrderSummaryTest(){

        // Open the Order Reports dropdown
        $(By.id("p0~26")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);

        // Click Order Summary link & push Run Report button
        $(By.id("dl1~26~12")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        switchTo().window(1);
        // Verify Report export buttons display and are active
        $("body > div.noPrint > input[type=button]:nth-child(3)").shouldBe(Condition.appear);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.appear);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }


}
