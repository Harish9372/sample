package com.qa.sbi.pages;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;
import com.qa.sbi.util.ConfigReader;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class LoginPage extends BasePage {

	public LoginPage(Page page) {
		super(page);
		loadProperties("home","LoginPage");
	}

	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App Credentials: " + appUserName + ":" + appPassword);
		inputData(getLocator("emailId"), appUserName);
		inputData(getLocator("password"), appPassword);
		click(getLocator("loginBtn"));
		click(getLocator("Home_tab"));
		if(isElementVisible(getLocator("homeHeader"))) {
			System.out.println("✅ "+appUserName+" user is logged in successfully.... ");
			return true;
		}else {
			System.out.println("❌ user is not logged in....");
			return false;
		}
	}
}
