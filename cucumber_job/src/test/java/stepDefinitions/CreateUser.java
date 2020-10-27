package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUser {
	WebDriver driver;
    WebDriverWait wait;

@Given("^User is on Login page$")
public void loginPage() {
    //Setup instances
	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 15);

	
    //Open browser
    driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
    driver.manage().window().maximize();
}

@When("^User enters username and password$")
public void enterCredentials() {
    //Enter username
    driver.findElement(By.id("user_login")).sendKeys("root");
    //Enter password
    driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    //Click Login
    driver.findElement(By.id("wp-submit")).click();
}
    
  @Then("^Add new User$")
  public void add_new_user() {
    Actions actions = new Actions(driver);
    //Retrieve WebElement 'User' to perform mouse hover 
	WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Users')]"));
	//Mouse hover menuOption 'Users'
	actions.moveToElement(menuOption).perform();
	//Now Select 'Add New' from menu which has got displayed on mouse hover of 'Users'
	WebElement selectMenuOption = driver.findElement(By.linkText("Add New"));
	selectMenuOption.click();
	driver.findElement(By.id("user_login")).sendKeys("Mary");
	driver.findElement(By.id("email")).sendKeys("tester@hotmail.com");
	driver.findElement(By.name("createuser")).click();
}
 
}