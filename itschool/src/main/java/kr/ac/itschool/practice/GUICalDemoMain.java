package kr.ac.itschool.practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUICalDemoMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setLocation(300,200);
		frame.setPreferredSize(new Dimension(400,400));
		Container contentPane = frame.getContentPane();
		JPanel panel1 = new JPanel();
		GridLayout gridlayout = new GridLayout(4,4);
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton button0 = new JButton("0");
		JButton buttonplus = new JButton("+");
		JButton buttonminus = new JButton("-");
		JButton buttontime = new JButton("*");
		JButton buttondiv = new JButton("/");
		JButton buttoneq = new JButton("=");
		JButton buttoncl = new JButton("C");
		panel1.setLayout(gridlayout);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(buttonplus);
		panel1.add(button4);
		panel1.add(button5);
		panel1.add(button6);
		panel1.add(buttonminus);
		panel1.add(button7);
		panel1.add(button8);
		panel1.add(button9);
		panel1.add(buttontime);
		panel1.add(buttoncl);
		panel1.add(button0);
		panel1.add(buttoneq);
		panel1.add(buttondiv);
		JPanel panel2 = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		JTextField text1 = new JTextField(30);
		JTextField text2 = new JTextField(30);
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		panel2.setLayout(boxlayout);
		text1.setHorizontalAlignment(SwingConstants.RIGHT);
		text2.setHorizontalAlignment(SwingConstants.RIGHT);
		text1.setFont(font);
		text2.setFont(font);
		text1.setEditable(false);
		text2.setEditable(false);
		panel2.add(text1);
		panel2.add(text2);
		
		contentPane.add(panel1, BorderLayout.CENTER);
		contentPane.add(panel2, BorderLayout.NORTH);
		ActionListener listener=
				new GUICalClickListener(text1,text2); 
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
		button4.addActionListener(listener);
		button5.addActionListener(listener);
		button6.addActionListener(listener);
		button7.addActionListener(listener);
		button8.addActionListener(listener);
		button9.addActionListener(listener);
		button0.addActionListener(listener);
		buttonplus.addActionListener(listener);
		buttonminus.addActionListener(listener);
		buttontime.addActionListener(listener);
		buttondiv.addActionListener(listener);
		buttoneq.addActionListener(listener);
		buttoncl.addActionListener(listener);
		frame.pack();
		frame.setVisible(true);

	
	}

}
