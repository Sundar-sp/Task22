package task22;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateFormUsingWebDriverWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement firstName = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='first_name']"))));
		firstName.sendKeys("FirstName");

		WebElement lastName = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='last_name']"))));
		lastName.sendKeys("LastName");

		WebElement businessName = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='business_name']"))));
		businessName.sendKeys("company");

		WebElement email = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='email']"))));
		email.sendKeys("company@test.com");

		String num1 = driver.findElement(By.xpath("//span[@id='numb1']")).getText();
		String num2 = driver.findElement(By.xpath("//span[@id='numb2']")).getText();
		int add = Integer.parseInt(num1) + Integer.parseInt(num2);
		WebElement value = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='number']"))));
		value.sendKeys(String.valueOf(add));

		WebElement button = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='demo']"))));
		button.click();

		WebElement confirm = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//strong[text()=' Thank you!']"))));
		String confirmText = confirm.getText();
		if ("Thank you!".contentEquals(confirmText)) {
			System.out.println("Verified form is submitted successfully");
		} else {
			System.out.println("Form not submitted");
		}

		SimpleDateFormat timeValue = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date = new Date();
		String location = System.getProperty("user.dir") + "/screenshot" + timeValue.format(date) + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(location);
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}

Output:
May 27, 2024 3:08:35 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
Verified form is submitted successfully
