package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Add_Candidate {
	WebDriver driver;
	WebDriverWait wait;

	Double d = (Math.random() + 1) * 1000;
	String firstName = "FName_" + Math.round(d);
	String lastName = "lName_" + Math.round(d);
	String email = firstName + lastName +"@gmail.com";
	String candidateName = firstName + " " + lastName;
	
	String path = System.getProperty("user.dir")+"/Files/Cucumber-Project-HRM.pdf";

	@Given("^Open the OrangeHRM​ page and login with the credentials provided$")
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

	@When("^Navigate to the Recruitment page and click on the Add button to add candidate information$")
	public void navigateToRecruitmentPage() {
		WebElement dashboardLink = driver.findElement(By.id("menu_dashboard_index"));
		WebElement recruitmentLink = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));

		if (dashboardLink.isEnabled()) {

			recruitmentLink.click();

		} else {

			dashboardLink.click();
			recruitmentLink.click();
		}
		
		driver.findElement(By.id("btnAdd")).click();
	}

	@Then("^On the next page, fill in the details of the candidate$")
	public void fillAddCandidateForm() {
		driver.findElement(By.id("addCandidate_firstName")).clear();
		driver.findElement(By.id("addCandidate_firstName")).sendKeys(firstName);
		
		driver.findElement(By.id("addCandidate_lastName")).clear();
		driver.findElement(By.id("addCandidate_lastName")).sendKeys(lastName);
		
		driver.findElement(By.id("addCandidate_email")).clear();
		driver.findElement(By.id("addCandidate_email")).sendKeys(email);		
	}

	@And("^Upload a resume docx or pdf to the form$")
	public void uploadResume() {
		driver.findElement(By.id("addCandidate_resume")).sendKeys(path);
	}

	@And("^Click Save$")
	public void clickOnSaveButton() {
		driver.findElement(By.id("btnSave")).click();
	}

	@Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void verifyVacancyCreation() {
		driver.findElement(By.id("btnBack")).click();

		driver.findElement(By.id("candidateSearch_candidateName")).clear();
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(candidateName);
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("btnSrch")).click();

		String actualCandidateName = driver.findElement(By.linkText(candidateName)).getText();

		Assert.assertEquals(actualCandidateName, candidateName);
	}

	@And("^Close the Browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}

}
	
	


