package threadpackage;

public class ThreadDemoMain {

	public static void main(String[] args) {
		Thread thread1 = new ThreadCreate01();
		Thread thread2 = new ThreadCreate02();
		thread1.start();
		thread2.start();
	}

}