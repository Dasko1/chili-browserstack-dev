package com.demandbridge.single;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Retail {

    @Test
    public void retailTest() {

        open("https://qnet.e-quantum2k.com/~support2/Custom/REDS-R/RETAIL/cgi-bin/qnet-main-rs.cgi");
        $(By.className("eqd-Heading")).shouldBe(Condition.visible);
        $$(By.className("eqc-NavButton")).shouldBe(CollectionCondition.itemWithText("SHOP"));
        $$(By.className("eqc-NavButton")).shouldBe(CollectionCondition.itemWithText("CONTACT US"));
        $("#divDetail > center:nth-child(1) > img:nth-child(1)").shouldBe(Condition.visible);
        $(By.className("eqcFooter")).shouldBe(Condition.visible);
        $(By.className("eqcNavCorner")).shouldBe(Condition.visible);
        $(By.className("eqcAccountDesc")).shouldBe(Condition.visible);
        $(By.className("eqcAccountAlert")).shouldBe(Condition.visible);

        // Click Shop & make assertions.
        $(By.id("eqcNavShop")).click();
        $(By.id("CatalogNode")).shouldBe(Condition.visible);
        $(By.className("qnsearchButton")).shouldBe(Condition.visible);
        $(By.linkText("Distributor Catalog")).shouldBe(Condition.visible);
        $(By.linkText("SanMar Logoizer")).shouldBe(Condition.visible);
        $(By.linkText("Sanmar Non-logoizer")).shouldBe(Condition.visible);
        $(By.linkText("Sage Punchout")).shouldBe(Condition.visible);
        $(By.linkText("Essendant")).shouldBe(Condition.visible);

        // Promotional Items Flow
        $(By.id("B1~PROM")).shouldBe(Condition.visible).click();
        executeJavaScript("showItemDetail('APP001','REDS-R','REDS1','1','Y','1000');");
        switchTo().activeElement();
        $(By.className("idImgMain")).shouldBe(Condition.image);
        $(By.id("kitTab2")).shouldBe(Condition.enabled);
        $(By.className("kitSuggestedSellTitle")).shouldBe(Condition.text("SUGGESTED ITEMS"));
        $(".kitSuggestedCell > img:nth-child(1)").shouldBe(Condition.image).click();
        $(By.id("kitTab1")).click();
        $(By.className("kitTabAreaPage")).shouldBe(Condition.text("A solid choice! No need to complicate your wardrobe decisions. " +
                "Our classic fit soft cotton pique polos go with everything."));
        $(".kitSuggestedCell > img:nth-child(1)").click();
        $(By.className("eqd-FormLabel")).shouldHave(Condition.text("RESTAURANT"));
        $("#ATTRIB-003").click();
        $("#ATTRIB-003 > option:nth-child(3)").click();
        $(By.id("UPM_1")).shouldBe(Condition.text("$13.80"));
        $(By.id("UPM_2")).shouldBe(Condition.text("$13.80"));
        $(By.id("UPM_3")).shouldBe(Condition.text("$13.80"));
        $(By.className("idPM_Matrix1_CellInnerL2")).shouldBe(Condition.text("+ $2.50/unit"));
        $(By.id("PMX001_1Y002_6")).shouldBe(Condition.visible).sendKeys("1");
        $(By.className("idAddToCartM")).click();

        // Click Shopping Cart.
        $(By.className("eqcViewCart2On")).shouldBe(Condition.visible).click();
        $(By.className("eqd-Title")).shouldBe(Condition.text("Cart Summary"));
        $(By.className("eqc-NavBar")).shouldBe(Condition.text("SHOP"));
        $(By.className("eqc-NavBar")).shouldBe(Condition.text("CONTACT US"));
        $(By.id("IMGPOP1")).hover();
        $(By.id("Lprice1")).shouldBe(Condition.text("13.80"));
        $(By.id("divVCGrandTotalValue")).shouldBe(Condition.text("$16.30"));
        $("div.eqcButtonStd:nth-child(1)").shouldBe(Condition.visible);             // Assert Remove All button

        // Push Continue To Shipping Button: ad@qgowwpz9.mailosaur.net/abcd1234 for login if needed.
        $(By.id("divShipButton")).shouldBe(Condition.visible).click();
        $(By.name("fSignInLogin")).shouldBe(Condition.visible).sendKeys("ad@qgowwpz9.mailosaur.net");
        $(By.name("fSignInPassword")).shouldBe(Condition.visible).sendKeys("abcd1234");
        $(By.className("eqd-SignIn")).click();
        $(By.name("NextStep")).shouldBe(Condition.visible).click();

        // Checkout page
        $(By.className("eqd-Title")).shouldBe(Condition.visible);
        $(By.className("c2PayCheck")).scrollIntoView(true);
        $(By.id("svgC1")).shouldBe(Condition.visible).click();
        Selenide.sleep(1000);
        $(By.className("c2PayCheck")).shouldBe(Condition.enabled);
        $(By.id("divSubmitButton")).shouldBe(Condition.visible).click();

        // Order Submitted page
        $(By.id("qnocDivUserName")).shouldBe(Condition.visible);
        $(By.id("qnocMsgTop")).shouldBe(Condition.visible);
        Selenide.sleep(3000);
    }
}
