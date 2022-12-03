package pramodpoojary.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pramodpoojary.AbstractComponents.AbstractComponents;

public class ordersPage extends AbstractComponents {

	WebDriver driver;

	public ordersPage(WebDriver driver) {
		super(driver);
		// initialiation
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "//tbody/tr/td[2]")
	List<WebElement> orders;

	public List<WebElement> orderList() {
		return orders;
	}

	public Boolean verifyOrderDisplay(String productNames) {
		System.out.println(orders);
		Boolean match = orders.stream().anyMatch(order -> order.getText().equalsIgnoreCase(productNames));
		return match;
	}
}
