package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		driver.get("https://demo.guru99.com/test/drag_drop.html");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		//drag and drop
		WebElement fromBank = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement toBank = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		Actions actBank = new Actions(driver);
		
		//drag, hold and release
		actBank.dragAndDrop(fromBank, toBank).build().perform();
		
		WebElement fromAmnt = driver.findElement(By.xpath("//li[@id='fourth']/a"));
		WebElement toAmnt = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
		
		Actions actAmnt = new Actions(driver);
		
		//drag, hold and release
		actAmnt.dragAndDrop(fromAmnt, toAmnt).build().perform();
		
		//doubleClick(): Performs double click on the element
		//clickAndHold(): Performs long click on the mouse without releasing it
		//dragAndDrop(): Drags the element from one point and drops to another
		//moveToElement(): Shifts the mouse pointer to the center of the element
		//contextClick(): Performs right-click on the mouse
		
	}

}
