package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Takeattendance extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OraclePreparedStatement pst1=null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JTable table;
	private JTableHeader header;
	private JTextField textField;
	private JLabel label;
	private JLabel label1;
	private JTextArea textArea;
	private JTextField textField_1;
	private JLabel lblStudentAttendence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Takeattendance frame = new Takeattendance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void UpdateJTable(String a){

		 try {
		    Class.forName("oracle.jdbc.OracleDriver");
		    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
		    
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e);
		        } 
		 label.setText(a);
		 label.setVisible(true);
		 label1.setVisible(true);
		    try{
		String sql = "select roll, studentname from student where subject_subjectid = ?";
		pst  = (OraclePreparedStatement) conn.prepareStatement(sql);
		pst.setString(1,a);
		rs = (OracleResultSet) pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
		    JOptionPane.showMessageDialog(null, e);
		}
		    
		    java.util.Date date=Calendar.getInstance().getTime();
       	 DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
       	String s=dateFormat.format(date);
       	label1.setText(s);
		    }
	/**
	 * Create the frame.
	 */
	public Takeattendance() {
		
		setResizable(false);
		setIconImage(icon);
		setTitle("Attendance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {
                    "Student Roll", "Student name"
                }
            ));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(205, 96, 445, 405);
		contentPane.add(table);
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		tableMouseClickListener(arg0);
        	}
		});
        header=table.getTableHeader();
        header.setBounds(205,70,445,25);
        contentPane.add(header);
		
		JButton present_name = new JButton("Present");
		present_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prsentButtonActionPerformed(arg0);
			}
		});
		present_name.setFont(new Font("Tahoma", Font.PLAIN, 22));
		present_name.setBounds(259, 553, 141, 39);
		contentPane.add(present_name);
		
		JButton btnAbsent = new JButton("Absent");
		btnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbsentButtonActonPerformed(arg0);
			}
		});
		btnAbsent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAbsent.setBounds(471, 553, 141, 39);
		contentPane.add(btnAbsent);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BackButtonActionPerformed(arg0);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnClose.setBounds(361, 637, 141, 39);
		contentPane.add(btnClose);
		
		textArea = new JTextArea();
		textArea.setBounds(22, 258, 150, 243);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(352, 509, 150, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label1 = new JLabel("");
		label1.setForeground(Color.RED);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label1.setBounds(696, 77, 108, 29);
		contentPane.add(label1);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(696, 117, 108, 29);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(512, 509, 150, 29);
		contentPane.add(textField_1);
		
		lblStudentAttendence = new JLabel("STUDENT  ATTENDENCE");
		lblStudentAttendence.setForeground(Color.CYAN);
		lblStudentAttendence.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblStudentAttendence.setBounds(163, 23, 629, 46);
		contentPane.add(lblStudentAttendence);
		
		JLabel absent_name = new JLabel("");
		absent_name.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		absent_name.setBounds(-158, -195, 972, 931);
		contentPane.add(absent_name);
	}

	private void BackButtonActionPerformed(ActionEvent arg0) {
		dispose();
		Login klogin=new Login();
		klogin.setVisible(true);
	}

	private void prsentButtonActionPerformed(ActionEvent arg0) {
		
		 try {
        	 java.util.Date date=Calendar.getInstance().getTime();
        	 DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
            String sql = "insert into attendence (date1, status, student_roll, student_subject_subjectid) values(?,?,?,?)";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            String s=dateFormat.format(date);
            pst.setString(1,s);
            pst.setString(2, "Present");
            pst.setString(3,textField.getText().toString());
            pst.setString(4,label.getText());
           // System.out.println(jLabel1.getText());
            
            pst.execute();
            
             JOptionPane.showMessageDialog(null, "Present");
             String sql1 = "delete from attendence where rowid not in (select min(rowid) from attendence group by date1,status,student_roll,student_subject_subjectid)";
             pst1=(OraclePreparedStatement) conn.prepareStatement(sql1);
             pst1.execute(); 
             textArea.append(""+textField_1.getText()+ " -Present\n");
          
      } catch (Exception e ) {
          System.out.println("Please Try Again");
          JOptionPane.showMessageDialog(null, e);

      }
	}

	
	private void AbsentButtonActonPerformed(ActionEvent arg0) {
		try {
			java.util.Date date=Calendar.getInstance().getTime();
	       	 DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
            String sql = "insert into attendence values(?,?,?,?)";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            String s=dateFormat.format(date);
            pst.setString(1,s);
            pst.setString(2,"Absent");
            pst.setString(3,textField.getText());
            pst.setString(4,label.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Absent");  
            String sql1 = "delete from attendence where rowid not in (select min(rowid) from attendence group by date1,status,student_roll,student_subject_subjectid)";
            pst1=(OraclePreparedStatement) conn.prepareStatement(sql1);
            pst1.execute(); 
            textArea.append(""+textField_1.getText()+ " -Absent\n");
            
        } catch (Exception e ) {
            System.out.println("Please Try Again");
            JOptionPane.showMessageDialog(null, e);

        }
		
	}

	
	protected void tableMouseClickListener(MouseEvent arg0) {
		 int row = table.getSelectedRow();
	        textField.setText(table.getModel().getValueAt(row, 0).toString());
	        textField_1.setText(table.getModel().getValueAt(row, 1).toString());
		
	}
}

