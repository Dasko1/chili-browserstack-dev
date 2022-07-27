package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemRestrictionsSandraNorthEQC {

    @Test
    public void itemRestrictionsSandraNorthEQCTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=sandra@ez.com&Passwd=password ");
        $(By.id("eqcNavShop")).shouldBe(Condition.visible).click();                     // Click Shop link
        $(By.className("eqd-Heading")).shouldHave(Condition.text("EZ Living"));
        $(By.id("B1~IP")).shouldBe(Condition.visible).click();                          // Click Item Properties
        Selenide.switchTo().frame(0);
        $(By.id("divItem-ITEMCOMBO1")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMCOMBO1")).shouldHave(Condition.text("ITEMCOMBO1"));
        $(By.id("divItem-ITEMCOMBO1")).shouldHave(Condition.text("Item not available/ EA"));
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.exist);
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.text("ITEMCOMBO2"));
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.text("$8.00 / EA"));
        $(By.id("divItem-ITEMPROP2")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("ITEMPROP2"));
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("EZ Select Choice 2 - Northern Region"));
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP6")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP6")).shouldHave(Condition.text("ITEMPROP6"));
        $(By.id("divItem-ITEMPROP6")).shouldHave(Condition.text("EZ Select Choice 6 - Northern Region"));
        $(By.id("divItem-ITEMPROP6")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP8")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("ITEMPROP8"));
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("EZ Select Choice 8 - Not Restricted"));
        $(By.id("divItem-ITEMPROP8")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPE")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("ITEMPROPE"));
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("EZ Baby Ruth Northern Region"));
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPG")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("ITEMPROPG"));
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("EZ Mounds Northern Region"));
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPH")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("ITEMPROPH"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("EZ Snickers Northern Region max 5"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("Maximum Qty: 5"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("Add to Cart"));
    }
}
