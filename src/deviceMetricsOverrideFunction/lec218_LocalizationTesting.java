package deviceMetricsOverrideFunction;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.emulation.Emulation;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class lec218_LocalizationTesting {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3), Optional.of(1)));
		// Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3),
		// Optional.of(1)));
		// spanish
//		Map<String, Object> coordinates = new HashMap<String,Object>();
//		coordinates.put("latitude", 40 );
//		coordinates.put("longitude", 3);
//		coordinates.put("accuracy", 1);

//		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println("Spanish Title :- " + title);
		Thread.sleep(2000);
		driver.close();
	}

}
