package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderHistoryPage;
import pages.OrderProductpage;

public class OrderHistoryTest extends InitialTest {

	HomePage homePageObject ;
	OrderHistoryPage OrderhistoryObject;
	LoginPage loginPageObject;
	OrderProductpage selectObject;
	
	@Test
	public void orderFromHistory() throws InterruptedException{

		homePageObject = new HomePage(driver);
		homePageObject.openhistroypage();
		OrderhistoryObject = new OrderHistoryPage(driver);
		OrderhistoryObject.reorder();
		selectObject =new OrderProductpage(driver);
		selectObject.reorderCheckout();
		Assert.assertTrue(OrderhistoryObject.orderconfirmtxt.getText().equals("Your order on My Store is complete."));
		Thread.sleep(3000);
	}
	
}
