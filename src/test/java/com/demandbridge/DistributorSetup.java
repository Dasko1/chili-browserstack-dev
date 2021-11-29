package com.demandbridge;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DistributorSetup {

    @Test
    public void distributorSetupTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/qnet-site-setup.cgi");
//        $("body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)")
//                .shouldBe(Condition.visible);
//        $("#dl0\\~1").shouldBe(Condition.visible).click();
//        $("#dl1\\~1\\~6 > div:nth-child(2)").shouldBe(Condition.visible);
    }

}
