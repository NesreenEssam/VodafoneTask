package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutProcedurePage {

	WebDriver browserobject;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	
	By ProceedToCheckBtn = By.xpath("(//span[contains(.,\'Proceed to checkout\')])[2]");
	By CheckBoxBtn = By.id("uniform-cgv");

	
	public CheckOutProcedurePage(WebDriver browserobject, WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		
		
	}
	
	
	public void FollowCheckOutProcedure() throws InterruptedException
	{
		js = (JavascriptExecutor) browserobject;
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckBtn));
		 WebElement ProceedBtn =browserobject.findElement(ProceedToCheckBtn);  
		 js.executeScript("arguments[0].scrollIntoView(true);", ProceedBtn);
		 ProceedBtn.click();
	}
	
	public void EnableCheckBox() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBoxBtn));
		 WebElement CheckBox =browserobject.findElement(CheckBoxBtn);  
		 js.executeScript("arguments[0].scrollIntoView(true);", CheckBox);
		 CheckBox.click();
		
    }
}
