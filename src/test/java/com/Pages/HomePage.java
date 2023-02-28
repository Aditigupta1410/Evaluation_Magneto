package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    // @FindBy(xpath = "//span[text()='Gear']//../following-sibling::ul/li/a/span[text()='Bags']")

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gear;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement Bags;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cart;

    @FindBy(xpath = "//div[contains(@class,'block block-minicart ')]")
    WebElement emptycart;

    public void selectBag() throws InterruptedException {
        Thread.sleep(10);
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).perform();
        Thread.sleep(1000);
        actions.moveToElement(Bags).click().perform();
        cart.click();
        Assert.assertTrue(emptycart.isDisplayed());
        System.out.println("Empty cart is displayed");
    }

    public void highPrice() {
        List<WebElement> listofallprices = new ArrayList<WebElement>();
        listofallprices = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li[8]/div/a/following-sibling::div/strong/following-sibling::div[2]/span/span/span[text()='$74.00']"));
        List<Double> allproductsamount = new ArrayList<>();

        for (WebElement webElement : listofallprices) {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }
        System.out.println(Collections.max(allproductsamount));
        Double maxproductamount = Collections.max(allproductsamount);
        System.out.println("max amount" + maxproductamount);
        WebElement maxprodamountName = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'" + maxproductamount + "')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
        System.out.println(maxprodamountName.getText());
        maxprodamountName.click();
    }
}
