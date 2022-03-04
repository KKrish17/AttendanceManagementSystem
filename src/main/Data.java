package main;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Data {

	public static void main(String[] args) {
		
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String s;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/postbox", "root", "");
			st=con.createStatement();
			s="Select * from users";
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
			JFrame j=new JFrame();
			JPanel jp=new JPanel();
			j.setSize(1000,100);
			j.setLocationRelativeTo(null);
			JTable jt=new JTable(data,col);
			jt.setRowHeight(30);
			JScrollPane jsp=new JScrollPane(jt);
			jp.setLayout(new BorderLayout());
			jp.add(jsp,BorderLayout.CENTER);
			j.setContentPane(jp);
			j.setVisible(true);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}finally {
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
