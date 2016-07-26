package kr.ac.itschool.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.ac.itschool.dbpool.DBConnectionManager;

public class UiGuiDaoService implements UiGuiDao {
	DBConnectionManager db = DBConnectionManager.getInstance();
	Connection cn = null;
	PreparedStatement ps = null; 
	ResultSet rs =null;
	boolean ans = false;

	@Override
	public boolean insertRow( Bean data ) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO customer (code,name,licence1,licence2,licence3");
		sb.append(",chief,post,add1,add2,business,type,manager");
		sb.append(",phone1,phone2,phone3");
		sb.append(")values(");
		sb.append(" '"+data.getCode()+"','"+data.getName()+"','"+data.getLicence1()+"', ");
		sb.append(" '"+data.getLicence2()+"','"+data.getLicence3()+"','"+data.getChief()+"', ");
		sb.append(" '"+data.getPost()+"','"+data.getAdd1()+"','"+data.getAdd2()+"', ");
		sb.append(" '"+data.getBusiness()+"','"+data.getType()+"','"+data.getManager()+"', ");
		sb.append(" '"+data.getPhone1()+"','"+data.getPhone2()+"','"+data.getPhone3()+"')") ;
		String sql = sb.toString();
		try{
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement( sql ); 
			ps.execute();
			ans = true; 
			cn.close();
			ps.close();
		} catch (Exception e){
			System.out.println("DB error : "+e.getMessage());
		}
		return ans;
	}
	@Override
	public void updateRow() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteRow() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkCode(String code) {
		boolean findcode = false;
		String sql = "SELECT code FROM customer where code = '"+code+"' ";
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement( sql ); 
			rs = ps.executeQuery();
			if ( rs.next() ) { 
				findcode = true;
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("DB error : "+e.getMessage());
		}
		return findcode;
	}
	@Override
	public ArrayList<Bean> searchRowAll() {
		ArrayList<Bean> list = new ArrayList<Bean>();
		String sql = "SELECT * FROM customer" ;
		System.out.println("ALL     >> "+sql);
		Bean data = null;
		try{
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement( sql ); 
			rs = ps.executeQuery();
			while( rs.next() ) {
				data = new Bean();
				data.setCode( rs.getString("code") );
				data.setName(rs.getString("name"));
				data.setLicence1(rs.getString("licence1"));
				data.setLicence2(rs.getString("licence2"));
				data.setLicence3(rs.getString("licence3"));
				data.setChief(rs.getString("chief"));
				data.setPost(rs.getString("post"));
				data.setAdd1(rs.getString("add1"));
				data.setAdd2(rs.getString("add2"));
				data.setBusiness(rs.getString("business"));
				data.setType(rs.getString("type"));
				data.setManager(rs.getString("manager"));
				data.setPhone1(rs.getString("Phone1"));
				data.setPhone2(rs.getString("Phone2"));
				data.setPhone3(rs.getString("Phone3"));
				list.add(data);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e){
			System.out.println("DB error : "+e.getMessage());
		}
		return list;
	}
	@Override
	public ArrayList<Bean> searchRowOne( String find ) {
		ArrayList<Bean> list = new ArrayList<Bean>();
		String sql = "SELECT * FROM customer where code like '%"+find+"%' OR name like '%"+find+"%' " ;
		System.out.println("find     >> "+find+ "    SQL   >>"+sql);
		Bean data = null;
		try{
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement( sql ); 
			rs = ps.executeQuery();
			while( rs.next() ) {
				data = new Bean();
				data.setCode( rs.getString("code") );
				data.setName(rs.getString("name"));
				data.setLicence1(rs.getString("licence1"));
				data.setLicence2(rs.getString("licence2"));
				data.setLicence3(rs.getString("licence3"));
				data.setChief(rs.getString("chief"));
				data.setPost(rs.getString("post"));
				data.setAdd1(rs.getString("add1"));
				data.setAdd2(rs.getString("add2"));
				data.setBusiness(rs.getString("business"));
				data.setType(rs.getString("type"));
				data.setManager(rs.getString("manager"));
				data.setPhone1(rs.getString("Phone1"));
				data.setPhone2(rs.getString("Phone2"));
				data.setPhone3(rs.getString("Phone3"));
				list.add(data);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e){
			System.out.println("DB error : "+e.getMessage());
		}
		return list;
		
	}
	

}
