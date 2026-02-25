package com.qa.sbi.pages.reports;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class ReportSubmitPage extends BasePage {
    public ReportSubmitPage(Page page) {
        super(page);
        loadProperties("report","ReportSubmit");
          }

    public void clickMoreIcon() {
        click(getLocator("report_submitPage_MoreOptionsIcon"));}
    public void clickMoreOptionsViewSql() {
        click(getLocator("report_MoreOptionsViewSql"));}

public boolean verifyConditionInViewSql(String Condition){
    return  Condition.contains(getText(getLocator("viewSQL")));

}

    }

