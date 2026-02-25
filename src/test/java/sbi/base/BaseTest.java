package com.qa.sbi.base;

import java.io.*;
import java.util.Hashtable;
import java.util.Properties;
import com.github.javafaker.Faker;
import com.google.gson.*;
import com.qa.sbi.pages.admin.SetupPage;
import com.qa.sbi.pages.domain.DomainEditPage;
import com.qa.sbi.pages.domain.TableEditPage;
import com.qa.sbi.pages.reports.ReportCreatePage;
import com.qa.sbi.pages.WorkspacePage;
import com.qa.sbi.pages.admin.AdminPage;
import com.qa.sbi.pages.admin.UsersPage;
import com.qa.sbi.pages.domain.DomainCreatePage;
import com.qa.sbi.pages.reports.ReportSubmitPage;
import org.testng.Assert;
import org.testng.annotations.*;
import com.microsoft.playwright.Page;
import com.qa.sbi.factory.PlaywrightFactory;
import com.qa.sbi.pages.HomePage;
import com.qa.sbi.pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected AdminPage adminPage;
	protected UsersPage userPage;
	protected DomainCreatePage domCreatePage;
	protected WorkspacePage workSpacePage;
	protected ReportCreatePage reportCreatePage;
	protected TableEditPage tableEditPage;
	protected ReportSubmitPage reportSubmitPage;
	protected DomainEditPage domainEditPage;
	protected SetupPage setupPage;
	public static String testDataPath="src/test/resources/testdata/";
	private static final String LOG_FILE_PATH = "consoleLogs.log";
	Faker faker = new Faker();

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(@Optional String browserName) {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		loginPage = new LoginPage(page);
		adminPage = new AdminPage(page);
		userPage = new UsersPage(page);
		domCreatePage=new DomainCreatePage(page);
		workSpacePage=new WorkspacePage(page);
		reportCreatePage=new ReportCreatePage(page);
		domainEditPage=new DomainEditPage(page);
		setupPage=new SetupPage(page);
		reportSubmitPage=new ReportSubmitPage(page);
		tableEditPage=new TableEditPage(page);
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}

	@AfterTest
	public void tearDown() {
		try {
				page.context().browser().close();
		} catch (Exception e) {
			System.err.println("Error closing browser: " + e.getMessage());
		}
	}

	@BeforeSuite
	public static void clearLogFile() {
		File logFile = new File(LOG_FILE_PATH);

		if (logFile.exists()) {
			try {
				new FileWriter(logFile, false).close();
				System.out.println("Log file cleared: " + LOG_FILE_PATH);
			} catch (IOException e) {
				System.err.println("Error while clearing log file: " + e.getMessage());
			}
		} else {
			System.out.println("Log file does not exist, no need to clear.");
		}
	}

	public static Object[][] getTestData(String module,String jsonFileName, String testCaseName){
		String filePath=testDataPath+module+"/"+jsonFileName+".json";
		Gson gson = new GsonBuilder().create();
		JsonObject job = null;
		try {
			job = gson.fromJson(new FileReader(filePath), JsonObject.class);
		} catch (JsonSyntaxException | FileNotFoundException | JsonIOException e) {
			e.printStackTrace();
		}
		JsonElement cate= job.getAsJsonArray(testCaseName);
		int trows= job.getAsJsonArray(testCaseName).size();
		System.out.println("Total Rows: "+trows);
		Hashtable<String, String> table=null;
		int index=0;
		Object[][] data =new Object[trows][1];
		System.out.println("============================================================================================================================");
		for(int rowNum=0;rowNum<trows;rowNum++) {
			JsonElement rowData= job.getAsJsonArray(testCaseName).get(rowNum);
			String values=rowData.toString().substring(1, rowData.toString().length()-1);
			String[] splitvalues= values.split("\",");
			System.out.println("Total Columns: "+splitvalues.length);
			table=new Hashtable<String, String>();
			for(int c=0;c<splitvalues.length;c++) {
				if(c<splitvalues.length-1) {
					table.put(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length()), splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()));
					System.out.println(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length())+"=="+splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()));
				}else {
					table.put(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length()), splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()-1));
					System.out.println(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length())+"=="+splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()-1));
				}
			}
			data[index][0]=table;
			index++;
		}
		System.out.println("===========================================================================================================================");
		return data;
	}

	public String randomStringGenerator(int size){
        return faker.lorem().characters(size);
    }
	public String randomFirstNameGenerator(){
		return faker.name().firstName();
	}
	public String randomLastNameGenerator(){
		return faker.name().lastName();
	}
	public String randomPasswordGenerator(){
		return faker.internet().password(8, 12);
	}
	public String randomEmailGenerator(){
		return faker.internet().emailAddress();
	}

}
