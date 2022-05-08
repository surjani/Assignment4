package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {

	@AndroidFindBy(accessibility = "test-Username")
	private MobileElement userNameTxtFld;

	@AndroidFindBy(accessibility = "test-Password")
	private MobileElement passwordTxtFld;

	@AndroidFindBy(accessibility = "test-LOGIN")
	private MobileElement loginBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	private MobileElement errorMsg;

	public void enterUserName(String username) {
		clear(userNameTxtFld);
		userNameTxtFld.sendKeys(username);

	}

	public void enterPassword(String password) {
		clear(passwordTxtFld);
		passwordTxtFld.sendKeys(password);

	}

	public void clickLoginBtn() {
		click(loginBtn);
	}

	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		click(loginBtn);
	}

	public String getErrorTxt() {

		return getText(errorMsg);

	}

	/*
	 * public void clickLoginBtn() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
