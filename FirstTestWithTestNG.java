package POMTEST;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class FirstTestWithTestNG extends POMTEST.loginPage{


	static FirstTestWithTestNG login = new FirstTestWithTestNG();

	private static Logger logger = LogManager.getLogger(FirstTestWithTestNG.class);

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;


	@DataProvider
	public Object[][] dataset() {
		Object[][] dataset  = new Object[4][2];
		
		
		dataset[0][0] = "Admin";
		dataset[0][1] = "Admin123";
		
		dataset[1][0] = "Admin11";
		dataset[1][1] = "Admin123";
		
		dataset[2][0] = "Admin";
		dataset[2][1] = "Admin12345";
		
		dataset[3][0] = "Admin";
		dataset[3][1] = "Admin123";
		
		
		
		return dataset;
		
	}
	
@Test (dataProvider="dataset")

public static void main(String username, String password) throws InterruptedException {
	

	

    login.htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//myextreport.html");
    login.htmlReporter.config().setDocumentTitle("TestNG Automation Report");
    login.htmlReporter.config().setReportName("Functional Report");
    login.extent = new ExtentReports();
    login.extent.attachReporter(htmlReporter);
    login.extent.setSystemInfo("Hostname","Localhost");
    login.extent.setSystemInfo("Browser","Chrome");
    ExtentTest test = login.extent.createTest("TestNG Extent Report demo", "This is to login to an application");
	
    

    logger.info("This is a test for login functionality");
    
    
    login.openBrowser();
		
	
	login.enterUsername(username);
	logger.info("Logging with username: "+username);
	
	
	login.enterPassword(password);
	logger.info("Logging with password: "+password);
    login.chooseLocation("Inpatient Ward");
    login.clickLoginBtn();
    
        
    if(username == "Admin" && password =="Admin123") {
    	logger.info("Login successful");
        logger.info("Test passed");
        test.pass("Passed");
        login.clickLogout();	
        
    }
    else {
    	logger.info("Login failed");
    	logger.info("Test failed");
    	test.fail("Failed");
    }
    	
}
	@AfterTest
	public void teardown() {
		login.closewindow();
		extent.flush();
	}
	
}
