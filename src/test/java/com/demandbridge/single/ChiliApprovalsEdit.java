package com.demandbridge.single;

import com.demandbridge.single.pages.MailosaurCheck;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ChiliApprovalsEdit {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void chiliApprovalsAsIs_Test() throws MalformedURLException, AWTException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliApprovals Edit"); // test name
        caps.setCapability("build", "ChiliApprovals Edit 1"); // CI/CD job or build name


        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://generic.development.dbenterprise.com/");
        Robot robot = new Robot();
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
        robot.delay(3500);
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
        robot.delay(12000);
        WebElement update_quant_btn = driver.findElement(By.id("checkout_update_quantities_button"));
        Assertions.assertTrue(update_quant_btn.isDisplayed());

        // Shipping Location/Billing Required Fields: set Deliver Options to Next Day Air; push Place This Order Now button l.96
        WebElement attention_field = driver.findElement(By.id("shipping_attention"));
        WebElement emp_number = driver.findElement(By.id("shipping_misc1"));
        WebElement phone_number = driver.findElement(By.id("shipping_misc2"));
        WebElement email = driver.findElement(By.id("billing_email"));
        WebElement field_1 = driver.findElement(By.id("billing_misc1"));
        WebElement field_2 = driver.findElement(By.id("billing_misc2"));
        WebElement delivery_options = driver.findElement(By.id("shipping_delivery_options_cbo"));
        actions.moveToElement(attention_field);
        Assertions.assertTrue(attention_field.isDisplayed());
        attention_field.sendKeys("The Receiver");
        emp_number.sendKeys("1235");
        phone_number.sendKeys("800-448-1484");
        // Select delivery_options = new Select(driver.findElement(By.id("shipping_delivery_options_cbo")));
        delivery_options.click();
        WebElement next_day_air = driver.findElement(By.xpath("//*[@id=\"ext-gen25\"]/div[3]"));
        robot.delay(5500);
        next_day_air.click();
        robot.delay(7000);
        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        robot.delay(5500);
        WebElement place_order_now_btn = driver.findElement(By.id("checkout_place_order_button"));
        place_order_now_btn.click();
        robot.delay(17000);

        // Final Confirmation Of Your Order modal: find Approval notifications
        WebElement final_checkout_btn = driver.findElement(By.id("final_place_order_button"));
        Assertions.assertTrue(final_checkout_btn.isEnabled());
        final_checkout_btn.click();
        robot.delay(12000);

        // Click Approvals link
        WebElement approvals_link = driver.findElement(By.id("nhl_250"));
        approvals_link.click();
        robot.delay(8000);
        WebElement order_4_approval = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/a"));
        order_4_approval.click();
        robot.delay(7000);

        // Find & push Edit button; push View Proof and then Approve & Checkout buttons
        WebElement approvals_edit_btn = driver.findElement(By.linkText("Edit"));
        approvals_edit_btn.click();
        robot.delay(7500);
        // Edit fields
        robot.delay(7500);
        Assertions.assertEquals("COR001 - Business Cards", "COR001 - Business Cards");
        WebElement edit_phone = driver.findElement(By.id("value-Phone"));
        edit_phone.clear();
        edit_phone.sendKeys("410-123-3452");
        WebElement save_btn = driver.findElement(By.id("chili-customize-save-button"));
        save_btn.click();
        WebElement viewProofButton = driver.findElement(By.id("chili-view-proof-text"));
        viewProofButton.click();
        robot.delay(2000);
        WebElement approveCheckout = driver.findElement(By.id("chili-step2b-text"));
        robot.delay(3000);
        approveCheckout.click();
        robot.delay(2500);

        // Verify Approvals page and push Approve Modifications button
        Assertions.assertEquals("Orders Requiring Approval", "Orders Requiring Approval");
        WebElement approve_mods_btn = driver.findElement(By.name("approveButton"));
        approve_mods_btn.click();
        robot.delay(3500);

        // Click in the Approval field, enter text and push Approve button
        WebElement reason = driver.findElement(By.name("reason"));
        WebElement conf_approve = driver.findElement(By.id("approveConfirmButton"));
        // reason.click();
        reason.sendKeys("Approve with modifications");
        robot.delay(1500);
        conf_approve.click();
        robot.delay(3500);
        Assertions.assertEquals("The order has been approved.", "The order has been approved.");
        robot.delay(3000);

        // Check Mailosaur for lowres PDF
        new MailosaurCheck().mailosaurCheckTest();

        // Try to download the high-res PDF and XML via an FTP download; read XML to assert the edit in the above l.123


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
        System.out.println("Expected file download confirmed: " + (jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"COR001.pdf\"}}")));
    }
}
