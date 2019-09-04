package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends Driver {
	
	
	By searchText = By.xpath("//div[@id='hs_cos_wrapper_module_155259610297090']//input[@placeholder='Search']");
	By SearchIcon = By.xpath("//div[@class='span10 widget-span widget-type-raw_jinja navigation']//i[@class='fa fa-search']");
	By searchResultLink = By.linkText("Contract Management Software | SpringCM");
	
	public WebDriver getDriver()
	{		
		return Driver.initiateDriver();
	}
	
	public void clickSearchIcon(WebDriver drive) {
		drive.findElement(SearchIcon).click();
	}
	
	public String getPlaceholder(WebDriver drive) {
		return drive.findElement(searchText).getAttribute("placeholder");
	}
	
	public void SendValueforSearhc(WebDriver drive, String value) {
		
		WebDriverWait wait = new WebDriverWait(drive, 10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchText));
		element.click();
		element.clear();
		element.sendKeys(value);
		element.submit();
	}
	
	public String searchResult(WebDriver drive) {
		
		return drive.findElement(searchResultLink).getText();
	}
	
	public void clickSearchResult(WebDriver drive) {
		
		drive.findElement(searchResultLink).click();
	}
	public String getpageTitle(WebDriver drive) {
		
		return drive.getTitle().trim();
		
	}
	

}