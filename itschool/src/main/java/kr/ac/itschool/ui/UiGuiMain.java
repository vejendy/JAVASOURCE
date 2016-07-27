package kr.ac.itschool.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

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

public class UiGuiMain {

	public static void main(String[] args){
		JFrame frame = new JFrame("거래처 관리 프로그램");
		frame.setPreferredSize(new Dimension(1000,500));
		frame.setLocation(300,50);
		Container contentPane = frame.getContentPane();
		Font font = new Font("바탕체", Font.TYPE1_FONT, 20);
		Font font1 = new Font("고딕체", Font.TYPE1_FONT, 15);
		String colName[] = { " CODE ","상호","사업자번호","전화번호" };
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
		panel.add(insert);
		panel.add(update);
		panel.add(delete);
		panel.add(find);
		panel.add(search);
		panel.add(cancel);
		contentPane.add(panel, BorderLayout.SOUTH);
		JPanel panel1 = new JPanel();
		GridLayout grid = new GridLayout(12,2) ;
		grid.setVgap(1);
		panel1.setLayout(grid);
		JLabel labelcode = new JLabel( "CODE" );
		labelcode.setHorizontalAlignment(JLabel.CENTER);
		JTextField code = new JTextField(10);
		JButton check = new JButton("중복검사");
		JPanel codepanel = new JPanel();
		codepanel.add(code);
		codepanel.add(check);
		
		JLabel labelname = new JLabel( "상호" );
		labelname.setHorizontalAlignment(JLabel.CENTER);
		JTextField name = new JTextField(10);
		
		JLabel labellicence = new JLabel( "사업자 번호" );
		labellicence.setHorizontalAlignment(JLabel.CENTER);
		JPanel licencepanel = new JPanel();
		JTextField licence1 = new JTextField(3);
		JLabel labellic1 = new JLabel( " - " );
		JTextField licence2 = new JTextField(2);
		JLabel labellic2 = new JLabel( " - " );
		JTextField licence3 = new JTextField(5);
		licencepanel.add(licence1);
		licencepanel.add(labellic1);
		licencepanel.add(licence2);
		licencepanel.add(labellic2);
		licencepanel.add(licence3);
		
		JLabel labelchief = new JLabel( "대표자" );
		labelchief.setHorizontalAlignment(JLabel.CENTER);
		JTextField chief = new JTextField(10);
		
		JLabel labelpost = new JLabel("우편번호");
		labelpost.setHorizontalAlignment(JLabel.CENTER);
		JTextField post = new JTextField(6);
		
		JLabel labeladd1 = new JLabel("주소");
		labeladd1.setHorizontalAlignment(JLabel.CENTER);
		JTextField add1 = new JTextField(20);
		JLabel labeladd2 = new JLabel(" ");
		labeladd2.setHorizontalAlignment(JLabel.CENTER);
		JTextField add2 = new JTextField(20);
		
		JLabel labelbusiness = new JLabel("업태");
		labelbusiness.setHorizontalAlignment(JLabel.CENTER);
		JTextField business = new JTextField(10);
		
		JLabel labeltype = new JLabel("종목");
		labeltype.setHorizontalAlignment(JLabel.CENTER);
		JTextField type = new JTextField(10);
		
		JLabel labelmanager = new JLabel("담당자");
		labelmanager.setHorizontalAlignment(JLabel.CENTER);
		JTextField manager = new JTextField(10);
		
//		JComboBox combo = new JComboBox();
//		String comarr[] = {"010","011","016","017","019"};
//		combo.setModel( new DefaultComboBoxModel(comarr));
//		JPanel = new JPanel();
//		panel.add(combo);
//		contentPane.add(panel, BorderLayout.CENTER);
		
		
		JLabel labelphone = new JLabel( "전화번호" );
		labelphone.setHorizontalAlignment(JLabel.CENTER);
		JPanel phonepanel = new JPanel();
		JComboBox phone1 = new JComboBox();
		String comarr[] = {"010","011","016","017","019"};
		phone1.setModel( new DefaultComboBoxModel(comarr));
		JLabel label1 = new JLabel( " - " );
		JTextField phone2 = new JTextField(4);
		JLabel label2 = new JLabel( " - " );
		JTextField phone3 = new JTextField(4);
		phonepanel.add(phone1);
		phonepanel.add(label1);
		phonepanel.add(phone2);
		phonepanel.add(label2);
		phonepanel.add(phone3);
		
		panel1.add(labelcode);
		panel1.add(codepanel);
		panel1.add(labelname);
		panel1.add(name);
		panel1.add(labellicence);
		panel1.add(licencepanel);
		panel1.add(labelchief);
		panel1.add(chief);
		panel1.add(labelpost);
		panel1.add(post);
		panel1.add(labeladd1);
		panel1.add(add1);
		panel1.add(labeladd2);
		panel1.add(add2);
		panel1.add(labelbusiness);
		panel1.add(business);
		panel1.add(labeltype);
		panel1.add(type);
		panel1.add(labelmanager);
		panel1.add(manager);
		panel1.add(labelphone);
		panel1.add(phonepanel);
		
		ActionListener listener = new UiGuiActionListener( model, table,find ,code, name, licence1, licence2, licence3, chief, post, add1, add2, business, type,
				manager, phone1, phone2, phone3 );
		MouseListener mouse = new UiGuiActionListener( model, table,find ,code, name, licence1, licence2, licence3, chief, post, add1, add2, business, type,
				manager, phone1, phone2, phone3 );
		table.addMouseListener(mouse);
		insert.addActionListener(listener);
		update.addActionListener(listener);
		delete.addActionListener(listener);
		search.addActionListener(listener);
		check.addActionListener(listener);
		cancel.addActionListener(listener);
		
		contentPane.add(panel1, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

