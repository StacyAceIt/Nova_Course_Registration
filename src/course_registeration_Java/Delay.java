package course_registeration_Java;

import java.util.concurrent.TimeUnit;

public class Delay {
	
	Delay(){
		
	}
	
	public static void delay(int num){

		try {
			TimeUnit.SECONDS.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
