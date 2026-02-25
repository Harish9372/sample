package com.qa.sbi.pages.admin;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;
import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class AdminPage extends BasePage {

     public AdminPage(Page page) {
        super(page);
        loadProperties("admin","AdminPage");
    }


    public UsersPage clickOnUsersIcon() {
        click(getLocator("Users_Icon"));
        return new UsersPage(page);
    }

    public SetupPage clickOnSetupIcon() {
        clickOnElementWithText("Setup");
        return new SetupPage(page);
    }
    public void clickOnsetUpIcon1(){
        click((getLocator("setUp")));
    }
    public void clickOnBusinessApp1(){
        click(getLocator("business_applications"));
    }
    public int getBusinessAppListSize(){
        return getElementsCount(getLocator("business_application_list"));

    }


    public void logout() {
        try {
            click(getLocator("profile_icon"));
            click(getLocator("logout_button"));
            System.out.println("Successfully logged out.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to log out.", e);
        }
    }



}
