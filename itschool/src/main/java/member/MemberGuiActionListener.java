package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class MemberGuiActionListener implements ActionListener {
	JTable table; JTextField id; JTextField name; JTextField pw; 
	JTextField phone1; JTextField phone2; JTextField phone3; 
	JTextField post; JTextField addr; JTextField addr1;
	
	MemberGuiActionListener(JTable table,JTextField id ,JTextField name,JTextField pw,JTextField phone1,
				JTextField phone2,JTextField phone3,JTextField post ,JTextField addr,JTextField addr1) {
		this.table = table;
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.post = post;
		this.addr = addr;
		this.addr1 = addr1;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

	}

}
