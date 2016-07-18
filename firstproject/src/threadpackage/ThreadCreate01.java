package threadpackage;

public class ThreadCreate01 extends Thread {
	public void run(){
		for (int i = 0 ; i < 1000 ; i++){
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				
			}
		}
	}

}