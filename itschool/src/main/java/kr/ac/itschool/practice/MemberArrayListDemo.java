package kr.ac.itschool.practice;

import java.util.ArrayList;

import kr.ac.itschool.entities.Member;

public class MemberArrayListDemo {
	ArrayList <Member> memberListGet(){
		ArrayList <Member> list= new ArrayList<Member>();
		Member member = new Member();
		member.setId("korea");
		member.setName("이한국");
		member.setAddr1("대전시 서구 용문동");
		member.setAddr2("594-1 번지");
		member.setJob("개발자");
		list.add( member );
		
		member = new Member();
		member.setId("usa");
		member.setName("박미국");
		member.setAddr1("미국 캘리포니아주 LA시");
		member.setAddr2("에비뉴750");
		member.setJob("CEO");
		list.add( member );
		
		member = new Member();
		member.setId("china");
		member.setName("왕중국");
		member.setAddr1("중국 길림성");
		member.setAddr2("240");
		member.setJob("영업");
		list.add( member );
		
		return list;
	}
}
