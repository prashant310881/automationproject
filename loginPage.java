package POMTEST;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class loginPage {
	protected static WebDriver driver=null;
	protected String URL=null;
	protected By txt_username;
	protected By txt_password;
	protected By txt_location;
	protected By btn_login;
	protected By id_Homepage;
	protected By id_logout;
 
	protected By id_admin;
	
    public loginPage() {
    	System.setProperty("webdriver.gecko.driver","geckodriver");
     	driver = new FirefoxDriver();
     	URL = "https://demo.openmrs.org/openmrs/login.htm"; 
     		    
        txt_username = By.xpath("/html/body/div/div[3]/div/div/div/form/fieldset/p[1]/input");
    	txt_password = By.xpath("/html/body/div/div[3]/div/div/div/form/fieldset/p[2]/input");
    	txt_location = By.xpath("/html/body/div/div[3]/div/div/div/form/fieldset/ul/li[1]");
    	btn_login = By.xpath("/html/body/div/div[3]/div/div/div/form/fieldset/p[6]/input");
    	
    	id_logout =By.xpath("//a[@href='/openmrs/appui/header/logout.action?successUrl=openmrs']");
    
    }

	public void openBrowser()
	{
	
	  driver.navigate().to(URL);
	  driver.manage().window().maximize();
	  
	  if(!driver.getTitle().equals("Login")) {
  		throw new IllegalStateException("This is not Login page. The current page is: " +driver.getCurrentUrl());
  	  }
	 
	
 	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).click();
		driver.findElement(txt_username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).click();
		driver.findElement(txt_password).sendKeys(password);
	}

	public void chooseLocation(String location) {
		driver.findElement(txt_location).sendKeys(location);
	}

	public void clickLoginBtn() {
		driver.findElement(btn_login).click();
	}
	public boolean checkLogout() {
		if(driver.findElement(id_logout)==null) {
			return false;
		}
		else
		{
			return true;
		}
	}
	
    public void clickLogout() {
    	
    	driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		driver.findElement(id_logout).click();
		
	}
   

	public void closewindow() {
	
		driver.quit();
		
	}

}
