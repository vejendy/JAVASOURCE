package kr.ac.itschool.beanpractice;

import java.util.ArrayList;

public class mainArrayList {

	public static void main(String[] args) {
		BeanArrayList data = new BeanArrayList();
		
		ArrayList<BeanArrayList> arrlist = new ArrayList<BeanArrayList>();
		ArrayList<String> mlist = new ArrayList<String>();
		data.setStr("111");
		data.setStr2("addd111");
		mlist.add("one");
		mlist.add("two");
		mlist.add("three");
		data.setList(mlist);
		arrlist.add(data);
		
		data = new BeanArrayList();
		data.setStr("222");
		data.setStr2("hhhh222");
		mlist.add("four");
		mlist.add("five");
		mlist.add("six");
		data.setList(mlist);
		arrlist.add(data);
		
		for ( BeanArrayList arrlist1 : arrlist){
			System.out.print( arrlist1.getStr()+"\t" );
			System.out.print( arrlist1.getStr2()+"\t");
			for(String str0 : arrlist1.getList() ){
				System.out.print(str0+"\t");
			}
			System.out.println();
		}
		

	}

}
