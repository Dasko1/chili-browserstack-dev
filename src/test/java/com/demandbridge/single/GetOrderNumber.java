// GetOrderNumber.java: uses JSoup to find an element name from CSS; you can also you Selenide, like in l.
package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GetOrderNumber {

    @Test
    public void getOrderNumber_Test() throws IOException {
/*

        // Before Log in: get the title & Welcome message from the CSS element & print.
        String url = "https://generic.development.dbenterprise.com/Login.epm";

        Document document = Jsoup.connect(url).get();

        // This uses JSoup to find the title of a webpage!
        System.out.println("Before Login");
        String description = document.title();
        Document title = Jsoup.parse(description);
        System.out.println("The Title is: " + title.text());

        // The next line finds the cssElement for "Welcome to DB Commerce" in the URL for the Generic DEV site.  The next 2 lines strip the html tags & prints it!
        Elements cssElement = document.select("#main_content > div > div > p");
        Document welcomeMessage = Jsoup.parse(String.valueOf(cssElement));
        System.out.println("The text from the CSS is: " + welcomeMessage.text());

        System.out.println("\nAfter Login");

        // After login: get the text from CSS for the top order number.

        // Login the JSoup way
        String url1 = "https://generic.development.dbenterprise.com/approval/ApprovalCenter.epm?nhi=250";

        Connection.Response response = Jsoup
                .connect(url)
                .followRedirects(true)
                .data("username", "daskoadmin", "password", "dasko")
                .method(Connection.Method.POST)
                .execute();

        Map<String, String> cookies = response.cookies();

        Document document1 = Jsoup.connect(url1)
                .cookies(cookies)
                .followRedirects(true)
                .get();

        // The next line finds the cssElement for "Shopping cart" in the URL in l.54.  The next 2 lines strip the html tags & prints it!
        // Prints "Orders Requiring Approval; the Order Number CSS will be #approval_content > table > tbody > tr:nth-child(3) > td:nth-child(1) > a
        Elements cssElement1 = document1.select("#approval_content > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");
        Document orderNumber = Jsoup.parse(String.valueOf(cssElement1));
        System.out.println("The order number is: " + orderNumber.text());

*/

        // Use Selenide below!
        open("https://generic.development.dbenterprise.com/");
        System.out.println("\nThis find elements with Selenide!");

        // Print Welcome message found with Selenide!
        String welcomeMessageFromSelenide = $("#main_content > div > div > p").text();
        System.out.println("Selenide gives you the text: " + welcomeMessageFromSelenide);
        Selenide.sleep(2500);

        //Login, go to Approvals and get the order number!
        $(By.name("username")).shouldBe(Condition.visible).sendKeys("daskoadmin");
        $(By.name("password")).sendKeys("dasko");
        $(By.id("loginbutton_btn")).click();
        $(By.id("nhl_250")).shouldBe(Condition.visible).click();
        String orderNumber1 = $("#approval_content > table > tbody > tr:nth-child(2) > td:nth-child(1) > a").text();
        System.out.println("The order number found by Selenide is: " + orderNumber1);
    }
}
