package course_registeration_Java;

import java.util.concurrent.TimeUnit;

public class Delay {
	static int count = 0;
	
	Delay(){
		
	}
	
	public static void delay(int num){

		try {
			TimeUnit.SECONDS.sleep(num);
			count += num;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int getDelayCount() {
		return count;
	}

}
