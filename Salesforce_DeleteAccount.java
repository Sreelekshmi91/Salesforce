package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_DeleteAccount {

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

//		5) Search for the Account Using the unique account name created by you 
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("SREELEKSHMI S", Keys.ENTER);

		Thread.sleep(5000);

//		6) Click on the displayed Account Dropdown icon and select Delete
		String text = driver.findElement(By.xpath("(//a[contains(@class,'slds-truncate outputLookupLink')])[1]"))
				.getText();
		WebElement Delete = driver
				.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]"));
		driver.executeScript("arguments[0].click();", Delete);

		Thread.sleep(5000);

		WebElement Delete1 = driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click();", Delete1);
		Thread.sleep(5000);

		WebElement Delete2 = driver.findElement(By.xpath(
				"//button[@data-aura-class='uiButton--default uiButton--brand uiButton forceActionButton']//span[1]"));
		driver.executeScript("arguments[0].click();", Delete2);

//		7. Verify Whether account is Deleted using account Name

		Thread.sleep(5000);
		if (text.equals("SREELEKSHMI S")) {
			System.out.println("The Account should be deleted successfully");
		} else {
			System.out.println("The Account should not deleted successfully");
		}

	}
}
