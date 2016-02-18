import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyDemo extends JFrame {
	private JTextField textField;

	
	public static void main(String[] args) {
		
					MyDemo frame = new MyDemo();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public MyDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 457);
		this.getContentPane().setLayout(null);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okClick();
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setBounds(214, 145, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelClick();
			}
		});
		btCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btCancel.setBounds(338, 145, 89, 23);
		getContentPane().add(btCancel);
		
		textField = new JTextField();
		textField.setBounds(241, 68, 236, 54);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	}
	private void okClick(){
		textField.setText("Hello Ok");
	}
	private void cancelClick(){
		textField.setText("Hello Cancel");
	}
}
