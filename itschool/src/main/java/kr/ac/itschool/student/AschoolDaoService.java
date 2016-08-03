package kr.ac.itschool.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import kr.ac.itschool.dbpool.DBConnectionManager;

public class AschoolDaoService implements AschoolDao{
	DBConnectionManager db = DBConnectionManager.getInstance();
	Connection cn = null;
	PreparedStatement ps = null; 
	ResultSet rs =null;
	boolean result = false;

	@Override
	public ArrayList<StudMember> searchAll() {
		ArrayList<StudMember> list = new ArrayList<StudMember>();
		StudMember data = null;
		String sql = "SELECT A.code , B.name , A.name , C.name FROM student A, dept B , professor C "
				+ "where A.dept=B.code and A.professor=C.code";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new StudMember();
				data.setCode(rs.getString(1));
				data.setDept_name(rs.getString(2));
				data.setName(rs.getString(3));
				data.setProf_name(rs.getString(4));
				list.add(data);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return list;
		
		
	}
	
	@Override
	public ArrayList<StudMember> searchRow ( String find ) {
		ArrayList<StudMember> list1 = new ArrayList<StudMember>();
		String sql ="select A.code , B.name , A.name , C.name from student A, dept B, professor C"
				+ " where ( A.code like '%"+find+"%' OR A.name like '%"+find+"%' ) "
				+ "AND  A.dept=B.code and A.professor = C.code ";
		StudMember data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new StudMember();
				data.setCode(rs.getString(1));
				data.setDept_name(rs.getString(2));
				data.setName(rs.getString(3));
				data.setProf_name(rs.getString(4));
				list1.add(data);
			}
			cn.close();
			ps.close();
			rs.close();			
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return list1; 
		
	}

	@Override
	public boolean insertRow(StudMember data) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO student (code, name, idcard, postno, addr1, addr2, professor, dept ");
		sb.append(" )values( ");
		sb.append(" '"+data.getCode()+"', '"+data.getName()+"', '"+data.getIdcard()+"', " );
		sb.append(" '"+data.getPostno()+"', '"+data.getAddr1()+"', '"+data.getAddr2()+"', " );
		sb.append(" '"+data.getProfessor()+"', '"+data.getDept()+"' ) " );
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n 입력이 안됨");
			System.out.println("DB error 입: "+e.getMessage());
			result = false;
		}
		return result;
		
	}

	@Override
	public boolean updateRow(StudMember data) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE student SET dept='"+data.getDept()+"', ");
		sb.append(" name='"+data.getName()+"', idcard='"+data.getIdcard()+"', postno='"+data.getPostno()+"', ");
		sb.append(" addr1='"+data.getAddr1()+"', addr2='"+data.getAddr2()+"', professor='"+data.getProfessor()+"' ");
		sb.append(" WHERE code='"+data.getCode()+"' ");
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("DB error 수: "+e.getMessage());
		}	
		return result;
		
	}

	@Override
	public boolean deleteRow( String code ) {
		String sql = "DELETE FROM student where code='"+code+"' ";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("DB error 삭: "+e.getMessage());
		}
		return result;
		
	}

	@Override
	public ArrayList<DeptMember> comboDept() {
		String sql = "SELECT name FROM dept";
		DeptMember data2 = null;
		ArrayList<DeptMember> deptlist = new ArrayList<DeptMember>();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data2 = new DeptMember();
				data2.setName(rs.getString("name")) ;
				deptlist.add(data2);
			}
			cn.close();
			ps.close();
			rs.close();	
		}
		catch (Exception e) {
			System.out.println("combo  "+e.getMessage());
		}
		return deptlist;
		
	}

	@Override
	public ArrayList<ProfMember> comboProf() {
		String sql = "SELECT name FROM professor";
		ProfMember data1 = null;
		ArrayList<ProfMember> proflist = new ArrayList<ProfMember>();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data1 = new ProfMember();
				data1.setName(rs.getString("name")) ;
				proflist.add(data1);
			}
			cn.close();
			ps.close();
			rs.close();	
		}
		catch (Exception e) {
			System.out.println("DB error :  "+e.getMessage());
		}
		return proflist;
		
	}

	@Override
	public String deptTrans(String dept) {
		String sql = "SELECT code FROM dept where name = '"+dept+"'";
		String transdept = new String();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				transdept = rs.getString("code");
			}
			cn.close();
			ps.close();
			rs.close();	
		}
		catch (Exception e) {
			System.out.println("DB error :  "+e.getMessage());
		}
		return transdept;
	}

	@Override
	public String profTrans(String prof) {
		String sql = "SELECT code FROM professor where name = '"+prof+"'";
		String transprof = new String();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				transprof = rs.getString("code");
			}
			cn.close();
			ps.close();
			rs.close();	
		}
		catch (Exception e) {
			System.out.println("DB error :  "+e.getMessage());
		}
		return transprof;
	}

	@Override
	public StudMember selectRowOne(String code) {
		String sql = "select * from student,dept,professor where student.code='"+code+"' "
				+ " and student.dept = dept.code and student.professor = professor.code ";
		StudMember data = null ;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new StudMember();
				data.setCode(rs.getString("code"));
				data.setDept(rs.getString("dept"));
				data.setName(rs.getString("name"));
				data.setIdcard(rs.getString("idcard"));
				data.setPostno(rs.getString("postno"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setProfessor(rs.getString("professor"));
				data.setDept_name(rs.getString(11));
				data.setProf_name(rs.getString(13));
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error :  "+e.getMessage());
		}
		return data;
	}

	@Override
	public boolean insertDept(DeptMember data2) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dept ( code , name ");
		sb.append(" ) values ( ");
		sb.append(" '"+data2.getCode()+"' , '"+data2.getName()+"' ) ");
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n 입력불가 \n");
			System.out.println("DB error 학과입:  "+e.getMessage());
			result=false;
		}
		return result;
	}

	@Override
	public ArrayList<DeptMember> searchDeptAll() {
		String sql = "SELECT * FROM dept";
		ArrayList<DeptMember> listdept = new ArrayList<DeptMember>();
		DeptMember data2 = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data2 = new DeptMember();
				data2.setCode(rs.getString("code"));
				data2.setName(rs.getString("name"));
				listdept.add(data2);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return listdept;
	}

	@Override
	public ArrayList<DeptMember> searchDeptOne(String find) {
		String sql = "SELECT * FROM dept where code like '%"+find+"%' OR name  like '%"+find+"%'  ";
		ArrayList<DeptMember> listdept = new ArrayList<DeptMember>();
		DeptMember data2 = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data2 = new DeptMember();
				data2.setCode(rs.getString("code"));
				data2.setName(rs.getString("name"));
				listdept.add(data2);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return listdept;
	}

	@Override
	public boolean updateDept(DeptMember data2) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE dept SET name='"+data2.getName()+"' ");
		sb.append(" WHERE code='"+data2.getCode()+"' ");
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n 수정불가 \n");
			System.out.println("DB error 학과수:  "+e.getMessage());
			result=false;
		}
		return result;
	}

	@Override
	public DeptMember selectDeptOne(String code) {
		String sql = "SELECT * FROM dept where code='"+code+"' ";
		DeptMember data2 = null ;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data2 = new DeptMember();
				data2.setCode(rs.getString("code"));
				data2.setName(rs.getString("name"));
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error :  "+e.getMessage());
		}
		return data2;
	}

	@Override
	public boolean deleteDept(String code) {
		String sql = "DELETE FROM dept WHERE code='"+code+"' ";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"때문에 \n 삭제할 수 없습니다");
			System.out.println("DB error 삭: "+e.getMessage());
			result = false;
		}
		return result;
	}

	@Override
	public boolean insertProf(ProfMember data1) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO professor ( code , name ");
		sb.append(" ) values ( ");
		sb.append(" '"+data1.getCode()+"' , '"+data1.getName()+"' ) ");
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n 입력불가 \n");
			System.out.println("DB error 교수입:  "+e.getMessage());
			result=false;
		}
		return result;
	}

	@Override
	public boolean updateProf(ProfMember data1) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE professor SET name='"+data1.getName()+"' ");
		sb.append(" WHERE code='"+data1.getCode()+"' ");
		String sql = sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n 수정불가 \n");
			System.out.println("DB error 교수수:  "+e.getMessage());
			result=false;
		}
		return result;
	}

	@Override
	public boolean deleteProf(String code) {
		String sql = "DELETE FROM professor WHERE code='"+code+"' ";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"때문에 \n 삭제할 수 없습니다");
			System.out.println("DB error 교수삭: "+e.getMessage());
			result = false;
		}
		return result;
	}

	@Override
	public ProfMember selectProfOne(String code) {
		String sql = "SELECT * FROM professor where code='"+code+"' ";
		ProfMember data1 = null ;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data1 = new ProfMember();
				data1.setCode(rs.getString("code"));
				data1.setName(rs.getString("name"));
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error :  "+e.getMessage());
		}
		return data1;
	}

	@Override
	public ArrayList<ProfMember> searchProfAll() {
		String sql = "SELECT * FROM professor";
		ArrayList<ProfMember> listprof = new ArrayList<ProfMember>();
		ProfMember data1 = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data1 = new ProfMember();
				data1.setCode(rs.getString("code"));
				data1.setName(rs.getString("name"));
				listprof.add(data1);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return listprof;
	}

	@Override
	public ArrayList<ProfMember> searchProfOne(String find) {
		String sql = "SELECT * FROM professor where code like '%"+find+"%' OR name  like '%"+find+"%'  ";
		ArrayList<ProfMember> listprof = new ArrayList<ProfMember>();
		ProfMember data1 = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data1 = new ProfMember();
				data1.setCode(rs.getString("code"));
				data1.setName(rs.getString("name"));
				listprof.add(data1);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return listprof;
	}
}
