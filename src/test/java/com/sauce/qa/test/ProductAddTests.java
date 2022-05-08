package com.sauce.qa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucelab.qa.base.BaseTest;
import com.saucelab.qa.pages.CartPage;
import com.saucelab.qa.pages.LoginPage;
import com.saucelab.qa.pages.ProductPage;
import com.saucelab.qa.pages.checkoutInformationPage;
import com.saucelab.qa.pages.checkoutOverview;
import com.saucelab.qa.pages.successfulOrderPage;

import io.appium.java_client.MobileElement;

public class ProductAddTests extends BaseTest {

	FileInputStream detail;
	JSONObject loginUser;
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	checkoutInformationPage checkoutPage;
	checkoutOverview overview;
	successfulOrderPage success;

	@BeforeClass
	public void readJSONFile() throws FileNotFoundException {
		detail = new FileInputStream(
				"\\Users\\SurjaniBiswas\\eclipse-workspace\\SLAppium\\src\\test\\resources\\Data\\data.json");
		JSONTokener jsonToken = new JSONTokener(detail);
		loginUser = new JSONObject(jsonToken);
		/*
		 * closeApp(); launchApp();
		 */
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		System.out.println("************* starting test" + m.getName() + "*******");
		// closeApp();
		// launchApp();
		loginPage = new LoginPage();// Initialize the Page
		productPage = new ProductPage();

		cartPage = new CartPage();
		checkoutPage = new checkoutInformationPage();
		overview = new checkoutOverview();
		success = new successfulOrderPage();

	}

	@Test(priority = 1)
	public void successfulLogin() {
		loginPage.enterUserName(loginUser.getJSONObject("validUser").getString("username"));
		loginPage.enterPassword(loginUser.getJSONObject("validUser").getString("password"));
		loginPage.clickLoginBtn();

		String actualString = productPage.getTitle();
		String expectedString = "PRODUCTS";

		Assert.assertEquals(actualString, expectedString);

	}

	@Test(priority = 2)
	public void addSLBInCart() {
		productPage.addSlb();

	}

	/*
	 * @Test(priority = 3) public void addSLBLInCart() { productTwo.addSlbl(); }
	 */

	@Test(priority = 3)
	public void clickOnCartBtn() {
		productPage.clickOnCart();
	}

	/*
	 * @Test(priority = 5) public void scrollToCheckoutBtn() { MobileElement item =
	 * cartPage.scrollToElement(); item.click();
	 * 
	 * }
	 */

	@Test(priority = 4)
	public void clickOnCheckoutBtn() {
		cartPage.clickOnCheckout();
	}

	@Test(priority = 5)
	public void enterCheckoutInfo() {
		checkoutPage.enterFirstName(loginUser.getJSONObject("customerInfo").getString("firstname"));
		checkoutPage.enterLastName(loginUser.getJSONObject("customerInfo").getString("lastname"));
		checkoutPage.enterPostalCode(loginUser.getJSONObject("customerInfo").getString("postalcode"));
		checkoutPage.clickcontinueBtn();

		/*
		 * String actualString = productPage.getTitle(); String expectedString =
		 * "PRODUCTS";
		 * 
		 * Assert.assertEquals(actualString, expectedString);
		 */

	}

	/*
	 * @Test public String scrollToElementFinish() { return
	 * overview.scrollToFinish();
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 8) public void scrollToElementFinishBtn() {
	 * overview.scrollToFinish(); }
	 */

	@Test(priority = 6)
	public void clickOnFinishBtn() {
		// String text=overview.scrollToFinish();
		overview.scrollToElementFinishAndClick();
		;
	}

	@Test(priority = 7)
	public void successfulShopping() {

		String actualString = success.getSuccessTxt();
		String expectedString = "THANK YOU FOR YOU ORDER";

		Assert.assertEquals(actualString, expectedString);

	}

}
