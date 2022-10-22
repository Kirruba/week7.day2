package week7.day2.salesforcesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewDashboard extends BaseClass {

	@Given("Click Dashboards from App Launcher")
	public void clickDashboard() {
		WebElement dashboard = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboard);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
	}

	@And("Click on New Dashboard")
	public void clickNewDashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New Dashboard']"))).click();
	}

	@When("Enter Name as {string}")
	public void enterName(String name) {
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(name);
	}

	@And("Click on Create")
	public void clickCreate() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitBtn']"))).click();
	}

	@And("Click on Save")
	public void clickOnSave() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='dashboard']")));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='slds-button slds-button_neutral save']"))).click();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.textToBe(
				By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"),
				"Dashboard saved"));
		String successMessage = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		System.out.println(successMessage);
	}

	@Then("Verify Dashboard name as {string}")
	public void verifyDashboardName(String name) {
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='slds-button slds-button_icon slds-m-left_x-small']")))
				.click();

		String dashboardName = driver.findElement(By.xpath("//input[@id='edit-dashboard-title']"))
				.getAttribute("value");

		Assert.assertTrue(dashboardName.contains(name));
	}

}
