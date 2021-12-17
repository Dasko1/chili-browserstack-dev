package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SiteAppearance {

    public void siteAppearanceTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $(By.id("p0~3")).shouldBe(Condition.visible).click();
        $(By.id("p1~3~15")).shouldBe(Condition.visible).click();                            // Upload Files
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Upload Files"));
        $(By.id("p1~3~16")).shouldBe(Condition.visible).click();                            // Clone Client (Beta)
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Clone Client (Beta)"));
        $(By.id("p1~3~87")).shouldBe(Condition.visible).click();                            // Category Ads
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Category Ads"));
        $(By.id("p1~3~87")).shouldBe(Condition.visible).click();                            // Category Ads
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Category Ads"));
        $(By.id("p1~3~86")).shouldBe(Condition.visible).click();                            // Custom Catalog Navigation
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Custom Catalog Navigation"));
        $(By.id("p1~3~18")).shouldBe(Condition.visible).click();                            // Collapsible Category Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Collapsible Category Setup"));
        $(By.id("p1~3~94")).shouldBe(Condition.visible).click();                            // Customize Colors
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize Colors"));
        $(By.id("p1~3~20")).shouldBe(Condition.visible).click();                            // Customize Messages
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize Messages"));
        $(By.id("p1~3~21")).shouldBe(Condition.visible).click();                            // Customize Reports
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize Reports"));
        $(By.id("p1~3~95")).shouldBe(Condition.visible).click();                            // Ship Info & View Cart
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Ship Info & View Cart"));
        $(By.id("p1~3~23")).shouldBe(Condition.visible).click();                            // Customize New View Cart
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize New View Cart"));
        $(By.id("p1~3~22")).shouldBe(Condition.visible).click();                            // Customize Resupply
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize Resupply"));
        $(By.id("p1~3~83")).shouldBe(Condition.visible).click();                            // New Customize RFQ
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("New Customize RFQ"));
        $(By.id("p1~3~25")).shouldBe(Condition.visible).click();                            // Customize New Item
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize New Item"));
        $(By.id("p1~3~74")).shouldBe(Condition.visible).click();                            // Customize Checkout
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Customize Checkout"));
        $(By.id("p1~3~75")).shouldBe(Condition.visible).click();                            // e-Store Mobile Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("e-Store Mobile Setup"));
        $(By.id("p1~3~82")).shouldBe(Condition.visible).click();                            // Pending Orders
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Pending Orders"));
        $(By.id("p1~3~84")).shouldBe(Condition.visible).click();                            // Order Confirmation
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Order Confirmation"));
        $(By.id("p1~3~85")).shouldBe(Condition.visible).click();                            // Manager Approval Confirmation Email
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Manager Approval Confirmation Email"));
        $(By.id("p1~3~88")).shouldBe(Condition.visible).click();                            // Order Status Email
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Order Status Email"));
        $(By.id("p1~3~100")).shouldBe(Condition.visible).click();                            // EQ Commerce Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("EQ Commerce Setup"));
    }
}
