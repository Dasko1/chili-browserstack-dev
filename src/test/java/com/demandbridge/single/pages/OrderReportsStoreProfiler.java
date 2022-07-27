package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsStoreProfiler {

    @Test
    public void orderReportsStoreProfilerTest(){

        // Open the Order Reports dropdown, then the Sales dropdown
        $(By.id("p0~26")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);

        //Click the Store Profiler link
        $(By.id("dl1~26~21")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        Selenide.sleep(1500);
        $("#sltAllImg").scrollIntoView(true);
        // $(By.id("sltAllImg")).shouldBe(Condition.checked);                      // Select All is checked by default
        executeJavaScript("saveReport()");
        Selenide.sleep(5000);
        switchTo().window(1);
        $("body > div.noPrint > input[type=button]:nth-child(3)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
