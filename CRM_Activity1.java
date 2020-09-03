package CRMProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CRM_Activity1 {
	public static void main(String[] args) {
		 //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //And now use this to visit the website
        driver.get("http://alchemy.hguy.co/crm");
        
        //Check the title of the page
        String title = driver.getTitle();
        
        //Print the title of the page
        System.out.println("Page title is: " + title);
        
        //Make sure it matches “SuiteCRM” exactly.
        Assert.assertEquals("SuiteCRM", title);
                
        //close the driver
        driver.close();

	}

}
