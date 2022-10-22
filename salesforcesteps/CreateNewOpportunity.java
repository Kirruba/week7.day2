package week7.day2.salesforcesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewOpportunity extends BaseClass {

	@Given("Click Sales from App Launcher")
	public void clickSales() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']"))).click();
	}

	@And("Click on Opportunity tab")
	public void clickOpportunity() {
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		wait.until(ExpectedConditions.elementToBeClickable(opportunity));
		driver.executeScript("arguments[0].click();", opportunity);
	}

	@And("Click on New button")
	public void clickNewButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();
	}

	@When("Enter Opportunity name as {string}")
	public void enterOpportunityName(String opportunityName) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityName);
	}

	@And("Choose close date as Today")
	public void chooseCloseDate() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']//span")).click();
	}

	@And("Select Stage as {string}")
	public void selectStage(String stage) {
		driver.findElement(By.xpath("//label[text()='Stage']/following::button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title=" + "'" + stage + "'" + "]")))
				.click();
	}

	@And("Click Save")
	public void clickSave() {
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
	}

	@Then("Verify Oppurtunity Name as given {string}")
	public void verifyOppurtunityName(String opportunityName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));
		String successMessage = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		System.out.println(successMessage);

		Assert.assertTrue(successMessage.contains(opportunityName));
	}

}
