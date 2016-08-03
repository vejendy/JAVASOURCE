package kr.ac.itschool.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UiGuiActionListener implements ActionListener , MouseListener{
	boolean findcode;
	UiGuiDaoService service = new UiGuiDaoService();
	DefaultTableModel model; JTable table;
	JTextField code; JTextField name; JTextField licence1; JTextField licence2;
	JTextField licence3; JTextField chief; JTextField post; JTextField add1; JTextField add2;
	JTextField business; JTextField type; JTextField manager; JComboBox phone1; JTextField phone2;
	JTextField phone3; JTextField find;

	public UiGuiActionListener(DefaultTableModel model, JTable table,JTextField find ,JTextField code, JTextField name, JTextField licence1, JTextField licence2,
			JTextField licence3, JTextField chief, JTextField post, JTextField add1, JTextField add2,
			JTextField business, JTextField type, JTextField manager, JComboBox phone1, JTextField phone2,
			JTextField phone3) {
		this.find = find;
		this.model = model; this.table = table;
		this.code = code; this.name = name; this.licence1 = licence1; this.licence2 = licence2; this.licence3 =  licence3;
		this.chief = chief; this.post =  post; this.add1 = add1; this.add2 = add2; this.business = business; this.type =  type;
		this.manager = manager; this.phone1 =  phone1; this.phone2 = phone2; this.phone3 = phone3;
		
	}
	
	boolean checkCode() {
		boolean findcode = service.checkCode(code.getText());
		if(findcode){
			JOptionPane.showMessageDialog(null, "중복된 CODE 입니다\n 다시 입력해 주세요");
			code.setText("");
			this.findcode = false;
		} else {
			JOptionPane.showMessageDialog(null, "사용가능한 CODE 입니다");
			this.findcode = true;
		}
		return this.findcode;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btntxt = e.getActionCommand();
		if(btntxt.equals("중복검사")){
			if(code.getText().equals(""))
				JOptionPane.showMessageDialog(code, "CODE를 입력하세요");
			else
				checkCode();
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
		data.setPhone1( phone1.getSelectedItem().toString() );
		data.setPhone2( phone2.getText() );
		data.setPhone3( phone3.getText() );
		
		if(btntxt.equals("입력")){
			insertBean(data, btntxt);
		}
		if(btntxt.equals("검색")){
			searchBean( find.getText() );
		}
		if(btntxt.equals("취소")){
			int cancel = JOptionPane.showConfirmDialog(null, "취소 하시겠습니까?" , "Cancel Warning",
					JOptionPane.YES_NO_OPTION);
			if(cancel==0){
				screenClear();
				model.setRowCount(0);
			} else {
				return;
			}
		}
		if(btntxt.equals("수정")) {
			updateBean(data);
		}
		if(btntxt.equals("삭제")){
			deleteBean();
		}
	}

	private void deleteBean() {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "삭제 항목을 선택하세요", "DELETE Alert", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String code = (String) model.getValueAt( table.getSelectedRow() , 0);
		int confirm = JOptionPane.showConfirmDialog(null, code+"를(을) 삭제하시겠습니까?", "Delete Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(confirm==0){
			boolean ans = service.deleteRow(code);
			if(ans){
				JOptionPane.showMessageDialog(null, "삭제완료");
				model.removeRow(table.getSelectedRow());
				screenClear();
			} else {
				return;
			}
		}
	}

	private void updateBean(Bean data) {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "수정 항목을 선택하세요", "UPDATE Alert", JOptionPane.WARNING_MESSAGE);
			return;
		}
		boolean ans = service.updateRow(data);		
		String beforecode = (String) model.getValueAt(table.getSelectedRow(), 0);
		String aftercode = code.getText();
		if(!aftercode.equals(beforecode)){
			JOptionPane.showMessageDialog(null, "CODE는 변경할 수 없습니다");
			code.setText(beforecode);
			return;
		}
		if(ans){
			JOptionPane.showMessageDialog(null, "수정 완료");
			screenClear();
			model.setValueAt(data.getName(), table.getSelectedRow(), 1);
			String licence = data.getLicence1()+"-"+data.getLicence2()+"-"+data.getLicence3(); 
			model.setValueAt(licence, table.getSelectedRow(), 2);
			String phone = data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
			model.setValueAt(phone, table.getSelectedRow(), 3);
		} else { 
			JOptionPane.showMessageDialog(null, "수정 실패");
		}
	}

	private void searchBean( String find ) {
		model.setRowCount(0);
		ArrayList<Bean> list = null;
		if(find.equals(""))
			list = service.searchRowAll();
		else
			list = service.searchRowOne(find);
		Object row[] ={ "", "", "",""};
		for ( Bean list1 : list){
			row[0] = list1.getCode();
			row[1] = list1.getName();
			row[2] = list1.getLicence1()+"-"+list1.getLicence2()+"-"+list1.getLicence3();
			row[3] = list1.getPhone1()+"-"+list1.getPhone2()+"-"+list1.getPhone3();
			model.addRow( row );
		}
		if(model.getRowCount()==0)
			JOptionPane.showMessageDialog(null, find+"를(을) 찾을 수 없습니다");
		this.find.setText("");
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
		if (!msg.equals(" 다시한번 입력항목 확인 해주세요 \n\n")){
			JOptionPane.showMessageDialog(null, msg);
			return;
		}
			
		boolean ans = service.insertRow(data);
		if(ans){
			JOptionPane.showMessageDialog(null, "저장 완료!");
			Object row[] ={ "", "", "",""};
			row[0] = data.getCode();
			row[1] = data.getName();
			row[2] = data.getLicence1()+"-"+data.getLicence2()+"-"+data.getLicence3();
			row[3] = data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
			model.addRow( row );
			screenClear();
		} else{
			JOptionPane.showMessageDialog(null, "저장 실패\n 다시 입력하세요");
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
		phone1.setSelectedIndex(0);
		phone2.setText("");
		phone3.setText("");
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(null, "항목을 선택하세요", "경고창", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String code = (String) target.getValueAt(row , 0);
		Bean data = service.selectRowOne(code);
		this.code.setText(data.getCode());
		name.setText(data.getName());
		licence1.setText(data.getLicence1());
		licence2.setText(data.getLicence2());
		licence3.setText(data.getLicence3());
		chief.setText(data.getChief());
		post.setText(data.getPost());
		add1.setText(data.getAdd1());
		add2.setText(data.getAdd2());
		business.setText(data.getBusiness());
		type.setText(data.getType());
		manager.setText(data.getManager());
		phone1.setSelectedItem(data.getPhone1());
		phone2.setText(data.getPhone2());
		phone3.setText(data.getPhone3());
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
