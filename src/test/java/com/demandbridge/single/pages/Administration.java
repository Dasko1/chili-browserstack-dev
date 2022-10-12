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
        $("body > div > div:nth-child(2) > div.eqd-SignIn").shouldBe(Condition.visible).click();
        Selenide.sleep(1500);

        // Open the Administration dropdown; click and assert.
        $("#dl0\\~1").shouldBe(Condition.visible).click();
        Selenide.sleep(1500);
        // Assert Distributor Access: assert title & Client ID
        $(By.id("dl1~1~6")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.visible);

        // Click Login/Password & assert elements.
        $(By.id("dl1~1~7")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Setup for password security options"));
        // Purge Thumbnails
        $(By.id("dl1~1~9")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Purge Thumbnails"));
        // Upload Status Monitor
        $(By.id("dl1~1~72")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Upload Status Monitor"));
        // Distributor Setup Users
        $(By.id("dl1~1~97")).shouldBe(Condition.visible).click();
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Distributor Setup Users"));
        $("#dl0\\~1").shouldBe(Condition.visible).click();                      // Close Administration
    }
}
