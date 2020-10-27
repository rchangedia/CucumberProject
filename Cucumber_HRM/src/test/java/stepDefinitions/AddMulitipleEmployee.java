package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddMulitipleEmployee {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the OrangeHRM​ page and login with the given credentials$")
	public void openBrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);

		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();

		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("orange");

		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

		driver.findElement(By.id("btnLogin")).click();
	}
	
	@When("^Find the PIM option in the menu and click it$")
	public void navigateToPIMPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_dashboard_index")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_viewPimModule")));
		WebElement dashboardLink = driver.findElement(By.id("menu_dashboard_index"));
		WebElement pimLink = driver.findElement(By.id("menu_pim_viewPimModule"));

		if (dashboardLink.isDisplayed()) {

			pimLink.click();

		} else {

			dashboardLink.click();
			pimLink.click();
		}
		
		Thread.sleep(3500);
	}
	
	@Then("^Click the Add button to add a new Employee$")
	public void clickOnAddButton() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	}
	
	@And("^Make sure the Create Login Details checkbox is checked$")
	public void checkTheCreateLoginDetailsCheckBox() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("chkLogin")));
		driver.findElement(By.id("chkLogin")).click();
	}
	
	@Then("^Fill in the \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" and click Save$")
	public void fillAddEmployeeForm(String firstName, String lastName, String userName, String password, String confirmPassword) {
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys(userName);
		
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(password);
		
		driver.findElement(By.id("re_password")).clear();
		driver.findElement(By.id("re_password")).sendKeys(confirmPassword);		
		
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Then("^Verify that the employees have been created \"(.*)\"$")
	public void verifyEmployeeCreation(String employeeName) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='profile-pic']/h1")));
		String actualEmployeeName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		Assert.assertEquals(actualEmployeeName, employeeName);
	}
	
	@And("^Close Browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}
}




	

