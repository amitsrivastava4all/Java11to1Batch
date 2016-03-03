import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class MainScreen extends JFrame {
	private JTextField userTxt;
	private JTextField pwdTxt;
	private JTextField useridTxt;
	private JPasswordField passwordTxt;
	private JTextField emailTxt;

	
	public static void main(String[] args) {
		
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 454);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 32, 536, 355);
		getContentPane().add(tabbedPane);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		tabbedPane.addTab("Login", null, loginPanel, null);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(20, 64, 46, 14);
		loginPanel.add(lblUserid);
		
		userTxt = new JTextField();
		userTxt.setBounds(115, 61, 194, 20);
		loginPanel.add(userTxt);
		userTxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 128, 76, 14);
		loginPanel.add(lblPassword);
		
		pwdTxt = new JPasswordField();
		
		pwdTxt.setBounds(118, 125, 191, 20);
		loginPanel.add(pwdTxt);
		pwdTxt.setColumns(10);
		
		JButton loginBT = new JButton("Login");
		loginBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginHere();
			}
		});
		loginBT.setBounds(20, 187, 89, 23);
		loginPanel.add(loginBT);
		
		JButton clearBt = new JButton("Clear");
		clearBt.setBounds(134, 187, 89, 23);
		loginPanel.add(clearBt);
		
		JPanel regPanel = new JPanel();
		regPanel.setLayout(null);
		tabbedPane.addTab("Register", null, regPanel, null);
		
		useridTxt = new JTextField();
		useridTxt.setBounds(178, 41, 137, 20);
		regPanel.add(useridTxt);
		useridTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(178, 101, 137, 20);
		regPanel.add(passwordTxt);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(173, 163, 142, 20);
		regPanel.add(emailTxt);
		emailTxt.setColumns(10);
		
		JLabel lblUserid_1 = new JLabel("Userid");
		lblUserid_1.setBounds(22, 44, 46, 14);
		regPanel.add(lblUserid_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(22, 107, 46, 14);
		regPanel.add(lblPassword_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 166, 46, 14);
		regPanel.add(lblEmail);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerHere();
			}
		});
		btnRegister.setBounds(27, 227, 89, 23);
		regPanel.add(btnRegister);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(169, 227, 89, 23);
		regPanel.add(btnClear);
	}
	private void registerHere(){
		User user = new User();
		user.setUserid(useridTxt.getText());
		user.setPassword(passwordTxt.getText());
		user.setEmail(emailTxt.getText());
		
		try {
			if(UserOperations.registerUser(user)){
				JOptionPane.showMessageDialog(this, "Register SuccessFully");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Problem in Register Please Try After some time");
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Error in Register");
		}
	}
	private void loginHere(){
		User user = new User();
		user.setUserid(userTxt.getText());
		user.setPassword(pwdTxt.getText());
		try {
			if(UserOperations.isUserExist(user)){
				JOptionPane.showMessageDialog(this, "Welcome "+user.getUserid());
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invalid Userid or password");
			}
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Error in Login ");
		}
		
		
	}
}
