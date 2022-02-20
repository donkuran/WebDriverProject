package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignup {

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
		WebElement Signup = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		
		Signup.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@aria-label='First name']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@aria-label='Last name']"));
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Email2 = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
				
		FirstName.sendKeys("Donald");
		LastName.sendKeys("Kurangwa");
		Email.sendKeys("email@email.com");
		Email2.sendKeys("email@email.com");
		Password.sendKeys("355RD@hgf#");
		
		String strGender = "Male";
		
		//input[@value='1']
        //input[@value='2']
        //input[@value='-1']
		

        //label[text()='Male']/following-sibling::input
        //label[text()='Female']/following-sibling::input
        //label[text()='Custom']/following-sibling::input
		
		//dynamic xpath
		String genXpath = "//label[text()='" + strGender + "']/following-sibling::input";
		
		WebElement gen = driver.findElement(By.xpath(genXpath));
		
		gen.click();
		
		List<WebElement> months = driver.findElements(By.xpath("//select[@title='Month']/option"));
		
		for(WebElement elm :months) {
			
			System.out.println(elm.getText());
		}
		
		//current month
		WebElement currentMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
			
		System.out.println(currentMonth.getText());
		
		
		//Days
		List<WebElement> Days = driver.findElements(By.xpath("//select[@title='Day']/option"));
		
		for(WebElement elm :Days) {
			
			System.out.println(elm.getText());
		}
		
		//month select
		
		WebElement Month = driver.findElement(By.xpath("//select[@title='Month']"));
		
		Select ddMonth = new Select(Month);
		
		ddMonth.selectByVisibleText("Apr");
		
		//day select
		
		WebElement Day = driver.findElement(By.xpath("//select[@title='Day']"));
		
		Select ddDay = new Select(Day);
		
		ddDay.selectByVisibleText("4");
		
		//years
		
		List<WebElement> Years = driver.findElements(By.xpath("//select[@title='Year']/option"));
		
		for(WebElement elm :Years) {
			
			System.out.println(elm.getText());
		}
		
		//day select
		
		WebElement Year = driver.findElement(By.xpath("//select[@title='Year']"));
				
		Select ddYear = new Select(Year);
				
		ddYear.selectByVisibleText("1981");
	}

}
