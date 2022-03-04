package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Addteacher extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JTextField teacher_id;
	private JTextField teacher_name;
	private JTextField teachar_department;
	private JTextField teacher_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addteacher frame = new Addteacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addteacher() {
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				formWindowOpened(arg0);
			}
		});
		
		setResizable(false);
		setIconImage(icon);
		setTitle("Add Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblAddStudentInfo = new JLabel("ADD TEACHER INFO");
		lblAddStudentInfo.setForeground(Color.CYAN);
		lblAddStudentInfo.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblAddStudentInfo.setBounds(247, 63, 629, 46);
		contentPane.add(lblAddStudentInfo);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(Color.YELLOW);
		id.setFont(new Font("Monospaced", Font.BOLD, 24));
		id.setBounds(218, 177, 117, 24);
		contentPane.add(id);
		
		JLabel teacher_name1 = new JLabel("Name:");
		teacher_name1.setForeground(Color.YELLOW);
		teacher_name1.setFont(new Font("Monospaced", Font.BOLD, 24));
		teacher_name1.setBounds(218, 236, 117, 24);
		contentPane.add(teacher_name1);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.YELLOW);
		lblDepartment.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblDepartment.setBounds(218, 302, 172, 24);
		contentPane.add(lblDepartment);
		
		teacher_id = new JTextField();
		teacher_id.setEditable(false);
		teacher_id.setFont(new Font("Monospaced", Font.BOLD, 25));
		teacher_id.setColumns(10);
		teacher_id.setBounds(422, 177, 277, 30);
		contentPane.add(teacher_id);
		
		teacher_name = new JTextField();
		teacher_name.setFont(new Font("Monospaced", Font.BOLD, 25));
		teacher_name.setColumns(10);
		teacher_name.setBounds(422, 236, 277, 30);
		contentPane.add(teacher_name);
		
		teachar_department = new JTextField();
		teachar_department.setFont(new Font("Monospaced", Font.BOLD, 25));
		teachar_department.setColumns(10);
		teachar_department.setBounds(422, 302, 277, 30);
		contentPane.add(teachar_department);
		
		JLabel lblSemester = new JLabel("Password:");
		lblSemester.setForeground(Color.YELLOW);
		lblSemester.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblSemester.setBounds(218, 360, 172, 24);
		contentPane.add(lblSemester);
		
		teacher_pass = new JTextField();
		teacher_pass.setFont(new Font("Monospaced", Font.BOLD, 25));
		teacher_pass.setColumns(10);
		teacher_pass.setBounds(422, 357, 277, 30);
		contentPane.add(teacher_pass);
		
		JButton add_teacher = new JButton("ADD");
		add_teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addTeacherActionPerformed(arg0);
			}
		});
		add_teacher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add_teacher.setBounds(232, 482, 172, 54);
		contentPane.add(add_teacher);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelActionPerformed(arg0);
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cancel.setBounds(494, 482, 172, 54);
		contentPane.add(cancel);
		
		JLabel teacher_dept = new JLabel("");
		teacher_dept.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		teacher_dept.setBounds(-156, -174, 1159, 854);
		contentPane.add(teacher_dept);
	}
	
		private void formWindowOpened(WindowEvent arg0) {
	        try
	        {
	        Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	        }
	        catch(Exception e)
	        {
	            JOptionPane.showMessageDialog(null,"Connection Problem Occurred");
	        }
	        String sql = "select max(teacherid)+1 from teacher";
	        
	        try{
	            
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            rs = (OracleResultSet) pst.executeQuery();
	            while(rs.next())
	            {
	                String sub = rs.getString(1);
	                teacher_id.setText(sub);
	            }
	        }
	        catch(Exception e){
	            JOptionPane.showMessageDialog(null, e+" Problem");
	        }

		
	}

		private void addTeacherActionPerformed(ActionEvent arg0) {
	         try {
	             Class.forName("oracle.jdbc.OracleDriver");
	             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	             String sql = "insert into login (username, password, usertype) values(?,?,?)";
	             pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	             String id = teacher_name.getText();
	             String pass = teacher_pass.getText();
	             String type = "Teacher";
	             pst.setString(1,id);
	             pst.setString(2, pass);
	             pst.setString(3,"Teacher");
	             //System.out.println(""+id + "  " + pass);
	             pst.execute();
	             JOptionPane.showMessageDialog(null, "Saved in login");
	    
	         } catch (Exception e ) {
	             System.out.println("no");
	             JOptionPane.showMessageDialog(null, e);

	         }
	          
	          try {
	             Class.forName("oracle.jdbc.OracleDriver");
	             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	             String sql = "insert into teacher (teacherid, teachername, Login_username) values(?,?,?)";
	             pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	             String id = teacher_id.getText();
	             String name = teacher_name.getText();
	             String user = teacher_name.getText();
	             pst.setString(1,id);
	             pst.setString(2, name);
	             pst.setString(3,user);
	             //System.out.println(""+id + "  " + pass);
	             pst.execute();
	             JOptionPane.showMessageDialog(null, "Saved in Teacher");
	    
	         } catch (Exception e ) {
	             System.out.println("Problem occurred");
	             JOptionPane.showMessageDialog(null, e);

	         }

		
	}

		private void cancelActionPerformed(ActionEvent arg0) {
				
				Addinfoform f2=new Addinfoform();
				f2.setVisible(true);
				dispose();
			}
}
