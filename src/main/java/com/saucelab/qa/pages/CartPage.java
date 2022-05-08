package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BaseTest{
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]/android.widget.TextView")
	private MobileElement continueShopping;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView")
	private MobileElement checkOut;
	
	public String scrollToCheckoutAndContinueShopping() {
		return getText(scrollToElement());
	}
	
	public void clickOnContinueShopping() {
		click(continueShopping);
	}
	
	public void clickOnCheckout() {
		click(checkOut);
	}
}
