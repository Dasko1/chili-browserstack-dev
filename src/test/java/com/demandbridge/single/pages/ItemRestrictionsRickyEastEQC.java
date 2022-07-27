package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemRestrictionsRickyEastEQC {

    @Test
    public void itemRestrictionsRickyEastEQCTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=ricky@ez.com&Passwd=password");
        $(By.id("eqcNavShop")).shouldBe(Condition.visible).click();                     // Click Shop link
        $(By.className("eqd-Heading")).shouldHave(Condition.text(""));
        $(By.id("B1~IP")).shouldBe(Condition.visible).click();                          // Click Item Properties
        Selenide.switchTo().frame(0);
        $(By.id("divItem-ITEMPROP3")).shouldHave(Condition.text("ITEMPROP3"));
        $(By.id("divItem-ITEMPROP3")).shouldHave(Condition.text("EZ Select Choice 3"));
        $(By.id("imgPic-ITEMPROP3")).shouldBe(Condition.image);
        // Next frame, I think, or I found what to look for on the page!
        $(By.id("divItem-ITEMPROP8")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("ITEMPROP8"));
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("EZ Select Choice 8 - Not Restricted\n"));
        $(By.id("divItem-ITEMPROPB")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("ITEMPROPB"));
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("EZ Heath Eastern Region"));
        $(By.id("divItem-ITEMPROPD")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("ITEMPROPD"));
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("$0.65 / EA"));
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("EZ Twix Eastern Region"));
        $(By.id("divItem-ITEMPROPJ")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("ITEMPROPJ"));
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("EZ Almond Joy Eastern Region max 5"));
    }
}
