package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import PageObjects.SearchPage;
import PageObjects.ContractManagementPage;
import PageObjects.HomePage;

public class TestSuite_ContractManagement{
	
	//Create Search Page object
	public SearchPage objSearch = new SearchPage();

	//Create Home Page Object
	public HomePage objHome = new HomePage();
	
	//Create Contract Management page object
	public ContractManagementPage objCMPage = new ContractManagementPage();
	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUp() {
		
		driver = objSearch.getDriver();
		driver.manage().window().maximize();
		objHome.acceptCookie(driver);
		
	}
	@Test (priority = 1)
	public void TestCase1_verifyHomepageTitle() {
		String expectedTitle = "SpringCM | Optimize Your Contract and Document Process";
		String actualTitle = objHome.getHomepageTitle(driver);
		String actualUrl = objHome.getHomepageURL(driver);
		
		//Verify Page Title
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
		//Verify Home page url
		AssertJUnit.assertEquals(actualUrl, PageObjects.Driver.baseUrl);
	}
	@Test (priority =2)
	public void TestCase1_verifySearch() {
	
		objSearch.clickSearchIcon(driver);
		
		//Verify placeholder
		String placeHolder = objSearch.getPlaceholder(driver);
		AssertJUnit.assertTrue(placeHolder.contains("Search"));
		
		//Verify Search Page Result
		objSearch.SendValueforSearhc(driver, "Contract Management");
		
		String result = objSearch.searchResult(driver);
		
		AssertJUnit.assertTrue(result.contains("Contract Management Software | SpringCM"));
		
		objSearch.clickSearchResult(driver);
		
		String PageTitle = objSearch.getpageTitle(driver);
			
		AssertJUnit.assertTrue(PageTitle.contains("Contract Management Software | SpringCM"));
	}
		
	@Test(priority = 3)
	public void TestCase2_verifyDemoPageTitle() {
		
		objCMPage.getProductDemoPage(driver);
		
		String Title = objCMPage.verifyNewPageOpened(driver);;
		
		//Verify Page Title
		AssertJUnit.assertTrue(Title.contains("SpringCM in Action: Watch Demo"));
		
		objCMPage.clickPlayVideoButton(driver);
		
		String message = objCMPage.verifyValidationMessage(driver);
		AssertJUnit.assertTrue(message.contains("Please complete all required fields."));
		
		String[] fieldName = new String[] {"firstname", "lastname", "email", "phone", "company", "country"};
		String[] Input = new String[] {"Priya", "Patra", "casaravilla@foryoumyfriend.space", "3451237896", "ABC", "USA"};
		
		for (int i =0; i<fieldName.length; i++)
		{
			objCMPage.fillForm(driver, Input[i], fieldName[i]);
		}
		
		objCMPage.clickButton(driver);
		
		objCMPage.verifyplayer(driver);
		
		}
	@AfterTest
	public void closeDriver(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }
	

	
}