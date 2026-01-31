package pageObjects;

import java.util.Arrays;

import org.openqa.selenium.By;

public class testclass {
	
	public static void main(String[] args) {
		
		String str = "7e - Does not document the account in the Interaction Record. Interaction Records should be saved at the time of the call, and system access should not be done through \"Back Office\". Documents BP's PII in the Interaction Record (SSN, Payment method account number, last 4 digits of account #)";
		
		String sp[] = str.split("'");
		for(String dt : sp)
		{
			System.out.println(dt);
		}
		
		String apend = String.join("'", sp);
		
		String newstr= "//div[contains(@id,'collapse')]/div/div/div[@class='row gx-3']/div/h4[text()='"+String.join("\'", sp)+"']/parent::div/following-sibling::div/select/option";
		System.out.println(newstr);
		By getRatings = By.xpath(newstr);
		
	}

}
