package pramodpoojary.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pramodpoojary.pageObjects.MyCartPage;
import pramodpoojary.pageObjects.ordersPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink=\"/dashboard/cart\"]")
	WebElement cartButton;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orders;

	public void waitForElementToDisAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));

	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(findBy)));

	}

	public MyCartPage navigateToCart() {
		cartButton.click();

		MyCartPage myCartPage = new MyCartPage(driver);
		return myCartPage;
	}

	public ordersPage navigateToOrders() {
		orders.click();
		ordersPage ordersPage = new ordersPage(driver);
		return ordersPage;

	}
}
