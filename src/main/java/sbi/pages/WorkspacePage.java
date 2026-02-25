package com.qa.sbi.pages;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;
import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class WorkspacePage extends BasePage {
    public WorkspacePage(Page page) {
        super(page);
        loadProperties("home","WorkspacePage");
    }

    public void enterValueInSearchInWorkspace(String value){
        inputData(getLocator("search_in_workspace"),value);
    }
    public boolean verifySearchItemInWorkspace(String value){
        return (String.format(getLocator("searched_item"),value).equalsIgnoreCase(value));
    }
    public void hoverOverSearchedItemInWorkspace(String objectName){
        hoverOverElement(String.format(getLocator("searched_item"), objectName));
    }
    public void clickOnDomainEdit(){
        clickElementWithByLabel("Edit");
    }
    public void clickOnDomainFavorites(){
        clickElementWithByLabel("Favorites");
    }
    public void clickOnDomainInfo(){
        clickElementWithByLabel("Info");
    }
    public void clickOnDomainMoreOptions(){
        clickElementWithByLabel("More");
    }

    public void clickOnReportRun(){
        clickElementWithByLabel("Run");
    }

    public void clickOnInfoCloseIcon(){
        click(getLocator("close_info"));
    }
    public void clickOnTabCloseIcon(){
        click(getLocator("close_info"));
    }


    public void clickOnRefreshIcon(){
        click(getLocator("refresh_icon"));
    }

}
