package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;
import pageObjects.ChangePasswordPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class ChangePasswordTest extends BaseClass {
	
	@Test
	public void Phi_TC_Change_Password_039_redirectToChangePasswordPage() throws InterruptedException, IOException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String url = cpo.redirectToChangePasswordPage();
		String expectedURL = "https://expectedurl/change-password";
		Assert.assertEquals(url, expectedURL);
	}
	
	@Test
	public void Phi_TC_Change_Password_040_errorMessageForBlankNewPassword() throws InterruptedException, IOException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String message = cpo.errorMessageForBlankNewPassword();
		String expectedMessage = "New password is required";
		Assert.assertEquals(message, expectedMessage);
	}
	
	@Test
	public void Phi_TC_Change_Password_041_errorMessageForBlankConfirmPassword() throws InterruptedException, IOException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String message = cpo.errorMessageForBlankConfirmPassword();
		String expectedMessage = "Please confirm your password";
		Assert.assertEquals(message, expectedMessage);
	}
	
	@Test
	public void Phi_TC_Change_Password_042_errorMessageForInvalidPassword() throws InterruptedException, IOException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String message = cpo.errorMessageForInvalidPassword();
		String expectedMessage = "Include 12–20 characters, with uppercase, lowercase, number, special character (@ # $ % ^ & + =)";
		Assert.assertEquals(message, expectedMessage);
	}
	
	@Test
	public void Phi_TC_Change_Password_043_errorMessageForLast12Password() throws InterruptedException, IOException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String message = cpo.errorMessageForLast12Password();
		String expectedMessage = "Password should not be same as last 12 password";
		Assert.assertEquals(message, expectedMessage);
	}
	
	@Test
	public void Phi_TC_Change_Password_044_redirectToLoginPage() throws InterruptedException, IOException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String url = cpo.redirectToLoginPage();
		String expectedurl = "https://exelonphi.neqqo.com/";
		Assert.assertEquals(url, expectedurl);
	}
	
	@Test
	public void Phi_TC_Change_Password_045_changePasswordNotDirectlyAccessible()
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String url = cpo.changePasswordNotDirectlyAccessible();
		String expectedurl = "https://exelonphi.neqqo.com/";
		Assert.assertEquals(url, expectedurl);
	}
	
	@Test(groups= {"smoke"})
	public void Phi_TC_Change_Password_046_changePasswordSuccessfully() throws IOException, InterruptedException, TesseractException
	{
		ChangePasswordPO cpo = new ChangePasswordPO(driver);
		String message = cpo.changePasswordSuccessfully();
		String expectedMessage = "Password changed successfully";
		Assert.assertEquals(message, expectedMessage);
	}
}
