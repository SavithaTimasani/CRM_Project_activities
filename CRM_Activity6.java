package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRM_Activity6 {
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
		//Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
        //Type credentials
        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        //Click Log in
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        
        //Make sure that the “Activities” menu item exists and is clickable
        
        boolean activitytab = driver.findElement(By.id("grouptab_3")).isEnabled();
       
        System.out.println("Activity tab is Present: " + activitytab);
        boolean selectedActtab = driver.findElement(By.id("grouptab_3")).isSelected();
        System.out.println("Activity tab is Selected: " + selectedActtab);
             
              
	}
	
	@AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
