package kr.ac.itschool.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class deptActionListener implements ActionListener , MouseListener {
	AschoolDaoService service = new AschoolDaoService();
	JTextField code; JTextField name;DefaultTableModel model; JTable table;JTextField find;
	
	public deptActionListener(DefaultTableModel model, JTable table, JTextField code, JTextField name, JTextField find) {
		this.code = code; this.name = name; this.model = model; this.table = table; this.find = find;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		DeptMember data2 = new DeptMember();
		data2.setCode(code.getText());
		data2.setName(name.getText());
		
		if(btn.equals("입력")){
			insertDept(data2 , btn);
		}
		if(btn.equals("수정")){
			updateDept( data2 );
		}
		if(btn.equals("삭제")){
			deleteDept();
		}
		if(btn.equals("검색")){
			searchDept(find.getText());
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

	private void insertDept(DeptMember data2, String btn) {
		String msg = " 다시한번 입력항목 확인 해주세요 \n\n";
		if(code.getText().equals("")||code.getText()==null){
			msg += "코드를 입력하세요\n";
		}
		if(name.getText().equals("")||name.getText()==null){
			msg += "이름 입력하세요\n";
		}
		if (!msg.equals(" 다시한번 입력항목 확인 해주세요 \n\n")){
			JOptionPane.showMessageDialog(null, msg);
			return;
		}
		boolean result = service.insertDept(data2);
		if ( result ){
			JOptionPane.showMessageDialog(null , "저장완료");
			Object[] row = {"",""};
			row[0] = data2.getCode();
			row[1] = data2.getName();
			model.addRow(row);
			screenClear();
		} else {
			JOptionPane.showMessageDialog(null , "저장실패");
		}
	}

	private void updateDept(DeptMember data2) {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "수정항목을 선택하시오");
			return;
		}
		String before = (String) model.getValueAt(table.getSelectedRow(), 0);
		String after = code.getText();
		if (!(before.equals(after))){
			JOptionPane.showMessageDialog(null, "코드는 변경안됨");
			code.setText(before);
			return;
		}
		boolean result = service.updateDept(data2);
		if(result){
			JOptionPane.showMessageDialog(null, "수정 완료");
			screenClear();
			model.setValueAt(data2.getName(), table.getSelectedRow(), 1);
		} else {
			JOptionPane.showMessageDialog(null, "수정 실패!!!");
			return;
		}
	}

	private void deleteDept() {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "삭제 할 항목을 선택하세요");
			return;
		}
		String code = (String) model.getValueAt(table.getSelectedRow(), 0);
		int confirm = JOptionPane.showConfirmDialog(null, code+"를(을) 삭제하시겠습니까?", "Delete Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(confirm==0){
			boolean result = service.deleteDept(code);
			if(result){
				JOptionPane.showMessageDialog(null, "삭제완료");
				model.removeRow(table.getSelectedRow());
				screenClear();
			} else {
				return;
			}
		}
	}

	private void searchDept(String find) {
		model.setRowCount(0);
		ArrayList<DeptMember> listdept = null;
		if (find.equals(""))
			listdept = service.searchDeptAll();
		else
			listdept = service.searchDeptOne(find);
		Object row[] = {"",""};
		for(DeptMember list1 : listdept){
			row[0] = list1.getCode();
			row[1] = list1.getName();
			model.addRow(row);
		}
		if (table.getRowCount()==0){
			JOptionPane.showMessageDialog(null, "검색내역이 존재하지 않습니다");
			this.find.setText("");
			return;
		}
		screenClear();
	}

	private void screenClear() {
		code.setText("");
		name.setText("");
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
		DeptMember data2 = service.selectDeptOne(code);
		this.code.setText(data2.getCode());
		name.setText(data2.getName());
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