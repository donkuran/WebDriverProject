package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//count the number of rows
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		
		System.out.println("Total Rows are  " + tbRows.size());
		
		
		//count the number of columns
		List<WebElement> tbCols = driver.findElements(By.xpath("//table[@id='customers']//th"));
		
		System.out.println("Total Columns are  " + tbCols.size());
		
		//print data in third row
		List<WebElement> ThirdRow = driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
		
		for (WebElement elm : ThirdRow) {
			System.out.println(elm.getText());
		}
		
		//print data in first column
		List<WebElement> FirstCol = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));
		
		for (WebElement elm : FirstCol) {
			System.out.println(elm.getText());
		}
		
		
	}

}
