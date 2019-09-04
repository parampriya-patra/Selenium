package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public static WebDriver driver = null;
	public static String baseUrl = "https://www.springcm.com/";
	
	public static WebDriver initiateDriver() {
		
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(baseUrl);
	return driver;
	
	}
}
