package com.demandbridge.single;

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

public class ChiliApprovals {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void chiliApprovals_Test() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliApprovals"); // test name
        caps.setCapability("build", "ChiliApprovals 1"); // CI/CD job or build name

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("daskoadmin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("dasko");
        WebElement signinButton = driver.findElement(By.id("loginbutton_btn"));
        signinButton.click();

        System.out.println(driver.getTitle());

        // Assert page title and click Cart button
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement shopping_cart_count = driver.findElement(By.id("shopping-cart-item-count"));
        Assertions.assertTrue(driver.getTitle().contentEquals("DB Commerce"));
        WebElement checkout_btn = driver.findElement(By.id("checkout-button"));
        Assertions.assertTrue(checkout_btn.isDisplayed());
        Assertions.assertTrue(shopping_cart_count.isDisplayed());

        // if (shopping_cart_count > 0){
        //  checkout_btn.click();
        // else run ChiliBusBard.java}
        checkout_btn.click();

        // Shopping Cart
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebElement update_quant_btn = driver.findElement(By.id("checkout_update_quantities_button"));
        Assertions.assertTrue(update_quant_btn.isDisplayed());
        // Enter values into Employee ID Number fields.
        /* WebElement top_emp_id = driver.findElement(By.id("288897363_lii"));
        WebElement bot_emp_id = driver.findElement(By.id("288897364_lii"));
        top_emp_id.sendKeys("1235");
        bot_emp_id.sendKeys("1236");*/

        // Shipping Location/Billing Required Fields: set Deliver Options to Next Day Air; push Place This Order Now button l.96
        WebElement attention_field = driver.findElement(By.id("shipping_attention"));
        WebElement emp_number = driver.findElement(By.id("shipping_misc1"));
        WebElement phone_number = driver.findElement(By.id("shipping_misc2"));
        WebElement email = driver.findElement(By.id("billing_email"));
        WebElement field_1 = driver.findElement(By.id("billing_misc1"));
        WebElement field_2 = driver.findElement(By.id("billing_misc2"));
        WebElement field_3 = driver.findElement(By.id("billing_misc3"));
        WebElement delivery_options = driver.findElement(By.id("shipping_delivery_options_cbo"));
        actions.moveToElement(attention_field);
        Assertions.assertTrue(attention_field.isDisplayed());
        attention_field.sendKeys("The Receiver");
        emp_number.sendKeys("1235");
        phone_number.sendKeys("800-448-1484");
        // Select delivery_options = new Select(driver.findElement(By.id("shipping_delivery_options_cbo")));
        //delivery_options.click();
        delivery_options.sendKeys(Keys.ARROW_DOWN);
        delivery_options.sendKeys(Keys.ARROW_DOWN);
        delivery_options.sendKeys(Keys.ENTER);

        // WebElement next_day_air = driver.findElement(By.xpath("//*[@id=\"ext-gen25\"]/div[3]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //next_day_air.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        field_3.click();
        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);delay(1500);
        WebElement place_order_now_btn = driver.findElement(By.id("checkout_place_order_button"));
        place_order_now_btn.click();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        // Final Confirmation Of Your Order modal: find Approval notifications
        WebElement final_conf_modal = driver.findElement(By.className("checkoutFinalConfirmation"));
        Assertions.assertTrue(final_conf_modal.isDisplayed());
        WebElement final_checkout_btn = driver.findElement(By.id("final_place_order_button"));
        final_checkout_btn.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        WebElement following_reasons = driver.findElement(By.cssSelector("\"#ext-gen64 > div > table > tbody > tr:nth-child(2) > td > div > span"));
//        WebElement next_day_air_text = driver.findElement(By.xpath("//*[@id=\"ext-gen64\"]/div/table/tbody/tr[2]/td/div/span/ul/li[2]"));
//        Assertions.assertTrue(following_reasons.isDisplayed());
//        Assertions.assertTrue(next_day_air_text.isDisplayed());


        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.titleIs("DB Commerce"));
            markTestStatus("passed","Yaay, the title contains 'DB Commerce'!",driver);
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
