package course_registeration_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillPIN {
	
	FillPIN(){

	}
	
	public static void fillPin(WebDriver driver) {
		PIN pin = new PIN();
		String myPin = pin.getValue();
		
		Delay.delay(2);
		WebElement PinField = driver.findElement(By.xpath("//input[translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
		 		+ " = 'password']"));
		PinField.sendKeys(myPin);
		Delay.delay(2);
		
		// if it's not this button <input type="submit" value="Go" />
		// hit submit
		 WebElement SubmitButton = driver.findElement(By.xpath("//input[translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
		 		+ " = 'submit' and not(@value='Go')]"));
		 Delay.delay(2);
		 SubmitButton.click();
	}

}
