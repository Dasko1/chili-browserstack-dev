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
        $(By.linkText("EZ Living")).shouldBe(Condition.visible).click();                    // Click Shop link
        $(By.id("B1~IP")).shouldBe(Condition.visible).click();                              // Click Item Properties
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
    }
}
