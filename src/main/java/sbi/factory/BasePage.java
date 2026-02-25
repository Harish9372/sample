package com.qa.sbi.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import static com.qa.sbi.constants.AppConstants.PAGE_LOAD_TIMEOUT;
import static com.qa.sbi.constants.AppConstants.PAGE_NAVIGATION_TIMEOUT;
import static com.qa.sbi.util.ConfigReader.getLocator;


public class BasePage  {
    protected Page page;
    public static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(Page page) {
        this.page = page;
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/configurations/log4j.properties");
    }

    public void navigate(String url) {
        try {
            page.navigate(url);
            logger.info("Application URL is : "+url);
        } catch (TimeoutError e) {
            throw new RuntimeException("Application is not accessible: ", e);
        }
    }
    public void click(String locator) {
        try {
            waitForElement(locator);
            if(page.locator(locator).isVisible() && page.locator(locator).isEnabled()){
                page.click(locator);
                logger.info("Clicked on Element: "+locator);
                page.waitForLoadState(LoadState.DOMCONTENTLOADED);
            }else{
                logger.info("Unable to Click on Element: "+locator);
            }
        } catch (TimeoutError e) {
            throw new RuntimeException("Element not clickable: " + locator, e);
        }
    }
    public void clickOnElementWithText(String elementText) {
        List<Locator> eleList=page.locator("//*[normalize-space(text())='"+elementText+"']").all();
        try {
            if(eleList.size()>1){
                for(Locator loc : eleList){
                    if(loc.isVisible() && loc.isEnabled()){
                        loc.click();
                        logger.info("Clicked on Element with Text: "+loc);
                        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
                        break;
                    }
                }
            }else{
                if(eleList.get(0).isVisible() && eleList.get(0).isEnabled()){
                    eleList.get(0).click();
                    logger.info("Clicked on Element with Text: "+eleList.get(0));
                    page.waitForLoadState(LoadState.DOMCONTENTLOADED);
                }
            }

        } catch (TimeoutError e) {
            throw new RuntimeException("Element not clickable: " + eleList, e);
        }
    }

    public void inputData(String locator, String value) {
        try {
            waitForElement(locator);
            if(page.locator(locator).isVisible() && page.locator(locator).isEnabled()){
                page.fill(locator, value);
                logger.info("Entered "+value+" in the given Input: "+locator);
                page.waitForLoadState(LoadState.DOMCONTENTLOADED);
            }
        } catch (TimeoutError e) {
            throw new RuntimeException("Unable to fill the value in the Element: " + locator, e);
        }
    }
    public void clearInputData(String locator) {
        try {
            waitForElement(locator);
            page.locator(locator).clear();
            page.fill(locator, "");
            logger.info("Cleared in the given Input: "+locator);
        } catch (TimeoutError e) {
            throw new RuntimeException("Unable to clear the value in the Element: " + locator, e);
        }
    }

    public void dragAndDropByBoundingBox(String src, String dest) throws InterruptedException {
        Thread.sleep(3000);
        Locator srcEle = page.locator(src);
        Locator tarEle = page.locator(dest);
        BoundingBox draggableBox = srcEle.boundingBox();
        BoundingBox dropListBox = tarEle.boundingBox();
        int startX = (int) (draggableBox.x + draggableBox.width / 2);
        int startY = (int) (draggableBox.y + draggableBox.height / 2);
        int endX = (int) (dropListBox.x + dropListBox.width / 2);
        int endY = (int) (dropListBox.y + dropListBox.height / 2);
        page.mouse().move(startX, startY);
        page.mouse().down();
        page.mouse().move(endX, endY, new Mouse.MoveOptions().setSteps(30));
        page.mouse().up();
        Thread.sleep(2000);
    }

    public void inputDataWithType(String eleName, String value) {
        waitForElement(eleName);
        if(page.locator(eleName).isVisible() && page.locator(eleName).isEnabled()){
            page.click(eleName);
            page.locator(eleName).pressSequentially(value);
            logger.info("Entered the data " + value + " for element: " + eleName);
        }
    }
    public void inputDataWithTypeAfterClear(String eleName, String value) {
        try {
            waitForElement(eleName);
            if(page.locator(eleName).isVisible() && page.locator(eleName).isEnabled()){
                page.locator(eleName).click();
                page.press(eleName,"Control+A");
                page.press(eleName,"Delete");
                page.locator(eleName).click();
                page.locator(eleName).pressSequentially(value);
                logger.info("Entered the data: " + value + " for element: " + getLocatorByPlaceholder(eleName));
            }
            page.locator(eleName).click();
            page.press(eleName,"Control+A");
            page.press(eleName,"Delete");
            page.locator(eleName).click();
            page.locator(eleName).pressSequentially(value);
            logger.info("Entered the data: " + value + " for element: " + getLocatorByPlaceholder(eleName));
        } catch (Exception e) {
            logger.error("Failed to enter data for element: " + eleName, e);
            throw e;
        }
    }


    public void waitForElement(String locator) {
        page.waitForSelector(locator);
    }

    public boolean isElementVisible(String locator) {
        //page.locator(locator).waitFor();
        return page.locator(locator).isVisible();
    }


    public String getText(String locator) {
        waitForElement(locator);
        return page.locator(locator).textContent();
    }

    public String getAttribute(String locator, String attribute) {
        return page.locator(locator).getAttribute(attribute);
    }

    public Locator getLocatorByLabel(String label) {
        page.waitForLoadState();
        Locator ele = page.getByLabel(label, new Page.GetByLabelOptions().setExact(true));
        logger.info("Found element with label: " + label);
        return ele;
    }
    public void clickElementWithByLabel(String label){
        List<Locator> list=getLocatorByLabel(label).all();
        if(list.size()>1){
            for (Locator loc : list) {
                if (loc.isVisible() && loc.isEnabled()) {
                    loc.click();
                    logger.info("Clicked on element with Label: "+label);
                }
            }
        } else {
            getLocatorByLabel(label).click();
            logger.info("Clicked on element with Label: "+label);

        }
    }
    public boolean isTextVisible(String text) {
        try {
            return page.locator("text=" + text)
                    .isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public Locator getLocatorByPlaceholder(String placeholder) {
        Locator ele = page.getByPlaceholder(placeholder, new Page.GetByPlaceholderOptions().setExact(true));
        logger.info("Found element with placeholder: " + placeholder);
        return ele;
    }
    public Page switchToNewWindow(String triggerLocator) {
        Page newPage = page.waitForPopup(() -> click(triggerLocator));
        newPage.setDefaultNavigationTimeout(PAGE_NAVIGATION_TIMEOUT);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);
        newPage.setDefaultTimeout(PAGE_LOAD_TIMEOUT);
        logger.info("Switched to new window : ");
        return newPage;
    }


    public void selectDropDownValue(String drpDwn, String searchField, String value) throws InterruptedException {
        Thread.sleep(2000);
        click(drpDwn);
        logger.info("Selected the dropdown: " + drpDwn);
        Thread.sleep(3000);
        List<Locator> locatorList = page.locator(searchField).all();
        if (locatorList.size() > 1) {
            for (Locator locator : locatorList) {
                String locValue = locator.innerText();
                //System.out.println("locator value: " + locValue);
                if (locValue.equalsIgnoreCase(value)) {
                    logger.info("Located the element: " + value);
                    locator.scrollIntoViewIfNeeded();
                    locator.click();
                    logger.info("Selected the element: " + value + " from the list");
                    page.waitForLoadState(LoadState.DOMCONTENTLOADED);
                    break;
                }
            }
        } else {
            if (page.locator(searchField).isEnabled()) {
                page.click(searchField);
                logger.info("Selected the element: " + searchField + " from the list");
            }
        }
    }
    public Locator getLocatorByText(String text) {
        return page.getByText(text);
    }

    public void verifiesThatTheToastMessageIsDisplayed(String TOAST_MESSAGE, String toastMsg) {

        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        Locator toast = page.locator(TOAST_MESSAGE);
        Locator getByText = getLocatorByText(toastMsg);
        //RetryPolicy<Object> retryPolicy = BasePage.createRetryPolicy(1, 10);
        if (toast.isVisible()) {
            logger.info("Expected is: " + toastMsg);
            logger.info("Actual is: " + toast.innerText());
            Assert.assertTrue(toast.innerText().contains(toastMsg));
            toast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.DETACHED));
        } else {
            logger.info("Expected is: " + toastMsg);
            logger.info("Actual is: " + toast.innerText());
            Assert.assertTrue(getByText.innerText().contains(toastMsg));
            getByText.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.DETACHED));
        }
    }

    public void waitForElementToDisappear(String selector) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.locator(selector).waitFor(new Locator.WaitForOptions()
                .setTimeout(180000)
                .setState(WaitForSelectorState.DETACHED));
    }

    public void hoverOverElement(String ele) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        List<Locator> locList = page.locator(ele).all();
        if (locList.size() > 1) {
            for(Locator loc : locList){
                if(loc.isVisible() && loc.isEnabled()){
                    loc.hover(new Locator.HoverOptions().setForce(true));
                    break;
                }
            }
        } else {
            page.locator(ele).hover(new Locator.HoverOptions().setForce(true));
            logger.info("Hovered to the element: " + ele);
        }
    }
    public void hoverOverElementByText(String text) {
        String locator = "//span[normalize-space(text())='" + text + "']";
        page.locator(locator).hover(new Locator.HoverOptions().setForce(true));
        System.out.println("Hovered over the element with text: " + text);
    }


    public void verifiesValidationMessage(String VALIDATION_MESSAGE, String message) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        Locator validationPop = page.locator(VALIDATION_MESSAGE);
        Locator getByText = getLocatorByText(message);
        if (validationPop.isVisible()) {
            logger.info("Expected is: " + message);
            logger.info("Actual is: " + validationPop.innerText());
            System.out.println("Matches Actual and expected");
            Assert.assertTrue(validationPop.innerText().contains(message));
        } else {
            logger.info("Expected is: " + message);
            logger.info("Actual is: " + validationPop.innerText());
            System.out.println("Not Matching Actual and expected");
            Assert.assertFalse(getByText.innerText().contains(message));
            }
    }
    public void dragAndDrop(String source, String target) {
        page.waitForSelector(source);
        page.waitForSelector(target);
        page.locator(source).dragTo(page.locator(target));
        logger.info("Dragged the element: " + source + " to: " + target);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public void dragAndDropwithLocatorText(String source, String target,String text) {

        page.waitForSelector(source);
        page.waitForSelector(target);
        page.locator(source).locator("text=" +text).dragTo(page.locator(target));
        logger.info("Dragged the element: " + source + " to: " + target);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public void getLocatorByRunTimeText(String xpath,String text){
        page.locator(String.format(xpath, text)).click();
        logger.info("Clicked on element with text: " + text);

    }

    public void verifyText(String locator, String text) {
        Locator ele = page.locator(locator);
        String eleText= ele.innerText();
        if(ele.isVisible()) {
            if (eleText.equalsIgnoreCase(text)){
                logger.info("Text displayed: " + text); }
            else {
                Assert.fail("Text not found");
                logger.info("Text not displayed as: " + text); } }
        else {
            Assert.fail("Element Not Visible:" +text); }
        }


    public void switchToParentWindow() {
        List<Page> pages = page.context().pages();
        if (!pages.isEmpty()) {
            Page parentPage = pages.get(0);
            parentPage.bringToFront();
            this.page = parentPage;
            System.out.println("Switched to the parent window.");
        } else {
            throw new RuntimeException("No parent window found.");
        }
    }
    public void closeCurrentWindowAndSwitchToParent() {
        List<Page> pages = page.context().pages();
        if (pages.size() > 1) {
            Page currentPage = page;
            Page parentPage = pages.get(0);
            currentPage.close();
            if (!parentPage.isClosed()) {
                parentPage.bringToFront();
                this.page = parentPage;
                System.out.println("Switched to the parent window.");
            } else {
                throw new RuntimeException("Parent window is already closed.");
            }
        } else {
            throw new RuntimeException("No other window to switch to.");
        }
    }
    public boolean isChecked(String ele){
        return page.locator(ele).isChecked();
    }
    public void uncheckCheckbox(String ele){
        page.locator(ele).uncheck();
    }
    public void keyboardInput(String key) {
        page.keyboard().press(key);
    }
    public int getElementsCount(String ele){
        waitForElement(ele);
        return page.locator(ele).all().size();
    }

    public void VerifyElementWithByText(String Text) {
        List<Locator> list = getLocatorByText(Text).all();

       if (!list.isEmpty()) {
            boolean elementFound = false;
           for (Locator loc : list) {
                if (loc.isVisible()) {
                   String elementText = loc.innerText();
                    if (elementText.equalsIgnoreCase(Text)) {
                        logger.info("Found element with Text: " + Text);
                        elementFound = true;
                        break;
                    }
                }
            }
   if (!elementFound) {
                logger.warn("No visible element found with Text: " + Text);
                Assert.fail();
            }
        } else {
            logger.warn("Element not found with Text: " + Text);
           Assert.fail();
        }
    }



    public void hoverOnTableInDatabaseObjectsPane(String tableName) {
        String sourceXpath = String.format("//*[@class='k-table k-grid-table k-table-md']//tr//span[normalize-space(text())='%s']", tableName);
        hoverOverElement(sourceXpath);
    }

    public String getTrimmedText(String eleText){
        String trimmedText = getText(eleText).replaceAll("\\u00A0", " ");
        System.out.println("Updated query after removing white spaces: \n" + trimmedText);
        System.out.println("Actual text is : " + eleText);
        return trimmedText;

    }


    public String selectRandomValueFromDropdown(String dropdown,String dropdownValueList) throws InterruptedException {
        Thread.sleep(2000);
        String selectedValue = getText(dropdown);
        click(dropdown);
        logger.info("Selected the dropdown: " + dropdown);
        Thread.sleep(3000);
        List<Locator> locatorList = page.locator(dropdownValueList).all();
        String locValue = null;
        for (Locator locator : locatorList) {
            locValue = locator.innerText();
            //System.out.println("locator value: " + locValue);
            if (!(locValue.equalsIgnoreCase(selectedValue))) {
                locator.scrollIntoViewIfNeeded();
                locator.click();
                logger.info("Selected the value : " + locValue + " from the dropdown");
                page.waitForLoadState(LoadState.DOMCONTENTLOADED);
                break;
            }
        }
        return locValue;
    }

    public void waitUntilThatTheLoaderIsDetached(String loader) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        Locator toast = page.locator(loader);
        if (toast.isVisible()) {
            toast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.DETACHED)
                    .setTimeout(100000));
        }
    }
    public List<String> getElementsTextList(String locator) {
        List<String> textPresenceList = new ArrayList<>();
        List<Locator> elements  =page.locator(locator).all();

        for (Locator element : elements) {
            String text = element.textContent();
            textPresenceList.add(text.trim());
        }
        return textPresenceList;
    }
    public boolean verifyMenuListItemsAll() {

        List<String> actualTableList = getElementsTextList(getLocator("lov_table"));
        if (actualTableList.isEmpty()) {
            System.out.println("No items found in the menu.");
            return false;
        }
        System.out.println("Total items found: " + actualTableList.size());
        System.out.println("Menu items: " + actualTableList);

        return true;
    }
    public boolean verifyTableHeaderItemsAll() {

        List<String> actualTableList = getElementsTextList(getLocator("table_header_list"));
        if (actualTableList.isEmpty()) {
            System.out.println("No items list is present in the table header menu.");
            return false;
        }
        System.out.println("Total items found: " + actualTableList.size());
        System.out.println("Menu items: " + actualTableList);
       click(getLocator("filter_header_table"));
        List<String> actualFilterList = getElementsTextList(getLocator("table_filter_list"));
        if (actualFilterList.isEmpty()) {
            System.out.println("No filter options available.");
            return false;
        }
        System.out.println("Total filter options found: " + actualFilterList.size());
        System.out.println("Filter options: " + actualFilterList);
        return true;
    }


    public boolean verifyTableTypeByText(String tableName, String expectedType) {

        String tableNameXPath = "//*[normalize-space(text())='" + tableName + "']";
        String tableTypeXPath = "//*[normalize-space(text())='" + expectedType + "']";
        if (page.isVisible(tableNameXPath) && page.isVisible(tableTypeXPath)) {
            System.out.println("Verified: Table Name '" + tableName + "' has Type '" + expectedType + "'");
            return true;
        } else {
            System.out.println("Verification failed: Table Name '" + tableName + "' does not have Type '" + expectedType + "'");
            return false;
        }
    }

    public boolean verifyElementsAreNotEmptyInList(String loc){
      List<Locator> eleList=page.locator(loc).all();
      boolean flag= !eleList.isEmpty();
        return flag;
    }
    public void verifiesValidateMessage(String VALIDATION_MESSAGE, String message) {

        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        Locator validationPop = page.locator(VALIDATION_MESSAGE);

        int count = validationPop.count();
        System.out.println("DEBUG: Validation message locator found: " + count + " times.");

        try {
            validationPop.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
        } catch (Exception e) {
            System.out.println("❌ Validation message did not appear within timeout.");
            Assert.fail("Validation message is not visible: " + message);
            return;
        }

        // Check the inner text of the validation message
        String actualMessage = validationPop.innerText().trim();
        String expectedMessage = message.trim();

        logger.info("Expected: [" + expectedMessage + "]");
        logger.info("Actual:   [" + actualMessage + "]");

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("✅ Matches Actual and Expected");
        } else {
            System.out.println("❌ Not Matching: Actual and Expected are different!");
            Assert.fail("Validation message mismatch!");
        }
    }

    public boolean isEnabled(String locatorKey) {
        Locator element = page.locator(locatorKey); // Convert String to Locator
        return element.isVisible() && element.isEnabled();
    }
    public boolean isVisible(String locatorKey) {
        Locator element = page.locator(getLocator(locatorKey));
        return element.isVisible();
    }

    public List<Locator> getElementsList(String locator){
        return page.locator(locator).all();
    }

    public void hoverAndClick(String hoverLocator, String clickLocator) {
        Locator elementToHover = page.locator(getLocator(hoverLocator));
        Locator elementToClick = page.locator(getLocator(clickLocator));
        elementToHover.hover(new Locator.HoverOptions().setForce(true));
        System.out.println("Hovered over the element: " + hoverLocator);
        page.waitForCondition(() -> elementToClick.isVisible(), new Page.WaitForConditionOptions().setTimeout(5000));
        elementToClick.click(new Locator.ClickOptions().setForce(true));
        System.out.println("Clicked on the element: " + clickLocator);
    }



}
