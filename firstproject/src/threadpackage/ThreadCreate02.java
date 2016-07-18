package threadpackage;

import java.io.BufferedReader;
import java.io.FileReader;

public class ThreadCreate02 extends Thread {
	public void run() {
		StringBuffer sb = new StringBuffer();
		try {
			FileReader file = new FileReader("D:/treasure.txt");
//			FileInputStream ins = new FileInputStream(file);
//			InputStreamReader insr = new InputStreamReader(ins);
			BufferedReader br = new BufferedReader(file);
			
			String data = null;
			while ( true ){
				data = br.readLine();
				System.out.println(data);
				Thread.sleep(500);
			}
		} catch (Exception e) {
						
		} 
	}

}
