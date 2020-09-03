package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CRM_Activity2 {

		public static void main(String[] args) {
			 //Create a new instance of the Firefox driver
	        WebDriver driver = new FirefoxDriver();
	        
	        //And now use this to visit the website
	        driver.get("http://alchemy.hguy.co/crm");
	        
	        //Get the url of the header image.	       
	      String URL = driver.findElement(By.xpath("//img[contains(@src,'themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g')]")).getAttribute("src");
	       //Print the url to the console.
	  	  	System.out.println("URL is:" +URL);
	  	  //close the driver
	        driver.close();
	        

	}

}
