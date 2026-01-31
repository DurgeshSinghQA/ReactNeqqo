package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.UtilityClass;
import net.sourceforge.tess4j.TesseractException;

public class FormPreviewPO extends UtilityClass{
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public FormPreviewPO(ThreadLocal<WebDriver> driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By menuOptionFormpreview = By.xpath("//ul[@class='main-menu']//span[text()='Form Preview']");
	By formName = By.xpath("//table/tbody/tr/td/a");
	
	public String[] FormNameShowingInList() throws IOException, InterruptedException, TesseractException
	{
		login();
		myClick(menuOptionFormpreview);
		toBeVisible(formName);
		List<WebElement> forms = driver.get().findElements(formName);
		int formsCount = forms.size();
		String formNames[] = new String[formsCount];
		
		int count=0;
		for(WebElement getFormName : forms)
		{
			formNames[count] = getFormName.getText();
			count++;
		}
		
		return formNames;
		
	}

}
