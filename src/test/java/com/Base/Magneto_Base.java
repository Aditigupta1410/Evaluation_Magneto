package com.Base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Magneto_Base {
     protected WebDriver driver;
    @BeforeSuite
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void openApp() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        ChromeOptions chromeOptions=new ChromeOptions();
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.merge(chromeOptions);
        driver=new RemoteWebDriver(new URL("https://aditigupta9700:SS2kFB3daRbvKNru2TJDoD75UH2qYp1eK8lO3jdHhiEeWLi9wG@hub.lambdatest.com/wd/hub"),chromeOptions);
        driver = new RemoteWebDriver(new URL( "http://172.18.0.139:4444"),chromeOptions);

    driver.get("https://magento.softwaretestingboard.com/customer/account/");
    driver.manage().window().maximize();
    }

    @AfterTest
    public void closeApp()
    {

        driver.quit();
    }


}

