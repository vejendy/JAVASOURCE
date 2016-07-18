package objectpackage;

import java.util.Random;

public class LottoDemo {
	public int[] lotto( ) {
		int arr[];
		arr = new int[6];
		Random random = new Random();
		
		for ( int i = 0 ; i < arr.length ; i ++) {
			arr[i] = random.nextInt(45)+1;
//			System.out.print(arr[i]+"   ");
			for ( int j = 0 ; j < i ; j ++) {
//				System.out.print("인덱스번호 j:"+j+" 배열j 값 :"+arr[j]+"   인덱스번호 i:"+i+" 배열i 값 :"+arr[i]);
				if ( arr[i] == arr[j]){
					i--;
				break;
				}
			}
//			System.out.println("i.."+arr[i]+"  ");
		}
		return arr;
//		for ( int i = 0 ; i  < arr.length ; i ++) {
//			System.out.print("   로또번호 : "+ arr[i]);
//		}
		
	}

}
