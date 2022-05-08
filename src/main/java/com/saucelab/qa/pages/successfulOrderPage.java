package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class successfulOrderPage extends BaseTest{
	
	@AndroidFindBy(xpath="//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	private MobileElement successTxt;
	
	public String getSuccessTxt() {
		return getText(successTxt);
	}

}
