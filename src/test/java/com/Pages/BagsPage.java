package com.Pages;

import com.CommonMethod.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage {
    SeleniumActions seleniumActions;
    public WebDriver driver;


    public BagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions=new SeleniumActions(driver);
    }

   @FindBy(xpath = "//span[text()='Add to Wish List']")
    WebElement addToWishList;
    @FindBy(xpath="//div[@class='product-item-info']//following-sibling::strong/a")
   WebElement wishlist;

  // @FindBy(xpath="//body[contains(@class,'account wishlist')]")
  // WebElement mywishList;

    public void clickonWishlist() throws InterruptedException {
        seleniumActions.clickOnElement(addToWishList);
        Thread.sleep(2000);
        //mywishList.click();
        Assert.assertTrue(wishlist.isDisplayed());
        System.out.println(wishlist.getText());

    }

    }




