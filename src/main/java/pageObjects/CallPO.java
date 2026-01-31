package pageObjects;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.UtilityClass;
import net.sourceforge.tess4j.TesseractException;

public class CallPO  extends UtilityClass{

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public CallPO(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = (ThreadLocal<WebDriver>) driver;
	}
	
	String addCallURL = "https://exelonphi.neqqo.com/call/add-call";
	
	By profileName = By.xpath("//span[@class='user-title d-block']");
	By registerButton = By.xpath("//button[text()='Register']");
	By errorMsg = By.xpath("//p[@class='red-txt mb-0 text-error']");
	By callDateTimeErrorMsg = By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-contained css-1kcale7']");
	By menuOptionCall = By.xpath("//ul[@class='main-menu']//span[text()='Call']");
	By menuOptionAddCall = By.xpath("//ul[@class='main-menu']//span[text()='Add Call']");
	By menuOptionCallList = By.xpath("//ul[@class='main-menu']//span[text()='Call List']");
	By menuOptionMyCall = By.xpath("//ul[@class='main-menu']//span[text()='My Call']");
	By menuOptionUnAssigned = By.xpath("//ul[@class='main-menu']//span[text()='Un-Assigned']");
	By chanelBox = By.xpath("//span[text() = 'Channel']/parent::label/following-sibling::div/div/div/div[@class='neqqo-select__indicators css-1wy0on6']");
	By chanelOption = By.xpath("//span[text() = 'Channel']/parent::label/following-sibling::div/div/div/div[contains(@id,'react-select') ]/div[text()='Audio']");
	
	//span[text() = 'Campaign']/parent::label/following-sibling::div/div/div/div/div
	//Skills[2]
	By lobBox = By.xpath("(//span[text() = '*']/parent::label/following-sibling::div/div/div/div[@class='neqqo-select__indicators css-1wy0on6'])[1]");
	By lobOption = By.xpath("//span[text() = '*']/parent::label/following-sibling::div/div/div/div[contains(@id,'react-select') ]/div");
	//Campaign[2]
	By campaignBox = By.xpath("(//span[text() = '*']/parent::label/following-sibling::div/div/div/div[@class='neqqo-select__indicators css-1wy0on6'])[2]");
	By campaignOption = By.xpath("//span[text() = '*']/parent::label/following-sibling::div/div/div/div[contains(@id,'react-select') ]/div");
	//Vendor[2]
	By vedorBox = By.xpath("(//span[text() = '*']/parent::label/following-sibling::div/div/div/div[@class='neqqo-select__indicators css-1wy0on6'])[3]");
	By vendorOption = By.xpath("//span[text() = '*']/parent::label/following-sibling::div/div/div/div[contains(@id,'react-select') ]/div");
	//Location[2]
	By locationBox = By.xpath("(//span[text() = '*']/parent::label/following-sibling::div/div/div/div[@class='neqqo-select__indicators css-1wy0on6'])[4]");
	By locationOption = By.xpath("//span[text() = '*']/parent::label/following-sibling::div/div/div/div[contains(@id,'react-select') ]/div");
	
	By formBox = By.xpath("//span[text() = 'Form']/parent::label/following-sibling::div/div/div/div[@class='neqqo-select__indicators css-1wy0on6']");
	By formOption = By.xpath("//span[text() = 'Form']/parent::label/following-sibling::div/div/div/div[contains(@id,'react-select') ]/div");
	
	By agentNameBox = By.xpath("//span[text() = 'Agent Name (ID)']/parent::label/following-sibling::div/input[@name = 'agent_name_id']");
	By agentNameOption = By.xpath("//span[text() = 'Agent Name (ID)']/parent::label/following-sibling::div/ul/li");
	
	By callDateTime = By.name("call_date_time");
	By todayDate = By.xpath("//div[@role = 'row']/button[contains(@class , 'today')]");
	By hour = By.xpath("//div[@role = 'group']/ul[@aria-label='Select hours']/li[contains(text() , '01')]");
	By minute = By.xpath("//div[@role = 'group']/ul[@aria-label='Select minutes']/li[contains(text() , '05')]");
	By second = By.xpath("//div[@role = 'group']/ul[@aria-label='Select seconds']/li[contains(text() , '15')]");
	By calendarOkbtn = By.xpath("//button[text() = 'OK']");
	
	By callID = By.xpath("//input[@name = 'call_chat_ID']");
	By callDuration = By.xpath("//span[text() = 'Call Duration']/parent::label/following-sibling::div/span/input[@name = 'call_duration']");
	By selectHours = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[2]/form/div/div[1]/div/div[9]/div[2]/div/div/div/div[2]/div[1]/ul/li[2]");
	By selectMins = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[2]/form/div/div[1]/div/div[9]/div[2]/div/div/div/div[2]/div[2]/ul/li[3]");
	By selectSecs = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[2]/form/div/div[1]/div/div[9]/div[2]/div/div/div/div[2]/div[3]/ul/li[4]");
	
	By assignToBox = By.xpath("//span[text() = 'Assign To']/parent::label/following-sibling::div/div/div/div/div[@class= 'neqqo-select__indicator neqqo-select__dropdown-indicator css-1xc3v61-indicatorContainer']");
	By assignToOptionSelf = By.xpath("//span[text() = 'Assign To']/parent::label/following-sibling::div/div/div[@class = 'neqqo-select__menu css-1nmdiq5-menu']/div/div[text() = 'Self']");
	By assignToOptionNone = By.xpath("//span[text() = 'Assign To']/parent::label/following-sibling::div/div/div[@class = 'neqqo-select__menu css-1nmdiq5-menu']/div/div[text() = 'None']");
	
	By evaluateBtn = By.xpath("//button[text() = 'Evaluate']");
	
	By formName = By.xpath("//*[@id=\"root\"]/div/div/div[4]/main/div/div/div[2]/div/div/div/div[1]/div/div[1]/div[1]/h3");
	By searchBox = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div/div/div[1]/div[2]/div/input");
	By callIDInCallList = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div/div/div[2]/div/div[1]/table/tbody/tr/td[2]/span");
	By callIDInMyCallList = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[2]/div/div[2]/div/div[1]/table/tbody/tr/td[1]/a");
	
	By callIDInUnAssignedList = By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[2]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[2]");
	
	
	
	public void registerCall() throws IOException, InterruptedException, TesseractException
	{
		String CallId = "Call014";
		login();
		toBeVisible(profileName);
		
		myClick(menuOptionCall);
		myClick(menuOptionAddCall);
		
		myClick(lobBox);
		
		String option = driver.get().findElement(lobOption).getText();
				
		toBeChangeAttributeValue(lobOption,"Loading...");
		toBeChangeAttributeValue(lobOption,"No options");
	
		myClick(lobOption);
		
		myClick(campaignBox);
		toBeChangeAttributeValue(campaignOption,"Loading...");
		toBeChangeAttributeValue(campaignOption,"No options");
		
		myClick(campaignOption);
		
		myClick(vedorBox);
		toBeChangeAttributeValue(vendorOption,"Loading...");
		
		myClick(vendorOption);
		
		
		myClick(locationBox);
		toBeChangeAttributeValue(locationOption,"Loading...");

		myClick(locationOption);
		
		myClick(formBox);
		toBeChangeAttributeValue(formOption,"No options");
		//toBeChangeAttributeValue(formOption,"All");
		
		myClick(formOption);
		mySendKeys(agentNameBox, "Dummy");
		myClick(agentNameOption);
		mySendKeys(callDateTime, "28102025113522");
		driver.get().findElement(callDuration).click();
		driver.get().findElement(selectHours).click();
		driver.get().findElement(selectMins).click();
		driver.get().findElement(selectSecs).click();
		mySendKeys(callID, CallId);
		myClick(assignToBox);
		
	}
	
	public String[] errorForAllBlankFields() throws IOException, InterruptedException, TesseractException
	{
		login();
		toBeVisible(profileName);
		
		myClick(menuOptionCall);
		myClick(menuOptionAddCall);
		
		//driver.get().navigate().to(addCallURL);
		
		myClick(registerButton);
				
		List<WebElement> errors = driver.get().findElements(errorMsg);
		
		String errorMsg[] = new String[9];
		int count=0;
		
		for(WebElement el: errors)
		{			
			errorMsg[count] = el.getText();
			count++;
		}
		
		return errorMsg;
	}
	
	public String redirectFormEvaluationPageOnDirectlyEvaluatingTheCall() throws InterruptedException, IOException, TesseractException
	{
		registerCall();
		myClick(assignToOptionSelf);
		myClick(evaluateBtn);
		toBeVisible(formName);
		toBeChangeAttributeValue(formName,"Loading...");
		
		String getFormName = driver.get().findElement(formName).getText();
		
		return getFormName;
		
		/*
		myClick(callDateTime);
		myClick(todayDate);
		myClick(hour);
		myClick(minute);
		myClick(second);
		myClick(calendarOkbtn);
		
		
		Actions actions = new Actions(driver.get());
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(Duration.ofSeconds(5));
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(Duration.ofSeconds(5));
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(Duration.ofSeconds(5));
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(Duration.ofSeconds(5));
		actions.sendKeys("123456").build().perform();
		Thread.sleep(Duration.ofSeconds(5));
		*/
		
		
		
		/*
		JavascriptExecutor executor = (JavascriptExecutor)driver.get();
		

		String script = ""
			    + "var xpath = \"//input[@name='call_chat_ID']\";" 
			    + "var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"
			    + "if (element) { element.value = 'Call001'; }";

			executor.executeScript(script);
			*/
		
		
		//driver.get().findElement(callDuration).clear();
		//Thread.sleep(Duration.ofSeconds(10));
		
			//executor.executeScript("document.getElementById('timeElementInput').value = '01:23:45';");
			
			
		/*	actions.keyDown(Keys.CONTROL)
			       .sendKeys("1")
			       .keyUp(Keys.CONTROL)
			       .perform();
			*/
			//myClick(callDuration);
			/*actions.sendKeys(Keys.TAB).perform();
			Thread.sleep(Duration.ofSeconds(5));
			actions.sendKeys(Keys.TAB).perform();
			Thread.sleep(Duration.ofSeconds(5));
			actions.sendKeys(Keys.TAB).perform();
			Thread.sleep(Duration.ofSeconds(5));
			actions.sendKeys(Keys.BACK_SPACE).perform();
			Thread.sleep(Duration.ofSeconds(5));
			actions.sendKeys("123456").build().perform();
			Thread.sleep(Duration.ofSeconds(5));*/
		
	}
	
	public Boolean registeredCallShowingInCallList() throws IOException, InterruptedException, TesseractException
	{
		registerCall();
		myClick(assignToOptionSelf);
		String getCallId = driver.get().findElement(callID).getDomAttribute("value");
		
		driver.get().findElement(registerButton).click();
		driver.get().findElement(menuOptionCallList).click();
		driver.get().navigate().refresh();
		driver.get().findElement(searchBox).sendKeys(getCallId);
		toBeVisible(callIDInCallList);
		String callIdFoundInList = driver.get().findElement(callIDInCallList).getText();
		if(getCallId.equals(callIdFoundInList))
			return true;
		return false;
		
	}
	
	public Boolean registeredCallShowingInMyCallList() throws IOException, InterruptedException, TesseractException
	{
		registerCall();
		myClick(assignToOptionSelf);
		String getCallId = driver.get().findElement(callID).getDomAttribute("value");
		
		driver.get().findElement(registerButton).click();
		driver.get().findElement(menuOptionMyCall).click();
		driver.get().navigate().refresh();
		driver.get().findElement(searchBox).sendKeys(getCallId);
		toBeVisible(callIDInMyCallList);
		String callIdFoundInList = driver.get().findElement(callIDInMyCallList).getText();
		if(getCallId.equals(callIdFoundInList))
			return true;
		return false;
		
	}
	
	public Boolean registeredCallShowingInUnAssignedList() throws IOException, InterruptedException, TesseractException
	{
		registerCall();
		
		myClick(assignToOptionNone);
		
		String getCallId = driver.get().findElement(callID).getDomAttribute("value");
		
		driver.get().findElement(registerButton).click();
		driver.get().findElement(menuOptionUnAssigned).click();
		driver.get().navigate().refresh();
		driver.get().findElement(searchBox).sendKeys(getCallId);
		toBeVisible(callIDInUnAssignedList);
		String callIdFoundInList = driver.get().findElement(callIDInUnAssignedList).getText();
		if(getCallId.equals(callIdFoundInList))
			return true;
		return false;
		
	}

}
