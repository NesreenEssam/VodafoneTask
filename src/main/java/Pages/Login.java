package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReadingCredentialFromExceel;

public class Login {
	
	WebDriver browserobject;
	WebDriverWait wait;
	ReadingCredentialFromExceel CredentialExceel;

	By Email=By.id("email");
	By Password = By.id("passwd");
	By SignInBtn = By.id("SubmitLogin");
	

	public Login(WebDriver browserobject, WebDriverWait wait,ReadingCredentialFromExceel CredentialExceel)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		this.CredentialExceel=CredentialExceel;
	}
	
	public void navigateLoginPage() throws IOException
	{     
		String email = CredentialExceel.ReadingData(1, 1);
		String Passwd = CredentialExceel.ReadingData(2, 1);
 		
		WebElement Emailbar =browserobject.findElement(Email);   
		Emailbar.clear();   
		Emailbar.sendKeys(email); 
			
		WebElement pswdbar =browserobject.findElement(Password);   
		pswdbar.clear();   
		pswdbar.sendKeys(Passwd); 
		 
		browserobject.findElement(SignInBtn).click();
	}
	
	

}
