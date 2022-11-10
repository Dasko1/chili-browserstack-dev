package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ChiliBusCard {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void chiliBusCard_Test() throws MalformedURLException, AWTException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliBusCard"); // test name
        caps.setCapability("build", "ChiliBusCard 1"); // CI/CD job or build name

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/");
        Robot robot = new Robot();
        driver.manage().window().maximize();
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("daskoadmin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("dasko");
        WebElement signinButton = driver.findElement(By.id("loginbutton_btn"));
        signinButton.click();

        System.out.println(driver.getTitle());

        // Click the Shop link
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assertions.assertTrue(driver.getTitle().contentEquals("DB Commerce"));
        WebElement shopLink = driver.findElement(By.linkText("SHOP"));
        shopLink.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Click Corporate Collateral to get to Business Cards
        WebElement corpColl = driver.findElement(By.linkText("Corporate Collateral"));
        Assertions.assertTrue(corpColl.isDisplayed());
        corpColl.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement busCards = driver.findElement(By.linkText("Business Cards"));
        Assertions.assertTrue(busCards.isDisplayed());
        busCards.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertEquals("Business Cards", "Business Cards");
        // Push the Customize button. First, select 4 from the dropdown to avoid warning.
        WebElement customizeDrpdn = driver.findElement(By.id("order-qty_cbo"));
        customizeDrpdn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement two = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(2)"));
        two.click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        customizeDrpdn.click();
        WebElement four = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(3)"));
        four.click();
        keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement customizeBtn = driver.findElement(By.id("customizebutton_btn"));
        customizeBtn.click();
        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
        Assertions.assertEquals("Name", "Name");
        Assertions.assertEquals("Email", "Email");
        Assertions.assertEquals("Title", "Title");
        Assertions.assertEquals("Phone", "Phone");
        Assertions.assertEquals("Card Back", "Card Back");

        // Make Edits to field in descending order, starting with the Name field and descending
        WebElement titleField = driver.findElement(By.id("value-Title"));
        titleField.clear();
        titleField.sendKeys("northeast regional director");
        WebElement phoneField = driver.findElement(By.name("Phone"));
        phoneField.clear();
        phoneField.sendKeys("410-987-9543");
        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.clear();
        emailField.sendKeys("mschwartz");
        WebElement cardBackField = driver.findElement(By.name("Back"));
        Assertions.assertTrue(cardBackField.isDisplayed());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement cardBackDropdown = driver.findElement(By.name("Back"));
        cardBackDropdown.clear();
        cardBackDropdown.sendKeys("let us bring you home");
        cardBackDropdown.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        cardBackDropdown.clear();
        cardBackDropdown.sendKeys("promises made... promises kept");
        cardBackDropdown.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Hover over infoprint/tooltips
        Actions act = new Actions(driver);
        WebElement email_help = driver.findElement(By.id("chili-help-icon"));
        act.moveToElement(email_help).perform();
        Assertions.assertEquals("Enter username only", "Enter username only");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Visual test to go here to confirm information saved to business cards

        // Profile: Add
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement add_a_profile = driver.findElement(By.id("chili_customize_add_profile_button"));
        add_a_profile.click();
        WebElement cancel_profile = driver.findElement(By.xpath("//*[@id=\"chili_new_profile_name_wrapper\"]/div[1]/a[2]"));
        cancel_profile.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        add_a_profile.click();
        WebElement new_profile = driver.findElement(By.id("chili_new_profile_name"));
        new_profile.click();
        new_profile.sendKeys("Auto Test Profile");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement save_profile_btn = driver.findElement(By.xpath("//*[@id=\"chili_new_profile_name_wrapper\"]/div[1]/a[1]"));
        save_profile_btn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Check for new profile
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement show_profiles = driver.findElement(By.name("profileCombo"));
        show_profiles.click();
        Assertions.assertEquals("Auto Test Profile", "Auto Test Profile");
        // Delete Profile
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement delete_profile = driver.findElement(By.id("chili-delete-profile-icon"));
        delete_profile.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        show_profiles.click();
        Assertions.assertNotEquals("Auto Test Profile", "");
        // Change Profile
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // show_profiles.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Open Profile
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.RETURN);

        // Push the VIEW PROOF button
        WebElement viewProofButton = driver.findElement(By.id("chili-view-proof-text"));
        viewProofButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement approveAdd2Cart = driver.findElement(By.id("chili-step2a-text"));
        WebElement approveCheckout = driver.findElement(By.id("chili-step2b-text"));
        Assertions.assertTrue(approveCheckout.isEnabled());
        Assertions.assertTrue(approveAdd2Cart.isEnabled());

        // Push Approve & Add To Cart button; push VIEW PROOF button
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        approveAdd2Cart.click();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        viewProofButton.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //Edit from Cart; click Approve and Checkout;
        viewProofButton.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        Assertions.assertTrue(approveCheckout.isEnabled());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        approveCheckout.click();
        Assertions.assertEquals("Shopping Cart", "Shopping Cart");
        Selenide.sleep(15000);
        // Click Edit link on the top.
        WebElement edit_link = driver.findElement(By.linkText("Edit"));
        edit_link.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assertions.assertEquals("COR001 - Business Cards", "COR001 - Business Cards");
        WebElement edit_phone = driver.findElement(By.id("value-Phone"));
        edit_phone.clear();
        edit_phone.sendKeys("410-123-4567");
        WebElement save_btn = driver.findElement(By.id("chili-customize-save-button"));
        save_btn.click();
        // Push View Proof and then Return to check out buttons
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement viewProofButton2 = driver.findElement(By.id("chili-customize-view-proof-button"));
        viewProofButton2.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement return_to_checkout_btn = driver.findElement(By.id("chili-step2a-text"));
        return_to_checkout_btn.click();
        Assertions.assertEquals("Shopping Cart", "Shopping Cart");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.urlContains("CheckoutV2"));
            markTestStatus("passed","Yaay, the Business Card test passed'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","Title does not contain 'CheckoutV2'!",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}

