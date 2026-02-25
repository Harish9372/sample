package com.qa.sbi.pages.domain;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class TableEditPage extends BasePage {
    public TableEditPage(Page page) {
        super(page);
        loadProperties("domain","TableEdit");
    }

    public void clickConditionsTab() {
        click(getLocator("table_edit_ConditionsTab"));}

    public void clickTableUsageTab(){
        click(getLocator("table_edit_UsageTab"));
    }

    public void dragConditionColumn(String colName) throws InterruptedException {
        String source=String.format("//app-table-conditions//div[@draggable='true']//span[text()='%s']", colName);
        dragAndDropByBoundingBox(source, getLocator("table_conditionDRopArea"));
    }

    public void selectOptionalFilterFromDropdown(String optionalFilterCondition) throws InterruptedException {
        selectDropDownValue(getLocator("Conditions_dropdown"),getLocator("dropdown_list"),optionalFilterCondition);
    }

    public void clickConditionsSave() {
        click(getLocator("table_filter_saveBtn"));}

    public void enterConditionValue(String ConditionValue){
        inputData(getLocator("condition_value_input"),ConditionValue);
    }




    public void clickTableEditSettingsTab() {
        click(getLocator("table_edit_SettingsTab"));
    }
    public void clickTableEditSettingsSave() {
        click(getLocator("table_edit_settings_Save"));
    }

    public void clickTableEditJoinsTab() {
        click(getLocator("table_edit_JoinsTab"));
    }

    public void selectAllowDefaultSelfLovDropDownValue(String Option) throws InterruptedException {
        selectDropDownValue(getLocator("table_edit_SettingsAllowDefaultSelfLOV"),getLocator("dropdown_list"),Option);
    }
    public void enterColumnNameInColumnsTab(String ColumnName){
        inputData(getLocator("tableEdit_columns_search"),ColumnName);
    }

    public void hoverOverTableColumnInColumnsTab() {
        hoverOverElement(getLocator("table_columns_in_columns_tab"));
    }
    public void clickColumnEditInColumnsTab() {
        click(getLocator("edit_table_columns_in_columns_tab"));}

    public void clickColumnMoreIconInColumnsTab() {
        click(getLocator("columnMoreIcon_in_columns_tab"));}

    public void clickColumnMoreDeleteInColumnsTab() {
        click(getLocator("columnMoreDelete_in_ColumnsTab"));}
    public void clickColumnDeleteContinueButtonInDeletePopup() {
        click(getLocator("columnMoreDelete_Popup_ColumnsTab"));}
    public void clickSyncWithDataBaseButtonInColumnsTab() {
        click(getLocator("tableColumnsTab_SyncWithDatabaseButton"));}
    public void clickSaveInColumnsTab() {
        click(getLocator("tableColumnsTab_Save"));}



    public void selectAllowDefaultSelfLovDropDownValueInColumnEdit(String Option) throws InterruptedException {
        selectDropDownValue(getLocator("Domain_Table_ListOfValues_drpdwn"),getLocator("dropdown_list"),Option);
    }

    public void selectAggregationDropDownInColumnEdit(String Option) throws InterruptedException {
        selectDropDownValue(getLocator("tableColumn_aggregationDropDown"),getLocator("dropdown_list"),Option);
    }

    public void selectNumberFormatFromDropDownInColumnEdit(String Option) throws InterruptedException {
        selectDropDownValue(getLocator("tableColumn_NumberFormatDropDown"),getLocator("dropdown_list"),Option);
    }


    public void clickColumnEditSave() {
        click(getLocator("save_in_column_edit"));}

    public void dragTableToCreateJoin(String tablename) throws InterruptedException {
        String source=String.format("//app-joins-domains//span[@draggable='true' and text()=' %s']", tablename);
        dragAndDropByBoundingBox(source, getLocator("joins_tab_grid_view"));
    }
    public void clickReverseJoinToggle() {
        click(getLocator("reverse_join"));}
    public void clickTableSaveInJoinsTab() {
        click(getLocator("table_Save_JoinsTab"));}


    public void enterDomainNameSearchInJoinsTab(String DomainName){
        inputData(getLocator("searchDomain_OrTable_JoinsTab"),DomainName);
    }
    public void clickDomainExpandInJoinsTab() {
        click(getLocator("joinsTab_DomainExpand"));}


    public void enterCurrencyFieldInColumnEdit(String currencySymbol){
        inputData(getLocator("CurrencyField_ColumnEdit"),currencySymbol);
    }

    public void enterDecimalPlacesFieldInColumnEdit(String decimalPlaces){
        inputData(getLocator("DecimalPlaceField_ColumnEdit"),decimalPlaces);
    }

    public void verifyReportNameInTableUsage(String Reportname) {
        VerifyElementWithByText(Reportname);
    }

        public void verifyFieldValidationMsg(String ValidationMessage) {
            verifiesValidationMessage(getLocator("SQLtable_QueryFieldValidation"), ValidationMessage);
        }
    public void verifyConnectionValidationMsg(String ValidationMessage) {
        verifiesValidationMessage(getLocator("SQLtable_ConenctionValidation"), ValidationMessage);
    }

    public void verifySQLtableInvalidQueryValidationMsg(String ValidationMessage) {
        verifiesValidationMessage(getLocator("SQL_Invalidquery_Validation"), ValidationMessage);
    }

        public boolean verifySQLtableExecuteQueryWithDataIsEnabled(){
            return page.locator(getLocator("SQL_executeQuery_WithOutDataButton")).isEnabled();
        }

    public boolean verifySQLtableExecuteQueryWithOutDataIsEnabled(){
        return page.locator(getLocator("SQL_executeQuery_WithDataButton")).isEnabled();   }

    public boolean VerifySaveInSqlTableCreate(){
       return page.locator(String.valueOf(getLocatorByLabel("save"))).isEnabled();
    }

}
