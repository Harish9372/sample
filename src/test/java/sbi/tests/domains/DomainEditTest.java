package com.qa.sbi.tests.domains;

import com.qa.sbi.base.BaseTest;
import com.qa.sbi.util.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Hashtable;
import static org.testng.Assert.*;

public class DomainEditTest extends BaseTest {

    String domName1 = "AutoDomain" + "_" + randomStringGenerator(6);
    String domName2 = "AutoDomain" + "_" + randomStringGenerator(6);
    String folderName="folder_"+randomStringGenerator(6);
    @Test(dataProvider = "TC_DOM_EditDomain_001", priority = 0)
    public void TC_DOM_EditDomain_002(Hashtable<String, String> data) throws InterruptedException {
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(domName1);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        homePage.clickOnWorkspace();
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        domCreatePage.enterDomainNameInDomainCreate(domName2);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName1);
        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName1));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName1);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        domainEditPage.inputDomainNameInputInDetails(domName2);
        domainEditPage.inputDomainCodeInputInDetails(domName2);
        domainEditPage.clickOnUpdateInDomainDetails();
        domCreatePage.verifyToastMsg(data.get("DomainUpdatedToast"));
    }

    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 1)
    public void TC_DOM_EditDomain_001(Hashtable<String, String> data) throws  InterruptedException {
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName2));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        domainEditPage.clearDomainNameInputInDetails();
        domainEditPage.clearDomainCodeInputInDetails();
        domainEditPage.clickOnUpdateInDomainDetails();
        assertTrue(domainEditPage.verifyDomainNameInputValidation());
        assertTrue(domainEditPage.verifyDomainCodeInputValidation());
        domainEditPage.clickOnCloseBtn();

    }

    @DataProvider(name = "TC_DOM_EditDomain_001")
    public Object[][] TC_DOM_EditDomain_001() {
        return getTestData("domain", "DomainEdit", "TC_DOM_EditDomain_001");
    }

    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 2)
    public void TC_DOM_EditDomain_003(Hashtable<String, String> data) throws  InterruptedException {
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName2));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        domainEditPage.inputDomainNameInputInDetails(randomStringGenerator(256));
        domainEditPage.clickOnUpdateInDomainDetails();
        domCreatePage.verifyToastMsg(data.get("DomainUpdatedToast"));
    }

    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 3)
    public void TC_DOM_EditDomain_005(Hashtable<String, String> data) throws  InterruptedException {
        adminPage = homePage.navigateToAdminPage();
        setupPage= adminPage.clickOnSetupIcon();
        setupPage.clickOnBusinessApp();
        int count= setupPage.getBusinessAppListSize();
        userPage.closeCurrentWindowAndSwitchToParent();
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        assertEquals(domainEditPage.getBusinessAppDropdownValuesSize(),count);
        domainEditPage.clickOnCloseBtn();
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 4)
    public void TC_DOM_EditDomain_006(Hashtable<String, String> data) throws  InterruptedException {
        adminPage = homePage.navigateToAdminPage();
        setupPage= adminPage.clickOnSetupIcon();
        setupPage.clickOnFolders();
        setupPage.enterValueInSearchInFolders("Splash Administrator");
        int count = setupPage.getFoldersListSize();
        userPage.closeCurrentWindowAndSwitchToParent();
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        domainEditPage.selectBusinessApplication("Splash Administrator");
        assertEquals(domainEditPage.getFoldersDropdownValuesSize(),count);
        domainEditPage.clickOnCloseBtn();
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 5)
    public void TC_DOM_EditDomain_007(Hashtable<String, String> data) throws  InterruptedException {
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        domainEditPage.selectBusinessApplication("Splash Administrator");
        domainEditPage.clickCreateFolderBtn();
        domainEditPage.clickOnFolderSaveIcon();
        domCreatePage.verifyToastMsg("Folder Name Cannot be Empty");
        domainEditPage.inputFolderNameInputForNew(folderName);
        domainEditPage.clickOnFolderSaveIcon();
        domainEditPage.clickOnCloseBtn();
        adminPage = homePage.navigateToAdminPage();
        setupPage= adminPage.clickOnSetupIcon();
        setupPage.clickOnFolders();
        setupPage.enterValueInSearchInFolders(folderName);
        assertTrue(setupPage.verifySearchedFolder(folderName));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 6)
    public void TC_DOM_EditDomain_008(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        String folderName="folder_4jut2c";
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        domainEditPage.selectBusinessApplication("Splash Administrator");
        domainEditPage.selectFolder(folderName);
        domainEditPage.clickOnCreateSubFolderBtn();
        domainEditPage.clickOnFolderSaveIcon();
        domCreatePage.verifyToastMsg("Folder Name Cannot be Empty");
        String subFolder="SubFolder_"+randomStringGenerator(6);
        domainEditPage.inputFolderNameInputForNew(subFolder);
        domainEditPage.clickOnFolderSaveIcon();
        domainEditPage.clickOnCloseBtn();
        adminPage = homePage.navigateToAdminPage();
        setupPage= adminPage.clickOnSetupIcon();
        setupPage.clickOnFolders();
        setupPage.enterValueInSearchInFolders(folderName);
        setupPage.clickOnArrowIconForSubFolder();
        assertTrue(setupPage.verifySubFolderIsDisplayed(subFolder));
    }

    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 7)
    public void TC_DOM_EditDomain_009(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        String connName=domainEditPage.getDatabaseConnectorText();
        String bAppName=domainEditPage.getBusinessAppText();
        domainEditPage.selectDatabaseConn("splash_demos");
        domainEditPage.selectBusinessApplication("Splash Administrator");
        domainEditPage.clickOnCloseBtn();
        domCreatePage.clickOnDomainDetailsIcon();
        assertTrue(domainEditPage.verifyDatabaseConnectorText(connName));
        assertTrue(domainEditPage.verifyBusinessAppText(bAppName));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 8)
    public void TC_DOM_EditDomain_010(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnDomainDetailsIcon();
        String conn=domainEditPage.selectRandomDatabaseConn();
        domainEditPage.clickOnUpdateInDomainDetails();
        domCreatePage.verifyToastMsg(data.get("DomainUpdatedToast"));
        assertTrue(conn.equalsIgnoreCase(domCreatePage.getDbConnNameInConnectToDataTab()));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 9)
    public void TC_DOM_EditDomain_011(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace(domName2);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        String schema1=domCreatePage.getSchemaNameInConnectToDataTab();
        domCreatePage.selectRandomDbConnNameInConnectToDataTab();
        assertFalse(schema1.equalsIgnoreCase(domCreatePage.getSchemaNameInConnectToDataTab()));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 10)
    public void TC_DOM_EditDomain_012(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
       // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__7ioe78");
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Materialized Views");
        domCreatePage.searchwithDataTable("CSD");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("Materialized View".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Synonyms");
        domCreatePage.searchwithDataTable("xx");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("Synonym".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Tables");
        domCreatePage.searchwithDataTable("xx");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("Table".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Views");
        domCreatePage.searchwithDataTable("xx");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        assertTrue("View".equalsIgnoreCase(domCreatePage.getDbObjectTypeToolTip()));
    }

    //need to update the verification
    @Test(dataProvider = "TC_DOM_EditDomain_013",priority = 11)
    public void TC_DOM_EditDomain_013(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__7ioe78");
        workSpacePage.hoverOverSearchedItemInWorkspace(domName2);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Materialized Views");
        domCreatePage.searchwithDataTable(data.get("MaterializedView"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("MaterializedView"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Synonyms");
        domCreatePage.searchwithDataTable(data.get("Synonym"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("Synonym"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Tables");
        domCreatePage.searchwithDataTable(data.get("Table"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("Table"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Views");
        domCreatePage.searchwithDataTable(data.get("View"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("View"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.searchwithTableName(data.get("MaterializedView"));
        domCreatePage.searchwithTableName(data.get("Synonym"));
        domCreatePage.searchwithTableName(data.get("Table"));
        domCreatePage.searchwithTableName(data.get("View"));
    }
    @DataProvider(name = "TC_DOM_EditDomain_013")
    public Object[][] TC_DOM_EditDomain_013() {
        return getTestData("domain", "DomainEdit", "TC_DOM_EditDomain_013");
    }

    @Test(dataProvider = "TC_DOM_EditDomain_013",priority = 12)
    public void TC_DOM_EditDomain_014(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("EBS_Domain_uMIme_automation");
        workSpacePage.hoverOverSearchedItemInWorkspace("EBS_Domain_uMIme_automation");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnERDViewIcon();
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Materialized Views");
        domCreatePage.searchwithDataTable(data.get("MaterializedView"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("MaterializedView"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Synonyms");
        domCreatePage.searchwithDataTable(data.get("Synonym"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("Synonym"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Tables");
        domCreatePage.searchwithDataTable(data.get("Table"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("Table"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnTableClearButton();
        domCreatePage.selectObjectType("Views");
        domCreatePage.searchwithDataTable(data.get("View"));
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.dragAndDropTableInDomain(data.get("View"));
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 13)
    public void TC_DOM_EditDomain_015(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        //String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.selectDbConnNameInConnectToDataTab("splash_demos");
        domCreatePage.searchwithDataTable("MS_SALES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverOnTableInDatabaseObjectsPane("MS_SALES");
        domCreatePage.clickOnPreviewDataIconOfTableInDbObjects();
       // assertTrue(domCreatePage.verifyPreviewDataIsDisplayed("MS_SALES"));
        domCreatePage.clickOnCloseIconInPreviewDataPopup();
        domCreatePage.selectDbConnNameInConnectToDataTab("Oracle EBS");
        domCreatePage.searchwithDataTable("XXA99_SPLASH_SECURITY_ROLES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverOnTableInDatabaseObjectsPane("XXA99_SPLASH_SECURITY_ROLES");
        domCreatePage.clickOnPreviewDataIconOfTableInDbObjects();
       // assertFalse(domCreatePage.verifyPreviewDataIsDisplayed("XXA99_SPLASH_SECURITY_ROLES"));
        domCreatePage.clickOnCloseIconInPreviewDataPopup();
        domCreatePage.selectDbConnNameInConnectToDataTab("Oracle Cloud Applications");
        domCreatePage.selectschema("FUSION");
        domCreatePage.searchwithDataTable("fnd_user_preferences");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverOnTableInDatabaseObjectsPane("fnd_user_preferences");
        domCreatePage.clickOnPreviewDataIconOfTableInDbObjects();
      //  assertFalse(domCreatePage.verifyPreviewDataIsDisplayed("fnd_user_preferences"));
        domCreatePage.clickOnCloseIconInPreviewDataPopup();
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 14)
    public void TC_DOM_EditDomain_016(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        //String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1tpvpj");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1tpvpj");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.selectDbConnNameInConnectToDataTab("splash_demos");
        domCreatePage.searchwithDataTable("MS_SALES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverOnTableInDatabaseObjectsPane("MS_SALES");
        domCreatePage.clickOnPreviewDataIconOfTableInDbObjects();
        domCreatePage.enterTextInSearchInPreviewDataPopup("");
        domCreatePage.clickOnCloseIconInPreviewDataPopup();
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 15)
    public void TC_DOM_EditDomain_017(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        //String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.selectDbConnNameInConnectToDataTab("splash_demos");
        domCreatePage.searchwithDataTable("MS_SALES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverOnTableInDatabaseObjectsPane("MS_SALES");
        domCreatePage.clickOnPreviewDataIconOfTableInDbObjects();
        String currentPageNumber;
        String totalPageNumber=domCreatePage.getTotalPageNumberInPreviewDataPopup("MS_SALES");
        domCreatePage.clickOnLastPageIconInPreviewDataPopup("MS_SALES");
        currentPageNumber=domCreatePage.getCurrentPageNumberInPreviewDataPopup("MS_SALES");
        assertEquals(currentPageNumber,totalPageNumber);
        domCreatePage.clickOnFirstPageIconInPreviewDataPopup("MS_SALES");
        currentPageNumber=domCreatePage.getCurrentPageNumberInPreviewDataPopup("MS_SALES");
        assertEquals(currentPageNumber,"1");
        domCreatePage.clickOnNextPageIconInPreviewDataPopup("MS_SALES");
        currentPageNumber=domCreatePage.getCurrentPageNumberInPreviewDataPopup("MS_SALES");
        assertEquals(currentPageNumber,"2");
        domCreatePage.clickOnPreviousPageIconInPreviewDataPopup("MS_SALES");
        currentPageNumber=domCreatePage.getCurrentPageNumberInPreviewDataPopup("MS_SALES");
        assertEquals(currentPageNumber,"1");
        domCreatePage.clickOnCloseIconInPreviewDataPopup();
    }
    @Test(dataProvider = "TC_DOM_EditDomain_001",priority = 16)
    public void TC_DOM_EditDomain_018(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.selectDbConnNameInConnectToDataTab("splash_demos");
        domCreatePage.searchwithDataTable("MS_SALES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.hoverSearchedDbObject();
        //assertTrue("MS_SALES".equalsIgnoreCase(domCreatePage.getSourceTableToolTip()));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_013",priority = 17)
    public void TC_DOM_EditDomain_020(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.selectDbConnNameInConnectToDataTab("splash_demos");
        domCreatePage.searchwithDataTable("MS_SALES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.clickOnTableInDatabaseObjectsPane("MS_SALES");
        domCreatePage.clickOnAddBtnInDatabaseObjectsPane();
        domCreatePage.verifyToastMsg("Table added successfully");
        domCreatePage.searchwithTableName("Ms Sales");
        assertTrue(domCreatePage.verifySearchedTableIsDisplayed("Ms Sales"));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_013",priority = 18)
    public void TC_DOM_EditDomain_021(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickOnERDViewIcon();
        domCreatePage.selectDbConnNameInConnectToDataTab("splash_demos");
        domCreatePage.searchwithDataTable("MS_SALES");
        domCreatePage.keyboardInput("Enter");
        domCreatePage.waitForSkeletonLoaderToDisappear();
        domCreatePage.clickOnTableInDatabaseObjectsPane("MS_SALES");
        domCreatePage.clickOnAddBtnInDatabaseObjectsPane();
        domCreatePage.verifyToastMsg("Table added successfully");
        assertTrue(domCreatePage.verifySearchedTableIsDisplayedInErdView("Ms Sales"));
    }
    @Test(dataProvider = "TC_DOM_EditDomain_013",priority = 17)
    public void TC_DOM_EditDomain_022(Hashtable<String, String> data) throws IOException, InterruptedException {
        homePage.clickOnWorkspace();
        // String domName2 = ConfigReader.getData("NonEbsSqlDomain");
        workSpacePage.enterValueInSearchInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.hoverOverSearchedItemInWorkspace("Automation_Ebs__1xq4zi");
        workSpacePage.clickOnDomainEdit();
        domCreatePage.selectDbConnNameInConnectToDataTab("Oracle EBS");
        assertTrue(domCreatePage.verifyTooManyTablesInConnectToDataPane());
        domCreatePage.selectDbConnNameInConnectToDataTab("Oracle Cloud Applications");
        domCreatePage.selectschema("FUSION");
        assertTrue(domCreatePage.verifyTooManyTablesInConnectToDataPane());
    }
}

