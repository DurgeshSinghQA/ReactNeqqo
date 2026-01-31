package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import abstractComponents.GetDataFromExcelUtility;
import net.sourceforge.tess4j.TesseractException;
import pageObjects.ForgotPasswordPO;
import pageObjects.LoginPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class LoginTest extends BaseClass{
	
	
	
	@Test
	public void Phi_TC_Login_001_availabilityOfUsernameLabel()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfUsernameLabel();
		Assert.assertEquals(fieldName, "Username");
	}
	
	@Test
	public void Phi_TC_Login_002_availabilityOfUsernameTextBox()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfUsernameBox();
		Assert.assertEquals(fieldName, "input");
	}
	
	@Test
	public void Phi_TC_Login_003_availabilityOfPasswordLabel()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfPasswordLabel();
		Assert.assertEquals(fieldName, "Password");
	}
	
	@Test
	public void Phi_TC_Login_004_availabilityOfPasswordTextBox()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfPasswordBox();
		Assert.assertEquals(fieldName, "input");
	}
	
	@Test
	public void Phi_TC_Login_005_availabilityOfEyeButtonInPasswordTextBox()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfEyeButton();
		Assert.assertEquals(fieldName, "M38.8 5.1C28.4-3.1 13.3-1.2 5.1 9.2S-1.2 34.7 9.2 42.9l592 464c10.4 8.2 25.5 6.3 33.7-4.1s6.3-25.5-4.1-33.7L525.6 386.7c39.6-40.6 66.4-86.1 79.9-118.4c3.3-7.9 3.3-16.7 0-24.6c-14.9-35.7-46.2-87.7-93-131.1C465.5 68.8 400.8 32 320 32c-68.2 0-125 26.3-169.3 60.8L38.8 5.1zM223.1 149.5C248.6 126.2 282.7 112 320 112c79.5 0 144 64.5 144 144c0 24.9-6.3 48.3-17.4 68.7L408 294.5c8.4-19.3 10.6-41.4 4.8-63.3c-11.1-41.5-47.8-69.4-88.6-71.1c-5.8-.2-9.2 6.1-7.4 11.7c2.1 6.4 3.3 13.2 3.3 20.3c0 10.2-2.4 19.8-6.6 28.3l-90.3-70.8zM373 389.9c-16.4 6.5-34.3 10.1-53 10.1c-79.5 0-144-64.5-144-144c0-6.9 .5-13.6 1.4-20.2L83.1 161.5C60.3 191.2 44 220.8 34.5 243.7c-3.3 7.9-3.3 16.7 0 24.6c14.9 35.7 46.2 87.7 93 131.1C174.5 443.2 239.2 480 320 480c47.8 0 89.9-12.9 126.2-32.5L373 389.9z");
	}
	
	@Test
	public void Phi_TC_Login_006_crossedEyeButtonInPasswordTextBox()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfEyeButton();
		Assert.assertEquals(fieldName, "M38.8 5.1C28.4-3.1 13.3-1.2 5.1 9.2S-1.2 34.7 9.2 42.9l592 464c10.4 8.2 25.5 6.3 33.7-4.1s6.3-25.5-4.1-33.7L525.6 386.7c39.6-40.6 66.4-86.1 79.9-118.4c3.3-7.9 3.3-16.7 0-24.6c-14.9-35.7-46.2-87.7-93-131.1C465.5 68.8 400.8 32 320 32c-68.2 0-125 26.3-169.3 60.8L38.8 5.1zM223.1 149.5C248.6 126.2 282.7 112 320 112c79.5 0 144 64.5 144 144c0 24.9-6.3 48.3-17.4 68.7L408 294.5c8.4-19.3 10.6-41.4 4.8-63.3c-11.1-41.5-47.8-69.4-88.6-71.1c-5.8-.2-9.2 6.1-7.4 11.7c2.1 6.4 3.3 13.2 3.3 20.3c0 10.2-2.4 19.8-6.6 28.3l-90.3-70.8zM373 389.9c-16.4 6.5-34.3 10.1-53 10.1c-79.5 0-144-64.5-144-144c0-6.9 .5-13.6 1.4-20.2L83.1 161.5C60.3 191.2 44 220.8 34.5 243.7c-3.3 7.9-3.3 16.7 0 24.6c14.9 35.7 46.2 87.7 93 131.1C174.5 443.2 239.2 480 320 480c47.8 0 89.9-12.9 126.2-32.5L373 389.9z");
	}
	
	@Test
	public void Phi_TC_Login_007_crossedRemoveEyeButtonInPasswordTextBox()
	{		
		LoginPO login = new LoginPO(driver);
		String fieldName = login.crossedRemoveEyeButtonInPasswordTextBox();
		Assert.assertEquals(fieldName, "M288 32c-80.8 0-145.5 36.8-192.6 80.6C48.6 156 17.3 208 2.5 243.7c-3.3 7.9-3.3 16.7 0 24.6C17.3 304 48.6 356 95.4 399.4C142.5 443.2 207.2 480 288 480s145.5-36.8 192.6-80.6c46.8-43.5 78.1-95.4 93-131.1c3.3-7.9 3.3-16.7 0-24.6c-14.9-35.7-46.2-87.7-93-131.1C433.5 68.8 368.8 32 288 32zM144 256a144 144 0 1 1 288 0 144 144 0 1 1 -288 0zm144-64c0 35.3-28.7 64-64 64c-7.1 0-13.9-1.2-20.3-3.3c-5.5-1.8-11.9 1.6-11.7 7.4c.3 6.9 1.3 13.8 3.2 20.7c13.7 51.2 66.4 81.6 117.6 67.9s81.6-66.4 67.9-117.6c-11.1-41.5-47.8-69.4-88.6-71.1c-5.8-.2-9.2 6.1-7.4 11.7c2.1 6.4 3.3 13.2 3.3 20.3z");
	}
	
	@Test
	public void Phi_TC_Login_008_passwordUnencryted()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.passwordUnencryted();
		Assert.assertEquals(fieldName, "text");
	}
	
	@Test
	public void Phi_TC_Login_009_availabilityOfEnterCaptchaLabel()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfEnterCaptchaLabel();
		Assert.assertEquals(fieldName, "Enter Captcha");
	}
	
	@Test
	public void Phi_TC_Login_010_availabilityOfEnterCaptchaTextBox()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfEnterCaptchaTextBox();
		Assert.assertEquals(fieldName, "input");
	}
	
	@Test
	public void Phi_TC_Login_011_availabilityOfCaptchaBox()
	{
		LoginPO login = new LoginPO(driver);
		boolean fieldName = login.availabilityOfCaptchaBox();
		Assert.assertEquals(fieldName, true);
	}
	
	@Test
	public void Phi_TC_Login_012_availabilityOfImageInCaptchaBox()
	{
		LoginPO login = new LoginPO(driver);
		boolean fieldName = login.availabilityOfImageInCaptchaBox();
		Assert.assertEquals(fieldName, true);
	}
	
	@Test
	public void Phi_TC_Login_013_availabilityOfCaptchaResetButton()
	{
		LoginPO login = new LoginPO(driver);
		boolean fieldName = login.availabilityOfCaptchaResetButton();
		Assert.assertEquals(fieldName, true);
	}
	
	@Test
	public void Phi_TC_Login_014_availabilityOfForgotPasswordLink()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfForgotPasswordLink();
		Assert.assertEquals(fieldName, "Forgot Password?");
	}
	
	@Test
	public void Phi_TC_Login_015_userNameTextBoxIsEditable()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.userNameTextBoxIsEditable();
		Assert.assertEquals(fieldName, "TestUserName@123.com");
	}
	
	@Test
	public void Phi_TC_Login_016_passwordTextBoxIsEditable()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.passwordTextBoxIsEditable();
		Assert.assertEquals(fieldName, "TestUserName@123");
	}
	
	@Test
	public void Phi_TC_Login_017_passwordEncrytedByDefault()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.passwordEncrytedByDefault();
		Assert.assertEquals(fieldName, "password");
	}
	
	@Test
	public void Phi_TC_Login_018_captchaBoxIsEditable()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.captchaBoxIsEditable();
		Assert.assertEquals(fieldName, "12345");
	}
	
	@Test
	public void Phi_TC_Login_019_availabilityOfLoginButton()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.availabilityOfLoginButton();
		Assert.assertEquals(fieldName, "Login");	
	}
	
	@Test
	public void Phi_TC_Login_020_errorMessageForBlankUserName()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.errorMessageForBlankUserName();
		Assert.assertEquals(fieldName, "Username is required !");	
	}
	
	@Test
	public void Phi_TC_Login_021_errorMessageForBlankPassword()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.errorMessageForBlankPassword();
		Assert.assertEquals(fieldName, "Password is required !");	
	}
	
	@Test
	public void Phi_TC_Login_022_errorMessageForBlankEnterCaptcha()
	{
		LoginPO login = new LoginPO(driver);
		String fieldName = login.errorMessageForBlankEnterCaptcha();
		Assert.assertEquals(fieldName, "Captcha is Required !");	
	}
	
	@Test
	public void Phi_TC_Login_023_captchaRefresh()
	{
		LoginPO login = new LoginPO(driver);
		boolean isRefreshed = login.captchaRefresh();
		Assert.assertEquals(isRefreshed, true);
	}
	
	@Test
	public void Phi_TC_Login_024_loginWithAllFieldsBlank() throws InterruptedException, IOException, TesseractException
	{
		String testCase = "Login with all fields blank";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	@Test
	public void Phi_TC_Login_025_loginWithOnlyUsername() throws InterruptedException, IOException, TesseractException
	{
		String testCase = "Login with only username";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	@Test
	public void Phi_TC_Login_026_loginWithOnlyPassword() throws InterruptedException, IOException, TesseractException
	{
		String testCase = "Login with only Password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	
	
	@Test
	public void Phi_TC_Login_028_loginWithInvalidEmail() throws IOException, InterruptedException, TesseractException
	{
		String testCase = "Login with invalid email";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	@Test
	public void Phi_TC_Login_029_logWithIncorrectEmailAndCorrectPassword() throws IOException, InterruptedException, TesseractException
	{
		String testCase = "Login with incorrect email and correct password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	@Test
	public void Phi_TC_Login_030_loginWithCorrectEmailAndIncorrectPassword() throws IOException, InterruptedException, TesseractException
	{
		String testCase = "Login with correct email and incorrect password";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	@Test(groups= {"smoke"})
	public void Phi_TC_Login_032_loginWithCorrectEmailAndCorrectPasswordByClickingOnLoginButton() throws IOException, InterruptedException, TesseractException
	{
		String testCase = "Login with correct email and correct password by clicking on Login button";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.login(testCase, user, pass);
	}
	
	@Test
	public void Phi_TC_Login_033_loginWithCorrectEmailAndCorrectPasswordByPressingEnterFromKeybord() throws IOException, InterruptedException, TesseractException
	{
		String testCase = "Login with correct email and correct password by pressing enter from keybord";
		GetDataFromExcelUtility getExcelData = new GetDataFromExcelUtility();
		
		String[] arr = getExcelData.getData(testCase);
		
		String user = arr[0];
		String pass = arr[1];
		LoginPO login = new LoginPO(driver);
		login.loginWithEnterKey(testCase, user, pass);
	}
	
	@Test
	public void Phi_TC_Login_034_redirectToForgotPassword()
	{
		String forgetPaswordURL = "https://exelonphi.neqqo.com/forget-password";
		LoginPO login = new LoginPO(driver);
		String url = login.redirectToForgotPasswordPage();
		Assert.assertEquals(url, forgetPaswordURL);
	}

	
	
	/*
	@Test(dataProvider = "userDetails", dataProviderClass = testComponents.DataProviders.class)
	public void loginWithCorrectEmailAndCorrectPassword(String arr[]) throws InterruptedException
	{
		LoginPO login = new LoginPO(driver);
		
		if(arr[1].equalsIgnoreCase("Login with correct email and correct password by clicking on Login button"))
		{
			String error = login.login(arr[1], arr[2], arr[3]);
			System.out.println(error);
		}
		
	}
	
	
	
	@Test(dataProvider = "userDetails", dataProviderClass = testComponents.DataProviders.class)
	public void login(String arr[]) throws IOException, InterruptedException
	{
			
		LoginPO login = new LoginPO(driver);
		
		String error = login.login(arr[1], arr[2], arr[3]);
		System.out.println(error);
		
	}
	
	*/

}
