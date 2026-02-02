package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;
import pageObjects.ProfilePO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class ProfileTest extends BaseClass {
	
	@Test
	public void PHI_TC_Profile_054_userNameDisplayedInHeaderCorrectly() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String userName = prof.userNameDisplayedInHeaderCorrectly();
		String expectedUserName  = "Durgesh Kumar" ;
		
		Assert.assertEquals(userName,expectedUserName );
	}
	
	@Test
	public void PHI_TC_Profile_055_roleDisplayedInHeaderCorrectly() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualRole = prof.roleDisplayedInHeaderCorrectly();
		String expectedRole  = "Quality Supervisor" ;
		
		Assert.assertEquals(actualRole,expectedRole );
	}
	
	@Test
	public void PHI_TC_Profile_056_redirectToProfilePageOnClickOnMyProfile() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualurl = prof.redirectToProfilePageOnClickOnMyProfile();
		String expectedUrl  = "url/profile" ;
		
		Assert.assertEquals(actualurl,expectedUrl );
	}
	
	@Test
	public void PHI_TC_Profile_057_userDetailsShowingCorreclty() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		List<WebElement> actualUserDetails = prof.userDetailsShowingCorreclty();
		String expectedUrl  = "url/profile" ;
		
		int count=0;
		String[] userDetailLabels = {"Name", "Email", "Campaign", "Skills", "Vendor", "Location"};
		
		for(WebElement we : actualUserDetails)
		{
			String actualurl = we.getText();
			
			Assert.assertEquals(actualurl,userDetailLabels[count] );
			count++;
		}
		
	}
	
	@Test
	public void PHI_TC_Profile_058_errorMessageForBlankCurrentPassword() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.errorMessageForBlankCurrentPassword();
		String expectederr  = "Current password is required" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
	
	@Test
	public void PHI_TC_Profile_059_errorMessageforBlankNewPassword() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.errorMessageforBlankNewPassword();
		String expectederr  = "New password is required" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
	
	@Test
	public void PHI_TC_Profile_060_errorMessageforBlankConfirmPassword() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.errorMessageforBlankConfirmPassword();
		String expectederr  = "Please confirm your password" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
	
	@Test
	public void PHI_TC_Profile_061_errorMessageForInvalidPassowrd() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.errorMessageForInvalidPassowrd();
		String expectederr  = "Password must be 12-20 characters, include uppercase, lowercase, digit and special character" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
	
	@Test
	public void PHI_TC_Profile_062_errorMessageForLast12SamePassowrd() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.errorMessageForLast12SamePassowrd();
		String expectederr  = "Password should not be same as last 12 password" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
	
	@Test
	public void PHI_TC_Profile_063_errorMessageForIncorrectOldPassowrd() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.errorMessageForIncorrectOldPassowrd();
		String expectederr  = "Old password doesn't match" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
	
	@Test
	public void PHI_TC_Profile_064_passwordChanged() throws InterruptedException, IOException, TesseractException
	{
		
		ProfilePO prof = new ProfilePO(driver);
		String actualerr = prof.passwordChanged();
		String expectederr  = "Password changed successfully" ;
		
		Assert.assertEquals(actualerr,expectederr );
	}
}
