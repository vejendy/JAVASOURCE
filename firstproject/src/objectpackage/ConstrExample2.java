package objectpackage;

public class ConstrExample2 {
	public static void main(String[] agrs) {
		SubscriberInfo obj1, obj2;
		obj1 = new SubscriberInfo("yeonheangbu", "poorman", "zebi");
		obj2 = new SubscriberInfo("yeonnolbu", "richman", "money","02-1234","tower");
		
		printSubscriberInfo(obj1);
		printSubscriberInfo(obj2);
	}
	static void printSubscriberInfo(SubscriberInfo obj) {
		System.out.println(obj.name);
		System.out.println(obj.id);
		System.out.println(obj.password);
		System.out.println(obj.phoneNo);
		System.out.println(obj.address);
		System.out.println();
	}

}
