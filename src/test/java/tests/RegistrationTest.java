package tests;

import com.github.javafaker.Faker;
import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends InitialTest {

	HomePage homePageObject;
	RegistrationPage registrationPageObj;
	LoginPage loginObject;

	Faker fakeDataObj = new Faker();
	String Email1 = LoadProperties.userInfo.getProperty("Email");
	String firstname = fakeDataObj.name().firstName();
	String lastname = fakeDataObj.name().lastName();
	String email = Email1.concat(fakeDataObj.internet().emailAddress());
	String password = fakeDataObj.number().digits(8).toString();
	String postcode = fakeDataObj.number().digits(5).toString();
	String phone_number = fakeDataObj.phoneNumber().cellPhone();
	String city = fakeDataObj.address().city();
	String address = fakeDataObj.address().streetName() ;

	// user Rediret To Sign in page
	@Test(priority = 1, alwaysRun = true)

	public void rediretToSiginpage()  	{

		homePageObject = new HomePage(driver);
		homePageObject.openSigninPage();
	}

	// user Enter Data To Register
	@Test(dependsOnMethods = "rediretToSiginpage")

	public void userRegister() {

		registrationPageObj = new RegistrationPage(driver);
		registrationPageObj.createclick(email);
		registrationPageObj.userSignUp(firstname, lastname, password, postcode, address, city, phone_number);
		System.out.println(email);
	}

	@Test(dependsOnMethods = "userRegister")
	public void checkuserRegister() {
		
		Assert.assertTrue(registrationPageObj.signout.getText().equals("Sign out"));
		
	}

	@Test(dependsOnMethods = "userRegister")
	public void userLogOut() {
		registrationPageObj.userLogout();
		Assert.assertTrue(homePageObject.signin.getText().equals("Sign in"));
	}

	@Test(dependsOnMethods = "userLogOut")
	public void checkuserlogin()  {

		homePageObject.openSigninPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registrationPageObj.signout.getText().equals("Sign out"));

	}
}
