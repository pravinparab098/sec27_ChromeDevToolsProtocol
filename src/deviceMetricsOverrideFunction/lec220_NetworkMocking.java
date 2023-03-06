package deviceMetricsOverrideFunction;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.fetch.Fetch;

public class lec220_NetworkMocking {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// this is a methods so it is executed with devTools.send
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		// this is a event, so it is executed with devTools.addListener
		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String newURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println("changed URL :- " + newURL);

				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newURL),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						Optional.empty()));
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						Optional.empty()));
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(3000);
		System.out.println("");
		System.out.println("When One Book is available : " + driver.findElement(By.cssSelector("p")).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
