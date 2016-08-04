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
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Student implements ActionListener{
	AschoolDaoService service = new AschoolDaoService();
	JFrame frame;
	JFrame framestud = new JFrame("학생등록");
	
	public Student(JFrame frame) {
		this.frame = frame;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		framestud.setLocation(200,200);
		framestud.setPreferredSize(new Dimension(1150, 500));
		framestud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ActionListener homelistener = new HomeButton();
		
		Container contentPane = framestud.getContentPane();
		
		Font font = new Font("바탕체", Font.TYPE1_FONT, 20);
		Font font1 = new Font("고딕체", Font.TYPE1_FONT, 15);
		String colName[] = { "학번","학과","성명","지도교수" };
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
		GridLayout grid = new GridLayout(8,2) ;
		grid.setVgap(5);
		panel1.setLayout(grid);
		JLabel labelcode = new JLabel( "학 번" );
		labelcode.setHorizontalAlignment(JLabel.CENTER);
		JTextField code = new JTextField(9);
		JLabel labeldept = new JLabel( "학 과" );
		labeldept.setHorizontalAlignment(JLabel.CENTER);
		
		

		JComboBox dept = new JComboBox();
		ArrayList<DeptMember> deptlist = new ArrayList<DeptMember>();
		deptlist = service.comboDept();
		String[] deptlist1 = new String[deptlist.size()] ;
		for(int i =0 ; i < deptlist1.length ; i++ ){
			deptlist1[i] = deptlist.get(i).getCode()+" "+deptlist.get(i).getName() ;	
		}
		dept.setModel( new DefaultComboBoxModel(deptlist1));
		
		JLabel labelname = new JLabel( "이 름" );
		labelname.setHorizontalAlignment(JLabel.CENTER);
		JTextField name = new JTextField(20);
		JLabel labelidcard = new JLabel( "주민 번호" );
		labelidcard.setHorizontalAlignment(JLabel.CENTER);
		JTextField idcard = new JTextField(6);
		JLabel labelpostno = new JLabel( "우편 번호" );
		labelpostno.setHorizontalAlignment(JLabel.CENTER);
		JTextField postno = new JTextField(5);
		JLabel labeladdr1 = new JLabel( "주 소" );
		labeladdr1.setHorizontalAlignment(JLabel.CENTER);
		JTextField addr1 = new JTextField(30);
		JLabel labeladdr2 = new JLabel( " " );
		labeladdr2.setHorizontalAlignment(JLabel.CENTER);
		JTextField addr2 = new JTextField(30);
		JLabel labelprofessor = new JLabel( "지도 교수" );
		labelprofessor.setHorizontalAlignment(JLabel.CENTER);
		JComboBox professor = new JComboBox();
		ArrayList<ProfMember> proflist = new ArrayList<ProfMember>();
		proflist = service.comboProf();
		String[] proflist1 = new String[proflist.size()] ;
		for(int i =0 ; i< proflist1.length ; i++ ){
			proflist1[i] = proflist.get(i).getName()+ " " +proflist.get(i).getCode() ;	
		}
		professor.setModel( new DefaultComboBoxModel(proflist1));
		
		panel1.add(labelcode);panel1.add(code);
		panel1.add(labeldept);panel1.add(dept);
		panel1.add(labelname);panel1.add(name);
		panel1.add(labelidcard);panel1.add(idcard);
		panel1.add(labelpostno);panel1.add(postno);
		panel1.add(labeladdr1);panel1.add(addr1);
		panel1.add(labeladdr2);panel1.add(addr2);
		panel1.add(labelprofessor);panel1.add(professor);

		contentPane.add(panel1, BorderLayout.WEST);
		
		ActionListener listner = new studActionListener(model, table, find, code, dept, name, idcard, postno, addr1, addr2, professor);
		MouseListener mouse = new studActionListener(model, table, find, code, dept, name, idcard, postno, addr1, addr2, professor);
		table.addMouseListener(mouse);
		insert.addActionListener(listner);
		update.addActionListener(listner);
		delete.addActionListener(listner);
		search.addActionListener(listner);
		cancel.addActionListener(listner);
		
		
		framestud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		home.addActionListener(homelistener);
//		JPanel panel1 = new JPanel();
//		panel1.add(home);
//		contentPane.add(panel1, BorderLayout.CENTER);
		framestud.pack();
		framestud.setVisible(true);
		
	}
	
	public class HomeButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			framestud.setVisible(false);
			frame.setVisible(true);
			return;
		}
		
	}
	

}
