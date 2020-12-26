package Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BlousesPage;
import Pages.CheckOutProcedurePage;
import Pages.HomePage;
import Pages.Login;
import Pages.PaymentPage;
import Pages.RegisterationPage;
import Utils.CaptureScreenShot;
import Utils.ReadingCredentialFromExceel;



public class NewTesT {
	
	WebDriver browserobject;
	WebDriverWait wait;
	ReadingCredentialFromExceel CredentialExceel;
	Login LoginPage;
	RegisterationPage Registeration;
	HomePage homePage;
	JavascriptExecutor js;
	CaptureScreenShot ScreenShoot;
	BlousesPage blousespage;
	PaymentPage paymentpage;
	CheckOutProcedurePage checkout;
	Actions mousehover; 
	
	String HomePage = "homepage.png";
	String OrderPage = "order.png";
	String loginPage = "loginpage.png";
	String ShippingPage = "shippingpage.png";
	String blousesPage = "blousespage.png";
	String SelectedItem = "selectedItem.png";
	String AddressPage = "addresspage.png";
	
	String ExpectedErrorMsg = "An account using this email address has already been registered. Please enter a valid password or request a new one. ";
		String ActualErrorMsg = "An account using this email address has already been registered. Please enter a valid password or request a new one. ";
		
	
	@Test()
	public void LoginTest() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	{
		browserobject.manage().window().maximize();
		Registeration.navigateTositeurl();
		Registeration.navigateToCreatAccount();
		ScreenShoot.ScreenShot(loginPage);
	
		
			
		Registeration.navigateToRegisterationPage();
		//LoginPage.navigateLoginPage();
		ScreenShoot.ScreenShot(HomePage);
		
		
	    homePage.navigateToBlousesCategoryPage();
        ScreenShoot.ScreenShot(blousesPage);
        
		blousespage.SelectResultedItem();
		blousespage.AddItemToCart();
		blousespage.ProceedCheckOutProcedure();
		ScreenShoot.ScreenShot(SelectedItem);
		
		
		checkout.FollowCheckOutProcedure();
		checkout.FollowCheckOutProcedure();
		checkout.EnableCheckBox();
		checkout.FollowCheckOutProcedure();
		
		paymentpage.SelectBankWireAndConfirmOrder();
		paymentpage.ValidateOrderExistInOrderHistory();
		ScreenShoot.ScreenShot(OrderPage);
		
		
		
		
		
		
	}
	
	
	
	 @BeforeClass
	  public void beforClass()
	 {
		  System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driiver\\chromedriver.exe");
		  browserobject = new ChromeDriver();
		  wait =new WebDriverWait(browserobject,10);
		  js = (JavascriptExecutor) browserobject;
		  CredentialExceel = new ReadingCredentialFromExceel(browserobject);
		  LoginPage=new Login(browserobject,wait,CredentialExceel);
		  Registeration = new RegisterationPage(browserobject,wait,CredentialExceel);
		  mousehover = new Actions(browserobject);
		  homePage = new HomePage(browserobject,wait, mousehover);
		  blousespage = new BlousesPage(browserobject,wait,js);
		  paymentpage = new PaymentPage(browserobject,wait,js);
		  checkout = new CheckOutProcedurePage (browserobject,wait,js);
		  ScreenShoot =  new CaptureScreenShot(browserobject);
		  
		  
		  
	  }
	  

}
