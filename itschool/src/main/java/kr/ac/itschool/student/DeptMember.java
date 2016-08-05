package kr.ac.itschool.student;

public class DeptMember {
	private String code;
	private String name;
	public DeptMember() {
	}
	
	public DeptMember(String name , String code ) {
		
		this.name = name;this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String  toString() {
		return name;
		}
	
}
