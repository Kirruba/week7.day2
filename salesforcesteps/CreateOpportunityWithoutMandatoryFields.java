package week7.day2.salesforcesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateOpportunityWithoutMandatoryFields extends BaseClass {

	@Given("Click on App Launcher button from the left corner")
	public void clickAppLauncher() {
		WebElement app = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		driver.executeScript("arguments[0].click();", app);
		wait.until(ExpectedConditions.elementToBeClickable(app));
	}

	@And("Click view All")
	public void clickViewAll() {
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewAll);
		wait.until(ExpectedConditions.invisibilityOf(viewAll));
	}

	@And("Choose Close date as Tomorrow Date")
	public void chooseCloseDateTomorrowdate() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']//span/following::span")).click();
	}

	@Then("Verify the Alert message displayed for Name and Stage as {string}")
	public void verifyAlertMessage(String alertMessage) {
		String nameAlertMessage = driver
				.findElement(By.xpath(
						"//label[text()='Opportunity Name']/following-sibling::div[@class='slds-form-element__help']"))
				.getText();
		System.out.println("Alert message for Name field: " + nameAlertMessage);
		String stageAlertMessage = driver
				.findElement(
						By.xpath("//label[text()='Stage']/following-sibling::div[@class='slds-form-element__help']"))
				.getText();
		System.out.println("Alert message for Stage field: " + stageAlertMessage);

		Assert.assertEquals(nameAlertMessage, alertMessage);
		Assert.assertEquals(stageAlertMessage, alertMessage);
	}

}
