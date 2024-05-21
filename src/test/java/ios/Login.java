package ios;

//Verify Signin button link works correctly at Already signup? partial signup page.
//To verify the reservation status on the dashboard when user logs back in.
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.LoginPage;
import pages.PartialSignupPage;

public class Login extends BaseClass {
	 static AppiumDriver driver;
		
		@Description("IOS Setup")
		@BeforeTest
		@SuppressWarnings({ "deprecation", "unused", "unused", "unused", "unused" })
		
		  public AppiumDriver setup() throws MalformedURLException{

			 BaseClass bs=new BaseClass();
			 driver=bs.initialize_driver();
			 return driver;
		}
	
	LoginPage loginpg;
	PartialSignupPage PartialSignupPg;
	
	@Description("FordDrive signin page verification begin")
	@Epic("Login Page")
	@Feature("Feature1: Login Page Process")
	@Severity(SeverityLevel.CRITICAL)
		@Test
		public static void Login() throws MalformedURLException {
		// run launch chrome
		try {

			PartialSignupPage PartialSignupPg = new PartialSignupPage(driver);
			LoginPage loginpg = new LoginPage(driver);
			
			//enter below env and email to login
			String env = "stage";
			String emailtoLogin = "8DE5HT6FIX@yopmail.com";
					
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (env.contains("stage")) {
							
			driver.get("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com");
			String context=((SupportsContextSwitching) driver).getContext();
			System.out.println(context);
							
			//Sign in button
			PartialSignupPg.link_signIn.click();
			Thread.sleep(5000);
			
			//allow cookie
			//if detect cookie settings
			PartialSignupPg.ignore_cookie_popup();
			Thread.sleep(6000);
			
			//enter email
			loginpg.text_EmailAddress1.click();
			loginpg.text_EmailAddress1.sendKeys(emailtoLogin);
			Thread.sleep(5000);
			loginpg.button_continue.click();
			Thread.sleep(5000);
				
			PartialSignupPg.ignore_cookie_popup();
			Thread.sleep(6000);
			
			//enter on login page
			loginpg.signIn_and_verifyDashboard(emailtoLogin);
						
			} 
					
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		@AfterTest
		public static void tearDown() {
			driver.quit();
			System.out.println("Test completed successfully.");
		}
}


		
