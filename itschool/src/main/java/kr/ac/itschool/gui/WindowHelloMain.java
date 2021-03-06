package kr.ac.itschool.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowHelloMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hellp Java Program");
		frame.setLocation(500,400);
		frame.setPreferredSize(new Dimension(300,120));
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField(20);
		JPanel panel = new JPanel();
		JButton button1 = new JButton("button1");
		JButton button2 = new JButton("cancel");
		panel.add(button1);
		panel.add(button2);
		JLabel label = new JLabel("hello");
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		contentPane.add(label, BorderLayout.EAST);
		ActionListener listener=
				new WindowHelloCickListener(text, label, button1, button2); 
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		frame.pack();
		frame.setVisible(true);		
	}
}
