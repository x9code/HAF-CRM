package com.vtigercrm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Elements
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusIcon;
	@FindBy(name = "accountname")
	private WebElement orgName;
	@FindBy(id = "phone")
	private WebElement phone;
	@FindBy(id = "email1")
	private WebElement email;
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	@FindBy(name = "bill_street")
	private WebElement billAddress;
	@FindBy(name = "ship_street")
	private WebElement shipAddress;
	@FindBy(id = "bill_city")
	private WebElement billCity;
	@FindBy(id = "ship_city")
	private WebElement shipCity;
	@FindBy(name = "bill_state")
	private WebElement billState;
	@FindBy(id = "ship_state")
	private WebElement shipState;
	@FindBy(name = "description")
	private WebElement desc;
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	@FindBy(xpath = "//input[@value='Cancel  ']")
	private WebElement cancelBtn;
	
	//Getters
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getIndustry() {
		return industryDropdown;
	}
	public WebElement getBillAddress() {
		return billAddress;
	}
	public WebElement getShipAddress() {
		return shipAddress;
	}
	public WebElement getBillCity() {
		return billCity;
	}
	public WebElement getShipCity() {
		return shipCity;
	}
	public WebElement getBillState() {
		return billState;
	}
	public WebElement getShipState() {
		return shipState;
	}
	public WebElement getDesc() {
		return desc;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
}
