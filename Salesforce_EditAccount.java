package salesforce_training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_EditAccount {

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

		WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		search.sendKeys("SREELEKSHMI S", Keys.ENTER);
		Thread.sleep(5000);

//		6) Click on the displayed Account Dropdown icon and select Edit

		WebElement edit = driver
				.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[3]"));
		driver.executeScript("arguments[0].click();", edit);
		Thread.sleep(5000);

		WebElement edit1 = driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", edit1);
		// driver.findElement(By.xpath("//a[@title='Edit']")).click();

//		7) Select Type as Technology Partner
		Thread.sleep(5000);

		WebElement Type = driver
				.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[2]"));
		driver.executeScript("arguments[0].click();", Type);
		Thread.sleep(5000);

		WebElement Type1 = driver.findElement(By.xpath("//span[text()='Technology Partner']"));
		driver.executeScript("arguments[0].click();", Type1);

//		8) Select Industry as Healthcare 

		Thread.sleep(5000);
		WebElement Industry = driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]"));
		driver.executeScript("arguments[0].click();", Industry);
		Thread.sleep(5000);

		WebElement Industry1 = driver.findElement(By.xpath("//span[text()='Healthcare']"));
		driver.executeScript("arguments[0].click();", Industry1);

//		9)Enter Billing Address
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("Testleaf");

//	10)Enter Shipping Address

		driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys("Testleaf, Chennai");

//	11)Select Customer Priority as Low
		Thread.sleep(5000);
		WebElement Customer = driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]"));
		driver.executeScript("arguments[0].click();", Customer);
		Thread.sleep(5000);

		WebElement Customer1 = driver.findElement(By.xpath("//span[text()='Low']"));
		driver.executeScript("arguments[0].click();", Customer1);

//		12)Select SLA as Silver

		Thread.sleep(5000);
		WebElement SLA = driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]"));
		driver.executeScript("arguments[0].click();", SLA);
		Thread.sleep(5000);

		WebElement SLA1 = driver.findElement(By.xpath("//span[text()='Silver']"));
		driver.executeScript("arguments[0].click();", SLA1);

//		13) Select Active as NO 

		Thread.sleep(5000);
		WebElement Active = driver.findElement(By.xpath("(//button[@data-value='--None--']//span)[3]"));
		driver.executeScript("arguments[0].click();", Active);
		Thread.sleep(5000);

		WebElement Active1 = driver.findElement(By.xpath("//span[text()='No']"));
		driver.executeScript("arguments[0].click();", Active1);

//		14) Enter Unique Number in Phone Field

		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("9578332458");

//		15)Select Upsell Oppurtunity as No

		Thread.sleep(5000);
		WebElement Upsell = driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]"));
		driver.executeScript("arguments[0].click();", Upsell);
		Thread.sleep(5000);

		WebElement Upsell1 = driver.findElement(By.xpath("//span[text()='No']"));
		driver.executeScript("arguments[0].click();", Upsell1);

		// 16. Click save and verify Account name

		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		String text = driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).getText();
		if (text.equals("(957) 833-2458")) {
			System.out.println("The Account is Edited Successfully");
		} else {
			System.out.println("The Account is Edited not Successfully");
		}

	}
}
