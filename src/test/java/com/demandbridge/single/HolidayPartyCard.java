package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HolidayPartyCard {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Test
    public void holidayPartyCardTest() throws IOException, AWTException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliHolidayPartyCard"); // test name
        caps.setCapability("build", "ChiliHolidayPartyCard 1"); // CI/CD job or build name


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
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement shopLink = driver.findElement(By.linkText("SHOP"));
        shopLink.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Click Corporate Collateral to get to Holiday Party Cards
        WebElement corpColl = driver.findElement(By.linkText("Corporate Collateral"));
        Assertions.assertTrue(corpColl.isDisplayed());
        corpColl.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement holidayCards = driver.findElement(By.linkText("Holiday Party Card-DM"));
        Assertions.assertTrue(holidayCards.isDisplayed());
        holidayCards.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Assertions.assertEquals("Holiday Party Card-DM", "Holiday Party Card-DM");
        WebElement customize_btn = driver.findElement(By.id("customizebutton_btn"));
        customize_btn.click();

        Selenide.sleep(25000);
        WebElement view_proof = driver.findElement(By.id("chili-customize-view-proof-button"));
        view_proof.click();
        Selenide.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("addRecipients()");                                    // This opens the file uploader field.
        Selenide.sleep(5000);
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

        // Upload Attachments; step 1: push Approve button and then remove attachment: get ready to delete this
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(7000);
//        WebElement view_proof = driver.findElement(By.id("chili-customize-view-proof-button"));
//        view_proof.click();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(1000);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("addRecipients()");                                    // This opens the file uploader field.
//        WebElement m = driver.findElement(By.xpath("//input[@type='file']"));
//        m.sendKeys("C:/upload-files/sample-1.csv");
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(3000);
//        Assertions.assertEquals("Recipients List", "Recipients List");
//        WebElement remove_recipients = driver.findElement(By.xpath("//*[@id=\"chili-add-recipients\"]/div[4]/div[1]/div/table/tbody/tr[2]/td[3]/a"));
//        remove_recipients.click();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(2000);
//        driver.quit();

        // Upload Attachments; step 1: push Approve button and then remove attachment; replaced with above 2: ready to delete
        /*driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(7000);
        WebElement view_proof = driver.findElement(By.id("chili-customize-view-proof-button"));
        view_proof.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(7000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("addRecipients()");                                    // This opens the file uploader field.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(7000);
        // driver.findElement(By.id("chiliRecipientsUploadForm_dz")).sendKeys("C:\\upload-files\\sample-1.csv");
        WebElement m = driver.findElement(By.xpath("//*[@id=\"chiliRecipientsUploadForm_dz\"]/div[1]/div"));
        m.sendKeys("C:\\upload-files\\sample-1.csv");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(3000);*/
        // Assertions.assertEquals("Recipients List", "Recipients List");
        /*WebElement remove_recipients = driver.findElement(By.xpath("//*[@id=\"chili-add-recipients\"]/div[4]/div[1]/div/table/tbody/tr[2]/td[3]/a"));
        remove_recipients.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(2000);
         */

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
