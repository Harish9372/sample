package com.qa.sbi.pages.domain;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class DomainEditPage extends BasePage {
    public DomainEditPage(Page page) {
        super(page);
        loadProperties("domain","DomainEditPage");
        loadProperties("domain","TableEdit");
    }
    public void clearDomainNameInputInDetails(){
        clearInputData(getLocator("domain_name_in_details"));
    }
    public void inputDomainNameInputInDetails(String value){
        inputData(getLocator("domain_name_in_details"),value);
    }
    public void inputDomainCodeInputInDetails(String value){
        inputData(getLocator("domain_name_in_details"),value);
    }
    public void clearDomainCodeInputInDetails(){
        clearInputData(getLocator("domain_code_in_details"));
    }

    public boolean verifyDomainNameInputValidation() throws InterruptedException {
        Thread.sleep(1000);
        return getLocatorByText("Domain Name is required").isVisible();
    }
    public boolean verifyDomainCodeInputValidation() throws InterruptedException {
        Thread.sleep(1000);
        return getLocatorByText("Domain Code is required").isVisible();
    }
    public void clickOnUpdateInDomainDetails(){
        clickOnElementWithText("Update");
    }
    public int getBusinessAppDropdownValuesSize(){
        click(getLocator("business_app_dropdown"));
        return getElementsCount(getLocator("dropdown_list_values"));
    }
    public void selectBusinessApplication(String bApp) throws InterruptedException {
        selectDropDownValue(getLocator("business_app_dropdown"),getLocator("dropdown_list"),bApp);
    }
    public void selectDatabaseConn(String conn) throws InterruptedException {
        selectDropDownValue(getLocator("default_db_conn_dropdown"),getLocator("dropdown_list"),conn);
    }
    public void selectFolder(String folder) throws InterruptedException {
        selectDropDownValue(getLocator("folders_dropdown"),getLocator("folders_dropdown_list_values"),folder);
    }
    public int getFoldersDropdownValuesSize(){
        click(getLocator("folders_dropdown"));
        return getElementsCount(getLocator("folders_dropdown_list_values"));
    }
    public void clickCreateFolderBtn(){
        clickOnElementWithText("Create Folder");
    }
    public void inputFolderNameInputForNew(String value){
        inputData(getLocator("folder_name_input_for_new"),value);
    }
    public void clickOnFolderSaveIcon(){
        click(getLocator("folder_save_icon"));
    }
    public void clickOnCloseBtn(){
        click(getLocator("close_btn"));
    }
    public void clickOnCreateDomainPageCloseBtn(){
        click(getLocator("createDomain_close"));
    }
    public void clickOnCreateSubFolderBtn(){
        clickOnElementWithText("Create Sub folder");
    }
    public boolean verifyDatabaseConnectorText(String conn) throws InterruptedException {
        Thread.sleep(1000);
        return conn.equalsIgnoreCase(getText(getLocator("default_db_conn_dropdown_text")));
    }
    public boolean verifyBusinessAppText(String bApp) throws InterruptedException {
        Thread.sleep(1000);
        return bApp.equalsIgnoreCase(getText(getLocator("business_app_dropdown_text")));
    }
    public String getDatabaseConnectorText() throws InterruptedException {
        Thread.sleep(1000);
        return getText(getLocator("default_db_conn_dropdown_text"));
    }

    public String getBusinessAppText() throws InterruptedException {
        Thread.sleep(1000);
        return getText(getLocator("business_app_dropdown_text"));
    }
    public String selectRandomDatabaseConn() throws InterruptedException {
        return selectRandomValueFromDropdown(getLocator("default_db_conn_dropdown_text"),getLocator("dropdown_list"));
    }
    public void clickOnTableMoreShare(){
        click(getLocator("table_moreOption_Share"));
    }
    public void clickOnSecurityRadioBtnInTableShare(){
        click(getLocator("SecurityRadioBtn_sharedUserOrUsergroup"));
    }
    public void clickOnAddIconInTableShare(){
        click(getLocator("UserOrUsergroupAddIcon"));
    }
    public void EnterUserOrUserGroupNameInAvailableUsersInTableShare(String name){
        inputData(getLocator("SearchIn_UsersOrUsergroupsTab"),name);
    }

    public void clickSelectAllCheckboxInAvailableUsersInTableShare(){
        click(getLocator("selectAll_UsersTab"));
    }
    public void clickSelectAllCheckboxInAvailableUserGroupsInTableShare(){
        click(getLocator("selectAll_UserGroupsTab"));
    }

    public void clickAddBtnInAvailableUsersOrUsergroupsInTableShare(){
        click(getLocator("AddButton_InAvailableUsersOrUsergroups"));
    }
    public void clickShareButtonInUsersOrUserGroupsTab(){
        click(getLocator("ShareButton_InUsersOrUserGroupsTab"));
    }
    public void clickEditCheckBoxInTableShare(){
        click(getLocator("TableShare_EditCheckbox"));
    }
    public void clickShareCheckBoxInTableShare(){
        click(getLocator("TableShare_ShareCheckbox"));
    }
    public void clickCopyCheckboxInUsersOrUserGroupsTab(){
        click(getLocator("TableShare_CopyCheckbox"));
    }
    public void clickExportCheckoxInUsersOrUserGroupsTab(){
        click(getLocator("TableShare_ExportCheckbox"));
    }
    public void clickDeleteCheckboxInUsersOrUserGroupsTab(){
        click(getLocator("TableShare_DeleteCheckbox"));
    }

    public void clickUserGroupsTabInTableShare(){
        click(getLocator("TableShare_UserGroupTab"));
    }

public boolean verifyTableExportOption(){
         return page.locator(getLocator("tableMore_export")).isEnabled();
    }
    public boolean verifyTableExportOptionDisabled(){
        return page.locator(getLocator("tableMore_export")).isDisabled();
    }

   public boolean verifyTableDeleteOption(){
        return page.locator(getLocator("tableMore_delete")).isEnabled();
    }
    public boolean verifyTableDeleteOptionDisabled(){
        return page.locator(getLocator("tableMore_delete")).isDisabled();
    }
    public boolean verifyTableCopyOption(){
        return page.locator(getLocator("tableMore_copy")).isEnabled();
    }
    public boolean verifyTableCopyOptionDisabled(){
        return page.locator(getLocator("tableMore_copy_disable")).isVisible();
    }
    public boolean verifyTableShareOption(){
        return page.locator(getLocator("table_moreOption_Share")).isEnabled();
    }
    public boolean verifyTableShareOptionDisabled(){
        return page.locator(getLocator("table_moreOption_Share")).isDisabled();
    }
    public boolean verifyTableEditOption(){
        return page.locator(getLocator("edit_table_btn")).isEnabled();
    }

    public boolean verifyTableDisable(){
        return page.locator(getLocator("disbaled_table")).isEnabled();
    }
    public boolean verifyTableEditOptiondisable(){
        return page.locator(getLocator("edit_table_disable_btn")).isDisabled();
    }

    public void EnterUserOrUserGroupNameSearch(String name) {
        inputData(getLocator("Searchfield_InDomainShare"),name);
    }


    public boolean verifyDatabaseConnectorMessage() {
        String expectedText = "Database Connector has more than 500 objects. Please use search to show objects";
        String actualText = page.getByText(String.valueOf(page.locator("your_locator_here"))).textContent();

        return actualText.contains(expectedText);
    }


}


