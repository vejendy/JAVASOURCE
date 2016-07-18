package Javatest;

public class MultiplyDemo {

	public static void main(String[] args) {
		String arr[][] = new String[10][10];
				
		for ( int i = 0 ; i < arr.length ; i ++){
			for( int j = 0 ; j < arr[i].length ; j ++){
				arr[i][j] = j+"*"+i+"="+i*j;					
			}
		}
		
		for ( int i = 1 ; i < arr.length ; i ++){
			for( int j = 2 ; j < arr[i].length ; j ++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		String str="aaa"+(010+1)+"bb" ;
		System.out.println(str);
		
		
		
	}

}
//구구단//