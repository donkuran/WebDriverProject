package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.simplilearn.com/");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//explicitly wait for browser
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		
//		WebElement LoginLink = driver.findElement(By.className("login"));
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
		
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		
		UserName.sendKeys("email@email.com");
		Password.sendKeys("Abc@12345");
		RememberMe.click();
		LoginBtn.click();
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		if(ActualMsg.equals(ExpMsg)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Failed");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links: " + Links.size());
		
		for (WebElement elm : Links) {
			System.out.println(elm.getAttribute("href"));
		}
		
		driver.close();
			
	}

}
