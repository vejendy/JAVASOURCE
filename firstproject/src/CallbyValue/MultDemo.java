package CallbyValue;

public class MultDemo {
	String[] multMeth( String arr[],int st ,int en ){
		String temp = null;
		temp = arr[st];
		arr[st] = arr[en];
		arr[en] = temp;
		return arr;
	}

	int[] valueChange( int arr[] ) {
		int temp = 0;
		for ( int i = 0 ; i < arr.length ; i++ ){
			for (int j = i+1 ; j < arr.length ; j++){
				if ( arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	int[] valueChange1( int arr[] ) {
		int temp = 0;
		for ( int i = 0 ; i < arr.length ; i++ ){
			for (int j = i+1 ; j < arr.length ; j++){
				if ( arr[i] < arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	int valueMax( int intarr[] ) {
		int max = 0 ;
		for ( int i = 0 ; i < intarr.length ; i ++){
			if( max < intarr[i]){
				max = intarr[i];
			}
		}
		
		return max;
	}
	
}
