package com.Pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;

public class AddToCart {

        public WebDriver driver;


        public AddToCart(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
    @FindBy(xpath="//div[@class='product-item-info']//following-sibling::strong/a")
    WebElement MywishlistProduct;

    @FindBy(xpath="//div[@class='product-item-actions']/div/button[@title='Add to Cart']/span")
    WebElement add2Cart;

@FindBy(xpath="//div[@class='message info empty']")
WebElement emptyWishlist;

    @FindBy(xpath = "//span[@class='text']/..")
    WebElement cart;

@FindBy(xpath = "//button[text()='Proceed to Checkout']")
WebElement checkout;

    public void VerifyAddToCart()
        {
            Actions actions=new Actions(driver);
            actions.moveToElement(MywishlistProduct).perform();
            actions.moveToElement(add2Cart).click().perform();
        }
        public void VerifyMyWishlist()
        {
            Assert.assertTrue(emptyWishlist.isDisplayed());
            System.out.println("MyWishList is empty after adding in the cart");
        }
        public  void clickonCart() throws InterruptedException {


            Thread.sleep(3000);
          Actions actions=new Actions(driver);

          actions.moveToElement(cart).click().perform();
           Thread.sleep(3000);
           actions.moveToElement(checkout).click().perform();
        }
    }

