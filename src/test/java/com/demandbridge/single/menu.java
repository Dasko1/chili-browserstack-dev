package com.demandbridge.single;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class menu {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void menu_Test() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliBrunch Tablescape"); // test name
        caps.setCapability("build", "ChiliBrunch Tablescape 1 - DEV"); // CI/CD job or build name on BStack

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/");
        // driver.get("https://generic.dbenterprise.com/");
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Click on Promotional Gifts
        WebElement promo_gifts = driver.findElement(By.linkText("Promotional Gifts"));
        Assertions.assertEquals("Promotional Gifts", "Promotional Gifts");
        promo_gifts.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement brunch_table = driver.findElement(By.linkText("Brunch Tablescape Kit"));
        Assertions.assertEquals("Brunch Tablescape", "Brunch Tablescape");
        brunch_table.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertEquals("Brunch Tablescape Kit", "Brunch Tablescape Kit");
        WebElement order_qty_field = driver.findElement(By.id("order-qty-text"));
        order_qty_field.clear();
        order_qty_field.sendKeys("7");
        order_qty_field.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement customizeBtn = driver.findElement(By.id("customizebutton_btn"));
        customizeBtn.click();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        // Go to Event Information tab first
        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
        WebElement eventInfoTab = driver.findElement(By.id("chili-tab-panel__tab_973"));   //already there by default.
        Actions actions = new Actions(driver);

        // actions.moveToElement(eventInfoTab).click().perform();   paired with l.78
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions.moveToElement(eventInfoTab).click().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement date = driver.findElement(By.id("value-date"));
        date.click();
        // WebElement day = driver.findElement(By.cssSelector(".x-date-today > a:nth-child(1) > em:nth-child(1) > span:nth-child(1)"));
        WebElement day = driver.findElement(By.xpath("//*[@id=\"ext-gen63\"]/tbody/tr[2]/td/table/tbody/tr[4]/td[2]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        day.click();

        // Image Selection
        WebElement image_selection = driver.findElement(By.id("chili-variable-uploadButton-menu_graphic"));
        image_selection.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement rosemary = driver.findElement(By.linkText("rosemary.pdf"));
        rosemary.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Go to Menu Items tab
        WebElement menu_items_tab = driver.findElement(By.id("chili-tab-panel__tab_972"));                  // DEV
        // WebElement menu_items_tab = driver.findElement(By.id("chili-tab-panel__tab_2899"));
        menu_items_tab.click();

        //Tooltips: go from top to down
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Actions act = new Actions(driver);
        WebElement second_course = driver.findElement(By.id("course_options_2_help"));
        act.moveToElement(second_course).perform();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        Assertions.assertEquals("Second Course", "Second Course");
        WebElement dessert_options = driver.findElement(By.id("dessert_options_1_help"));
        act.moveToElement(dessert_options).perform();
        Assertions.assertEquals("Please select 3 dessert options", "Please select 3 dessert options");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement bevs_options = driver.findElement(By.id("beverages_option1_help"));
        act.moveToElement(bevs_options).perform();
        Assertions.assertEquals("Please select 4 beverage options", "Please select 4 beverage options");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Edit Course Option Values: First Course; first click down-arrow to open the dropdown, then type desired course
        // WebElement dropdownOne = driver.findElement(By.id("ext-gen43"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // $(dropdownOne).click();
        WebElement firstOptionOne = driver.findElement(By.name("course_options_1"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        firstOptionOne.click();
        firstOptionOne.clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        firstOptionOne.sendKeys("Avocado Toast");
        firstOptionOne.sendKeys(Keys.RETURN);
        WebElement firstOptionTwo = driver.findElement(By.name("course_options_2"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        firstOptionTwo.click();
        firstOptionTwo.clear();
        firstOptionTwo.sendKeys("Greek Yogurt Parfait");
        firstOptionTwo.sendKeys(Keys.RETURN);
        // Second Course
        WebElement secondOptionOne = driver.findElement(By.name("course_options_3"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        secondOptionOne.click();
        secondOptionOne.clear();
        secondOptionOne.sendKeys("Spring Omelet");
        secondOptionOne.sendKeys(Keys.RETURN);
        WebElement secondOptionTwo = driver.findElement(By.name("course_options_4"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        secondOptionTwo.click();
        secondOptionTwo.clear();
        secondOptionTwo.sendKeys("Pan Roasted Wild Salmon");
        secondOptionTwo.sendKeys(Keys.RETURN);
        // Dessert and Drink Options; dessert options first: ll.147-161 work
        WebElement dessertOption = driver.findElement(By.name("dessert_options_1"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dessertOption.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement choc_cookies = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(2) > div:nth-child(2)"));
        choc_cookies.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement baked_donuts = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(5) > div:nth-child(2)"));
        baked_donuts.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement seasonalSorbetto = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(3) > div:nth-child(2)"));
        seasonalSorbetto.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement dessert_options_text = driver.findElement(By.id("value-dessert_options_1"));
        dessert_options_text.click();                                               // Try to close the Dessert Options dropdown
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //Assertions.assertEquals(6, driver.findElement(By.className("lov-combo-aggregate-indicator")));

        // Beverages: if the desserts are chosen, then the bevs fail and vice versa
        /*driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(3500);
        WebElement bevs = driver.findElement(By.name("beverages_option1"));         // Open Beverage dropdown
        bevs.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(3000);
        Assertions.assertEquals("Old Bay Bloody Mary", "Old Bay Bloody Mary");
        WebElement oldbay_bm = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(1) > div:nth-child(2)"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(3000);
        oldbay_bm.click();                                                      // Uncheck Old Bay top choice
        WebElement peach_bell = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(2) > div:nth-child(2)"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(1000);
        peach_bell.click();                                                     // Uncheck Sparkling Bellini
        WebElement peach_tea = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(4) > div:nth-child(2)"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(1000);
        peach_tea.click();
        WebElement coffee_tea = driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(5) > div:nth-child(2"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(1000);
        coffee_tea.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(1000);*/


        // Push the View Proof button
        WebElement viewProofButton = driver.findElement(By.id("chili-view-proof-text"));
        viewProofButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement approveAdd2Cart = driver.findElement(By.id("chili-step2a-text"));
        WebElement approveCheckout = driver.findElement(By.id("chili-step2b-text"));
        Assertions.assertTrue(approveCheckout.isEnabled());
        Assertions.assertTrue(approveAdd2Cart.isEnabled());

        // Push Approve & Add To Cart button.
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        approveAdd2Cart.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(".\\menu.png"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.urlContains("browseDefaultCatalog"));
            markTestStatus("passed","The Brunch Tablescape Test Passed'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","URL does not contain 'browseDefaultCatalog'!",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}
