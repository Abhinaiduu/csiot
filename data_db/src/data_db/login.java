package data_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField t1;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" login page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(206, 26, 153, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("S no");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(66, 100, 85, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lb1 = new JLabel("name");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb1.setBounds(66, 198, 85, 28);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("marks");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setBounds(66, 255, 85, 28);
		frame.getContentPane().add(lb2);
		
		t1 = new JTextField();
		t1.setBounds(152, 108, 118, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 206, 118, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 263, 118, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sn=t1.getText();
				int sno=Integer.parseInt(sn);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec5","root","mrec");
					String q="select name,marks from student4 where sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1,sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					1b1.setText("Name;"+rs.getString(1));
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(206, 162, 126, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
