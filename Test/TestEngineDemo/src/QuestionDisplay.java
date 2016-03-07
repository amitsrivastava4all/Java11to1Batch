import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class QuestionDisplay extends JFrame {
	JRadioButton ans1  = new JRadioButton();
	JRadioButton ans2  = new JRadioButton();
	JRadioButton ans3  = new JRadioButton();
	JRadioButton ans4  = new JRadioButton();
	ButtonGroup bg = new ButtonGroup();
	private ArrayList<Question> questionList = new ArrayList<Question>();
	private final JButton btnSubmit = new JButton("Submit");
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
					QuestionDisplay frame = new QuestionDisplay();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public QuestionDisplay() throws ClassNotFoundException, IOException {
		questionList = getAllQuestion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 471);
		this.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 26, 562, 209);
		getContentPane().add(scrollPane);
		bg.add(ans1);
		bg.add(ans2);
		bg.add(ans3);
		bg.add(ans4);
		ans1.setBounds(28,250,100,50);
		ans2.setBounds(28,300,100,50);
		ans3.setBounds(28,350,100,50);
		ans4.setBounds(28,400,100,50);
		JTextArea ques = new JTextArea();
		scrollPane.setViewportView(ques);
		this.getContentPane().add(ans1);
		this.getContentPane().add(ans2);
		this.getContentPane().add(ans3);
		this.getContentPane().add(ans4);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeAnswer();
			}
		});
		btnSubmit.setBounds(450, 300, 89, 23);
		
		getContentPane().add(btnSubmit);
		if(questionList.size()>0){
			ques.setText(questionList.get(0).getQuestion());
			ans1.setText(questionList.get(0).getAns1());
			ans2.setText(questionList.get(0).getAns2());
			ans3.setText(questionList.get(0).getAns3());
			ans4.setText(questionList.get(0).getAns4());
		}
	}
	
	private void takeAnswer(){
		if(ans1.isSelected()){
			JOptionPane.showMessageDialog(this, "U Select First");
		}
		if(ans2.isSelected()){
			JOptionPane.showMessageDialog(this, "U Select Second");
		}
	}
	private ArrayList<Question> getAllQuestion() throws IOException, ClassNotFoundException{
		ArrayList<Question> questionList = new ArrayList<Question>();
		FileInputStream fi = new FileInputStream("D:\\Images\\Ques.dat");
		ObjectInputStream oi = new ObjectInputStream(fi);
		while(true){
			try{
			Object o = oi.readObject();
			questionList.add((Question)o);
			}
			catch(EOFException e){
				System.out.println("EOF Exception Reach "+questionList);
				break;
			}
		}
		oi.close();
		fi.close();
		return questionList;
	}
}
