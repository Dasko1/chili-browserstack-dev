package com.demandbridge.single;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FileDownload_2 {

        public static final String AUTOMATE_USERNAME = "adaskalopoulos1";
        public static final String AUTOMATE_KEY = "RwofYrpjLEBwrwzpTdSc";
        public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

        public static void main(String[] args) throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 1);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        // You will need to find the content-type of your app and set it here.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("name", "Bstack-[Java] Sample file download");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.get("https://www.browserstack.com/test-on-the-right-mobile-devices");
        Thread.sleep(2000);
        driver.findElement(By.id("accept-cookie-notification")).click();

        // Find element by class name and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("CSV"));

        // This will scroll the page till the element is found
        jse.executeScript("arguments[0].scrollIntoView();", Element);
        jse.executeScript("window.scrollBy(0,-100)");
        Thread.sleep(1000);

        // Click on the element to download the file
        Element.click();
        Thread.sleep(2000);

        System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"THE PDF EXPRESS FILE EXISTS!!\"}}"));

        System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"BrowserStack - List of devices to test on.csv\"}}"));

        driver.quit();
        }

        public static void main() {
        }
}
