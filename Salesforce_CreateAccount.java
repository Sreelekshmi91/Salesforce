package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_CreateAccount {

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

//		4. Click on Accounts tab 
		Thread.sleep(5000);

		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);

//		5. Click on New button

		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(5000);

		// 6. Enter 'your name' as account name

		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("SREELEKSHMI S");
		Thread.sleep(5000);

//		7. Select Ownership as Public                                            

		WebElement ownership = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
		driver.executeScript("arguments[0].click();", ownership);

		WebElement item = driver.findElement(By.xpath("//span[text()='Public']"));
		driver.executeScript("arguments[0].click();", item);

		// 8. Click save and verify Account name

		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		String text = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		if (text.equals("SREELEKSHMI S")) {
			System.out.println("Account should be created Successfully");
		} else {
			System.out.println("Account should not created Successfully");
		}

	}
}
