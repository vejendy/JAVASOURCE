package CallbyValue;

import java.util.Stack;

public class StackDemo {
	String[] stackMove( Stack stack ){
		String strarr[] = new String [stack.size()];
// 		for( int i = 0 ; i < strarr.length ; i++ ) {
//			strarr[i] = (String) stack.pop();
//		}
		int i = 0;
		while(!stack.empty()){
			strarr[i] = (String) stack.pop();
			i++;
		}
		return strarr;
	}
}
