package GlobalBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	static WebDriver driver;
	static Properties prop;
	
		
		
	  public static WebDriver openBrowser() throws IOException {
			prop = new Properties();
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(fis);		
			
		  	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			//driver.get("https://magento.softwaretestingboard.com/"); 
			driver.get(prop.getProperty("url"));
			// maximize the window
			driver.manage().window().maximize();
			return driver;
	  }

}
