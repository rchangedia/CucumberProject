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

public class Create_Vacancies {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^Open the OrangeHRM​ page and login with given credentials$")
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

	@When("^Navigate to Recruitment page$")
	public void navigateToRecruitmentPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_dashboard_index")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_recruitment_viewRecruitmentModule")));
		WebElement dashboardLink = driver.findElement(By.id("menu_dashboard_index"));
		WebElement recruitmentLink = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));

		if (dashboardLink.isDisplayed()) {

			recruitmentLink.click();

		} else {

			dashboardLink.click();
			recruitmentLink.click();
		}
		
		Thread.sleep(3500);
	}

	@Then("^Click on Vacancies menu item to navigate to the vacancies page$")
	public void navigateToVacanciesPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_recruitment_viewJobVacancy")));		
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	}

	@And("^Click on Add button to navigate to the Add Job Vacancy form$")
	public void navigateToAddVacancyPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAdd")));
		driver.findElement(By.id("btnAdd")).click();
	}

	@Then("^Fill out the necessary details \"(.*)\"$")
	public void fillAddJobVacancyForm(String vacancyName) {
		WebElement addJobVacancy_jobTitle = driver.findElement(By.id("addJobVacancy_jobTitle"));

		Select selectJobTitle = new Select(addJobVacancy_jobTitle);
		selectJobTitle.selectByValue("3");

		driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);

		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Test Employee");
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(Keys.ENTER);
	}

	@And("^Click the Save button to save the vacancy$")
	public void clickOnSaveButton() {
		driver.findElement(By.id("btnSave")).click();
	}

	@Then("^Verify that the vacancy was created \"(.*)\"$")
	public void verifyVacancyCreation(String vacancyName) {
		driver.findElement(By.id("btnBack")).click();

		WebElement vacancySearch_jobTitle = driver.findElement(By.id("vacancySearch_jobTitle"));

		Select selectJobTitle = new Select(vacancySearch_jobTitle);
		selectJobTitle.selectByValue("3");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("vacancySearch_jobVacancy")));
		WebElement vacancySearch_jobVacancy = driver.findElement(By.id("vacancySearch_jobVacancy"));

		Select selectJobVacancy = new Select(vacancySearch_jobVacancy);
		selectJobVacancy.selectByVisibleText(vacancyName);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("vacancySearch_hiringManager")));
		WebElement vacancySearch_hiringManager = driver.findElement(By.id("vacancySearch_hiringManager"));

		Select selectHiringManager = new Select(vacancySearch_hiringManager);
		selectHiringManager.selectByVisibleText("Test Employee");

		driver.findElement(By.id("btnSrch")).click();

		String actualVacancyName = driver.findElement(By.linkText(vacancyName)).getText();

		Assert.assertEquals(actualVacancyName, vacancyName);
	}

	@And("^Close browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}
}

