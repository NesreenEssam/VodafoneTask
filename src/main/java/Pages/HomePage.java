package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver browserobject;
	WebDriverWait wait;
	Actions mousehover;

	By WomanCategory = By.xpath("//a[@title=\'Women\']");
	By BlousesCategory =By.xpath("//a[@title=\'Blouses\']");
	
	
	public HomePage(WebDriver browserobject, WebDriverWait wait,Actions mousehover)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		this.mousehover=mousehover;
		
	}
	
	public void navigateToBlousesCategoryPage() throws InterruptedException
	{
		
		mousehover.moveToElement(browserobject.findElement(WomanCategory)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(browserobject.findElement(BlousesCategory)));
		browserobject.findElement(BlousesCategory).click();
		 
	}
	
	
	

	
	
}
