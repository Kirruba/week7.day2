package waits;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriverwait {

	@Test
	public void webdriverWaits() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml;jsessionid=node018njzuxhhuo4l1il5whhqasf9x375735.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for Visibility (1 - 10 Sec)
		WebElement click1 = driver.findElement(By.xpath("//span[text()='Click']"));
		click1.click();
		String visible = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='I am here']")))
				.getText();
		System.out.println(visible);

		// Wait for Invisibility (1 - 10 Sec)
		WebElement click2 = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
		click2.click();
		WebElement invisible = driver.findElement(By.xpath(
				"(//h5[text()='Wait for Invisibility (1 - 10 Sec)']/following::span[@class='ui-button-text ui-c'])[2]"));
		System.out.println(invisible.getText());
		wait.until(ExpectedConditions.invisibilityOf(invisible));

		// Wait for Clickability
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click First Button']"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Message 1']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Message 2']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Message 3']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click Second']"))).click();

		// Wait for Text Change (1 - 10 Sec)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Click'])[3]"))).click();
		String text1 = driver.findElement(By.xpath(
				"(//h5[text()='Wait for Text Change (1 - 10 Sec)']/following::span[@class='ui-button-text ui-c'])[2]"))
				.getText();
		wait.until(ExpectedConditions.textToBe(By.xpath(
				"(//h5[text()='Wait for Text Change (1 - 10 Sec)']/following::span[@class='ui-button-text ui-c'])[2]"),
				"Did you notice?"));
		String text2 = driver.findElement(By.xpath(
				"(//h5[text()='Wait for Text Change (1 - 10 Sec)']/following::span[@class='ui-button-text ui-c'])[2]"))
				.getText();
		System.out.println(text1);
		System.out.println(text2);
		driver.close();
	}

}
