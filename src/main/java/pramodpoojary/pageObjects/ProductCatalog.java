package pramodpoojary.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pramodpoojary.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		// initialiation
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement userEmailElement = driver.findElement(By.id("userEmail"));

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	// pagefactory
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	

	By productsBy = By.cssSelector(".mb-3");
	By addToCartBy = By.cssSelector(".card-body button:last-of-type");

	By spinnerBy = By.xpath("//ngx-spinner/div/div/div");

	public List<WebElement> productList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = productList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {
		getProductByName(productName).findElement(addToCartBy).click();
		waitForElementToDisAppear(spinnerBy);
	}

	
}
