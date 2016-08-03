package kr.ac.itschool.student;

import java.util.ArrayList;

public interface AschoolDao {
	ArrayList<ProfMember> comboProf();
	ArrayList<DeptMember> comboDept();
	ArrayList<StudMember> searchAll();
	ArrayList<StudMember> searchRow(String find);
	boolean insertRow(StudMember data);
	boolean updateRow(StudMember data);
	boolean deleteRow(String code);
	String deptTrans(String dept);
	String profTrans(String prof);
	StudMember selectRowOne(String code);
	boolean insertDept(DeptMember data2);
	boolean updateDept(DeptMember data2);
	boolean deleteDept(String code);
	DeptMember selectDeptOne(String code);
	ArrayList<DeptMember> searchDeptAll();
	ArrayList<DeptMember> searchDeptOne(String find);
	boolean insertProf(ProfMember data1);
	boolean updateProf(ProfMember data1);
	boolean deleteProf(String code);
	ProfMember selectProfOne(String code);
	ArrayList<ProfMember> searchProfAll();
	ArrayList<ProfMember> searchProfOne(String find);
}
