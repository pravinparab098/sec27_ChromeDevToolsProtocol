package deviceMetricsOverrideFunction;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class lec217_CDPcommands {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		Map<String, Object> deviceMetrices = new HashMap<String, Object>();
		deviceMetrices.put("width", 600);
		deviceMetrices.put("height", 1000);
		deviceMetrices.put("deviceScaleFactor", 50);
		deviceMetrices.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrices);

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		System.out.println("Page Title :- " + driver.getTitle());
		Thread.sleep(2000);
		driver.close();

	}

}
