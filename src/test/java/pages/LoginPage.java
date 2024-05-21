package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import ios.BaseClass;

public class LoginPage extends BaseClass{
	public AppiumDriver driver;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public LoginPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Email Address\"]")
    public  WebElement text_EmailAddress;
	
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Email Address\"]")
    public  WebElement text_EmailAddress1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	public WebElement button_continue;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Sign in name\"]")
	public  WebElement text_emailToLogin;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSecureTextField[@name=\"Password\"]")
	public  WebElement text_password;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Sign in\"]")
	public  WebElement button_SignIn;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Not Now\"]")
	public WebElement button_NotNow;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"MILEAGE SNAPSHOT\"]")
	public WebElement textverify_mileageSnapshot;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"MILEAGE SNAPSHOT\"]")
	public WebElement textverify_PP;
	
	public void signIn_and_verifyDashboard(String email) throws InterruptedException 
	{
		text_emailToLogin.click();
		text_emailToLogin.sendKeys(email);
		text_password.click();
		text_password.sendKeys("Ford123!");
		Thread.sleep(4000);
		button_SignIn.click();
		Thread.sleep(15000);
		
		if (textverify_mileageSnapshot.getText().contains("MILEAGE SNAPSHOT")) {
			System.out.println("Login in Active account successful");
		}
			
		else {
			System.out.println("Login failed");
			
			}
			
	}
	
	public void signIn_and_verifyPendingDashboard(String email) throws InterruptedException 
	{
		text_emailToLogin.click();
		text_emailToLogin.sendKeys(email);
		text_password.click();
		text_password.sendKeys("Ford123!");
		Thread.sleep(4000);
		button_SignIn.click();
		Thread.sleep(15000);
			
	}
}
