package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.facebook.com/");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//relative xpath locator
		WebElement UserName = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement Login = driver.findElement(By.xpath("//button[@name='login']"));		
		
		UserName.sendKeys("abc@xyz.com");
		Password.sendKeys("abcd123");
		Login.click();
		
	}

}

//xpath
//WebElement CreateAcc = driver.findElement(By.xpath("//*[text()='Create new account']"));
//WebElement Text = driver.findElement(By.xpath("//*[text()='Connect with friends and the world around you on Facebook.']"));
	//find element with some text
//WebElement Text = driver.findElement(By.xpath("//*[contains(text(),'friends and the world')]"));
	//find element with id containing phrase
//WebElement Text = driver.findElement(By.xpath("//*[contains(@data-testid,'open-registration')]"));
	//find text starting with
//WebElement Text = driver.findElement(By.xpath("//*[starts-with(text(),'Connect with')]"));
	//Find child element
//WebElement Text = driver.findElement(By.xpath("//div[@class='logo-image']/img"));
	//find element using index number
//WebElement Text = driver.findElement(By.xpath("//div[@class='col-centered content-wrapper']/div[3]"));
	//find grand child
//WebElement Text = driver.findElement(By.xpath("//div[@class='col-centered content-wrapper']/div[1]/img"));
	//find all children and grand children
//WebElement Text = driver.findElement(By.xpath("//div[@class='col-centered content-wrapper']//img"));
	//find parent 
//WebElement Text = driver.findElement(By.xpath("//input[@name='user_login']/parent::div']//img"));
	//find all elements after tag 
//WebElement Text = driver.findElement(By.xpath("//div[@class='col-centered content-wrapper']/following::div"));
	//find following sibling/s
//WebElement Text = driver.findElement(By.xpath("//div[@class='logo-image']/following-sibling::div"));
	//find preceding tags
//WebElement Text = driver.findElement(By.xpath("//div[@class='logo-image']/preceding::div"));
	//find ancestors of
//WebElement Text = driver.findElement(By.xpath("//img[@alt='Simplilearn Logo']/ancestor::div"));

//CSS Selector

	//Using id attribute
//tag_name#id_value - input#email - facebook
	//Using class attribute

//tag_name.class_value - input.email - simplilearn page

	//Using attribute
//tag_name[attr=value] - input[name=firstname] - facebook
//input[aria-label='Email address or phone number']

	//contains using *
//input[aria-label*='or phone number']

	//start with using ^
//input[aria-label^='Email address'] 

	//ends with using
//input[aria-label$='or phone number']
