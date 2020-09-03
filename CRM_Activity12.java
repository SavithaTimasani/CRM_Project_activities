package CRMProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRM_Activity12 {
WebDriver driver ;

	
	@BeforeTest	
	public void beforemethod() {

	        //Create a new instance of the Firefox driver
	      driver  = new FirefoxDriver();

	        //And now use this to visit the website
	      driver.get("https://alchemy.hguy.co/crm");
	}
	@Test
public void Loginmethod() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
	        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
	        //Type credentials
	        userName.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	        //Click Log in
		 driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Actions builder = new Actions(driver);             
	        WebElement MN = driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
	        builder.moveToElement(MN).build().perform();
	        
	        WebElement Lead = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Meetings\"]"));
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Lead.click();
	        //click on schedule meeting link
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement impLead = driver.findElement(By.xpath("//div[contains(@class,'actionmenulink')and text()='Schedule Meeting']"));
	          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          impLead.click();
	          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          
	          WebElement subject = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		        WebElement fName = driver.findElement(By.xpath("//*[@id=\"search_first_name\"]"));
		        //Type credentials
		        subject.sendKeys("SAVI_Meet1");
		        fName.sendKeys("Dinesh");
		        driver.findElement(By.xpath("//*[@id=\"invitees_search\"]")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        driver.findElement(By.xpath("//*[@id=\"invitees_add_1\"]")).click();
		        
		        driver.findElement(By.xpath("//*[@id=\"SAVE_HEADER\"]")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		       // Click on view meetings
		        
		        WebElement viewMeet = driver.findElement(By.xpath("//div[contains(@class,'actionmenulink')and text()='View Meetings']"));
		        viewMeet.click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.print(driver.findElement(By.xpath("//*[@class= 'list-view-rounded-corners']/table/tbody/tr[1]/td[4]")).getText());

		        		       // Assert.assertEquals(meetName, "SAVI_Meet1");
		        
	}
  
   
   @AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
;