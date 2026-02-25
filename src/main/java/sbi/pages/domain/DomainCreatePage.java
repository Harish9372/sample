package com.qa.sbi.pages.domain;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.qa.sbi.factory.BasePage;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class DomainCreatePage extends BasePage {

    public DomainCreatePage(Page page) {
        super(page);
        loadProperties("domain", "DomainCreatePage");
    }

    public void enterDomainNameInDomainCreate(String domName) {
        inputData(getLocator("domain_name"), domName);
    }

    public void DomainCodeInputInDetails(String domName) {
        inputData(getLocator("domain_code_in_details"), domName);
    }

    public void enterDescInDomainCreate(String desc) {
        inputData(getLocator("description"), desc);
    }

    public void clickDatabaseConcRefresh() {
        click(getLocator("database_Connection_refresh"));
    }

    public void clickDatabaseConDataRefresh() {
        click(getLocator("database_refresh_refresh_connect_data"));
    }

    public void clickDatabaseConStatus() {
        click(getLocator("default_database_connection_Status"));
    }

    public void selectDefaultDatabaseConc(String concName) throws InterruptedException {
        selectDropDownValue(getLocator("default_database_connection"), getLocator("dropdown_list"), concName);
    }

    public void selectAnotherDatabaseConc(String concName) throws InterruptedException {
        selectDropDownValue(getLocator("database_connection_dropdown"), getLocator("dropdown_list"), concName);
    }

    public void selectSchema(String concName) throws InterruptedException {
        selectDropDownValue(getLocator("database_schema"), getLocator("dropdown_list"), concName);
    }


    public void selectDefaultDatabaseConnection() throws InterruptedException {
        click(getLocator("default_database_connection"));
    }

    public void selectBusinessApplication(String bApp) throws InterruptedException {
        selectDropDownValue(getLocator("business_application"), getLocator("dropdown_list"), bApp);
    }

    public void clickOnBusinessApplicationRefreshButton() {
        click(getLocator("businessApplication_Refresh"));
    }

    public void selectFolder(String folderName) throws InterruptedException {
        selectDropDownValue(getLocator("folder"), getLocator("folder_list"), folderName);
    }

    public void selectFolder2(String folderName) throws InterruptedException {
        selectDropDownValue(getLocator("folder"), getLocator("folder"), folderName);
    }


    public void clickOnSaveInDomainCreate() {
        click(getLocator("save_in_domain_create"));
    }

    public void clickOnAddTableBtn() {
        click(getLocator("add_table"));
    }

    public void clickOnSQLTableIcon() {
        clickOnElementWithText("SQL");
    }

    public void clickOnAddSQLTableBtn() {
        click(getLocator("domain_CreateOrEdit_SQLtableIcon"));
    }

    public void clickOnSelectInTableCreation() {
        click(getLocator("select_in_table_creation"));
    }

    public void enterSQLTableName(String tableName) {
        inputData(getLocator("sql_table_name"), tableName);
    }

    public void clickOnCSVTableIcon() {
        clickOnElementWithText("CSV");
    }

    public void clickOnSaveAndNextCsv() {
        click(getLocator("SaveAndNextCsvPage"));
    }

    public void clickOnSaveBtnCsv() {
        click(getLocator("Save_Csv_Table"));
    }

    public void clickOnConnectionInSettings() {
        click(getLocator("Connections_Settings"));
    }

    public void enterCSVInput(String tableName) {
        inputData(getLocator("csv_table_name"), tableName);
    }

    public void createOracleConnector(String conName, String hostName, String SID, String UserName, String Pass, String PortNum, String concName) throws InterruptedException {
        inputData(getLocator("connection_name"), conName);
        selectDropDownValue(getLocator("system"), getLocator("system_list"), concName);
        click(getLocator("overlay_backdrop"));
        inputData(getLocator("host_name"), hostName);
        inputData(getLocator("sid"), SID);
        inputData(getLocator("connection_user"), UserName);
        inputData(getLocator("connection_password"), Pass);
        inputData(getLocator("port_number"), PortNum);
        click(getLocator("test_Connector"));
        click(getLocator("save_close_btn"));
        click(getLocator("Check_Status"));
    }

    public void createSplashDemosConnector(String conName, String hostName, String SID, String UserName, String Pass, String PortNum, String concName) throws InterruptedException {
        inputData(getLocator("connection_name"), conName);
        selectDropDownValue(getLocator("system"), getLocator("system_list"), concName);
        click(getLocator("overlay_backdrop"));
        inputData(getLocator("host_name"), hostName);
        inputData(getLocator("sid"), SID);
        inputData(getLocator("connection_user"), UserName);
        inputData(getLocator("connection_password"), Pass);
        inputData(getLocator("port_number"), PortNum);
        click(getLocator("test_Connector"));
        click(getLocator("save_close_btn"));
        click(getLocator("Check_Status"));
    }

    public void createOracleCloudConnector(String conName, String UserName, String Pass, String URL) throws InterruptedException {
        inputData(getLocator("ConnectionName_Cloud"), conName);
        inputData(getLocator("connection_user"), UserName);
        inputData(getLocator("connection_cloudPassword"), Pass);
        inputData(getLocator("connection_Url"), URL);
        click(getLocator("test_Connector"));
        click(getLocator("saveAndClose"));
        click(getLocator("Check_Status"));
    }

    public void enterSourceTable(String tableName) {
        inputData(getLocator("sourceTableName"), tableName);
    }

    public void clickOnERDVIEWButton() {
        click(getLocator("erd_view"));
    }


    public void enterSqlQueryInQueryInput(String query) {
        inputDataWithType(getLocator("sql_query_input"), query);
    }

    public void clickOnValidateSQL() {
        clickOnElementWithText("Validate SQL");
    }

    public boolean verifyToastMsg(String toastMsg) {
        verifiesThatTheToastMessageIsDisplayed(getLocator("toast_message"), toastMsg);
        return false;
    }

    public void clickOnExecuteQueryWithData() {
        clickOnElementWithText("Execute query with Data");
    }

    public void clickOnExecuteQueryWithOutData() {
        clickOnElementWithText("Execute query without Data");
    }

    public void clickOnValidateWithWithRealTime() {
        clickOnElementWithText("Validate with Real-time & DW");
    }

    public void waitForDataLoaderDisappear() {
        waitForElementToDisappear(getLocator("data_loader_spinner"));
    }

    public void clickOnSaveInSqlTableCreate() {
        getLocatorByLabel("save").click();
    }

    public void clickOnCloseInSqlTableCreate() {
        getLocatorByLabel("cancel").click();
    }

    public void clickOnAddConnectorButton() {
        click(getLocator("add_Connection"));

    }

    public void clickOnValidateWithRealTimeandDW() {
        clickOnElementWithText("Validate with Real-time & DW");
    }

    public void verifyValidationMsg(String ValidationMessage) {
        verifiesValidationMessage(getLocator("OCC_sql_alertMessage"), ValidationMessage);
    }

    public void verifyValidationToastMsg(String ValidationMessage) {
        getText("OCC_sql_alertMessage");
    }

    public void dragAndDropColumn(String columnName, String destinationLocator) {
        String columnXpath = "//span[@class='sbi-tree-col-name']";
        String destinationXpath = "//kendo-splitter-pane//div[contains(@class,'sbi-re-tables-right-content')]";
        page.locator(columnXpath).getByText(columnName).dragTo(page.locator(destinationXpath));
        System.out.println("Successfully dragged column: " + columnName + " to destination.");
    }

    public void clickOnOccCloseAlert() {
        click(getLocator("OCC_sql_AlertPopupClose"));
    }

    public void hoverOverTableInDomain() {
        hoverOverElement(getLocator("edit_table_item"));
    }

    public void hoverOverTableHeader() {
        hoverOverElement(getLocator("header_table"));
    }

    public void clickTableEdit() {
        click(getLocator("edit_table_btn"));
    }

    public boolean isEditTableButtonEnabled() {
        return isEnabled("edit_table_btn");
    }

    public boolean isExportIconEnabled() {
        return isEnabled(getLocator("edit_table_export"));
    }

    public boolean isInfoIconEnabled() {
        return isEnabled("edit_table_info");
    }

    public boolean isMoreOptionEnabled() {
        return isEnabled("table_moreOption");
    }


    public void clickOnTableClearButton() {
        click(getLocator("tables_type_clear"));
    }

    public void selectObjectType(String objType) throws InterruptedException {
        selectDropDownValue(getLocator("tables_type"), getLocator("dropdown_list"), objType);

    }

    public void selectschema(String Type) throws InterruptedException {
        selectDropDownValue(getLocator("schema"), getLocator("dropdown_list"), Type);

    }

    public void searchwithDataTable(String table) {
        inputData(getLocator("tables_type_search"), table);
    }
    //public void dragAndDropTableInDomain(String TableName){
    //dragAndDrop(String.format(getLocator("grid_table"),tableName),getLocator("table_list_view"));
    //}

    public void searchwithTableName(String table) {
        inputData(getLocator("table_edit_search"), table);
    }

    public void clickOnListOfValue() {
        click(getLocator("list_of_value"));
    }

    public void clickSQLeditorInTableEdit() {
        click(getLocator("sql_editor_edit_inTableEdit"));
    }

    public void enterSqlQueryInTableEdit(String query) {
        inputDataWithTypeAfterClear(getLocator("update_sql_query_inTableEdit"), query);
    }

    public void clickSQLeditorAddcolumnSelectAll() {
        click(getLocator("add_columns_selectAll_inSQLtableEdit"));
    }

    public void clickSQLeditorDeletecolumnSelectAll() {
        click(getLocator("delete_columns_selectAll_inSQLtableEdit"));
    }

    public void clickSyncInSqlEditor() {
        click(getLocator("sync_button_inSQLtableedit"));
    }

    public void clickTableEditSave() {
        click(getLocator("table_edit_save"));
    }

    public void clickTableEditSaveInDrillLayoutTab() {
        click(getLocator("drill_layout_tableSave"));
    }


    public void clickTableEditColumnsTab() {
        click(getLocator("table_edit_columnsTab"));
    }

    public void verifyColumnNameInTableEditColumnsTab(String columnName) {
        VerifyElementWithByText(columnName);
    }

    public void clickAddColumnInTableEditColumnsTab() {
        click(getLocator("table_edit_createCalcolumn"));

    }

    public void clickOnDomainDetailsIcon() throws InterruptedException {
        click(getLocator("domain_details_icon"));
        Thread.sleep(2000);
    }

    public void EnterCalColumnName(String name) {
        inputData(getLocator("calColumn_name"), name);
    }

    public void clickCalcColumnSave() {
        click(getLocator("createCalSave"));

    }

    public void clickCalColumnOperatorPlus() {
        click(getLocator("calColumnOperatorPlus"));

    }

    public void dragColumnToFormulaInCalCol(String col) {
        dragAndDropwithLocatorText(getLocator("calColumns_list"), getLocator("calFormula_field"), col);
    }

    public void clickTableEditDataTab() {
        click(getLocator("table_edit_DataTab"));
    }

    public void verifyColumnNameInTableDataTab(String Column) {
        VerifyElementWithByText(Column);
    }

    public void clickTableEditDrillToggle() {
        click(getLocator("table_edit_drilldownToggle"));
    }

    public void clickOnSetting() {
        click(getLocator("Setting_button"));
    }

    public void clickOnOracleEBS() {
        click(getLocator("Oracle_Connector"));
    }

    public void clickOnmySqlConnector() {
        click(getLocator("mySQL_Connector"));
    }

    public void clickOnOracleCloud() {
        click(getLocator("OracleCloud_Connector"));
    }

    public void clickOnConnectorByUsingText(String Con) {
        clickOnElementWithText(Con);
    }

    public void uploadFileWithSelector(String selector, String filePath) {
        page.waitForLoadState();
        FileChooser fileChooser = page.waitForFileChooser(() -> page.locator(getLocator(selector)).click());
        fileChooser.setFiles(Paths.get(filePath));
        logger.info("Uploaded file from the path: " + filePath);
    }

    public void resetPassword() {
    }

    public void clickTableEditDrillLayoutTab() {
        click(getLocator("table_edit_drilllayoutTab"));
    }

    public String getDbConnNameInConnectToDataTab() {
        return getText(getLocator("db_conn_dropdown_in_connect_to_data_tab"));
    }

    public void selectRandomDbConnNameInConnectToDataTab() throws InterruptedException {
        selectRandomValueFromDropdown(getLocator("db_conn_dropdown_in_connect_to_data_tab"), getLocator("dropdown_list"));
    }

    public void selectDbConnNameInConnectToDataTab(String dbConnector) throws InterruptedException {
        selectDropDownValue(getLocator("db_conn_dropdown_in_connect_to_data_tab"), getLocator("dropdown_list"), dbConnector);
    }

    public String getSchemaNameInConnectToDataTab() {
        return getText(getLocator("schema_dropdown_in_connect_to_data_tab"));
    }

    public void waitForSkeletonLoaderToDisappear() {
        waitUntilThatTheLoaderIsDetached(getLocator("skeleton_loader"));
    }

    public void hoverSearchedDbObject() {
        hoverOverElement(getLocator("searched_db_object"));
    }

    public String getDbObjectTypeToolTip() throws InterruptedException {
        Thread.sleep(2000);
        //String actText=
        //System.out.println("Expected is :"+tableType);
        //System.out.println("Actual is   :"+tableType);
        return getText(getLocator("db_object_type_tool_tip")).trim();
    }

    public String getDbObjectTypeToolTipSourceType() throws InterruptedException {
        Thread.sleep(2000);
        //String actText=
        //System.out.println("Expected is :"+tableType);
        //System.out.println("Actual is   :"+tableType);
        return getText(getLocator("db_source_table_tool_tip")).trim();
    }

    public void clickTableEditDrillLayoutInDrillLayoutTab() {
        click(getLocator("drill_layout_Tab"));

    }

    public void dragColumnToDrillFilters(String colName) throws InterruptedException {
        String source = String.format("//app-drill-layout//div[@draggable='true']//span[text()='%s']", colName);
        dragAndDropByBoundingBox(source, getLocator("drill_layout_filter_grid_view"));
    }


    public void dragColumnToDrillLayout(String colName) throws InterruptedException {
        String source = String.format("//app-drill-layout//div[@draggable='true']//span[text()='%s']", colName);
        dragAndDropByBoundingBox(source, getLocator("drill_layout_filter_left"));
    }

    public void EnterDrillLayoutHeader(String name) {
        inputData(getLocator("drill_layout_Hearder"), name);
    }


    public void clickTableMoreOption() {
        click(getLocator("table_moreOption"));
    }
    public void clickTableMoreDelete(){
        click(getLocator("tableMore_delete"));
    }
    public void clickContinueInTableDeletePopup(){
        click(getLocator("table_delete_PopupContinue"));
    }
    public void clickTableDomainMoreOption() {
        click(getLocator("domain_more"));
    }

    public boolean verifyMenuListItems() {

        List<String> actualTableList = getElementsTextList(getLocator("More_items"));
        if (actualTableList.isEmpty()) {
            System.out.println("No items found in the menu.");
            return false;
        }
        System.out.println("Total items found: " + actualTableList.size());
        System.out.println("Menu items: " + actualTableList);

        return true;
    }

    public void clickOnPreviewDataButton() {
        click(getLocator("preview_data"));
    }

    public void enterDataInPreviewDataPage(String Data) {
        inputData(getLocator("source_data_table"), Data);
    }

    public boolean verifyPreviewData() {
        String salesIdXpath = "//div[@col-id='SALES_ID']";
        List<String> salesIdList = page.locator(salesIdXpath).allInnerTexts();
        boolean containsNumber = salesIdList.stream().anyMatch(text -> text.trim().matches(".*\\d+.*"));
        if (containsNumber) {
            System.out.println("✅ SALES_ID contains a number in one of the elements: " + salesIdList);
        } else {
            System.out.println("❌ SALES_ID does not contain a number in any of the elements: " + salesIdList);
        }

        return containsNumber;
    }

    public void clickTableMoreOptionCopy() {
        click(getLocator("table_moreOption_Copy"));
    }

    public void clickCopyButtonInCopyPopup() {
        click(getLocator("table_Copy_CopyBtn"));
    }

    public void hoverOnTable(String tablename) {
        hoverOverElementByText(tablename);
    }

    public void EnterNewTableNameInCopy(String NewTableName) {
        clearInputData(getLocator("table_copy_newTableName"));
        inputData(getLocator("table_copy_newTableName"), NewTableName);

    }

    public boolean verifySqlQueryInCopiedTable(String query) {
        String text = getTrimmedText(getLocator("update_sql_query_inTableEdit"));
        return text.equalsIgnoreCase(query);
    }


    public void clickDomainMore() {
        click(getLocator("domain_more"));
    }

    public void clickOnTableHeader() {
        hoverAndClick(getLocator("header_table"), getLocator("table_header_menu"));
    }

    public void hoverTable() {
        hoverOverElement(getLocator("header_table"));
    }

    public void clickonTablemenu() {
        // First, hover over the table header
        Locator tableHeader = page.locator(getLocator("header_table"));
        tableHeader.scrollIntoViewIfNeeded();
        tableHeader.hover(new Locator.HoverOptions().setForce(true));
        System.out.println("Hovered over the table header");

        // Now, locate and click the menu icon
        Locator tableMenu = page.locator(getLocator("table_header_menu"));
        page.waitForCondition(() -> tableMenu.isVisible(), new Page.WaitForConditionOptions().setTimeout(5000));
        tableMenu.click(new Locator.ClickOptions().setForce(true));
        System.out.println("Clicked on the table menu icon");
    }


    public void clickDomainMoreDrillSet() {
        click(getLocator("domain_more_Drillset"));
    }


    public void clickDrillSetAdd() {
        click(getLocator("drill_sets_addition"));
    }

    public void clickDrillSetSelectAllTables() {
        click(getLocator("drillSet_available_drill_tables_select_all"));
    }

    public void clickDrillSetMoveTables() {
        click(getLocator("drillSet_drill_tables_assign"));
    }

    public void clickDrillSetSaveAndNext() {
        click(getLocator("drillSet_SaveAndNext"));
    }

    public void clickDrillSetSave() {
        click(getLocator("drillSet_filterSave"));
    }

    public void clickDrillSetLoadUniqueFilters() {
        click(getLocator("drillSet_LoadUniqueDrillFil"));
    }

    public void EnterDrillSetName(String DrillsetName) {
        inputData(getLocator("drillSet_Name"), DrillsetName);
    }

    public void clickDomainMoreShare() {
        click(getLocator("domain_more_Share"));
    }

    public void clickOnERDViewIcon() {
        click(getLocator("erdViewIcon"));
    }

    public void clickOnPreviewDataIconOfTableInDbObjects() {
        click(getLocator("preview_data_icon_of_table_in_database_objects"));
    }

    public boolean verifyPreviewDataIsDisplayed(String table) {
        return isElementVisible(String.format(getLocator("row_list_in_preview_data_popup"), table));
    }

    public boolean verifyPreviewDataIsDisplayed() {
        waitForElement(getLocator("data_in_preview_data_window"));
        return isElementVisible(getLocator("data_in_preview_data_window"));
    }

    public void clickOnCloseIconInPreviewDataPopup() {
        click(getLocator("close_icon_in_preview_data_popup"));
    }

    public void enterTextInSearchInPreviewDataPopup(String text) {
        inputData(getLocator("search_input_in_preview_data_popup"), text);
    }

    public void clickOnLastPageIconInPreviewDataPopup(String tableName) {
        click(String.format(getLocator("last_page_icon_in_preview_data_popup"), tableName));
    }

    public void clickOnFirstPageIconInPreviewDataPopup(String tableName) {
        click(String.format(getLocator("first_page_icon_in_preview_data_popup"), tableName));
    }

    public void clickOnNextPageIconInPreviewDataPopup(String tableName) {
        click(String.format(getLocator("next_page_icon_in_preview_data_popup"), tableName));
    }

    public void clickOnPreviousPageIconInPreviewDataPopup(String tableName) {
        click(String.format(getLocator("previous_page_icon_in_preview_data_popup"), tableName));
    }

    public boolean verifyConnectorIsDisplayedUnderDataBaseConnection() {
        return isElementVisible(getLocator("data_base_connection_dropdown")) &&
                getText(getLocator("data_base_connection_dropdown")).contains("Oracle EBS");
    }

    public void clickOnDatabaseConnectorsDropdown() {
        click(getLocator("data_base_connection_dropdown"));

    }

    public boolean verifyDatabaseConnectorList() throws InterruptedException {
        click(getLocator("data_base_connection_dropdown"));
        Thread.sleep(1000);
        List<String> actualConnectors = getElementsTextList(getLocator("dropdown_list"));
        if (actualConnectors.isEmpty()) {
            System.out.println("No connectors found in the dropdown.");
            return false;
        }

        System.out.println("Connectors found: " + actualConnectors);
        return true;
    }

    public boolean verifyDatabaseschemalist() throws InterruptedException {
        click(getLocator("database_schema"));
        Thread.sleep(1000);
        List<String> actualSchemas = getElementsTextList(getLocator("dropdown_list"));
        if (actualSchemas.isEmpty()) {
            System.out.println("No schema Present in the dropdown.");
            return false;
        }
        System.out.println("Schema's found: " + actualSchemas);
        return true;
    }


    public String getCurrentPageNumberInPreviewDataPopup(String tableName) {
        return getText(String.format(getLocator("current_page_number_in_preview_data_popup"), tableName));
    }

    public String getTotalPageNumberInPreviewDataPopup(String tableName) {
        return getText(String.format(getLocator("total_page_number_in_preview_data_popup"), tableName));
    }

    public void dragAndDropTableInDomain(String tableName) {
        String sourceXpath = String.format("//*[@class='k-table k-grid-table k-table-md']//tr//span[normalize-space(text())='%s']", tableName);
        String targetXpath = getLocator("grid_table");
        dragAndDrop(sourceXpath, targetXpath);
    }

    public void ClickOnTableCheckbox() {
        click(getLocator("select_checkbox"));

    }

    public void ClickOnTableAddInDatabaseObjectTypePage() {
        click(getLocator("add_table_obj"));

    }

    public void hoverOnTableInDatabaseObjectsPane(String tableName) {
        String sourceXpath = String.format("//*[@class='k-table k-grid-table k-table-md']//tr//span[normalize-space(text())='%s']", tableName);
        hoverOverElement(sourceXpath);
    }

    public void clickOnTableInDatabaseObjectsPane(String tableName) {
        String sourceXpath = String.format("//*[@class='k-table k-grid-table k-table-md']//tr//span[normalize-space(text())='%s']", tableName);
        click(sourceXpath);
    }

    public void clickOnAddBtnInDatabaseObjectsPane() {
        clickOnElementWithText("Add");
    }

    public void clickOnClosePreviewPage() {

        click(getLocator("closeButton_preview"));
    }

    public boolean verifySearchedTableIsDisplayed(String tableName) {
        return isElementVisible(String.format(getLocator("searched_table"), tableName));
    }

    public boolean verifySearchedTableIsDisplayedInErdView(String tableName) {
        return isElementVisible(String.format(getLocator("searched_table_in_erd_view"), tableName));
    }

    public boolean verifyTooManyTablesInConnectToDataPane() {
        return isElementVisible(getLocator("too_many_tables_in_connect_to_data_pane"));
    }

    public boolean verifyDemosTablePreviewData(String expectedText) {
        return isElementVisible(getLocator("non_ebs_preview_data"));
    }

    public boolean verifyTableOracleEBSPreviewData() {
        return isElementVisible(getLocator("oracle_ebs_preview_data"));
    }

    public boolean verifyTableOracleCloudPreviewData() {
        return isElementVisible(getLocator("oracle_cloud_preview_data_not_available"));
    }

    public void navigateAndVerifyTableData() {

        click(getLocator("last_page"));
        verifyTableData();
        click(getLocator("first_page"));
        verifyTableData();
        click(getLocator("next_page"));
        verifyTableData();
        click(getLocator("Previous_Page"));
        verifyTableData();
    }

    private void verifyTableData() {
        List<String> tableData = page.locator("//div[contains(@class, 'ag-cell-value')]").allInnerTexts();
        System.out.println("✅ Table data: " + tableData);
    }

    public void verifyTotalRowCount() {
        String totalRowText = getLocator("totalRowText"); // Update with actual locator
        System.out.println("✅ Total Row Count: " + totalRowText);
    }

    public void changePageSizeAndVerifyRowCount(int pageSize) throws InterruptedException {

        click(getLocator("page_size_dropdown"));

        page.click("//div[contains(@class, 'sbi-dm-database-source-table-container')]//div[contains(@aria-label, 'Page Size')]//div[text()='" + pageSize + "']");

        Thread.sleep(2000);

        List<String> rows = page.locator("//div[contains(@role, 'row')]").allInnerTexts();
        if (rows.size() == pageSize) {
            System.out.println("✅ Page size " + pageSize + " verified successfully.");
        } else {
            System.out.println("❌ Mismatch in page size. Expected: " + pageSize + ", Found: " + rows.size());
        }
    }

    public boolean isHeaderPresent(String expectedHeaderText) {
        Locator header = page.locator("//*[contains(@class, 'modal sbi-modal-container') and contains(@class, 'sbi-database-source-tables-model')]//h6[normalize-space(text())='" + expectedHeaderText + "']");
        boolean isPresent = header.count() > 0;
        if (isPresent) {
            System.out.println("Header '" + expectedHeaderText + "' Preview Data Header is Displayed");
        } else {
            System.out.println("Header '" + expectedHeaderText + "' is NOT present.");
        }
        return isPresent;
    }

    public boolean verifyPaginationInTable() throws InterruptedException {
        boolean flag;
        while (true) {
            flag = verifyElementsAreNotEmptyInList(getLocator("firstPageTables"));

            if (isElementVisible(getLocator("nextButtonDisabled"))) {
                break;
            } else {
                click(getLocator("nextButton"));
                Thread.sleep(2000);
            }

        }

        return flag;
    }

    public void clearNewTableNameInCopy() {
        clearInputData(getLocator("table_copy_newTableName"));
    }

    public void verifyCopyTableNameValidation(String validationMessage) {
        verifiesValidationMessage(getLocator("copy_table_name_validation"), validationMessage);
    }

    public void CheckAndDragMultipleTables() throws InterruptedException {
        Locator checkboxes = page.locator("//input[@aria-label='Select row']");
        if (checkboxes.count() >= 2) {
            checkboxes.first().check();
            checkboxes.nth(1).check();
        } else {
            throw new RuntimeException("Less than two tables found to select.");
        }
        Locator selectedRows = page.locator("//td[//input[@aria-label='Select row']]");
        Locator target = page.locator(getLocator("grid_table"));
        Thread.sleep(2000);
        for (int i = 0; i < selectedRows.count(); i++) {
            selectedRows.nth(i).dragTo(target);
        }
    }

    public boolean VerifyDatabaseObjectTypesList() throws InterruptedException {
        click(getLocator("tables_type"));
        Thread.sleep(1000);
        List<String> actualObjectsFound = getElementsTextList(getLocator("dropdown_list"));
        if (actualObjectsFound.isEmpty()) {
            System.out.println("No Object Types found in the dropdown.");
            return false;
        }
        System.out.println("Object Types found: " + actualObjectsFound);
        Thread.sleep(2000);
        page.keyboard().press("Escape");

        return true;
    }

    public void dragAndDropTableInDomainERDView(String tableName) {
        String sourceXpath = String.format("//*[@class='k-table k-grid-table k-table-md']//tr//span[normalize-space(text())='%s']", tableName);
        String targetXpath = getLocator("erd_table");
        dragAndDrop(sourceXpath, targetXpath);
    }


    public void verifyAndCloseKendoPopup(String expectedText) {
        try {
            // Wait for the popup to appear
            Locator popup = page.locator("//div[contains(@class,'k-window k-dialog')]");
            page.waitForSelector("//div[contains(@class,'k-window k-dialog')]", new Page.WaitForSelectorOptions().setTimeout(5000));

            if (popup.isVisible()) {
                // Locate the popup message
                Locator popupMessage = popup.locator("//div[contains(text(),'Query valid against real-time connector')]");

                // Get and verify the text
                String actualText = popupMessage.textContent();
                if (actualText.contains(expectedText)) {
                    System.out.println("Popup text verification passed: " + actualText);
                } else {
                    throw new RuntimeException("Popup text mismatch! Expected: " + expectedText + " but found: " + actualText);
                }

                // Locate the Close 'X' button using your exact XPath
                Locator closeButton = page.locator("(//*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted'])[6]");

                // Click the close button (force click in case it's hidden)
                closeButton.click(new Locator.ClickOptions().setForce(true));

                // Wait for the popup to disappear
                page.waitForSelector("//div[contains(@class,'k-window k-dialog')]", new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.DETACHED));

                System.out.println("Popup closed successfully.");
            } else {
                throw new RuntimeException("Popup found but not visible!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Popup not found or failed to close!", e);
        }
    }


    public void selectTableCheckboxes() {
        page.waitForSelector("//table[contains(@class,'k-table k-grid-table')]//td//input[@type='checkbox']");
        Locator checkboxes = page.locator("//table[contains(@class,'k-table k-grid-table')]//td//input[@type='checkbox']");
        int count = checkboxes.count();

        if (count >= 2) {
            checkboxes.first().click();
            checkboxes.nth(1).click();
            System.out.println("Successfully selected two checkboxes.");
        } else {
            throw new RuntimeException("Less than two checkboxes found in the table. Found: " + count);
        }
    }

    public String verifyDatabaseConnectorMessage(String expectedMessage) {
        String actualMessage = page.locator(getLocator("database_connector_message")).innerText();

        System.out.println("🔍 Expected: " + expectedMessage);
        System.out.println("🔍 Actual: " + actualMessage);

        return actualMessage; // Return actual message
    }


    public boolean isTableGridViewHasData() {
        try {
            Locator table = page.locator(getLocator("erd_table"));
            table.waitFor(new Locator.WaitForOptions().setTimeout(5000)); // Wait for table

            // Check if table is visible and has text
            return table.isVisible() && !table.innerText().trim().isEmpty();
        } catch (Exception e) {
            System.out.println("⚠️ Table Grid View is either not visible or empty: " + e.getMessage());
            return false;
        }
    }

    public void clickOnListViewIcon() {
        click(getLocator("list_view"));
    }

    public boolean isTableListViewDisplayed() {
        return isElementVisible(getLocator("edit_table_item"));
    }


    public int verifyAndSelectAllCheckboxesAndAdd() throws InterruptedException {
        int totalCheckboxCount = 0;

        while (true) {
            List<Locator> checkboxes = getElementsList(getLocator("table_list_check"));
            totalCheckboxCount += checkboxes.size();
            for (Locator checkbox : checkboxes) {
                if (!checkbox.isChecked()) {
                    checkbox.click();
                }
            }

            if (isElementVisible(getLocator("disableIconNext"))) {
                break;
            } else {
                click(getLocator("nextButton"));
                Thread.sleep(2000);
            }
        }

        click(getLocator("add_table_obj"));
        Thread.sleep(5000);

        return totalCheckboxCount;
    }

    public int getDomainInfoTableCount() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = page.locator(getLocator("Table_count_list")).innerText().trim(); // Fetch inner text
        return Integer.parseInt(actualText);
    }



}
