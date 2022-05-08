package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends BaseTest {
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	private MobileElement productTitleTxt;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
	private MobileElement slbTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
	private MobileElement slbPrice;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
	private MobileElement slbAdd;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")
	private MobileElement slblTitle;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[2]")
	private MobileElement slblPrice;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView")
	private MobileElement slblAdd;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	private MobileElement cartButton;

	public String getTitle() {
		return getText(productTitleTxt);
	}

	public String getslbTitle() {
		return getText(slbTitle);
	}

	public String getslbPrice() {
		return getText(slbPrice);
	}

	public void clickSLBTitle() {
		click(slbPrice);
	}

	public void addSlb() {
		click(slbAdd);
	}
	
	public String getslblTitle() {
		return getText(slblTitle);
	}
	
	public void addSlbl() {
		click(slblAdd);
	}

	public void clickOnCart() {
		click(cartButton);
	}

}
