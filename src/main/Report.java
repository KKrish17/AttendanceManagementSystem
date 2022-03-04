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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;

public class Report extends JFrame {

	Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
	private Image icon=Toolkit.getDefaultToolkit().getImage("F:\\icon.png");
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public void UpdateJTable(String sql){
		try{

			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
			String sql1 = "SELECT student_roll, count(CASE WHEN  status = 'Present'  then 1 END)/count(*)*100 as percentage FROM attendence where student_subject_subjectid = ? group by student_roll";
			pst  = (OraclePreparedStatement) conn.prepareStatement(sql1);
			pst.setString(1,sql);
			rs = (OracleResultSet) pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e){
			    JOptionPane.showMessageDialog(null, e);
		}
		    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		
//		addWindowListener(new WindowAdapter() {
//			public void windowOpened(WindowEvent arg0) {
//				formWindowOpened(arg0);
//			}
//		});
		setResizable(false);
		setIconImage(icon);
		setTitle("Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setBounds(206, 74, 415, 498);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Student Roll", "Percentage"
        }));
		
		JTableHeader header1=table.getTableHeader();
		header1.setBounds(206,52,415,22);
		contentPane.add(header1);
		
		JLabel lblAttendenceReport = new JLabel("ATTENDENCE  REPORT");
		lblAttendenceReport.setForeground(Color.CYAN);
		lblAttendenceReport.setFont(new Font("Sneakerhead BTN Shadow", Font.PLAIN, 49));
		lblAttendenceReport.setBounds(165, 11, 550, 46);
		contentPane.add(lblAttendenceReport);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Addinfoform.class.getResource("/main/back.jpeg")));
		lblNewLabel.setBounds(-156, -174, 972, 829);
		contentPane.add(lblNewLabel);
	}
}
