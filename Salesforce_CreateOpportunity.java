package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_CreateOpportunity {

//	1. Login to https://login.salesforce.com
//		2. Click on toggle menu button from the left corner
//		3. Click view All and click Sales from App Launcher
//		4. Click on Opportunity tab 
//		5. Click on New button
//		6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
//		7. Choose close date as Today
//		8. Select 'Stage' as Need Analysis
//		9. click Save and VerifyOppurtunity Name
//		Expected Result:
//		New Opportunity should be created with name as  'Salesforce Automation by Your Name'
//	

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
		Thread.sleep(5000);

//		5. Click on New button

		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(5000);

//		6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 

		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input"))
				.sendKeys("Salesforce Automation by SREELEKSHMI S");
		Thread.sleep(5000);

//		7. Choose close date as Today

		WebElement close = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
		driver.executeScript("arguments[0].click();", close);
		Thread.sleep(5000);

		WebElement close1 = driver.findElement(By.xpath("//span[text()='22']"));
		driver.executeScript("arguments[0].click();", close1);

//		8. Select 'Stage' as Need Analysis

		WebElement Stage = driver.findElement(By.xpath("//span[text()='--None--']"));
		driver.executeScript("arguments[0].click();", Stage);
		Thread.sleep(5000);

		WebElement Stage1 = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", Stage1);
		Thread.sleep(5000);

		// 9. click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		String text = driver
				.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by SREELEKSHMI S']"))
				.getText();
		if (text.equals("Salesforce Automation by SREELEKSHMI S")) {
			System.out.println(
					"New Opportunity should be created with name as  'Salesforce Automation by SREELEKSHMI S'");
		} else {
			System.out.println(
					"New Opportunity should not created with name as  'Salesforce Automation by SREELEKSHMI S'");
		}

	}

}
