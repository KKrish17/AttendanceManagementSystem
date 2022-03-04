package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addinfoform extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addinfoform frame = new Addinfoform();
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
	public Addinfoform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setIconImage(icon);
		setTitle("Welcome Admin");
		setResizable(false);
		
		JButton add_student = new JButton("Add Student");
		add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add_studentActionPerformed(arg0);
			}
		});
		add_student.setFont(new Font("Clarendon Hv BT", Font.PLAIN, 23));
		add_student.setBounds(71, 132, 236, 97);
		contentPane.add(add_student);
		
		JButton add_teacher = new JButton("Add Teacher");
		add_teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add_teacherActionPerformed(arg0);
			}
		});
		add_teacher.setFont(new Font("Clarendon Hv BT", Font.PLAIN, 23));
		add_teacher.setBounds(498, 132, 236, 97);
		contentPane.add(add_teacher);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDeleteStudentActionPerformed(arg0);
			}
		});
		btnDeleteStudent.setFont(new Font("Clarendon Hv BT", Font.PLAIN, 23));
		btnDeleteStudent.setBounds(71, 377, 236, 97);
		contentPane.add(btnDeleteStudent);
		
		JButton btnDeleteTeacher = new JButton("Delete Teacher");
		btnDeleteTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDeleteTeacherActionPerformed(arg0);
			}
		});
		btnDeleteTeacher.setFont(new Font("Clarendon Hv BT", Font.PLAIN, 23));
		btnDeleteTeacher.setBounds(498, 377, 236, 97);
		contentPane.add(btnDeleteTeacher);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME  ADMIN");
		lblNewLabel_1.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(198, 41, 423, 46);
		contentPane.add(lblNewLabel_1);
		
		JButton logout = new JButton("Log Out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logoutButtonActionPerformed(arg0);
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logout.setBounds(351, 513, 107, 34);
		contentPane.add(logout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		lblNewLabel.setBounds(-156, -174, 972, 762);
		contentPane.add(lblNewLabel);
	}

	private void logoutButtonActionPerformed(ActionEvent arg0) {
		int op = JOptionPane.showConfirmDialog(null,"Do you really want to logout?","confirm",0);
        if(op == 0)
        {
        dispose();
        Login login1=new Login();
        login1.setVisible(true);
        }
        else{
           // dispose();
        }
		
	}

	private void btnDeleteTeacherActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Deleteteacher f5=new Deleteteacher();
		f5.setVisible(true);
		dispose();
	}

	private void btnDeleteStudentActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Deletestudent f4=new Deletestudent();
		f4.setVisible(true);
		dispose();
	}

	private void add_teacherActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Addteacher f3=new Addteacher();
		f3.setVisible(true);
		dispose();
	}

	private void add_studentActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 Addstudent f3=new Addstudent();
	        f3.setVisible(true);
	        dispose();
	}
}
