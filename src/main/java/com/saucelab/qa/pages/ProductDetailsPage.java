package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsPage extends BaseTest {

	@AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
	private MobileElement backToProductBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
	private MobileElement SBLTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
	private MobileElement SBLPrice;

	public String getSBLTitle() {
		return getText(SBLTitle);
	}

	public String getSBLPrice() {
		return getText(SBLPrice);
	}

	public void clickOnBackToProduct() {
		click(backToProductBtn);
	}

	public void scrollToElementRemoveAndClick() {
		MobileElement removeItem=(MobileElement) ((FindsByAndroidUIAutomator) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"REMOVE\"));");
		System.out.println(removeItem.getLocation());
		removeItem.click();
	}

}
