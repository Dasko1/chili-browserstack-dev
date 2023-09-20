package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MailosaurCheck extends BrowserStackTest {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public void mailosaurCheckTest() {

        // Go to Mailosaur enter username/password & push Continue & Login buttons
        open("https://mailosaur.com/app/");
        $(By.name("email")).shouldBe(Condition.visible).sendKeys("amallah@demandbridge.com");
        $(By.id(":rd:")).shouldBe(Condition.visible).click();
        $(By.name("password")).shouldBe(Condition.visible).sendKeys("d3m4ndbr1dg32017!");
        $(By.id(":rd:")).shouldBe(Condition.visible).click();
        Selenide.sleep(7500);

        // Assert MODIFIED and click on topmost email
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[4]/div/table/tbody/tr[1]/td[2]")).shouldBe(Condition.visible).click();
        Selenide.sleep(5500);
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[4]/div[2]/div[1]/div[3]")).click();
        Selenide.sleep(1500);
        // Confirm "MODIFIED" & "_lowres.pdf"
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[3]")).shouldBe(Condition.text("_lowres.pdf"));
        Selenide.sleep(1500);
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[1]/div[2]")).shouldHave(Condition.text("MODIFIED"));
    }
}
