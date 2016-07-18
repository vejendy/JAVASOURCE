package kr.ac.itschool.practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalculatorClickListener implements ActionListener  {
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;	
	private JLabel label1;
	CalculatorClickListener(JTextField text1,JTextField text2,JTextField text3, JLabel label1){	
		this.text1 = text1;
		this.text2 = text2;	
		this.text3 = text3;	
		this.label1 = label1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String gettext = e.getActionCommand();
		boolean numcheck = chkNum(text1.getText());
		if(!numcheck){
			JOptionPane.showMessageDialog(text1, "처음 수를 입력하세요");
			return;
		}
		numcheck = chkNum(text2.getText());
		if(!numcheck){
			JOptionPane.showMessageDialog(text2, "다음 수를 입력하세요");
			return;
		}
		int num1 = Integer.parseInt(text1.getText());
		int num2 = Integer.parseInt(text2.getText());
		int result = 0;
		if(gettext.equals("+")){
			result = num1+num2;
			label1.setText("+");
		}
		if(gettext.equals("-")){
			result = num1-num2;
			label1.setText("-");
		}
		if(gettext.equals("×")){
			result = num1*num2;
			label1.setText("×");
		}
		if(gettext.equals("÷")&&num2==0){
			JOptionPane.showMessageDialog(text2, "0으로 나눌 수 없습니다");
			return;
		}
		if(gettext.equals("÷")){
			result = num1/num2;
			label1.setText("÷");
		}
		String ans = String.valueOf(result);
		text3.setText(ans);
		text3.getText();
		label1.getText();
		if(gettext.equals("C")){
			text1.setText("");
			text2.setText("");
			text3.setText("");
		}
		text1.getText();
		text2.getText();
		text3.getText();
	}
	
	boolean chkNum(String str) {
		boolean numcheck = false;
		try {
			Integer.parseInt(str);
			numcheck = true;
		} catch(Exception e){
		}
		return numcheck;
	}
}
