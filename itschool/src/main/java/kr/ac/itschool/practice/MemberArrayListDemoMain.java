package kr.ac.itschool.practice;

import java.util.ArrayList;

import kr.ac.itschool.entities.Member;

public class MemberArrayListDemoMain {
	
	public static void main(String[] args){
		MemberArrayListDemo obj = new MemberArrayListDemo();
		ArrayList<Member> list = obj.memberListGet();
		Member data = new Member();
		for( int i = 0 ; i < list.size() ; i++ ){
			data = list.get(i);
			System.out.print("id: "+ data.getId()+" name: "+data.getName()+" addr1: "+data.getAddr1()+data.getAddr2() );
			System.out.println();
		}
		
	}
	
}
