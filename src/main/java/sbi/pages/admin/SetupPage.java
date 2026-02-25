package com.qa.sbi.pages.admin;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class SetupPage extends BasePage {
    public SetupPage(Page page) {
        super(page);
        loadProperties("admin","SetupPage");
    }
   public void clickOnBusinessApp(){
        clickOnElementWithText("Business Applications");
   }
   public int getBusinessAppListSize(){
       return getElementsCount(getLocator("business_application_list"));

   }
    public void clickOnFolders(){
        clickOnElementWithText("Folders");
    }
    public void clickOnFolders1(){
        click(getLocator("folder"));
    }

    public void enterValueInSearchInFolders(String value){
        inputData(getLocator("search_in_folders"),value);
    }
    public int getFoldersListSize(){
        return getElementsCount(getLocator("folders_list"));
    }
    public boolean verifySearchedFolder(String folder){
        return getText(getLocator("folders_list")).equalsIgnoreCase(folder);
    }
    public void clickOnArrowIconForSubFolder(){
           click(getLocator("arrow_icon_for_sub_folder"));
    }

    public void clickOnExtendIconForSubFolder(){
        click(getLocator("expand_Icon_SubFolder"));
    }

    public  void clickOnOutSideOfSub(){
        click(getLocator("overlay_backdrop"));
    }
    public boolean verifySubFolderIsDisplayed(String subFolder){
        return isTextVisible(subFolder);
    }

}
