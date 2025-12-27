package com.vtigercrm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.utility.SeleniumUtility;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	@FindBy (linkText = "Sign Out")
	private WebElement signoutLink;
	@FindBy (linkText = "Organizations")
	private WebElement orgLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getAdminIcon() {
		return adminIcon;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void signOut(WebDriver driver) {
		SeleniumUtility su = new SeleniumUtility();
		su.hover(driver, adminIcon);
		HomePage hp = new HomePage(driver);
		hp.getSignoutLink().click();
	}

}
