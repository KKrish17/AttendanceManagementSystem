package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import java.awt.event.ActionEvent;

public class Teacher1 extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
    String iddd=null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JLabel jLabel1;
	private JPanel contentPane;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher1 frame = new Teacher1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void fillcombobox(){
        try
        {
        Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Connection Problem occurred");
        }
        String sql = "select * from teaches where teacher_teacherid = ?";
        
        try{
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, iddd);
            rs = (OracleResultSet) pst.executeQuery();
            while(rs.next())
            {
                String sub = rs.getString("subject_idsubject");
                comboBox.addItem(sub);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
	
	public void Return(String a) {
		
	}
	/**
	 * Create the frame.
	 */
	public Teacher1() {
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				formWindowOpened(arg0);
			}
		});
		
		setResizable(false);
		setIconImage(icon);
		setTitle("Welcome Teacher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		jLabel1 = new JLabel("");
		jLabel1.setForeground(Color.CYAN);
		jLabel1.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		jLabel1.setBounds(225, 60, 629, 46);
		contentPane.add(jLabel1);
		
		JLabel teacher_name1 = new JLabel("Choose Subject:");
		teacher_name1.setForeground(Color.YELLOW);
		teacher_name1.setFont(new Font("Monospaced", Font.BOLD, 24));
		teacher_name1.setBounds(200, 224, 214, 36);
		contentPane.add(teacher_name1);
		
		JButton take_attendence = new JButton("Take Attendence");
		take_attendence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				takeAttendenceActionPerformed(arg0);
			}
		});
		take_attendence.setFont(new Font("Tahoma", Font.PLAIN, 25));
		take_attendence.setBounds(176, 383, 238, 54);
		contentPane.add(take_attendence);
		
		JButton generate_report = new JButton("Generate Report");
		generate_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerateReportActionPerformed(arg0);
			}
		});
		generate_report.setFont(new Font("Tahoma", Font.PLAIN, 25));
		generate_report.setBounds(502, 383, 224, 54);
		contentPane.add(generate_report);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setBounds(428, 224, 224, 39);
		contentPane.add(comboBox);
		
		JLabel teacher_dept = new JLabel("");
		teacher_dept.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		teacher_dept.setBounds(-156, -174, 1159, 854);
		contentPane.add(teacher_dept);
	}
	
	 private void GenerateReportActionPerformed(ActionEvent arg0) {
		Report f7=new Report();
		f7.setVisible(true);
		f7.UpdateJTable((String)comboBox.getSelectedItem());
		dispose();
	}


	private void takeAttendenceActionPerformed(ActionEvent arg0) {
		 Takeattendance f2 = new Takeattendance();
         f2.setVisible(true);
         f2.UpdateJTable((String)comboBox.getSelectedItem());
         dispose();
		
	}


	private void formWindowOpened(WindowEvent arg0) {
		fillcombobox();
		
	}


	void setit(String text) {
	        
	        try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	            String sql = "select * from teacher where Login_username=?";
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1, text);
	            rs = (OracleResultSet) pst.executeQuery();

	            if (rs.next()) {
	                 String name = rs.getString("teachername");
	                
	                jLabel1.setText("Welcome  "+name);
	                iddd = rs.getString("teacherid");
	                System.out.println(""+iddd);
	              
	            } else {
	                JOptionPane.showMessageDialog(null, "Problem Occurred. Please Try Again");

	            }
	        } catch (Exception e) {
	            System.out.println("Please Try Again");
	            JOptionPane.showMessageDialog(null, e);

	        }  
	    }
}
