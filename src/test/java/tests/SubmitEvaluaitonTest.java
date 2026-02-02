package tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import abstractComponents.GetFormData;
import net.sourceforge.tess4j.TesseractException;
import pageObjects.SubmitEvaluationPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class SubmitEvaluaitonTest extends BaseClass{
	
	@Test
	public void PHI_TC_Evaluation_071_submiteval() throws InterruptedException, IOException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		Boolean status = se.submitCallBySelectingValueInAllFields();
		Assert.assertEquals(status, true, "Submit button doesn't disappeared after submitting call.");
	}
	
	@Test
	public void PHI_TC_Evaluation_072_AvailabilityOfBasicMeta() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		Boolean statusOfBasicMeta = se.basicMetaFieldsAreShowing();
		
		Assert.assertEquals(statusOfBasicMeta, false);
	}
	
	@Test
	public void PHI_TC_Evaluation_073_valuesShowingInBasicMeta() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		Boolean statusOfBasicMeta = se.valuesShowingInbasicMetaFields();
		
		Assert.assertEquals(statusOfBasicMeta, false);
	}
	
	@Test
	public void PHI_TC_Evaluation_074_errorMessageBelowCustomMetaBoxes() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		boolean isErrorShowingForAllCustomMeta = se.errorMessageBelowCustomMetaBoxes();
		Assert.assertEquals(isErrorShowingForAllCustomMeta, true, "Error Message is not showing for all Custom Meta fields below Custom Meta boxes");
	}
	
	@Test
	public void PHI_TC_Evaluation_075_errorMessageBelowCustomMetaBoxes() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		boolean isErrorShowingForAllCustomMeta = se.errorMessageBelowCustomMetaBoxes();
		Assert.assertEquals(isErrorShowingForAllCustomMeta, true, "Error Message is not showing for all Custom Meta fields below Custom Meta boxes");
	}
	
	@Test
	public void PHI_TC_Evaluation_076_valueCanBeEnteredInAllCustomMetaField() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		boolean isAlertMessageShowing = se.valueCanBeEnteredInAllCustomMetaField();
		Assert.assertEquals(isAlertMessageShowing, true, "Value is not entered in all custome meta fields");
	}
	
	@Test
	public void PHI_TC_Evaluation_077_AllCategoriesAreShowing() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		String msg = se.allCategoriesAreShowing();
		Assert.assertEquals(msg, "All categories are showing", msg);
	}
	
	@Test
	public void PHI_TC_Evaluation_078_allAttributesAreShowing() throws IOException, InterruptedException, TesseractException
	{		
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		
		List<String> attributesOnForm = se.allAttributesAreShowing();
		String formAttributeArray[] = attributesOnForm.toArray(new String[0]);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\filename.xlsx";
		List<String> attributesExcel = GetFormData.getData(path, "Attributes");
		String excelAttributesArray[] = attributesExcel.toArray(new String[0]);
		
		SoftAssert sa = new SoftAssert();
		
		int largestSize = attributesExcel.size();
		for(int i=0; i<largestSize; i++)
		{
			sa.assertEquals(formAttributeArray[i], excelAttributesArray[i], "'"+excelAttributesArray[i]+"' is missing");
		}
				
		sa.assertAll();
		
	}
	
	@Test
	public void PHI_TC_Evaluation_079_allSubAttributesAreShowing() throws IOException, InterruptedException, TesseractException
	{		
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		
		List<String> attributesOnForm = se.allSubAttributesAreShowing();
		String formAttributeArray[] = attributesOnForm.toArray(new String[0]);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\filename.xlsx";
		List<String> attributesExcel = GetFormData.getData(path, "Subattributes");
		String excelAttributesArray[] = attributesExcel.toArray(new String[0]);
		
		SoftAssert sa = new SoftAssert();
		
		int largestSize = attributesExcel.size();
		for(int i=0; i<largestSize; i++)
		{
			sa.assertEquals(formAttributeArray[i], excelAttributesArray[i], "'"+excelAttributesArray[i]+"' is missing");
		}
				
		sa.assertAll();
		
	}
	
	@Test
	public void PHI_TC_Evaluation_080_allAttributesRatingsAreShowing() throws IOException, InterruptedException, TesseractException
	{		
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		
		Boolean isRatingMissing = se.allAttributesRatingsAreShowing();
		Assert.assertEquals(isRatingMissing, true, "All ratings are not showing");	
		
	}
	
	@Test
	public void PHI_TC_Evaluation_081_allSubAttributesRatingsAreShowing() throws IOException, InterruptedException, TesseractException
	{		
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		
		Boolean isRatingMissing = se.allSubAttributesRatingsAreShowing();
		Assert.assertEquals(isRatingMissing, true, "All ratings are not showing");	
		
	}
	
	@Test
	public void PHI_TC_Evaluation_082_errorForBlankAttributeRatingIsShowing() throws IOException, InterruptedException, TesseractException
	{
		SubmitEvaluationPO se = new SubmitEvaluationPO(driver);
		
		Boolean isRatingMissing = se.errorForBlankAttributeRatingIsShowing();
		Assert.assertEquals(isRatingMissing, true, "All ratings are not showing");	
	}

	

}

