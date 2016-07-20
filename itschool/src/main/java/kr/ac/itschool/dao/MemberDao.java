package kr.ac.itschool.dao;

import kr.ac.itschool.entities.Member;

public interface MemberDao {
	public boolean insertRow( Member data ) ;
	public boolean findId( String id ) ;
	public void selectAll();
}
