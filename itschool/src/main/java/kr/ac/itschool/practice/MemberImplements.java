package kr.ac.itschool.practice;

public class MemberImplements implements MemberInterface{

	@Override
	public void insert(String no) {
		
	}

	@Override
	public int update() {
		return 0;
	}

	@Override
	public String select() {
			String sql = "selcet * from student where name is not null";
		return sql;
	}

	@Override
	public int delete() {
		return 0;
	}

	@Override
	public void sumMeth() {
		
	}

}
