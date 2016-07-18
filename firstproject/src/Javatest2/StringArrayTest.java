package Javatest2;

public class StringArrayTest {
	public static void main(String[] args){
		String str = "html oracle java spring jQuery javascript Android";
		String arr[] = str.split(" ");
		for( int i = 0 ; i < arr.length ; i++ ){
			if ( arr[i].equals("spring") ) {
				System.out.println(i+"번째"+arr[i]);
				break;
			}			
		}
	}
	
}

