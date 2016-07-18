package listpackage;

import java.util.LinkedList;

public class LinkedListDemo {
	void linkedListMeth() {
		LinkedList <String>lklist = new LinkedList<String>();
		lklist.add("java");
		lklist.add("oracle");
		lklist.add("html5");
		lklist.add("jsp");
		for ( String lklist1 : lklist){
			System.err.println(lklist1);			
		}
	}
}
