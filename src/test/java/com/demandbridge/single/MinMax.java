package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class MinMax extends BrowserStackTest {

    @Test
    public void minMaxTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=nicole@ez.com&Passwd=password");
        $("title").shouldHave(attribute("text", "EZ Living- Main"));                // Assert title
        $(By.id("tblHeaderTabs")).shouldHave(Condition.text("User nicole@ez.com on support2, client EZ"));                 // Assert text
        $(By.name("ViewCartImg")).shouldBe(Condition.visible).click();                                                     // Open cart
        // Assert Cart Items
        $(By.id("Approval2")).shouldHave(Condition.text("Special Items over $100 rejected on Submit"));
        $(By.id("Lqty2")).shouldHave(Condition.value("5.00"));
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys("6");
        $(By.id("Lqty2")).sendKeys(Keys.RETURN);
        $(By.id("Approval2")).shouldNotHave(exactText("Special Items over $100 rejected on Submit"));
        // $(By.id("qtyNotes2")).shouldHave(Condition.text("Min/Max set to reject"));
        // Push Checkout button; accept alert, return qty to 5 & checkout
        $(By.name("CheckOutImg")).shouldBe(Condition.visible).click();
        Selenide.sleep(3000);
        switchTo().alert().accept();
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys(Keys.BACK_SPACE);
        $(By.id("Lqty2")).sendKeys("5");
        $(By.name("CheckOutImg")).shouldBe(Condition.visible).click();
        Selenide.sleep(2000);
        // Push Checkout button with Quantity of <5 & <100 for each item in Cart; check Pay by Cash
        $(By.name("CheckOutImg")).shouldBe(Condition.visible).click();
        $(By.id("cbC1")).scrollIntoView(true);
        $(By.id("cbC1")).shouldBe(Condition.visible).click();
        $(By.id("cbC1")).shouldBe(Condition.enabled);
        $(By.className("checkoutSubmit2")).shouldBe(Condition.visible).click();                             // Popup will appear.
        Selenide.sleep(1500);
        switchTo().alert().accept();

        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.urlContains("qnet-checkout2.cgi"));
            wait.until(ExpectedConditions.titleIs("Checkout"));
            markTestStatus("passed", "Yaay the Title contains 'Checkout'!",driver);
            markTestStatus("passed","Yaay the URL contains 'qnet-checkout2.cgi'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","The URL does not contain 'qnet-checkout2.cgi'",driver);
            markTestStatus("failed", "The Title does not contain 'Checkout'",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}
