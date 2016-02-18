import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class FirstDemo extends JFrame {//implements ActionListener {
	private JTextField t = new JTextField();
	FirstDemo(){
		JLabel lbl = new JLabel("Enter the Name");
		this.setTitle("My Frame-2016");
		this.setSize(300, 300);
		setLocation(400, 300);
		lbl.setBounds(10,120,100,50);
		t.setBounds(100, 120, 120, 50);
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		getContentPane().setLayout(null);
		ok.setBounds(20, 30, 90, 50);
		cancel.setBounds(120, 30, 90, 50);
		//getContentPane().setLayout(new FlowLayout());
		getContentPane().add(ok);
		getContentPane().add(cancel);
		getContentPane().add(t);
		getContentPane().add(lbl);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				okLogic();
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelLogic();
				
			}
		});
	}

	public static void main(String[] args) {
		FirstDemo obj = new FirstDemo();
		obj.setVisible(true);

	}
	
	private void okLogic(){
		t.setText("Hello Ok");
		this.getContentPane().setBackground(Color.RED);
	}
	private void cancelLogic(){
		t.setText("Hello Cancel");
		this.getContentPane().setBackground(Color.GREEN);
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "";
		String userName = t.getText();
		String buttonValue = e.getActionCommand();
		if(buttonValue.equalsIgnoreCase("Ok")){
			msg = "Welcome "+userName;
			
		}
		else{
			msg = "Bye Bye "+userName;
		}
		t.setText(msg);
		JOptionPane.showMessageDialog(this, msg);
		//JOptionPane.showConfirmDialog(this, "Do u want to Close this ","MyMsg",JOptionPane.YES_NO_CANCEL_OPTION);
	}*/

}
