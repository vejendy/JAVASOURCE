package kr.ac.itschool.practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CalculatorDemoMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hellp Java Program");
		frame.setLocation(300,200);
		frame.setPreferredSize(new Dimension(700,120));
		Container contentPane = frame.getContentPane();
		JPanel panel1 = new JPanel();
		JTextField text1 = new JTextField(10);
		JLabel label1 = new JLabel("??");
		JTextField text2 = new JTextField(10);
		JLabel label2 = new JLabel("=");
		JTextField text3 = new JTextField(10);
		panel1.add(text1);
		panel1.add(label1);
		panel1.add(text2);
		panel1.add(label2);
		panel1.add(text3);
		JPanel panel2 = new JPanel();
		JButton button1 = new JButton("+");
		JButton button2 = new JButton("-");
		JButton button3 = new JButton("×");
		JButton button4 = new JButton("÷");
		JButton button5 = new JButton("C");
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		contentPane.add(panel1, BorderLayout.CENTER);
		contentPane.add(panel2, BorderLayout.SOUTH);
		ActionListener listener=
				new CalculatorClickListener(text1, text2,text3,label1); 
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
		button4.addActionListener(listener);
		button5.addActionListener(listener);
		frame.pack();
		frame.setVisible(true);

	}

}
