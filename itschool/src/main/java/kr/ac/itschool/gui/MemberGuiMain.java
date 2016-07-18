package kr.ac.itschool.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemberGuiMain {
	public static void main(String[] args){
		JFrame frame = new JFrame("Hellp Java Program");
		frame.setLocation(500,400);
		frame.setPreferredSize(new Dimension(300,200));
		Container contentPane = frame.getContentPane();
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");
		JLabel label1 = new JLabel("label1");
		JLabel label2 = new JLabel("label2");
		JLabel label3 = new JLabel("label3");
		JLabel label4 = new JLabel("label4");
		JPanel panel1 = new JPanel();
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		JPanel panel2 = new JPanel();
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		contentPane.add(panel1, BorderLayout.CENTER);
		contentPane.add(panel2, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
