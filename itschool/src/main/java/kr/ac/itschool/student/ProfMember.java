package kr.ac.itschool.student;

public class ProfMember {
	private String name;
	private String code;
	private String labno;
	private String subject;
	public ProfMember() {
	}
	
	public ProfMember(String name , String code ) {
		this.code = code;	this.name = name; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabno() {
		return labno;
	}
	public void setLabno(String labno) {
		this.labno = labno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String  toString() { return name; }
}
