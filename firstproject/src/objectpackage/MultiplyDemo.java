package objectpackage;

public class MultiplyDemo {
	
	void multiMeth() {
		int result = 0 ;

		for ( int i = 1 ; i < 10 ; i ++){
			for( int j = 2 ; j < 10 ; j ++){
				result = i*j;
				System.out.print(j+"*"+i+"="+result+"\t");
			}
			System.out.println();
		}
		
	}
}
