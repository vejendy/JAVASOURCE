package Javatest;

public class WhilePractice {

	public static void main(String[] args) {
		int arr[] = {76, 90, 60, 70 , 80, 83, 40};
		String grade[] = new String[arr.length];
		int i = 0 ;				
		while( i < arr.length){
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
			i++;
		}
		
//		for ( int i = 0 ; i < arr.length ; i++){
//			if ( arr[i] >= 90 ){
//				grade[i] = "A";
//			}
//			else if ( arr[i] >= 80 ){
//				grade[i] = "B";
//			}
//			else if ( arr[i] >= 70 ){
//				grade[i] = "C";
//			}
//			else if ( arr[i] >= 60 ){
//				grade[i] = "D";
//			}
//			else{
//				grade[i] = "F";
//			}
//		}
		for (  i =0 ; i < arr.length ; i++){
			System.out.print(grade[i]+" ");
		}
		
	}
}
