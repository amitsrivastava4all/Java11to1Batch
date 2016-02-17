import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TicTacToe extends JFrame {
	private boolean isXorZero= false;
	JButton one = new JButton("");
	JButton two = new JButton("");
	JButton three = new JButton("");
	JButton four = new JButton("");
	JButton five = new JButton("");
	JButton six = new JButton("");
	JButton seven = new JButton("");
	JButton eight = new JButton("");
	JButton nine = new JButton("");
	public static void main(String[] args) {
		
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(one);
			}
		});
		one.setFont(new Font("Tahoma", Font.BOLD, 24));
		one.setBounds(35, 57, 104, 47);
		getContentPane().add(one);
		
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(two);
			}
		});
		two.setFont(new Font("Tahoma", Font.BOLD, 24));
		two.setBounds(158, 57, 104, 47);
		getContentPane().add(two);
		
		
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(three);
			}
		});
		three.setFont(new Font("Tahoma", Font.BOLD, 24));
		three.setBounds(292, 57, 104, 47);
		getContentPane().add(three);
		
		
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(four);
			}
		});
		four.setFont(new Font("Tahoma", Font.BOLD, 24));
		four.setBounds(35, 138, 104, 47);
		getContentPane().add(four);
		
		
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(five);
			}
		});
		five.setFont(new Font("Tahoma", Font.BOLD, 24));
		five.setBounds(158, 138, 104, 47);
		getContentPane().add(five);
		
		
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(six);
			}
		});
		six.setFont(new Font("Tahoma", Font.BOLD, 24));
		six.setBounds(292, 138, 104, 47);
		getContentPane().add(six);
		
		
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(seven);
			}
		});
		seven.setFont(new Font("Tahoma", Font.BOLD, 24));
		seven.setBounds(35, 196, 104, 47);
		getContentPane().add(seven);
		
		
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(eight);
			}
		});
		eight.setFont(new Font("Tahoma", Font.BOLD, 24));
		eight.setBounds(158, 196, 104, 47);
		getContentPane().add(eight);
		
		
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(nine);
			}
		});
		nine.setFont(new Font("Tahoma", Font.BOLD, 24));
		nine.setBounds(292, 196, 104, 47);
		getContentPane().add(nine);
		
		JLabel lblTictactoe = new JLabel("TicTacToe");
		lblTictactoe.setForeground(Color.BLUE);
		lblTictactoe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTictactoe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTictactoe.setBounds(96, 11, 222, 28);
		getContentPane().add(lblTictactoe);
	}
	private void printXorZero(JButton button){
		if(button.getText().trim().length()==0){
		if(isXorZero){
		button.setText("X");
		}
		else
		{
			button.setText("0");
		}
		
		isXorZero = !isXorZero;
		if(isWin()){
			JOptionPane.showMessageDialog(this, "Game Over ");
		}
	
		}
	}
	private boolean isWin(){
		boolean win = false;
		if(!isRowBlank(one, two, three)){
		if((one.getText().equals(two.getText())) && (one.getText().equals(three.getText()))){
			win = true;
		}
		}
		return win;
		
	}
	
	private boolean isRowBlank(JButton b1 , JButton b2, JButton b3){
		if(isButtonBlank(b1) && isButtonBlank(b2) && isButtonBlank(b3)){
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean isButtonBlank(JButton b1){
		if(b1.getText().trim().length()==0){
			return true;
		}
		return false;
	}
}
