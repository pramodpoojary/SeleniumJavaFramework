package pramodpoojary.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pramodpoojary.pageObjects.MyCartPage;
import pramodpoojary.pageObjects.ProductCatalog;
import pramodpoojay.testcomponents.BaseTest;
import pramodpoojay.testcomponents.RetryTest;

public class errorValidation extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = RetryTest.class)
	public void errorMessageValidation() throws IOException {

		landingPage.loginApplication("pramod@gmail.com", "Pramod1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test(retryAnalyzer = RetryTest.class)
	public void errorMessageProdcut() throws IOException {

		String productName = "ZARA COAT 3";
		String countryName = "India";
		ProductCatalog productCatalog = landingPage.loginApplication("pramodpoojary@gmail.com", "Pramod123");
		productCatalog.addProductToCart(productName);
		MyCartPage myCartPage = productCatalog.navigateToCart();
		Assert.assertTrue(myCartPage.productFoundInCart("COAT 333"));
	}
}
