package deviceMetricsOverrideFunction;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class lec224_BasicAuthentication {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// class called "uri" Java, so this class will help you to take the URL of the
		// what you have hidden in the browser,
		/*
		 * catching the host from the complete URL
		 * (http://httpbin.org/basic-auth/foo/bar this is URL) and (http://httpbin.org
		 * thsi is host) so we use a predicate -- Predicate will help you to create one
		 * filter condition for your data. let's say you have an array of one 200. And
		 * if you want to filter the data of even numbers, then you can write a
		 * predicate logic to get the even numbers out of that area, like every number
		 * divided by two. That gives you that Even so, that's the predicate logic.
		 */

		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");	
	
	
	}
}	