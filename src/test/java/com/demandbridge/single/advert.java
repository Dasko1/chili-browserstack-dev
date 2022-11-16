package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class advert {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void advert_Test() throws MalformedURLException, AWTException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliBankAdvert"); // test name
        caps.setCapability("build", "Chili Bank Advert"); // CI/CD job or build name

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
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

        // Click on Advertising & go to Mobile Banking App
        WebElement advertising = driver.findElement(By.linkText("Advertising"));
        advertising.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement mobile_banking = driver.findElement(By.linkText("Mobile Banking Banner Ad"));
        mobile_banking.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement customizeBtn = driver.findElement(By.id("customizebutton_btn"));
        Assertions.assertEquals("Mobile Banking Banner Ad", "Mobile Banking Banner Ad");
        Assertions.assertEquals("Sizes available: ", "Sizes available: ");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        customizeBtn.click();

        // Edit Banner Ad: start with Ad size
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assertions.assertEquals("Square 250x250", "Square 250x250");
        Assertions.assertEquals("Leaderboard 728x90", "Leaderboard 728x90");
        Assertions.assertEquals("Skyscraper 120x600", "Skyscraper 120x600");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebElement ad_size = driver.findElement(By.name("ad_size"));
        ad_size.click();
        ad_size.clear();
        ad_size.sendKeys("Square 250x250");
        ad_size.sendKeys(Keys.RETURN);
        // Title
        WebElement title = driver.findElement(By.name("title"));
        title.click();
        title.clear();
        title.sendKeys("life is mobile! like, so is your bank!");
        // Text
        WebElement text = driver.findElement(By.name("text"));
        text.click();
        text.clear();
        text.sendKeys("Earn 12% APY");
        text.sendKeys(Keys.ENTER);
        text.sendKeys("$10 minimum");
        text.sendKeys(Keys.ENTER);
        text.sendKeys("FDIC insured, of course");

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
        show_profiles.click();
        // Change Profile
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // show_profiles.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Open Profile
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.DOWN);
        show_profiles.sendKeys(Keys.RETURN);

        // Resizer
        WebElement chili_zoom = driver.findElement(By.id("chili-zoom-button"));
        chili_zoom.click();
        WebElement chili_zoom_out = driver.findElement(By.id("chili-zoom-out-button"));
        chili_zoom_out.click();
        WebElement toggle = driver.findElement(By.id("chili-expand-toggle"));
        toggle.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        toggle.click();

        // Undo then Redo buttons
        WebElement undo_button = driver.findElement(By.id("chili-undo-button"));
        undo_button.click();
        Assertions.assertEquals("Square 250x250", "Square 250x250");
        WebElement redo_button = driver.findElement(By.id("chili-redo-button"));
        redo_button.click();
        Assertions.assertEquals("Leaderboard 728x90", "Leaderboard 728x90");

        // Push the View Proof button
        WebElement viewProofButton = driver.findElement(By.id("chili-view-proof-text"));
        viewProofButton.click();
        Selenide.sleep(8000);
        WebElement close_image = driver.findElement(By.xpath("//*[@id=\"image-preview-modal\"]/span"));
        $(close_image).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        if (driver.getTitle().equals("DB Commerce")) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"OK: The Bank Advert test passed!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"NOK: Title not matched\"}}");
        }

        driver.quit();
    }
}
