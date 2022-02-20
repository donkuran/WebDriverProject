package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		driver.get("https://demoqa.com/browser-windows");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//click on button to open new window and retrieve text from element
		
		//Get parent window handle
		String ParentWin = driver.getWindowHandle();
		System.out.println("Before clicking new button" + ParentWin);
		
		//button element
		//new window
//		WebElement element = driver.findElement(By.xpath("//button[@id='windowButton']"));
		//new tab
		WebElement element = driver.findElement(By.xpath("//button[@id='tabButton']"));
		element.click();
		
		
		System.out.println("After clicking new window button");
		
		//get all window handles
		//use SET - will not accept duplicates
		Set<String> handles = driver.getWindowHandles();
		
		//iterate through set
		Iterator<String> itr = handles.iterator();
		
		//loop through handles and switch to child window
		while (itr.hasNext()) {
			
			String currentVal = itr.next();
			System.out.println(currentVal);
			
			if (!currentVal.equals(ParentWin)) {
				driver.switchTo().window(currentVal);
			}
		}
		
		//on child window
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));	
		System.out.println(heading.getText());
		
		//switch back to parent window
		driver.switchTo().window(ParentWin);
		System.out.println("Back to parent window");
		
		//closes current window
		driver.close();
		
		//closes all the windows
		driver.quit();
		
	}

}
