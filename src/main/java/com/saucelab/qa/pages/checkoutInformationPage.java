package com.saucelab.qa.pages;

import com.saucelab.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class checkoutInformationPage extends BaseTest{
	
	@AndroidFindBy(accessibility="test-First Name")
	private MobileElement firstNameTxtFld;
	
	@AndroidFindBy(accessibility="test-Last Name")
	private MobileElement lastNameTxtFld;
	
	@AndroidFindBy(accessibility="test-Zip/Postal Code")
	private MobileElement postalCodeTxtFld;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-CANCEL\"]/android.widget.TextView")
	private MobileElement cancelBtn;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView")
	private MobileElement continueBtn;
	
	public void enterFirstName(String firstName) {
		clear(firstNameTxtFld);
		firstNameTxtFld.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {
		clear(lastNameTxtFld);
		lastNameTxtFld.sendKeys(lastName);

	}
	
	public void enterPostalCode(String postalCode) {
		clear(postalCodeTxtFld);
		postalCodeTxtFld.sendKeys(postalCode);

	}

	public void clickcontinueBtn() {
		click(continueBtn);
	}

	public void login(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
		click(continueBtn);
	}

}
