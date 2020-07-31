package course_registeration_Java;

import java.util.concurrent.TimeUnit;

public class Delay {
	
	public int num;
	
	Delay(int _num){
		this.num = _num;
		try {
			TimeUnit.SECONDS.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
