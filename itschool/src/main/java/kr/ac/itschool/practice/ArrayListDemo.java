package kr.ac.itschool.practice;

import java.util.ArrayList;

public class ArrayListDemo {
//	ArrayList<String> arrayListMeth(String[] arr) {
//		ArrayList<String> list = new ArrayList();
//		for ( int i = 0 ; i < arr.length ; i ++){
//			list.add(arr[i]);
//		}
//		return list;
//	}
//	ArrayList<String> subjectMeth(String subject) {
//		ArrayList<String> sub = new ArrayList();
////		subject = subject.replace("|", " ");
//		String []arrsub = subject.split("[|]"); 
//		for( int i = 0 ; i < arrsub.length ; i++){
//			sub.add(arrsub[i]);
//		}
//		return sub;
//	}
	ArrayList<Integer> evenList(int start , int end){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for ( int i = start ; i <= end ; i++){
			if ( i%2 == 0 )
				list.add(i);
		}
		
		return list;
	}
}
