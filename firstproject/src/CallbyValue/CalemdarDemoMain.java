package CallbyValue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalemdarDemoMain {

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = 
				new SimpleDateFormat("yyyy-MM-dd aa hh:mm");
		String today = dateFormat.format(calendar.getTime());
		System.out.println(today);
	}

}
