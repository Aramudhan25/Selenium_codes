package guru99;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) {
		EdgeOptions options = new EdgeOptions();
		 options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
		  WebDriverManager.edgedriver().setup();
		 WebDriver driver = new EdgeDriver(options);
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.switchTo().frame("frame1");
		 
		    driver.switchTo().frame("frame3");
			 WebElement elements1 = driver.findElement(By.xpath("//input[@id='a']"));
			 elements1.click();
			   driver.switchTo().parentFrame();
			    WebElement elements = driver.findElement(By.xpath("//b[text()='Topic :']"));
			    String text = elements.getText();
			    System.out.println(text);
			    driver.switchTo().defaultContent();
			    WebElement elements2 = driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']"));
			    String text2 = elements2.getText();
			    System.out.println(text2);
	}

}
