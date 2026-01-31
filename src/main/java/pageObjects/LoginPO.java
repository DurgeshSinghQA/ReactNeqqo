package pageObjects;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.UtilityClass;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPO extends UtilityClass{
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	@SuppressWarnings("unchecked")
	public LoginPO(ThreadLocal<WebDriver> driver)
	{	super(driver);
		this.driver = (ThreadLocal<WebDriver>) driver;
	}
	
	By userName = By.id("uname_field");
	By passwrd = By.id("pwd_field");
	By captcha = By.id("captcha");
	By loginBtn = By.xpath("//button[contains(text(),'Login')]");
	By dashboard = By.xpath("//h3[@class = 'sc-title d-flex align-items-center']/span[text()='Dashboard']");
	By userNameLabel = By.xpath("//span[text()='Username']");
	By userNameBox = By.xpath("//input[@id='user_name']");
	By password = By.xpath("//span[text()='Password']");
	By passwordBox = By.xpath("//input[@name='user_pwd']");
	By eyeButton = By.xpath("//input[@name='user_pwd']/parent::div//*[name()='svg']/*[name()='path']");
	By enterCaptchaLabel = By.xpath("//span[text()='Enter Captcha']");
	By enterCaptchaBox = By.xpath("//input[@id='login_captcha']");
	By CaptcaBox = By.xpath("//div[@class='mb-0 captcha-box']");
	By ImageInCaptchaBox = By.xpath("//div[@class='mb-0 captcha-box']/img");
	By CaptchaResetButton = By.xpath("//button[@class= 'btn-captcha-reset']");
	By ForgotPasswordLink = By.xpath("//a[@class='fcard-link']");
	By LoginButton = By.xpath("//button[contains(text(),'Login')]");
	By blankUserNameError = By.xpath("//div/p[text()='Username is required !']");
	By blankPasswordError = By.xpath("//div/p[text()='Password is required !']");
	By blankEnterCaptchaBox = By.xpath("//div/p[text()='Captcha is Required !']");
	By invalidUserNamePasswordMsg = By.xpath("//div[text()='Invalid username and password']");
	By invalidCaptchaMsg = By.xpath("//div[text()='Invalid Captcha']");
	By errorForblankfield = By.xpath("//div/p[@class='red-txt mb-0 text-error']");
	By errorForIncorrectCreds = By.xpath("//div[@class='Toastify__toast-body']/div[2]");
	By profileName = By.xpath("//span[@class='user-title d-block']");
	
	
	
	public void loginOnOldApp(String user, String pass) throws InterruptedException
	{
		mySendKeys(userName, user);
		mySendKeys(passwrd, pass);
		myClick(captcha);
		
		Thread.sleep(5000);
		
		myClick(loginBtn);
		toBeVisible(dashboard);
		
	}
	
	public String availabilityOfUsernameLabel()
	{
		String fieldName = driver.get().findElement(userNameLabel).getText();
		
		return fieldName;
	}
	
	public String availabilityOfUsernameBox()
	{
		String fieldName = driver.get().findElement(userNameBox).getTagName();
		
		return fieldName;
	}
	
	public String availabilityOfPasswordLabel()
	{
		String fieldName = driver.get().findElement(password).getText();
		
		return fieldName;
	}
	
	public String availabilityOfPasswordBox()
	{
		String fieldName = driver.get().findElement(passwordBox).getTagName();
		
		return fieldName;
	}
	
	public String availabilityOfEyeButton()
	{
		String fieldName = driver.get().findElement(eyeButton).getAttribute("d");
		
		return fieldName;
	}
	public String crossedRemoveEyeButtonInPasswordTextBox()
	{
		driver.get().findElement(eyeButton).click();
		String fieldName = driver.get().findElement(eyeButton).getAttribute("d");
		return fieldName;
	}
	
	public String passwordUnencryted()
	{
		driver.get().findElement(passwordBox).sendKeys("Pass@123");
		driver.get().findElement(eyeButton).click();
		String fieldName = driver.get().findElement(passwordBox).getAttribute("type");
		return fieldName;
	}
	
	public String availabilityOfEnterCaptchaLabel()
	{
		String fieldName = driver.get().findElement(enterCaptchaLabel).getText();
		return fieldName;
	}
	
	public String availabilityOfEnterCaptchaTextBox()
	{
		String fieldName = driver.get().findElement(enterCaptchaBox).getTagName();
		return fieldName;
	}
	
	public boolean availabilityOfCaptchaBox()
	{
		boolean fieldName = driver.get().findElement(CaptcaBox).isDisplayed();
		return fieldName;
	}
	
	public boolean availabilityOfImageInCaptchaBox()
	{
		toBeVisible(ImageInCaptchaBox);
		boolean fieldName = driver.get().findElement(ImageInCaptchaBox).isDisplayed();
		return fieldName;
	}
	
	public boolean availabilityOfCaptchaResetButton()
	{
		boolean fieldName = driver.get().findElement(CaptchaResetButton).isDisplayed();
		return fieldName;
	}
	
	public String availabilityOfForgotPasswordLink()
	{
		String fieldName = driver.get().findElement(ForgotPasswordLink).getText();
		return fieldName;
	}
		
	public String userNameTextBoxIsEditable()
	{
		driver.get().findElement(userNameBox).sendKeys("TestUserName@123.com");
		String fieldName = driver.get().findElement(userNameBox).getAttribute("value");
		return fieldName;
	}
	
	public String passwordTextBoxIsEditable()
	{
		driver.get().findElement(passwordBox).sendKeys("TestUserName@123");
		String fieldName = driver.get().findElement(passwordBox).getAttribute("value");
		return fieldName;
	}
	
	public String passwordEncrytedByDefault()
	{
		driver.get().findElement(passwordBox).sendKeys("Pass@123");
		String fieldName = driver.get().findElement(passwordBox).getAttribute("type");
		return fieldName;
	}
	
	public String captchaBoxIsEditable()
	{
		driver.get().findElement(enterCaptchaBox).sendKeys("12345");
		String fieldName = driver.get().findElement(enterCaptchaBox).getAttribute("value");
		return fieldName;
	}
	
	public String availabilityOfLoginButton()
	{
		toBeClickable(LoginButton);
		String fieldName = driver.get().findElement(LoginButton).getText();
		return fieldName;
	}
	
	public String errorMessageForBlankUserName()
	{
		myClick(LoginButton);
		toBeVisible(blankUserNameError);
		String fieldName = driver.get().findElement(blankUserNameError).getText();
		return fieldName;
	}
	
	public String errorMessageForBlankPassword()
	{
		myClick(LoginButton);
		toBeVisible(blankPasswordError);
		String fieldName = driver.get().findElement(blankPasswordError).getText();
		return fieldName;
	}
	
	public String errorMessageForBlankEnterCaptcha()
	{
		myClick(LoginButton);
		toBeVisible(blankEnterCaptchaBox);
		String fieldName = driver.get().findElement(blankEnterCaptchaBox).getText();
		return fieldName;
	}
	
	public boolean captchaRefresh()
	{
		toBeVisible(ImageInCaptchaBox);
		
		String intialImageURL = driver.get().findElement(ImageInCaptchaBox).getDomAttribute("src");
		driver.get().findElement(CaptchaResetButton).click();
		toBeChangeAttributeValue(ImageInCaptchaBox, "src", intialImageURL);
		String currentImageURL = driver.get().findElement(ImageInCaptchaBox).getDomAttribute("src");
			
		if(intialImageURL.equalsIgnoreCase(currentImageURL))
		{
			return false;
		}
		
		return true;
	}
	
	public String  loginWithInvalidEmail()
	{
		mySendKeys(userNameBox, "abcdedj");
		
		String message = driver.get().findElement(blankUserNameError).getText();
		return message;
	}
	
	
	
	public String  loginWithIncorrectEmailCorrectPassword() throws InterruptedException, TesseractException
	{
		mySendKeys(userNameBox, "abcdedj@billgosling.com");
		mySendKeys(passwordBox, "Durgesh@1234");
		driver.get().findElement(enterCaptchaBox).click();
		Thread.sleep(Duration.ofSeconds(5));
		
		String recognizedText="";
		
		if(availabilityOfImageInCaptchaBox())
		{
			WebElement captchaImage = driver.get().findElement(CaptcaBox);
			File screenShot = captchaImage.getScreenshotAs(OutputType.FILE);
			ITesseract tesseract = new Tesseract();
			tesseract.setDatapath(System.getProperty("user.dir")+"\\tessData");
			
			recognizedText = tesseract.doOCR(screenShot);
			System.out.println("OCR Recognized Text: " + recognizedText);
			 
		}
		
		driver.get().findElement(enterCaptchaBox).sendKeys(recognizedText);
		driver.get().findElement(loginBtn).click();
		toBeVisible(invalidUserNamePasswordMsg);
		String message = driver.get().findElement(invalidUserNamePasswordMsg).getText();
		return message;
	}
	
	public  void loginWithCorrectEmailCorrectPassword(String userName, String  password) throws InterruptedException, TesseractException
	{
		mySendKeys(userNameBox, userName);
		mySendKeys(passwordBox, password);
		
		Thread.sleep(Duration.ofSeconds(5));
		
		String recognizedText="";
		
		if(availabilityOfImageInCaptchaBox())
		{
			WebElement captchaImage = driver.get().findElement(CaptcaBox);
			File screenShot = captchaImage.getScreenshotAs(OutputType.FILE);
			ITesseract tesseract = new Tesseract();
			tesseract.setDatapath(System.getProperty("user.dir")+"\\tessData");
			
			recognizedText = tesseract.doOCR(screenShot);
			System.out.println("OCR Recognized Text: " + recognizedText);
			 
		}
		
		driver.get().findElement(enterCaptchaBox).sendKeys(recognizedText);
		driver.get().findElement(loginBtn).click();
		
	
	}
	
	
	public void login(String testCase, String userName, String  password) throws InterruptedException, TesseractException
	{
		if(userName.equals("null"))
		{
			userName="";
		}
		if(password.equals("null"))
		{
			password="";
		}
		
		driver.get().findElement(userNameBox).clear();
		driver.get().findElement(passwordBox).clear();
		driver.get().findElement(enterCaptchaBox).clear();
		
		mySendKeys(userNameBox, userName);
		mySendKeys(passwordBox, password);
		Thread.sleep(Duration.ofSeconds(5));
		
		String recognizedText="";
		
		if(availabilityOfImageInCaptchaBox())
		{
			WebElement captchaImage = driver.get().findElement(CaptcaBox);
			File screenShot = captchaImage.getScreenshotAs(OutputType.FILE);
			ITesseract tesseract = new Tesseract();
			tesseract.setDatapath(System.getProperty("user.dir")+"\\tessData");
			
			recognizedText = tesseract.doOCR(screenShot);
			System.out.println("OCR Recognized Text: " + recognizedText);
			 
		}
		
		driver.get().findElement(enterCaptchaBox).sendKeys(recognizedText);
		Thread.sleep(10000);
		
		//driver.get().findElement(loginBtn).click();
		
		if(testCase.equalsIgnoreCase("Login with all fields blank") || testCase.equalsIgnoreCase("Login with invalid email") )
		{
			toBeVisible(blankUserNameError);
			toBeVisible(blankPasswordError);
			toBeVisible(blankEnterCaptchaBox);
		}
		else if(testCase.equalsIgnoreCase("Login with only username"))
		{
			toBeVisible(blankPasswordError);
			toBeVisible(blankEnterCaptchaBox);
		}
		else if(testCase.equalsIgnoreCase("Login with only Password"))
		{
			toBeVisible(blankUserNameError);
			toBeVisible(blankEnterCaptchaBox);
		}
		else if(testCase.equalsIgnoreCase("Login with incorrect email and correct password") || testCase.equalsIgnoreCase("Login with correct email and incorrect password"))
		{
			toBeVisible(invalidUserNamePasswordMsg);
			String message = driver.get().findElement(invalidUserNamePasswordMsg).getText();
			//return message;
		}
		else if(testCase.equalsIgnoreCase("Login with correct email and correct password by clicking on Login button"))
		{
			toBeVisible(profileName);
			String profile = driver.get().findElement(profileName).getText();
			//return profile;
		}
		
		//return "No message";
		
	}
	
	public void loginWithEnterKey(String testCase, String userName, String  password) throws InterruptedException, TesseractException
	{
		if(userName.equals("null"))
		{
			userName="";
		}
		if(password.equals("null"))
		{
			password="";
		}
		
				
		mySendKeys(userNameBox, userName);
		mySendKeys(passwordBox, password);
		Thread.sleep(Duration.ofSeconds(5));
		
		String recognizedText="";
		
		if(availabilityOfImageInCaptchaBox())
		{
			WebElement captchaImage = driver.get().findElement(CaptcaBox);
			File screenShot = captchaImage.getScreenshotAs(OutputType.FILE);
			ITesseract tesseract = new Tesseract();
			tesseract.setDatapath(System.getProperty("user.dir")+"\\tessData");
			
			recognizedText = tesseract.doOCR(screenShot);
			System.out.println("OCR Recognized Text: " + recognizedText);
			 
		}
		
		driver.get().findElement(enterCaptchaBox).sendKeys(recognizedText);
		driver.get().findElement(enterCaptchaBox).sendKeys(Keys.ENTER);
	
		
		
		if(testCase.equalsIgnoreCase("Login with correct email and correct password by pressing enter from keybord"))
		{
			toBeVisible(profileName);
			String profile = driver.get().findElement(profileName).getText();
			//return profile;
		}
		
		//return "No message";
		
	}
	
	public String redirectToForgotPasswordPage()
	{
		myClick(ForgotPasswordLink);
		String forgetUrl = driver.get().getCurrentUrl();
		return forgetUrl;
	}
	
	

}
