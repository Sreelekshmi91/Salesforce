package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_CreateOpportunitywithoutmandatoryfields {

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

//		6. Choose Close date as Tomorrow Date

		WebElement close = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
		driver.executeScript("arguments[0].click();", close);
		Thread.sleep(5000);

		WebElement close1 = driver.findElement(By.xpath("//span[text()='24']"));
		driver.executeScript("arguments[0].click();", close1);

//		7. Click on save 

		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(5000);

//		8. Verify the Alert message (Complete this field) displayed for Name and Stage

		String text = driver.findElement(By.xpath("//h2[@title='We hit a snag.']")).getText();
		if (text.equals("We hit a snag.")) {
			System.out.println("Complete this field message should be displayed for Name and Stage fields");
		} else {
			System.out.println("Complete this field message should not displayed for Name and Stage fields");
		}

	}
}
