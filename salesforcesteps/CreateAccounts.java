package week7.day2.salesforcesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccounts extends BaseClass {

	@And("Click on Accounts tab")
	public void clickAccounts() {
		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounts);
		wait.until(ExpectedConditions.elementToBeClickable(accounts));
	}

	@And("Click New Account")
	public void clickNewAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();
	}

	@When("Enter your name as {string}")
	public void enterAccountName(String accountName) {
		WebElement accName = driver.findElement(By.xpath("//input[@name='Name']"));
		accName.sendKeys(accountName);
	}

	@And("Select Ownership as {string}")
	public void selectOwnership(String ownership) {
		WebElement Ownership = driver.findElement(By.xpath("//label[text()='Ownership']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Ownership)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Public']"))).click();
	}

	@And("Click save")
	public void clicksave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']"))).click();
	}

	@Then("Verify Account name as {string}")
	public void verifyAccounts(String accountName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));

		String verify = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		System.out.println(verify);
		Assert.assertTrue(verify.contains(accountName));
	}

}
