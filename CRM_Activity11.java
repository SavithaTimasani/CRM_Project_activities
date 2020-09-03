package CRMProject;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRM_Activity11 {
	WebDriver driver ;
	
	@BeforeTest	
	public void beforemethod() {

	        //Create a new instance of the Firefox driver
	      driver  = new FirefoxDriver();

	        //And now use this to visit the website
	      driver.get("https://alchemy.hguy.co/crm");
	}
	@Test
public void Loginmethod() throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		//Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
        //Type credentials
        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        //Click Log in
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        File file = new File("/Users/SAVITATIMASANI/Desktop/API/Project/importLead");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Actions builder = new Actions(driver);             
        WebElement MN = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
        builder.moveToElement(MN).build().perform();
        
        // click on leads
        WebElement Lead = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Lead.click();
        
        //click on import leads
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement impLead = driver.findElement(By.xpath("//div[contains(@class,'actionmenulink')and text()='Import Leads']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        impLead.click();
        Thread.sleep(500); 
		
		//upload file
		WebElement addFile=driver.findElement(By.xpath("//*[@id='userfile']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addFile.sendKeys(file.getAbsolutePath());
		
      //addFile.sendKeys("/Users/SAVITATIMASANI/Desktop/API/Project/importLead");
		 //Prepare the path of excel file
     //   String filePath = "C:\\Users\\SAVITATIMASANI\\eclipse-workspace\\Selenium1\\src\\test\\java\\CRMProject\\importLead.xlsx";
       
   //  addFile.sendKeys("filepath");
		
		driver.findElement(By.xpath("//*[@id=\"gonext\"]']")).click();

		Thread.sleep(2000);
        
	}
	
	@AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
