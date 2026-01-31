package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public void init() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeDriver chromeDriver = new ChromeDriver();
			driver.set(chromeDriver);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			FirefoxDriver firefoxDriver = new FirefoxDriver();
			driver.set(firefoxDriver);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			EdgeDriver firefoxDriver = new EdgeDriver();
			driver.set(firefoxDriver);
		}
		
		driver.get().manage().deleteAllCookies();
		driver.get().manage().window().maximize();
	}
	
	@BeforeMethod(groups= {"smoke"})
	public void launchApp() throws IOException
	{
		init();
		
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("stagingURL");
		
		driver.get().get(url);
	}
	
	@AfterMethod(groups= {"smoke"})
	public void tearDown()
	{
		driver.get().quit();
	}
	
	public String takeScreenShot(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver.get();
		String path = System.getProperty("user.dir")+"\\ScreenShots\\"+testCaseName+".png";
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		
		FileUtils.copyFile(src, des);
		
		return path;
	}
}
