import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class QuestionFill extends JFrame {
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextField ans4;
	private JTextField rans;
	JTextArea question = new JTextArea();
	private ArrayList<Question> questionList = new ArrayList<Question>();
	
	public static void main(String[] args) {
		
					QuestionFill frame = new QuestionFill();
					frame.setVisible(true);
				

	}
	public QuestionFill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 492);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 29, 498, 218);
		getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(question);
		
		ans1 = new JTextField();
		ans1.setBounds(77, 270, 440, 20);
		getContentPane().add(ans1);
		ans1.setColumns(10);
		
		ans2 = new JTextField();
		ans2.setColumns(10);
		ans2.setBounds(77, 309, 440, 20);
		getContentPane().add(ans2);
		
		ans3 = new JTextField();
		ans3.setColumns(10);
		ans3.setBounds(77, 340, 440, 20);
		getContentPane().add(ans3);
		
		ans4 = new JTextField();
		ans4.setColumns(10);
		ans4.setBounds(77, 371, 440, 20);
		getContentPane().add(ans4);
		
		rans = new JTextField();
		rans.setColumns(10);
		rans.setBounds(77, 402, 440, 20);
		getContentPane().add(rans);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveQuestion();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(QuestionFill.this, "Error in Question Save...");
				}
			}
		});
		btnSave.setBounds(545, 339, 89, 23);
		getContentPane().add(btnSave);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addQuestion();
			}
		});
		add.setBounds(545, 288, 89, 23);
		getContentPane().add(add);
	}
	
	private void addQuestion(){
		Question ques = new Question();
		ques.setQuestion(question.getText());
		ques.setAns1(ans1.getText());
		ques.setAns2(ans2.getText());
		ques.setAns3(ans3.getText());
		ques.setAns4(ans4.getText());
		ques.setRans(rans.getText());
		questionList.add(ques);
	}
	private void saveQuestion() throws IOException{
		FileOutputStream fo = new FileOutputStream("D:\\Images\\Ques.dat");
		ObjectOutputStream os = new ObjectOutputStream(fo);
		
		for(Question ques: questionList){
		os.writeObject(ques);
		}
		os.close();
		fo.close();
		JOptionPane.showMessageDialog(this, "Question Saved..");
	}
}
