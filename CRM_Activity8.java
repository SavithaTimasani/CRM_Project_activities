package CRMProject;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRM_Activity8 {
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
		//Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
        //Type credentials
        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        //Click Log in
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions builder = new Actions(driver);             
        WebElement MN = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
        builder.moveToElement(MN).build().perform();
        
        WebElement Lead = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Lead.click();
        
        //no of rows are
          int rows = driver.findElements(By.xpath(".//*[@class= 'list-view-rounded-corners']/table/tbody/tr/td[1]")).size(); 
        System.out.println("No of rows are : " + rows);
        
        //no of columns are

     int col = driver.findElements(By.xpath(".//*[@class= 'list-view-rounded-corners']/table/thead/tr/th")).size();
      System.out.println("No of cols are : " +col); 

    //fetch the data from the table
      
        for (int i=1; i<=10; i=i+2) {
        	for (int j=1; j<=10; j++) {
        	
       
   	System.out.print(driver.findElement(By.xpath(".//*[@class='list-view-rounded-corners']/table/tbody/tr[" + i + "] /*[" +j +"]")).getText() + " ");
    
    	}
        }
        } 	    
    
	
	@AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
