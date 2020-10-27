package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostJob {
	WebDriver driver;
    WebDriverWait wait;

@Given("^Open browser with Alchemy Jobs site$")
public void OpenBrowser() {
    //Setup instances
	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 15);
	
    //Open browser
    driver.get("https://alchemy.hguy.co/jobs/");
    driver.manage().window().maximize();
}
  @When("^User clicks on Post Job$")
    public void clickPostJob() 
  {   
	  driver.findElement(By.linkText("Post a Job")).click();

  }
  @Then("^user enters \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\" and click on Preview button$")
  
  public void fillJobDetails(String email,String jobTitle,String description,String ApplnEmail,String companyName)
  { 
	driver.findElement(By.id("create_account_email")).clear();
	driver.findElement(By.id("create_account_email")).sendKeys(email);
	driver.findElement(By.id("job_title")).sendKeys(jobTitle);
	WebElement iframe = driver.findElement(By.id("job_description_ifr"));
	driver.switchTo().frame(iframe);
	driver.findElement(By.xpath("/html/body")).sendKeys(description);
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//input[@id='application']")).sendKeys(ApplnEmail);
	driver.findElement(By.id("company_name")).clear();
	driver.findElement(By.id("company_name")).sendKeys(companyName);
	driver.findElement(By.name("submit_job")).click();
		
  } 
    @Then("^user clicks on Submit button$")
    public void clickSubmit()
    {
    	driver.findElement(By.id("job_preview_submit_button")).click();
    } 
   @Then("^Go to the Jobs site$")
   public void gotoJobsPage() {
		driver.findElement(By.linkText("Jobs")).click();
   }
		

   @And("^Confirm job listing \"(.*)\" is shown on page$")
	public void confirmJobListing(String jobTitle1) {
		driver.findElement(By.linkText("Jobs")).click();

		driver.findElement(By.id("search_keywords")).clear();
		driver.findElement(By.id("search_keywords")).sendKeys(jobTitle1);

		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/h3[text()='" + jobTitle1 + "']")));
		String actualJobTitle = driver.findElement(By.xpath("//div/h3[text()='" + jobTitle1 + "']")).getText();

		Assert.assertEquals(actualJobTitle, jobTitle1);
	}
        
}
