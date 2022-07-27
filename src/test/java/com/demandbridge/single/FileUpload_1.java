package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FileUpload_1 {

    public static final String AUTOMATE_USERNAME = "adaskalopoulos1";
    public static final String AUTOMATE_KEY = "RwofYrpjLEBwrwzpTdSc";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");
        caps.setCapability("os", "windows");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os_version", "10");
        caps.setCapability("name", "Chili Holiday Party Card");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        // Go to Generic page and login
        driver.get("https://generic.development.dbenterprise.com/");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement signin = driver.findElement(By.id("loginbutton_btn"));
        username.sendKeys("daskoadmin");
        password.sendKeys("dasko");
        signin.click();

        // This opens the browser and logs in the User.
        // WebDriver driver = DriverInit.getInstance().getDriver();
        Assertions.assertTrue(driver.getTitle().contentEquals("DB Commerce"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click the Shop link
        WebElement shopLink = driver.findElement(By.linkText("SHOP"));
        shopLink.click();
        Selenide.sleep(2000);

        // Click Corporate Collateral to get to Holiday Party Cardss
        WebElement corpColl = driver.findElement(By.linkText("Corporate Collateral"));
        Assertions.assertTrue(corpColl.isDisplayed());
        corpColl.click();
        Selenide.sleep(8000);
        WebElement holidayCards = driver.findElement(By.linkText("Holiday Party Card-DM"));
        Assertions.assertTrue(holidayCards.isDisplayed());
        holidayCards.click();
        Selenide.sleep(5000);
        Assertions.assertEquals("Holiday Party Card-DM", "Holiday Party Card-DM");
        WebElement customize_btn = driver.findElement(By.id("customizebutton_btn"));
        customize_btn.click();

        // Upload Attachments; step 1: push Approve button and then remove attachment
        Selenide.sleep(17000);
        WebElement view_proof = driver.findElement(By.id("chili-customize-view-proof-button"));
        view_proof.click();
        Selenide.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("addRecipients()");                                    // This opens the file uploader field.

        // Try to upload wrong file type
        Selenide.sleep(2500);
        WebElement l = driver.findElement(By.xpath("//input[@type='file']"));
        l.sendKeys("C:/upload-files/Product-Meeting.png");
        Assertions.assertEquals("You can't upload files of this type.", "You can't upload files of this type.");
        Selenide.sleep(3000);

        WebElement m = driver.findElement(By.xpath("//input[@type='file']"));
        m.sendKeys("C:/upload-files/sample-1.csv");
        Selenide.sleep(3000);
        Assertions.assertEquals("Recipients List", "Recipients List");
        WebElement remove_recipients = driver.findElement(By.xpath("//*[@id=\"chili-add-recipients\"]/div[4]/div[1]/div/table/tbody/tr[2]/td[3]/a"));
        remove_recipients.click();
        Selenide.sleep(2000);
        WebElement n = driver.findElement(By.xpath("//input[@type='file']"));
        n.sendKeys("C:/upload-files/sample-3.xlsx");
        Selenide.sleep(3500);
        WebElement o = driver.findElement(By.xpath("//input[@type='file']"));
        o.sendKeys("C:/upload-files/sample-4.xls");
        WebElement p = driver.findElement(By.xpath("//input[@type='file']"));
        p.sendKeys("C:/upload-files/sample-2.csv");
        Assertions.assertEquals("Recipient list cannot exceed two files", "Recipient list cannot exceed two files");
        Selenide.sleep(3000);

        // Go to Cart
        WebElement approveCheckout = driver.findElement(By.id("chili-step2b-text"));
        Assertions.assertTrue(approveCheckout.isEnabled());
        approveCheckout.click();
        Selenide.sleep(20000);

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
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
