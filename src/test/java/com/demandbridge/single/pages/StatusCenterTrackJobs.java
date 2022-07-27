package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class StatusCenterTrackJobs {

    @Test
    public void statusCenterTrackJobsTest(){

        // Click the Status Center Track Jobs link
        $(By.id("dl0~20")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        Selenide.sleep(1500);
        switchTo().window(1);
        Selenide.sleep(5500);
        $("body > div.whTitle").shouldBe(Condition.visible);                // Get Title
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
