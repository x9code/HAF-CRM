package com.vtigercrm.objectRepository;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.utility.FileUtility;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(name = "user_name")
	private WebElement nameField;
	@FindBy(name = "user_password")
	private WebElement passField;
	@FindBy (id="submitButton")
	private WebElement loginButton;
	
	public WebElement getNameField() {
		return nameField;
	}
	public WebElement getPassField() {
		return passField;
	}
	public WebElement getloginButton() {
		return loginButton;
	}
	public void login(WebDriver driver) throws IOException {
		FileUtility p = new FileUtility();
		LoginPage lp = new LoginPage(driver);
		lp.getNameField().sendKeys(p.readCommonData("username"));
		lp.getPassField().sendKeys(p.readCommonData("password"));
		lp.getloginButton().click();
	}
}
