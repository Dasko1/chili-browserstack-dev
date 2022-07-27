package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserReportsAllowance {

    @Test
    public void userReportsAllowanceTest(){

        // Open the User Reports dropdown and click on Allowance: verify Export buttons and Close
        $(By.id("p0~28")).shouldBe(Condition.visible).click();
        $(By.id("dl1~28~40")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        Selenide.sleep(1500);
        switchTo().window(1);
        Selenide.sleep(5500);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
