package abstractComponents;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.TesseractException;
import pageObjects.LoginPO;

public class UtilityClass {
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	WebDriverWait exWait;
	
	public UtilityClass(ThreadLocal<WebDriver> driver) {
		
		this.driver = (ThreadLocal<WebDriver>) driver;
	}

	public void toBeClickable(By locator)
	{
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		exWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void toBeVisible(By locator)
	{
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		exWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public void toBeStale(By locator)
	{
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		exWait.until(ExpectedConditions.stalenessOf(driver.get().findElement(locator)));
	}
	
	public Boolean toBeDisappear(By locator)
	{
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		Boolean status = exWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return status;
	}
	
	public void toBeChangeAttributeValue(By locator, String attribute, String value)
	{
		WebElement element = driver.get().findElement(locator);
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		exWait.until(ExpectedConditions.not(ExpectedConditions.domAttributeToBe(element, attribute, value)));
		
	}
	
	public void toBeChangeAttributeValue(By locator, String value)
	{
		WebElement element = driver.get().findElement(locator);
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		exWait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, value)));
		
		
	}
	
	public void toBeChangeURL(String url)
	{
		exWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		exWait.until(ExpectedConditions.urlToBe(url));
	}
	
	public void mySendKeys(By locator, String key)
	{
		toBeClickable(locator);
		driver.get().findElement(locator).sendKeys(key);
	}
	
	public void myClick(By locator)
	{
		toBeClickable(locator);
		driver.get().findElement(locator).click();
	}
	
	public void login() throws IOException, InterruptedException, TesseractException
	{
		String testCase = "Login with correct email and correct password by clicking on Login button";
		
		String arr[] = GetDataFromExcelUtility.getData(testCase);
		String userName = arr[0];
		String password = arr[1];
	
		LoginPO lp = new LoginPO(driver);
		lp.login(testCase, userName, password);
	}
	
	
	public void swtichwindow()
	{
		Set<String> winIDs = new HashSet<>();
		winIDs = driver.get().getWindowHandles();
		String windows[] = new String[winIDs.size()]; 
		int count=0;
		
		for(String win : winIDs)
		{
			windows[count] = win;
			count++;
		}
		
		String childWin = windows[1];
		
		driver.get().switchTo().window(childWin);
	}

}
