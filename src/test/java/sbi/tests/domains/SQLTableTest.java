package com.qa.sbi.tests.domains;

import com.qa.sbi.base.BaseTest;
import com.qa.sbi.pages.domain.TableEditPage;
import com.qa.sbi.util.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Hashtable;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SQLTableTest extends BaseTest {

    //Mysql SQL Table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_001")
    public void TC_DOM_SQL_TABLE_001(Hashtable<String, String> data) throws InterruptedException, IOException {
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
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        //  assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));

    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_001")
    public Object[][] TC_DOM_SQL_TABLE_001() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_001");
    }

    //OracleEBS sql table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_002")
    public void TC_DOM_SQL_TABLE_002(Hashtable<String, String> data) throws InterruptedException, IOException {
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
        domCreatePage.verifyToastMsg(data.get("DomainCreateToast"));
        ConfigReader.updateTestDataConfig("EbsSqlDomain", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        // assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_002")
    public Object[][] TC_DOM_SQL_TABLE_002() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_002");
    }

    //OCC sql table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_003")
    public void TC_DOM_SQL_TABLE_003(Hashtable<String, String> data) throws InterruptedException, IOException {
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
        domCreatePage.verifyToastMsg(data.get("DomainCreateToast"));
        ConfigReader.updateTestDataConfig("OCCSqlDomain", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateWithRealTimeandDW();
        domCreatePage.verifyValidationMsg(data.get("Alertmesaage"));
        domCreatePage.clickOnOccCloseAlert();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        Thread.sleep(3000);
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
//        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));

    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_003")
    public Object[][] TC_DOM_SQL_TABLE_003() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_003");
    }

    //Update mysql sql table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_001")
    public void TC_DOM_SQL_TABLE_004(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("NonEbsSqlDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
       // assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickSQLeditorInTableEdit();
        domCreatePage.enterSqlQueryInTableEdit(data.get("UpdatedQuery"));
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(2000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.clickSQLeditorAddcolumnSelectAll();
        domCreatePage.clickSQLeditorDeletecolumnSelectAll();
        domCreatePage.clickSyncInSqlEditor();
        domCreatePage.verifyToastMsg(data.get("TableSyncToast"));
        Thread.sleep(2000);
        domCreatePage.clickTableEditSave();
        domCreatePage.clickTableEditColumnsTab();
        Thread.sleep(2000);
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName1"));
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName2"));

    }

    //Update Oracle sql table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_002")
    public void TC_DOM_SQL_TABLE_005(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("EbsSqlDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickSQLeditorInTableEdit();
        domCreatePage.enterSqlQueryInTableEdit(data.get("UpdatedQuery"));
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        Thread.sleep(2000);
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.clickSQLeditorAddcolumnSelectAll();
        domCreatePage.clickSQLeditorDeletecolumnSelectAll();
        domCreatePage.clickSyncInSqlEditor();
        domCreatePage.verifyToastMsg(data.get("TableSyncToast"));
        Thread.sleep(2000);
        domCreatePage.clickTableEditSave();
        domCreatePage.clickTableEditColumnsTab();
        Thread.sleep(2000);
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName1"));
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName2"));

    }

    //Update OCC sql table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_003")
    public void TC_DOM_SQL_TABLE_006(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("OCCSqlDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
//        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickSQLeditorInTableEdit();
        domCreatePage.enterSqlQueryInTableEdit(data.get("UpdatedQuery"));
        domCreatePage.clickOnValidateWithRealTimeandDW();
        domCreatePage.verifyValidationMsg(data.get("Alertmesaage"));
        domCreatePage.clickOnOccCloseAlert();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        Thread.sleep(5000);
        domCreatePage.clickSQLeditorAddcolumnSelectAll();
        domCreatePage.clickSQLeditorDeletecolumnSelectAll();
        domCreatePage.clickSyncInSqlEditor();
        domCreatePage.verifyToastMsg(data.get("TableSyncToast"));
        Thread.sleep(2000);
        domCreatePage.clickTableEditSave();
        domCreatePage.clickTableEditColumnsTab();
        Thread.sleep(2000);
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName1"));
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName2"));

    }
    //SQL Table calc column
    @Test(dataProvider = "TC_DOM_SQL_TABLE_007")
    public void TC_DOM_SQL_TABLE_007(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("To Verify SQL Table columnProperties");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("NonEbsSqlAutoDomainColProp", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickTableEditColumnsTab();
        domCreatePage.clickAddColumnInTableEditColumnsTab();
        domCreatePage.EnterCalColumnName(data.get("CalculationColumnName"));
        domCreatePage.dragColumnToFormulaInCalCol(data.get("ColumnName1"));
        domCreatePage.clickCalColumnOperatorPlus();
        domCreatePage.dragColumnToFormulaInCalCol(data.get("ColumnName2"));
        domCreatePage.clickCalcColumnSave();
        Thread.sleep(5000);
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("CalculationColumnName"));
        domCreatePage.clickTableEditDataTab();
        Thread.sleep(5000);
        domCreatePage.verifyColumnNameInTableDataTab(data.get("CalculationColumnName"));

    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_007")
    public Object[][] TC_DOM_SQL_TABLE_007() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_007");
    }

    //SQL Drill table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_008")
    public void TC_DOM_SQL_TABLE_008(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("To Verify SQL Table drill");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("NonEbsSqlAutoDomaindrill", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickTableEditDrillToggle();
        domCreatePage.clickTableEditDrillLayoutTab();
        domCreatePage.dragColumnToDrillFilters(data.get("DrillFiterColumn1"));
        domCreatePage.clickTableEditDrillLayoutInDrillLayoutTab();
        domCreatePage.dragColumnToDrillLayout(data.get("LayoutColumn1"));
        domCreatePage.dragColumnToDrillLayout(data.get("LayoutColumn2"));
        domCreatePage.EnterDrillLayoutHeader(data.get("LayoutHeader"));
        domCreatePage.clickTableEditSaveInDrillLayoutTab();
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ReportColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickDrilldownIcon();
        reportCreatePage.clickDrillCreateIcon();
        reportCreatePage.selectDrillDownColumnFromDropDown(data.get("ReportColumnName"));
        reportCreatePage.clickDrillOrDrillSetSelectLovIcon();
        reportCreatePage.clickDrillOrDrillSetNameRadioButton();
        reportCreatePage.clickDrillOrDrillSetSelectPageOK();
        reportCreatePage.clickDrillMappingsIcon();
        reportCreatePage.clickDrillMappingsReportColumnSearch();
        reportCreatePage.dragReportColumnToFormulaInDrillpage(data.get("ReportColumnName"));
        reportCreatePage.clickDrillMappingsFormulaSave();
        reportCreatePage.clickDrillMappingsDrillTableColumnSearch();
        reportCreatePage.dragReportColumnToFormulaInDrillpage(data.get("ReportColumnName"));
        reportCreatePage.clickDrillMappingsFormulaSave();
        reportCreatePage.clickDrillPageSave();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
        reportCreatePage.clickReportOutput();
        reportCreatePage=reportCreatePage.switchtoHTMLtab();
        reportCreatePage.verifyReportHTMLheaderText(reportName);

    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_008")
    public Object[][] TC_DOM_SQL_TABLE_008() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_008");
    }

    //Copy SQL table
    @Test(dataProvider = "TC_DOM_SQL_TABLE_008")
    public void TC_DOM_SQL_TABLE_009(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("NonEbsSqlAutoDomaindrill");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domCreatePage.clickTableMoreOptionCopy();
        String copiedTable = data.get("CopiedTableName") + "_" + randomStringGenerator(6);
        domCreatePage.EnterNewTableNameInCopy(copiedTable);
        domCreatePage.clickCopyButtonInCopyPopup();
        domCreatePage.searchwithTableName(copiedTable);
        domCreatePage.hoverOnTable(copiedTable);
        domCreatePage.clickTableEdit();
        domCreatePage.clickSQLeditorInTableEdit();
        assertTrue(domCreatePage.verifySqlQueryInCopiedTable(data.get("SQLQuery")));
    }

    // SQL tables drillset
    @Test(dataProvider = "TC_DOM_SQL_TABLE_008")
    public void TC_DOM_SQL_TABLE_0010(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("NonEbsSqlAutoDomaindrill");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreDrillSet();
        domCreatePage.clickDrillSetAdd();
        String drillSetName = data.get("DrillSetName") + "_" + randomStringGenerator(6);
        domCreatePage.EnterDrillSetName(drillSetName);
        domCreatePage.clickDrillSetSaveAndNext();
        domCreatePage.clickDrillSetSelectAllTables();
        domCreatePage.clickDrillSetMoveTables();
        domCreatePage.clickDrillSetSaveAndNext();
        domCreatePage.clickDrillSetLoadUniqueFilters();
        domCreatePage.clickDrillSetSave();
        domCreatePage.verifyToastMsg(data.get("DrillsetToastMessage"));
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ReportColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickDrilldownIcon();
        reportCreatePage.clickDrillCreateIcon();
        reportCreatePage.selectDrillDownColumnFromDropDown(data.get("ReportColumnName"));
        reportCreatePage.clickDrillOrDrillSetSelectLovIcon();
        reportCreatePage.EnterDrillOrDrillSetNameInSearch(drillSetName);
        reportCreatePage.clickDrillOrDrillSetNameRadioButton();
        reportCreatePage.clickDrillOrDrillSetSelectPageOK();
        reportCreatePage.clickDrillMappingsIcon();
        reportCreatePage.clickDrillMappingsReportColumnSearch();
        reportCreatePage.dragReportColumnToFormulaInDrillpage(data.get("ReportColumnName"));
        reportCreatePage.clickDrillMappingsFormulaSave();
        reportCreatePage.clickDrillMappingsDrillTableColumnSearch();
        reportCreatePage.dragReportColumnToFormulaInDrillpage(data.get("ReportColumnName"));
        reportCreatePage.clickDrillMappingsFormulaSave();
        reportCreatePage.clickDrillPageSave();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
        reportCreatePage.clickReportOutput();
        reportCreatePage=reportCreatePage.switchtoHTMLtab();
        reportCreatePage.verifyReportHTMLheaderText(reportName);

    }
    //SQL table Conditions
    @Test(dataProvider = "TC_DOM_SQL_TABLE_011")
    public void TC_DOM_SQL_TABLE_011(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("To Verify SQL Table Conditions");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("SqlAutoDomainTableCond", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        Thread.sleep(3000);
        tableEditPage.clickConditionsTab();
        tableEditPage.dragConditionColumn(data.get("ConditionColumn1"));
        tableEditPage.enterConditionValue(data.get("ConditionValue1"));
        tableEditPage.clickConditionsSave();
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ReportColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_011")
    public Object[][] TC_DOM_SQL_TABLE_011() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_011");
    }

    //SQL table optional filters
    @Test(dataProvider = "TC_DOM_SQL_TABLE_012")
    public void TC_DOM_SQL_TABLE_012(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName = data.get("DomainName") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName);
        domCreatePage.enterDescInDomainCreate("To Verify SQL Table Conditions");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        Thread.sleep(2000);
        domCreatePage.clickOnSaveInDomainCreate();
        //    domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("EbsSqlAutoDomainTableCond", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        //  domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        //  domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        Thread.sleep(3000);
        tableEditPage.clickConditionsTab();
        tableEditPage.dragConditionColumn(data.get("ConditionColumn1"));
        tableEditPage.selectOptionalFilterFromDropdown(data.get("OptionalFilter"));
        tableEditPage.enterConditionValue(data.get("ConditionValue1"));
        tableEditPage.clickConditionsSave();
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ReportColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickConditionsIcon();
        reportCreatePage.dragTableConditionColumn(data.get("ConditionColumn1"));
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_012")
    public Object[][] TC_DOM_SQL_TABLE_012() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_012");
    }

    //SQL table share to users
    @Test(dataProvider = "TC_DOM_SQL_TABLE_013")
    public void TC_DOM_SQL_TABLE_013(Hashtable<String, String> data) throws InterruptedException, IOException {

        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName1 = data.get("UserName1") + randomStringGenerator(6);
        String password1 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName1);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password1);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        String userName2 = data.get("UserName2") + randomStringGenerator(6);
        String password2 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName2);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password2);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        userPage.switchToParentWindow();
        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("NonEbsSqlDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
//        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName1);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(userName1);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareCheckBoxInTableShare();
        domainEditPage.clickExportCheckoxInUsersOrUserGroupsTab();
        domainEditPage.clickCopyCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickDeleteCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickOnAddIconInTableShare();
        Thread.sleep(2000);
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName2);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName1);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName2);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(userName2);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        userPage.logout();
        userPage.loginWithAnotherUser(userName1, password1);
        userPage.resetPasswordForUser(userName1, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName1, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        Thread.sleep(2000);
        //assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domainEditPage.verifyTableEditOption());
        Thread.sleep(2000);
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableExportOption());
        assertTrue(domainEditPage.verifyTableShareOption());
        assertTrue(domainEditPage.verifyTableDeleteOption());
        assertTrue(domainEditPage.verifyTableCopyOption());
        domCreatePage.clickTableMoreOption();
        userPage.logout();
        userPage.loginWithAnotherUser(userName2, password2);
        userPage.resetPasswordForUser(userName2, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName2, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        //   assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        Thread.sleep(2000);
        assertFalse(domainEditPage.verifyTableEditOptiondisable());
        Thread.sleep(2000);
        domCreatePage.clickTableMoreOption();
        assertFalse(domainEditPage.verifyTableExportOptionDisabled());
        assertFalse(domainEditPage.verifyTableShareOptionDisabled());
        assertFalse(domainEditPage.verifyTableDeleteOptionDisabled());
        assertFalse(domainEditPage.verifyTableCopyOptionDisabled());

    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_013")
    public Object[][] TC_DOM_SQL_TABLE_013() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_012");
    }

    //verify SQL table restriction to user
    @Test(dataProvider = "TC_DOM_SQL_TABLE_013")
    public void TC_DOM_SQL_TABLE_015(Hashtable<String, String> data) throws InterruptedException, IOException {

        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName1 = data.get("UserName1") + randomStringGenerator(6);
        String password1 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName1);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password1);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        String userName2 = data.get("UserName2") + randomStringGenerator(6);
        String password2 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName2);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password2);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        userPage.switchToParentWindow();
        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("EbsSqlDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
//        assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName1);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(userName1);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareCheckBoxInTableShare();
        domainEditPage.clickExportCheckoxInUsersOrUserGroupsTab();
        domainEditPage.clickCopyCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickDeleteCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName1);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName2);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(userName2);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        userPage.logout();
        userPage.loginWithAnotherUser(userName2, password2);
        userPage.resetPasswordForUser(userName2, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName2, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        Thread.sleep(2000);
        //assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domainEditPage.verifyTableEditOption());
    }



    //verify sql table share to usergroup
    @Test(dataProvider = "TC_DOM_SQL_TABLE_013")
    public void TC_DOM_SQL_TABLE_014(Hashtable<String, String> data) throws InterruptedException, IOException {

        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName1 = data.get("UserName1") + randomStringGenerator(6);
        String password1 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName1);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password1);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickOnAddUserGroupsButtonInUserUnderUserGroupsTab();
        userPage.EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(data.get("UserGroupName1"));
        Thread.sleep(2000);
        userPage.clickOnUserGroupCheckBoxInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickOnselectButtonInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickSaveButton();
        String userName2 = data.get("UserName2") + randomStringGenerator(6);
        String password2 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName2);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password2);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickOnAddUserGroupsButtonInUserUnderUserGroupsTab();
        userPage.EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(data.get("UserGroupName2"));
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
        ConfigReader.updateTestDataConfig("NonEbsSqlDomainShareUG", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        // domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickUserGroupsTabInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName1"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName1"));
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareCheckBoxInTableShare();
        domainEditPage.clickExportCheckoxInUsersOrUserGroupsTab();
        domainEditPage.clickCopyCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickDeleteCheckboxInUsersOrUserGroupsTab();
        domainEditPage.clickOnAddIconInTableShare();
        Thread.sleep(2000);
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName2"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickUserGroupsTabInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName1"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName1"));
        Thread.sleep(2000);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName2"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        Thread.sleep(2000);
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        Thread.sleep(3000);
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName2"));
        Thread.sleep(2000);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        homePage.clickOnWorkspace();
        userPage.logout();
        userPage.loginWithAnotherUser(userName1, password1);
        userPage.resetPasswordForUser(userName1, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName1, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        Thread.sleep(2000);
        //assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domainEditPage.verifyTableEditOption());
        Thread.sleep(2000);
        domCreatePage.clickTableMoreOption();
        assertTrue(domainEditPage.verifyTableExportOption());
        assertTrue(domainEditPage.verifyTableShareOption());
        assertTrue(domainEditPage.verifyTableDeleteOption());
        assertTrue(domainEditPage.verifyTableCopyOption());
        //Manual Bug
        userPage.logout();
        userPage.loginWithAnotherUser(userName2, password2);
        userPage.resetPasswordForUser(userName2, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName2, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        //   assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        Thread.sleep(2000);
        assertFalse(domainEditPage.verifyTableEditOptiondisable());
        Thread.sleep(2000);
        domCreatePage.clickTableMoreOption();
        assertFalse(domainEditPage.verifyTableExportOptionDisabled());
        assertFalse(domainEditPage.verifyTableShareOptionDisabled());
        assertFalse(domainEditPage.verifyTableDeleteOptionDisabled());
        assertFalse(domainEditPage.verifyTableCopyOptionDisabled());

    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_013")
    public void TC_DOM_SQL_TABLE_016(Hashtable<String, String> data) throws InterruptedException, IOException {

        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName1 = data.get("UserName1") + randomStringGenerator(6);
        String password1 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName1);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password1);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickOnAddUserGroupsButtonInUserUnderUserGroupsTab();
        userPage.EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(data.get("UserGroupName1"));
        Thread.sleep(2000);
        userPage.clickOnUserGroupCheckBoxInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickOnselectButtonInAvailableUserGroupInUserUnderUserGroupsTab();
        userPage.clickSaveButton();
        String userName2 = data.get("UserName2") + randomStringGenerator(6);
        String password2 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName2);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password2);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickOnAddUserGroupsButtonInUserUnderUserGroupsTab();
        userPage.EnterUserGoupNameInInAvailableUserGroupInUserUnderUserGroupsTab(data.get("UserGroupName2"));
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
        ConfigReader.updateTestDataConfig("NonEbsSqlDomainShareUG", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableMoreOption();
        domainEditPage.clickOnTableMoreShare();
        domainEditPage.clickOnSecurityRadioBtnInTableShare();
        domainEditPage.clickUserGroupsTabInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName1"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName1"));
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickUserGroupsTabInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName1"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(data.get("UserGroupName2"));
        domainEditPage.clickSelectAllCheckboxInAvailableUserGroupsInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(data.get("UserGroupName2"));
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        userPage.logout();
        userPage.loginWithAnotherUser(userName2, password2);
        userPage.resetPasswordForUser(userName2, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName2, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        Thread.sleep(2000);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        assertTrue(domainEditPage.verifyTableEditOption());
    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_017")
    public void TC_DOM_SQL_TABLE_017(Hashtable<String, String> data) throws InterruptedException, IOException {

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
        ConfigReader.updateTestDataConfig("NonEbsSqlDomainSelfLov", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        tableEditPage.clickTableEditSettingsTab();
        tableEditPage.selectAllowDefaultSelfLovDropDownValue(data.get("AllowDefaultSelfLovOption"));
        tableEditPage.clickTableEditSettingsSave();
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName"));
        reportCreatePage.clickFiltersIcon();
        reportCreatePage.dragTableFilterColumn(data.get("ColumnName"));
        reportCreatePage.clickFiltersListOfValuesTab();
        reportCreatePage.verifyFilterListOfValuesSource(data.get("ListOfValuesSourceValue"));
    }
        @DataProvider(name = "TC_DOM_SQL_TABLE_017")
        public Object[][] TC_DOM_SQL_TABLE_017() {
            return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_017");
        }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_017")
    public void TC_DOM_SQL_TABLE_018(Hashtable<String, String> data) throws InterruptedException, IOException {

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
        ConfigReader.updateTestDataConfig("NonEbsSqlDomainSelfLov", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickTableEditColumnsTab();
        tableEditPage.enterColumnNameInColumnsTab(data.get("ColumnName"));
        tableEditPage.hoverOverTableColumnInColumnsTab();
        tableEditPage.clickColumnEditInColumnsTab();
        tableEditPage.selectAllowDefaultSelfLovDropDownValueInColumnEdit(data.get("ListOfValuesSourceValue"));
        tableEditPage.clickColumnEditSave();
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName"));
        reportCreatePage.clickFiltersIcon();
        reportCreatePage.dragTableFilterColumn(data.get("ColumnName"));
        reportCreatePage.clickFiltersListOfValuesTab();
        reportCreatePage.verifyFilterListOfValuesSource(data.get("ListOfValuesSourceValue"));
    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_019")
    public void TC_DOM_SQL_TABLE_019(Hashtable<String, String> data) throws InterruptedException, IOException {

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
        ConfigReader.updateTestDataConfig("SqlDomainJoins", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName1 = data.get("TableName1") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery1"));
        domCreatePage.enterSQLTableName(tableName1);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnAddSQLTableBtn();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName2 = data.get("TableName2") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery2"));
        domCreatePage.enterSQLTableName(tableName2);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        Thread.sleep(2000);
        domCreatePage.searchwithTableName(tableName1);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        tableEditPage.clickTableEditJoinsTab();
        tableEditPage.dragTableToCreateJoin(tableName2);
        tableEditPage.clickReverseJoinToggle();
        tableEditPage.clickTableSaveInJoinsTab();

        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName1"));
       // reportCreatePage.clickOnTableExpand(tableName2);
        reportCreatePage.clickTablesExpanAllIcon();
        Thread.sleep(2000);
        reportCreatePage.dragAndDropTableColumnsToReportFromSecondColumn(data.get("ColumnName2"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));

        }
    @DataProvider(name = "TC_DOM_SQL_TABLE_019")
    public Object[][] TC_DOM_SQL_TABLE_019() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_019");
    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_020")
    public void TC_DOM_SQL_TABLE_020(Hashtable<String, String> data) throws InterruptedException, IOException {

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
        ConfigReader.updateTestDataConfig("SqlDomainJoins", domName);
        domCreatePage.searchwithDataTable(data.get("TableName2"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("TableName2"));
        Thread.sleep(2000);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName1 = data.get("TableName1") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery1"));
        domCreatePage.enterSQLTableName(tableName1);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        Thread.sleep(2000);
        domCreatePage.searchwithTableName(tableName1);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        tableEditPage.clickTableEditJoinsTab();
        tableEditPage.dragTableToCreateJoin(data.get("TableName"));
        tableEditPage.clickReverseJoinToggle();
        tableEditPage.clickTableSaveInJoinsTab();
          homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName2"));
        reportCreatePage.clickTablesExpanAllIcon();
        Thread.sleep(2000);
        reportCreatePage.dragAndDropTableColumnsToReportFromSecondColumn(data.get("ColumnName1"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));

    }
    @DataProvider(name = "TC_DOM_SQL_TABLE_020")
    public Object[][] TC_DOM_SQL_TABLE_020() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_020");
    }



    @Test(dataProvider = "TC_DOM_SQL_TABLE_021")
    public void TC_DOM_SQL_TABLE_021(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName1 = data.get("DomainName1") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName1);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("SqlCrossDomainJoins1", domName1);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName1 = data.get("SQLTableName1") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery1"));
        domCreatePage.enterSQLTableName(tableName1);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        workSpacePage.clickOnTabCloseIcon();
        Thread.sleep(2000);
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName2 = data.get("DomainName2") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName2);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("SqlCrossDomainJoins2", domName2);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName2 = data.get("SQLTableName2") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery2"));
        domCreatePage.enterSQLTableName(tableName2);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        Thread.sleep(2000);
     //   domCreatePage.searchwithTableName(tableName2);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        tableEditPage.clickTableEditJoinsTab();
        tableEditPage.enterDomainNameSearchInJoinsTab(domName1);
        tableEditPage.clickDomainExpandInJoinsTab();
        tableEditPage.dragTableToCreateJoin(tableName1);
        tableEditPage.clickReverseJoinToggle();
        tableEditPage.clickTableSaveInJoinsTab();
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName1);
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName2);
        reportCreatePage.clickOnDomainName(domName2);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName2"));
        reportCreatePage.clickTablesExpanAllIcon();
        Thread.sleep(2000);
        reportCreatePage.dragAndDropTableColumnsToReportFromSecondColumn(data.get("ColumnName1"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));

    }
    @DataProvider(name = "TC_DOM_SQL_TABLE_021")
    public Object[][] TC_DOM_SQL_TABLE_021() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_021");
    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_021")
    public void TC_DOM_SQL_TABLE_023(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName1 = data.get("DomainName1") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName1);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("SqlDBcrossDomain1", domName1);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName1 = data.get("SQLTableName1") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery1"));
        domCreatePage.enterSQLTableName(tableName1);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        workSpacePage.clickOnTabCloseIcon();
        Thread.sleep(2000);
        homePage.clickOnCreateIconInMenu();
        homePage.enterSearchInputInCreateSideBar("Domain");
        homePage.clickOnCreateDomain();
        String domName2 = data.get("DomainName2") + "_" + randomStringGenerator(6);
        domCreatePage.enterDomainNameInDomainCreate(domName2);
        domCreatePage.enterDescInDomainCreate("desc");
        domCreatePage.clickDatabaseConcRefresh();
        domCreatePage.selectDefaultDatabaseConc(data.get("DatabaseConc"));
        domCreatePage.selectBusinessApplication(data.get("BusinessApplication"));
        domCreatePage.selectFolder(data.get("Folder"));
        domCreatePage.clickOnSaveInDomainCreate();
        domCreatePage.verifyToastMsg(data.get("DomainCreatedToast"));
        ConfigReader.updateTestDataConfig("SqlDBcrossDomain2", domName2);
        domCreatePage.searchwithDataTable(data.get("DBTableName2"));
        Thread.sleep(5000);
        domCreatePage.keyboardInput("Enter");
        domCreatePage.dragAndDropTableInDomain(data.get("DBTableName2"));
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        tableEditPage.clickTableEditJoinsTab();
        tableEditPage.enterDomainNameSearchInJoinsTab(domName1);
        Thread.sleep(5000);
        tableEditPage.clickDomainExpandInJoinsTab();
        tableEditPage.dragTableToCreateJoin(tableName1);
        tableEditPage.clickReverseJoinToggle();
        tableEditPage.clickTableSaveInJoinsTab();
        homePage.clickOnWorkspace();
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName2);
        reportCreatePage.clickOnDomainName(domName2);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName2"));
        reportCreatePage.clickTablesExpanAllIcon();
        Thread.sleep(2000);
        reportCreatePage.dragAndDropTableColumnsToReportFromSecondColumn(data.get("ColumnName1"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));

    }
    @Test(dataProvider = "TC_DOM_SQL_TABLE_025")
    public void TC_DOM_SQL_TABLE_025(Hashtable<String, String> data) throws InterruptedException, IOException {

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
        ConfigReader.updateTestDataConfig("SqlSyncColAutoDomain", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("SQLTableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.clickOnExecuteQueryWithData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickTableEditColumnsTab();
        tableEditPage.enterColumnNameInColumnsTab(data.get("ColumnName"));
        tableEditPage.hoverOverTableColumnInColumnsTab();
        tableEditPage.clickColumnMoreIconInColumnsTab();
        tableEditPage.clickColumnMoreDeleteInColumnsTab();
        tableEditPage.clickColumnDeleteContinueButtonInDeletePopup();
        domCreatePage.verifyToastMsg(data.get("ColumnDeletedToast"));
        tableEditPage.clickSyncWithDataBaseButtonInColumnsTab();
        domCreatePage.clickSQLeditorAddcolumnSelectAll();
        domCreatePage.clickSyncInSqlEditor();
        tableEditPage.clickSaveInColumnsTab();
        domCreatePage.verifyColumnNameInTableEditColumnsTab(data.get("ColumnName"));
        domCreatePage.clickTableEditDataTab();
        Thread.sleep(2000);
        domCreatePage.verifyColumnNameInTableDataTab(data.get("ColumnName"));

    }
    @DataProvider(name = "TC_DOM_SQL_TABLE_025")
    public Object[][] TC_DOM_SQL_TABLE_025() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_025");
    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_025")
    public void TC_DOM_SQL_TABLE_027(Hashtable<String, String> data) throws InterruptedException, IOException {

        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("SqlSyncColAutoDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
       //assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickTableEditColumnsTab();
        tableEditPage.enterColumnNameInColumnsTab(data.get("AggColumnName"));
        tableEditPage.hoverOverTableColumnInColumnsTab();
        tableEditPage.clickColumnEditInColumnsTab();
        tableEditPage.selectAggregationDropDownInColumnEdit(data.get("Aggregation"));
        tableEditPage.clickColumnEditSave();
        homePage.clickOnWorkspace();
         homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("AggColumnName"));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
        reportSubmitPage.clickMoreIcon();
        reportSubmitPage.clickMoreOptionsViewSql();
        assertTrue(reportSubmitPage.verifyConditionInViewSql(data.get("Aggregation")));

    }


    @Test(dataProvider = "TC_DOM_SQL_TABLE_028")
    public void TC_DOM_SQL_TABLE_028(Hashtable<String, String> data) throws InterruptedException, IOException {
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
        domCreatePage.verifyToastMsg(data.get("DomainCreateToast"));
        ConfigReader.updateTestDataConfig("EbsSqlColPropAutoDomain", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        domCreatePage.clickTableEditColumnsTab();
        tableEditPage.enterColumnNameInColumnsTab(data.get("ColumnName"));
        tableEditPage.hoverOverTableColumnInColumnsTab();
        tableEditPage.clickColumnEditInColumnsTab();
        tableEditPage.selectNumberFormatFromDropDownInColumnEdit(data.get("NumberFormat"));
        tableEditPage.enterDecimalPlacesFieldInColumnEdit(data.get("DecimalPlace"));
        tableEditPage.enterCurrencyFieldInColumnEdit(data.get("Currency"));
        tableEditPage.clickColumnEditSave();
        homePage.clickOnWorkspace();
        homePage.clickOnCreateIconInMenu();
        homePage.clickOnCreateReport();
        reportCreatePage.enterDomainName(domName);
        reportCreatePage.clickOnDomainName(domName);
        Thread.sleep(2000);
        reportCreatePage.dragAndDropTableColumnsToReport(data.get("ColumnName"));
        reportCreatePage.selectDataPreviewFromDropDown(data.get("DataPreviewOption"));
        Thread.sleep(5000);
       // assertTrue(reportCreatePage.verifyValueInDataGridRow(data.get("Currency")));
        reportCreatePage.clickReportSave();
        String reportName = data.get("ReportName") + "_" + randomStringGenerator(6);
        ConfigReader.updateTestDataConfig("SqlColPropAutoRep", reportName);
        reportCreatePage.enterReportName(reportName);
        reportCreatePage.clickReportSaveButton();
        Thread.sleep(2000);
        reportCreatePage.clickSavePublish();
        reportCreatePage.clickPublishAndRun();
        reportCreatePage.clickReportSubmit();
        reportCreatePage.clickReportSubmissionRefreshUntilComplete();
        reportCreatePage.verifyReportSubmissionStatus(data.get("Status"));
    }

    @DataProvider(name = "TC_DOM_SQL_TABLE_028")
    public Object[][] TC_DOM_SQL_TABLE_028() {
        return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_028");
    }


    @Test(dataProvider = "TC_DOM_SQL_TABLE_028")
    public void TC_DOM_SQL_TABLE_030(Hashtable<String, String> data) throws InterruptedException, IOException {
        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("EbsSqlColPropAutoDomain");
        String reportName = ConfigReader.getData("SqlColPropAutoRep");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        // assertTrue(workSpacePage.verifySearchItemInWorkspace(domName));
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        domCreatePage.hoverOverTableInDomain();
        domCreatePage.clickTableEdit();
        tableEditPage.clickTableUsageTab();
        Thread.sleep(2000);
        tableEditPage.verifyReportNameInTableUsage(reportName);

    }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_028")
    public void TC_DOM_SQL_TABLE_031(Hashtable<String, String> data) throws InterruptedException, IOException {
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
        domCreatePage.verifyToastMsg(data.get("DomainCreateToast"));
        ConfigReader.updateTestDataConfig("EbsSqlInErdAutoDomain", domName);
        domCreatePage.clickOnERDVIEWButton();
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("SQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
        domCreatePage.clickOnExecuteQueryWithOutData();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.waitForDataLoaderDisappear();
        domCreatePage.clickOnSaveInSqlTableCreate();
        domCreatePage.verifyToastMsg(data.get("TableCreatedToast"));

    }
    @Test(dataProvider = "TC_DOM_SQL_TABLE_033")
    public void TC_DOM_SQL_TABLE_033_034_035_037(Hashtable<String, String> data) throws InterruptedException, IOException {
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
        domCreatePage.verifyToastMsg(data.get("DomainCreateToast"));
        ConfigReader.updateTestDataConfig("SqlInvalidAutoDomain", domName);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.enterSqlQueryInQueryInput(data.get("InvalidSQLQuery"));
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        tableEditPage.verifySQLtableInvalidQueryValidationMsg(data.get("InvalidQueryWarning"));
        domCreatePage.clickOnOccCloseAlert();
        domCreatePage.clickOnCloseInSqlTableCreate();
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("InvalidQueryToastMsg"));
        tableEditPage.verifyFieldValidationMsg((data.get("SQLqueryFieldValidation")));
        Thread.sleep(2000);
      //  assertFalse(tableEditPage.verifySQLtableExecuteQueryWithDataIsEnabled());
      //  assertFalse(tableEditPage.verifySQLtableExecuteQueryWithOutDataIsEnabled());
        domCreatePage.clickOnCloseInSqlTableCreate();
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        domCreatePage.enterSqlQueryInQueryInput(data.get("ValidSQLQuery"));
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("ValidQueryToast"));
      //  assertFalse(tableEditPage.verifySQLtableExecuteQueryWithDataIsEnabled());
    //  assertFalse(tableEditPage.verifySQLtableExecuteQueryWithOutDataIsEnabled());
        //assertFalse(tableEditPage.VerifySaveInSqlTableCreate());
        domCreatePage.clickOnCloseInSqlTableCreate();
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        domCreatePage.enterSqlQueryInQueryInput(data.get("InvalidConnQuery"));
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyValidationMsg(data.get("InvalidConnQueryValidation"));
        domCreatePage.clickOnOccCloseAlert();
        domCreatePage.clickOnCloseInSqlTableCreate();

    }

        @DataProvider(name = "TC_DOM_SQL_TABLE_033")
        public Object[][] TC_DOM_SQL_TABLE_033() {
            return getTestData("domain", "SQLTableTest", "TC_DOM_SQL_TABLE_033"); }

    @Test(dataProvider = "TC_DOM_SQL_TABLE_033")
    public void TC_DOM_SQL_TABLE_036(Hashtable<String, String> data) throws InterruptedException, IOException {

        adminPage = homePage.navigateToAdminPage();
        userPage = adminPage.clickOnUsersIcon();
        String userName1 = data.get("UserName1") + randomStringGenerator(6);
        String password1 = randomPasswordGenerator();
        userPage.clickOnCreateUserIcon();
        userPage.enterUserName(userName1);
        userPage.enterFirstname(randomFirstNameGenerator());
        userPage.enterLastname(randomLastNameGenerator());
        userPage.enterEmail(randomEmailGenerator());
        userPage.clickOnLetMeCreatePwd();
        userPage.enterPwd(password1);
        userPage.clickOnSaveAndNext();
        userPage.clickOnAdminDeveloperAccessToggle();
        userPage.clickOnSaveAndNext();
        userPage.clickOnSaveAndNext();
        userPage.clickSaveButton();
        userPage.switchToParentWindow();
        homePage.clickOnWorkspace();
        String domName = ConfigReader.getData("SqlInvalidAutoDomain");
        System.out.println(domName);
        workSpacePage.enterValueInSearchInWorkspace(domName);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        domCreatePage.clickDomainMore();
        domCreatePage.clickDomainMoreShare();
        domainEditPage.clickOnAddIconInTableShare();
        domainEditPage.EnterUserOrUserGroupNameInAvailableUsersInTableShare(userName1);
        domainEditPage.clickSelectAllCheckboxInAvailableUsersInTableShare();
        domainEditPage.clickAddBtnInAvailableUsersOrUsergroupsInTableShare();
        domainEditPage.EnterUserOrUserGroupNameSearch(userName1);
        domainEditPage.clickEditCheckBoxInTableShare();
        domainEditPage.clickShareButtonInUsersOrUserGroupsTab();
        userPage.logout();
        userPage.loginWithAnotherUser(userName1, password1);
        userPage.resetPasswordForUser(userName1, data.get("newPassword"));
        userPage.loginWithAnotherUser(userName1, data.get("newPassword"));
        homePage.clickOnWorkspace();
        workSpacePage.enterValueInSearchInWorkspace(domName);
        Thread.sleep(2000);
        workSpacePage.hoverOverSearchedItemInWorkspace(domName);
        workSpacePage.clickOnDomainEdit();
        Thread.sleep(2000);
        String tableName = data.get("TableName") + "_" + randomStringGenerator(6);
        domCreatePage.clickOnAddTableBtn();
        domCreatePage.clickOnSQLTableIcon();
        domCreatePage.clickOnSelectInTableCreation();
        domCreatePage.enterSQLTableName(tableName);
        domCreatePage.enterSqlQueryInQueryInput(data.get("ValidSQLQuery"));
        domCreatePage.clickOnValidateSQL();
        domCreatePage.verifyToastMsg(data.get("InvalidQueryToastMsg"));
        tableEditPage.verifyConnectionValidationMsg(data.get("SQLTableConnValidation"));

    }

    }
