package com.vtigercrm.tests;

//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtigercrm.objectRepository.HomePage;
import com.vtigrtcrm.generic.BaseClass;
import com.vtigrtcrm.generic.ListenerImplementation;


@Listeners(ListenerImplementation.class)
public class LoginTest extends BaseClass {
	
	@Test
	public void HomeTest() {
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		//Assert.fail();
	}
}
