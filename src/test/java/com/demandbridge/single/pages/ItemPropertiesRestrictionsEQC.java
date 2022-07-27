// Checks the box to go to the
package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemPropertiesRestrictionsEQC {

    @Test
    public void itemPropertiesRestrictionsEQCTest(){

        // Check checkbox for new admin
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/qnet-site-setup.cgi");
        $(By.id("inUserName")).shouldBe(Condition.visible).sendKeys("automation@test.com");
        $(By.id("inPW")).shouldBe(Condition.visible).sendKeys("password");
        $(By.className("eqd-SignIn")).shouldBe(Condition.visible).click();
        $("title").shouldHave(attribute("text", "DISTRIBUTOR SETUP - QuantumNet Main"));
        // Click Site Appearance > EQ Commerce Setup
        $(By.id("dl0~3")).shouldBe(Condition.visible).click();
        $(By.id("p1~3~100")).shouldBe(Condition.visible).click();
        // Enter 'EZ' in top field and select 'EZ Living'.  Go to the frame first.
        Selenide.switchTo().frame("details");
        $(By.id("qnCS_Client_Search")).sendKeys(Keys.ENTER);
        $(By.id("qnCS_Client_Search")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $(By.id("qnCS_Client_Search")).sendKeys(Keys.BACK_SPACE);
        Selenide.sleep(2000);
        $(By.id("qnCS_Client_Search")).shouldBe(Condition.visible).sendKeys("EZ");
        Selenide.sleep(3000);
        $("#EZ > div.qnCS_rCol.qnCS_rColW3").shouldBe(Condition.visible).click();
        Selenide.sleep(2000);
        $("#divOptions > div:nth-child(1)").shouldBe(Condition.visible).click();                    // Click Site Options link
        Selenide.sleep(1500);
        $("#divWorkSpace > div:nth-child(1)").shouldBe(Condition.visible);                          // Site Options visible
        Selenide.sleep(1500);
        $(By.id("inputValue-0")).shouldBe(Condition.visible).click();                                        // Check Enable EQ Commerce
        Selenide.sleep(1500);
        $("#divWorkSpace > div:nth-child(1) > div:nth-child(2) > input[type=button]").click();      // Push Save button

        Selenide.sleep(5000);
    }
}
