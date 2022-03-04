package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JFrame {

	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTable table;
	private JScrollPane jsp;
	private JTextField textField_6;
	
	private static Vector col,data,row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
						Welcome frame = new Welcome();
						frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String s;
		
		
		try {
			String sf=new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH).format(new Date());
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 70, 1200, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(icon);
		setTitle("Welcome to Attendance Management System");
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JLabel lblSubjectCode = new JLabel("Subject Code:");
		lblSubjectCode.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblSubjectCode.setForeground(Color.WHITE);
		lblSubjectCode.setBounds(366, 33, 171, 30);
		contentPane.add(lblSubjectCode);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(377, 74, 122, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSubjectName = new JLabel("Subject Name:");
		lblSubjectName.setForeground(Color.WHITE);
		lblSubjectName.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblSubjectName.setBounds(609, 33, 171, 30);
		contentPane.add(lblSubjectName);
		
		JLabel lblNoOfStudents = new JLabel("No. of Students Present:");
		lblNoOfStudents.setForeground(Color.WHITE);
		lblNoOfStudents.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblNoOfStudents.setBounds(893, 33, 255, 30);
		contentPane.add(lblNoOfStudents);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(509, 74, 373, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(942, 66, 122, 30);
		contentPane.add(textField_2);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setForeground(Color.WHITE);
		lblStartTime.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblStartTime.setBounds(234, 128, 122, 30);
		contentPane.add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setForeground(Color.WHITE);
		lblEndTime.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblEndTime.setBounds(234, 169, 122, 30);
		contentPane.add(lblEndTime);
		
		JLabel lblTeacherName = new JLabel("Teacher name:");
		lblTeacherName.setForeground(Color.WHITE);
		lblTeacherName.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblTeacherName.setBounds(651, 128, 171, 30);
		contentPane.add(lblTeacherName);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(576, 167, 306, 30);
		contentPane.add(textField_5);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblDepartment.setBounds(893, 107, 171, 30);
		contentPane.add(lblDepartment);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblSemester.setBounds(1055, 107, 105, 30);
		contentPane.add(lblSemester);
		
		String[] dept= {"CSE","ECE","ME","CE","EE"};
		String[] sem= {"1","2","3","4","5","6","7","8"};
		
		JComboBox comboBox = new JComboBox(dept);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		comboBox.setBounds(914, 140, 93, 30);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(sem);
		comboBox_1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(1055, 141, 93, 30);
		contentPane.add(comboBox_1);
		
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/attendance", "root", "");
		st=con.createStatement();
		s="Select * from attendance";
		rs=st.executeQuery(s);
		ResultSetMetaData rsmt=rs.getMetaData();
		int c=rsmt.getColumnCount();
		Vector col=new Vector(c);
		for(int i=1;i<=c;i++) {
			col.add(rsmt.getColumnName(i));
		}
		Vector data=new Vector();
		Vector row=new Vector();
		while(rs.next()) {
			row=new Vector(c);
			for(int i=1;i<=c;i++) {
				row.add(rs.getString(i));
				
			}
			data.add(row);
		}
		
		Date date=new Date();
		SpinnerDateModel sm=new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		SpinnerDateModel sm1=new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
				
		JSpinner spinner = new javax.swing.JSpinner(sm);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(366, 125, 171, 30);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new javax.swing.JSpinner(sm1);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_1.setBounds(366, 169, 171, 30);
		contentPane.add(spinner_1);
		
		JSpinner.DateEditor de=new JSpinner.DateEditor(spinner,"HH:mm:ss");
		spinner.setEditor(de);
		JSpinner.DateEditor de1=new JSpinner.DateEditor(spinner_1,"HH:mm:ss");
		spinner_1.setEditor(de1);
		
		table = new JTable(data,col);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectedRowIndex=table.getSelectedRow();
							
				textField.setText(model.getValueAt(selectedRowIndex,2).toString());
				textField_1.setText(model.getValueAt(selectedRowIndex,3).toString());
				textField_2.setText(model.getValueAt(selectedRowIndex,9).toString());
				textField_5.setText(model.getValueAt(selectedRowIndex,6).toString());
				textField_6.setText(model.getValueAt(selectedRowIndex,1).toString());
				comboBox.setSelectedItem(model.getValueAt(selectedRowIndex,4).toString());
				comboBox_1.setSelectedItem(model.getValueAt(selectedRowIndex,5).toString());
				spinner.setValue(model.getValueAt(selectedRowIndex,7).toString());
//				spinner.setText(model.getValueAt(selectedRowIndex, 3).toString());
//				spinner_1.setText(model.getValueAt(selectedRowIndex, 3).toString());
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(22);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"ID", "Date", "Subject Code", "Subject Name", "Department", "Semester", "Professor Name", "Start Time", "End Time", "Student Present"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Integer.class, Object.class, Object.class, Object.class, Object.class, Integer.class, Object.class, Object.class, Object.class, Integer.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent arg0) {
//				JOptionPane.showMessageDialog(null, "Column Selected");
//			}
//		});
		
		JTableHeader header=table.getTableHeader();
		table.getColumnModel().getColumn(0).setPreferredWidth(6);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(2).setPreferredWidth(32);
		table.getColumnModel().getColumn(3).setPreferredWidth(285);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		table.getColumnModel().getColumn(9).setPreferredWidth(5);
		
		table.setBounds(10, 365, 1174,166);
		header.setBounds(10,344,1174,21);
		contentPane.add(table);
		contentPane.add(header);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student student=new Student();
				student.setVisible(true);
			}
		});
		btnAdd.setBounds(234, 250, 89, 23);
		contentPane.add(btnAdd);
		
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Enter Subject Code");
				else
					JOptionPane.showMessageDialog(null, "Data Insert Successful");
			}
		});
		show.setBounds(355, 250, 89, 23);
		contentPane.add(show);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblDate.setBounds(248, 33, 74, 30);
		contentPane.add(lblDate);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setText(sf);
		textField_6.setEditable(false);
		textField_6.setBounds(215, 74, 152, 30);
		contentPane.add(textField_6);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/main/back.jpeg")));
		lblNewLabel.setBounds(-31, -209, 1708, 1088);
		contentPane.add(lblNewLabel);
		
		
	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
	}
}
