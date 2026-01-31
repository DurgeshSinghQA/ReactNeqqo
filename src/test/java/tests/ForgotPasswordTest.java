package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class ForgotPasswordTest extends BaseClass{
	
	
	
	@Test
	public void Phi_TC_Forgot_Password_035_errorMessageForBlankEnterYourEmailBox()
	{
		ForgotPasswordPO forgotPass = new ForgotPasswordPO(driver);
		String message = forgotPass.errorMessageForBlankEnterYourEmailBox();
		Assert.assertEquals(message, "Email ID is required !");
	}
	
	@Test
	public void Phi_TC_Forgot_Password_036_errorMessageForInvalidEnterYourEmailBox()
	{
		ForgotPasswordPO forgotPass = new ForgotPasswordPO(driver);
		String message = forgotPass.errorMessageForInvalidEnterYourEmailBox();
		Assert.assertEquals(message, "Enter Valid Email ID !");
	}
	
	
	
	@Test
	public void Phi_TC_Forgot_Password_037_errorMessageForIncorrectEmail()
	{
		ForgotPasswordPO forgotPass = new ForgotPasswordPO(driver);
		String message = forgotPass.errorMessageForIncorrectEmail();
		Assert.assertEquals(message, "Invalid Username");
	}
	
	@Test(groups= {"smoke"})
	public void Phi_TC_Forgot_Password_038_MessageForCorrectEmail()
	{
		ForgotPasswordPO forgotPass = new ForgotPasswordPO(driver);
		String message = forgotPass.MessageForCorrectEmail();
		Assert.assertEquals(message, "Password sent to your email id");
	}

}
