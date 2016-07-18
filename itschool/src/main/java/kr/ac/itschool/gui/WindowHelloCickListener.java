package kr.ac.itschool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowHelloCickListener implements ActionListener { /*인터페이스 액션리스너*/
	private JTextField text;	/*멤버영역에서 받기*/
	private JLabel label;	
	private JButton button1;
	private JButton button2;
	WindowHelloCickListener(JTextField text, JLabel label, JButton button1, JButton button2){	/*텍스트 라벨 버튼 1, 2 를 받아옴*/
		this.text = text;	/*텍스트 초기화*/
		this.label = label;	/*라벨 초기화*/
		this.button1 = button1;	/*버튼1 초기화*/
		this.button2 = button2;	/*버튼2 초기화*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String gettext = e.getActionCommand(); 
		if(gettext.equals("cancel")){
			text.setText("");
			label.setText("Hello");
		}
			
		label.setText(label.getText()+text.getText());
	}	
}