package course_registeration_Java;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class registeration {
	static int delay_count = 0;

	public static void main(String[] args) throws InterruptedException{
		
        long startTime = System.currentTimeMillis();

        registerForClasses();

        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in milliseconds: (with delay)" + timeElapsed);

        long delayMillisec = delay_count * 1000;
		
        System.out.println("Execution time in milliseconds: (without delay)" + (timeElapsed - delayMillisec));
		
			
	}

	private static void registerForClasses() {
		
		MyWebdriver mywebdriver = new MyWebdriver();
		System.setProperty("webdriver.chrome.driver", mywebdriver.getPath());
		WebDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65530).build());
		
		String novasis_login1 = "https://adfs.villanova.edu/adfs/ls?SAMLRequest=fZFLb8IwEITv%2FRWR73mHl0WCaBEqEhURCT30ZpJNsJTYqdeJ%2BvMbCAgqVRy93v1mNDNf%2FNSV0YFCLkVIXMshBohM5lyUITmka3NKFtHLHFldeQ1dtvok9vDdAmpjiQhK93dvUmBbg0pAdTyDw34bkpPWDVLbPjKBKBslc6vjVcWE7JgFeUuDwLf7n5oJVoKyzwJ2kuyIserZXDB9MXTDsLzAfwDnsV0hMdZSZXBxF5KCVQjE2KxCwgLuztgpy6EsM15wvxg5sykvS8gmk2DcL2HMEHkH9zPEFjYCNRM6JJ7jOaYzMX03dce9JB3NLH%2FkfREjVlLLTFavXAxhtUpQyZAjFawGpDqjyfJjSz3LocdhCel7msZmvEtSYnzeQvfOofc1CKRDzM9ZzVWYREMr9OJYPRKeA9itNxLd25nbj7Do%2BvzbePQL&RelayState=%2Fc%2Fauth%2FSSB%3Fpkg%3Dbwskfreg.P_AltPin&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=JXB%2Bj9z4keBBQSh8sXEFnBRHgMvnso1KDvbaGWu5ElePSDr57FbBMiikfNQ3Y0ZZIdpPx0Mt5N%2Bwrs%2F3dHGxTDiw7DIrQgQTsATdumQnkv7ITP%2ByF3%2BQBKqEMdNQZ%2FkkaraNV6%2F%2FXB%2BykQF9LGfgasA1okAXgTxC070MONXqysqQiLe6XzOHpRCmFg%2Bzxs8v8GXk8wKOrXx5w0zOjBrTNxn%2FHy2EpUFkeDRJWoXnd%2FF5Gzv54plYcXKaBs9Ihnp1xvjCqq65a9ZvMaH57D9Las%2Be9cNrxnf3cHKXpAHW9949kYL%2F3oXkkbQ9W6QfXQBtMoFbK8fgG5bC2lYje3Jd6Q%3D%3D";		 
		String novasis_login2 = "https://adfs.villanova.edu/adfs/ls?SAMLRequest=fZHNbsIwEITvfQrL9%2FxHarBIEC1CRaIiakIPvTnJAkaJnXqdqI%2FfQEBQqeLo9e43o5np7KepSQ8ahZIx9WyXEpClqoTcx3SbL62IzpKnKfKm9ls278xBfsB3B2jIHBG0Ge5elcSuAZ2B7kUJ2491TA%2FGtMgcp%2BASUbVaVXYv6ppL1XMbqo6FYeAMPw2XfA%2FaOQk4WbahZDGwheTmbOiK4dUO%2FwGcxk6NlCyVLuHsLqY7XiNQslrElHtlNAnDQkAUBRPwfHCDojyKXREeC14MS5hyRNHD7Qyxg5VEw6WJqe%2F6ruU%2BW4GXexHzg0HVDjz3i5JUK6NKVb8IOYbVackUR4FM8gaQmZJl8%2Fc1822XFeMSsrc8T610k%2BWUfF5D90%2BhDzVIZGPMj1ntRZgmYyvs7FjfEx4D%2BLU3mtzamTr3sOTy%2FNt48gs%3D&RelayState=%2Fc%2Fauth%2FSSB%3Fpkg%3Dtwbkwbis.P_GenMenu%3Fname%3Dbmenu.P_MainMnu&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=Zxu82eA1MUb7Gfi8PQnv2dVFBze7i6I0Rrv%2BZ493RpaHJSJWx432a37f0mhCKsAdmv2HTqHaFNRsfOKlYARK%2BY4PPha65u9Lz%2Fh1IReanJ6pLTRw4FV0hiEhXpLbflHHeiwvSduBoOfOS70vTnJriUYVk%2B33cqvrIkvPvpBriQC%2Bx4P1tGDVG5vuqkYO2zWv1nA6Lb%2Bii74Rt%2B7AhrGSkvbjt4nQU4FSO6awYcdSMVtUnn6GtLFgr1%2FVBl5VGRXVllsRTIp8605GEE%2BVlwtiveTNLUpZ2InJyFrNTEXjjtIR95bUzok4Ccxj7cddXaesRYwS1ORNbDzhiU2AZcesCw%3D%3D";

		int code1 = getResponseCode(novasis_login1);
		int code2 = getResponseCode(novasis_login2);
		
		if(code1 == 200) {
			loginShortcut(novasis_login1, driver);
			System.out.println("login shortcut");
		}else if(code2 == 200) {
			loginDetour(novasis_login2, driver);
			System.out.println("login detour");
		}else {
			//If none of the two links are accessible, wait and try again
			delay(30);
			registerForClasses();
			return;
			
		}
				 		 		 		 		 
		 //classSearch(driver);
		 		
}




private static int getResponseCode(String myURL) {
	int code = 0;
	try {
		 URL url = new URL(myURL);
		 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		 connection.setRequestMethod("GET");
		 connection.connect();
		 code = connection.getResponseCode();
		 
	} catch (Exception e) {

		e.printStackTrace();
	}
		return code;
}

private static void loginDetour(String novasis_login, WebDriver driver) {
	 driver.get(novasis_login);

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
	 
	//checking connection after clicking button
//	 String URL_After_login_novasis = driver.getCurrentUrl();
//	 int code_login_novasis = getResponseCode(URL_After_login_novasis);
//	 if (code_login_novasis != 200) {
//		 registerForClasses();
//		 return;
//	 }
//	

	 WebElement StudentFinancialAid = driver.findElement(By.linkText("Student & Financial Aid"));
	 StudentFinancialAid.click();
	 
	//checking connection after clicking button
//		 String URL_After_StudentFinancialAids = driver.getCurrentUrl();
//		 int code_StudentFinancialAids = getResponseCode(URL_After_StudentFinancialAids);
//		 if (code_StudentFinancialAids != 200) {
//			 registerForClasses();
//			 return;
//		 }

	 WebElement Registration = driver.findElement(By.linkText("Registration"));
	 Registration.click();
	 
	//checking connection after clicking button
//		 String URL_After_Registration = driver.getCurrentUrl();
//		 int code_After_Registration= getResponseCode(URL_After_Registration);
//		 if (code_After_Registration != 200) {
//			 registerForClasses();
//			 return;
//		 }

	 WebElement LoginToRegistration = driver.findElement(By.linkText("Login to Registration"));
	 LoginToRegistration.click();
	 
	//checking connection after clicking button
//		 String URL_After_LoginToRegistration = driver.getCurrentUrl();
//		 int code_LoginToRegistration = getResponseCode(URL_After_LoginToRegistration);
//		 if (code_LoginToRegistration != 200) {
//			 registerForClasses();
//			 return;
//		 }
	 
	 Select TermOptions = new Select(driver.findElement(By.name("term_in")));
		
	 Term myTerm = new Term();
	 TermOptions.selectByVisibleText(myTerm.getTerm());
	 
	 WebElement SubmitTerm = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));
	 SubmitTerm.submit();
	 
	//checking connection after clicking button
//		 String URL_After_SubmitTerm = driver.getCurrentUrl();
//		 int code_SubmitTerm = getResponseCode(URL_After_SubmitTerm);
//		 if (code_SubmitTerm != 200) {
//			 registerForClasses();
//			 return;
//		 }
	 
	 checkPIN(driver);

		
	}


private static void loginShortcut(String novasis_login, WebDriver driver) {
	 driver.get(novasis_login);

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
	 
	 //checking connection after clicking button
//	 String URL_After_Login_Novasis = driver.getCurrentUrl();
//	 int code_Login_Novasis = getResponseCode(URL_After_Login_Novasis);
//	 if (code_Login_Novasis != 200) {
//		 registerForClasses();
//		 return;
//	 }
	 
	 Select TermOptions = new Select(driver.findElement(By.name("term_in")));
		
	 Term myTerm = new Term();
	 TermOptions.selectByVisibleText(myTerm.getTerm());
	 
	 WebElement SubmitTerm = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));
	 SubmitTerm.submit();
	 
	//checking connection after clicking button
//		 String URL_After_Submit_Term = driver.getCurrentUrl();
//		 int code_Submit_Term = getResponseCode(URL_After_Submit_Term);
//		 if (code_Submit_Term != 200) {
//			 registerForClasses();
//			 return;
//		 }
	 
	 checkPIN(driver);

		
	}

	//	private static void classSearch(WebDriver driver, String[] args) {
//		//after registering for a class, the program goes back here
//		 WebElement ClassSearch = driver.findElement(By.cssSelector("input[type='submit'][value='Class Search']"));
//		 ClassSearch.click();
//		 Delay delay6 = new //delay(3);
//		 
//		 Select DepartmentOptions = new Select(driver.findElement(By.cssSelector("select[name='sel_subj']")));
//		//term format: e.g. Computer Science
//		 //command line: Computer\ Science
//		 DepartmentOptions.selectByVisibleText("Computer Science");
//		 Delay delay7 = new //delay(3);
//		 
//		 WebElement SubmitDepartment = driver.findElement(By.cssSelector("input[type='submit'][value='Course Search']"));
//		 SubmitDepartment.click();
//		 Delay delay8 = new //delay(3);
//		
//		 List<WebElement> CourseList = driver.findElements(By.cssSelector("input[name=\"SEL_CRSE\"]"));
//		 List<WebElement> SubmitList = driver.findElements(By.cssSelector("input[NAME=\"SUB_BTN\"][VALUE=\"View Sections\"]"));
//		 
//		 int index = 0;
//		 for(WebElement course:CourseList) {		 		
//		 		String courseNumber = course.getAttribute("value");
//		 		if (!courseNumber.isEmpty() ) {
//			 		//System.out.println(courseNumber);
//			 		//course number: args[4]  
//			 		if (courseNumber.compareTo(args[4]) == 0) {
//			 			System.out.println("course found");
//			 			SubmitList.get(index).click();
//			 			break;
//			 		};
//			 		index++;
//		 		}	 				 		
//		 }
//		 
//		 //When session number doesn't exist, it gives all the input tags with checkbox and ignores contains. Don't use it cuz of the wrong output
//		 //List<WebElement> SessionList = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@value,"+args[5]+")]"));
//		 List<WebElement> SessionList = driver.findElements(By.xpath("//input[@type='checkbox']"));
//
//		 for(WebElement session:SessionList) {		 		
//		 		String CRN = session.getAttribute("value");
//		 		if (CRN.contains(args[5])) {
//		 			System.out.println("session found");
//		 			session.click();
//		 		}else {
//		 			System.out.println("session not found or course is full");
//		 		}
//		 				 			 				 		
//		 }
//		 
//		 //click register
//		 //<input type="submit" name="ADD_BTN" value="Register" />
//		 WebElement Register = driver.findElement(By.cssSelector("input[type='submit'][value='Register']"));
//		 Register.click();
//		 
//		 System.out.println("done");	
//		 //driver.quit();
//		
//	}

private static void checkPIN(WebDriver driver) {
	 
	 //fill PIN if it's asking for a PIN
	 List<WebElement> PinElement = driver.findElements(By.cssSelector("input[type='password']"));

	 //check if there is a password field
	 if (!PinElement.isEmpty()) {
		 for (@SuppressWarnings("unused") WebElement pinField:PinElement){
			 System.out.println("PIN is requested");
			 //fillPin(driver);
			 fillPin(driver);
		 }
	 }else {
		 System.out.println("PIN is not requested");
	 }
		
}
private static void fillPin(WebDriver driver) {
		PIN pin = new PIN();
		String myPin = pin.getValue();
		
		//delay(2);
		WebElement PinField = driver.findElement(By.xpath("//input[translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
		 		+ " = 'password']"));
		PinField.sendKeys(myPin);
		//delay(2);
		
		// if it's not this button <input type="submit" value="Go" />
		// hit submit
		 WebElement SubmitButton = driver.findElement(By.xpath("//input[translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
		 		+ " = 'submit' and not(@value='Go')]"));
		 //delay(2);
		 SubmitButton.click();
}
	
private static void delay(int num){
		
		try {
			TimeUnit.SECONDS.sleep(num);
			delay_count += num;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}


}
