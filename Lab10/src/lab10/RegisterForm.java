package lab10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegisterForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField txtUname;
	private JTextField txtPwd;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con;
		}catch(Exception e) {}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(104, 21, 348, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 69, 125, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 103, 120, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(25, 147, 120, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 192, 125, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(25, 239, 120, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(25, 288, 125, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("User Name");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(25, 338, 120, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(25, 386, 125, 22);
		contentPane.add(lblNewLabel_8);
		
		txtName = new JTextField();
		txtName.setBounds(160, 66, 96, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea textAddress = new JTextArea();
		textAddress.setBounds(160, 97, 96, 22);
		contentPane.add(textAddress);
		
		txtAge = new JTextField();
		txtAge.setBounds(160, 189, 96, 19);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(160, 236, 96, 19);
		contentPane.add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(160, 285, 96, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUname = new JTextField();
		txtUname.setBounds(160, 335, 96, 19);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(160, 383, 96, 19);
		contentPane.add(txtPwd);
		txtPwd.setColumns(10);
		
		JRadioButton optFemale = new JRadioButton("Female");
		optFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(optFemale);
		optFemale.setBounds(153, 143, 103, 21);
		contentPane.add(optFemale);
		
		JRadioButton optMale = new JRadioButton("Male");
		optMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(optMale);
		optMale.setBounds(300, 143, 103, 21);
		contentPane.add(optMale);
		
		JButton btnValidate = new JButton("Add");
		
		
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Appu@2023");
				
					String query="insert into registration values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					ps.setString(2, textAddress.getText());
					if(optFemale.isSelected())
					{
						ps.setString(3,optFemale.getText());
					}
					else
					{
						ps.setString(3, optMale.getText());
					}
					ps.setInt(4, Integer.parseInt(txtAge.getText()));
					ps.setInt(5, Integer.parseInt(txtMobile.getText()));
					ps.setString(6, txtEmail.getText());
					ps.setString(7,txtUname.getText());
					ps.setString(8, txtPwd.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnValidate, i+" Record Added Successfully");
					ps.close();
					con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnValidate.setBounds(60, 471, 85, 21);
		contentPane.add(btnValidate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				textAddress.setText("");
				buttonGroup.clearSelection();
				txtAge.setText("");
				txtMobile.setText("");
				txtEmail.setText("");
				txtUname.setText("");
				txtPwd.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(189, 471, 85, 21);
		contentPane.add(btnReset);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Appu@2023");
					String query="delete from registration where name=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnValidate, i+" Record Deleted Successfully");
					ps.close();
					con.close();
					
					
				}catch(Exception e1) {}
				
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(60, 519, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Appu@2023");
				String query="update registration set address=?, gender=?,age=?, mobile=?, email=?,username=?,password=? where name=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(8, txtName.getText());
				ps.setString(1, textAddress.getText());
				if(optFemale.isSelected())
				{
					ps.setString(2,optFemale.getText());
				}
				else
				{
					ps.setString(2, optMale.getText());
				}
				ps.setInt(3, Integer.parseInt(txtAge.getText()));
				ps.setInt(4, Integer.parseInt(txtMobile.getText()));
				ps.setString(5, txtEmail.getText());
				ps.setString(6,txtUname.getText());
				ps.setString(7, txtPwd.getText());
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(btnValidate, i+" Record Updated Successfully");
				ps.close();
				con.close();
				
									
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(189, 522, 85, 21);
		contentPane.add(btnUpdate);
		
		
	}
}