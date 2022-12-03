package pramodpoojary.SeleniumFrameworkDesign;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pramodpoojary.pageObjects.LandingPage;

public class standalonetest {

	public static void main(String[] args) {
		
		String productName = "ZARA COAT 3";
		String countryName = "India";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		LandingPage landingPage=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("pramod@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pramod123");
		driver.findElement(By.id("login")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner/div/div/div"))));
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart']//h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(countryName);
		driver.findElement(By.xpath("(//button/span[contains(text(),'India')])[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		String orderId = driver.findElement(By.xpath("//tbody/tr[3]/td/label[1]")).getText().replace("|", "").trim();
		System.out.println(orderId);

		driver.quit();
	}
}
