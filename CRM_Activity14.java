package CRMProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRM_Activity14 {
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
	        WebElement MN = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
	        builder.moveToElement(MN).build().perform();
	        
	        WebElement Lead = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Opportunities\"]"));
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Lead.click();
	        
	             
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title= 'Filter']")));
		WebElement filter = driver.findElement(By.xpath("//a[@title= 'Filter']"));
	       	        filter.click();
	       	     String ChWindow = driver.getWindowHandle();
	       	        driver.switchTo().window(ChWindow);
	       	     System.out.println("Current window handle: " +ChWindow );
	       	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[3]/div/div/div/div[1]/ul/li[2]/a")));
	   WebElement adFileter = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div/div/div[1]/ul/li[2]/a"));
	   adFileter.click();
	   
	   WebElement Oppname = driver.findElement(By.xpath("//*[@id=\"name_advanced\"]"));
       WebElement range = driver.findElement(By.xpath("//*[@id=\"range_amount_advanced\"]"));
       //Type credentials
       Oppname.sendKeys("savitha");
       range.sendKeys("500");
       //Click Log in
       driver.findElement(By.xpath("//*[@id=\"search_form_submit_advanced\"]")).click();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[2]/a/span")));
                

       //no of rows are
         int rows = driver.findElements(By.xpath(".//*[@class= \'list-view-rounded-corners\']/table/tbody/tr/td[1]")).size(); 
       System.out.println("No of rows are : " + rows);
       
       //no of columns are

    int col = driver.findElements(By.xpath(".//*[@class= \'list-view-rounded-corners\']/table/thead/tr/th")).size();
     System.out.println("No of cols are : " +col); 
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   //fetch the data from the table
     
       for (int i=1; i<=10; i++) {
       
       	System.out.print(driver.findElement(By.xpath("//*[@class= 'list-view-rounded-corners']/table/tbody/tr[" +i +"]/td[3]")).getText());
      // 	System.out.print(driver.findElement(By.xpath("//*[@class= 'list-view-rounded-corners']/table/tbody/tr[" +i +"]/td[8]")).getText());
       	}
       
       
	}
  
   
   @AfterTest
	public void aftermethos() {

	        //Close the browser
	        driver.close();

	    }

	}
