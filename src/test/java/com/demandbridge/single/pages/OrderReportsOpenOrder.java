package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsOpenOrder extends BrowserStackTest {

    @Test
    public void orderReportsOpenOrderTest(){

        // Open the Order Reports dropdown
        $(By.id("p0~26")).shouldBe(Condition.visible).click();

        $(By.id("dl1~26~3")).shouldBe(Condition.visible).click();                                                  // Click Open Order
        switchTo().frame("details");
        $("body > table > tbody > tr:nth-child(1) > td:nth-child(1) > img").shouldBe(Condition.visible).click();  // HMTL
        switchTo().window(1);
        Selenide.sleep(2000);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        switchTo().frame("details");
        $("body > table > tbody > tr:nth-child(2) > td:nth-child(1) > img").click();                      // Click PDF
        switchTo().window(0);
        Selenide.sleep(2000);
        //executeJavaScript("window.open('close.html', '_self')");
    }
}
