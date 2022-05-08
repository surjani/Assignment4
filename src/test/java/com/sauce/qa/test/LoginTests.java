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
import com.saucelab.qa.pages.LoginPage;
import com.saucelab.qa.pages.ProductPage;

public class LoginTests extends BaseTest {

	FileInputStream detail;
	JSONObject loginUser;
	LoginPage loginPage;
	ProductPage productPage;

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
		closeApp();
		launchApp();
		loginPage = new LoginPage();// Initialize the Page
		productPage = new ProductPage();

	}

	@Test()
	public void invalidUserName() {

		loginPage.enterUserName(loginUser.getJSONObject("invalidUser").getString("username"));
		loginPage.enterPassword(loginUser.getJSONObject("invalidUser").getString("password"));
		loginPage.clickLoginBtn();

		String actualString = loginPage.getErrorTxt();
		String expectedString = "Username and Password do not match any user in this service";

		Assert.assertEquals(actualString, expectedString);

	}

	@Test()
	public void invalidPassword() {

		loginPage.enterUserName(loginUser.getJSONObject("invalidPassword").getString("username"));
		loginPage.enterPassword(loginUser.getJSONObject("invalidPassword").getString("password"));
		loginPage.clickLoginBtn();

		String actualString = loginPage.getErrorTxt();
		String expectedString = "Username and Password do not match any user in this service";

		Assert.assertEquals(actualString, expectedString);

	}

	@Test()
	public void successfulLogin() {
		loginPage.enterUserName(loginUser.getJSONObject("validUser").getString("username"));
		loginPage.enterPassword(loginUser.getJSONObject("validUser").getString("password"));
		loginPage.clickLoginBtn();

		String actualString = productPage.getTitle();
		String expectedString = "PRODUCTS";

		Assert.assertEquals(actualString, expectedString);

	}

}
