package guru99;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
		  WebDriverManager.edgedriver().setup();
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    
		WebElement e  =  driver.findElement(By.xpath("//select[@id='first']"));
		Select s = new Select(e);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
		s.selectByVisibleText("Yahoo");
		List<WebElement> options2 = s.getOptions();
		for (int i = 0; i < options2.size(); i++) {
			WebElement webElement = options2.get(i);
			System.out.println(webElement.getText());
			//if(webElement.getText().equals("Yahoo")){
				//s.selectByVisibleText(webElement.getText());
				
			//}
		
		}
	}
}
