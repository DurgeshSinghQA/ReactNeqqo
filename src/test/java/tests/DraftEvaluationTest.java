package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;
import pageObjects.DraftEvaluationPO;
import testComponents.BaseClass;
import testComponents.ListenersClass;

@Listeners(ListenersClass.class)
public class DraftEvaluationTest extends BaseClass{
	

	@Test
	public void PHI_TC_Draft_Evaluation_071_callIsShowingInDraftEvaluation() throws IOException, InterruptedException, TesseractException
	{
		DraftEvaluationPO de = new DraftEvaluationPO(driver);
		Boolean isCallShowingInDraftEvaluation = de.callIsShowingInDraftEvaluation();
		Assert.assertEquals(isCallShowingInDraftEvaluation, true);
	}
	
}
