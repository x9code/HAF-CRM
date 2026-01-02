package com.vtigercrm.tests;

//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtigercrm.objectRepository.HomePage;
import com.vtigercrm.generic.BaseClass;
import com.vtigercrm.generic.TestListener;


@Listeners(TestListener.class)
public class LoginTest extends BaseClass {
	
	@Test
	public void HomeTest() {
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		//Assert.fail();
	}
}
