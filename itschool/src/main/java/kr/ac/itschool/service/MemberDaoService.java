package kr.ac.itschool.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.ac.itschool.custom.CustomDateFormat;
import kr.ac.itschool.dao.MemberDao;
import kr.ac.itschool.dbpool.DBConnectionManager;
import kr.ac.itschool.entities.Member;

public class MemberDaoService implements MemberDao{
	boolean success = false;
	DBConnectionManager db = DBConnectionManager.getInstance();
	Connection cn = null;
	PreparedStatement ps = null; 
	ResultSet rs =null;
	
	@Override
	public boolean insertRow(Member data) {
		String inputdate = CustomDateFormat.mydateFormat();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO member (id,name,password,phone1,phone2");
		sb.append(",phone3,post,addr1,addr2,cardno,job,picture,inputdate");
		sb.append(")values(");
		sb.append(" '"+data.getId()+"','"+data.getName()+"','"+data.getPassword()+"', ");
		sb.append(" '"+data.getPhone1()+"','"+data.getPhone2()+"','"+data.getPhone3()+"', ");
		sb.append(" '"+data.getPost()+"','"+data.getAddr1()+"','"+data.getAddr2()+"', ");
		sb.append(" '"+data.getCardno()+"','"+data.getJob()+"','"+data.getPicture()+"','"+inputdate+"')") ;
		String sql = sb.toString();
		System.out.println(sql);
		try{
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement( sql ); 
			ps.execute();
			success = true; 
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return success;
	}

	@Override
	public boolean findId(String id) {
		String sql = "SELECT id FROM member where id = '"+id+"' ";  /* 문자: ' "+id+" ' =>따옴표 확인! int : "+숫자+" */
		boolean findid = false;
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement( sql ); 
			rs = ps.executeQuery();
			if ( rs.next() ) { 
				findid = true;
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("db error : "+e.getMessage());
		}
		return findid;
	}

	@Override
	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member data = null;
		String sql = "SELECT * FROM member";
		try {
			cn = db.getConnection(); 
			ps = (PreparedStatement) cn.prepareStatement( sql );
			rs = ps.executeQuery();
			while (rs.next()){
				data = new Member();
				data.setId( rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
				list.add( data );
			}
		} catch (Exception e) {
			System.out.println("db error : "+e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Member> selectFind( String find ) {
		ArrayList<Member> list = new ArrayList<Member>();
		Member data = null;
		String sql = "SELECT * FROM member where id like '%"+find+"%' OR name like '%"+find+"%' ";
		try {
			cn = db.getConnection(); 
			ps = (PreparedStatement) cn.prepareStatement( sql );
			rs = ps.executeQuery();
			while (rs.next()){
				data = new Member();
				data.setId( rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
				list.add( data );
			}
		} catch (Exception e) {
			System.out.println("db error : "+e.getMessage());
		}
		return list;		
	}

}
