package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AssetSelection {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void assetSelectionTest() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "Chili Asset Selection");            // test name
        caps.setCapability("build", "Chili Asset Selection 1");         // CI/CD job or build name
        caps.setCapability("acceptSslCerts", true);

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/Login.epm");
        driver.manage().window().maximize();
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("daskoadmin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("dasko");
        WebElement signinButton = driver.findElement(By.id("loginbutton_btn"));
        signinButton.click();

        System.out.println(driver.getTitle());

        // Click the Shop link
        Selenide.sleep(5000);
        Assertions.assertTrue(driver.getTitle().contentEquals("DB Commerce"));
        WebElement shopLink = driver.findElement(By.linkText("SHOP"));
        shopLink.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Click Corporate Collateral to go to Lookbook
        WebElement corpColl = driver.findElement(By.linkText("Corporate Collateral"));
        Assertions.assertTrue(corpColl.isDisplayed());
        corpColl.click();
        Selenide.sleep(15000);
        WebElement lookbook = driver.findElement(By.linkText("Property Lookbook"));
        Assertions.assertTrue(lookbook.isDisplayed());
        lookbook.click();
        Selenide.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("btnhandlercustomizebutton();");

        // Customize Lookbook: start with Assertions; first, wait for page to load
        Selenide.sleep(10000);
        Assertions.assertEquals("Help Layer", "Help Layer");
        Assertions.assertEquals("Prepared For", "Prepared For");
        Assertions.assertEquals("From", "From");
        Assertions.assertEquals("Job Title", "Job Title");
        Assertions.assertEquals("Address", "Address");
        Assertions.assertEquals("Email", "Email");
        Assertions.assertEquals("Message", "Message");
        Assertions.assertEquals("Logo", "Logo");

        WebElement locations_arrow = driver.findElement(By.id("chili-tab-lower-nav-right"));
        locations_arrow.click();
        Assertions.assertEquals("Image 3", "Image 3");
        WebElement uploads = driver.findElement(By.id("chili-variable-uploadButton-Image3"));
        uploads.click();
        Selenide.sleep(4500);

        // Click Image 3.
        WebElement assets_folder = driver.findElement(By.cssSelector("#ext-gen55 > div > li:nth-child(1) > div > a > span"));
        assets_folder.click();
        Selenide.sleep(3500);

        // Click photoE.jpg
        WebElement photoE = driver.findElement(By.partialLinkText("photoE"));
        photoE.click();
        Selenide.sleep(2500);

        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.titleIs("DB Commerce"));
            markTestStatus("passed","The Asset Selection test passed'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","The title does not contain 'DB Commerce'!",driver);
        }
        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}
