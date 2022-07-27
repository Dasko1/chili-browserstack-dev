package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.demandbridge.BrowserStackTest;
import com.demandbridge.single.pages.OrderReportsSalesReports;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationReports extends BrowserStackTest {

    @Test
    public void automationReportsTest(){

        // Go to page and login: verify that login succeeds. The below URL is legacy, the one after that is EQC, the new one.
        open("https://qnet.e-quantum2k.com/~support2/cgi-bin/nph-login.cgi?Client=&CC=&User=adaskalopoulos@demandbridge.com&Passwd=reds2");

        // Push Reports element
        $(By.id("eqcNavReports")).shouldBe(Condition.visible).click();


        //BUDGET: First Dropdown - ll.31-109
        // Push Category Budget Transaction & switch to iFrame: Run Current Year, Run Last Year, report to Excel & text for both.

/*

        $(By.id("p0~24")).shouldBe(Condition.visible).click();                                 // This opens Budget dropdown
        $(By.id("dl1~24~6")).shouldBe(Condition.visible).click();                              // Click Category Budget Transactions
        Selenide.sleep(1500);
        switchTo().frame("details");
        executeJavaScript("RunReport('CURRENT')");                                      // Push Run Current Year button
        Selenide.sleep(1500);
        switchTo().window(1);
        $("body").shouldHave(Condition.text("Category Budget Transaction Report"));
        $("body > input[type=button]:nth-child(7)").click();
        $("body > input[type=button]:nth-child(8)").click();
        $("body > input[type=button]:nth-child(5)").click();                        // Close window
        Selenide.sleep(1500);

        // Click Cost Budget Center
        switchTo().window(0);
        $(By.id("dl1~24~5")).shouldBe(Condition.visible).click();
        Selenide.sleep(1500);
        switchTo().frame("details");
        $("body").shouldHave(Condition.text("Cost Center Budget Report"));
        $("body").shouldHave(Condition.text("Make Budget Adjustments"));
        // Push Yes radio button on Make Budget Adjustments
        $(By.name("MkBdgAdj")).selectRadio("1");
        Selenide.sleep(1500);
        // Click Run Current Year button
        $("body > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input[type=button]").click();
        switchTo().window(1);
        $(By.id("BVSTLOUIS0")).shouldBe(Condition.visible).click();                                    // Click St. Louis January
        Selenide.sleep(3000);
        $(By.id("AddAdjustmentDiv")).shouldBe(Condition.visible).click();                              // Click Add Adjustment link
        $(By.id("Description")).shouldBe(Condition.visible).sendKeys("Test Descriptions");             // Enter Description
        $(By.id("Amount")).shouldBe(Condition.visible).sendKeys("2.00");                                // Enter 2.00 into Amount
        $(By.id("AddAdjustmentDiv")).shouldBe(Condition.visible).click();                              // Now Save adjustment & Close
        executeJavaScript("hide_detail_popup()");
        Selenide.sleep(2500);
        switchTo().window(0);
        // Push Pie Graph radio button & Push Current Year button
        switchTo().frame("details");
        $("body").shouldHave(Condition.text("Cost Center Budget Report"));
        $("body").shouldHave(Condition.text("Make Budget Adjustments"));
        $(By.name("ReportFormat")).selectRadio("pie3d");
        $("body > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input[type=button]").click();
        Selenide.sleep(2000);
        // Push Bar Graph radio button & Push Current Year button
        switchTo().window(0);
        switchTo().frame("details");
        $(By.name("ReportFormat")).selectRadio("bar3d");
        $("body > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input[type=button]").click();
        switchTo().window(1);
        Selenide.sleep(2000);
        Selenide.closeWindow();

        // Detail Budget Transaction
        switchTo().window(0);
        $(By.id("dl1~24~7")).shouldBe(Condition.visible).click();
        Selenide.sleep(1500);
        switchTo().frame("details");
        // Push Run Report button
        $("body > form > table > tbody > tr:nth-child(20) > td > input[type=button]").scrollIntoView(true);
        $("body > form > table > tbody > tr:nth-child(20) > td > input[type=button]").click();
        switchTo().window(1);
        Selenide.sleep(8000);
        $("body > input[type=button]:nth-child(10)").click();                                       // Close button
        //$("body > input[type=button]:nth-child(12)").click();
        //Selenide.sleep(2000);

        // Setup Cost Center Budgets
        switchTo().window(0);
        $(By.id("dl1~24~4")).shouldBe(Condition.visible).click();                                       // Click Setup Cost Center Budgets
        Selenide.sleep(2000);
        switchTo().frame("details");
        $("body > div:nth-child(7)").shouldBe(Condition.visible).click();
        switchTo().window(1);
        Selenide.sleep(2000);
        $("body > div").shouldHave(Condition.text("Report Budget Setup"));
        Selenide.sleep(2000);
        $("body > input:nth-child(12)").shouldBe(Condition.visible).click();                // Push Export Excel
        $("body > input:nth-child(13)").shouldBe(Condition.visible).click();                // Push Export Text
        Selenide.closeWindow();

        // INVENTORY REPORTS - ll.112-238
        // Backorder
        switchTo().window(0);
        $(By.id("dl0~25")).click();
        // Open Backorder and verify reports open in HTML & PDF
        $(By.id("dl1~25~1")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        Selenide.sleep(2500);
        $("body > table > tbody > tr:nth-child(1) > td:nth-child(1) > img").shouldBe(Condition.visible).click();
        switchTo().window(1);
        Selenide.sleep(1000);
        executeJavaScript("window.open('close.html', '_self')");
        Selenide.sleep(1500);
        switchTo().window(0);
        switchTo().frame("details");
        Selenide.sleep(1000);
        // executeJavaScript("document.fpbo.submit()");
        $("body > table > tbody > tr:nth-child(2) > td:nth-child(1) > img").shouldBe(Condition.visible).click();
        switchTo().window(1);
        Selenide.sleep(8000);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        Selenide.sleep(5000);

        // Click Cost Center Inventory Usage, then CC Inv Usage Standard & CC Inv Usage YTD
        $(By.id("p1~25~8")).shouldBe(Condition.visible).click();                       // Click open Cost Center Inventory Usage
        $("#dl2\\~25\\~8\\~32").shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $(By.name("Submit")).shouldBe(Condition.visible).click();                       // Push Submit button
        Selenide.sleep(1500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        $("#dl2\\~25\\~8\\~33").shouldBe(Condition.visible).click();           // Click CC Inv Usage TYD link
        switchTo().frame("details");
        $(By.name("Submit")).shouldBe(Condition.visible).click();                       // Push Submit button
        Selenide.sleep(1500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");
        switchTo().window(0);
        // Click Inventory link in Inventory Reports
        $(By.id("dl1~25~2")).click();
        switchTo().frame("details");
        $("body > center > b").shouldHave(Condition.text("Inventory Report"));
        $(By.name("Submit")).click();                                                   // Push Submit button
        switchTo().window(1);
        $("body > div.whTitle").shouldHave(Condition.text("Inventory Report"));
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        switchTo().window(0);
        switchTo().frame("details");
        $("body > center > b").shouldHave(Condition.text("Inventory Report"));
        $("#formatEHTML").click();                                            // Select HTML to export
        $(By.name("Submit")).click();                                                  // Push Submit button
        switchTo().window(1);
        Selenide.sleep(4000);
        $("body > div.whTitle").shouldHave(Condition.text("Inventory Report"));
        $("body > div.noPrint > input[type=button]:nth-child(4)").click();   // Push Export Excel button
        $("body > div.noPrint > input[type=button]:nth-child(5)").shouldBe(Condition.enabled).click();
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        Selenide.sleep(5000);

        // Click Perpetual Inventory, below Cost Center Inventory Usage
        switchTo().window(0);
        $(By.id("dl1~25~11")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $("body > center > b").shouldHave(Condition.text("Perpetual Inventory"));
        $("body > table > tbody > tr:nth-child(1) > td:nth-child(2) > span").click();         // Open HTML Report & confirm
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        switchTo().window(1);
        $("body").shouldHave(Condition.text("Perpetual Inventory Entry Screen"));
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        switchTo().window(0);
        Selenide.sleep(1500);
        $(By.id("dl1~25~11")).shouldBe(Condition.visible).click();                      // Click Perpetual Inventory link
        Selenide.sleep(4000);
        switchTo().frame("details");
        $("body > table > tbody > tr:nth-child(2) > td:nth-child(1) > img").click();       // View report in HTML format with pre-filled quantities.
        Selenide.sleep(2500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        Selenide.sleep(1500);
        switchTo().window(0);
        switchTo().frame("details");
        Selenide.sleep(1500);
        $("body > table > tbody > tr:nth-child(3) > td:nth-child(2) > span").click();       // View Report in PDF Format
        Selenide.sleep(2500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        Selenide.sleep(1500);
        switchTo().window(0);
        switchTo().frame("details");
        Selenide.sleep(1500);
        $("body > table > tbody > tr:nth-child(4) > td:nth-child(2) > span").click();       // View Report in PDF Format
        Selenide.sleep(2500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        Selenide.sleep(1500);
        switchTo().window(0);
        switchTo().frame("details");
        Selenide.sleep(1500);
        $("body > table > tbody > tr:nth-child(5) > td:nth-child(2) > span").click();       // View Report in PDF Format
        Selenide.sleep(2500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        Selenide.sleep(1500);
        switchTo().window(0);
        switchTo().frame("details");
        Selenide.sleep(1500);
        $("body > table > tbody > tr:nth-child(6) > td:nth-child(2) > span").click();       // View Report in PDF Format
        Selenide.sleep(2500);
        switchTo().window(1);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button
        Selenide.sleep(1500);
        switchTo().window(0);
        // switchTo().frame("details");
        Selenide.sleep(1500);


        // Usage Pending & Shipped
        $(By.id("dl1~25~44")).shouldBe(Condition.visible).click();
        switchTo().frame("details");
        $(By.name("StartDate")).shouldBe(Condition.visible).sendKeys("Apr-15-2022");
        executeJavaScript("runReport()");
        switchTo().window(1);
        Selenide.sleep(1500);
        executeJavaScript("window.open('close.html', '_self')");                 // Push Close button

        switchTo().window(0);

*/

//        new OrderReportsCategoryGraph().orderReportCategoryGraphTest();
//        new OrderReportsOpenOrder().orderReportsOpenOrderTest();
//        new OrderReportsOrderSummary().orderReportsOrderSummaryTest();
//        new OrderReportsOrderTracking().orderReportsOrderTrackingTest();
        new OrderReportsSalesReports().salesReports();
//        new OrderReportsStoreProfiler().orderReportsStoreProfilerTest();
//        new OrderReportsManagerApprovalStatus().orderReportsManagerApprovalStatusTest();
//        new StatusCenterTrackJobs().statusCenterTrackJobsTest();


        // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'DB Commerce'
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            // wait.until(ExpectedConditions.urlContains("qnet-rtps.cgi"));
            wait.until(ExpectedConditions.titleIs("Redesign Two"));
            markTestStatus("passed","Yaay the URL contains qnet-rtps.cgi!",driver);
            markTestStatus("passed", "Yaay, Report Details Reviewed!",driver);
        }
        catch(Exception e) {
            markTestStatus("failed","The URL does not contain qnet-rtps.cgi",driver);
            markTestStatus("failed", "The Title is not EQ Commerce",driver);
        }

        driver.quit();
    }

    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }
}
