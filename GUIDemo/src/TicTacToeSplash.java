import jaco.mp3.player.MP3Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class TicTacToeSplash extends JWindow {
	Timer timer = null;
	Timer progressTimer ;
	int y = 321;
	JLabel rocket = new JLabel("");
	int progressStart = 1;
	int colorRange = 255;
	private JLabel lblGame = new JLabel("Game-2016");
	private boolean isVisible= false;
	private Icon  icon = new ImageIcon(TicTacToeSplash.class.getResource("main.gif"));
	private Icon  rocketIcon = new ImageIcon(TicTacToeSplash.class.getResource("rocket.png"));
	private final JProgressBar progressBar = new JProgressBar();
	public static void main(String[] args) {
		
					TicTacToeSplash frame = new TicTacToeSplash();
					frame.setVisible(true);
					frame.doAnimation();
					frame.doProgress();
				
	}
	
	

	/**
	 * Create the frame.
	 */
	public TicTacToeSplash() {
		getContentPane().setBackground(Color.CYAN);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 507);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(10, 0, 557, 337);
		getContentPane().add(lblNewLabel);
		
		
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGame.setBounds(180, 374, 212, 47);
		getContentPane().add(lblGame);
		
		
		rocket.setIcon(rocketIcon);
		rocket.setBounds(494, 321, 92, 100);
		getContentPane().add(rocket);
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 18));
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.MAGENTA);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(10, 417, 563, 50);
		
		getContentPane().add(progressBar);
	}
	
	private void doProgress(){
		MP3Player mp3 = new MP3Player(TicTacToeSplash.class.getResource("BMB.mp3"));
		mp3.play();
		progressTimer = new Timer(300,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(progressStart<=100){
					progressBar.setValue(progressStart);
					progressStart ++;
					
					
					}
				if(progressStart>=100){
					TicTacToe obj = new TicTacToe();
					obj.setVisible(true);
					TicTacToeSplash.this.setVisible(false);
					TicTacToeSplash.this.dispose();
					mp3.stop();
					timer.stop();
					progressTimer.stop();
					
				}
			}
		});
		progressTimer.start();
	}
	
	private void doAnimation(){
		
		timer = new Timer(50,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(isVisible){
					Random r = new Random();
				lblGame.setForeground(new Color(r.nextInt(colorRange),r.nextInt(colorRange-30),r.nextInt(colorRange-50)));
				}
				rocket.setBounds(494,y , 92, 100);
				y--;
				lblGame.setVisible(isVisible);
				isVisible = !isVisible;
				
			}
		});
		timer.start();
	}
}
