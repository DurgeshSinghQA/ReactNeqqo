package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	
	public static ExtentReports getReportObj()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Neqqo Test Report");
		sparkReporter.config().setReportName("ExelonPHI Test Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Durgesh Kumar");
		
		return extent;
	}

}
