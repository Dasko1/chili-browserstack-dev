package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsSalesReports {

    @Test
    public void salesReports() {

        // Open the Order Reports dropdown, then the Sales dropdown
        $(By.id("p0~26")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);
        $(By.id("p1~26~30")).shouldBe(Condition.visible).click();

        // Click Detail Sales, go to the Report tab and verify buttons
        $(By.id("dl2~26~30~22")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Click Sales
        $(By.id("dl2~26~30~18")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Click Sanmar Sales
        $(By.id("dl2~26~30~23")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        executeJavaScript("RunReport()");
        Selenide.sleep(15000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(3)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);

        // Click Store Profiler
        $(By.id("dl1~26~21")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        executeJavaScript("saveReport()");
        Selenide.sleep(10000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(3)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
