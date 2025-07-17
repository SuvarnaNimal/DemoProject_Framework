package test;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobject.LoginPage;
import pageobject.SearchPage;
import utilities.ReadConfig;

public class LoginTest extends BaseClass {
	LoginPage lp;

	@Test(priority = 0, dataProvider = "loginData")
	public void SignInDetail(String emailid, String password) throws InterruptedException {
		lp = new LoginPage(driver); //this is for login page
		lp.clickOnSignInbtn();
		lp.enterEmailId(emailid);
		lp.enterpass(password);
		lp.signinbtnclick();
		Thread.sleep(3000);
		lp.closePopupIfPresent();
		Thread.sleep(2000);
		lp.navigationLogin();
		
		SearchPage sp = new SearchPage(driver);
		sp.scrolldown();
		sp.searchAndClickFourthOption();
		Thread.sleep(5000);
		sp.clicktryityourselft();
		Thread.sleep(3000);
		sp.clearcode();
	}
	

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword() } };
	}
	

}