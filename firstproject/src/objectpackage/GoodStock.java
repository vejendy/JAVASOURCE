package objectpackage;

public class GoodStock {
	private int stock;
	private String code;
	
	public GoodStock(){
	}
	
	public GoodStock( int stock , String code) {
		this.stock = stock;
		this.code = code;
	}
	
	void addStock() {
		System.out.println("add Stock.."+this.stock);
	}
	void subStock(){
		System.out.println("sub Stock...."+this.code);
	}
	void callMeth() {
		System.out.println("call test...");
	}
}
