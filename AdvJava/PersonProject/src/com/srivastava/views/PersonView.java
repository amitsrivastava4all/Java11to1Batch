package com.srivastava.views;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.srivastava.dao.PersonDAO;
import com.srivastava.dto.PersonDTO;

public class PersonView extends JFrame {
	private JTextField nameTxt;
	private JTextField ageTxt;
	private JTable table;
	Choice cityChoice = new Choice();

	
	public static void main(String[] args) {
		
					PersonView frame = new PersonView();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public PersonView() {
		cityChoice.add("Delhi");
		cityChoice.add("Mumbai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 478);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(54, 61, 98, 14);
		getContentPane().add(lblName);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(162, 60, 235, 20);
		getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		ageTxt = new JTextField();
		ageTxt.setBounds(168, 109, 86, 20);
		getContentPane().add(ageTxt);
		ageTxt.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(63, 115, 49, 20);
		getContentPane().add(lblAge);
		
		
		cityChoice.setBounds(168, 165, 189, 20);
		getContentPane().add(cityChoice);
		
		JLabel citylbl = new JLabel("City");
		citylbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		citylbl.setBounds(63, 165, 49, 20);
		getContentPane().add(citylbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 218, 538, 195);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewPerson();
			}
		});
		btnAdd.setBounds(415, 184, 89, 23);
		getContentPane().add(btnAdd);
		
		
	}
	private void addNewPerson(){
		String name = nameTxt.getText();
		int age = Integer.parseInt(ageTxt.getText());
		String city = cityChoice.getSelectedItem();
		PersonDTO personDTO = new PersonDTO();
		personDTO.setName(name);
		personDTO.setAge(age);
		personDTO.setCity(city);
		PersonDAO personDAO = new PersonDAO();
		try {
			boolean isAdded = personDAO.addPerson(personDTO);
			if(isAdded){
				JOptionPane.showMessageDialog(this, "Record Added SuccessFully...");
				ArrayList<PersonDTO> personList =personDAO.selectAllPersons();
				PersonJTableModel model = new PersonJTableModel(personList);
				table.setModel(model);
			}
			else{
				JOptionPane.showMessageDialog(this, "Error in Record Addition ");
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Error During Add "+e);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Error During Add "+e);
			e.printStackTrace();
		}
	}
}
