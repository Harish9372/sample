package com.qa.sbi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.sbi.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}

}
