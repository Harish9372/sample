package com.qa.sbi.tests;

import com.github.javafaker.Faker;
import com.qa.sbi.base.BaseTest;
import com.qa.sbi.util.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Hashtable;
import static java.lang.Integer.parseInt;

public class AdminPageTest extends BaseTest {
    @Test(dataProvider = "createUserTest")
    public void createUserTest(Hashtable<String, String> data) throws IOException {
        adminPage = homePage.navigateToAdminPage();
        adminPage.clickOnUsersIcon();
        for(int i=1;i<=parseInt(data.get("NoOfUsers"));i++){
        String UserName = data.get("UserName")+randomStringGenerator(6);
        String Password = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(UserName);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(Password);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("UserName"+i,UserName);
        //System.out.println("✅ User Created: " + UserName);
        }
    }
    @DataProvider(name = "createUserTest")
    public Object[][] TC_DOM_SQL_TABLE_002() {
        return getTestData("admin","userPage", "createUserTest");
    }

}
