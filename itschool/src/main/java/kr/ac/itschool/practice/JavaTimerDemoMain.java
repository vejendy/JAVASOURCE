package kr.ac.itschool.practice;

import java.util.Timer;
import java.util.TimerTask;

import kr.ac.itschool.custom.CustomDateFormat;

public class JavaTimerDemoMain {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new WorkTask(),1,3000);
	}
	public static class WorkTask extends TimerTask{
		@Override
		public void run() {
			String today = CustomDateFormat.mydateFormat();
			
			System.out.println(today);
		}
	}
}
