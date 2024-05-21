package pages;

import java.util.Random;

import org.openqa.selenium.By;
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

public class DashboardPage {
	public AppiumDriver driver = null;
	
	//constructor so that this class can use driver of runner java class, this class will not have any driver.
	public DashboardPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Not Now\"]")
    public WebElement button_ios_Notnow;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Pickup Pending\"]")
	public WebElement text_status;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	public WebElement close_btn;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"DAVID\"]")
	public WebElement text_profilesection;
          
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"DAVID LANGE\"])[2]")
	public WebElement text_profilesection_creditcard;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Add Credit Card\"]")
	public WebElement btn_AddCreditCard;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Card Name\"]")
	public WebElement text_cardName;
	
	 // + tab +space 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@name=\"Credit or debit card number\"]")
	public WebElement text_entetrCard;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Add Payment Method\"]")
	public WebElement buttn_AddPaymentMethod;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Your card was added successfully!\"]")
	public WebElement text_successMsg;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Not Now\"]")
	public WebElement NotNow_btn;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Head Back Home\"]")
	public WebElement HeadBack_btn;
	
	//don not show checkbox and then close
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSwitch[@name=\"Do Not Show Me Again\"]")
	public WebElement chheckboxPopup_btn;
	//XCUIElementTypeButton[@name="Close"]
	
	//profile --> david--> add new card = 4000 0000 0000 9995 ; 1234 ; 23212
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Card Error:\"]")
	public WebElement error_Msg1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Your card has insufficient funds.\"]")
	public WebElement error_Msg;
	
	//profile --> david--> add new card = 4000 0000 0000 9996 ; 1234 ; 23212
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Your card number is invalid.\"]")
	public WebElement error_Invalid_Msg;
	



	
	

	
	@Step("Verify Pickup Pending Status")
	public void Verify_pendingPickup() throws InterruptedException  {
	//button_ios_Notnow.click();
	try {
		button_ios_Notnow.click();
	}
	
	catch (Exception e) {
		// TODO: handle exception
		Thread.sleep(4000);
	}
	Thread.sleep(5000);
	boolean status=text_status.isDisplayed();
	Assert.assertTrue(status);
		
	}
	
	@Step("Go to Profile section and add credit card, catch invalid card message")
	public void goto_profile_addCard(String cardNo) throws InterruptedException {
		text_profilesection.click();
		Thread.sleep(5000);
		text_profilesection_creditcard.click();
        Thread.sleep(5000);
        btn_AddCreditCard.click();
        Thread.sleep(5000);
        text_cardName.click();
        text_cardName.sendKeys("test");
        //correct path of iframe
        text_entetrCard.click();
        text_entetrCard.sendKeys(cardNo);
        Thread.sleep(5000);
        buttn_AddPaymentMethod.click();
        verify_errorMsg_invalid(cardNo);
        
	}
	
	@Step("Go to Profile section and add credit card, catch insufficient card message")
	public void goto_profile_addCard1(String cardNo) throws InterruptedException {
		//text_profilesection.click();
		//Thread.sleep(5000);
		//text_profilesection_creditcard.click();
        //Thread.sleep(5000);
       // btn_AddCreditCard.click();
        //Thread.sleep(5000);
        //text_cardName.click();
        //text_cardName.sendKeys("test");
        //correct path of iframe
        text_entetrCard.click();
        text_entetrCard.clear();
        text_entetrCard.sendKeys(cardNo);
        Thread.sleep(5000);
        buttn_AddPaymentMethod.click();
        verify_errorMsg(cardNo);
        
	}

	@Step("Verify invalid Error msg on card adding")
	public void verify_errorMsg_invalid(String cardNo) throws InterruptedException{
		boolean msgError=error_Invalid_Msg.isDisplayed();
		if(msgError) {
			AssertJUnit.assertTrue(msgError);
			System.out.println("invalid card =   "  +cardNo);
		}
		
		else {
			AssertJUnit.assertTrue(msgError);
		}
	}
	
	@Step("Verify insufficient Error msg on card adding")
	public void verify_errorMsg(String cardNo) throws InterruptedException{
		boolean msgError=error_Msg.isDisplayed();
		if(msgError) {
			AssertJUnit.assertTrue(msgError);
			System.out.println("insufficient card =   "  +cardNo);
		}
		
		else {
			AssertJUnit.assertTrue(msgError);
		}
	}
}
