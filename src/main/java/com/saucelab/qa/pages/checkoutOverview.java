package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class checkoutOverview extends BaseTest {

	/*
	 * @AndroidFindBy(xpath="") private MobileElement checkoutTitle;
	 */

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView")
	private MobileElement finishBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CANCEL\"]/android.widget.TextView")
	private MobileElement cancelBtn;

	/*public  void scrollToFinish() {
		return getText(scrollToElementFinish());
	}*/
	
	public void scrollToElementFinishAndClick() {
		MobileElement item=(MobileElement) ((FindsByAndroidUIAutomator) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"FINISH\"));");
		System.out.println(item.getLocation());
		item.click();
	}
	
	public void clickOnCancelBtn() {
		click(cancelBtn);
	}
	
	/*public void clickOnFinishBtn() {
		
		//click(finishBtn);
	}*/

}
