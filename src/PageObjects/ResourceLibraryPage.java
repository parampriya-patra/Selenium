package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ResourceLibraryPage {
	
	By cookieLink = By.id("hs-eu-confirmation-button");
	By resourceLink = By.linkText("Resources");
	By subResource = By.xpath("//div[contains(@class,'span10 widget-span widget-type-raw_jinja navigation')]//a[contains(text(),'Resources Library')]");
	By resourceContent1 = By.xpath("//span[contains(text(),'SpringCM Resource Library')]");
	By resourceContent2 = By.xpath("//span[@class='hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_rich_text']//h3");
	By mediaType = By.xpath("//a[@class='clicker-type']");
	By mediaList = By.xpath("//div[contains(@class,'click-drop-type button-group span5')]//ul[contains(@class,'portfolio-filters js')]//ul//li");
	By reportsMediaType = By.xpath("//a[contains(text(),'Reports')]");
	By mediaContent1 = By.xpath("//div[contains(@class,'portfolio-item mix report forrester')]");
	By mediaContent3 = By.xpath("//div[contains(@class,'portfolio-item mix report document-managment public-sector')]");
	
	public WebDriver getDriver()
	{		
		return Driver.initiateDriver();
	}
	
	public void acceptCookie(WebDriver drv) {
		drv.findElement(cookieLink).click();
	}
	
	public String getResourceAttribute(WebDriver driv) {		
		return driv.findElement(resourceLink).getAttribute("role");
	}
	
	public Boolean isResourceDisplayed(WebDriver driv) {
		return driv.findElement(resourceLink).isDisplayed();		
	}
	public void selectResourceMenu(WebDriver driv) {
		WebElement menuElement = driv.findElement(resourceLink);
		Actions action = new Actions(driv);
		action.moveToElement(menuElement).perform();
		
		WebElement selectMenuOption = driv.findElement(subResource);
		selectMenuOption.click();
	}
	
	public String verifyresoucePageContent1(WebDriver driv) {
		return driv.findElement(resourceContent1).getText();		
	}
	public String verifyresourcePageContent2(WebDriver driv) {
		return driv.findElement(resourceContent2).getText();
	}

	public List<WebElement> selectMediaType(WebDriver driv) {
		
		
		 WebElement dropdown = driv.findElement(mediaType);  
		 dropdown.click();

		 List<WebElement> options = driv.findElements(mediaList);
		 return options;
	}
		  
	
	public void selectReportsMediaType(WebDriver driv) {
		driv.findElement(reportsMediaType).click();
		JavascriptExecutor jse = (JavascriptExecutor)driv;
		jse.executeScript("scroll(0, 500)");
	}
	
	
	public String mediaPageContent1(WebDriver driv) {
		return driv.findElement(mediaContent1).getText();
	}
	
	public String mediaPageContent3(WebDriver driv) {
		return driv.findElement(mediaContent3).getText();
	}
	

}
