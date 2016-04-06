package com.srivastava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.srivastava.dao.QueryConstants.*;

import com.srivastava.dto.PersonDTO;

// DAO - Data Access Object and this class contains all the DB Related Logic
public class PersonDAO {
	
	public ArrayList<PersonDTO> selectAllPersons() throws ClassNotFoundException, SQLException{
		ArrayList<PersonDTO> personList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try{
		con = CommonDAO.createConnection();
		pstmt = con.prepareStatement(PERSON_SELECT_SQL);
		rs = pstmt.executeQuery();
		while(rs.next()){
			PersonDTO personDTO =new PersonDTO();
			personDTO.setName(rs.getString(PERSON_COLUMN_NAME));
			personDTO.setAge(rs.getInt(PERSON_COLUMN_AGE));
			personDTO.setCity(rs.getString(PERSON_COLUMN_CITY));
			personList.add(personDTO);
		}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return personList;
	}
	
	public boolean addPerson(PersonDTO personDTO) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = CommonDAO.createConnection();
			pstmt = con.prepareStatement(QueryConstants.PERSON_INSERT_SQL);
			pstmt.setString(1,personDTO.getName());
			pstmt.setInt(2,personDTO.getAge());
			pstmt.setString(3,personDTO.getCity());
			int recCount = pstmt.executeUpdate();
			if(recCount>0){
				return true;
			}
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return false;
	}

}
