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
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

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

public class Addstudent extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OraclePreparedStatement pst1=null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JLabel subject1;
	private JLabel subject2;
	private JLabel subject3;
	private JLabel subject4;
	private JLabel subject5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addstudent frame = new Addstudent();
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
            JOptionPane.showMessageDialog(null,"Connection Problem Occurred");
        }
        String sql = "select * from subject";
        
        try{
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            rs = (OracleResultSet) pst.executeQuery();
            while(rs.next())
            {
                String sub = rs.getString("subjectname");
                comboBox.addItem(sub);
                comboBox_1.addItem(sub);
                comboBox_2.addItem(sub);
                comboBox_3.addItem(sub);
                comboBox_4.addItem(sub);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
	/**
	 * Create the frame.
	 */
	public Addstudent() {
		
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
		
		JLabel lblAddStudentInfo = new JLabel("ADD STUDENT INFO");
		lblAddStudentInfo.setForeground(Color.CYAN);
		lblAddStudentInfo.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblAddStudentInfo.setBounds(247, 63, 629, 46);
		contentPane.add(lblAddStudentInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblName.setBounds(218, 177, 117, 24);
		contentPane.add(lblName);
		
		JLabel lblRoll = new JLabel("Roll:");
		lblRoll.setForeground(Color.YELLOW);
		lblRoll.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblRoll.setBounds(218, 236, 117, 24);
		contentPane.add(lblRoll);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.YELLOW);
		lblDepartment.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblDepartment.setBounds(218, 302, 172, 24);
		contentPane.add(lblDepartment);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.BOLD, 25));
		textField.setColumns(10);
		textField.setBounds(422, 177, 277, 30);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(422, 236, 277, 30);
		contentPane.add(textField_1);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setForeground(Color.YELLOW);
		lblSemester.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblSemester.setBounds(218, 360, 172, 24);
		contentPane.add(lblSemester);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 451, 160, 30);
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				
				comboBoxPopupMenuWillBecomeInvisible(arg0);
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(200, 451, 160, 30);
		contentPane.add(comboBox_1);
		comboBox_1.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				
				comboBox1PopupMenuWillBecomeInvisible(arg0);
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(393, 451, 160, 30);
		contentPane.add(comboBox_2);
		comboBox_2.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				
				comboBox2PopupMenuWillBecomeInvisible(arg0);
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(585, 451, 160, 30);
		contentPane.add(comboBox_3);
		comboBox_3.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				
				comboBox3PopupMenuWillBecomeInvisible(arg0);
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(782, 451, 160, 30);
		contentPane.add(comboBox_4);
		comboBox_4.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				
				comboBox4PopupMenuWillBecomeInvisible(arg0);
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		subject1 = new JLabel("Subject 1:");
		subject1.setForeground(Color.YELLOW);
		subject1.setFont(new Font("Monospaced", Font.BOLD, 18));
		subject1.setBounds(27, 504, 117, 24);
		contentPane.add(subject1);
		
		subject2 = new JLabel("Subject 2:");
		subject2.setForeground(Color.YELLOW);
		subject2.setFont(new Font("Monospaced", Font.BOLD, 18));
		subject2.setBounds(218, 504, 117, 24);
		contentPane.add(subject2);
		
		subject3 = new JLabel("Subject 3:");
		subject3.setForeground(Color.YELLOW);
		subject3.setFont(new Font("Monospaced", Font.BOLD, 18));
		subject3.setBounds(416, 504, 117, 24);
		contentPane.add(subject3);
		
		subject4 = new JLabel("Subject 4:");
		subject4.setForeground(Color.YELLOW);
		subject4.setFont(new Font("Monospaced", Font.BOLD, 18));
		subject4.setBounds(606, 504, 117, 24);
		contentPane.add(subject4);
		
		subject5 = new JLabel("Subject 5:");
		subject5.setForeground(Color.YELLOW);
		subject5.setFont(new Font("Monospaced", Font.BOLD, 18));
		subject5.setBounds(802, 504, 117, 24);
		contentPane.add(subject5);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addButtonPerformed(arg0);
			}
		});
		add.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add.setBounds(238, 593, 172, 54);
		contentPane.add(add);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelActionPerformed(arg0);
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cancel.setBounds(511, 593, 172, 54);
		contentPane.add(cancel);
		
		String[] dept= {"CSE","ECE","ME","CE","EE"};
		String[] sem= {"1","2","3","4","5","6","7","8"};
		
		comboBox_5 = new JComboBox(dept);
		comboBox_5.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(422, 296, 131, 30);
		contentPane.add(comboBox_5);
		
		comboBox_6 = new JComboBox(sem);
		comboBox_6.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		comboBox_6.setBackground(Color.WHITE);
		comboBox_6.setBounds(422, 354, 131, 30);
		contentPane.add(comboBox_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		lblNewLabel.setBounds(-156, -174, 1159, 854);
		contentPane.add(lblNewLabel);
	}
		private void addButtonPerformed(ActionEvent arg0) {
			try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	            String sql = "insert into student (studentname,roll, dept,semester, subject_subjectid) values(?,?,?,?,?)";
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1,textField.getText());
	            pst.setString(2, textField_1.getText());
	            pst.setString(3,comboBox_5.getSelectedItem().toString());
	            pst.setString(4,comboBox_6.getSelectedItem().toString());
	            pst.setString(5,subject1.getText());
	           // System.out.println(l1.getText());
	            pst.execute();
	            
	            
	            String sql1 = "insert into studentroll (roll, name) values(?,?)";
	             pst1 = (OraclePreparedStatement) conn.prepareStatement(sql1);
	             pst1.setString(1, textField_1.getText());
	             pst1.setString(2,textField.getText());
	             pst1.execute();
	            //JOptionPane.showMessageDialog(null, "Saved");

	        } catch (Exception e ) {
	            System.out.println("no");
	            JOptionPane.showMessageDialog(null, e);
	        }
	         
			try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	            String sql = "insert into student (studentname,roll, dept,semester, subject_subjectid) values(?,?,?,?,?)";
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1,textField.getText());
	            pst.setString(2, textField_1.getText());
	            pst.setString(3,comboBox_5.getSelectedItem().toString());
	            pst.setString(4,comboBox_6.getSelectedItem().toString());
	            pst.setString(5,subject2.getText());
	           // System.out.println(l1.getText());
	            pst.execute();
	            //JOptionPane.showMessageDialog(null, "Saved");

	        } catch (Exception e ) {
	            System.out.println("no");
	            JOptionPane.showMessageDialog(null, e);
	        }
	         
	         
			try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	            String sql = "insert into student (studentname,roll, dept,semester, subject_subjectid) values(?,?,?,?,?)";
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1,textField.getText());
	            pst.setString(2, textField_1.getText());
	            pst.setString(3,comboBox_5.getSelectedItem().toString());
	            pst.setString(4,comboBox_6.getSelectedItem().toString());
	            pst.setString(5,subject3.getText());
	           // System.out.println(l1.getText());
	            pst.execute();
	            //JOptionPane.showMessageDialog(null, "Saved");

	        } catch (Exception e ) {
	            System.out.println("no");
	            JOptionPane.showMessageDialog(null, e);
	        }
	         
	         
	         
			try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	            String sql = "insert into student (studentname,roll, dept,semester, subject_subjectid) values(?,?,?,?,?)";
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1,textField.getText());
	            pst.setString(2, textField_1.getText());
	            pst.setString(3,comboBox_5.getSelectedItem().toString());
	            pst.setString(4,comboBox_6.getSelectedItem().toString());
	            pst.setString(5,subject4.getText());
	           // System.out.println(l1.getText());
	            pst.execute();
	            //JOptionPane.showMessageDialog(null, "Saved");

	        } catch (Exception e ) {
	            System.out.println("no");
	            JOptionPane.showMessageDialog(null, e);
	        }
	         
	         
	         
	         try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	            String sql = "insert into student (studentname,roll, dept,semester, subject_subjectid) values(?,?,?,?,?)";
	            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1,textField.getText());
	            pst.setString(2, textField_1.getText());
	            pst.setString(3,comboBox_5.getSelectedItem().toString());
	            pst.setString(4,comboBox_6.getSelectedItem().toString());
	            pst.setString(5,subject5.getText());
	            //System.out.println(l1.getText());
	            pst.execute();
	            int op = JOptionPane.showConfirmDialog(null,"Student Entry Done. Next Student","Saved",0);
	            if(op==0){
	                Addstudent f3 = new Addstudent();
	                f3.setVisible(true);
	                dispose();
	            }
	            else
	                if(op==0){
	                Addinfoform f3 = new Addinfoform();
	                f3.setVisible(true);
	                dispose();
	            }
	                
	        } catch (Exception e ) {
	            System.out.println("no");
	            JOptionPane.showMessageDialog(null, e);
	        }
		
	}

		private void comboBoxPopupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			 String tmp = (String)comboBox.getSelectedItem();
		        String sql = "select * from subject where subjectname = ?";
		        
		        try{
		            
		            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
		            pst.setString(1, tmp);
		            rs = (OracleResultSet) pst.executeQuery();
		            if(rs.next())
		            {
		                String id = rs.getString("subjectid");
		                subject1.setText(id);
		            }
		        }catch(Exception e)
		        {
		            
		        }
		
	}

		private void comboBox4PopupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			 String tmp = (String)comboBox_4.getSelectedItem();
		        String sql = "select * from subject where subjectname = ?";
		        
		        try{
		            
		            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
		            pst.setString(1, tmp);
		            rs = (OracleResultSet) pst.executeQuery();
		            if(rs.next())
		            {
		                String id = rs.getString("subjectid");
		                subject5.setText(id);
		            }
		        }catch(Exception e)
		        {
		            
		        }
		
	}

		private void comboBox3PopupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			 String tmp = (String)comboBox_3.getSelectedItem();
		        String sql = "select * from subject where subjectname = ?";
		        
		        try{
		            
		            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
		            pst.setString(1, tmp);
		            rs = (OracleResultSet) pst.executeQuery();
		            if(rs.next())
		            {
		                String id = rs.getString("subjectid");
		                subject4.setText(id);
		            }
		        }catch(Exception e)
		        {
		            
		        }
		
	}

		private void comboBox2PopupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			 String tmp = (String)comboBox_2.getSelectedItem();
		        String sql = "select * from subject where subjectname = ?";
		        
		        try{
		            
		            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
		            pst.setString(1, tmp);
		            rs = (OracleResultSet) pst.executeQuery();
		            if(rs.next())
		            {
		                String id = rs.getString("subjectid");
		                subject3.setText(id);
		            }
		        }catch(Exception e)
		        {
		            
		        }
		
	}

		private void comboBox1PopupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			 String tmp = (String)comboBox_1.getSelectedItem();
		        String sql = "select * from subject where subjectname = ?";
		        
		        try{
		            
		            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
		            pst.setString(1, tmp);
		            rs = (OracleResultSet) pst.executeQuery();
		            if(rs.next())
		            {
		                String id = rs.getString("subjectid");
		                subject2.setText(id);
		            }
		        }catch(Exception e)
		        {
		            
		        }
		
	}

		private void formWindowOpened(WindowEvent arg0) {
			fillcombobox();
	}

		private void cancelActionPerformed(ActionEvent arg0) {
				
				Addinfoform f2=new Addinfoform();
				f2.setVisible(true);
				dispose();
			}
}
