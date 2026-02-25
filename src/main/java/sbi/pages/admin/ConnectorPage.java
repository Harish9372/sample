package com.qa.sbi.pages.admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.sbi.factory.BasePage;

import static com.qa.sbi.util.ConfigReader.getLocator;
import static com.qa.sbi.util.ConfigReader.loadProperties;

public class ConnectorPage extends BasePage {
    public ConnectorPage(Page page) {
        super(page);
        loadProperties("admin","ConnectorPage");
    }

    public void clickOnConnectorsTab() {
        click(getLocator("Connectors_Tab"));
    }

    /**
     * Selects a connector from the dropdown.
     *
     * @param connectorName Name of the connector to select
     */
    public void selectConnector(String connectorName) {
      //  selectByVisibleText(getLocator("Connector_Dropdown"),connectorName);
        logger.info("Selected connector: " + connectorName);
    }


    /**
     * Clicks on the Share button.
     */
    public void clickOnShareButton() {
        click(getLocator("Share_Button"));
    }

    /**
     * Enters the username in the search field.
     *
     * @param userName The username to search for
     */
    public void enterUserName(String userName) {
        inputData(getLocator("User_Search_Field"), userName);
    }

    /**
     * Selects the user from the list.
     */
    public void selectUserFromList() {
        click(getLocator("User_Checkbox"));
    }

    /**
     * Clicks on the Confirm Share button.
     */
    public void clickOnConfirmShare() {
        click(getLocator("Confirm_Share_Button"));
    }
    public void selectByVisibleText(Locator dropdown, String visibleText) {
        dropdown.selectOption(visibleText);
        logger.info("Selected option '" + visibleText + "' from dropdown.");
    }


}

