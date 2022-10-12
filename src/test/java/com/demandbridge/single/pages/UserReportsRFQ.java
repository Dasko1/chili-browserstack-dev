package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserReportsRFQ {

    @Test
    public void userReportsRFQTest(){

        $(By.id("dl1~28~16")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        Selenide.sleep(3500);
        executeJavaScript("RunReport()");
        Selenide.sleep(1500);
        switchTo().window(1);
        $("body > div").shouldBe(Condition.text("RFQ List"));
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
