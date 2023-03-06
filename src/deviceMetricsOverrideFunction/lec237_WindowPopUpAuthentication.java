package deviceMetricsOverrideFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class lec237_WindowPopUpAuthentication {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

//		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
//		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
//		driver.get("http://httpbin.org/basic-auth/foo/bar");	
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		System.out.println("Sucess Message :- "+driver.findElement(By.cssSelector("p")).getText());
		Thread.sleep(2000);
		driver.close();
	}
}	