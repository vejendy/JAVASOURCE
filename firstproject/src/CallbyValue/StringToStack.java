package CallbyValue;

import java.util.Stack;

public class StringToStack {
	Stack strStack ( String[] array ){
		Stack stack = new Stack();
		for( int i = 0 ; i < array.length ; i++){
			stack.push(array[i]);
		}
//		int i = array.length-1 ;
//		while( i >= 0 ){
//			stack.push(array[i]);
//			i--;
//		}
		return stack;
	}

}
