package com.qa.sbi.pages;

import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;
import com.qa.sbi.pages.admin.AdminPage;
import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class HomePage extends BasePage {

	public HomePage(Page page) {
		super(page);
		loadProperties("home","HomePage");
	}

	public AdminPage navigateToAdminPage() {
		return new AdminPage(switchToNewWindow(getLocator("menu_admin")));
	}

	public void clickOnCreateIconInMenu() {
		click(getLocator("menu_create"));
	}

	public void enterSearchInputInCreateSideBar(String searchItem) {
		inputData(getLocator("search_input_in_create_side_bar"), searchItem);
	}

	public void clickOnCreateDomain() {
		click(getLocator("create_domain"));
	}
	public void clickOnWorkspace(){
		click(getLocator("menu_workspace"));
	}

	public void clickOnCreateReport() {
		click(getLocator("create_report"));
	}
}

