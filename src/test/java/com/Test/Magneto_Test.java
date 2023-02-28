package com.Test;

import com.Base.Magneto_Base;
import com.Pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class Magneto_Test extends Magneto_Base {

Login_Magneto lm;
HomePage hp;
BagsPage bp;
AddToCart addToCart;
    ShippingAddressPage shippingAddressPage;
    @Test
    public void Task1() throws InterruptedException, IOException, ParseException {
        lm = new Login_Magneto(driver);
        hp=new HomePage(driver);
        bp=new BagsPage(driver);
        addToCart=new AddToCart(driver);
        shippingAddressPage=new ShippingAddressPage(driver);

        lm.webelementPerform();
        hp.selectBag();
        hp.highPrice();
       bp.clickonWishlist();
      // bp.verifyWishlist();
       addToCart.VerifyAddToCart();
addToCart.VerifyMyWishlist();
        addToCart.clickonCart();
       // addToCart.clickonCart();
        shippingAddressPage.fillShippingAddress();
shippingAddressPage.clickONNext();
shippingAddressPage.clickONPlaceorder();
shippingAddressPage.orderID();
shippingAddressPage.orderidVerify();

    }
}

