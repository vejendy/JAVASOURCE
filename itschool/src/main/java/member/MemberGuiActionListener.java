package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.entities.Member;
import kr.ac.itschool.service.MemberDaoService;

public class MemberGuiActionListener implements ActionListener {
	MemberDaoService service = new MemberDaoService();
	boolean confirmchk;
	DefaultTableModel model;
	JTable table; JTextField find ;JTextField id; JTextField name; JTextField password; 
	JTextField phone1; JTextField phone2; JTextField phone3; 
	JTextField post; JTextField addr1; JTextField addr2;
	
	MemberGuiActionListener(boolean confirmchk, DefaultTableModel model, JTable table,JTextField find,JTextField id ,JTextField name,JTextField password,JTextField phone1,
				JTextField phone2,JTextField phone3,JTextField post ,JTextField addr1,JTextField addr2) {
		this.confirmchk = confirmchk;
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
	boolean confirmChk() {
		boolean findid = service.findId( id.getText() );
		if ( findid ) {
			JOptionPane.showMessageDialog(id,"중복된 ID입니다");
			id.setText("");
			confirmchk = false;
		}  else {
			JOptionPane.showMessageDialog(id,"사용가능한 ID 입니다");
			confirmchk = true;
		}
		return confirmchk;
}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String btntxt = e.getActionCommand();
		if(btntxt.equals("중복검사")){
			if(id.getText().equals("")){
				JOptionPane.showMessageDialog(id,"ID를 입력해주세요");
				return;
			}
			boolean findid = confirmChk();
			if (findid)
				return;
		}
		
//			boolean findid = service.findId( id.getText() );
//			if ( findid ) {
//				JOptionPane.showMessageDialog(id,"중복된 ID입니다");
//				id.setText("");
//				confirmchk = false;
//				return;
//			} else if ( id.getText().equals("")||id.getText()==null && (!findid) ){
//				JOptionPane.showMessageDialog(id,"ID를 입력해주세요");
//				confirmchk = false;
//				return;
//			} else {
//				JOptionPane.showMessageDialog(id,"사용가능한 ID 입니다");
//				confirmchk = true;
//			}
//		}		
		
		Member data = new Member();
		data.setId( id.getText() );
		data.setName( name.getText() );
		data.setPassword( password.getText() );
		data.setPhone1( phone1.getText() );
		data.setPhone2( phone2.getText() );
		data.setPhone3( phone3.getText() );
		data.setAddr1( addr1.getText() );
		data.setAddr2( addr2.getText() );
		
		if ( btntxt.equals("입력")){
			insertMember( data , btntxt );
		}
		if ( btntxt.equals("검색")){
			searchMember( find.getText() );
		}
	}

	
	void insertMember( Member data, String btntxt ) {
		String message = "- 입력시 체크사항 - \n\n";
		if ( !confirmchk )
			message += "중복검사 하세요! \n";
		if (id.getText().equals("") || id.getText() == null ) {
			message += "ID를 입력하세요! \n";
		}
		if (name.getText().equals("") || name.getText() == null) {
			message +=  "이름을 입력하세요!\n";
		}
		if (!message.equals("- 입력시 체크사항 - \n\n")){
			JOptionPane.showMessageDialog(id, message);
			return;
		}
		boolean success = service.insertRow(data);
		if(success){
			JOptionPane.showMessageDialog(id, "저장 완료!");
			Object row[] ={ "", "", ""};
			row[0] = data.getId();
			row[1] = data.getName();
			row[2] = data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
			model.addRow( row );
			screenClear();
		} else{
			JOptionPane.showMessageDialog(id, "저장 실패.. 다시 입력하세요");
		}		
		
	}
	void searchMember( String find ){
		model.setRowCount(0);
		ArrayList<Member> list = null;
		if(find.equals(""))
			list = 	service.selectAll();
		else 
			list = service.selectFind( find );
		Object row[] = {"","",""};
		for ( Member list1 : list ){
			row[0] = list1.getId();
			row[1] = list1.getName();
			row[2] = list1.getPhone1()+"-"+list1.getPhone2()+"-"+list1.getPhone3();
			model.addRow( row );
		}
	}
	void screenClear() {
		id.setText("");;
		password.setText("");
		name.setText("");
		phone1.setText("");
		phone2.setText("");
		phone3.setText("");
		post.setText("");
		addr1.setText("");
		addr2.setText("");
		confirmchk = false;
	}
}
