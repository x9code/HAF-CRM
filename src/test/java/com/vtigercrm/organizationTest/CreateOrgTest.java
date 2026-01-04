package com.vtigercrm.organizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtigercrm.generic.TestListener;
import com.vtigercrm.utility.FileUtility;
import com.vtigercrm.utility.SeleniumUtility;
import com.vtigercrm.generic.BaseClass;


@Listeners(TestListener.class)
public class CreateOrgTest extends BaseClass {
	FileUtility f = new FileUtility();
	SeleniumUtility s = new SeleniumUtility();
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException {
		hp.getOrgLink().click();
		org.getPlusIcon().click();
		org.getOrgName().sendKeys(f.excelReader("organization",2, 0));
		org.getPhone().sendKeys(f.excelReader("organization",2, 1));
		org.getEmail().sendKeys(f.excelReader("organization",2, 2));
		org.getBillAddress().sendKeys(f.excelReader("organization",2, 4));
		org.getShipAddress().sendKeys(f.excelReader("organization",2, 5));
		org.getBillCity().sendKeys(f.excelReader("organization",2, 6));
		org.getShipCity().sendKeys(f.excelReader("organization",2, 7));
		org.getBillState().sendKeys(f.excelReader("organization",2, 8));
		org.getShipState().sendKeys(f.excelReader("organization",2, 9));
		org.getDesc().sendKeys(f.excelReader("organization",2, 10));
		s.selectByContainsVisibleText(org.getIndustry(), f.excelReader("organization",2, 3));
		org.getCancelBtn().click();
	}
}
