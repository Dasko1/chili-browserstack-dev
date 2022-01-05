package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class DeleteUser extends BrowserStackTest {

    @Test
    public void deleteUser(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        // Administration > Distributor Access > REDS2 > Administrator Login > Admin Settings > Dropdown: Email > Enter Email
        $(By.id("dl0~1")).shouldBe(Condition.visible).click();
        $(By.id("dl1~1~6")).shouldBe(Condition.visible).click();
        // Switch to iFrame
        switchTo().innerFrame("details");
        $("#distributor > tbody:nth-child(2) > tr:nth-child(85) > td:nth-child(6)").scrollIntoView(true).click();
        $(By.xpath("/html/body/div[3]/div[2]/div")).shouldBe(Condition.visible).click();
        Selenide.sleep(1000);
        switchTo().window("EQ Commerce");
        Selenide.sleep(2000);
        $(By.xpath("//*[@id=\"eqcNavAdmin\"]")).shouldBe(Condition.visible).click();
        $("#UserSearchTypeB").selectOptionContainingText("Email");
        $(By.name("UserSearchB")).sendKeys("newuser101@test.com");
        $("html body.eqd-Body div.uaWrapper div.uaHLine div.uaLSide div.eqcButtonStd.uaButton").click();    // Search button
        Selenide.sleep(3000);
        $(By.xpath("//*[@id=\"delete1\"]")).shouldBe(Condition.visible).click();                                               // Checkbox
        $("div.eqcButtonStd:nth-child(5)").click();                                                        // Delete button
        $(By.className("QNET_ConfirmButtonOK")).shouldBe(Condition.visible).click();                                // No button
        executeJavaScript("deleteSelectedUsers();");
        $(By.className("QNET_ConfirmButtonCancel")).shouldBe(Condition.visible).click();
        Selenide.sleep(3000);
        Selenide.closeWindow();
    }
}
