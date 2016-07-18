package extendpackage;

public class ChildClass extends ParentClass {
	private int total;
	int totalGet() {
		super.sum+=1000;
		total= 20;
		return total;
	}
	void totalSet(int total){
		this.total = this.total + total;
	}
}
