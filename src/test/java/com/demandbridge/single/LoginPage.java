package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;

public class LoginPage extends BrowserStackTest {

    @Test
    public void loginPageTest (){

        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/login-client.cgi?Client=REDS2");
        $(".eqd-Heading > img:nth-child(1)").shouldBe(Condition.visible);
        // Verify that a Welcome message appears; as of 30 Nov 21, this is broken/non-existant.
        $("#divBottomMsg").shouldBe(Condition.text("Bottom message on Redesign II."));
        // Login: fail first login and assert message.
        $(By.id("inputEmail")).sendKeys("XXXXXX");
        $(By.id("inputPW")).sendKeys("TestingReds2");
        $(By.className("eqd-SignIn")).click();
        $("body").shouldBe(Condition.text("Unable to Log in."));
        $("body > div:nth-child(2) > input:nth-child(1)").shouldBe(Condition.visible).click();
        // Successful login
        $(By.id("inputEmail")).sendKeys("testing@reds2.com");
        $(By.id("inputPW")).sendKeys("TestingReds2");
        $(By.className("eqd-SignIn")).click();
        $(By.className("eqcFooter")).shouldBe(Condition.text("Welcome (testing@reds2.com)"));
        Selenide.sleep(1000);
        // Logout and do the register test.
        $(By.id("eqcNavLogout")).shouldBe(Condition.visible).click();

        // New User Registration: switch to the new open tab!
        $(By.id("divBottomMsg")).shouldBe(Condition.text("Bottom message on Redesign II. "));
        $(By.linkText("here")).shouldBe(Condition.visible).click();
        switchTo().window(1);
        System.out.println(Selenide.title());
        ElementsCollection pageItems = $$("body");
        System.out.println(pageItems);
        $(By.xpath("//*[@id=\"eqcNavLogout\"]")).shouldBe(Condition.visible);
        $("#SignInLogin").shouldBe(Condition.visible).sendKeys("newuser21@test.com");
        $(".eqcButtonStd").shouldBe(Condition.visible).click();
        // Fill in form.
        $(By.id("FName")).sendKeys("New");
        $(By.id("LName")).sendKeys("User");
        $(By.id("Phone")).sendKeys("410-555-5554");
        $(By.id("Password")).sendKeys("abcd1234");
        $(By.id("RePassword")).sendKeys("abcd1234");
        switchTo().activeElement().sendKeys(ENTER);
        $(By.name("Company")).shouldBe(Condition.visible).sendKeys("Company X");
        // Uncomment when you can remove the New User from admin as a teardown step.
        // The best thing is, after pushing the Submit button, then log in as the new user and then go to admin and delete it.
        $(By.id("NextStep")).shouldBe(Condition.visible).click();
        switchTo().alert().accept();
    }
}
