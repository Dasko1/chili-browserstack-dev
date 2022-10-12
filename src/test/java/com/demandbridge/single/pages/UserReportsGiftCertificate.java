package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserReportsGiftCertificate {

    @Test
    public void userReportsGiftCertificateTest(){

        $(By.id("dl1~28~17")).shouldBe(Condition.visible).click();
        Selenide.sleep(1500);
        switchTo().window(1);
        Selenide.sleep(3500);
        // Check for Open Gift Certificate button
        $(By.className("qnCS_def_btn")).shouldBe(Condition.visible);
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }

}
