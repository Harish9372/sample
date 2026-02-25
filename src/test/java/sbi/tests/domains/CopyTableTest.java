package com.qa.sbi.tests.domains;

import com.qa.sbi.base.BaseTest;
import com.qa.sbi.util.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CopyTableTest extends BaseTest {

    //Copy Table
    @Test(dataProvider = "TC_DOM_CT_01")
    public void TC_DOM_CT_01(Hashtable<String, String> data) throws InterruptedException, IOException {
        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName = data.get("UserName") + randomStringGenerator(6);
        String password = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password);
        userPage.clickOnSaveAndNext();
        Thread.sleep(3000);
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("CopyTableUserName", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName(data.get("DatabaseConc"));
        userPage.hoverOverElementByText(data.get("DatabaseConc"));
        userPage.ClickOnMore();
        userPage.ClickOnShare();
        Thread.sleep(3000);
        userPage.deleteExistingUsers();
        userPage.AddUser();
        Thread.sleep(5000);
        userPage.SearchforUser(userName);
        Thread.sleep(5000);
        userPage.SelectFirstCheckBox();
        Thread.sleep(5000);
        userPage.AddAvailableUser();
        Thread.sleep(5000);
        userPage.ShareConnector();
        userPage.switchToParentWindow();
        userPage.logout();
        userPage.loginWithAnotherUser(userName, password);
        userPage.resetPasswordForUser(userName, data.get("NewPassword"));
        userPage.loginWithAnotherUser(userName, data.get("NewPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("TableCopyDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableCopyOption());
    }
    @DataProvider(name = "TC_DOM_CT_01")
    public Object[][] TC_DOM_CT_01() {
        return getTestData("domain", "CopyTableTest", "TC_DOM_CT_01");
    }

    @Test(dataProvider = "TC_DOM_CT_01")
    public void TC_DOM_CT_02(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(ConfigReader.getData("CopyTableUserName"));
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(ConfigReader.getData("CopyTableUserName"));
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickCopyCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();

        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("CopyTableUserName"), data.get("NewPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableCopyOption());
    }

    @Test(dataProvider = "TC_DOM_CT_03")
    public void TC_DOM_CT_03(Hashtable<String, String> data) throws InterruptedException, IOException {
        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName = data.get("UserName") + randomStringGenerator(6);
        String password = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickOnAddUserGroupsButtonInUserUnderUserGroupsTab();
        userPage.EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(data.get("UserGroupName"));
        Thread.sleep(2000);
        userPage.clickOnUserGroupCheckBoxInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickOnselectButtonInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickSaveButton();
        userPage.switchToParentWindow();
        homePage.clickOnWorkspace();

        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickUserGroupsTabInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName"));
        domainEditPage.clickCopyCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();

        userPage.logout();
        userPage.loginWithAnotherUser(userName, password);
        userPage.resetPasswordForUser(userName, data.get("NewPassword"));
        userPage.loginWithAnotherUser(userName, data.get("NewPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableCopyOption());
    }
    @DataProvider(name = "TC_DOM_CT_03")
    public Object[][] TC_DOM_CT_03() {
        return getTestData("domain", "CopyTableTest", "TC_DOM_CT_03");
    }

    @Test(dataProvider = "TC_DOM_CT_01")
    public void TC_DOM_CT_04(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(ConfigReader.getData("CopyTableUserName"));
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(ConfigReader.getData("CopyTableUserName"));
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();

        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("CopyTableUserName"), data.get("NewPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableCopyOptionDisabled());
    }

    @Test(dataProvider = "TC_DOM_CT_03")
    public void TC_DOM_CT_05(Hashtable<String, String> data) throws InterruptedException, IOException {
        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName = data.get("UserName") + randomStringGenerator(6);
        String password = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickOnAddUserGroupsButtonInUserUnderUserGroupsTab();
        userPage.EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(data.get("UserGroupName"));
        Thread.sleep(2000);
        userPage.clickOnUserGroupCheckBoxInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickOnselectButtonInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickSaveButton();
        userPage.switchToParentWindow();
        homePage.clickOnWorkspace();

        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickUserGroupsTabInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName"));
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();

        userPage.logout();
        userPage.loginWithAnotherUser(userName, password);
        userPage.resetPasswordForUser(userName, data.get("NewPassword"));
        userPage.loginWithAnotherUser(userName, data.get("NewPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableCopyOptionDisabled());
    }

    @Test(dataProvider = "TC_DOM_CT_06")
    public void TC_DOM_CT_06(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(ConfigReader.getData("TableCopyDomain"));
        workSpacePage.hoverOverSearchedItemInWorkspace(ConfigReader.getData("TableCopyDomain"));
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domCreatePage.clickTableMoreOptionCopy();
        domCreatePage.clearNewTableNameInCopy();
        domCreatePage.verifyCopyTableNameValidation(data.get("ValidationMessage"));
    }

    @DataProvider(name = "TC_DOM_CT_06")
    public Object[][] TC_DOM_CT_06() {
        return getTestData("domain", "CopyTableTest", "TC_DOM_CT_06");
    }

}
