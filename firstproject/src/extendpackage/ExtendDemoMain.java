package extendpackage;

public class ExtendDemoMain {

	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
//		int sum = obj.sumGet();
//		int total = obj.totalGet();
//		System.out.println("sum: "+sum);
//		System.out.println("total:  "+total);
//		obj.totalSet(300);
//		total = obj.totalGet();
//		System.out.println(total);
		int sum = obj.sumGet();
		int total = obj.totalGet();
		obj.totalSet(10);
		System.out.println(sum);
		System.out.println(total);
		total = obj.totalGet();
		System.out.println(total);
		
	}

}
