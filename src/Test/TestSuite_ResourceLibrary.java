package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.ResourceLibraryPage;

public class TestSuite_ResourceLibrary {
	
	//Create Search Page object
	public ResourceLibraryPage objResource = new ResourceLibraryPage();
	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUp() {
		
		driver = objResource.getDriver();
		driver.manage().window().maximize();
		objResource.acceptCookie(driver);
	}
	
	@Test
	public void TestCase3_verifyResourceLibrary() {
		String role = objResource.getResourceAttribute(driver);
		AssertJUnit.assertTrue(role.contains("menuitem"));
		
		AssertJUnit.assertTrue(objResource.isResourceDisplayed(driver));
		
		objResource.selectResourceMenu(driver);
		
		String pageContent1 = objResource.verifyresoucePageContent1(driver);		
		AssertJUnit.assertTrue(pageContent1.contains("SpringCM Resource Library"));
		
		String pageContent2 = objResource.verifyresourcePageContent2(driver);
		AssertJUnit.assertTrue(pageContent2.contains("Discover the value of better contract and document management."));
		
		//Verify Media Type
		String[] exp = {"all","Datasheets & Tip Sheets","eBook","Reports","Webinars","Videos","Other"};
		List<WebElement> options = objResource.selectMediaType(driver);
		
		for(WebElement we:options)  
		 {  
		  boolean match = false;
		  for (int i=0; i<exp.length; i++){
		      if (we.getText().equals(exp[i])){
		        match = true;
		      }
		    }
		  AssertJUnit.assertTrue(match);
		 }
		
		//Verify Reports Media Type
		objResource.selectReportsMediaType(driver);
		
		String mediaContent1 = objResource.mediaPageContent1(driver);
		AssertJUnit.assertTrue(mediaContent1.contains("The Forrester Wave™: Contract Lifecycle Management For All Contracts, Q1 2019"));
	
		String mediaContent3 = objResource.mediaPageContent3(driver);
		AssertJUnit.assertTrue(mediaContent3.contains("Government Business Council Flash Poll: Citizen Engagement"));
	
	}
	
	
	@AfterTest
	public void closeDriver(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
	}

}
