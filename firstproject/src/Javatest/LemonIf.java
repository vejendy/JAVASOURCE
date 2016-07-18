package Javatest;

public class LemonIf {
	public static void main(String[] args){
		String fruits = "apple|배|복숭아|레몬|키위|바나나|딸기";
		fruits = fruits.replace("|", " ");
		String arr[] = fruits.split(" ");
		String find = "레몬";
		int a = 0;
		
		for ( int i = 0 ; i < arr.length ; i++ ){
			if (arr[i].equals(find)){
				a = i ;
				break;
			}			 
		}	
		System.out.println(arr[a]);
		
		int position1 = 2;
		int position2 = 4;
		String temp;
		temp = arr[position1];
		arr[position1] = arr[position2];
		arr[position2] = temp;
		for (int i = 0 ; i < arr.length ; i++ ){
			System.out.print(arr[i] + " ");
		}
	}
}