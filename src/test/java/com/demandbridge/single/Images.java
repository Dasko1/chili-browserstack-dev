package com.demandbridge.single;

import com.codeborne.selenide.Condition;
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
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.Keys.ENTER;


public class Images {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void images_Test() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "Images"); // test name
        caps.setCapability("build", "Images 1"); // CI/CD job or build name

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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lookbook = driver.findElement(By.linkText("Property Lookbook"));
        Assertions.assertTrue(lookbook.isDisplayed());
        lookbook.click();

        // Click on Lookbook in dropdown
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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assertions.assertEquals("Help Layer", "Help Layer");
        Assertions.assertEquals("Prepared For", "Prepared For");
        Assertions.assertEquals("From", "From");
        Assertions.assertEquals("Job Title", "Job Title");
        Assertions.assertEquals("Address", "Address");
        Assertions.assertEquals("Email", "Email");
        Assertions.assertEquals("Message", "Message");
        Assertions.assertEquals("Logo", "Logo");
        sleep(3500);

        // Switch tabs
        WebElement locationsTab = driver.findElement(By.id("chili-tab-panel__tab_971"));
        sleep(7000);
        locationsTab.click();
        Assertions.assertEquals("Caption 1", "Caption 1");
        WebElement imageThree = driver.findElement(By.id("chili-variable-uploadButton-Image3"));
        imageThree.click();
        sleep(2500);
        // Open Chili Assets and select an image.
        WebElement chiliAssets = driver.findElement(By.linkText("Chili Assets"));
        chiliAssets.click();
        sleep(1500);
        WebElement photoA = driver.findElement(By.linkText("photoA.jpg"));
        photoA.click();
        sleep(1500);
        // Select Another Image
        imageThree.click();
        sleep(2000);
        WebElement chiliAssets1 = driver.findElement(By.linkText("Chili Assets"));
        chiliAssets1.click();
        sleep(1500);
        WebElement photoE = driver.findElement(By.linkText("photoE.jpg"));
        photoE.click();

        Assertions.assertEquals("SHOP", "SHOP");

        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.urlContains("DefaultCatalog"));
            markTestStatus("passed","Assets & Images tests passed'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","Something is wrong with Images'",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}

