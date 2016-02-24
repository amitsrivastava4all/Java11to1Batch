import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class TicTacToe extends JFrame {
	Timer timer;
	int noOfSpaces = 18;
	String title = "TicTacToeGame-2016";
	int Xscore = 0; 
	int zeroScore = 0;
	String msg = "Zero Score";
	String xmsg = "X Score ";
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
	boolean isGameStart = false;
	
	private String fillSpaces(){
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i<=noOfSpaces){
			sb.append(" ");
			i++;
		}
		return sb.toString();
	}
	
	private void moveTitle(){
		 timer = new Timer(200,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				char firstChar = TicTacToe.this.getTitle().charAt(0);
				TicTacToe.this.setTitle(TicTacToe.this.getTitle().substring(1)+firstChar);
				
			}
		});
		 timer.start();
	}
	
	public static void main(String[] args) {
		
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
					frame.moveTitle();
				
	}
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawRect(10, 50, 100, 100);
        g.drawString(msg,20,70);
        g.drawString(xmsg,350,70);
    }

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		this.setTitle(fillSpaces()+title);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				windowclose();
			}
		});
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 516, 389);
		getContentPane().setLayout(null);
		
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(one);
			}
		});
		one.setFont(new Font("Tahoma", Font.BOLD, 24));
		one.setBounds(35, 114, 104, 47);
		getContentPane().add(one);
		
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(two);
			}
		});
		two.setFont(new Font("Tahoma", Font.BOLD, 24));
		two.setBounds(158, 114, 104, 47);
		getContentPane().add(two);
		
		
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(three);
			}
		});
		three.setFont(new Font("Tahoma", Font.BOLD, 24));
		three.setBounds(292, 114, 104, 47);
		getContentPane().add(three);
		
		
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(four);
			}
		});
		four.setFont(new Font("Tahoma", Font.BOLD, 24));
		four.setBounds(35, 195, 104, 47);
		getContentPane().add(four);
		
		
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(five);
			}
		});
		five.setFont(new Font("Tahoma", Font.BOLD, 24));
		five.setBounds(158, 195, 104, 47);
		getContentPane().add(five);
		
		
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(six);
			}
		});
		six.setFont(new Font("Tahoma", Font.BOLD, 24));
		six.setBounds(292, 195, 104, 47);
		getContentPane().add(six);
		
		
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(seven);
			}
		});
		seven.setFont(new Font("Tahoma", Font.BOLD, 24));
		seven.setBounds(35, 253, 104, 47);
		getContentPane().add(seven);
		
		
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(eight);
			}
		});
		eight.setFont(new Font("Tahoma", Font.BOLD, 24));
		eight.setBounds(158, 253, 104, 47);
		getContentPane().add(eight);
		
		
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(nine);
			}
		});
		nine.setFont(new Font("Tahoma", Font.BOLD, 24));
		nine.setBounds(292, 253, 104, 47);
		getContentPane().add(nine);
		
		JLabel lblTictactoe = new JLabel("TicTacToe");
		lblTictactoe.setForeground(Color.BLUE);
		lblTictactoe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTictactoe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTictactoe.setBounds(96, 68, 222, 28);
		getContentPane().add(lblTictactoe);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mntmReadme = new JMenuItem("ReadMe");
		mntmReadme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TicTacToe.this, "ReadMe");
			}
		});
		mntmReadme.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		mnFile.add(mntmReadme);
		mnFile.addSeparator();
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutus = new JMenuItem("AboutUs");
		mntmAboutus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnHelp.add(mntmAboutus);
		
		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mnHelp.add(mntmInstructions);
		//getContentPane().add(menuBar);
	}
	private void printXorZero(JButton button){
		isGameStart = true;
		if(button.getText().trim().length()==0){
		if(isXorZero){
		button.setText("X");
		}
		else
		{
			button.setText("0");
		}
		
		
		if(isWin()){
			if(isXorZero){
				Xscore++;
				xmsg = "X U Win "+Xscore;
			}
			else
			{
				zeroScore++;
				msg = "Zero u win "+zeroScore;
			}
			repaint();
			JOptionPane.showMessageDialog(this, "Game Over ");
		}
		isXorZero = !isXorZero;
		}
	}
	private boolean isWin(){
		boolean win = false;
		if(!isRowBlank(one, two, three)){
		if((one.getText().equals(two.getText())) && (one.getText().equals(three.getText()))){
			one.setBackground(Color.RED);
			two.setBackground(Color.RED);
			three.setBackground(Color.RED);
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
	private void windowclose(){
		if(isGameStart){
			int choice = JOptionPane.showConfirmDialog(this, "Do u want to Leave this Game ","Game-2016",JOptionPane.YES_NO_OPTION);
			if(choice ==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(this, "Thanks For Playing");
				this.setVisible(false);
				this.dispose();
			}
			else{
				return;
			}
			
		}
		else{
			JOptionPane.showMessageDialog(this, "Thanks For Playing");
			this.setVisible(false);
			this.dispose();
		}
	}
}
