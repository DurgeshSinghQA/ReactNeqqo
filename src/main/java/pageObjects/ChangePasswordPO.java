package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.GetDataFromExcelUtility;
import abstractComponents.UtilityClass;
import abstractComponents.WriteDataInExcelUtility;
import net.sourceforge.tess4j.TesseractException;

public class ChangePasswordPO  extends UtilityClass {
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public ChangePasswordPO(ThreadLocal<WebDriver> driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By changePasswordCard = By.xpath("//h3[text()='Change Password']");
	By changePasswordSubmitBtn = By.xpath("//button[text() = 'Submit']");
	By blankNewPasswordError = By.xpath("//div[@class = 'form-group mb-global position-relative']/p[@class = 'red-txt mb-0 text-error' and text() = 'New password is required']");
	By blankConfirmPasswordError = By.xpath("//div[@class = 'form-group mb-global position-relative']/p[@class = 'red-txt mb-0 text-error' and text() = 'Please confirm your password']");
	By blankInvalidPasswordError = By.xpath("//div[@class = 'form-group mb-global position-relative']/p[@class = 'red-txt mb-0 text-error' and text() = 'Include 12–20 characters, with uppercase, lowercase, number, special character (@ # $ % ^ & + =)']");
	By newPasswordBox = By.xpath("//input[@name='new_pwd']");
	By confirmPasswordBox = By.xpath("//input[@name='confirm_pwd']");
	By last12PasswordError = By.xpath("//div[@class = 'Toastify__toast-body']/div[text() = 'Password should not be same as last 12 password']");
	By passwordChangedMsg = By.xpath("//div[@class = 'Toastify__toast-body']/div[text() = 'Password changed successfully']");
	By loginPageLink = By.xpath("//a[@class = 'fcard-primary-link' and text() = 'Login Page']");
	By signInCard = By.xpath("//h3[text()='Sign in']");
	
	
	public String redirectToChangePasswordPage() throws InterruptedException, IOException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		toBeVisible(changePasswordCard);
		String currentURL = driver.get().getCurrentUrl();
		return currentURL;	
	}
	
	public String errorMessageForBlankNewPassword() throws InterruptedException, IOException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		myClick(changePasswordSubmitBtn);
		toBeVisible(blankNewPasswordError);
		String message = driver.get().findElement(blankNewPasswordError).getText();
		return message;
		
	}
	
	public String errorMessageForBlankConfirmPassword() throws IOException, InterruptedException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		mySendKeys(newPasswordBox, "TestPass@123454334");
		myClick(changePasswordSubmitBtn);
		toBeVisible(blankConfirmPasswordError);
		String message = driver.get().findElement(blankConfirmPasswordError).getText();
		return message;
	}
	
	public String errorMessageForInvalidPassword() throws IOException, InterruptedException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		mySendKeys(newPasswordBox, "a");
		myClick(changePasswordSubmitBtn);
		toBeVisible(blankInvalidPasswordError);
		String message = driver.get().findElement(blankInvalidPasswordError).getText();
		return message;
	}

	
	
	public String errorMessageForLast12Password() throws IOException, InterruptedException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		
		String oldPassword = "Login with correct email and correct password by clicking on Login button";
		String[] arr2 = getExcelData.getData(oldPassword);
		String oldPass = arr2[1];
		
		mySendKeys(newPasswordBox, oldPass);
		mySendKeys(confirmPasswordBox, oldPass);
		
		myClick(changePasswordSubmitBtn);
		toBeVisible(last12PasswordError);
		String message = driver.get().findElement(last12PasswordError).getText();
		return message;
	}
	
	public String redirectToLoginPage() throws IOException, InterruptedException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		myClick(loginPageLink);
		toBeVisible(signInCard);
		String currentURL = driver.get().getCurrentUrl();
		return currentURL;	
	}
	
	public String changePasswordNotDirectlyAccessible()
	{
		driver.get().navigate().to("https://exelonphi.neqqo.com/change-password");
		toBeVisible(signInCard);
		String currentURL = driver.get().getCurrentUrl();
		return currentURL;
		
	}
	
	public String changePasswordSuccessfully() throws IOException, InterruptedException, TesseractException
	{
		ForgotPasswordPO fpo = new ForgotPasswordPO(driver);
		fpo.MessageForCorrectEmail();
		
		String testCase = "Login with default Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
		
		String oldPassword = "Password changes on entering valid and different than last 12 passwords";
		String[] arr2 = getExcelData.getData(oldPassword);
		
		String oldPass = arr2[1];
		String lastdigitofPass = oldPass.substring(oldPass.length()-1);
		int digitTobeAddedinNewPass = Integer.parseInt(lastdigitofPass)+1; 
		String newPass = oldPass.substring(0,oldPass.length()-1)+String.valueOf(digitTobeAddedinNewPass);
		
		mySendKeys(newPasswordBox, newPass);
		mySendKeys(confirmPasswordBox, newPass);
		
		myClick(changePasswordSubmitBtn);
		toBeVisible(passwordChangedMsg);
		String message = driver.get().findElement(passwordChangedMsg).getText();
		
	
		WriteDataInExcelUtility.writeNewPassInExcel(newPass);
		
		return message;
	}

}
