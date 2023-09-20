package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ShowHideColors {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void showHideColorsTest() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "Chili Show/Hide Colors"); // test name
        caps.setCapability("build", "Chili Show/Hide Colors 1"); // CI/CD job or build name

        // Go to DBDevTest page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("https://dbdevtest.development.dbenterprise.com");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("username-text"));
        username.sendKeys("daskoadmin");
        WebElement password = driver.findElement(By.id("password-text"));
        password.sendKeys("dasko");
        WebElement login_btn = driver.findElement(By.id("loginbutton_btn"));
        login_btn.click();
        System.out.println(driver.getTitle());

        // Search for ITEM_044
        WebElement shop = driver.findElement(By.id("nhl_200"));
        shop.click();
        WebElement search_field = driver.findElement(By.id("catalogsearch"));
        search_field.sendKeys("ITEM_044");
        search_field.sendKeys(Keys.RETURN);
        WebElement showColors = driver.findElement(By.linkText("Show Hide Colors"));
        showColors.click();
        Selenide.sleep(6500);
        WebElement customize_btn = driver.findElement(By.id("customizebutton_btn"));
        customize_btn.click();
        Selenide.sleep(8500);

        // Hide Hints/Show Hints Help Layer
        WebElement hide_hints = driver.findElement(By.id("ToggleHelp-button-6EB0E1E6-02EC-4548-AF84-8A5ACC271671"));
        hide_hints.click();
        Selenide.sleep(3500);
        WebElement show_hints = driver.findElement(By.id("ToggleHelp-button-E069A3BC-335B-42F6-993F-207D7C9D875C"));
        show_hints.click();
        Assertions.assertEquals("HELP!", "HELP!");

        // Show/Hide Fields: Start with red
        Selenide.sleep(15000);
        Assertions.assertEquals("Red Animal", "Red Animal");
        Assertions.assertEquals("Red Fruit", "Red Fruit");
        Assertions.assertEquals("strawberry", "strawberry");
        Assertions.assertEquals("Red Toy", "Red Toy");
        Assertions.assertEquals("wagon", "wagon");
        // Change color: Yellow first
        WebElement dropdown = driver.findElement(By.id("ext-gen45"));
        dropdown.click();
        WebElement yellow = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(2)"));
        yellow.click();
        Assertions.assertEquals("Yellow Animal", "Yellow Animal");
        Assertions.assertEquals("finch", "finch");
        Assertions.assertEquals("Yellow Fruit", "Yellow Fruit");
        Assertions.assertEquals("banana", "banana");
        Assertions.assertEquals("Yellow Toy", "Yellow Toy");
        Assertions.assertEquals("Bus", "Bus");
        // Change color: Blue
        Selenide.sleep(2500);
        dropdown.click();
        WebElement blue = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(3)"));
        blue.click();
        Assertions.assertEquals("Blue Animal", "Blue Animal");
        Assertions.assertEquals("parakeet", "parakeet");
        Assertions.assertEquals("Blue Fruit", "Blue Fruit");
        Assertions.assertEquals("blueberry", "blueberry");
        Assertions.assertEquals("Blue Toy", "Blue Toy");
        Assertions.assertEquals("ball", "ball");
        Assertions.assertEquals("Always Here", "Always Here");
        Assertions.assertEquals("say something", "say something");
        Selenide.sleep(2500);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleIs("DB Commerce"));
            if(driver.getTitle().equals("DB Commerce")) {
                js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Upload Succeeded!\"}}");
            } else {
                js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Upload Failed\"}}");
            }
        }
        catch(Exception e) {
            js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"The upload did not succeed\"}}");
        }
        driver.quit();
    }
}
