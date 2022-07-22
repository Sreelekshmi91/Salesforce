package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_SortAccount {

	public static void main(String[] args) throws InterruptedException {

//		1. Login to https://login.salesforce.com

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get(" https://login.salesforce.com ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(" ramkumar.ramaiah@testleaf.com ");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();

		// 2. Click on toggle menu button from the left corner

		driver.findElement(By.className("slds-r5")).click();

		// 3. Click view All and click Sales from App Launcher
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

//	4. Click on Accounts tab 
		Thread.sleep(5000);

		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);

//		5. Click sort arrow in the Account Name to sort in ascending order

		WebElement sort = driver.findElement(By.xpath("//a[contains(@class,'toggle slds-th__action')]"));
		driver.executeScript("arguments[0].click();", sort);

		String text = driver.findElement(By.xpath("//span[text()='50+ items • Sorted by Account Name • ']")).getText();
		System.out.println(text);
		if (text.equals("50+ items • Sorted by Account Name •")) {
			System.out.println("All the accounts should be displayed ascending order by Account Name");
		} else {
			System.out.println("All the accounts should not displayed ascending order by Account Name");
		}
	}

}
