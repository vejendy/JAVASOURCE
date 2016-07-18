package extendpackage;

public class ParentClass {
	protected int sum;
	int sumGet() {
		int sum = 0;
		sum += sum;
		return sum;
	}


}
