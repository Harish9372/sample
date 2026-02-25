package com.qa.sbi.tests.domains;

import com.qa.sbi.base.BaseTest;
import com.qa.sbi.util.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import static org.testng.Assert.*;

public class DomainCreateTest extends BaseTest {


    //========Working=============================//
    //Need New User
    @Test(dataProvider = "TC_DOM_CR_01")
    public void TC_DOM_CR_01(Hashtable<String, String> data) throws IOException, InterruptedException {

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
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("ConnectorUserName", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
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
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName, data.get("newPassword"));
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
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_01")
    public Object[][] TC_DOM_CR_01() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_01");
    }

    //===============Working++++++++++++++++++++++++
    //Need New User
    @Test(dataProvider = "TC_DOM_CR_02")
    public void TC_DOM_CR_02(Hashtable<String, String> data) throws IOException, InterruptedException {

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
        userPage.clickOnAdminCheckBox();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("AdminAccessUser", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
        userPage.clickOnMore();
        userPage.clickOnShare();
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
        loginPage.doLogin(userName, password);
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        loginPage.doLogin(userName, data.get("newPassword"));
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
        ConfigReader.updateTestDataConfig("NonEbsSqlDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_02")
    public Object[][] TC_DOM_CR_02() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_02");
    }


    //===========Working=============================================
    //Need New User
    @Test(dataProvider = "TC_DOM_CR_03")
    public void TC_DOM_CR_03(Hashtable<String, String> data) throws IOException, InterruptedException {

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
        userPage.clickOnExcludePermissions();
        userPage.clickOnExcludeAdminOrDeveloperPermissionsTableForDomains();
        userPage.clickOnCreateDomainCheckBox();
        Thread.sleep(5000);
        userPage.clickOnSelectButton();
        userPage.clickOnOK();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("ExcludeUserName", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
        userPage.clickOnMore();
        userPage.clickOnShare();
        userPage.deleteExistingUsers();
        Thread.sleep(5000);
        userPage.addUser();
        Thread.sleep(5000);
        userPage.searchForUser(userName);
        Thread.sleep(5000);
        userPage.selectFirstCheckBox();
        userPage.addAvailableUser();
        Thread.sleep(5000);
        userPage.shareConnector();
        Thread.sleep(5000);
        userPage.switchToParentWindow();
        userPage.logout();
        loginPage.doLogin(userName, password);
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        loginPage.doLogin(userName, data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_03")
    public Object[][] TC_DOM_CR_03() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_03");
    }
    //=====================Working=======================

    @Test(dataProvider = "TC_DOM_CR_04")
    public void TC_DOM_CR_04(Hashtable<String, String> data) throws IOException, InterruptedException {

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
        userPage.clickOnReadOnlyAccessTongle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("ReadOnlyAccessUserName", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
        userPage.clickOnMore();
        userPage.clickOnShare();
        userPage.deleteExistingUsers();
        Thread.sleep(5000);
        userPage.addUser();
        Thread.sleep(5000);
        userPage.searchForUser(userName);
        Thread.sleep(5000);
        userPage.selectFirstCheckBox();
        userPage.addAvailableUser();
        Thread.sleep(5000);
        userPage.shareConnector();
        Thread.sleep(5000);
        userPage.switchToParentWindow();
        userPage.logout();
        loginPage.doLogin(userName, password);
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        loginPage.doLogin(userName, data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_04")
    public Object[][] TC_DOM_CR_04() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_04");
    }

    //================Working==========================
    @Test(dataProvider = "TC_DOM_CR_05")
    public void TC_DOM_CR_05(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
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
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes1"));
        domCreatePage.searchwithDataTable(data.get("MaterializedTableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("MaterializedTableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes2"));
        domCreatePage.searchwithDataTable(data.get("Synonyms"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("Synonyms"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes3"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes4"));
        domCreatePage.searchwithDataTable(data.get("Views"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("Views"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String domNSqlTableName = data.get("SqlTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(domNSqlTableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(5000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnCSVTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String CsvTable = "CsvTable_" + randomStringGenerator(4);
        domCreatePage.enterCSVInput("CsvTable_" + randomStringGenerator(4));
        domCreatePage.uploadFileWithSelector("file_Upload", "./src/test/resources/testdata/csv_domain_test.csv");
        String SourceTableName = "CsvTable_" + randomStringGenerator(4);
        domCreatePage.enterSourceTable("SourceTableName_" + randomStringGenerator(4));
        domCreatePage.clickOnSaveAndNextCsv();
        domCreatePage.clickOnSaveBtnCsv();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_05")
    public Object[][] TC_DOM_CR_05() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_05");
    }

    //========================Working=====================

    //Sharing Splash Demos Connector
    @Test(dataProvider = "TC_DOM_CR_07")
    public void TC_DOM_CR_07(Hashtable<String, String> data) throws IOException, InterruptedException {

        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        userPage.clickOnConnectorsTab();
        Thread.sleep(3000);
        userPage.enterConnectionName("splash_demos");
        userPage.hoverOverElementByText("splash_demos");
        userPage.ClickOnMore();
        userPage.ClickOnShare();
        userPage.deleteExistingUsers();
        userPage.AddUser();
        Thread.sleep(5000);
        userPage.SearchforUser(ConfigReader.getData("ConnectorUserName"));
        Thread.sleep(5000);
        userPage.SelectFirstCheckBox();
        Thread.sleep(5000);
        userPage.AddAvailableUser();
        Thread.sleep(5000);
        userPage.ShareConnector();
        userPage.switchToParentWindow();
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
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
        ConfigReader.updateTestDataConfig("NonEbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String domNSqlTableName = data.get("SqlTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(domNSqlTableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(5000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnCSVTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        //String CsvTable="CsvTable_"+randomStringGenerator(4);
        domCreatePage.enterCSVInput("CsvTable_" + randomStringGenerator(4));
        domCreatePage.uploadFileWithSelector("file_Upload", "./src/test/resources/testdata/csv_domain_test.csv");
        //String SourceTableName="CsvTable_"+randomStringGenerator(4);
        domCreatePage.enterSourceTable("SourceTableName_" + randomStringGenerator(4));
        domCreatePage.clickOnSaveAndNextCsv();
        domCreatePage.clickOnSaveBtnCsv();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_07")
    public Object[][] TC_DOM_CR_07() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_07");
    }

    //============================Working==========================================
    @Test(dataProvider = "TC_DOM_CR_06")
    public void TC_DOM_CR_06(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        domCreatePage.clickOnSetting();
        domCreatePage.clickOnConnectionInSettings();
        domCreatePage.clickOnAddConnectorButton();
        domCreatePage.clickOnOracleEBS();
        domCreatePage.createOracleConnector(data.get("connectionName"),
                data.get("hostName"),
                data.get("sid"),
                data.get("connectionUser"),
                data.get("connectionPassword"),
                data.get("portNumber"),
                data.get("system"));
        Thread.sleep(5000);
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("connectionName"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("NonEbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String domNSqlTableName = data.get("SqlTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(domNSqlTableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(5000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnCSVTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        //String CsvTable="CsvTable_"+randomStringGenerator(4);
        domCreatePage.enterCSVInput("CsvTable_" + randomStringGenerator(4));
        domCreatePage.uploadFileWithSelector("file_Upload", "./src/test/resources/testdata/csv_domain_test.csv");
        // String SourceTableName="CsvTable_"+randomStringGenerator(4);
        domCreatePage.enterSourceTable("SourceTableName_" + randomStringGenerator(4));
        domCreatePage.clickOnSaveAndNextCsv();
        domCreatePage.clickOnSaveBtnCsv();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_06")
    public Object[][] TC_DOM_CR_06() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_06");
    }
    //================Completed==========================

    //Splash_demos_connector
    @Test(dataProvider = "TC_DOM_CR_08")
    public void TC_DOM_CR_08(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        domCreatePage.clickOnSetting();
        domCreatePage.clickOnConnectionInSettings();
        domCreatePage.clickOnAddConnectorButton();
        domCreatePage.clickOnOracleEBS();
        domCreatePage.createSplashDemosConnector(data.get("connectionName"),
                data.get("hostName"),
                data.get("sid"),
                data.get("connectionUser"),
                data.get("connectionPassword"),
                data.get("portNumber"),
                data.get("system"));
        Thread.sleep(5000);
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("connectionName"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("NonEbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String domNSqlTableName = data.get("SqlTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(domNSqlTableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(5000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnCSVTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        // String CsvTable="CsvTable_"+randomStringGenerator(4);
        domCreatePage.enterCSVInput("CsvTable_" + randomStringGenerator(4));
        domCreatePage.uploadFileWithSelector("file_Upload", "./src/test/resources/testdata/csv_domain_test.csv");
        //String SourceTableName="CsvTable_"+randomStringGenerator(4);
        domCreatePage.enterSourceTable("SourceTableName_" + randomStringGenerator(4));
        domCreatePage.clickOnSaveAndNextCsv();
        domCreatePage.clickOnSaveBtnCsv();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_08")
    public Object[][] TC_DOM_CR_08() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_08");
    }
//=========================Working=================================

    //Cloud connection for MainCreated User
    @Test(dataProvider = "TC_DOM_CR_09")
    public void TC_DOM_CR_09(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        domCreatePage.clickOnSetting();
        domCreatePage.clickOnConnectionInSettings();
        domCreatePage.clickOnAddConnectorButton();
        domCreatePage.clickOnOracleCloud();
        domCreatePage.createOracleCloudConnector(data.get("connectionName"),
                data.get("connectionUser"),
                data.get("connectionPassword"),
                data.get("url"));
        Thread.sleep(5000);
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("connectionName"));
        domCreatePage.clickDatabaseConStatus();
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String domNSqlTableName = data.get("SqlTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(domNSqlTableName);
        domCreatePage.clickOnValidateWithWithRealTime();
        //domCreatePage.verifyValidationToastMsg(data.get("Altermesaage"));
        //domCreatePage.clickOnOccCloseAlert();
        domCreatePage.verifyAndCloseKendoPopup("Query valid against real-time connector");
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(5000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_09")
    public Object[][] TC_DOM_CR_09() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_09");
    }

    //==============================Working===============================================
    @Test(dataProvider = "TC_DOM_CR_10")
    public void TC_DOM_CR_10(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("connectionName"));
        domCreatePage.clickDatabaseConStatus();
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String domNSqlTableName = data.get("SqlTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(domNSqlTableName);
        domCreatePage.clickOnValidateWithWithRealTime();
        domCreatePage.verifyValidationMsg(data.get("Alertmesaage"));
        domCreatePage.clickOnOccCloseAlert();
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(5000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @DataProvider(name = "TC_DOM_CR_10")
    public Object[][] TC_DOM_CR_10() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_10");
    }

    //=========================Working=================================
    @Test(dataProvider = "TC_DOM_CR_11")
    public void TC_DOM_CR_11(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.clickOnSaveInDomainCreate();
        assertTrue(domainEditPage.verifyDomainNameInputValidation());
        assertTrue(domainEditPage.verifyDomainCodeInputValidation());
    }

    @DataProvider(name = "TC_DOM_CR_11")
    public Object[][] TC_DOM_CR_11() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_11");
    }

//============================11 th case verification is in pending=================

    @Test(dataProvider = "TC_DOM_CR_12")
    public void TC_DOM_CR_12(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainName"));
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainName"));
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
    }

    @DataProvider(name = "TC_DOM_CR_12")
    public Object[][] TC_DOM_CR_12() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_12");
    }

    //=========================Working===========================================================
    @Test(dataProvider = "TC_DOM_CR_13")
    public void TC_DOM_CR_13(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(256);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainNameSpl"));
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
    }

    @DataProvider(name = "TC_DOM_CR_13")
    public Object[][] TC_DOM_CR_13() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_13");
    }

    //===============================Working=========================
    @Test(dataProvider = "TC_DOM_CR_14")
    public void TC_DOM_CR_14(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainNameCode"));
        domainEditPage.clearDomainCodeInputInDetails();
        domCreatePage.DomainCodeInputInDetails(data.get("DomainNameCode"));
        Thread.sleep(5000);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
    }

    @DataProvider(name = "TC_DOM_CR_14")
    public Object[][] TC_DOM_CR_14() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_14");
    }

    //===================================Working-14===================================
    @Test(dataProvider = "TC_DOM_CR_15")
    public void TC_DOM_CR_15(Hashtable<String, String> data) throws IOException, InterruptedException {

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
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("ConnectorUserName", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
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
        loginPage.doLogin(userName, password);
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        loginPage.doLogin(userName, data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainNameCode"));
        domainEditPage.clearDomainCodeInputInDetails();
        domCreatePage.DomainCodeInputInDetails(data.get("DomainNameCode"));
        Thread.sleep(5000);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
    }

    @DataProvider(name = "TC_DOM_CR_15")
    public Object[][] TC_DOM_CR_15() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_15");
    }

    //================================Working=======================

    @Test(dataProvider = "TC_DOM_CR_16")
    public void TC_DOM_CR_16(Hashtable<String, String> data) throws IOException, InterruptedException {

        adminPage = homePage.navigateToAdminPage();
        setupPage = adminPage.clickOnSetupIcon();
        setupPage.clickOnBusinessApp();
        int count = setupPage.getBusinessAppListSize();
        userPage.switchToParentWindow();
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
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
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("BusinessAppUserNameUser", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
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
        loginPage.doLogin(userName, password);
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        loginPage.doLogin(userName, data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.clickOnBusinessApplicationRefreshButton();
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        assertEquals(domainEditPage.getBusinessAppDropdownValuesSize(), count);
    }

    @DataProvider(name = "TC_DOM_CR_16")
    public Object[][] TC_DOM_CR_16() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_16");
    }

    //========================Working========================
    @Test(dataProvider = "TC_DOM_CR_17")
    public void TC_DOM_CR_17(Hashtable<String, String> data) throws IOException, InterruptedException {

        adminPage = homePage.navigateToAdminPage();
        setupPage = adminPage.clickOnSetupIcon();
        setupPage.clickOnFolders();
        setupPage.enterValueInSearchInFolders("Splash Samples");
        int count = setupPage.getFoldersListSize();
        userPage.switchToParentWindow();
        userPage.logout();
        loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
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
        userPage.clickSaveButton();
        ConfigReader.updateTestDataConfig("FolderAppUserName", userName);
        System.out.println("✅ User Created: " + userName);
        userPage.clickOnConnectorsTab();
        userPage.enterConnectionName("Oracle EBS");
        userPage.hoverOverElementByText("Oracle EBS");
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
        loginPage.doLogin(userName, password);
        userPage.resetPasswordForUser(userName, data.get("newPassword"));
        loginPage.doLogin(userName, data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        assertEquals(domainEditPage.getFoldersDropdownValuesSize(), count);
    }

    @DataProvider(name = "TC_DOM_CR_17")
    public Object[][] TC_DOM_CR_17() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_17");
    }

    //===================== Working=====================
    @Test(dataProvider = "TC_DOM_CR_18")
    public void TC_DOM_CR_18(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(256);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg("Please select business application folder");
        domainEditPage.clickOnCreateDomainPageCloseBtn();

    }

    @DataProvider(name = "TC_DOM_CR_18")
    public Object[][] TC_DOM_CR_18() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_18");
    }

    //=====================================working=====================
    @Test(dataProvider = "TC_DOM_CR_19")
    public void TC_DOM_CR_19(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(256);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domainEditPage.clickOnCreateSubFolderBtn();
        domainEditPage.clickOnFolderSaveIcon();
        domCreatePage.verifyToastMsg("Folder Name Cannot be Empty");
        String subFolder = "SubFolder_" + randomStringGenerator(6);
        domainEditPage.inputFolderNameInputForNew(subFolder);
        domainEditPage.clickOnFolderSaveIcon();
        setupPage.clickOnFolders1();
        setupPage.enterValueInSearchInFolders(data.get("Folder"));
        setupPage.clickOnFolders1();
        setupPage.clickOnExtendIconForSubFolder();
        domCreatePage.selectFolder2(subFolder);
        //assertTrue(setupPage.verifySubFolderIsDisplayed(subFolder));
    }

    @DataProvider(name = "TC_DOM_CR_19")
    public Object[][] TC_DOM_CR_19() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_19");
    }

    //===============================Working=========================@Test(dataProvider = "TC_DOM_CR_19")
    @Test(dataProvider = "TC_DOM_CR_20")
    public void TC_DOM_CR_20(Hashtable<String, String> data) throws IOException, InterruptedException {

        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainName"));
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domainEditPage.clickOnCreateDomainPageCloseBtn();
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(data.get("DomainName"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(data.get("DomainName"));
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domainEditPage.clickOnCreateDomainPageCloseBtn();
        homePage.clickOnWorkspace();
        Thread.sleep(3000);
        workSpacePage.enterValueInSearchInWorkspace(data.get("DomainName"));
        //assertFalse(workSpacePage.verifySearchItemInWorkspace(data.get("DomainName")));;
    }

    @DataProvider(name = "TC_DOM_CR_20")
    public Object[][] TC_DOM_CR_20() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_20");
    }
    //===============================Working=========================

    @Test(dataProvider = "TC_DOM_CR_21")
    public void TC_DOM_CR_21(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(256);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        homePage.clickOnWorkspace();
        Thread.sleep(3000);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        //Pending Description Verification
    }

    @DataProvider(name = "TC_DOM_CR_21")
    public Object[][] TC_DOM_CR_21() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_21");
    }

    //==============================Working===========================@Test(dataProvider = "TC_DOM_CR_21")
    @Test(dataProvider = "TC_DOM_CR_22")
    public void TC_DOM_CR_22(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        homePage.clickOnWorkspace();
        Thread.sleep(3000);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        //Pending all Verification
    }

    @DataProvider(name = "TC_DOM_CR_22")
    public Object[][] TC_DOM_CR_22() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_22");
    }

    //===============================Working============================
    @Test(dataProvider = "TC_DOM_CR_23")
    public void TC_DOM_CR_23(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        assertTrue(domCreatePage.verifyConnectorIsDisplayedUnderDataBaseConnection());
        assertTrue(domCreatePage.verifyDatabaseConnectorList());
        domCreatePage.clickDatabaseConDataRefresh();
        assertTrue(domCreatePage.verifyConnectorIsDisplayedUnderDataBaseConnection());
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableNameSearch"));
        domCreatePage.keyboardInput("Enter");
        Thread.sleep(5000);
        domCreatePage.CheckAndDragMultipleTables();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
    }

    @DataProvider(name = "TC_DOM_CR_23")
    public Object[][] TC_DOM_CR_23() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_23");
    }

    //==============================Working===========================  @Test(dataProvider = "TC_DOM_CR_23")
    @Test(dataProvider = "TC_DOM_CR_24")
    public void TC_DOM_CR_24(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        assertTrue(domCreatePage.verifyConnectorIsDisplayedUnderDataBaseConnection());
        assertTrue(domCreatePage.verifyDatabaseConnectorList());
        domCreatePage.clickDatabaseConDataRefresh();
        assertTrue(domCreatePage.verifyConnectorIsDisplayedUnderDataBaseConnection());
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseCon2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName1"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName1"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

    }

    @DataProvider(name = "TC_DOM_CR_24")
    public Object[][] TC_DOM_CR_24() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_24");

        //===============================Working======================
    }

    @Test(dataProvider = "TC_DOM_CR_25")
    public void TC_DOM_CR_25(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        assertTrue(domCreatePage.verifyDatabaseschemalist());
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseCon2"));
        assertTrue(domCreatePage.verifyDatabaseschemalist());
    }

    @DataProvider(name = "TC_DOM_CR_25")
    public Object[][] TC_DOM_CR_25() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_25");
    }

    //==============================Working=========================== @Test(dataProvider = "TC_DOM_CR_25")
    @Test(dataProvider = "TC_DOM_CR_26")
    public void TC_DOM_CR_26(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.VerifyDatabaseObjectTypesList();
        domCreatePage.selectObjectType(data.get("ObjectTypes2"));
        domCreatePage.searchwithDataTable(data.get("Synonyms"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverOnTable(data.get("Synonyms"));
        assertTrue("Synonym".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Views");
        domCreatePage.searchwithDataTable("xx");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("View".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Tables");
        domCreatePage.searchwithDataTable("xx");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("Table".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Materialized Views");
        domCreatePage.searchwithDataTable("CSD");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("Materialized View".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
    }

    @DataProvider(name = "TC_DOM_CR_26")
    public Object[][] TC_DOM_CR_26() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_26");
    }

    //==============================Working===========================@Test(dataProvider = "TC_DOM_CR_26")
    @Test(dataProvider = "TC_DOM_CR_27")
    public void TC_DOM_CR_27(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes3"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.verifyTableTypeByText(data.get("TableName"), data.get("TableType"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes1"));
        domCreatePage.searchwithDataTable(data.get("MaterializedTableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("MaterializedTableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.verifyTableTypeByText(data.get("MaterializedTableName"), data.get("TableType1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes2"));
        domCreatePage.searchwithDataTable(data.get("Synonyms"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("Synonyms"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.verifyTableTypeByText(data.get("Synonyms"), data.get("TableType2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes4"));
        domCreatePage.searchwithDataTable(data.get("Views"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("Views"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.verifyTableTypeByText(data.get("Views"), data.get("TableType3"));
    }

    @DataProvider(name = "TC_DOM_CR_27")
    public Object[][] TC_DOM_CR_27() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_27");
    }

    //==============================Working===========================  @Test(dataProvider = "TC_DOM_CR_27")
    @Test(dataProvider = "TC_DOM_CR_28")
    public void TC_DOM_CR_28(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnERDVIEWButton();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes3"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomainERDView(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes1"));
        domCreatePage.searchwithDataTable(data.get("MaterializedTableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomainERDView(data.get("MaterializedTableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.verifyTableTypeByText(data.get("MaterializedTableName"), data.get("TableType1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes2"));
        domCreatePage.searchwithDataTable(data.get("Synonyms"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomainERDView(data.get("Synonyms"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes4"));
        domCreatePage.searchwithDataTable(data.get("Views"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomainERDView(data.get("Views"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

    }

    @DataProvider(name = "TC_DOM_CR_28")
    public Object[][] TC_DOM_CR_28() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_28");
    }

    //==============================Working===========================
    @Test(dataProvider = "TC_DOM_CR_29")
    public void TC_DOM_CR_29(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName1"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverSearchedDbObject();
        domCreatePage.clickOnPreviewDataButton();
        assertTrue(domCreatePage.verifyDemosTablePreviewData("PRODUCT_KEY"));
        domCreatePage.clickOnClosePreviewPage();
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverSearchedDbObject();
        domCreatePage.clickOnPreviewDataButton();
        assertTrue(domCreatePage.verifyTableOracleEBSPreviewData());
        domCreatePage.clickOnClosePreviewPage();
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc3"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName2"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverSearchedDbObject();
        Thread.sleep(1000);
        domCreatePage.clickOnPreviewDataButton();
        assertTrue(domCreatePage.verifyTableOracleCloudPreviewData());
        domCreatePage.clickOnClosePreviewPage();
    }

    @DataProvider(name = "TC_DOM_CR_29")
    public Object[][] TC_DOM_CR_29() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_29");
    }

    //==============================Working===========================@Test(dataProvider = "TC_DOM_CR_29")
    @Test(dataProvider = "TC_DOM_CR_30")
    public void TC_DOM_CR_30(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName1"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverSearchedDbObject();
        domCreatePage.clickOnPreviewDataButton();
        assertTrue(domCreatePage.verifyDemosTablePreviewData("PRODUCT_KEY"));
        domCreatePage.enterDataInPreviewDataPage(data.get("SourceData"));
        assertTrue(domCreatePage.verifyPreviewData());
    }

    @DataProvider(name = "TC_DOM_CR_30")
    public Object[][] TC_DOM_CR_30() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_30");
    }

    //==============================Working===========================
    @Test(dataProvider = "TC_DOM_CR_31")
    public void TC_DOM_CR_31(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName1"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverSearchedDbObject();
        domCreatePage.clickOnPreviewDataButton();
        assertTrue(domCreatePage.verifyDemosTablePreviewData("PRODUCT_KEY"));
        domCreatePage.navigateAndVerifyTableData();
        domCreatePage.changePageSizeAndVerifyRowCount(20);
        domCreatePage.changePageSizeAndVerifyRowCount(50);
        domCreatePage.changePageSizeAndVerifyRowCount(100);
    }

    @DataProvider(name = "TC_DOM_CR_31")
    public Object[][] TC_DOM_CR_31() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_31");
    }

    //==============================Working===========================@Test(dataProvider = "TC_DOM_CR_31")
    @Test(dataProvider = "TC_DOM_CR_32")
    public void TC_DOM_CR_32(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName1"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.hoverSearchedDbObject();
        domCreatePage.getDbObjectTypeToolTipSourceType();
        domCreatePage.clickOnPreviewDataButton();
        assertTrue(domCreatePage.isHeaderPresent(data.get("TableName1")));
    }

    @DataProvider(name = "TC_DOM_CR_32")
    public Object[][] TC_DOM_CR_32() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_32");
    }
//==============================Working===========================@Test(dataProvider = "TC_DOM_CR_32")

    @Test(dataProvider = "TC_DOM_CR_33")
    public void TC_DOM_CR_33(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        assertTrue((domCreatePage.verifyPaginationInTable()));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName1"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        assertTrue((domCreatePage.verifyPaginationInTable()));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc3"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName2"));
        domCreatePage.keyboardInput("Enter");
        assertTrue((domCreatePage.verifyPaginationInTable()));
    }

    @DataProvider(name = "TC_DOM_CR_33")
    public Object[][] TC_DOM_CR_33() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_33");
    }

    //==============================Working===========================  @Test(dataProvider = "TC_DOM_CR_33")
    @Test(dataProvider = "TC_DOM_CR_34")
    public void TC_DOM_CR_34(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.ClickOnTableCheckbox();
        domCreatePage.ClickOnTableAddInDatabaseObjectTypePage();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName2"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.ClickOnTableCheckbox();
        domCreatePage.ClickOnTableAddInDatabaseObjectTypePage();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc3"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName3"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.selectTableCheckboxes();
        domCreatePage.ClickOnTableAddInDatabaseObjectTypePage();
        Thread.sleep(2000);
        assertTrue(domCreatePage.verifyToastMsg(data.get("TableCreatedToast")));
    }

    @DataProvider(name = "TC_DOM_CR_34")
    public Object[][] TC_DOM_CR_34() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_34");
    }

    //==============================Working===========================@Test(dataProvider = "TC_DOM_CR_34")
    @Test(dataProvider = "TC_DOM_CR_35")
    public void TC_DOM_CR_35(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        loginPage.doLogin(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.clickOnERDVIEWButton();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        domCreatePage.ClickOnTableCheckbox();
        domCreatePage.ClickOnTableAddInDatabaseObjectTypePage();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.clickOnERDVIEWButton();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName2"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.ClickOnTableCheckbox();
        domCreatePage.ClickOnTableAddInDatabaseObjectTypePage();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc3"));
        domCreatePage.clickOnERDVIEWButton();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName3"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.selectTableCheckboxes();
        domCreatePage.ClickOnTableAddInDatabaseObjectTypePage();
        //assertTrue(domCreatePage.verifyToastMsg(data.get("TableCreatedToast")));
    }

    @DataProvider(name = "TC_DOM_CR_35")
    public Object[][] TC_DOM_CR_35() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_35");
    }

    //==============================Working===========================@Test (dataProvider = "TC_DOM_CR_35")
    @Test(dataProvider = "TC_DOM_CR_36")
    public void TC_DOM_CR_36(Hashtable<String, String> data) throws IOException, InterruptedException {

        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        assertEquals(
                domCreatePage.verifyDatabaseConnectorMessage(data.get("DataBaseConnectorMessage")),
                data.get("DataBaseConnectorMessage"),
                "❌ Database Connector validation message did not match for DatabaseConc1!"
        );
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseConc3"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.selectschema(data.get("Schema"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        assertEquals(
                domCreatePage.verifyDatabaseConnectorMessage(data.get("DataBaseConnectorMessage")),
                data.get("DataBaseConnectorMessage"),
                "❌ Database Connector validation message did not match for DatabaseConc3!"
        );
    }

    @DataProvider(name = "TC_DOM_CR_36")
    public Object[][] TC_DOM_CR_36() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_36");
    }
//==============================Working===========================

    @Test(dataProvider = "TC_DOM_CR_37")
    public void TC_DOM_CR_37(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName("Ms Sales");
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domCreatePage.isEditTableButtonEnabled(), "❌ Edit Table button is either not visible or not enabled!");
    }
@DataProvider(name = "TC_DOM_CR_37")
public Object[][] TC_DOM_CR_37() {
    return getTestData("domain", "DomainCreate", "TC_DOM_CR_37");
}

@Test(dataProvider = "TC_DOM_CR_38")
    public void TC_DOM_CR_38(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName("Ms Sales");
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domCreatePage.isExportIconEnabled(), "❌ Edit Export button is either not visible or not enabled!");
    }
@DataProvider(name = "TC_DOM_CR_38")
public Object[][] TC_DOM_CR_38() {
    return getTestData("domain", "DomainCreate", "TC_DOM_CR_38");
}
@Test(dataProvider = "TC_DOM_CR_39")
    public void TC_DOM_CR_39(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName("Ms Sales");
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domCreatePage.isInfoIconEnabled(), "❌ Edit Info button is either not visible or not enabled!");
    }
@DataProvider(name = "TC_DOM_CR_39")
public Object[][] TC_DOM_CR_39() {
    return getTestData("domain", "DomainCreate", "TC_DOM_CR_39");
}
@Test(dataProvider = "TC_DOM_CR_40")
    public void TC_DOM_CR_40(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName("Ms Sales");
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domCreatePage.isMoreOptionEnabled(), "❌ Edit More Option Button is either not visible or not enabled!");
    }
@DataProvider(name = "TC_DOM_CR_40")
public Object[][] TC_DOM_CR_40() {
    return getTestData("domain", "DomainCreate", "TC_DOM_CR_40");
}
@Test(dataProvider = "TC_DOM_CR_41")
    public void TC_DOM_CR_41(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.clickOnERDVIEWButton();
//        assertTrue(domCreatePage.isTableGridViewHasData(), "❌ Table Grid View is NOT visible!");
        domCreatePage.clickOnListViewIcon();
        //assertTrue(domCreatePage.isTableListViewDisplayed(), "❌ Table List View is NOT visible!");
}
@DataProvider(name = "TC_DOM_CR_41")
public Object[][] TC_DOM_CR_41() {
    return getTestData("domain", "DomainCreate", "TC_DOM_CR_41");
}

//=====================================================================
 @Test(dataProvider = "TC_DOM_CR_42")
    public void TC_DOM_CR_42(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName("Ms Sales");
        domCreatePage.clickTableDomainMoreOption();
        assertTrue(domCreatePage.verifyMenuListItems());

    }
    @DataProvider(name = "TC_DOM_CR_42")
    public Object[][] TC_DOM_CR_42() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_42");
    }
    //===========================Working=================
    @Test(dataProvider = "TC_DOM_CR_43")
    public void TC_DOM_CR_43(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnListOfValue();
        assertTrue(domCreatePage.verifyMenuListItemsAll());
    }
    @DataProvider(name = "TC_DOM_CR_43")
    public Object[][] TC_DOM_CR_43() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_43");
    }

    //==========================working====================== @Test(dataProvider = "TC_DOM_CR_43")
    @Test(dataProvider = "TC_DOM_CR_45")
    public void TC_DOM_CR_45(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseCon2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseCon1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName2"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName2"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseCon2"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.hoverTable();
        domCreatePage.clickonTablemenu();
        //domCreatePage.clickOnTableHeader();
        assertTrue(domCreatePage.verifyTableHeaderItemsAll());

    }
    @DataProvider(name = "TC_DOM_CR_45")
    public Object[][] TC_DOM_CR_45() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_45");
    }

    //==========================working======================
    @Test(dataProvider = "TC_DOM_CR_48")
    public void TC_DOM_CR_48(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseCon2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseCon1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        int expectedCount = domCreatePage.verifyAndSelectAllCheckboxesAndAdd();
        Thread.sleep(5000);
        homePage.clickOnWorkspace();
        Thread.sleep(500);
        workSpacePage.enterValueInSearchInWorkspace(ConfigReader.getData("EbsDomain"));
        workSpacePage.hoverOverSearchedItemInWorkspace(ConfigReader.getData("EbsDomain"));
        workSpacePage.clickOnDomainInfo();
        int actualCount = domCreatePage.getDomainInfoTableCount();
        assertEquals(actualCount, expectedCount, "❌ Mismatch between Added Page and Domain Info Page!");
        workSpacePage.clickOnInfoCloseIcon();
        workSpacePage.enterValueInSearchInWorkspace(ConfigReader.getData("EbsDomain"));
        workSpacePage.hoverOverSearchedItemInWorkspace(ConfigReader.getData("EbsDomain"));
        workSpacePage.clickOnDomainEdit();
        domCreatePage.searchwithTableName(data.get("TableName2"));
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domCreatePage.clickTableMoreDelete();
        domCreatePage.clickContinueInTableDeletePopup();
        Thread.sleep(2000);
        homePage.clickOnWorkspace();
        Thread.sleep(500);
        workSpacePage.enterValueInSearchInWorkspace(ConfigReader.getData("EbsDomain"));
        workSpacePage.hoverOverSearchedItemInWorkspace(ConfigReader.getData("EbsDomain"));
        workSpacePage.clickOnDomainInfo();
        domCreatePage.getDomainInfoTableCount();
    }
    @DataProvider(name = "TC_DOM_CR_48")
    public Object[][] TC_DOM_CR_48() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_48");
    }
    //==========================working======================
    @Test(dataProvider = "TC_DOM_CR_49")
    public void TC_DOM_CR_49(Hashtable<String, String> data) throws IOException, InterruptedException {
        userPage.logout();
        userPage.loginWithAnotherUser(ConfigReader.getData("ConnectorUserName"), data.get("newPassword"));
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        String Descrip = data.get("DomainDec") + "_" + randomStringGenerator(6);
        domCreatePage.enterDescInDomainCreate(Descrip);
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseCon2"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsDomain", domName);
        domCreatePage.selectAnotherDatabaseConc(data.get("DatabaseCon1"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName(data.get("TableName1"));
        Thread.sleep(2000);
        assertTrue( domCreatePage.verifySearchedTableIsDisplayed(data.get("TableName1")));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType(data.get("ObjectTypes"));
        domCreatePage.searchwithDataTable(data.get("TableName"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName(data.get("TableName2"));
        Thread.sleep(2000);
        assertTrue( domCreatePage.verifySearchedTableIsDisplayed(data.get("TableName2")));
    }
    @DataProvider(name = "TC_DOM_CR_49")
    public Object[][] TC_DOM_CR_49() {
        return getTestData("domain", "DomainCreate", "TC_DOM_CR_49");
    }
    //==========================working======================




}