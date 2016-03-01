import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;


public class TabDemo extends JFrame {
	
	
	public static void main(String[] args) {
		
					TabDemo frame = new TabDemo();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public TabDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 461);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		tabbedPane.setBounds(33, 30, 570, 356);
		getContentPane().add(tabbedPane);
		ImageIcon icon = new ImageIcon(TabDemo.class.getResource("login.jpg"));
		JPanel loginpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
		loginpanel.setLayout(null);
		tabbedPane.addTab("Login", null, loginpanel, null);
		Icon loginIcon = new ImageIcon(TabDemo.class.getResource("login-icon.png"));
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Click To Login");
		btnLogin.setMnemonic('L');
		btnLogin.setIcon(loginIcon);
		btnLogin.setBounds(69, 193, 159, 66);
		loginpanel.add(btnLogin);
		
		JButton btnCancel = new JButton("Clear");
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(276, 194, 134, 65);
		loginpanel.add(btnCancel);
		
		JPanel regpanel = new JPanel();
		regpanel.setLayout(null);
		tabbedPane.addTab("Register", null, regpanel, null);
		
		JRadioButton rdbtnMale = new JRadioButton();
		rdbtnMale.setBounds(51, 154, 109, 23);
		rdbtnMale.setText("Male");
		regpanel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton();
		rdbtnFemale.setText("Female");
		rdbtnFemale.setBounds(222, 154, 109, 23);
		regpanel.add(rdbtnFemale);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
	}
}
