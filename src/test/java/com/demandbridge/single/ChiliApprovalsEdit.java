package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demandbridge.BrowserStackTest;
import com.demandbridge.single.pages.MailosaurCheck;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.*;


public class ChiliApprovalsEdit extends BrowserStackTest {

    // Run in BrowserStack Dashboard
    public static final String AUTOMATE_USERNAME = "anastasiosdaskal1";
    public static final String AUTOMATE_ACCESS_KEY = "swze39oMCvW69Gsgh8qA";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static String x = "";
    private static final String orderNumber = "";                                                     // Sends Order Number, l.193.


    @Test
    public static void chiliApprovalsAsIs_Test() throws MalformedURLException, SftpException, InterruptedException, JSchException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        // caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "Chili Approvals Edit"); // test name
        caps.setCapability("build", "Chili Approvals Edit 1"); // CI/CD job or build name

        // Go to Generic page and login
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        open("https://generic.development.dbenterprise.com/");
        $(By.name("username")).sendKeys("daskoadmin");
        $(By.name("password")).sendKeys("dasko");
        $(By.id("loginbutton_btn")).click();

        System.out.println(driver.getTitle());

        // Assert page title and click Cart button
        Selenide.sleep(4000);
        $(By.id("shopping-cart-item-count")).shouldBe(Condition.visible);
        Selenide.title().contains("DB Commerce");
        $(By.id("checkout-button")).shouldBe(Condition.visible).click();

        // Shopping Cart
        Selenide.sleep(5000);
        $(By.id("checkout_update_quantities_button")).shouldBe(Condition.visible);
        Selenide.sleep(2000);

        // Shipping Location/Billing Required Fields: set Deliver Options to Next Day Air; push Place This Order Now button l.96
        SelenideElement attention_field = $(By.id("shipping_attention"));
        SelenideElement emp_number = $(By.id("shipping_misc1"));
        SelenideElement phone_number = $(By.id("shipping_misc2"));
        SelenideElement email = $(By.id("billing_email"));
        SelenideElement field_1 = $(By.id("billing_misc1"));
        SelenideElement field_2 = $(By.id("billing_misc2"));
        SelenideElement delivery_options = $(By.id("shipping_delivery_options_cbo"));
        attention_field.sendKeys("The Receiver");
        emp_number.sendKeys("1235");
        phone_number.sendKeys("800-448-1484");

        delivery_options.click();
        Selenide.sleep(3000);
        delivery_options.sendKeys(Keys.ARROW_DOWN);
        delivery_options.sendKeys(Keys.ARROW_DOWN);
        delivery_options.sendKeys(Keys.ENTER);

        // Select A Payment Method dropdown: Select credit card.
        $(By.id("payment_method_cbo")).clear();
        $(By.id("payment_method_cbo")).sendKeys("Holder A Dee ending with 1111");
        $(By.id("payment_method_cbo")).click();

        // Wait for Place This Order Now button to activate
        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        Selenide.sleep(7000);

        email.sendKeys("ad@qgowwpz9.mailosaur.net");
        field_1.sendKeys("Field One");
        field_2.sendKeys("Field Two");
        Selenide.sleep(10000);
        /**/

        // WebElement place_order_now_btn = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.id("checkout_place_order_button")));
        $(By.id("payment_method_cbo")).click();
        $(By.id("checkout_place_order_button")).scrollIntoView(true).click();
        Selenide.sleep(19000);

        // Final Confirmation Of Your Order modal: find Approval notifications
        $(By.id("final_place_order_button")).scrollIntoView(true).click();
        Selenide.sleep(25000);

        // Order Confirmation Page: find order number by CSS element: l.113;  Confirm "Thank you for placing your order!" on page: l.112.
        $("#main_content > div > h1 ").shouldBe(Condition.visible);
        String orderNumber = $("p a[href*='ViewOrder']").text();
        System.out.println("\nThe order number is: " + orderNumber);

        // Click Approvals link
        open("https://generic.development.dbenterprise.com/approval/ApprovalCenter.epm?nhi=250");
        Selenide.sleep(8000);
        $("#approval_content > table > tbody > tr:nth-child(2) > td:nth-child(1) > a").click();
        Selenide.sleep(10000);

        // Find & push Edit button; push View Proof and then Approve & Checkout buttons
        $(By.linkText("Edit")).scrollIntoView(true).click();
        Selenide.sleep(8000);
        // Edit fields
        Selenide.sleep(8000);
        Assertions.assertEquals("COR001 - Business Cards", "COR001 - Business Cards");
        $(By.id("value-Phone")).clear();
        $(By.id("value-Phone")).sendKeys("410-123-3452");
        $(By.id("value-Name")).clear();
        $(By.id("value-Name")).sendKeys("Wolfgang Schwanz");
        $(By.id("value-Title")).clear();
        $(By.id("value-Title")).sendKeys("The Great All-Knowing");

        $(By.id("chili-customize-save-button")).click();
        $(By.id("chili-view-proof-text")).click();
        Selenide.sleep(6500);
        $(By.id("chili-customize-step2b-button")).click();
        Selenide.sleep(7000);

        // Verify Approvals page and push Approve Modifications button
        Assertions.assertEquals("Orders Requiring Approval", "Orders Requiring Approval");
        $(By.name("approveButton")).scrollIntoView(true).click();
        Selenide.sleep(5000);

        // Click in the Approval field, enter text and push Approve button
        $(By.name("reason")).scrollIntoView(true).sendKeys("Test automation approval!");
        $(By.id("approveConfirmButton")).click();
        Selenide.sleep(4000);
        Assertions.assertEquals("The order has been approved.", "The order has been approved.");
        Selenide.sleep(3000);

        /**/

        /*
        // Assert the changed text in the
        // Try to download the high-res PDF and XML via an FTP download; read XML to assert the edit in the above l.123

        // The next line finds the cssElement for "Open source" in the URL in l.13.  The next 2 lines strip the html tags & prints it!
        */
        /*Elements cssElement = document.select("body > div > div.content > div.col1 > h2:nth-child(11)");
        Document orderNumber = (Document) Jsoup.parse(String.valueOf(cssElement));
        System.out.println("The order number is: " + orderNumber.text());*//*
         */

        // Check Mailosaur for lowres PDF
        new MailosaurCheck().mailosaurCheckTest();
        // Download the files from the ftpserver
        SFTPClientDB.main();

        //Return to Approvals
        // open("https://generic.development.dbenterprise.com/approval/ApprovalCenter.epm?nhi=250");
        // Selenide.sleep(20000);


        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.titleContains("DB Demo"));
            markTestStatus("passed","Yaay, the title contains 'DB Demo'!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","Title does not contain 'DB Demo'!",driver);
        }

        driver.quit();
    }

   // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
        // System.out.println("Expected file download confirmed: " + (jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"00-X00248-2_doc_lowres.pdf\"}}")));
        // System.out.println("Expected file download confirmed: " + (jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"00-X00248-2_doc_highres.pdf\"}}")));
    }
}
