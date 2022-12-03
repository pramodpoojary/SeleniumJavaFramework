package pramodpoojary.SeleniumFrameworkDesign;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pramodpoojary.pageObjects.MyCartPage;
import pramodpoojary.pageObjects.ProductCatalog;
import pramodpoojary.pageObjects.ordersPage;
import pramodpoojay.testcomponents.BaseTest;
import pramodpoojay.testcomponents.RetryTest;

public class submitOrder extends BaseTest {

	@Test(dataProvider = "getData", groups = "purchase", retryAnalyzer = RetryTest.class)
	public void submitOrders(HashMap<String, String> input) throws IOException {

		String countryName = "India";
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalog.productList();
		productCatalog.addProductToCart(input.get("productName"));
		MyCartPage myCartPage = productCatalog.navigateToCart();
		Assert.assertTrue(myCartPage.productFoundInCart(input.get("productName")));
		myCartPage.checkoutWithAddress(countryName);
		System.out.println(myCartPage.getOrderId());
	}

	// verify placed order is displaying in order history
	@Test(dependsOnMethods = { "submitOrders" }, retryAnalyzer = RetryTest.class)
	public void orderHistory() {
		String productName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingPage.loginApplication("pramod@gmail.com", "Pramod123");
		ordersPage ordersPage = productCatalog.navigateToOrders();
		Assert.assertFalse(ordersPage.verifyOrderDisplay(productName));
	}

	// Extent Reports

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//pramodpoojary//data//purhcaseorder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
