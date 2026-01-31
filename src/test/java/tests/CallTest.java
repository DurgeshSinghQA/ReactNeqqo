package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.sourceforge.tess4j.TesseractException;
import pageObjects.CallPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class CallTest  extends BaseClass {
	
	@Test
	public void Phi_TC_Add_Call_065_errorForAllBlankFields() throws IOException, InterruptedException, TesseractException
	{
		CallPO cp = new CallPO(driver);
		String[] errMsg= cp.errorForAllBlankFields();
		
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(errMsg[0], "Skills is required !  ", "Error for 'Skills' field is incorrect");
        softAssert.assertEquals(errMsg[1], "Campaign is required !", "Error for 'Campaign' field is incorrect.");
        softAssert.assertEquals(errMsg[2], "Vendor is required !", "Error for 'Vendor' field is incorrect.");
        softAssert.assertEquals(errMsg[3], "Location is required !", "Error for 'Location' field is incorrect.");
        softAssert.assertEquals(errMsg[4], "Form name is required !", "Error for 'Form' field is incorrect.");
        softAssert.assertEquals(errMsg[5], "Call date time is required", "Error for 'Call Date & Time' field is incorrect.");
        softAssert.assertEquals(errMsg[6], "Call duration is required", "Error for 'Call Duration' field is incorrect.");
        softAssert.assertEquals(errMsg[7], "Call/Chat ID is required", "Error for 'Call/Chat ID' field is incorrect.");
        softAssert.assertEquals(errMsg[8], "Assign to is required!", "Error for 'Assign To' field is incorrect.");
        softAssert.assertAll();
        
        Thread.sleep(10000);
				
	}
	
	
	
	@Test(groups= {"smoke"})
	public void Phi_TC_Add_Call_066_redirectFormEvaluationPageOnDirectlyEvaluatingTheCall() throws InterruptedException, IOException, TesseractException
	{
		CallPO cp = new CallPO(driver);
		String getFormname = cp.redirectFormEvaluationPageOnDirectlyEvaluatingTheCall();
		Assert.assertEquals(getFormname, "TSI Gas Emergency Coaching FORM (V1.0)");
	}
	
	@Test
	public void PHI_TC_Call_List_067_registeredCallShowingInCallList() throws IOException, InterruptedException, TesseractException
	{
		CallPO cp = new CallPO(driver);
		Boolean isCallShowingInCallList = cp.registeredCallShowingInCallList();
		Assert.assertEquals(isCallShowingInCallList, true);
	}
	
	@Test
	public void PHI_TC_My_Call_068_registeredCallShowingInMyCallList() throws IOException, InterruptedException, TesseractException
	{
		CallPO cp = new CallPO(driver);
		Boolean isCallShowingInMyCallList = cp.registeredCallShowingInMyCallList();
		Assert.assertEquals(isCallShowingInMyCallList, true);
	}

	
	@Test
	public void PHI_TC_Un_Assigned_069_registeredCallShowingInUnAssignedList() throws IOException, InterruptedException, TesseractException
	{
		CallPO cp = new CallPO(driver);
		Boolean isCallShowingInUnAssignedList = cp.registeredCallShowingInUnAssignedList();
		Assert.assertEquals(isCallShowingInUnAssignedList, true);
	}
	
	

}
