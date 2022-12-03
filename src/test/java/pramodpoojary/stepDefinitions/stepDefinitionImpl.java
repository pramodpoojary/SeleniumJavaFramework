package pramodpoojary.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pramodpoojary.pageObjects.LandingPage;
import pramodpoojary.pageObjects.MyCartPage;
import pramodpoojary.pageObjects.ProductCatalog;
import pramodpoojay.testcomponents.BaseTest;

public class stepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public MyCartPage myCartPage;

	@Given("the user is on Ecommerce page")
	public void userLandsOnEcommercePage() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^the user logged in with (.+) and (.+)$")
	public void loginWithUsernameAndPassword(String username, String password) {
		productCatalog = landingPage.loginApplication(username, password);

	}

	@When("^I add product (.+)$")
	public void addProductToCart(String productName) {
		List<WebElement> products = productCatalog.productList();
		productCatalog.addProductToCart(productName);
	}

	@And("^Checkout (.+) and Submit the order$")
	public void checkoutAndSubmitOrder(String productName) {
		myCartPage = productCatalog.navigateToCart();
		Assert.assertTrue(myCartPage.productFoundInCart(productName));
		myCartPage.checkoutWithAddress("India");
	}

	@Then("Order gets placed")
	public void oderPlaced() {
		System.out.println(myCartPage.getOrderId());
		driver.close();
	}

	@Then("{string} message is displayed")
	public void errorMessageValidation(String errorMessage) {
		Assert.assertEquals(errorMessage, landingPage.getErrorMessage());
		driver.close();
	}
}
