package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		//scroll to selected element
		WebElement element = driver.findElement(By.xpath("//h2[text()='Table Rows']"));
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		
		obj.executeScript("arguments[0].scrollIntoView();", element);
		
		//scroll to the end of the page
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		//scroll to the top of the page
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		
	}

}
