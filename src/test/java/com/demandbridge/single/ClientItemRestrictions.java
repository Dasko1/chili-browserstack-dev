package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ClientItemRestrictions extends BrowserStackTest {

    @Test
    public void clientItemRestrictionsTest(){

        // Step 1:
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=amber@sm-1.com&Passwd=password");
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(1) > td:nth-child(2) > img").shouldBe(Condition.image);
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(2) > td:nth-child(2) > a:nth-child(2) > img")
                .shouldBe(Condition.visible);                                   // Assert Online Ordering, Home & Search
        $(By.name("SEARCH")).shouldBe(Condition.visible);
        // Search for item: RESTRICT1
        $(By.name("SEARCH")).click();
        $(By.name("SEARCH")).shouldBe(Condition.visible).sendKeys("RESTRICT1");
        // $(By.name("SEARCH")).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        $("#divSearchArea2 > div.qnsearch > span:nth-child(3) > i").click();                       // Click Search icon
        Selenide.sleep(2000);
        $(By.id("bPMAddToCart")).shouldBe(Condition.exist);
        Selenide.switchTo().frame(0);                                       // Switch to Active Frame, which is "0"!
        $(By.id("Q_1")).shouldBe(Condition.visible);                             // Quantity field
        $(By.id("Q_1")).shouldBe(Condition.empty);
        $("div.GridButton:nth-child(1)").shouldBe(Condition.visible);
        $("div.GridButton:nth-child(2)").shouldBe(Condition.visible);

         // Step 2:
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=henry@sm2.com&Passwd=password");
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(1) > td:nth-child(2) > img").shouldBe(Condition.image);
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(2) > td:nth-child(2) > a:nth-child(2) > img")
                .shouldBe(Condition.visible);                                   // Assert Online Ordering, Home & Search
        $(By.name("SEARCH")).shouldBe(Condition.visible);
        // Search for item: RESTRICT1
        $(By.name("SEARCH")).click();
        $(By.name("SEARCH")).shouldBe(Condition.visible).sendKeys("RESTRICT1");
        // $(By.name("SEARCH")).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        $("#divSearchArea2 > div.qnsearch > span:nth-child(3) > i").click();                       // Click Search icon
        Selenide.sleep(2000);
        $(By.id("bPMAddToCart")).shouldBe(Condition.exist);
        Selenide.switchTo().frame(0);                                       // Switch to Active Frame, which is "0"!
        $(By.id("Q_1")).shouldBe(Condition.visible);                             // Quantity field
        $(By.id("Q_1")).shouldBe(Condition.empty);
        $("div.GridButton:nth-child(1)").shouldBe(Condition.visible);
        $("div.GridButton:nth-child(2)").shouldBe(Condition.visible);

        // Step 3:
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=user@sm3.com&Passwd=password");
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(1) > td:nth-child(2) > img").shouldBe(Condition.image);
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(2) > td:nth-child(2) > a:nth-child(2) > img")
                .shouldBe(Condition.visible);                                   // Assert Online Ordering, Home & Search
        $(By.name("SEARCH")).shouldBe(Condition.visible);
        // Search for item: RESTRICT1
        $(By.name("SEARCH")).click();
        $(By.name("SEARCH")).shouldBe(Condition.visible).sendKeys("RESTRICT1");
        // $(By.name("SEARCH")).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        $("#divSearchArea2 > div.qnsearch > span:nth-child(3) > i").click();                       // Click Search icon
        Selenide.sleep(2000);
        $(By.id("bPMAddToCart")).shouldBe(Condition.exist);
        Selenide.switchTo().frame(0);                                       // Switch to Active Frame, which is "0"!
        $(By.id("Q_1")).shouldBe(Condition.visible);                             // Quantity field
        $(By.id("Q_1")).shouldBe(Condition.empty);
        $("div.GridButton:nth-child(1)").shouldBe(Condition.visible);
        $("div.GridButton:nth-child(2)").shouldBe(Condition.visible);

        // Step 4: Verify that RESTRICT1 does not appear. An alert appears saying item not available: accept & pass the test.
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=craig@sm4.com&Passwd=password");
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(1) > td:nth-child(2) > img").shouldBe(Condition.image);
        $("#qnBody > table:nth-child(17) > tbody > tr:nth-child(2) > td:nth-child(2) > a:nth-child(2) > img")
                .shouldBe(Condition.visible);                                   // Assert Online Ordering, Home & Search
        $(By.name("SEARCH")).shouldBe(Condition.visible);
        // Search for item: RESTRICT1
        $(By.name("SEARCH")).click();
        $(By.name("SEARCH")).shouldBe(Condition.visible).sendKeys("RESTRICT1");
        Selenide.sleep(2000);
        $("#divSearchArea2 > div.qnsearch > span:nth-child(3) > i").click();                       // Click Search icon
        sleep(5000);
        switchTo().alert().accept();

        // Step 5: Verify that RESTRICT1 does not appear.
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=user@smith.com&Passwd=password");
        $(By.name("SEARCH")).shouldBe(Condition.visible);
        // Search for item: RESTRICT1
        $(By.name("SEARCH")).click();
        $(By.name("SEARCH")).shouldBe(Condition.visible).sendKeys("RESTRICT1");
        Selenide.sleep(2000);
        $(By.className("qnsearchButton")).click();                       // Click Search icon
        sleep(5000);
        switchTo().alert().accept();


        Selenide.sleep(3000);
        Selenide.closeWindow();
    }
}
