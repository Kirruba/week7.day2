package week7.day2.salesforcesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateIndividuals extends BaseClass {

	@Given("Click Individuals from App Launcher")
	public void clickIndividuals() {
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		wait.until(ExpectedConditions.elementToBeClickable(individual));
	}

	@And("Click on Dropdown icon in the Individuals tab")
	public void clickDropdown() {
		WebElement clickDropdown = driver.findElement(
				By.xpath("//span[text()='Individuals']/following::a[@class='slds-button slds-button_reset']"));
		driver.executeScript("arguments[0].click();", clickDropdown);
		wait.until(ExpectedConditions.elementToBeClickable(clickDropdown));
	}

	@And("Click on New Individual")
	public void clickNewIndividual() {
		WebElement newIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", newIndividual);
	}

	@When("Enter Last Name as {string}")
	public void enterLastName(String lastName) {
		WebElement lName = driver.findElement(By.xpath("//span[text()='Last Name']/following::input"));
		lName.sendKeys(lastName);
	}

	@And("Click on save")
	public void clickonSave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]"))).click();
	}

	@Then("Verify Individuals Name as {string}")
	public void verifyIndividuals(String lastName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));
		String verifyIndividual = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		System.out.println(verifyIndividual);
		Assert.assertTrue(verifyIndividual.contains(lastName));
	}
}
