package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemRestrictionsTobyWest {

    @Test
    public void itemRestrictionsTobyWestTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=toby@ez.com&Passwd=password");
        // Go to EZ Living Catalog. Select Category - Item Properties.
        $(By.linkText("EZ Living")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);
        $(By.linkText("Item Properties (5)")).shouldBe(Condition.visible).click();
        Selenide.switchTo().frame(0);
        $(By.id("divItem-ITEMPROP4")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("ITEMPROP4"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("EZ Select Choice 4 - Western Region"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("Qty:"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("Show Details"));
        $(By.id("divItem-ITEMPROP5")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("ITEMPROP5"));
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("EZ Select Choice 5 - Western Region"));
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP5")).shouldNotHave(Condition.text("Qty:"));
        $(By.id("divItem-ITEMPROP5")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("Show Details"));
        $(By.id("divItem-ITEMPROP7")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("ITEMPROP7"));
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("EZ Select Choice 7 - Western Region"));
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP7")).shouldNotHave(Condition.text("Qty:"));
        $(By.id("divItem-ITEMPROP7")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("Show Details"));
        $(By.id("divItem-ITEMPROPF")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("ITEMPROPF"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("EZ Milkyway Western Region"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("Qty:"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("Show Details"));
    }
}
