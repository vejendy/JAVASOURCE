package kr.ac.itschool.ui;

import java.util.ArrayList;

public interface UiGuiDao {
	public boolean checkCode( String code );
	public boolean insertRow( Bean data );
	ArrayList<Bean> searchRowAll();
	void updateRow();
	void deleteRow();
	ArrayList<Bean> searchRowOne(String find);
}
