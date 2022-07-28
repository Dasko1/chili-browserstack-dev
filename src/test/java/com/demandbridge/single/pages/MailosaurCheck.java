package com.demandbridge.single.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MailosaurCheck extends BrowserStackTest {

    public void mailosaurCheckTest() {

        // Go to Mailosaur enter username/password & push Continue & Login buttons
        open("https://mailosaur.com/app/");
        $(By.name("email")).shouldBe(Condition.visible).sendKeys("amallah@demandbridge.com");
        $("#root > div > div > div > div > div.mBox-root.css-v76q14 > form > button > div").click();
        $(By.name("password")).shouldBe(Condition.visible).sendKeys("d3m4ndbr1dg32017!");
        $("#root > div > div > div > div > div.mBox-root.css-v76q14 > form > button.mLoadingButton-root.mButton-root.mButton-contained.mButton-containedPrimary.mButton-sizeMedium.mButton-containedSizeMedium.mButton-disableElevation.mButton-fullWidth.mButtonBase-root.css-1s3uy45").click();
        Selenide.sleep(7500);

        // Assert MODIFIED and click on topmost email
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[4]/div/table/tbody/tr[1]/td[2]")).shouldBe(Condition.visible).click();
        Selenide.sleep(5500);
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[4]/div[2]/div[1]/div[3]")).click();
        Selenide.sleep(1500);
        // Confirm "_lowres.pdf"
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[3]")).shouldBe(Condition.text("_lowres.pdf"));
        Selenide.sleep(5500);
    }
}
