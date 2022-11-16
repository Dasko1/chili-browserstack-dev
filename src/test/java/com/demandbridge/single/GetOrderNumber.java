package com.demandbridge.single;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
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
import static com.codeborne.selenide.Selenide.screenshot;

public class GetOrderNumber {

    @Test
    public void getOrderNumber_Test() throws IOException {

        // Before Log in: get the Welcome message from the CSS element.
        String url = "https://generic.development.dbenterprise.com/Login.epm";

        Document document = Jsoup.connect(url).get();

        // This uses JSoup to find the title of a webpage!
        String description = document.title();
        Document title = Jsoup.parse(description);
        System.out.println("The Title Is : " + title.text());

        // The next line finds the cssElement for "Welcome to DB Commerce" in the URL for the Generic DEV site.  The next 2 lines strip the html tags & prints it!
        Elements cssElement = document.select("#main_content > div > div > p");
        Document welomeMessage = Jsoup.parse(String.valueOf(cssElement));
        System.out.println("The text from the CSS is: " + welomeMessage.text());

        System.out.println("\nAfter login");

        // After login

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

        // The next line finds the cssElement for "Open source" in the URL in l.13.  The next 2 lines strip the html tags & prints it!
        Elements cssElement1 = document1.select("#header-shopping-cart");
        Document orderNumber = Jsoup.parse(String.valueOf(cssElement1));
        System.out.println("The order number is: " + orderNumber.text());

    }
}
