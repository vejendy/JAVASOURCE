package member;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.Member;
import kr.ac.itschool.service.MemberDaoService;

public class MemberGuiMouseListener implements MouseListener{
	MemberDaoService service = new MemberDaoService();
	DefaultTableModel model;
	JTable table; JTextField find ;JTextField id; JTextField name; JTextField password; 
	JTextField phone1; JTextField phone2; JTextField phone3; 
	JTextField post; JTextField addr1; JTextField addr2;
	
	MemberGuiMouseListener( DefaultTableModel model, JTable table,JTextField find,JTextField id ,JTextField name,JTextField password,JTextField phone1,
	JTextField phone2,JTextField phone3,JTextField post ,JTextField addr1,JTextField addr2){
		this.model = model;
		this.table = table;
		this.find  = find;
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		String id = (String) target.getValueAt(row , 0);
		MemberDaoService service = new MemberDaoService();
		Member data = service.selectRowone(id);
		this.id.setText( data.getId() );
		name.setText( data.getName() );
		password.setText( data.getPassword());
		phone1.setText(data.getPhone1());
		phone2.setText(data.getPhone2());
		phone3.setText(data.getPhone3()); 
		post.setText(data.getPost());
		addr1.setText(data.getAddr1());
		addr2.setText(data.getAddr2());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
