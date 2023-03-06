package deviceMetricsOverrideFunction;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.Request;

public class lec219_NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		/*
		 * visit this WebSite :- https://chromedevtools.github.io/devtools-protocol/ go
		 * to Domain called Network for all network related things go to enable so its
		 * helps for Enables network tracking, network events will now be delivered back
		 * to the client(Selenium).
		 * 
		 */
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
			System.out.println(req.getUrl());
		});

		// when event get fired:-
		devTools.addListener(Network.responseReceived(), response -> {
			org.openqa.selenium.devtools.v108.network.model.Response res = response.getResponse();
			System.out.println(res.getStatus());
			if (res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + "is failling with status code" + res.getStatus());
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
