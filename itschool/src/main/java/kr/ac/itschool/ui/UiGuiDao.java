package kr.ac.itschool.ui;

import java.util.ArrayList;

public interface UiGuiDao {
	public boolean checkCode( String code );
	public boolean insertRow( Bean data );
	ArrayList<Bean> searchRowAll();
	public boolean updateRow(Bean data);
	public boolean deleteRow(String code);
	ArrayList<Bean> searchRowOne(String find);
	public Bean selectRowOne(String code);
	
}
