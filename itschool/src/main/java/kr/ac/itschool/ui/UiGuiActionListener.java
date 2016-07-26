package kr.ac.itschool.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UiGuiActionListener implements ActionListener {
	boolean findcode;
	UiGuiDaoService service = new UiGuiDaoService();
	DefaultTableModel model; JTable table;
	JTextField code; JTextField name; JTextField licence1; JTextField licence2;
	JTextField licence3; JTextField chief; JTextField post; JTextField add1; JTextField add2;
	JTextField business; JTextField type; JTextField manager; JTextField phone1; JTextField phone2;
	JTextField phone3; JTextField find;

	public UiGuiActionListener(DefaultTableModel model, JTable table, JTextField code, JTextField name, JTextField licence1, JTextField licence2,
			JTextField licence3, JTextField chief, JTextField post, JTextField add1, JTextField add2,
			JTextField business, JTextField type, JTextField manager, JTextField phone1, JTextField phone2,
			JTextField phone3, JTextField find) {
		this.find = find;
		this.model = model; this.table = table;
		this.code = code; this.name = name; this.licence1 = licence1; this.licence2 = licence2; this.licence3 =  licence3;
		this.chief = chief; this.post =  post; this.add1 = add1; this.add2 = add2; this.business = business; this.type =  type;
		this.manager = manager; this.phone1 =  phone1; this.phone2 = phone2; this.phone3 = phone3;
		
	}
	
	boolean checkCode() {
		boolean findcode = service.checkCode(code.getText());
		if(findcode){
			JOptionPane.showMessageDialog(table, "중복된 CODE 입니다\n 다시 입력해 주세요");
			code.setText("");
			this.findcode = false;
		} else {
			JOptionPane.showMessageDialog(table, "사용가능한 CODE 입니다");
			this.findcode = true;
		}
		return this.findcode;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btntxt = e.getActionCommand();
		if(btntxt.equals("중복검사")){
			if(code.getText().equals("")){
				JOptionPane.showMessageDialog(code, "CODE를 입력하세요");
			} else {
				checkCode();
			}
		}
		
		Bean data = new Bean();
		data.setCode(code.getText());
		data.setName(name.getText());
		data.setLicence1(licence1.getText());
		data.setLicence2(licence2.getText());
		data.setLicence3(licence3.getText());
		data.setChief(chief.getText());
		data.setPost(post.getText());
		data.setAdd1(add1.getText());
		data.setAdd2(add2.getText());
		data.setBusiness(business.getText());
		data.setType(type.getText());
		data.setManager(manager.getText());
		data.setPhone1( phone1.getText() );
		data.setPhone2( phone2.getText() );
		data.setPhone3( phone3.getText() );
		
		
		if(btntxt.equals("입력")){
			insertBean(data, btntxt);
		}
		if(btntxt.equals("검색")){
			System.out.println(find.getText());
			searchBean( find.getText() );
		}
			
		
		
	}

	private void searchBean( String find ) {
		model.setRowCount(0);
		ArrayList<Bean> list = null;
		if(find.equals(""))
			list = service.searchRowAll();
		else
			list = service.searchRowOne(find);
			System.out.println(find);
		Object row[] ={ "", "", "",""};
		for ( Bean list1 : list){
			row[0] = list1.getCode();
			row[1] = list1.getName();
			row[2] = list1.getLicence1()+"-"+list1.getLicence2()+"-"+list1.getLicence3();
			row[3] = list1.getPhone1()+"-"+list1.getPhone2()+"-"+list1.getPhone3();
			model.addRow( row );
		}
		screenClear();
	}

	private void insertBean(Bean data, String btntxt) {
		String msg = " 다시한번 입력항목 확인 해주세요 \n\n";
		if(!findcode){
			msg += "중복확인 먼저 하세요\n";
		}
		if(code.getText().equals("")||code.getText()==null){
			msg += "CODE를 입력하세요\n";
		}
		if(name.getText().equals("")||name.getText()==null){
			msg += "상호를 입력하세요\n";
		}
		if(licence1.getText().equals("")||licence2.getText().equals("")||licence3.getText().equals("")||licence1.getText()==null||licence2.getText()==null||licence3.getText()==null){
			msg += "사업자 번호를 입력하세요\n";
		}
		if (!msg.equals("- 입력시 체크사항 - \n\n")){
			JOptionPane.showMessageDialog(table, msg);
			return;
		}
			
		boolean ans = service.insertRow(data);
		if(ans){
			JOptionPane.showMessageDialog(table, "저장 완료!");
			Object row[] ={ "", "", "",""};
			row[0] = data.getCode();
			row[1] = data.getName();
			row[2] = data.getLicence1()+"-"+data.getLicence2()+"-"+data.getLicence3();
			row[3] = data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
			model.addRow( row );
			screenClear();
		} else{
			JOptionPane.showMessageDialog(table, "저장 실패\n 다시 입력하세요");
		}
		
	}

	private void screenClear() {
		code.setText("");
		name.setText("");
		licence1.setText("");
		licence2.setText("");
		licence3.setText("");
		chief.setText("");
		post.setText("");
		add1.setText("");
		add2.setText("");
		business.setText("");
		type.setText("");
		manager.setText("");
		phone1.setText("");
		phone2.setText("");
		phone3.setText("");
		
		
	}

}
