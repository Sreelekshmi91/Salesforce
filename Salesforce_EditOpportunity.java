package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_EditOpportunity {

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

//		6. Click on the Dropdown icon and Select Edit

		WebElement edit = driver
				.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]"));
		driver.executeScript("arguments[0].click();", edit);
		Thread.sleep(5000);

		WebElement edit1 = driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", edit1);

//		7. Choose close date as Tomorrow date

		WebElement close = driver.findElement(
				By.xpath("//div[contains(@class,'slds-form-element__control slds-input-has-icon')]//input[1]"));

		driver.executeScript("arguments[0].click();", close);
		Thread.sleep(5000);

		WebElement close1 = driver.findElement(By.xpath("//span[text()='24']"));
		driver.executeScript("arguments[0].click();", close1);

//		8. Select 'Stage' as Perception Analysis

		WebElement Stage = driver.findElement(By.xpath("//button[@data-value='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", Stage);
		Thread.sleep(5000);

		WebElement Stage1 = driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
		driver.executeScript("arguments[0].click();", Stage1);
		Thread.sleep(5000);

//		9. Select Deliver Status as In Progress

		WebElement Status = driver.findElement(By.xpath("(//button[@data-value='--None--']//span)[3]"));
		driver.executeScript("arguments[0].click();", Status);
		Thread.sleep(5000);

		WebElement Status1 = driver.findElement(By.xpath("//span[@title='In progress']"));
		driver.executeScript("arguments[0].click();", Status1);
		Thread.sleep(5000);

//		10. Enter Description as SalesForce

		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Salesforce");
		Thread.sleep(5000);

//		11. Click on Save and Verify Stage as Perception Analysis

		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		String text = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		if (text.equals("Perception Analysis")) {
			System.out.println("The Oppurtunity is Edited Successfully");
		} else {
			System.out.println("The Oppurtunity is not Edited Successfully");
		}

	}
}
