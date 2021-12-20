package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OptionalModules {

    @Test
    public void optionalModulesTest(){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=support2&Passwd=support2FMDS");
        $(By.id("p0~5")).shouldBe(Condition.visible).click();                               // Open Optional Modules dropdown
        $(By.id("p1~5~31")).shouldBe(Condition.visible).click();                            // Digital Library
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Digital Library Users, Groups and configuration"));
        $(By.id("p1~5~32")).shouldBe(Condition.visible).click();                            // Punchouts
        $(By.id("dl2~5~32~48")).shouldBe(Condition.visible).click();                        // Ariba
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Ariba Setup"));
        $(By.id("dl2~5~32~49")).click();                                                    // Artina
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Artina Setup"));
        $(By.id("dl2~5~32~50")).click();                                                    // SAP
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("SAP Setup"));
        $(By.id("dl2~5~32~51")).click();                                                    // PeopleSoft Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("PeopleSoft Setup"));
        $(By.id("dl2~5~32~52")).click();                                                    // Osiris Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Osiris Setup"));
        $(By.id("dl2~5~32~53")).click();                                                    // WardKraft Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("WardKraft Setup"));
        $(By.id("dl2~5~32~54")).click();                                                    // Oracle Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Oracle Setup"));
        $(By.id("dl2~5~32~55")).click();                                                    // Infor Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Infor Setup"));
        $(By.id("dl2~5~32~56")).click();                                                    // SAGE Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("SAGE Setup"));
        $(By.id("dl2~5~32~57")).click();                                                    // Printra Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Printra Setup"));
        $(By.id("dl2~5~32~58")).click();                                                    // Printegra Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Printegra Setup"));
        $(By.id("dl2~5~32~59")).click();                                                    // Ketera Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Ketera Setup"));
        $(By.id("dl2~5~32~60")).click();                                                    // BCT Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("BCT Setup"));
        $(By.id("dl2~5~32~61")).click();                                                    // James Tower Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("James Tower Setup"));
        $(By.id("dl2~5~32~63")).click();                                                    // SanMar Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("SanMar Setup"));
        $(By.id("dl2~5~32~65")).click();                                                    // Ennis - General Financial Supply Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Ennis - General Financial Supply Setup"));
        $(By.id("dl2~5~32~66")).click();                                                    // Ennis - Catalog Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Ennis - Catalog Setup"));
        $(By.id("dl2~5~32~67")).click();                                                    // DataWidget Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("DataWidget Setup"));
        $(By.id("dl2~5~32~68")).click();                                                    // AccuData Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("AccuData Setup"));
        $(By.id("dl2~5~32~73")).click();                                                    // Graphic Dimensions
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Graphic Dimensions"));
        $(By.id("dl2~5~32~76")).click();                                                    // DFS Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("DFS Setup"));
        $(By.id("dl2~5~32~78")).click();                                                    // Snowman Group Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Snowman Group Setup"));
        $(By.id("dl2~5~32~96")).click();                                                    // Sterling Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Sterling Setup"));
        $(By.id("dl2~5~32~79")).click();                                                    // Red Cheetah Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Red Cheetah Setup"));
        $(By.id("dl2~5~32~81")).click();                                                    // ASI Setup
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("ASI Setup"));
        $(By.id("dl2~5~32~90")).click();                                                    // United Stationers
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("United Stationers"));
        $(By.id("dl2~5~32~91")).click();                                                    // Firespring
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("Firespring"));
        $(By.id("dl2~5~32~93")).click();                                                    // MICR Express
        $(By.id("detailsTitle_top")).shouldBe(Condition.text("MICR Express"));
    }
}
