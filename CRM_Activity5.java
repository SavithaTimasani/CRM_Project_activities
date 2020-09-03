package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRM_Activity5 {
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
        String tabColour1 = driver.findElement(By.id("grouptab_0")).getCssValue("color");
        System.out.println("colour of the 1st tab is: " + tabColour1);

        
        
	}
	
	@AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
