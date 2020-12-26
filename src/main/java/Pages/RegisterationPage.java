package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.ReadingCredentialFromExceel;

public class RegisterationPage {
	
	WebDriver browserobject;
	WebDriverWait wait;
	ReadingCredentialFromExceel CredentialExceel;
	
	By EmailAddress =By.name("email_create");
	By CreatAcctBtn = By.id("SubmitCreate");
	By SignInPage=By.className("login");
	By RadioBox = By.xpath("//input[@type='radio' and @value='2']");
	By Fname = By.id("customer_firstname");
	By Lname = By.id("customer_lastname");
	By Email = By.id("email");
	By Pass = By.id("passwd");
	By Address = By.id("address1");
	By City = By.id("city");
	By State = By.xpath("//div//select[@id=\'id_state\' and contains(.,\'California\')]");
	By PostalCode = By.id("postcode");
	By PhoneNo = By.id("phone_mobile");
    By AddressAlias = By.id("alias");
    By RegisterBtn = By.id("submitAccount");
	By Country = By.xpath("//div[@id='uniform-id_country'and contains(.,'United States')]");
	
	
	
	
	public RegisterationPage(WebDriver browserobject, WebDriverWait wait,ReadingCredentialFromExceel CredentialExceel)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		this.CredentialExceel=CredentialExceel;
	}
	
	public void navigateTositeurl() throws IOException
	{
		String SiteUrl = CredentialExceel.ReadingData(0,1);
		 browserobject.navigate().to(SiteUrl);
	}

	
	public void navigateToCreatAccount() throws InterruptedException, IOException
	{
	
		String email = CredentialExceel.ReadingData(1, 1);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPage));
	    WebElement SignInBtn =browserobject.findElement(SignInPage);   
        SignInBtn.click();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddress));
	    WebElement EmailField =browserobject.findElement(EmailAddress);  
	    EmailField.sendKeys(email);
	
	   browserobject.findElement(CreatAcctBtn).click();
	
	}
	
	
	
	public void navigateToRegisterationPage() throws InterruptedException, IOException
	{
		
		String email = CredentialExceel.ReadingData(1, 1);
		String Firstname = CredentialExceel.ReadingData(3, 1);
		String Lastname = CredentialExceel.ReadingData(4, 1);
		String Passwd = CredentialExceel.ReadingData(2, 1);
		String address = CredentialExceel.ReadingData(5, 1);
		String city = CredentialExceel.ReadingData(6, 1);
		String postalCode = CredentialExceel.ReadingData(7, 1);
		String mobileNo = CredentialExceel.ReadingData(8, 1);
		String addressAlias = CredentialExceel.ReadingData(9, 1);
		
		
		
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(Fname));
		WebElement FirstNamee =browserobject.findElement(Fname);   
		FirstNamee.clear();     
		FirstNamee.sendKeys(Firstname); 
	 

		wait.until(ExpectedConditions.visibilityOfElementLocated(Lname));
		WebElement LastNamee =browserobject.findElement(Lname);   
		LastNamee.clear();     
		LastNamee.sendKeys(Lastname);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
		WebElement Mail =browserobject.findElement(Email);   
		Mail.clear();       
		Mail.sendKeys(email); 
		

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pass));
		browserobject.findElement(Pass).sendKeys(Passwd);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
		browserobject.findElement(Address).sendKeys(address);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(City));
		browserobject.findElement(City).sendKeys(city);
		
		
		Select Selectdropdown = new Select(browserobject.findElement(By.id("id_state")));  
		Selectdropdown.selectByVisibleText("Alabama");  
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(PostalCode));
		browserobject.findElement(PostalCode).sendKeys(postalCode);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Country));
		browserobject.findElement(Country).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(PhoneNo));
		browserobject.findElement(PhoneNo).sendKeys(mobileNo);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddressAlias));
		browserobject.findElement(AddressAlias).sendKeys(addressAlias);
		browserobject.findElement(RegisterBtn).click();
		
		
	}

}
