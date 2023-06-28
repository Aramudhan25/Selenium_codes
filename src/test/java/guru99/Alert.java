package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) {
		try {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
		  WebDriverManager.edgedriver().setup();
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://demoqa.com/alerts");

		    driver.manage().window().maximize();
		   
		    
		  driver.findElement(By.id("alertButton")).click();  
		  org.openqa.selenium.Alert a = driver.switchTo().alert();
		  a.accept();
		 
	  WebElement y = driver.findElement(By.id("promtButton"));
	  Thread.sleep(1000);
	   JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].scrollIntoView(true)", y);
		  Thread.sleep(1000);
		  driver.findElement(By.id("promtButton")).click();  
		 a.sendKeys("selenium");
		 
	   a.accept();
		}
		catch (Exception e) {
			System.out.println (e.toString());
		}
	}
}
