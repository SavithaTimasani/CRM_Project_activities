package CRMProject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMActivity13 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        //Prepare the path of excel file
        String filePath = "C:\\Users\\SAVITATIMASANI\\eclipse-workspace\\Selenium1\\src\\test\\java\\CRMProject\\test1.xlsx";

        //Create an object of current class
        CRMActivity13 srcExcel = new CRMActivity13();
        
        //Call read file method of the class to read data
        List<List<String>> data = srcExcel.readExcel(filePath);
        List<String> row;
        
        //Open the browser
        driver.get("https://alchemy.hguy.co/crm");
        
   
        
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
        WebElement MN = driver.findElement(By.xpath("//*[@id='grouptab_5']"));
        builder.moveToElement(MN).build().perform();
                      
        
        WebElement Lead = driver.findElement(By.xpath("/html/body/div[3]/nav/div/div[2]/ul/li[7]/span[2]/ul/li[25]/a"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Lead.click();
     
        
        //Get row 1 data
        row = data.get(3);
            
        //Find the input fields and enter text
        WebElement ProductName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement Price = driver.findElement(By.xpath("//*[@id=\"price\"]"));
        
        ProductName.sendKeys(row.get(1));
        Price.sendKeys(row.get(2));
        
               //Click Submit
        driver.findElement(By.xpath("//*[@id=\"SAVE\"]")).click();
        
        //Switch to alert
       // Alert message = driver.switchTo().alert();
        
        //Get alert message
        //System.out.println("Alert message: " + message.getText());
      //  message.accept();

        //Close the browser
        driver.close();
    }
    
    public List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);

            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                //Temp variable
                List<String> rowData = new ArrayList<String>();
                Row row = rowIterator.next();
                
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(row.getLastCellNum() == 5) {
                        //Store row data
                        rowData.add(cell.getStringCellValue());
                    }
                }
                //Store row data in List
                data.add(rowData);
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}