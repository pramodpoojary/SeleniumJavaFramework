package pramodpoojary.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pramodpoojary.AbstractComponents.AbstractComponents;

public class MyCartPage extends AbstractComponents {

	WebDriver driver;

	public MyCartPage(WebDriver driver) {
		super(driver);
		// initialiation
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart']//h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selecctCountry;

	@FindBy(xpath = "(//button/span[contains(text(),'India')])[2]")
	WebElement selectFromDropDown;

	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement placeOrder;

	@FindBy(xpath = "//tbody/tr[3]/td/label[1]")
	WebElement orderID;

	public List<WebElement> cartProductList() {
		return cartProducts;
	}

	public Boolean productFoundInCart(String productName) {
		Boolean match = cartProductList().stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public void checkoutWithAddress(String country) {
		checkOut.click();
		selecctCountry.sendKeys(country);
		selectFromDropDown.click();
		placeOrder.click();
	}

	public String getOrderId() {

		return orderID.getText().replace("|", "").trim();
	}

}
