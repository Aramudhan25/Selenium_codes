package guru99;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	public static void main(String[] args) {
		   try {
			   EdgeOptions options = new EdgeOptions();
				 options.addArguments("--remote-allow-origins=*");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
				  WebDriverManager.edgedriver().setup();
				 WebDriver driver = new EdgeDriver(options);
				 driver.get("https://demo.guru99.com/test/web-table-element.php");

				    driver.manage().window().maximize();
				    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				    
				      
			     int rowsize = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr")).size();
			     System.out.println("Row size:"+rowsize);
			     int coloumnsize = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr[1]//td")).size();
			      System.out.println("coloumnsize:"+coloumnsize);
			      
	 List<WebElement> Tablehead = driver.findElements(By.xpath("//table[@class='dataTable']//thead/tr//th"));
	 
	 WebElement company = driver.findElement(By.xpath("//table[@class='dataTable']//thead/tr//th[text()='Company']"));
			     
	 WebElement currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']//thead/tr//th[text()='Current Price (Rs)']"));
			      int companyindexOf = Tablehead.indexOf(company)+1;
			        System.out.println(companyindexOf);
			        
			        int currentPriceindexof = Tablehead.indexOf(currentPrice)+1;
			        System.out.println(currentPriceindexof);
			        
			        //to print company name value
			        for (int i = 1; i <= rowsize; i++) {
	WebElement element = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+ i +"]//td["+ companyindexOf +"]"));
	String text = element.getText();
	System.out.println("company coulmn value:"+text);
	
	WebElement element1 = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+ i +"]//td["+ currentPriceindexof +"]"));
	String text1 = element1.getText();
	System.out.println("current price coulmn value:"+text1);
	
						
						
					}
		   }
			    catch (Exception e) {
			      System.out.println(e.toString());
			    }
			  }

			
	}


