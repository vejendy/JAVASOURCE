package kr.ac.itschool.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Professor implements ActionListener {
	JFrame frame;
	JFrame frameprof = new JFrame("교수등록");
	
	public Professor(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		frameprof.setLocation(300,300);
		frameprof.setPreferredSize(new Dimension(950, 200));
		frameprof.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ActionListener homelistener = new HomeButton();
		
		Container contentPane = frameprof.getContentPane();
		
		Font font = new Font("바탕체", Font.TYPE1_FONT, 20);
		Font font1 = new Font("고딕체", Font.TYPE1_FONT, 15);
		String colName[] = { "코드","성명" };
		DefaultTableModel model = new DefaultTableModel (colName,0);
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100,30));
		header.setBackground(Color.LIGHT_GRAY);
		table.setFont(font1);
		table.setRowHeight(20);
		contentPane.add(new JScrollPane(table), BorderLayout.EAST);
		JPanel panel = new JPanel();
		JButton insert = new JButton("입력");
		JButton update = new JButton("수정");
		JButton delete = new JButton("삭제");
		JTextField find = new JTextField(9);
		find.setFont(font);
		JButton search = new JButton("검색");
		JButton cancel = new JButton("취소");
		JButton home = new JButton("Home");
		panel.add(insert);
		panel.add(update);
		panel.add(delete);
		panel.add(find);
		panel.add(search);
		panel.add(cancel);
		panel.add(home);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JPanel panel1 = new JPanel();
		GridLayout grid = new GridLayout(2,2) ;
		grid.setVgap(5);
		panel1.setLayout(grid);
		JLabel labelcode = new JLabel( "코 드" );
		labelcode.setHorizontalAlignment(JLabel.CENTER);
		JTextField code = new JTextField(4);
		JLabel labelname = new JLabel( "성 명" );
		labelname.setHorizontalAlignment(JLabel.CENTER);
		JTextField name = new JTextField(20);
		
		panel1.add(labelcode);panel1.add(code);
		panel1.add(labelname);panel1.add(name);

		contentPane.add(panel1, BorderLayout.WEST);
		
		ActionListener listner = new profActionListener(model, table, code, name, find);
		MouseListener mouse = new profActionListener(model, table, code, name, find);
		table.addMouseListener(mouse);
		insert.addActionListener(listner);
		update.addActionListener(listner);
		delete.addActionListener(listner);
		search.addActionListener(listner);
		cancel.addActionListener(listner);
		
		
		frameprof.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		home.addActionListener(homelistener);
//		JPanel panel1 = new JPanel();
//		panel1.add(home);
//		contentPane.add(panel1, BorderLayout.CENTER);
		frameprof.pack();
		frameprof.setVisible(true);

	}
	public class HomeButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frameprof.setVisible(false);
			frame.setVisible(true);
			return;
		}
		
	}

}
