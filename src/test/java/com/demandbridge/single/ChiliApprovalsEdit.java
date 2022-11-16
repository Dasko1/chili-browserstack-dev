package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import com.demandbridge.single.pages.MailosaurCheck;
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


public class ChiliApprovalsEdit {

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
        caps.setCapability("build", "ChiliApprovals Edit 1"); // CI/CD job or build name

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
        driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
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


        delivery_options.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        delivery_options.sendKeys(Keys.ARROW_DOWN);
        delivery_options.sendKeys(Keys.ARROW_DOWN);
        delivery_options.sendKeys(Keys.ENTER);

        // Wait for Place This Order Now button to activate
        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        Selenide.sleep(7000);

        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");

        WebElement place_order_now_btn = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.id("checkout_place_order_button")));

        place_order_now_btn.click();
        Selenide.sleep(8000);

        // Final Confirmation Of Your Order modal: find Approval notifications
        WebElement final_checkout_btn = driver.findElement(By.id("final_place_order_button"));
        Assertions.assertTrue(final_checkout_btn.isEnabled());
        final_checkout_btn.click();
        Selenide.sleep(15000);

        // Click Approvals link
        WebElement approvals_link = driver.findElement(By.id("nhl_250"));
        approvals_link.click();
        Selenide.sleep(8000);
        WebElement order_4_approval = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/a"));
        order_4_approval.click();
        Selenide.sleep(17000);

        // Find & push Edit button; push View Proof and then Approve & Checkout buttons
        WebElement approvals_edit_btn = driver.findElement(By.linkText("Edit"));
        approvals_edit_btn.click();
        Selenide.sleep(8000);
        // Edit fields
        Selenide.sleep(10000);
        Assertions.assertEquals("COR001 - Business Cards", "COR001 - Business Cards");
        WebElement edit_phone = driver.findElement(By.id("value-Phone"));
        edit_phone.clear();
        edit_phone.sendKeys("410-123-3452");
        WebElement save_btn = driver.findElement(By.id("chili-customize-save-button"));
        save_btn.click();
        WebElement viewProofButton = driver.findElement(By.id("chili-view-proof-text"));
        viewProofButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement approveCheckout = driver.findElement(By.id("chili-step2b-text"));
        Selenide.sleep(7000);
        approveCheckout.click();
        Selenide.sleep(7000);

        // Verify Approvals page and push Approve Modifications button
        Assertions.assertEquals("Orders Requiring Approval", "Orders Requiring Approval");
        WebElement approve_mods_btn = driver.findElement(By.name("approveButton"));
        approve_mods_btn.click();
        Selenide.sleep(4000);

        // Click in the Approval field, enter text and push Approve button
        WebElement reason = driver.findElement(By.name("reason"));
        WebElement conf_approve = driver.findElement(By.id("approveConfirmButton"));
        // reason.click();
        reason.sendKeys("Approve with modifications");
        Selenide.sleep(2000);
        conf_approve.click();
        Selenide.sleep(4000);
        Assertions.assertEquals("The order has been approved.", "The order has been approved.");
        Selenide.sleep(3000);

        // Assert the changed text in the
        // Try to download the high-res PDF and XML via an FTP download; read XML to assert the edit in the above l.123

        // The next line finds the cssElement for "Open source" in the URL in l.13.  The next 2 lines strip the html tags & prints it!
        /*Elements cssElement = document.select("body > div > div.content > div.col1 > h2:nth-child(11)");
        Document orderNumber = (Document) Jsoup.parse(String.valueOf(cssElement));
        System.out.println("The order number is: " + orderNumber.text());*/

        // Check Mailosaur for lowres PDF
        new MailosaurCheck().mailosaurCheckTest();

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
        System.out.println("Expected file download confirmed: " + (jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"00-X00248-2_doc_lowres.pdf\"}}")));
        System.out.println("Expected file download confirmed: " + (jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"00-X00248-2_doc_highres.pdf\"}}")));
    }

}
