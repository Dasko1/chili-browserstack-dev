package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ItemRestrictionsRickyEast {

    public void itemRestrictionsRickyEastTest(){

        // User Ricky – limited to items for East
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=ricky@ez.com&Passwd=password");
        // Go to EZ Living Catalog. Select Category - Item Properties.
        $(By.linkText("EZ Living")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);
        $(By.linkText("Item Properties (5)")).shouldBe(Condition.visible).click();
        // Go to each frame and assert expected contents. Start with frame(0) and move right.
        Selenide.switchTo().frame(0);
        $(By.className("divCellMid")).shouldHave(Condition.text("ITEMPROP3"));
        $(By.className("divDescGrid")).shouldHave(Condition.text("EZ Select Choice 3"));
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
