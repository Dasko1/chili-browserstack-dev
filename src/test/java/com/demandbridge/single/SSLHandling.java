package com.demandbridge.single;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLHandling {

    public static void main(String[] args) {

        //DesiredCapabilities handlSSLErr = new DesiredCapabilities();
        //handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
        //WebDriver driver =new ChromeDriver (handlSSLErr);


        //Create instance of ChromeOptions Class
        ChromeOptions handlingSSL = new ChromeOptions();

        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Set path to chromedriver
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        WebDriver driver = new ChromeDriver(handlingSSL);


        //Launching the URL
        driver.get("https://expired.badssl.com/");
        System.out.println("The page title is : " +driver.getTitle());
        driver.quit();
    }
}
