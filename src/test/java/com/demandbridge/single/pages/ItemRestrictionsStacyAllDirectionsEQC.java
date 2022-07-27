package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemRestrictionsStacyAllDirectionsEQC {

    @Test
    public void itemRestrictionsStacyAllDirectionsEQCTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=stacy@ez.com&Passwd=password ");
        $(By.id("eqcNavShop")).shouldBe(Condition.visible).click();                     // Click Shop link
        $(By.className("eqd-Heading")).shouldHave(Condition.text("EZ Living"));
        $(By.id("B1~IP")).shouldBe(Condition.visible).click();                          // Click Item Properties
        Selenide.switchTo().frame(0);
        $(By.id("divItem-ITEMCOMBO1")).shouldBe(Condition.visible);
        $(By.id("divItem-ITEMCOMBO1")).shouldHave(Condition.text("IP North"));
        $(By.id("divItem-ITEMCOMBO1")).shouldHave(Condition.text("ITEMCOMBO1"));
        $(By.id("divItem-ITEMCOMBO1")).shouldHave(Condition.text("Item not available/ EA"));
        $(By.id("divItem-ITEMCOMBO1")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMCOMBO2")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.text("IP North"));
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.text("ITEMCOMBO2"));
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.text("$8.00 / EA"));
        $(By.id("divItem-ITEMCOMBO2")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP1")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP1")).shouldHave(Condition.text("EZ Select Choice 1 - Southern Region"));
        $(By.id("divItem-ITEMPROP1")).shouldHave(Condition.text("ITEMPROP1"));
        $(By.id("divItem-ITEMPROP1")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP1")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP2")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("EZ Select Choice 2 - Northern Region"));
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("ITEMPROP2"));
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP2")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP3")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP3")).shouldHave(Condition.text("EZ Select Choice 3 - Eastern Region"));
        $(By.id("divItem-ITEMPROP3")).shouldHave(Condition.text("ITEMPROP3"));
        $(By.id("divItem-ITEMPROP3")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP3")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP4")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("EZ Select Choice 4 - Western Region"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("ITEMPROP4"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP4")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP5")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("EZ Select Choice 5 - Western Region"));
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("ITEMPROP5"));
        $(By.id("divItem-ITEMPROP5")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP5")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP6")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP6")).shouldHave(Condition.text("EZ Select Choice 6 - Northern Region"));
        $(By.id("divItem-ITEMPROP6")).shouldHave(Condition.text("ITEMPROP6"));
        $(By.id("divItem-ITEMPROP6")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP6")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP7")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("EZ Select Choice 7 - Western Region"));
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("ITEMPROP7"));
        $(By.id("divItem-ITEMPROP7")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP7")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROP8")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("EZ Select Choice 8 - Not Restricted"));
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("ITEMPROP8"));
        $(By.id("divItem-ITEMPROP8")).shouldHave(Condition.text("$4.75 / EA"));
        $(By.id("divItem-ITEMPROP8")).shouldNotHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPA")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPA")).shouldHave(Condition.text("EZ Butterfinger -Southern Region wt .25/ex frt .15"));
        $(By.id("divItem-ITEMPROPA")).shouldHave(Condition.text("ITEMPROPA"));
        $(By.id("divItem-ITEMPROPA")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPA")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPB")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("EZ Heath Eastern Region"));
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("ITEMPROPB"));
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPB")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPC")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPC")).shouldHave(Condition.text("EZ Hershey Southern Region"));
        $(By.id("divItem-ITEMPROPC")).shouldHave(Condition.text("ITEMPROPC"));
        $(By.id("divItem-ITEMPROPC")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPC")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPD")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("EZ Twix Eastern Region"));
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("ITEMPROPD"));
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("$0.65 / EA"));
        $(By.id("divItem-ITEMPROPD")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPE")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("EZ Baby Ruth Northern Region"));
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("ITEMPROPE"));
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPE")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPF")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("EZ Milkyway Western Region"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("ITEMPROPF"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPF")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPG")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("EZ Mounds Northern Region"));
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("ITEMPROPG"));
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPG")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPH")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("EZ Snickers Northern Region max 5"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("Maximum Qty: 5"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("ITEMPROPH"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPH")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPI")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("EZ Payday Southern Region max 5"));
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("Maximum Qty: 5"));
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("ITEMPROPI"));
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPI")).shouldHave(Condition.text("Add to Cart"));
        $(By.id("divItem-ITEMPROPJ")).shouldBe(Condition.exist);
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("EZ Almond Joy Eastern Region max 5"));
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("Maximum Qty: 5"));
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("ITEMPROPJ"));
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("$0.75 / EA"));
        $(By.id("divItem-ITEMPROPJ")).shouldHave(Condition.text("Add to Cart"));
    }
}
