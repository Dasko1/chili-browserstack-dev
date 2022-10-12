// Checks the box to go to the
package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ItemPropertiesRestrictionsEQC {

    @Test
    public void itemPropertiesRestrictionsEQCTest(){

        // Check checkbox for new admin
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/qnet-site-setup.cgi");
        $(By.id("inUserName")).shouldBe(Condition.visible).sendKeys("automation@test.com");
        $(By.id("inPW")).shouldBe(Condition.visible).sendKeys("password");
        executeJavaScript("loginSession()");
        // $(By.className("eqd-SignIn")).shouldBe(Condition.visible).click();
        // $("title").shouldHave(attribute("text", "DISTRIBUTOR SETUP - QuantumNet Main"));
        // Click Site Appearance > EQ Commerce Setup
        $(By.id("dl0~3")).shouldBe(Condition.visible).click();
        $(By.id("p1~3~100")).shouldBe(Condition.visible).click();
        // Enter 'EZ' in top field and select 'EZ Living'.  Go to the frame first.
        Selenide.switchTo().frame("details");
        $(By.id("qnCS_Client_Search")).sendKeys(Keys.ENTER);
        $(By.id("qnCS_Client_Search")).sendKeys(Keys.BACK_SPACE);

        // Use a loop to backspace and clear the field; the CLEAR command does not do anything
        int x = 1;
        while (x < 19){
            $(By.id("qnCS_Client_Search")).sendKeys(Keys.BACK_SPACE);
            x++;
        }

        Selenide.sleep(2000);
//        $(By.id("qnCS_Client_Search")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        Selenide.sleep(2000);
        $(By.id("qnCS_Client_Search")).shouldBe(Condition.visible).sendKeys("EZ");
        Selenide.sleep(3000);
        $(By.id("EZ")).shouldBe(Condition.visible).click();
        // $("#EZ > div.qnCS_rCol.qnCS_rColW3").shouldBe(Condition.visible).click();
        Selenide.sleep(2000);
        $("#divOptions > div:nth-child(1)").shouldBe(Condition.visible).click();                    // Click Site Options link
        Selenide.sleep(1500);
        $("#divWorkSpace > div:nth-child(1)").shouldBe(Condition.visible);                          // Site Options visible
        Selenide.sleep(1500);
        $(By.id("inputValue-0")).shouldBe(Condition.visible).click();                                        // Check Enable EQ Commerce
        Selenide.sleep(1500);
        $("#divWorkSpace > div:nth-child(1) > div:nth-child(2) > input[type=button]").click();      // Push Save button

        Selenide.sleep(3000);
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=ricky@ez.com&Passwd=password");
    }
}
