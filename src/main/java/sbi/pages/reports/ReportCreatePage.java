package com.qa.sbi.pages.reports;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.qa.sbi.factory.BasePage;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class ReportCreatePage extends BasePage {

    public ReportCreatePage(Page page) {
        super(page);
        loadProperties("report","ReportCreatePage");
    }

    public void enterDomainName(String domainName) {
        inputData(getLocator("search_DomainName"), domainName);
    }

    public void clickDomainName() {
        click(getLocator("select_domainName"));
    }

    public void clickOnDomainName(String domainName) {
        getLocatorByRunTimeText(getLocator("domain_list_in_rep_create"),domainName);
    }
    public void dragAndDropTableColumnsToReport(String columnName){
        dragAndDrop(String.format(getLocator("table_column_names"), columnName),getLocator("reports_list_container"));
    }
    public void dragAndDropTableColumnsToReportFromSecondColumn(String columnName){
        dragAndDrop(String.format(getLocator("table_column_names"), columnName),getLocator("reports_grid_view"));
    }


    public void enterReportName(String reportName) {
        inputData(getLocator("Report_Name_field"), reportName);
    }

    public void clickReportSave() {
        click(getLocator("report_save"));

    }
    public void clickReportSaveButton() {
        click(getLocator("Save_report_Btn"));

    }
    public void clickSavePublish(){
        click(getLocator("save_publish"));
    }
    public void clickPublish(){
        click(getLocator("Publish"));
    }

    public void clickPublishAndRun(){
        click(getLocator("publishAndRun_InReport"));
    }

    public void verifyReportPublishToastMsg(String toastMsg) {
        verifiesThatTheToastMessageIsDisplayed(getLocator("toast_message"), toastMsg);
    }
    public void clickReportSubmit(){
        click(getLocator("report_submit"));
    }

    public void clickReportPastSubmissionRefresh(){
        click(getLocator("past_submissions_refresh"));
    }
    public void clickReportSubmissionRefreshUntilComplete() throws InterruptedException {

        String loc = getLocator("report_submission_status");

        int maxRetries = 50;
        int retryCount = 0;
        while (retryCount < maxRetries) {
            waitForElement(loc);
            String statusText = getText(loc).trim();
            if (!statusText.equalsIgnoreCase("Waiting") && !statusText.equalsIgnoreCase("Processing") && !statusText.equalsIgnoreCase("Error")) {
                break;
            }
            click(getLocator("past_submissions_refresh"));
            retryCount++;
            Thread.sleep(3000); // Wait for 3 seconds between retries
        }
        if (retryCount >= maxRetries) {
            throw new RuntimeException("Exceeded maximum retries, submission status still in 'Waiting' or 'Processing'.");
        }
    }

    public void hoverOverReportPastSubmission() {
        hoverOverElement(getLocator("hover_Submitted_Report"));
    }

    public void verifyReportSubmissionStatus(String Status) {
        verifyText(getLocator("report_submission_status"), Status);
    }

    public void clickDrilldownIcon(){
        click(getLocator("report_dilldownIcon"));
    }
    public void clickDrillCreateIcon(){
        click(getLocator("drill_createIcon"));
    }
    public void selectDrillDownColumnFromDropDown(String colName) throws InterruptedException {
        selectDropDownValue(getLocator("drilldown_columnsDropdown"),getLocator("dropdown_list"),colName);
    }
    public void clickDrillOrDrillSetSelectLovIcon(){
        click(getLocator("Drill_DrillSet_SelectIcon"));
    }
    public void clickDrillOrDrillSetNameRadioButton(){
        click(getLocator("Drill_set_Name_radio_btn"));
    }

    public void clickDrillOrDrillSetSelectPageOK(){
        click(getLocator("Drill_DrillSet_SelectPage_OK"));
    }
    public void clickDrillMappingsIcon(){
        click(getLocator("DrillPage_Mapping"));
    }
    public void clickDrillMappingsReportColumnSearch(){
        click(getLocator("drill_report_column_search"));
    }
    public void dragReportColumnToFormulaInDrillpage(String column){
        dragAndDropwithLocatorText(getLocator("Drill_report_columns"),getLocator("drill_column_formulaField"),column);
    }
    public void clickDrillMappingsDrillTableColumnSearch(){
        click(getLocator("drill_column_Filter_search"));
    }

    public void clickDrillMappingsFormulaSave(){
        click(getLocator("drill_ReportCol_FilterCol_save"));
    }

    public void clickDrillPageSave(){
        click(getLocator("drill_pageSave"));
    }

    public void clickReportOutput(){
        click(getLocator("Report_Output_Icon_1"));
    }

    public void clickReportOutputHTML(){
        click(getLocator("HTMLoutput"));
    }

    public void verifyReportHTMLheaderText(String Text) {
        verifyText(getLocator("html_tab_header"), Text);
    }
    public ReportCreatePage switchtoHTMLtab(){
        return new ReportCreatePage(switchToNewWindow(getLocator("HTMLoutput")));
    }

    public void EnterDrillOrDrillSetNameInSearch(String DrillsetName) {
        inputData(getLocator("drillOrDrillSet_nameSearch"),DrillsetName);}

    public void clickConditionsIcon(){
        click(getLocator("report_ConditionsIcon"));
    }

    public void dragTableConditionColumn(String colName) throws InterruptedException {
        String source=String.format("//app-edit-report-container//div[@cdkdrag]//span[text()='%s']", colName);
        dragAndDropByBoundingBox(source, getLocator("conditions_tab_ColumnDropArea"));
    }

    public void clickFiltersIcon(){
        click(getLocator("report_FiltersIcon"));
    }

    public void dragTableFilterColumn(String colName) throws InterruptedException {
        String source=String.format("//app-edit-report-container//div[@cdkdrag]//span[text()='%s']", colName);
        dragAndDropByBoundingBox(source, getLocator("filters_tab_ColumnDropArea"));
    }
    public void clickFiltersListOfValuesTab(){
        click(getLocator("filters_ListOfValuesTab"));
    }


    public void verifyFilterListOfValuesSource(String Source) {
        verifyText(getLocator("filters_ListOfValuesSource"), Source);
    }

    public void clickOnTableExpand(String tableName) {
        String sourceXpath = String.format("//*[text()='%s']//preceding::kendo-svgicon[1]", tableName);
        click(sourceXpath);
    }

    public void clickTablesExpanAllIcon(){
        click(getLocator("Expand_All"));
    }
    public void selectDataPreviewFromDropDown(String previewOption) throws InterruptedException {
        selectDropDownValue(getLocator("report_datagrid_previeDataDropdown"),getLocator("dropdown_list"),previewOption);
    }
    public boolean verifyValueInDataGridRow(String value){
        return  value.contains(getText(getLocator("report_datagrid_DataFirstRow")));

    }

}