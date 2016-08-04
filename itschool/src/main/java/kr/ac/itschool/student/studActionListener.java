package kr.ac.itschool.student;

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

public class studActionListener implements ActionListener , MouseListener{
	AschoolDaoService service = new AschoolDaoService();
	JTextField code; JComboBox dept; JTextField name; JTextField idcard; JTextField postno;
	JTextField addr1; JTextField addr2; JComboBox professor; DefaultTableModel model;  JTable table; JTextField find;

	public studActionListener(DefaultTableModel model, JTable table,JTextField find ,JTextField code, JComboBox dept, JTextField name, JTextField idcard, JTextField postno,
			JTextField addr1, JTextField addr2, JComboBox professor) {
		this.code = code; this.dept = dept; this.name = name; this.idcard = idcard; this.postno = postno;
		this.addr1 = addr1; this.addr2 = addr2; this.professor = professor;	this.model = model; this.table = table; this.find = find;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		StudMember data = new StudMember();
		data.setCode(code.getText());
		data.setDept(dept.getSelectedItem().toString());
		data.setName(name.getText());
		data.setIdcard(idcard.getText());
		data.setPostno(postno.getText());
		data.setAddr1(addr1.getText());
		data.setAddr2(addr2.getText());
		data.setProfessor(professor.getSelectedItem().toString());
		if(btn.equals("입력")){
			insertStud( data , btn );
		}
		if(btn.equals("수정")){
			updateStud( data );
		}
		if(btn.equals("삭제")){
			deleteStud();
		}
		if (btn.equals("검색")){
			searchAll( find.getText() );
		}
		if(btn.equals("취소")){
			int cancel = JOptionPane.showConfirmDialog(null, "취소 하시겠습니까?" , "Cancel Warning",
					JOptionPane.YES_NO_OPTION);
			if(cancel==0){
				screenClear();
				model.setRowCount(0);
			} else {
				return;
			}
		}
	}

	private void deleteStud() {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "삭제 할 항목을 선택하세요");
			return;
		}
		String code = (String) model.getValueAt(table.getSelectedRow(), 0);
		int confirm = JOptionPane.showConfirmDialog(null, code+"를(을) 삭제하시겠습니까?", "Delete Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(confirm==0){
			boolean result = service.deleteRow(code);
			if(result){
				JOptionPane.showMessageDialog(null, "삭제완료");
				model.removeRow(table.getSelectedRow());
				screenClear();
			} else {
				return;
			}
		}
	}

	private void updateStud(StudMember data) {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "수정항목을 선택하시오");
			return;
		}
		String before = (String) model.getValueAt(table.getSelectedRow(), 0);
		String after = code.getText();
		if (!(before.equals(after))){
			JOptionPane.showMessageDialog(null, "학번은 변경안됨");
			code.setText(before);
			return;
		}
		String[] deptcode = dept.getSelectedItem().toString().split(" ");
		String deptcode1 = deptcode[0];
		data.setDept(deptcode1);
		String[] profcode = professor.getSelectedItem().toString().split(" ");
		String profcode1 = profcode[1];
		data.setProfessor(profcode1);
	
		boolean result = service.updateRow(data);
		if(result){
			JOptionPane.showMessageDialog(null, "수정 완료");
			screenClear();
			StudMember list = service.selectRowOne(before);
			model.setValueAt(list.getDept_name(), table.getSelectedRow(), 1);
			model.setValueAt(list.getName(), table.getSelectedRow(), 2);
			model.setValueAt(list.getProf_name(), table.getSelectedRow(), 3);
		} else {
			JOptionPane.showMessageDialog(null, "수정 실패!!!");
			return;
		}
	}

	private void insertStud( StudMember data, String btn) {
		String msg = " 다시한번 입력항목 확인 해주세요 \n\n";
		if(code.getText().equals("")||code.getText()==null){
			msg += "학번을 입력하세요\n";
		}
		if(name.getText().equals("")||name.getText()==null){
			msg += "이름 입력하세요\n";
		}
		if (!msg.equals(" 다시한번 입력항목 확인 해주세요 \n\n")){
			JOptionPane.showMessageDialog(null, msg);
			return;
		}
		String[] deptcode = dept.getSelectedItem().toString().split(" ");
		String deptcode1 = deptcode[0];
		data.setDept(deptcode1);
		String[] profcode = professor.getSelectedItem().toString().split(" ");
		String profcode1 = profcode[1];
		data.setProfessor(profcode1);
		boolean result = service.insertRow(data);
		if ( result ){
			JOptionPane.showMessageDialog(null , "저장완료");
			ArrayList<StudMember> list = service.searchRow(code.getText());
			Object[] row = {"","","",""};
			for(StudMember list1 : list){
				row[0] = list1.getCode();
				row[1] = list1.getDept_name();
				row[2] = list1.getName();
				row[3] = list1.getProf_name();
				model.addRow(row);
				screenClear();
				}			
		} else {
			JOptionPane.showMessageDialog(null , "저장실패");
		}
	}

	private void searchAll(String find) {
		model.setRowCount(0);
		ArrayList<StudMember> list = null;
		if (find.equals(""))
			list = service.searchAll();
		else
			list = service.searchRow(find);
		Object row[] = {"","","",""};
		for(StudMember list1 : list){
			row[0] = list1.getCode();
			row[1] = list1.getDept_name();
			row[2] = list1.getName();
			row[3] = list1.getProf_name();
			model.addRow(row);
		}
		if (table.getRowCount()==0){
			JOptionPane.showMessageDialog(null, "검색내역이 존재하지 않습니다");
			this.find.setText("");
			return;
		}
		screenClear();
	}

	void screenClear(){
		code.setText("");
		dept.setSelectedIndex(0);
		name.setText("");
		idcard.setText("");
		postno.setText("");
		addr1.setText("");
		addr2.setText("");
		professor.setSelectedIndex(0);
		find.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		if(row == -1 ){
			JOptionPane.showMessageDialog(null , "수정사항을 선택하세요");
			return;
		}
		String code = (String) target.getValueAt(row, 0);
		StudMember data = service.selectRowOne(code);
		this.code.setText(data.getCode());
		String dept1 = data.getDept() + " "+ data.getDept_name();
		dept.setSelectedItem(dept1);
		name.setText(data.getName());
		idcard.setText(data.getIdcard());
		postno.setText(data.getPostno());
		addr1.setText(data.getAddr1());
		addr2.setText(data.getAddr2());
		String prof1 = data.getProf_name()+" "+ data.getProfessor();
		professor.setSelectedItem(prof1);
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