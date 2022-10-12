package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserReportsAllowanceBalance {

    @Test
    public void userReportsAllowanceBalanceTest(){

        // Open User Reports dropdown & click on Allowance Balance
        Selenide.sleep(1500);
        // $(By.id("p0~28")).shouldBe(Condition.visible).click();
        $(By.id("dl1~28~15")).shouldBe(Condition.visible).click();
        Selenide.sleep(1500);
        switchTo().window(1);
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
