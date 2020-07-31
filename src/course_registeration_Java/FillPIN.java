package course_registeration_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillPIN {
	
	FillPIN(WebDriver driver){
		PIN pin = new PIN();
		String myPin = pin.getValue();
		
		Delay delay = new Delay(2);
		WebElement PinField = driver.findElement(By.xpath("//input[translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
		 		+ " = 'password']"));
		PinField.sendKeys(myPin);
		Delay delay2 = new Delay(2);
		
		// if it's not this button <input type="submit" value="Go" />
		// hit submit
		 WebElement SubmitButton = driver.findElement(By.xpath("//input[translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
		 		+ " = 'submit' and not(@value='Go')]"));
		 Delay delay3 = new Delay(2);
		 SubmitButton.click();
	}

}
