package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrwoserFactory;
import util.ReadExcel;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ReadExcel exlread = new ReadExcel("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String emailName = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		
		driver = BrwoserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboarPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboarPage.varifyDashboarPage();
		dashboarPage.clickCustomerButton();
		dashboarPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompanyName(companyName);
		addCustomerPage.enterEmail(emailName);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddCustomerPage();
		
		dashboarPage.clickListCustmerButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
		//BrwoserFactory.tearDown();
	}

}
