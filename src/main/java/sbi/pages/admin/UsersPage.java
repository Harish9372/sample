package com.qa.sbi.pages.admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;
import com.qa.sbi.util.ConfigReader;

import java.util.List;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class UsersPage extends BasePage {
    public UsersPage(Page page) {
        super(page);
        loadProperties("admin","UsersPage");
    }

    public void clickOnCreateUserIcon() {
        click(getLocator("create_user"));
    }

    public void enterUserName(String username) {
        inputData(getLocator("admin_create_user_username"), username);
    }

    public void enterFirstname(String firstname) {
        inputData(getLocator("admin_create_user_firstname"), firstname);
    }

    public void enterLastname(String lastname) {
        inputData(getLocator("admin_create_user_lastname"), lastname);
    }

    public void clickOnLetMeCreatePwd() {
        click(getLocator("admin_create_user_password"));
    }

    public void enterEmail(String email) {
        inputData(getLocator("admin_create_user_email"), email);
    }

    public void enterPwd(String pass) {
        inputData(getLocator("admin_enter_password"), pass);
    }

    public void clickOnSaveAndNext() {
        click(getLocator("save_and_next"));
    }

    public void clickSaveButton() {
        click(getLocator("Save_button"));
    }

    public void clickOnSelectButton(){
        click(getLocator("Select_button"));
    }
    public void clickOnOK(){
        click(getLocator("click_OK"));
    }

    public void clickOnAdminDeveloperAccessToggle() {
        click(getLocator("admin_developer_access_toggle"));
    }

    public void clickOnReadOnlyAccessTongle(){
        click(getLocator("ReadOnly_Tap"));
    }

    public void clickOnAdminCheckBox(){
        click(getLocator(("admin_checkbox")));
    }
    public void unCheckedDeveloperCheck() {
        uncheckCheckbox(getLocator("developer_Uncheck"));
    }
    public void clickOnExcludePermissions(){
        click(getLocator("Exclude_permission"));
    }
    public void clickOnExcludeAdminOrDeveloperPermissionsTableForDomains(){
        click(getLocator("Domains_ExcludePermission"));
    }
    public void clickOnCreateDomainCheckBox() {
           click(getLocator("create_domain_checkBox"));

    }
    public void ClickOnMore(){
        click(getLocator("More_connector"));
    }
    public void ClickOnShare(){

        click(getLocator("Share_Connector"));
    }
    public void SearchforUser(String userName){
        inputData(getLocator("Available_User_SearchBox"), userName);
    }
    public void ShareConnector(){
        click(getLocator("Connector_Share_Btn"));
    }
    public void SelectFirstCheckBox(){
        click(getLocator("select_first_check_box"));
    }
    public void AddAvailableUser(){
        click(getLocator("Add_Available_User"));
    }
    public void AddUser(){
        click(getLocator("Share_Add_User"));
    }
    //Connectors page
    public void clickOnConnectorsTab() {
        click(getLocator("Connectors_Tab"));
    }public void clickOnConnector() {
        click(getLocator("Connector"));
    }
    public void clickOnMore(){
        click(getLocator("More_connector"));
    }
    public void clickOnShare(){
        click(getLocator("Share_Connector"));
    }
    public void addUser(){
        click(getLocator("Share_Add_User"));
    }

    public void selectFirstCheckBox(){
        click(getLocator("select_first_check_box"));
    }

    public void shareConnector(){
        click(getLocator("Connector_Share_Btn"));
    }
    public void searchForConnector(String connector) {
        inputData(getLocator("search_inputbox"), connector);
    }
    public void enterConnectionName(String connector) {
        inputData(getLocator("connector_SearchBox"), connector);
    }

    public void searchForUser(String userName){
        inputData(getLocator("Available_User_SearchBox"), userName);
    }

    public void addAvailableUser(){
        click(getLocator("Add_Available_User"));
    }
    public void deleteExistingUsers() {
        click(getLocator("select_all_checkboxes"));
        System.out.println("All checkboxes selected.");
        click(getLocator("delete"));
        System.out.println("Clicked on the Delete button.");
        click(getLocator("delete_confirmation_button"));
        System.out.println("Clicked on the Okay button.");
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
    public boolean loginWithAnotherUser(String username, String password) {
        try {
            inputData(getLocator("login_username"), username);
            inputData(getLocator("login_password"), password);
            click(getLocator("Sign_In"));

            // Verify if "Home" text is visible after login
            if (isTextVisible("Home")) {
                System.out.println("✅ Successfully logged in with user: " + username);
                return true;
            } else {
                System.out.println("❌ Login failed for user: " + username + " (Home text not found)");
                return false;
            }
        } catch (Exception e) {
            System.out.println("❌ Login failed for user: " + username + " due to an error: " + e.getMessage());
            return false;
        }
    }

    public void resetPasswordForUser(String username, String newPassword) {
        try {
            inputData(getLocator("Create_password"), newPassword);
            inputData(getLocator("Confirm_Password"), newPassword);
            click(getLocator("Reset_Submit"));
            click(getLocator("Login_Btn"));

        } catch (Exception e) {
            throw new RuntimeException("Password reset failed for user: " + username, e);
        }
    }


    public void clickOnAddUserGroupsButtonInUserUnderUserGroupsTab() {
        click(getLocator("Add_Usergroup"));
    }

    public void clickOnUserGroupCheckBoxInAvailableUserGroupInUserUnderUserGroupsTab() {
        click(getLocator("selectCheckbox_AvailableUserGroup"));
    }

    public void clickOnselectButtonInAvailableUserGroupInUserUnderUserGroupsTab() {
        click(getLocator("selectButton_AvaialbleUserGroup"));
    }

    public void EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(String UserGroupName){
        inputData(getLocator("SearchIn_AvailableUserGroup"),UserGroupName);
    }

}
