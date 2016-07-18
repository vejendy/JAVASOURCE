package objectpackage;

public class SumDemo {
	
	void sumMeth( int A , int B ) {
		
		for ( int i = 1 ; i < 10 ; i ++){
			for ( int j = A ; j <= B ; j ++){
				System.out.print(j + "*" + i +"=" + i*j +"\t");
			}
			System.out.println();
		}
		
	}
	
}
