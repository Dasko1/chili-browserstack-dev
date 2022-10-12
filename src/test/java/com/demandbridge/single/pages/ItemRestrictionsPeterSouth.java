package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemRestrictionsPeterSouth {

    @Test
    public void itemRestrictionsPeterSouthTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=peter@ez.com&Passwd=password");
        // Go to EZ Living Catalog. Select Category - Item Properties.
        $(By.linkText("EZ Living")).shouldBe(Condition.visible).click();
        Selenide.sleep(5000);
        $(By.id("B1~IP")).shouldBe(Condition.visible).click();
        Selenide.switchTo().frame(0);
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
