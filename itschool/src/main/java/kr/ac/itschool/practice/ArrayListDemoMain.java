package kr.ac.itschool.practice;

import java.util.ArrayList;

public class ArrayListDemoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayListDemo obj = new ArrayListDemo();
//		String []arr = {"java", "jsp", "android", "oracle", "mssql"};
//		ArrayList<String> list = obj.arrayListMeth(arr);
//		for ( String list1 : list ){
//			System.out.println(list1);
//		}
//		String subject = "oracle|mssql|java|jsp|android|html";
//		
//		ArrayList<String> subj = obj.subjectMeth(subject);
//		for ( String subject1 : subj){
//			System.out.println(subject1);
//		}
		int start = 1 ;
		int end = 100 ;
		ArrayList<Integer> even = obj.evenList(start, end);
		for( int even1 : even){
			System.out.println(even1);
		}
	}
}
