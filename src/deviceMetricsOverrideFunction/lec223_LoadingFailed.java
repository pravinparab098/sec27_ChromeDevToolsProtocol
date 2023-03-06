package deviceMetricsOverrideFunction;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.ConnectionType;

public class lec223_LoadingFailed {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		//if its true then break the network connection
		devTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		//to know the exact reason of error
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println("Error Reason" +	loadingFailed.getErrorText());
			System.out.println("Error Time" +	loadingFailed.getTimestamp());
		});
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		System.out.println("Page Title : " + driver.getTitle());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		Thread.sleep(2000);
		driver.close();
		//16017
		//commenting the 20 th line its 488
	}
}
