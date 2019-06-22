import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class Practice extends CommonMethods{

	public void practice1 () {
	Actions action=new Actions(driver);
	WebElement element = driver.findElement(By.linkText("TEST"));
	//double click
	action.doubleClick(element).perform();
	
	//Mouse over
	action.moveToElement(element).perform();
	
	//right click
	action.contextClick(element).perform();
	
	//mouse drag
	WebElement source=driver.findElement(By.className("source"));
	WebElement target=driver.findElement(By.className("target"));
	action.dragAndDrop(source, target).perform();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
	
	element.sendKeys("User");//using sendKeys
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript(executor.getElementById("email").value="abcemail@gmail.com");
	
	js.executeScript("window.scrollBy(0,250)");//scroll up the page
	js.executeScript("window.scrollBy(0,-400)");//scroll down the page
	
	js.executeScript("argument[0].scrollIntoView(true);",element);
	
	driver.findElement(By.id("Value")).sendKeys(Keys.RETURN);
	driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
	driver.findElement(By.id("Value")).sendKeys(Keys.TAB);
	
	
	//27.How do you handle the calendar elements? WebTables? 
	String url="https://www.google.com/";
	System.setProperty("webdriver.chrome.driver",  "Path of driver");
	driver=new ChromeDriver();
	driver.get("url");
	
	driver.findElement("By.id(daepicker")).click();
	List<WebElement> days=driver.findElements(By.xpath("//table[@class='ui-datepicker-calandar']//td"));
	for(WebElement ele:days) {
		String date=ele.getText();
		if(date.equalsIgnoreCase("28")) {
			ele.click();
			break;
		}
	}	
	
	TakesScreenshot scr=((TakesScreenshot)driver);//convert webdriver object to screenshot
	File SrcFile=scr.getScreenshotAs(OutputType.FILE);//create image file by calling getScreenshotAs method
	File DestFile=new File("FilePAth"); //create ne destination file
	FileUtils.copyFile(SrcFile,  DestFile);//copy file at the new destination file
	}
}
