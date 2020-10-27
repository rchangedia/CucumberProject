package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Search_Job {
		WebDriver driver;
	    WebDriverWait wait;

	@Given("^Open browser with Alchemy Jobs site​ and navigate to Jobs page$")
	public void Loginsite() {
	    //Setup instances
	   	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		
	    //Open browser
	    driver.get("https://alchemy.hguy.co/jobs/");
	    driver.manage().window().maximize();
	}
	
   @When("^User searches for a job using Full time job filter$")
      public void SearchJob()
   {
	   driver.findElement(By.linkText("Jobs")).click();
	   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("search_keywords")));
	   driver.findElement(By.id("search_keywords")).clear();
	   driver.findElement(By.name("search_keywords")).sendKeys("Tester");
	   driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	   driver.findElement(By.id("job_type_freelance")).click();
	   driver.findElement(By.id("job_type_internship")).click();
	   driver.findElement(By.id("job_type_part-time")).click();
	   driver.findElement(By.id("job_type_temporary")).click();
	   
  }	 
   @Then("^find the title of the Job and print it$")
   public void FindJobtitle()
   {   
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")));
	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")).click();
	String getJobTitle = driver.findElement(By.className("entry-title")).getText();

	Assert.assertEquals(getJobTitle, "Tester");
   }
	   
	@And("^Click on Apply for Job$")
	public void ApplyJob()
	{
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
   }
  
	@And("^Close the Browser$")
	public void closeBrowser() {
	    //Close browser
	    driver.close();
	    
	 }
   }