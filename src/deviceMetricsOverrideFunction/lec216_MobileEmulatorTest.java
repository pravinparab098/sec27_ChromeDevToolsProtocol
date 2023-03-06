package deviceMetricsOverrideFunction;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lec216_MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {

		// Step 1 :- Initiate Chromium driver
		WebDriverManager.chromedriver().setup();
		// webDriver do not expose to devTools so use chromeDriver only
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		// Step 2 :- Create the Object for Chrome dev tools with getDevTools() methods
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// send commands to CDP [Chrome DevTools protocol] methods --> CDP methods will
		// invoke and get access to chrome dev tools
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));

		// Step 3 :- go to webPage
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		System.out.println("Page Title :- " + driver.getTitle());
		Thread.sleep(2000);
		driver.close();
	}
}
