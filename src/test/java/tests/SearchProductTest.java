package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrderProductpage;


public class SearchProductTest extends InitialTest {

	
	OrderProductpage searchProductObject;
	LoginPage loginObject;

	@Test()
	public void searchBlouses() {
	
		searchProductObject =new OrderProductpage(driver);
		
		searchProductObject.searchforProduct();
	
	}
	@Test(dependsOnMethods = "searchBlouses")
	public void SelectResultedProduct() throws InterruptedException {
		
		searchProductObject.selectblouse();
		
	}
		
	@Test (dependsOnMethods = "SelectResultedProduct")
	public void checkProceedCheckOutsuccessfully() throws InterruptedException {
		
		searchProductObject.Checkout();
		Assert.assertTrue(searchProductObject.orderconfirmation.getText().equals("Your order on My Store is complete."));
		Thread.sleep(3000);
	}
}
