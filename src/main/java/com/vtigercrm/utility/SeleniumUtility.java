package com.vtigercrm.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import freemarker.template.Template.WrongEncodingException;

public class SeleniumUtility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void impliWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void hover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void selectByContainsVisibleText(WebElement address, String text) {
		Select select = new Select(address);
		select.selectByContainsVisibleText(text);
	}

}
