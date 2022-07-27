package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Administration {

    @Test
    public void administrationTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/qnet-site-setup.cgi");
        $(By.id("inUserName")).sendKeys("automation@test.com");
        $(By.id("inPW")).sendKeys("password");
        $(By.className("eqd-SignIn")).click();
        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)")
                .shouldBe(Condition.visible);
        // Open the Administration dropdown; click and assert.
        $("#dl0\\~1").shouldBe(Condition.visible).click();
        // Assert Distributor Access: assert title & Client ID
        $("#dl1\\~1\\~6 > div:nth-child(2)").shouldBe(Condition.visible);
        $("#dl1\\~1\\~6 > div:nth-child(2)").shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.visible);
        // Click Login/Password & assert elements.
        $("#dl1\\~1\\~7 > div:nth-child(2)").shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Setup for password security options"));
        // Purge Thumbnails
        $(By.id("p1~1~9")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Purge Thumbnails"));
        // Upload Status Monitor
        $(By.id("dl1~1~72")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Upload Status Monitor"));
        // Distributor Setup Users
        $(By.id("dl1~1~97")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Distributor Setup Users"));
        $("#dl0\\~1").shouldBe(Condition.visible).click();                      // Close Administration
        Selenide.closeWindow();
    }
}
