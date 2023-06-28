package guru99;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic {
 public static void main(String[] args) {
	
	EdgeOptions options = new EdgeOptions();
	 options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
	  WebDriverManager.edgedriver().setup();
	 WebDriver driver = new EdgeDriver(options);
	 driver.get("https://www.flipkart.com/");

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	      
	      driver.findElement(By.xpath("//input[@name='q']")).sendKeys("poco",Keys.ENTER);
	    WebElement mob4 = driver.findElement(By.xpath("//div[contains(text(),'POCO C50 (Royal Blue, 32 GB)')]"));
		mob4.click();

	    String w1 = driver.getWindowHandle();
			 Set<String> ui = driver.getWindowHandles();
			for (String child1 : ui) { 
				
				if(!w1.equals(child1)) {
					 driver.switchTo().window(child1);
				 }
					}
		//WebElement mob4 = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		//String str = mob4.getText();
	
	WebElement mob = driver.findElement(By.xpath("//span[contains(text(),'POCO C50 (Royal Blue, 32 GB)')]"));
	String  etr = mob.getText();
	     System.out.println(etr);
 }}
	
	 

