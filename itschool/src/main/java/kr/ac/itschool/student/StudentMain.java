package kr.ac.itschool.student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudentMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("등록선택");
		frame.setPreferredSize(new Dimension(500,100));
		frame.setLocation(500	,300);
		Container contentPane = frame.getContentPane();
		JButton btndept = new JButton("학과등록");
		JButton btnprof = new JButton("교수등록");
		JButton btnstud = new JButton("학생등록");
		JPanel panel = new JPanel();
		panel.add(btndept);
		panel.add(btnprof);
		panel.add(btnstud);
		contentPane.add(panel, BorderLayout.CENTER);
		
		ActionListener listener = new Student( frame );
		btnstud.addActionListener(listener);
		ActionListener listener1 = new Professor( frame );
		btnprof.addActionListener(listener1);
		ActionListener listener2 = new Dept( frame );
		btndept.addActionListener(listener2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}