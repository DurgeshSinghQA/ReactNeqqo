package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.GetFormData;
import abstractComponents.UtilityClass;
import net.sourceforge.tess4j.TesseractException;

public class SubmitEvaluationPO extends  UtilityClass{
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public SubmitEvaluationPO(ThreadLocal<WebDriver> driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By callId = By.xpath("//*[@id=\"basic-meta\"]/div/div[1]/div[2]/p");
	By callIdInMyCall = By.xpath("//a[text() = 'TestCall_002']");
	
	
	
	
	By customButton = By.xpath("//*[@id='custom-meta-tab']");
	By typeOfEvaluation = By.xpath("//*[@id='custom-meta']/div/div/div[1]/input");
	
	By callType = By.xpath("//*[@id='custom-meta']/div/div/div[2]/select");
	By callTypeOption = By.xpath("//*[@id=\"custom-meta\"]/div/div/div[2]/select/option[2]");
	
	By mediaFileType = By.xpath("//*[@id='custom-meta']/div/div/div[3]/select");
	By mediaFileTypeOption = By.xpath("//*[@id=\"custom-meta\"]/div/div/div[3]/select/option[3]");
	
	By language = By.xpath("//*[@id='custom-meta']/div/div/div[4]/select");
	By languageOption = By.xpath("//*[@id=\"custom-meta\"]/div/div/div[4]/select/option[2]");
	
	By agentType = By.xpath("//*[@id='custom-meta']/div/div/div[5]/input");
	By agentStatus = By.xpath("//*[@id='custom-meta']/div/div/div[6]/input");
	By contractAccount = By.xpath("//*[@id='custom-meta']/div/div/div[7]/input");
	By callDirection = By.xpath("//*[@id='custom-meta']/div/div/div[8]/input");
	By utilityType = By.xpath("//*[@id=\"custom-meta\"]/div/div/div[9]/input");
	By nICELink = By.xpath("//*[@id=\"custom-meta\"]/div/div/div[10]/input");
	By wFH = By.xpath("//*[@id='custom-meta']/div/div/div[11]/input");
	By disposition = By.xpath("//*[@id=\"custom-meta\"]/div/div/div[12]/input");
	By evaluatorComment = By.xpath("//*[@id=\"evaluator_cmnt\"]");
	By formSubmitButton = By.xpath("//form/div[@class='submit-btn-group']/div/button[text()='Submit']");
	By yesConfirmButton = By.xpath("//*[@id=\"submitEval\"]/div/div/div[2]/div/button[1]");
	
	By menuOptionCall = By.xpath("//ul[@class='main-menu']//span[text()='Call']");
	By menuOptionAddCall = By.xpath("//ul[@class='main-menu']//span[text()='Add Call']");
	By menuOptionCallList = By.xpath("//ul[@class='main-menu']//span[text()='Call List']");
	By menuOptionMyCall = By.xpath("//ul[@class='main-menu']//span[text()='My Call']");
	By menuOptionUnAssigned = By.xpath("//ul[@class='main-menu']//span[text()='Un-Assigned']");
	
	By allBasicMetafieldsName = By.xpath("//div[@id='basic-meta']/div/div/div[@class='box-header']/div");
	By basicMetaCallId = By.xpath("//div[@id='basic-meta']/div/div/div[@class='box-header']/div[text() = 'Call ID']");
	By basicMetaEvaluatorIdValue = By.xpath("//div[@id='basic-meta']/div/div/div[@class='box-body']/p[text()='Durgesh Kumar']");
	By allBasicMetafieldsValues = By.xpath("//div[@id='basic-meta']/div/div/div[@class='box-body']/p");
	By customMetaNames = By.xpath("//div[@id='custom-meta']/div/div/div/label");
	By customMetaErrors = By.xpath("//div[@id='custom-meta']/div/div/div/p");
	By customMetaAlertMessage = By.xpath("//div[@class='Toastify']/div/div[@id='customFieldRequired']/div/div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']/following-sibling::div");
	By customMetaType = By.xpath("(//div[@id='custom-meta']/div/div/div/label[text()='Type of Evaluation']/following-sibling::*)[2]");
	By categoriesNames = By.xpath("//div[@id='evaluationCategories']/div/div[contains(@id,'cat')]/div/h4");
	By attributesNames = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4");
	By subAttributeNames = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='box-body p-0']/div/div/div/h4");
	
	By errorForBlankRating = By.xpath("//div[@role='alert' and @class = 'Toastify__toast-body']/div/div/div");
	
	public Boolean submitCallBySelectingValueInAllFields() throws InterruptedException, IOException, TesseractException
	{
		CallPO cp = new CallPO(driver);
		cp.redirectFormEvaluationPageOnDirectlyEvaluatingTheCall();
		
		String getCallId = driver.get().findElement(callId).getText();
		System.out.println(getCallId);
		
		myClick(customButton);
		mySendKeys(typeOfEvaluation, "test Evalution Type");
		myClick(callType);
		myClick(callTypeOption);
		myClick(mediaFileType);
		myClick(mediaFileTypeOption);
		myClick(language);
		myClick(languageOption);
		
		mySendKeys(agentType, "test agentType");
		mySendKeys(agentStatus, "test agentStatus");
		mySendKeys(contractAccount, "test contractAccount");
		mySendKeys(callDirection, "test callDirection");
		mySendKeys(utilityType, "test utilityType");
		mySendKeys(nICELink, "test nICELink");
		mySendKeys(wFH, "test wFH");
		mySendKeys(disposition, "test disposition");
		mySendKeys(evaluatorComment, "test evaluatorComment");
		mySendKeys(formSubmitButton, "test formSubmitButton");
		mySendKeys(yesConfirmButton, "test yesConfirmButton");
		
		Boolean isSumbitButtonInvisible = toBeDisappear(formSubmitButton);
		
		return isSumbitButtonInvisible;
	}
	
	public Boolean  basicMetaFieldsAreShowing() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		
		toBeVisible(basicMetaEvaluatorIdValue);
		List<WebElement> basicMetaField = driver.get().findElements(allBasicMetafieldsName);
		
		List<String> getBasicMetafieldsForm = new ArrayList<>();
				 
		for(WebElement meta : basicMetaField)
		{
			getBasicMetafieldsForm.add(meta.getText());
		}
		
		//System.out.println(getBasicMetafieldsForm);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> basicMetaExcel = GetFormData.getData(path, "Basic Meta fields");
		//System.out.println(basicMetaExcel);
		
		List<String> missingBasicMeta = new ArrayList<>();
		
		Boolean isBasicMeatMissing= false;
		
		for(String name : basicMetaExcel)
		{
			if(!getBasicMetafieldsForm.contains(name))
			{
				missingBasicMeta.add(name);
				isBasicMeatMissing = true;
			}
		}
		
		System.out.println("Missing Meta Fields: " + missingBasicMeta);
		
		return isBasicMeatMissing;
	}
	
	public Boolean  valuesShowingInbasicMetaFields() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(basicMetaEvaluatorIdValue);
		
		
		
		List<WebElement> basicMetaFieldValuesElment = driver.get().findElements(allBasicMetafieldsValues);
		List<String> getBasicMetafieldsForm = new ArrayList<>();
		 
		for(WebElement meta : basicMetaFieldValuesElment)
		{
			getBasicMetafieldsForm.add(meta.getText());
		}
		
		System.out.println(getBasicMetafieldsForm);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> basicMetaExcel = GetFormData.getData(path, "Basic Meta Fields Values");
		
		System.out.println(basicMetaExcel);
		
		List<String> missingBasicMeta = new ArrayList<>();
		
		Boolean isBasicMeatMissing= false;
		
		for(String value : basicMetaExcel)
		{
			if(!getBasicMetafieldsForm.contains(value))
			{
				missingBasicMeta.add(value);
				isBasicMeatMissing = true;
			}
		}
		
		System.out.println("Missing Meta Fields: " + missingBasicMeta);
		
		return isBasicMeatMissing;
	}
	
	public boolean errorMessageBelowCustomMetaBoxes() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(basicMetaEvaluatorIdValue);
		myClick(customButton);
		
		Actions act = new Actions(driver.get());
		
		act.scrollToElement(driver.get().findElement(formSubmitButton)).perform();
		myClick(formSubmitButton);
		
		List<WebElement> customMetaFieldsElment = driver.get().findElements(customMetaNames);
		List<String> getCustomMetafieldsForm = new ArrayList<>();
		 
		for(WebElement meta : customMetaFieldsElment)
		{
			getCustomMetafieldsForm.add(meta.getText());
		}
		
		List<WebElement> customMetaFieldsErrors = driver.get().findElements(customMetaErrors);
		List<String> getCustomMetafieldsErrors = new ArrayList<>();
		
		for(WebElement error : customMetaFieldsErrors)
		{
			getCustomMetafieldsErrors.add(error.getText());
		}
		
		boolean isErrorForAllCustomMeta= true;
		
		for(String err : getCustomMetafieldsForm)
		{
			String errorMessage = err+" is required";
			
			if(!getCustomMetafieldsErrors.contains(errorMessage))
			{
				isErrorForAllCustomMeta = false;
			}	
		}
		
		return isErrorForAllCustomMeta;
		
	}
	
	public boolean errorMessageCustomMetaAtTheBottonOfThePage() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(basicMetaEvaluatorIdValue);
				
		Actions act = new Actions(driver.get());
		
		act.scrollToElement(driver.get().findElement(formSubmitButton)).perform();
		
		myClick(formSubmitButton);
		toBeVisible(customMetaAlertMessage);
		String cutomMetaAlert = driver.get().findElement(customMetaAlertMessage).getText();
		
		if(cutomMetaAlert.equals("Custom Fields are Required!"))
			return true;
		
		return false;
		
	}
		
	public boolean valueCanBeEnteredInAllCustomMetaField() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		myClick(customButton);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> customMetaExcel = GetFormData.getData(path, "Custon Meta Fields");
		
		for(String customname : customMetaExcel)
		{
			By customMetaType = By.xpath("(//div[@id='custom-meta']/div/div/div/label[text()='"+customname+"']/following-sibling::*)[2]");
			toBeVisible(customMetaType);
			String customTagName = driver.get().findElement(customMetaType).getTagName();
			
			if(customTagName.equals("select"))
			{
				Select sel = new Select(driver.get().findElement(customMetaType));
				sel.selectByIndex(1);
				System.out.println(driver.get().findElement(customMetaType).getText());
			}
			else if(customTagName.equals("input"))
			{
				driver.get().findElement(customMetaType).sendKeys("Test Value "+customname);
			}
		}
		
		Actions act = new Actions(driver.get());
		
		act.scrollToElement(driver.get().findElement(formSubmitButton)).perform();
		
		myClick(formSubmitButton);
		
		try
		{
			WebElement el = driver.get().findElement(customMetaAlertMessage);

			if(el.isDisplayed())
			{
				return false;
			}			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Error message element not found, validation passed.");	
		}
		
		return true;
	}
	
	public String allCategoriesAreShowing() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(categoriesNames);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> categoriesExcel = GetFormData.getData(path, "Categories");
		
		List<WebElement> categoriesOnForm = driver.get().findElements(categoriesNames);
		List<String> categoryOnForm = new ArrayList<>();
		
		for(WebElement el : categoriesOnForm)
		{
			categoryOnForm.add(el.getText());
		}
		
		for(String catgoryName : categoriesExcel)
		{	
			if(!catgoryName.equals(""))
			{
				if(!categoryOnForm.contains(catgoryName))
				{
					String msg = "Category '"+catgoryName+"' is not showing on form";
					return msg;
				}
			}
		}
		String msg = "All categories are showing";
		return msg;
	}
	
	public List<String> allAttributesAreShowing() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(basicMetaEvaluatorIdValue);
	
		List<WebElement> attributesOnForm = driver.get().findElements(attributesNames);
		List<String> attributeOnForm = new ArrayList<>();
		
		for(WebElement el : attributesOnForm)
		{
			attributeOnForm.add(el.getText());
		}
				
		return attributeOnForm;		
	}
	
	public List<String> allSubAttributesAreShowing() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(basicMetaEvaluatorIdValue);
	
		List<WebElement> attributesOnForm = driver.get().findElements(subAttributeNames);
		List<String> attributeOnForm = new ArrayList<>();
		
		for(WebElement el : attributesOnForm)
		{
			attributeOnForm.add(el.getText());
		}
				
		return attributeOnForm;		
	}
	
	
	public Boolean allAttributesRatingsAreShowing() throws IOException, InterruptedException, TesseractException
	{
		Boolean isRatingMissing = true;
		
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		toBeVisible(basicMetaEvaluatorIdValue);
	
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> attributeAndRatingExcel = GetFormData.getData(path, "Ratings");
		for(String ratings : attributeAndRatingExcel)
		{
			String ratingArr[] = ratings.split("@,");
						
			String attr = ratingArr[0];
			
									
			By getRatings = By.xpath("");
						
			if(attr.contains("'") && !attr.contains("\""))
			{
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()=\""+attr+"\"]/parent::div/following-sibling::div/select/option");
			}
			else if(!attr.contains("'") && attr.contains("\""))
			{
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/select/option");
			}
			else if(attr.contains("'") && attr.contains("\""))
			{
				String splitAttr[] = attr.split("\"");
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[contains(text(),'"+splitAttr[0]+"')]/parent::div/following-sibling::div/select/option");
				
			}
			else
			{
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/select/option");
			}
			
			
			List<WebElement> ratingsElements = driver.get().findElements(getRatings);
			List<String> ratingNames = new ArrayList<>();
			
			for(WebElement el : ratingsElements)
			{
				ratingNames.add(el.getText());
			}
			
			
			for(int i= 1; i<ratingArr.length; i++)
			{
				if(!ratingNames.contains(ratingArr[i]))
				{
					isRatingMissing = false;
					System.out.println("Attribute Name : " + ratingArr[0]);
					System.out.println("Missing Rating : " + ratingArr[i]);
				}
			}
		}
		return isRatingMissing;
						
		
	}
	
	public Boolean allSubAttributesRatingsAreShowing() throws IOException, InterruptedException, TesseractException
	{
		Boolean isRatingMissing = true;
		
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		System.out.println("Window switched");
		toBeVisible(basicMetaEvaluatorIdValue);
	
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> attributeAndRatingExcel = GetFormData.getData(path, "Sub-Attribute Ratings");
		
		for(String ratings : attributeAndRatingExcel)
		{
			String ratingArr[] = ratings.split("@,");
			//System.out.println(Arrays.toString(ratingArr));			
			String attr = ratingArr[0];
			//System.out.println("ratingArr[0]: "+attr);
									
			By getRatings = By.xpath("");
						
			if(attr.contains("'") && !attr.contains("\""))
			{
				//getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()=\""+attr+"\"]/parent::div/following-sibling::div/select/option");
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='box-body p-0']/div/div/div/h4[text()=\""+attr+"\"]/parent::div/following-sibling::div/div/div/div/label");
			}
			else if(!attr.contains("'") && attr.contains("\""))
			{
				//getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/select/option");
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='box-body p-0']/div/div/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/div/div/div/label");
			}
			else if(attr.contains("'") && attr.contains("\""))
			{
				String splitAttr[] = attr.split("\"");
				//getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[contains(text(),'"+splitAttr[0]+"')]/parent::div/following-sibling::div/select/option");
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='box-body p-0']/div/div/div/h4[contains(text(),'"+splitAttr[0]+"')]/parent::div/following-sibling::div/div/div/div/label");
			}
			else
			{
				
				//getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/select/option");
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='box-body p-0']/div/div/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/div/div/div/label");
			}
			
			
			List<WebElement> ratingsElements = driver.get().findElements(getRatings);
			List<String> ratingNames = new ArrayList<>();
			
			for(WebElement el : ratingsElements)
			{
				ratingNames.add(el.getText());
				
			}
			
			
			for(int i= 1; i<ratingArr.length; i++)
			{
				if(!ratingNames.contains(ratingArr[i]))
				{
					isRatingMissing = false;
					System.out.println("Attribute Name : " + ratingArr[0]);
					System.out.println("Missing Rating : " + ratingArr[i]);
				}
				
			}
		}
		
		return isRatingMissing;
						
		
	}
	
	public Boolean errorForBlankAttributeRatingIsShowing() throws IOException, InterruptedException, TesseractException
	{
		Boolean isRatingMissing = false;
		
		login();
		myClick(menuOptionCall);
		myClick(menuOptionMyCall);
		myClick(callIdInMyCall);
		swtichwindow();
		myClick(customButton);
		String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> customMetaExcel = GetFormData.getData(path, "Custon Meta Fields");
		
		for(String customname : customMetaExcel)
		{
			By customMetaType = By.xpath("(//div[@id='custom-meta']/div/div/div/label[text()='"+customname+"']/following-sibling::*)[2]");
			toBeVisible(customMetaType);
			String customTagName = driver.get().findElement(customMetaType).getTagName();
			
			if(customTagName.equals("select"))
			{
				Select sel = new Select(driver.get().findElement(customMetaType));
				sel.selectByIndex(1);
				//System.out.println(driver.get().findElement(customMetaType).getText());
			}
			else if(customTagName.equals("input"))
			{
				driver.get().findElement(customMetaType).sendKeys("Test Value "+customname);
			}
		}
		
		
		
		//String path = "C:\\Users\\durgesh.kumar\\Documents\\Durgesh Kumar\\Neqqo BGO\\PHI\\PHI QA Experience FORM (V1.0).xlsx";
		List<String> attributeAndRatingExcel = GetFormData.getData(path, "Ratings");
		for(String ratings : attributeAndRatingExcel)
		{
			String ratingArr[] = ratings.split("@,");
						
			String attr = ratingArr[0];
			
									
			By getRatings = By.xpath("");
						
			if(attr.contains("'") && !attr.contains("\""))
			{
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()=\""+attr+"\"]/parent::div/following-sibling::div/select");
			}
			else if(!attr.contains("'") && attr.contains("\""))
			{
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/select");
			}
			else if(attr.contains("'") && attr.contains("\""))
			{
				String splitAttr[] = attr.split("\"");
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[contains(text(),'"+splitAttr[0]+"')]/parent::div/following-sibling::div/select");
				
			}
			else
			{
				getRatings = By.xpath("//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+attr+"']/parent::div/following-sibling::div/select");
			}
			
			Actions act = new Actions(driver.get());
			
			WebElement rating = driver.get().findElement(getRatings);
			act.scrollToElement(rating);
			Select selectRating = new Select(rating);
			selectRating.selectByContainsVisibleText("Select");
			
			
			
			act.scrollToElement(driver.get().findElement(formSubmitButton)).perform();
			
			myClick(formSubmitButton);
			
			toBeVisible(errorForBlankRating);
			System.out.println(driver.get().findElement(errorForBlankRating).getText());
			toBeDisappear(errorForBlankRating);
			act.scrollToElement(rating);
			selectRating.selectByIndex(1);
	
		}
	
		return isRatingMissing;
	}
}
