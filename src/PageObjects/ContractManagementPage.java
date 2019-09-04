package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContractManagementPage {
	
	By demoLink = By.linkText("WATCH OUR PRODUCT DEMO");
	By playButton = By.xpath("//input[@class='hs-button primary large']");
	By validationMessage = By.xpath("//label[@class='hs-main-font-element']");
	By playerLink = By.xpath("//div[contains(@class,'w-bottom-bar-middle-inner w-css-reset')]//div[contains(@class,'w-playbar-wrapper w-css-reset w-css-reset-tree')]");
	
	public void getProductDemoPage(WebDriver drive) {
		
		WebDriverWait wait = new WebDriverWait(drive, 10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(demoLink));
		element.click();
	}
	
	public String verifyNewPageOpened(WebDriver drive) {
		
		/*WebDriverWait wait = new WebDriverWait(drive, 5000);
		
		WebElement element = drive.findElement(playButton);
		wait.until(ExpectedConditions.visibilityOf(element));*/
		
		 //Store all window handles in a list
		List<String> allWindowHandles = new ArrayList<String> (drive.getWindowHandles());
		
		if (allWindowHandles.size()>1)
        {
        	System.out.println("New window has been opened.");
        	
        }
        
		//Switch to new window handle.
        drive.switchTo().window(allWindowHandles.get(1));
        
        return drive.getTitle().trim();		
	}
	
	public void clickPlayVideoButton(WebDriver drive) {
		
		JavascriptExecutor jse = (JavascriptExecutor)drive;
		jse.executeScript("scroll(0, 500)");
		WebDriverWait wait = new WebDriverWait(drive, 10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(playButton));
		element.click();
		

	}
	
	public String verifyValidationMessage(WebDriver drive) {
		WebDriverWait wait = new WebDriverWait(drive, 10);
		
		WebElement element = drive.findElement(validationMessage);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		return element.getText();
	}
	
	public void fillForm(WebDriver drive, String input, String name) {
		
		drive.findElement(By.name(name)).sendKeys(input);
		
	}
	
	public void clickButton(WebDriver drive) {
		WebDriverWait wait = new WebDriverWait(drive, 10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(playButton));
		element.click();
		
	}
	
	public void verifyplayer(WebDriver drive) {
		
		drive.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Actions actions = new Actions(drive);
		WebElement playerElement = drive.findElement(playerLink);
		actions.moveToElement(playerElement, 50, 0).perform();
		drive.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//playerElement.click();
	}
	
}
