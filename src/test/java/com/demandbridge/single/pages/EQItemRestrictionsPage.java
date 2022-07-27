package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EQItemRestrictionsPage {

    @Test
    public void eqItemsRestricionsPageTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=peter@ez.com&Passwd=password");
        $(By.id("eqcNavShop")).shouldBe(Condition.visible).click();                     // Click Shop link
        $(By.className("eqd-Heading")).shouldHave(Condition.text("EZ Living"));
        $(By.id("B1~IP")).shouldBe(Condition.visible).click();                          // Click Item Properties
        Selenide.switchTo().frame(0);
        $(By.id("divID-ITEMPROP1")).shouldBe(Condition.visible);
        $(By.id("divItem-ITEMPROP8")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("ITEMPROP8"));
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("EZ Select Choice 8 - Not Restricted"));
        $(By.id("divItem-ITEMPROPA")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPA")).shouldHave(Condition.text("ITEMPROPA"));
        $(By.id("divItem-ITEMPROPA")).shouldHave(Condition.text("EZ Butterfinger -Southern Region wt .25/ex frt .15"));
        $(By.id("divItem-ITEMPROPC")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPC")).shouldHave(Condition.text("ITEMPROPC"));
        $(By.id("divItem-ITEMPROPC")).shouldHave(Condition.text("EZ Hershey Southern Region"));
        $(By.id("divItem-ITEMPROPI")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("ITEMPROPI"));
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("EZ Payday Southern Region max 5"));
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("Maximum Qty: 5"));
    }
}
