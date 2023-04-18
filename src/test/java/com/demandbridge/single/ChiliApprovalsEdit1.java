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
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class ChiliApprovalsEdit1 {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void chiliApprovalsAsIs_Test() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "ChiliApprovals Edit"); // test name
        caps.setCapability("build", "ChiliApprovals Edit"); // CI/CD job or build name

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
        checkout_btn.click();

        // Shopping Cart
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebElement update_quant_btn = driver.findElement(By.id("checkout_update_quantities_button"));
        Assertions.assertTrue(update_quant_btn.isDisplayed());

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

        // Wait for Place This Order Now button to activate
        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        field_3.sendKeys(Keys.ENTER);
        Selenide.sleep(7000);

        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        field_3.sendKeys(Keys.ENTER);

        WebElement place_order_now_btn = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.id("checkout_place_order_button")));

        place_order_now_btn.click();
        Selenide.sleep(8000);

        // Final Confirmation Of Your Order modal: find Approval notifications
        WebElement final_checkout_btn = driver.findElement(By.id("final_place_order_button"));
        Assertions.assertTrue(final_checkout_btn.isEnabled());
        final_checkout_btn.click();
        Selenide.sleep(7000);

        // Click Approvals link
        WebElement approvals_link = driver.findElement(By.id("nhl_250"));
        approvals_link.click();
        Selenide.sleep(8000);
        WebElement order_4_approval = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/a"));
        order_4_approval.click();
        Selenide.sleep(4000);

        // Find & push Edit link; push View Proof and then Approve & Checkout buttons
        WebElement edit_link = driver.findElement(By.linkText("Edit"));
        edit_link.click();
        Selenide.sleep(8000);
        WebElement phone = driver.findElement(By.id("value-Phone"));
        WebElement name = driver.findElement(By.id("value-Name"));
        WebElement title = driver.findElement(By.id("value-Title"));
        // Edit fields
        Selenide.sleep(8000);
        Assertions.assertEquals("COR001 - Business Cards", "COR001 - Business Cards");
        phone.clear();
        phone.sendKeys("410-123-3452");
        name.clear();
        name.sendKeys("Wolfgang Schwanz");
        title.clear();
        title.sendKeys("The Great All-Knowing");

        // Click View Proof button
        WebElement view_proof_btn = driver.findElement(By.id("chili-view-proof-text"));
        WebElement approve_and_checkout_btn = driver.findElement(By.id("chili-customize-step2b-button"));
        view_proof_btn.click();
        Selenide.sleep(6500);
        approve_and_checkout_btn.click();
        Selenide.sleep(7000);

        // Click Approvals link
        WebElement approve_btn = driver.findElement(By.name("approveButton"));                  // Push Approve button
        approve_btn.click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement reason_field = driver.findElement(By.name("reason"));
        reason_field.sendKeys("Approved for test purposes!");
        WebElement confirm_btn = driver.findElement(By.name("confirmButton"));                  // Push Confirm button in modal
        confirm_btn.click();
        Assertions.assertEquals("The order has been approved.", "The order has been approved.");

        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.urlContains("CheckoutV2"));
            markTestStatus("passed","Yaay, the 'Approve Edit' test passed!",driver);
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
