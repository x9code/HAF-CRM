package com.vtigrtcrm.generic;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.vtigercrm.objectRepository.HomePage;
import com.vtigercrm.objectRepository.LoginPage;
import com.vtigercrm.objectRepository.OrganizationPage;
import com.vtigercrm.utility.FileUtility;
import com.vtigercrm.utility.SeleniumUtility;

public class BaseClass {
	public static WebDriver driver;
	SeleniumUtility su = new SeleniumUtility();
	FileUtility p = new FileUtility();
	public OrganizationPage org;
	public HomePage hp;
	
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected successfully",true);
	}
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		su.maximize(driver);
		driver.get(p.readCommonData("url"));
		Reporter.log("browser launched",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.login(driver);
		org = new OrganizationPage(driver);
		hp = new HomePage(driver);
		Reporter.log("signed in successfully",true);
	}
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		Reporter.log("signed out successfully",true);
	}
	@AfterTest
	public void closeBrowser() {
		if(driver != null) {
			driver.quit();
		}
		Reporter.log("browser closed",true);
	}
	@AfterSuite
	public void disconnect() {
		Reporter.log("database disconnected successfully",true);
	}
}
