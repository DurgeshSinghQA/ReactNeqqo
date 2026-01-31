package tests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.sourceforge.tess4j.TesseractException;
import pageObjects.FormPreviewPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class FormPreviewTest extends BaseClass{
	
	@Test
	public void PHI_TC_Form_Preview_070_FormNameShowingInList() throws IOException, InterruptedException, TesseractException
	{
		FormPreviewPO fp = new FormPreviewPO(driver);
		String formNames[] = fp.FormNameShowingInList();
		String form1 = "PHI Gas Emergency Coaching FORM";
		String form2 = "TSI Gas Emergency Coaching FORM";
		String form3 = "PHI QA Coaching FORM";
		String form4 = "PHI QA Experience FORM";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(formNames[0], form1,"'PHI Gas Emergency Coaching FORM' is not showing in List");
		softAssert.assertEquals(formNames[1], form2,"'TSI Gas Emergency Coaching FORM' is not showing in List");
		softAssert.assertEquals(formNames[2], form3,"'PHI QA Coaching FORM' is not showing in List");
		softAssert.assertEquals(formNames[3], form4,"'PHI QA Experience FORM' is not showing in List");
		softAssert.assertAll();
		
	}

}
