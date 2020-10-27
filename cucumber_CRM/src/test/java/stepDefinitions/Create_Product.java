package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Create_Product {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the browser to the ​Alchemy CRM​ site and login with the credentials$")
	public void openBrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);

		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();

		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("username_password")).clear();
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");

		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^Navigate to All -> Products-> Create Product$")
	public void navigateToCreateProduct() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dashlet-title")));
		WebElement salesLink = driver.findElement(By.id("grouptab_5"));
		
		Actions action = new Actions(driver);
		action.moveToElement(salesLink).build().perform();
		
		driver.findElement(By.linkText("Products")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Create Product']")));
		driver.findElement(By.xpath("//div[text()='Create Product']")).click();
	}

	@And("^Enter the details of the product \"(.*)\"$")
	public void fillProductDetails(String productName) throws InterruptedException {
		Thread.sleep(3500);
		
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(productName);
 	}
	
	@Then("^Click Save button$")
	public void clickOnSaveButton() {
		driver.findElement(By.id("SAVE")).click();
	}
	
	@And("^Go to the View Products page to see all products listed \"(.*)\"$")
	public void navigateToViewLeads(String productName) throws InterruptedException {
		Thread.sleep(3500);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='View Products']")));
		driver.findElement(By.xpath("//div[text()='View Products']")).click();
		
		Thread.sleep(3500);
		
		String actualProductName = driver.findElement(By.linkText(productName)).getText();
		
		Assert.assertEquals(actualProductName, productName);
	}
	
	@And("^Close browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}
}
