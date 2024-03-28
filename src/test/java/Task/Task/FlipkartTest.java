package Task.Task;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlipkartTest {
	
	WebDriver driver;
	@Test
    public void OpenFlipcard() throws IOException {
		 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\SUDARSHAN GAIKWAD\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

	        // Launching Chrome browser
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        

	        try {
	            // Open Flipkart website
	            driver.get("https://www.flipkart.com/");

	            // Search for a Selenium book
	            WebElement searchBox = driver.findElement(By.name("q"));
	            searchBox.sendKeys("Selenium book");
	            searchBox.sendKeys(Keys.ENTER);

	            // Wait for search results to load
	            Thread.sleep(2000);

	            // Click on the first search result
	            WebElement firstResult = driver.findElement(By.xpath("//a[@title='Selenium WebDriver 3 Practical Guide']"));
	            firstResult.click();

	            // Switch to the new window
	            for (String windowHandle : driver.getWindowHandles()) {
	                driver.switchTo().window(windowHandle);
	            }

	            // Wait for the book page to load
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
	            
	          
	            

	            // Check delivery availability
	            String pinCode = "413801"; 

	         // Locate the pin code input field
	            WebElement pinCodeInput = driver.findElement(By.xpath("//input[@id='pincodeInputId']"));

	         // Clear the input field to ensure it's empty
	         	pinCodeInput.clear();

	         // Enter the pin code
	         	pinCodeInput.sendKeys(pinCode);

	         // Locate and click the check button
	         	WebElement checkButton = driver.findElement(By.xpath("//span[@class='_2P_LDn']"));
	         	checkButton.click();
	         	
	         	WebElement viewdetail = driver.findElement(By.xpath("//span[@class='YxlyDn']"));
	         	viewdetail.click();

	         	// Wait for the delivery details to appear
	         	WebDriverWait wait1 = new WebDriverWait(driver, 10);
	         	WebElement deliveryDetails = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1_YTe1']//div//div[@class='LH-oB5']")));
	         	
	         	

	         	// Fetch the delivery duration text
	         	String deliveryDuration = deliveryDetails.getText();
	         	System.out.println("Delivery duration to pin code " + pinCode + ": " + deliveryDuration);
	         	
	         	WebElement cancel1 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _1KAjNd']"));
	            cancel1.click();

	         	
	       
	            WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	            addToCartButton.click();

	           
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Cart']")));

	            
	            
	           
	         	WebElement login = driver.findElement(By.xpath("//a[@class='_1_3w1N']"));
	            login.click();
	            
	            Random rand = new Random();
	            String email = "test" + rand.nextInt(1000) + "@example.com";
	            

	            WebElement emailInput = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
	            emailInput.sendKeys(email);
	           

	            
	            WebElement loginButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
	            loginButton.click();

	        
	            Thread.sleep(2000);
	            WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(),'Please enter valid Email ID/Mobile number')]"));
	            System.out.println("Error message: " + errorMessage.getText());

	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
    }

}
