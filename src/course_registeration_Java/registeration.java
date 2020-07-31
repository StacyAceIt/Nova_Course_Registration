package course_registeration_Java;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;


public class registeration {

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
		 WebDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65530).build());

		 String novasis_login = new String();
		 //https://adfs.villanova.edu/adfs/ls?SAMLRequest=fZFfb4IwFMXf9ylI34FSUEcjGDdjZuIiEdzD3gpU7QIt6y1kH38oGl2y%2BHj%2F%2Fe7JOdPZT11ZHdcglIyQ52BkcVmoUshDhHbZ0n5Gs%2FhpCqyuSEPnrTnKLf9uORhrDsC16e9elYS25jrluhMF323XEToa0wB13ZxJANVoVTqdqComVcccXrY0CHy3n9RMsgPX7umBm6YbZC16tpDMnAVdMazcwz%2BAU9utAFlLpQt%2BVhehPauAI2u1iBALRmQyFl889BnJg2LkiUOI%2FZKM9x4O834JEgYgOn47A2j5SoJh0kSIYIJtPLF9nBGP4pB6xBmFk09kJVoZVajqRcjBrFZLqhgIoJLVHKgpaDp%2FX1PiYJoPS0Dfsiyxk02aIevjajo5md7HIIEONj9mNZfHKB5SoWfF%2Bp7wGMCuuaH4ls7UvYfFl%2FJv4vEv&RelayState=%2Fc%2Fauth%2FSSB%3Fpkg%3Dbwskfreg.P_AltPin&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=CYE%2F3RluOKezwDO%2Bg3bAQMSKSVsdyEDKZ%2BqmX5G3mtPNs%2Bd3E%2B2WUF8pw74pCFdo1fR1TVFErk8zPAwFr7YpguPz1bb8DdVqeb3xW8AJIE3C2dKCfpkFsGfY5ce%2FTDVjguGIhLQ3R29R9qcM5v%2FoZOSpYOSJBx7pbfHk2l2AEzXW%2B7CvzhXmKwPp7Fe1pwzdjK0Es5%2FIVwc%2BZkIQaIlteVMQkW5lRjgEONko4MkAYvQ7TNiyOHZmmPoHLSREzIKopjW9u%2F%2BDAF61mDgS%2FnxkJ0e7w8gICJf%2BG4txWPiCFxuLDnSwzPYYYz8%2BpCV3xgsqIfIE%2FtMhivVVR7Znxsl7gQ%3D%3D
		 novasis_login = "https://adfs.villanova.edu/adfs/ls?SAMLRequest=fZFLb4JAFIX3%2FRVk9jwcaYWJYGyNqYmNRLCL7ka4AgZm6NyB9OcXRaNNGpf39d2Tc6azn7oyOlBYShGQkeUQA0Qqs1LkAdklS9Mjs%2FBpiryuaMPmrS7EFr5bQG3MEUHp%2Fu5NCmxrUDGorkxht10HpNC6QWbbey4QZaNkZnVlVXEhO25B1jLXHdv9pOaC56Ds0wM7jjfEWPTsUnB9FnTF8OyA%2FwBObbtCYiylSuGsLiAHXiEQY7UICM996rrPR2cPxdF3x%2BmLe6AAXl54mU%2F7HYw4YtnB7QqxhZVAzYUOCHWoYzoTk%2FrJaMKoxxzPmtDxFzEiJbVMZfVaisGrVgkmOZbIBK8BmU5ZPP9YM2o5bD8sIXtPksiMNnFCjM%2Br5%2FTkeZ%2BCQDa4%2FJjVXB6TcAiFnRWre8JjAL%2FGRsJbOFP7HhZeyr%2BBh78%3D&RelayState=%2Fc%2Fauth%2FSSB%3Fpkg%3Dtwbkwbis.P_GenMenu%3Fname%3Dbmenu.P_MainMnu&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=PLioQAWxkYpcQGS9HJiFvTNfYtqu6V1t2W2X%2FSHuofRDDRxZ4z2vjKNany1WxHpgqa%2B0bjOdKGZNwi58X8OJeY4EMgvmNcaa7qmwRfQ3zgdMhL2IEyUOf2AR7E9lm5a4zXul2BvljkGCuOW2bEx95gkrmphDrsoXjwp0ImmAMJTBasHVWO0N7ou4mn2D0vbc%2BGD5MCUehjhmyY06zUUnx49vfrDS%2FywXxvhck6lCw0kwgG5XbdFVwlNApOkSEJ5eUdWgU7LK8qwrrXBlEB0JKrDBS%2B1YVngKBz%2FddiBB8K%2BTv0NVpbq9819xVQItX9TuSZTJfW69cLMBbiCB1grYaQ%3D%3D";
		 driver.get(novasis_login);
		 delay(3);
		 //fill in Username and Password
		 Login login = new Login();
		 String myUsername = login.getUsername();
		 String myPassword = login.getPassword();
		 
		 //https://www.guru99.com/accessing-forms-in-webdriver.html
		 WebElement Username = driver.findElement(By.id("userNameInput"));
		 Username.sendKeys(myUsername);
		 WebElement Password = driver.findElement(By.id("passwordInput"));
		 Password.sendKeys(myPassword);
	
		 
		 WebElement login_novasis = driver.findElement(By.id("submitButton"));
		 login_novasis.click();
		 delay(3);
		 //https://novasis.villanova.edu/pls/bannerprd/twbkwbis.P_GenMenu?name=bmenu.P_StuMainMnu
		 WebElement StudentFinancialAid = driver.findElement(By.linkText("Student & Financial Aid"));
		 StudentFinancialAid.click();
		 delay(3);
		 
		 WebElement Registration = driver.findElement(By.linkText("Registration"));
		 Registration.click();
		 delay(3);
		 
		 WebElement LoginToRegistration = driver.findElement(By.linkText("Login to Registration"));
		 LoginToRegistration.click();
		 delay(3);
		 
		 //select from dropdown list
		 //https://www.guru99.com/select-option-dropdown-selenium-webdriver.html		 
		 Select TermOptions = new Select(driver.findElement(By.name("term_in")));
		
		 Term myTerm = new Term();
		 TermOptions.selectByVisibleText(myTerm.getTerm());
		 
		 WebElement SubmitTerm = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));
		 SubmitTerm.submit();
		 delay(3);
		 
		 //fill PIN if it's asking for a PIN
		 List<WebElement> PinElement = driver.findElements(By.cssSelector("input[type='password']"));
		 if (!PinElement.isEmpty()) {
			 for (WebElement pinField:PinElement){
				 fillPin(driver);
			 }
		 }else {
			 System.out.println("PIN is not requested");
		 }
		 
		 //classSearch(driver,args);
		 
		 
		
	}

	private static void fillPin(WebDriver driver) {
		PIN pin = new PIN();
		String myPin = pin.getValue();
		WebElement PinField = driver.findElement(By.cssSelector("input[type='password']"));
		PinField.sendKeys(myPin);
		
		// if it's not this button <input type="submit" value="Go" />
		// hit submit
		 WebElement submit_pin = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));
		 submit_pin.click();
		
		
	}

	private static void classSearch(WebDriver driver, String[] args) {
		//after registering for a class, the program goes back here
		 WebElement ClassSearch = driver.findElement(By.cssSelector("input[type='submit'][value='Class Search']"));
		 ClassSearch.click();
		 delay(3);
		 
		 Select DepartmentOptions = new Select(driver.findElement(By.cssSelector("select[name='sel_subj']")));
		//term format: e.g. Computer Science
		 //command line: Computer\ Science
		 DepartmentOptions.selectByVisibleText("Computer Science");
		 delay(3);
		 
		 WebElement SubmitDepartment = driver.findElement(By.cssSelector("input[type='submit'][value='Course Search']"));
		 SubmitDepartment.click();
		 delay(3);
		
		 List<WebElement> CourseList = driver.findElements(By.cssSelector("input[name=\"SEL_CRSE\"]"));
		 List<WebElement> SubmitList = driver.findElements(By.cssSelector("input[NAME=\"SUB_BTN\"][VALUE=\"View Sections\"]"));
		 
		 int index = 0;
		 for(WebElement course:CourseList) {		 		
		 		String courseNumber = course.getAttribute("value");
		 		if (!courseNumber.isEmpty() ) {
			 		//System.out.println(courseNumber);
			 		//course number: args[4]  
			 		if (courseNumber.compareTo(args[4]) == 0) {
			 			System.out.println("course found");
			 			SubmitList.get(index).click();
			 			break;
			 		};
			 		index++;
		 		}	 				 		
		 }
		 
		 //When session number doesn't exist, it gives all the input tags with checkbox and ignores contains. Don't use it cuz of the wrong output
		 //List<WebElement> SessionList = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@value,"+args[5]+")]"));
		 List<WebElement> SessionList = driver.findElements(By.xpath("//input[@type='checkbox']"));

		 for(WebElement session:SessionList) {		 		
		 		String CRN = session.getAttribute("value");
		 		if (CRN.contains(args[5])) {
		 			System.out.println("session found");
		 			session.click();
		 		}else {
		 			System.out.println("session not found or course is full");
		 		}
		 				 			 				 		
		 }
		 
		 //click register
		 //<input type="submit" name="ADD_BTN" value="Register" />
		 WebElement Register = driver.findElement(By.cssSelector("input[type='submit'][value='Register']"));
		 Register.click();
		 
		 System.out.println("done");	
		 //driver.quit();
		
	}

	private static void delay(int num) {
		try {
			TimeUnit.SECONDS.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
