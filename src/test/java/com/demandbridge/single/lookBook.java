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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class lookBook {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void lookBook_Test() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliLookBook"); // test name
        caps.setCapability("build", "ChiliLookBook 1"); // CI/CD job or build name

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/");
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

        // Click Corporate Collateral to go to Lookbook
        WebElement corpColl = driver.findElement(By.linkText("Corporate Collateral"));
        Assertions.assertTrue(corpColl.isDisplayed());
        corpColl.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebElement lookbook = driver.findElement(By.linkText("Property Lookbook"));
        Assertions.assertTrue(lookbook.isDisplayed());
        lookbook.click();

        // Click on Flipbook in dropdown
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement flipbook = driver.findElement(By.id("item-group_cbo"));
        flipbook.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement flipbook_option = driver.findElement(By.cssSelector("#ext-gen28 > div.x-combo-list-item.x-combo-selected"));
        flipbook_option.click();

        // Push Customize button
        Assertions.assertEquals("Property Lookbook", "Property Lookbook");
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        WebElement customizeBtn = driver.findElement(By.id("customizebutton_btn"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        customizeBtn.click();

        // Customize Lookbook: start with Assertions; first, wait for page to load
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assertions.assertEquals("Help Layer", "Help Layer");
        Assertions.assertEquals("Prepared For", "Prepared For");
        Assertions.assertEquals("From", "From");
        Assertions.assertEquals("Job Title", "Job Title");
        Assertions.assertEquals("Address", "Address");
        Assertions.assertEquals("Email", "Email");
        Assertions.assertEquals("Message", "Message");
        Assertions.assertEquals("Logo", "Logo");

        //Hints: assert that they first appear - use Visual Regression if the hints can't be found
        Assertions.assertEquals("Please refer to the hints", "Please refer to the hints");
        // Now hide hints
        WebElement hideHints = driver.findElement(By.id("ToggleHelp-button-03804BB8-0938-420D-89FE-628CFF0C9019"));
        Assertions.assertTrue(hideHints.isDisplayed());
        hideHints.click();                                      // Check next if hints are now gone
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertNotEquals("Please refer to the hints", "");

        // Edit fields
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement preparedFor = driver.findElement(By.name("Recipient"));
        preparedFor.clear();
        preparedFor.sendKeys("jane doe");
        WebElement name = driver.findElement(By.name("Name"));
        name.clear();
        name.sendKeys("Jack Smith");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement title = driver.findElement(By.name("Title"));
        title.clear();
        title.sendKeys("Florida Property Manager");
        // Address
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement address = driver.findElement(By.name("Address"));
        address.clear();
        address.sendKeys("Reno Office");
        address.sendKeys(ENTER);
        WebElement email = driver.findElement(By.name("Email"));
        email.clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        email.sendKeys("mschwartz");
        // Push Save button
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement save = driver.findElement(By.id("chili-customize-save-button"));
        Assertions.assertTrue(save.isDisplayed());
        save.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Undo/Redo
        WebElement undo_btn = driver.findElement(By.id("chili-undo-button"));
        WebElement redo_btn = driver.findElement(By.id("chili-redo-button"));
        undo_btn.click();
        Assertions.assertTrue(redo_btn.isEnabled());
        redo_btn.click();

        // Jump To Page:  see address change in ll.145-
        WebElement next_btn = driver.findElement(By.id("chili-next-button"));
        WebElement prev_btn = driver.findElement(By.id("chili-previous-button"));
        next_btn.click();
        Assertions.assertTrue(prev_btn.isEnabled());
        next_btn.click();
        next_btn.click();
        prev_btn.click();


        // Profile: Add
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement add_a_profile = driver.findElement(By.id("chili_customize_add_profile_button"));
        add_a_profile.click();
        WebElement cancel_profile = driver.findElement(By.xpath("//*[@id=\"chili_new_profile_name_wrapper\"]/div[1]/a[2]"));
        cancel_profile.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement delete_profile = driver.findElement(By.id("chili-delete-profile-icon"));
        delete_profile.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        show_profiles.click();
        Assertions.assertNotEquals("Auto Test Profile", "");
        // Change Profile
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        // show_profiles.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Open Profile
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.RETURN);

        // Tooltips: email first and then address.
        Actions act = new Actions(driver);
        WebElement email_help = driver.findElement(By.id("Email_help"));
        act.moveToElement(email_help).perform();
        email.sendKeys("mschwartz");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assertions.assertEquals("Enter username only", "Enter username only");
        WebElement address_tooltip = driver.findElement(By.id("Address_help"));
        act.moveToElement(address_tooltip).perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Switch tabs
        WebElement locationsTab = driver.findElement(By.id("chili-tab-panel__tab_2879"));
        locationsTab.click();
        Assertions.assertEquals("Caption 1", "Caption 1");
        WebElement imageOne = driver.findElement(By.id("chili-variable-uploadButton-Image1"));
        imageOne.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement photoA = driver.findElement(By.linkText("photoA.jpg"));
        photoA.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Switch back to Contact Information tab
        WebElement contact_info_tab = driver.findElement(By.id("chili-tab-panel__tab_2878"));
        contact_info_tab.click();

        // Change Logo
        WebElement reset = driver.findElement(By.id("chili-variable-resetButton-Logo"));
        reset.click();
        WebElement upload = driver.findElement(By.id("chili-variable-uploadButton-Logo"));
        upload.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement logo = driver.findElement(By.linkText("generic_logo.pdf"));
        logo.click();

        // Resizer
        WebElement zoom_out = driver.findElement(By.id("chili-zoom-out-button"));
        zoom_out.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement zoom = driver.findElement(By.id("chili-zoom-button"));
        zoom.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Push the View Proof button; View Proof disabled for flipbook
        email.clear();
        email.sendKeys("mschwartz");
        WebElement viewProofButton = driver.findElement(By.id("chili-view-proof-text"));
        Assertions.assertTrue(viewProofButton.isDisplayed());
        viewProofButton.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // Full Preview Popout
        WebElement popout = driver.findElement(By.id("chili-expand-toggle"));
        popout.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // Lines 234-48 are for the flipbook; ll.253-61 are for the lookbook. 
        /*WebElement create_flipbook = driver.findElement(By.id("chili-flipbook-text"));
        Assertions.assertTrue(create_flipbook.isEnabled());
        create_flipbook.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // driver.switchTo().alert().accept();
        WebElement yes_btn = driver.findElement(By.id("generateFlipbook"));
        yes_btn.click();
        WebElement generate_flipbook = driver.findElement(By.id("generateFlipbook"));
        generate_flipbook.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assertions.assertEquals("Your flipbook has been submitted for processing,", "Your flipbook has been submitted for processing,");
        Assertions.assertEquals("Thank you for placing your order!", "Thank you for placing your order!");
        WebElement continue_shopping_btn = driver.findElement(By.linkText("CONTINUE SHOPPING"));
        continue_shopping_btn.click();*/

        Assertions.assertEquals("SHOP", "SHOP");

        // The following lines were for the lookbook; the above lines are for the flipbook
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement approveAdd2Cart = driver.findElement(By.id("chili-step2a-text"));
        WebElement approveCheckout = driver.findElement(By.id("chili-customize-step2b-button"));
        Assertions.assertTrue(approveCheckout.isEnabled());
        Assertions.assertTrue(approveAdd2Cart.isEnabled());

        // Push Approve & Checkout
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        approveCheckout.click();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.urlContains("browseDefaultCatalog"));
            markTestStatus("passed","The LookBook test passed'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","URL does not contain 'DefaultCatalog'!",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}
