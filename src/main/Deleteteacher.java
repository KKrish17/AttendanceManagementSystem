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

public class Deleteteacher extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JComboBox teacherlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteteacher frame = new Deleteteacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillcombobox() {
		try
        {
        Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Connection Problem Occurred");
        }
        String sql = "select login_username from teacher";
        
        try{
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            rs = (OracleResultSet) pst.executeQuery();
            while(rs.next())
            {
                String sub = rs.getString("login_username");
                teacherlist.addItem(sub);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

	}
	/**
	 * Create the frame.
	 */
	public Deleteteacher() {
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				formWindowOpened(arg0);
			}
		});
		
		setResizable(false);
		setIconImage(icon);
		setTitle("Add Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblAddStudentInfo = new JLabel("DELETE TEACHER INFO");
		lblAddStudentInfo.setForeground(Color.CYAN);
		lblAddStudentInfo.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblAddStudentInfo.setBounds(200, 62, 629, 46);
		contentPane.add(lblAddStudentInfo);
		
		JLabel teacher_name1 = new JLabel("Teacher ID:");
		teacher_name1.setForeground(Color.YELLOW);
		teacher_name1.setFont(new Font("Monospaced", Font.BOLD, 24));
		teacher_name1.setBounds(221, 229, 154, 24);
		contentPane.add(teacher_name1);
		
		JButton add_teacher = new JButton("DELETE");
		add_teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteActionPerformed(arg0);
			}
		});
		add_teacher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add_teacher.setBounds(242, 383, 172, 54);
		contentPane.add(add_teacher);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelActionPerformed(arg0);
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cancel.setBounds(502, 383, 172, 54);
		contentPane.add(cancel);
		
		teacherlist = new JComboBox();
		teacherlist.setFont(new Font("Tahoma", Font.PLAIN, 17));
		teacherlist.setBounds(428, 224, 224, 39);
		contentPane.add(teacherlist);
		
		JLabel teacher_dept = new JLabel("");
		teacher_dept.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		teacher_dept.setBounds(-156, -174, 1159, 854);
		contentPane.add(teacher_dept);
	}
	
	protected void deleteActionPerformed(ActionEvent arg0) {
		try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
            String sql = "delete from teacher where login_username = ?";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String)teacherlist.getSelectedItem());
            
            pst.executeUpdate();
            
            int op = JOptionPane.showConfirmDialog(null,"Teacher deleted. More Teacher to delete?","Saved",0);
            if(op==0){
                Deleteteacher f4 = new Deleteteacher();
                f4.setVisible(true);
                dispose();
            }
            else
                if(op==0){
                Addinfoform f3 = new Addinfoform();
                f3.setVisible(true);
                dispose();
            }     
        } catch (Exception e) {
            System.out.println("Problem Occurred. Please Try Again");
            JOptionPane.showMessageDialog(null, e);

        }
		
	}

	private void cancelActionPerformed(ActionEvent arg0) {
		
		Addinfoform f2=new Addinfoform();
		f2.setVisible(true);
		dispose();
	}
	
	private void formWindowOpened(WindowEvent arg0) {
		fillcombobox();
		
	}
}
