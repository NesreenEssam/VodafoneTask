package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PaymentPage {


	WebDriver browserobject;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	By BankWireOption = By.xpath("//a[@title=\'Pay by bank wire\']");
	By ConfirmBtn = By.xpath("//span[contains(.,\'I confirm my order\')]");
	By BackToOrderBtn = By.xpath("//a[@title=\'Back to orders\']");
	By HomeButton = By.xpath("//span[contains(.,\'Home\')]");
	By ActualOrder = By.xpath("(//span[@class='price' and contains(.,'$30.16')])[1]");
	String ActualOrderPrice;
	
	//String ActualOrderPrice = browserobject.findElement(By.xpath("(//span[@class='price' and contains(.,'$30.16')])[1]")).getText();
      //WebElement element =   browserobject.findElement(By.xpath("(//span[@class='price' and contains(.,'$30.16')])[1]"));
	String ExpectedOrderPrice = "$30.16";
	
	public PaymentPage(WebDriver browserobject, WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		
		
	}
	
	public void SelectBankWireAndConfirmOrder() throws InterruptedException
	{
		js = (JavascriptExecutor) browserobject;
		 wait.until(ExpectedConditions.visibilityOfElementLocated(BankWireOption));
		 WebElement BankWire =browserobject.findElement(BankWireOption);  
		 js.executeScript("arguments[0].scrollIntoView(true);", BankWire);
		 BankWire.click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmBtn));
		 WebElement ConfirmOption =browserobject.findElement(ConfirmBtn);  
		 js.executeScript("arguments[0].scrollIntoView(true);", ConfirmOption);
		 ConfirmOption.click();
	}
	
	public void ValidateOrderExistInOrderHistory() throws InterruptedException
	{
		 ActualOrderPrice = browserobject.findElement(ActualOrder).getText();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(BackToOrderBtn));
		 WebElement BackToOrderOption =browserobject.findElement(BackToOrderBtn);  
		 js.executeScript("arguments[0].scrollIntoView(true);", BackToOrderOption);
		 BackToOrderOption.click();
		
		 js.executeScript("window.scrollTo(0, 250)");
		
		 
		 Assert.assertEquals(ActualOrderPrice, ExpectedOrderPrice);
	}
	
	
	
	
	
}
