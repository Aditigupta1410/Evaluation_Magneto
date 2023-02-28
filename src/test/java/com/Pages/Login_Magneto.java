package com.Pages;

import com.CommonMethod.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Magneto {

    SeleniumActions seleniumActions;
    public WebDriver driver;

    public Login_Magneto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions=new SeleniumActions(driver);

    }

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(xpath = "//div[@class='field password required']/div/input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='action login primary']/span[text()='Sign In']")
    WebElement signin;

    public void webelementPerform() throws InterruptedException {
        Thread.sleep(10);
        seleniumActions.EnterValueOnTextfield(email,"aditigupta9700@gmail.com");
        Thread.sleep(10);
        seleniumActions.EnterValueOnTextfield(password,"Aditi@1401");
        seleniumActions.clickOnElement(signin);

    }
}
