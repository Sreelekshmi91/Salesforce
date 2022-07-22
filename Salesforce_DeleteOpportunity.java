package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_DeleteOpportunity {

//	1. Login to https://login.salesforce.com
//		2. Click on toggle menu button from the left corner
//		3. Click view All and click Sales from App Launcher
//		4. Click on Opportunity tab 
//		5. Search the Opportunity 'Salesforce Automation by Your Name'
//		6. Click on  the Dropdown icon and Select Delete
//		7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
//
//		Expected result:
//		Oppurtunity is Successfully deleted

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

//		4. Click on Opportunity tab 
		Thread.sleep(5000);

		WebElement Opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", Opportunity);

//		5. Search the Opportunity 'Salesforce Automation by Your Name'

		Thread.sleep(5000);

		WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		search.sendKeys("Salesforce Automation by SREELEKSHMI S", Keys.ENTER);
		Thread.sleep(5000);

//		6. Click on  the Dropdown icon and Select Delete

		String text = driver.findElement(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]")).getText();

		WebElement Delete = driver
				.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]"));

		driver.executeScript("arguments[0].click();", Delete);

		Thread.sleep(5000);

		WebElement Delete1 = driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click();", Delete1);
		Thread.sleep(5000);

		WebElement Delete2 = driver.findElement(By.xpath("//button[@title='Delete']//span[1]"));
		driver.executeScript("arguments[0].click();", Delete2);

//		7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name

		Thread.sleep(5000);
		if (text.equals("Salesforce Automation by SREELEKSHMI S")) {
			System.out.println("Oppurtunity is Successfully deleted");
		} else {
			System.out.println("Oppurtunity is not Successfully deleted");
		}

	}
}
