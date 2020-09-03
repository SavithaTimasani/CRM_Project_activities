package CRMProject;

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

public class CRM_Activity7 {
	WebDriver driver ;
	
	@BeforeTest	
	public void beforemethod() {

	        //Create a new instance of the Firefox driver
	      driver  = new FirefoxDriver();

	        //And now use this to visit the website
	      driver.get("https://alchemy.hguy.co/crm");
	}
	@Test
public void Loginmethod() throws Exception {
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
        
        WebElement Lead = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Lead.click();
                       
     //  JavascriptExecutor js = (JavascriptExecutor) driver;  
     //  js.executeScript("window.scrollBy(0,1000)");
               
        
        WebElement AdditionalInfo=driver.findElement(By.xpath("//span[@title='Additional Details']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);     
		AdditionalInfo.click();
		Thread.sleep(500); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
		WebElement phone=driver.findElement(By.xpath("//span[@class='phone']"));
		System.out.println("Phone: "+phone.getText());
	}
	
	@AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
