package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsOrderTracking {

    @Test
    public void orderReportsOrderTrackingTest(){

        // Go to Reports, then open Order Reports dropdown, then the Order Tracking dropdown
        // $(By.className("eqc-NavButton")).shouldBe(Condition.visible).click();
        $(By.id("p0~26")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);
        $(By.id("p1~26~29")).shouldBe(Condition.visible).click();

        // Click Order Tracking Exportable 1
        $(By.id("dl2~26~29~45")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        // Verify Report export buttons display and are active
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.appear);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.appear);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Click Order Tracking Exportable 2
        $(By.id("dl2~26~29~47")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        // Verify Report export buttons display and are active
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.appear);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.appear);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Click Order Tracking by line
        $(By.id("dl2~26~29~31")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        // Verify Report export buttons display and are active
        $("head > title").shouldHave(Condition.attribute("text", "Order Tracking report shown by line Item"));
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Click Order Tracking Exportable and verify buttons
        $(By.id("dl2~26~29~19")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.appear);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.appear);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Original Order Tracking Online
        $(By.id("dl2~26~29~9")).shouldBe(Condition.visible).click();
        Selenide.sleep(2500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(1)").shouldBe(Condition.appear);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);


        Selenide.sleep(3000);
    }
}
