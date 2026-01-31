package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.UtilityClass;

public class ForgotPasswordPO extends UtilityClass{
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public ForgotPasswordPO(ThreadLocal<WebDriver> driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By ForgotPasswordLink = By.xpath("//a[@class='fcard-link']");
	By forgotPasswordSubmitBtn = By.xpath("//button[text() = 'Submit']");
	By enterYourEmaiBox = By.xpath("//input[@id='user_email']");
	By blankEnterYourEmailError = By.xpath("//div[@class = 'form-group mb-global position-relative']/p[@class = 'red-txt mb-0 text-error']");
	By inCorrectEmailMessage = By.xpath("//div[@class = 'Toastify__toast-body']/div[text() = 'Invalid Username']");
	By CorrectEmailMessage = By.xpath("//div[@class = 'Toastify__toast-body']/div[text() = 'Password sent to your email id']");
	
	public String errorMessageForBlankEnterYourEmailBox()
	{
		myClick(ForgotPasswordLink);
		myClick(forgotPasswordSubmitBtn);
		String message = driver.get().findElement(blankEnterYourEmailError).getText();
		return message;
		
	}
	
	public String errorMessageForInvalidEnterYourEmailBox()
	{
		
		myClick(ForgotPasswordLink);
		mySendKeys(enterYourEmaiBox, "Asdfdf12321");
		String message = driver.get().findElement(blankEnterYourEmailError).getText();
		return message;
	}
	
	public String errorMessageForIncorrectEmail()
	{
		myClick(ForgotPasswordLink);
		mySendKeys(enterYourEmaiBox, "Asdfdf12321@dfds.com");
		myClick(forgotPasswordSubmitBtn);
		toBeVisible(inCorrectEmailMessage);
		String message = driver.get().findElement(inCorrectEmailMessage).getText();
		return message;
		
	}
	
	

	public String MessageForCorrectEmail()
	{
		myClick(ForgotPasswordLink);
		mySendKeys(enterYourEmaiBox, "durgesh.kumar@billgosling.com");
		myClick(forgotPasswordSubmitBtn);
		toBeVisible(CorrectEmailMessage);
		String message = driver.get().findElement(CorrectEmailMessage).getText();
		return message;
		
	}
}
