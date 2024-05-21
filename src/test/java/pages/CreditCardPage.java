package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CreditCardPage {
	public AppiumDriver driver = null;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public CreditCardPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Let's Go!\"]")
    public WebElement button_letsGo;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[5]")
	public WebElement text_ccNo;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[6]")
	public WebElement text_ccExpiry;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[7]")
	public WebElement text_cvv;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[8]")
	public WebElement text_zip;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Home Zip Code\"]")
	public WebElement button_submitCrad;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSecureTextField[@value=\"Password\"]")
	public WebElement text_passwd;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSecureTextField[@value=\"Confirm Password\"]")
	public WebElement text_confirmPasswd;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Create Password\"]")
	public WebElement button_createPasswd;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"One lowercase character\"]")
	public WebElement cond_lowerCase;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"One uppercase character\"]")
	public WebElement cond_upperCase;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"One number\"]")
	public WebElement cond_oneNumber;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"One special character\"]")
	public WebElement cond_oneSpecialchar;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"8 character minimum\"]")
	public WebElement cond_8charlimit;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Passwords must match\"]")
	public WebElement error_passwordMatch;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Your card number is invalid.\"]")
	public WebElement invalid_card;
	
	@Step("Filling credit card invalid")
	public void fill_creditcard_invalid() throws InterruptedException {
		text_ccNo.click();
		text_ccNo.sendKeys("4000000000000111");
		text_ccExpiry.click();
		text_ccExpiry.sendKeys("1234");
		text_cvv.click();
		text_cvv.sendKeys("11111");
		text_zip.click();
		text_zip.sendKeys("09876"+ Keys.ENTER);
		//button_submitCrad.click();
		Thread.sleep(6000);
		boolean invalidMsg=invalid_card.isDisplayed();
		AssertJUnit.assertTrue(invalidMsg);
		
	}
	@Step("Filling valid credit card now")
	public void fill_creditcard1() throws InterruptedException {
		text_ccNo.clear();
		text_ccNo.click();
		text_ccNo.sendKeys("4111111111111111");
		//text_ccExpiry.click();
		//text_ccExpiry.sendKeys("1234");
		//text_cvv.click();
		//text_cvv.sendKeys("11111");
		text_zip.clear();
		text_zip.click();
		text_zip.sendKeys("09876"+ Keys.ENTER);
		//button_submitCrad.click();
		Thread.sleep(6000);
		
	}
	
	@Step("Filling credit card ")
	public void fill_creditcard() throws InterruptedException {
		text_ccNo.click();
		text_ccNo.sendKeys("4111111111111111");
		text_ccExpiry.click();
		text_ccExpiry.sendKeys("1234");
		text_cvv.click();
		text_cvv.sendKeys("11111");
		text_zip.click();
		text_zip.sendKeys("09876"+ Keys.ENTER);
		//button_submitCrad.click();
		Thread.sleep(6000);
		
	}
	@Step("Creating password ")
	public void create_password() throws InterruptedException {
		text_passwd.click();
		text_passwd.sendKeys("Ford123!");
		Thread.sleep(4000);
		text_confirmPasswd.click();
		text_confirmPasswd.sendKeys("Ford123!"+Keys.TAB);
		Thread.sleep(4000);
		button_createPasswd.click();
		Thread.sleep(8000);
		
	}
	
	@Step("Create password button is disabled without confirm password")
	public void create_password_buttonCheck() throws InterruptedException {
		text_passwd.click();
		text_passwd.sendKeys("Ford123!");
		Thread.sleep(6000);
		boolean button=text_confirmPasswd.isSelected();
		Assert.assertFalse(button);
		Thread.sleep(5000);
		
	}
	
	@Step("Password constraint lower case verification")
	public void cond1() {
		boolean lowercase= cond_lowerCase.isDisplayed();
		Assert.assertTrue(lowercase);
	}
	
	@Step("Password constraint upper case verification")
	public void cond2() {
		boolean uppercase= cond_upperCase.isDisplayed();
		Assert.assertTrue(uppercase);
	}
	
	@Step("Password constraint one number verification")
	public void cond3() {
		boolean cond_oneNumber1= cond_oneNumber.isDisplayed();
		Assert.assertTrue(cond_oneNumber1);
	}
	
	@Step("Password constraint one special char verification")
	public void cond4() {
		boolean cond_oneSpecialchar= cond_oneNumber.isDisplayed();
		Assert.assertTrue(cond_oneSpecialchar);
	}
		
	@Step("Password constraint 8 char limit verification")
	public void cond5() {
		boolean cond_8charlimit1= cond_8charlimit.isDisplayed();
		Assert.assertTrue(cond_8charlimit1);
	}	
	
	@Step("Password constraint password must match verification")
	public void cond6() {
		boolean error_passwordMatch1= error_passwordMatch.isDisplayed();
		Assert.assertTrue(error_passwordMatch1);
	}	
		

}
