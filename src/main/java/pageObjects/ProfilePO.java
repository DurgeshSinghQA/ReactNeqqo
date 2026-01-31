package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.GetDataFromExcelUtility;
import abstractComponents.UtilityClass;
import abstractComponents.WriteDataInExcelUtility;
import net.sourceforge.tess4j.TesseractException;

public class ProfilePO extends UtilityClass{
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public ProfilePO(ThreadLocal<WebDriver> driver)
	{
		super(driver);
		this.driver = driver;
				
	}
	
	By userProfileName = By.xpath("//header/div/div/div[4]/div/button/span/span[@class = 'user-title d-block']");
	By myProfile = By.xpath("//span[text() = 'My Profile']");
	By userRole = By.xpath("//header/div/div/div[4]/div/button/span/span/span[@class = 'user-post-title']");
	By userDetails = By.xpath("//table/tbody/tr/th");
	By location = By.xpath("//table/tbody/tr/th[text() = 'Location']");
	By changePasswordbtn = By.xpath("//button[text() = 'Change Password']");
	By submitChangePassword = By.xpath("//button[@class = 'btn btn-primary px-4 py-2' and text() = 'Submit']");
	By errorMessageforBlankCurrentPassowrd = By.xpath("//span[text() = 'Current Password']/parent::label/following-sibling::p[@class = 'red-txt mb-0 text-error']");
	By errorMessageForNewPassword = By.xpath("//span[text() = 'New Password']/parent::label/following-sibling::p[@class = 'red-txt mb-0 text-error']");
	By errorMessageforBlankConfirmPassword = By.xpath("//span[text() = 'Confirm Password']/parent::label/following-sibling::p[@class = 'red-txt mb-0 text-error']");
	 
	By currentPasswordBox = By.xpath("//span[text() = 'Current Password']/parent::label/following-sibling::div/input");
	By newPasswordBox = By.xpath("//span[text() = 'New Password']/parent::label/following-sibling::div/input");
	By confirmPasswordBox = By.xpath("//span[text() = 'Confirm Password']/parent::label/following-sibling::div/input");
	
	By oldPasswordError = By.xpath("//div[@class = 'Toastify__toast-body']/div[@class = 'Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']/following-sibling::div");
	
	
	public String userNameDisplayedInHeaderCorrectly() throws InterruptedException, IOException, TesseractException
	{
		login();
		toBeVisible(userProfileName);
		
		String profileName = driver.get().findElement(userProfileName).getText();
		return profileName;
	}
	
	public String roleDisplayedInHeaderCorrectly() throws InterruptedException, IOException, TesseractException
	{
		login();
		toBeVisible(userRole);
		
		String profileName = driver.get().findElement(userRole).getText();
		return profileName;
	}
	
	public String redirectToProfilePageOnClickOnMyProfile() throws InterruptedException, IOException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		String profileUrl = driver.get().getCurrentUrl();
		return profileUrl;
	}
	
	public List<WebElement> userDetailsShowingCorreclty() throws InterruptedException, IOException, TesseractException
	{
		redirectToProfilePageOnClickOnMyProfile();
		//toBeVisible(location);
		List<WebElement> user = driver.get().findElements(userDetails);
		return user;
	}
	
	public String errorMessageForBlankCurrentPassword() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		myClick(submitChangePassword);
		String errorMessage = driver.get().findElement(errorMessageforBlankCurrentPassowrd).getText();
		return errorMessage;
	}
	
	public String errorMessageforBlankNewPassword() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		myClick(submitChangePassword);
		String errorMessage = driver.get().findElement(errorMessageForNewPassword).getText();
		return errorMessage;
	}
	
	public String errorMessageforBlankConfirmPassword() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		myClick(submitChangePassword);
		String errorMessage = driver.get().findElement(errorMessageforBlankConfirmPassword).getText();
		return errorMessage;
	}
	
	public String errorMessageForInvalidPassowrd() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		mySendKeys(newPasswordBox, "a");
		String errorMessage = driver.get().findElement(errorMessageForNewPassword).getText();
		return errorMessage;
		
	}
	
	public String errorMessageForLast12SamePassowrd() throws IOException, InterruptedException, TesseractException
	{
		
		
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		
		GetDataFromExcelUtility gd = new GetDataFromExcelUtility();
		String testCase = "Login with correct email and correct password by clicking on Login button";
		
		String arr[] = gd.getData(testCase);
		String userName = arr[0];
		String password = arr[1];
		
		mySendKeys(currentPasswordBox, password);
		mySendKeys(newPasswordBox, password);
		mySendKeys(confirmPasswordBox, password);
		myClick(submitChangePassword);
		ChangePasswordPO cpp = new ChangePasswordPO(driver);
		By last12PassErr = cpp.last12PasswordError;
		toBeVisible(last12PassErr);
		String errorMessage = driver.get().findElement(last12PassErr).getText();
		return errorMessage;
		
	}
	
	
	public String errorMessageForIncorrectOldPassowrd() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		
		GetDataFromExcelUtility gd = new GetDataFromExcelUtility();
		String testCase = "Login with correct email and correct password by clicking on Login button";
		
		String arr[] = gd.getData(testCase);
		String userName = arr[0];
		String password = arr[1];
		
		mySendKeys(currentPasswordBox, password+"asdsdds");
		mySendKeys(newPasswordBox, password);
		mySendKeys(confirmPasswordBox, password);
		myClick(submitChangePassword);
		toBeVisible(oldPasswordError);
		String errorMessage = driver.get().findElement(oldPasswordError).getText();
		return errorMessage;
		
	}
	
	
	
	public String passwordChanged() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(userProfileName);
		myClick(myProfile);
		myClick(changePasswordbtn);
		
		GetDataFromExcelUtility gd = new GetDataFromExcelUtility();
		String testCase = "Login with correct email and correct password by clicking on Login button";
		
		String arr[] = gd.getData(testCase);
		String userName = arr[0];
				
		String oldPass = arr[1];
		String lastdigitofPass = oldPass.substring(oldPass.length()-1);
		int digitTobeAddedinNewPass = Integer.parseInt(lastdigitofPass)+1; 
		String newPass = oldPass.substring(0,oldPass.length()-1)+String.valueOf(digitTobeAddedinNewPass);
		
		mySendKeys(currentPasswordBox, oldPass);
		mySendKeys(newPasswordBox, newPass);
		mySendKeys(confirmPasswordBox, newPass);
		myClick(submitChangePassword);
		toBeVisible(oldPasswordError);
		String errorMessage = driver.get().findElement(oldPasswordError).getText();
		WriteDataInExcelUtility.writeNewPassInExcel(newPass);
		
		return errorMessage;
		
	}
	
}
