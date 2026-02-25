package com.qa.sbi.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Properties;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.qa.sbi.constants.AppConstants.PAGE_LOAD_TIMEOUT;
import static com.qa.sbi.constants.AppConstants.PAGE_NAVIGATION_TIMEOUT;

public class PlaywrightFactory {

	Properties prop;

	private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static final ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}
	public Page initBrowser(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		tlPlaywright.set(Playwright.create());

		switch (browserName.toLowerCase()) {
		case "chromium":
			getChromium();
			break;
		case "firefox":
			getFirefox();
			break;
		case "safari":
			getSafari();
			break;
		case "chrome":
			getChrome();
			break;
		case "edge":
			getEdge();
			break;
		default:
			System.out.println("Please Pass the Right BrowserName......");
			break;
		}
		tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions()
				        .setAcceptDownloads(true)
				        .setViewportSize(null)));
		tlPage.set(getBrowserContext().newPage());
		getPage().setDefaultTimeout(PAGE_LOAD_TIMEOUT);
		getPage().setDefaultNavigationTimeout(PAGE_NAVIGATION_TIMEOUT);
		BasePage basePage = new BasePage(getPage());
		basePage.navigate(prop.getProperty("url").trim());
		return getPage();

	}
	public void getChrome() {
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		tlBrowser.set(
				getPlaywright().chromium().launch(new BrowserType.LaunchOptions()
						.setChannel("chrome")
						.setHeadless(false)
						.setArgs(arguments)));
	}
	public void getChromium() {
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setArgs(arguments)));
	}

	public void getFirefox() {
		tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions()
				.setHeadless(false)));
	}

	public void getSafari() {
		tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions()
				.setHeadless(false)));
	}

	public void getEdge() {
		tlBrowser.set(
				getPlaywright().chromium().launch(new BrowserType.LaunchOptions()
						.setChannel("msedge")
						.setHeadless(false)));
	}


	/**
	 * this method is used to initialize the properties from config file
	 */
	public Properties init_prop() {

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
			ip.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * take screenshot
	 * 
	 */

	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return Base64.getEncoder().encodeToString(buffer);
	}

}
