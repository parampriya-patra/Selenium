package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Driver{
		
	By cookieLink = By.id("hs-eu-confirmation-button");
	
	public WebDriver getDriver()
	{		
		return Driver.initiateDriver();
	}
	
	public String getHomepageTitle(WebDriver drv) {
		
		return drv.getTitle().trim();
		
	}
	public String getHomepageURL(WebDriver drv) {
	
		return drv.getCurrentUrl();
	
	}
	public void acceptCookie(WebDriver drv) {
		drv.findElement(cookieLink).click();
	}
}