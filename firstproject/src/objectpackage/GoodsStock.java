package objectpackage;

public class GoodsStock {
	public String goodsCode;
	public int stockNum;
	public GoodsStock(String code, int num) {
		goodsCode = code;
		stockNum = num;
	}
	public void addStock(int amount){
		stockNum += amount;
	}
	int subtractStock(int amount){
		if (stockNum < amount)
			return 0;
		stockNum -= amount;
		return amount;
	}

}
