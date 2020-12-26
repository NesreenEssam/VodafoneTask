package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlousesPage {
	
	
	
	WebDriver browserobject;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	
	By ResultedProduct = By.xpath("(//a[@title=\'Blouse\'])[2]");
	By AddToCartBtn = By.xpath("//span[contains(.,\'Add to cart\')]");
	By ProceedToCheckBtn = By.xpath("//span[contains(.,\'Proceed to checkout\')]");
	
	public BlousesPage(WebDriver browserobject, WebDriverWait wait,JavascriptExecutor js)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		this.js=js;
		
	}

	public void SelectResultedItem() throws InterruptedException
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(ResultedProduct));
		WebElement ResultedItem =browserobject.findElement(ResultedProduct);  
		
		 js.executeScript("arguments[0].scrollIntoView(true);", ResultedItem);		
			ResultedItem.click();
	}
	
	
	public void AddItemToCart() throws InterruptedException
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartBtn));
		WebElement AddCartBtn =browserobject.findElement(AddToCartBtn);  
		 js.executeScript("arguments[0].scrollIntoView(true);", AddCartBtn);
		 AddCartBtn.click();
	}
	
	public void ProceedCheckOutProcedure() throws InterruptedException
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckBtn));
		 WebElement ProceedBtn =browserobject.findElement(ProceedToCheckBtn);  
		 js.executeScript("arguments[0].scrollIntoView(true);", ProceedBtn);
		 ProceedBtn.click();
	}
	

}
