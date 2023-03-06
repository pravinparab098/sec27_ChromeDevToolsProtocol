package deviceMetricsOverrideFunction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class lec225_ConsoleLogsCapture {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//this method is use in TestNG listeners onTestFailure 
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER); //creating LogEntry object which gives all errors from Browser in list format
		List<LogEntry> logs = entries.getAll();	// now storing that entries in list format
		
		for (LogEntry entry : logs)	//go through each entry
		{
			System.out.println("Error Message :- "+entry.getMessage()); //and print one by one -- push it into Log4j
		}
		
		Thread.sleep(2000);
		driver.close();
	}
}
