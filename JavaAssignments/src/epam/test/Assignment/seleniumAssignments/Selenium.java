package epam.test.Assignment.seleniumAssignments;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;


public class Selenium {

	public static void main(String[] args) {


		WebDriver driver = new InternetExplorerDriver() ;
		Actions ac = new Actions(driver);

		WebElement element1 = driver.findElement(By.id("String"));
		WebElement to = driver.findElement(By.id("to"));
		WebElement from = driver.findElement(By.id("from"));

		//Setting up input text to webelement
		JavascriptExecutor js = ((JavascriptExecutor) driver) ;
		js.executeScript("arguments[0].setAttribute('value','text')", element1);
		ac.sendKeys(element1, "text");
		
		

		//Fluent wait
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class);

		// Drag and Drop using action class
		ac.clickAndHold(from)
		.moveToElement(to)
		.release(to)
		.build();
		
		// Take screenshot
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(file, new File("D:\\"+System.currentTimeMillis()+".png"));
		
		// How to set Firefox profile and capabilities
		FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("network.proxy.type", 1);
	    profile.setPreference("network.proxy.http", "proxy.domain.example.com");
	    profile.setPreference("network.proxy.http_port", 8080);
	    profile.setPreference("network.proxy.ssl", "proxy.domain.example.com");
	    profile.setPreference("network.proxy.ssl_port", 8080);
	    
	    DesiredCapabilities dc = new DesiredCapabilities();
	    dc.setCapability(FirefoxDriver.PROFILE, profile);
	    driver =  new FirefoxDriver(dc);
	    

	}

}

