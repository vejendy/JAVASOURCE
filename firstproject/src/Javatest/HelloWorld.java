package Javatest;

public class HelloWorld {
	public static void main(String[] args){
		String fruits = "apple 배 복숭아 레몬 키위 바나나 딸기";
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
	}
}