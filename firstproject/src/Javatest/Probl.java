package Javatest;

public class Probl {

	public static void main(String[] args) {
		int arr[] = {76, 90, 60, 70 , 80, 83, 40};
		String grade[] = new String[arr.length];
		
		for ( int i = 0 ; i < arr.length ; i++){
			if ( arr[i] >= 90 ){
				grade[i] = "A";
			}
			else if ( arr[i] >= 80 ){
				grade[i] = "B";
			}
			else if ( arr[i] >= 70 ){
				grade[i] = "C";
			}
			else if ( arr[i] >= 60 ){
				grade[i] = "D";
			}
			else{
				grade[i] = "F";
			}
		}
		for ( String num : grade ){
			System.out.print(num+" ");
		}
		
	}
}