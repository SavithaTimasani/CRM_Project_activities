package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CRM_Activity3 {

		public static void main(String[] args) {
			 //Create a new instance of the Firefox driver
	        WebDriver driver = new FirefoxDriver();
	        
	        //And now use this to visit the website
	        driver.get("http://alchemy.hguy.co/crm");
	        
	        //Print the first copyright text in the footer to the console
	    String CopyFE =driver.findElement(By.xpath("//*[@id=\"admin_options\"]")).getText();
	    System.out.println("copyright text from Footer is: " + CopyFE);
	   	     
	   	     //Close the driver
	     driver.close();
	}

}
