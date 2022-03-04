package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oracle.jdbc.*;

public class Login extends JFrame{

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JFrame frame;
	private JTextField username;
	private JPasswordField pass;
	private JComboBox utype;
	private String username11;
	private final JLabel backgroundimg = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Krishna");
		setIconImage(icon);
		setBackground(Color.RED);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(28, 162, 117, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(28, 215, 117, 24);
		getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Monospaced", Font.BOLD, 25));
		username.setBounds(155, 162, 177, 30);
		getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
					String sql = "select * from login where username=? and password=? and usertype =?";
		            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
		            pst.setString(1, username.getText());
		            pst.setString(2, pass.getText());
		            pst.setString(3, (String)utype.getSelectedItem());
		            rs = (OracleResultSet) pst.executeQuery();
		            if (rs.next()) {
		                JOptionPane.showMessageDialog(null,"Congrats!!!!!","Succesfully logged in",1);
		                
		                if( utype.getSelectedItem()=="Administrator")
		                {
		                Addinfoform f2 = new Addinfoform();
		                f2.setVisible(true);
		                dispose();
		                }
		                else
		                if( utype.getSelectedItem()=="Teacher")
		                {
		                Teacher1 f2 = new Teacher1();
		                f2.setVisible(true);
		                f2.setit(username.getText());
		                dispose();
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Please check your username or paswword");
		            }
		        } catch (Exception e) {
		            System.out.println("no");
		            JOptionPane.showMessageDialog(null, e);

		        }  
			}
						
/*							String n=JOptionPane.showInputDialog(null, "Enter Your Name...");
							String sql1="Update users SET password='"+n+"' where username='"+username.getText()+"'";
							s.executeUpdate(sql1);
							JOptionPane.showMessageDialog(null, "Login Successsful","Enter",1);*/
			});
		btnNewButton.setBounds(165, 272, 109, 37);
		getContentPane().add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass.setBounds(155, 216, 177, 30);
		getContentPane().add(pass);
		
		JLabel lblAttendanceManagementSystem = new JLabel("Attendance Management System");
		lblAttendanceManagementSystem.setForeground(Color.CYAN);
		lblAttendanceManagementSystem.setFont(new Font("Britannic Bold", Font.BOLD, 35));
		lblAttendanceManagementSystem.setBounds(10, 11, 577, 37);
		getContentPane().add(lblAttendanceManagementSystem);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				forgetPassword(arg0);
			}
		});
		btnForgotPassword.setFont(new Font("Sitka Banner", Font.ITALIC, 17));
		btnForgotPassword.setBounds(141, 329, 158, 23);
		getContentPane().add(btnForgotPassword);
		
		utype=new JComboBox();
		utype.setBounds(155, 103, 177, 30);
		utype.setModel(new DefaultComboBoxModel(new String[] {"Administrator","Teacher"}));
		getContentPane().add(utype);
		
		JLabel usertype = new JLabel("UserType:");
		usertype.setForeground(Color.YELLOW);
		usertype.setFont(new Font("Monospaced", Font.BOLD, 20));
		usertype.setBounds(28, 103, 117, 24);
		getContentPane().add(usertype);
		backgroundimg.setIcon(new ImageIcon(Login.class.getResource("/main/ATT.jpg")));
		backgroundimg.setBounds(-315, -116, 1082, 642);
		getContentPane().add(backgroundimg);
		setBounds(400, 100, 724, 454);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void forgetPassword(ActionEvent arg0) {
		
		try {
			String userna=JOptionPane.showInputDialog("Enter Username");
			String pass=JOptionPane.showInputDialog("Enter Password");
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            String sql="update login set password=? where username=?";
			pst =(OraclePreparedStatement) conn.prepareStatement(sql);
			pst.setString(2, userna);
			pst.setString(1, pass);
            int c=pst.executeUpdate();
            if(c>0) {
            JOptionPane.showMessageDialog(null,"Done");}
            else {
                JOptionPane.showMessageDialog(null,"Failed");
            }
//            if(rs.next()) {
//            	JOptionPane.showInputDialog("Enter New Password: ");
//            }else {
//            	JOptionPane.showMessageDialog(null,"Enter Correct Username");
//            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error Occurred");
		}
	}
	
	
}
