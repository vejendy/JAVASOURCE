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

public class profActionListener implements ActionListener , MouseListener{
	AschoolDaoService service = new AschoolDaoService();
	JTextField code; JTextField name; DefaultTableModel model; JTable table;JTextField find;
	public profActionListener(DefaultTableModel model, JTable table, JTextField code, JTextField name, JTextField find) {
		this.code = code; this.name = name; this.model = model; this.table = table ; this.find = find;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		ProfMember data1 = new ProfMember();
		data1.setCode(code.getText());
		data1.setName(name.getText());
		if(btn.equals("입력")){
			insertProf(data1 , btn);
		}
		if(btn.equals("수정")){
			updateProf( data1 );
		}
		if(btn.equals("삭제")){
			deleteProf();
		}
		if(btn.equals("검색")){
			searchProf(find.getText());
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

	private void insertProf(ProfMember data1, String btn) {
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
		boolean result = service.insertProf(data1);
		if ( result ){
			JOptionPane.showMessageDialog(null , "저장완료");
			Object[] row = {"",""};
			row[0] = data1.getCode();
			row[1] = data1.getName();
			model.addRow(row);
			screenClear();
		} else {
			JOptionPane.showMessageDialog(null , "저장실패");
		}
		
	}

	private void updateProf(ProfMember data1) {
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
		boolean result = service.updateProf(data1);
		if(result){
			JOptionPane.showMessageDialog(null, "수정 완료");
			screenClear();
			model.setValueAt(data1.getName(), table.getSelectedRow(), 1);
		} else {
			JOptionPane.showMessageDialog(null, "수정 실패!!!");
			return;
		}
	}

	private void deleteProf() {
		if(code.getText().equals("")){
			JOptionPane.showMessageDialog(null, "삭제 할 항목을 선택하세요");
			return;
		}
		String code = (String) model.getValueAt(table.getSelectedRow(), 0);
		int confirm = JOptionPane.showConfirmDialog(null, code+"를(을) 삭제하시겠습니까?", "Delete Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(confirm==0){
			boolean result = service.deleteProf(code);
			if(result){
				JOptionPane.showMessageDialog(null, "삭제완료");
				model.removeRow(table.getSelectedRow());
				screenClear();
			} else {
				return;
			}
		}
	}

	private void searchProf(String find) {
		model.setRowCount(0);
		ArrayList<ProfMember> listprof = null;
		if (find.equals(""))
			listprof = service.searchProfAll();
		else
			listprof = service.searchProfOne(find);
		Object row[] = {"",""};
		for(ProfMember list1 : listprof){
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
		ProfMember data1 = service.selectProfOne(code);
		this.code.setText(data1.getCode());
		name.setText(data1.getName());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}		
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
