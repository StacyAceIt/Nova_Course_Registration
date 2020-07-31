package course_registeration_Java;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;


public class Course_Beta {

	public static void main(String[] args) {
		//download Selenium Client & WebDriver Language Bindings and add to Library
		//https://www.selenium.dev/downloads/
		//download chromedriver from
		//https://chromedriver.chromium.org/downloads
		//do this in terminal
		//xattr -d com.apple.quarantine chromedriver
		
		//https://stackoverflow.com/questions/11361332/how-to-call-a-method-on-specific-time-in-java
		//schedule to call registerForClasses
		
		registerForClasses(args);
		
		
		
	}
	

	private static void registerForClasses(String[] args) {
		
		MyWebdriver mywebdriver = new MyWebdriver();
		System.setProperty("webdriver.chrome.driver", mywebdriver.getPath());
		
		 //https://stackoverflow.com/questions/50245718/invalid-port-exiting-org-openqa-selenium-os-osprocess-checkforerror-while-la
		 WebDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65531).build());
		 
		 //file:// is the protocol to local html
	      driver.get("file:///Users/stacyzhang/eclipse-workspace/course_registeration_Java/src/course_beta.html");
	      
	    //fill PIN if it's asking for a PIN
		 List<WebElement> PinElement = driver.findElements(By.cssSelector("input[type='password']"));

		 //check if there is a password field
		 if (!PinElement.isEmpty()) {
			 for (@SuppressWarnings("unused") WebElement pinField:PinElement){
				 System.out.println("PIN is requested");
				 FillPIN fillPin = new FillPIN(driver);
			 }
		 }else {
			 System.out.println("PIN is not requested");
		 }
	
		 driver.quit();
	}
	


}
