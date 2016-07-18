package CallbyValue;

import java.util.Stack;

public class StackDemoMain {
	public static void main(String[] agrs) {
//		StackDemo obj = new StackDemo();
//		Stack stack = new Stack();
//		stack.push("java");
//		stack.push("oracle");
//		stack.push("jsp");
//		stack.push("html");
//		String[] strarr = obj.stackMove(stack);
//		for( String result : strarr ){
//			System.out.println(result);
//		}
		String [] arraystr = {"java","html5","android","jQuery","MySQL"};
		StringToStack obj = new StringToStack();
		Stack stack = obj.strStack(arraystr);
		while(!stack.empty()){
			System.out.print(stack.pop()+"  ");
		}
		String today = CustomDateFormat.mydateFormat();
		
		today = today.replace("-","/");
		System.out.println(today);
		
		today = today.replaceFirst("-", "년");
		today = today.replaceFirst("-", "월");
		today = today.replaceFirst(" ", "일 ");
		System.out.println(today);
		
		String year = today.substring(0, 4);
		String month = today.substring(5, 7);
		String day = today.substring(8, 10);
		String time = today.substring(11,today.length());
		System.out.println(year+"년"+month+"월"+day+"일 "+time);
		String [] date = today.split("-");
		System.out.println(date[0]+"년"+date[1]+"월"+date[2]);
		
		StringBuffer sb = new StringBuffer();
		sb.append(today.substring(0, 4)+"년");
		sb.append(today.substring(5,7)+"월");
		sb.append(today.substring(8,10)+"일 ");
		sb.append(today.substring(11,today.length()));
		System.out.println(sb);
	}
}
