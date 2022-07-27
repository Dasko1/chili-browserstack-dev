package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class OrderReportsCategoryGraph {

    public void orderReportCategoryGraphTest(){

        // Go to page and login: verify that login succeeds. The below URL is EQC, the new one.
        //open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=adaskalopoulos@demandbridge.com&Passwd=reds2");

        // Push Reports element
        // $(By.id("eqcNavReports")).shouldBe(Condition.visible).click();

        // Open the Order Reports dropdown
        $(By.id("p0~26")).shouldBe(Condition.visible).click();

        // Click Category Graph & Run Report button, switch windows and confirm
        $("#dl1\\~26\\~13 > span").click();
        switchTo().frame("details");
        $("body > form > table > tbody > tr:nth-child(4) > td > input[type=button]").shouldBe(Condition.visible).click();
        Selenide.sleep(45000);
        switchTo().window(1);
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
    }
}
