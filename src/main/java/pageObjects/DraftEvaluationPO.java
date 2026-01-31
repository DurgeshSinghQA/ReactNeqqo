package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import abstractComponents.UtilityClass;
import net.sourceforge.tess4j.TesseractException;

public class DraftEvaluationPO extends UtilityClass{
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public DraftEvaluationPO(ThreadLocal<WebDriver> driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By menuOptionDraftEvaluation = By.xpath("//ul[@class='main-menu']//span[text()='Draft Evaluation']");
	By saveAsDraftButton = By.xpath("//*[@id='root']/div/div/div[4]/main/div/div/div[2]/div/div/div/div[3]/form/div[3]/div[2]/button");
	//By getCallIdInSaveDraftList = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div/div/div[2]/div/div[1]/table/tbody/tr/td[1]/a");
	
	By callId = By.xpath("//*[@id=\"basic-meta\"]/div/div[1]/div[2]/p");
	
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
	By formSubmitButton = By.xpath("//*[@id='root']/div/div/div[4]/main/div/div/div[2]/div/div/div/div[3]/form/div[3]/div[1]/button");
	By yesConfirmButton = By.xpath("//*[@id=\"submitEval\"]/div/div/div[2]/div/button[1]");
	
	
	public boolean callIsShowingInDraftEvaluation() throws IOException, InterruptedException, TesseractException
	{
		String callid = "Call014";
		CallPO cp = new CallPO(driver);
		cp.redirectFormEvaluationPageOnDirectlyEvaluatingTheCall();
		
		myClick(customButton);
		mySendKeys(typeOfEvaluation, "test Evalution");
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
		
		WebElement saveDraft = driver.get().findElement(saveAsDraftButton);
		Actions actions = new Actions(driver.get());
		actions.moveToElement(saveDraft).perform();
		
		myClick(saveAsDraftButton);
		toBeChangeURL("https://exelonphi.neqqo.com/draft-evaluation");
		
		driver.get().navigate().refresh();
		
		By getCallIdInSaveDraftList = By.xpath("//table/tbody/tr/td/a[text() = '"+callid+"']");
		
		toBeVisible(getCallIdInSaveDraftList);
		String callID = driver.get().findElement(getCallIdInSaveDraftList).getText();
		
		if(callID.endsWith(callid))
			return true;
		return false;
		//myClick(menuOptionDraftEvaluation);
	}

}
