package Javatest2;

public class MyJob {
	public static void main(String[] args){
		String job1 = "공무원";
		String job2 = "교수";
		String job3 = "경찰";
		
		String myjob = "교수";
		
		if ( myjob.equals(job1) ){
			System.out.println("내 직업은 "+ job1 +"입니다");
		}
		else if ( myjob.equals(job2) ){
			System.out.println("내 직업은 "+job2 + "입니다");
		}
		else{
			System.out.println("내 직업은 "+ job3+"입니다");
		}
	}
}
