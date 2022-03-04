package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class Deletestudent extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OraclePreparedStatement pst1=null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletestudent frame = new Deletestudent();
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
        String sql = "select roll from studentroll";
        
        try{
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            rs = (OracleResultSet) pst.executeQuery();
            while(rs.next())
            {
                String sub = rs.getString("roll");
                comboBox.addItem(sub);
                int k=comboBox.getItemCount();
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

	}
	
	/**
	 * Create the frame.
	 */
	public Deletestudent() {
		
		
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
		
		JLabel lblAddStudentInfo = new JLabel("DELETE STUDENT INFO");
		lblAddStudentInfo.setForeground(Color.CYAN);
		lblAddStudentInfo.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblAddStudentInfo.setBounds(200, 62, 629, 46);
		contentPane.add(lblAddStudentInfo);
		
		JLabel teacher_name1 = new JLabel("Roll No:");
		teacher_name1.setForeground(Color.YELLOW);
		teacher_name1.setFont(new Font("Monospaced", Font.BOLD, 26));
		teacher_name1.setBounds(218, 224, 162, 36);
		contentPane.add(teacher_name1);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteActionPerformed(arg0);
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 25));
		delete.setBounds(242, 383, 172, 54);
		contentPane.add(delete);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelActionPerformed(arg0);
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cancel.setBounds(502, 383, 172, 54);
		contentPane.add(cancel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox.setBounds(428, 224, 224, 39);
		contentPane.add(comboBox);
		
		JLabel teacher_dept = new JLabel("");
		teacher_dept.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		teacher_dept.setBounds(-156, -174, 1159, 854);
		contentPane.add(teacher_dept);
	}

	private void cancelActionPerformed(ActionEvent arg0) {
		
		Addinfoform f2=new Addinfoform();
		f2.setVisible(true);
		dispose();
	}

	private void deleteActionPerformed(ActionEvent arg0) {
		try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
            String sql = "delete from student where roll = ?";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String)comboBox.getSelectedItem());
            
            pst.executeUpdate();
            
            
            String sql1 = "delete from studentroll where roll = ?";
            pst1 = (OraclePreparedStatement) conn.prepareStatement(sql1);
            pst1.setString(1, (String)comboBox.getSelectedItem());
            
            pst1.executeUpdate();
            
            int op = JOptionPane.showConfirmDialog(null,"Student deleted. More student to delete?","Saved",0);
            if(op==0){
                Deletestudent f3 = new Deletestudent();
                f3.setVisible(true);
                dispose();
            }
            else
                if(op==0){
                Addinfoform f3 = new Addinfoform();
                f3.setVisible(true);
                dispose();
            }     
        } catch (Exception e) {
            System.out.println("Problem Occur. Please Try Again");
            JOptionPane.showMessageDialog(null, e);

        }
		
	}

	private void formWindowOpened(WindowEvent arg0) {
		fillcombobox();
		
	}
}
