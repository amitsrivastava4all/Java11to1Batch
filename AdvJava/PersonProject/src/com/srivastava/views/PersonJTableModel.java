package com.srivastava.views;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.srivastava.dto.PersonDTO;

public class PersonJTableModel extends AbstractTableModel {
	private ArrayList<PersonDTO> personList ;
	public String[] colNames = { "Name", "Age", "City"};
	PersonJTableModel(ArrayList<PersonDTO> personList){
		this.personList = personList;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return personList.size();
	}
	@Override
	public String getColumnName(int col) {
	      return colNames[col];
	    }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colNames.length;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PersonDTO personDTO = personList.get(rowIndex);

	      switch (columnIndex) {
	      case 0:
	        return personDTO.getName();
	      case 1:
	        return personDTO.getAge();
	      case 2:
	        return personDTO.getCity();
	      
	      }
	      return null;
	}

}
