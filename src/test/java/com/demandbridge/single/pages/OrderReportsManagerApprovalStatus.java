package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsManagerApprovalStatus {

    @Test
    public void orderReportsManagerApprovalStatusTest(){

        // Open the Order Reports dropdown, then the Sales dropdown; the dropdown might still be open from the last test!
        $(By.id("p0~26")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);

        // Click on the Manager Approval Status link
        $(By.id("dl1~26~42")).shouldBe(Condition.visible).click();
        Selenide.sleep(3500);
        switchTo().frame("details");
        Selenide.sleep(1500);
        executeJavaScript("runReport()");
        switchTo().window(1);
        Selenide.sleep(5500);
        $("body > div.whTitle").shouldBe(Condition.visible);                // Verify Title
        $("body > div.noPrint > input[type=button]:nth-child(4)").shouldBe(Condition.visible);
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.visible);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
