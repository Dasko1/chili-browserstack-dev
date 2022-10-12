package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserReportsAllowanceReport {

    @Test
    public void UserReportsAllowanceReportTest(){

        $(By.id("dl1~28~14")).shouldBe(Condition.visible).click();
        Selenide.sleep(1500);
        switchTo().window(1);
        Selenide.sleep(3500);
        // Open dropdown & select "email" & put your email address into the email field; push the Select button.
        // $(By.name("user_search_type")).click();
        $(By.name("user_search_type")).selectOptionByValue("Email");
        $(By.name("user_search")).sendKeys("adaskalopoulos@demandbridge.com");
        executeJavaScript("selectThisUserSearch()");
        $("body > form:nth-child(26) > table:nth-child(8) > tbody > tr:nth-child(1) > td > input[type=button]:nth-child(3)").shouldBe(Condition.visible);
        $("body > form:nth-child(26) > table:nth-child(8) > tbody > tr:nth-child(1) > td > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

    }
}
