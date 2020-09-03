package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CRM_Activity4 {

	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm");
        
        //Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
        //Type credentials
        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        //Click Log in
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        
        //Check the title of the page
        String title = driver.getTitle();
        
        //Print the title of the page
        System.out.println("Page title is: " + title);
        
        //Verify that the homepage has opened.
            String homeIcon = driver.findElement(By.xpath("//a[contains(@class, 'navbar-brand')]")).getAttribute("href");
    		   System.out.println("Link of the Home Page is " + homeIcon);
        
        //Close browser
        driver.close();

    }
}