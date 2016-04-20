package com.brainmentors.ims.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.brainmentors.ims.common.dao.CommonDAO;

public class LoginDAO {
	public boolean isUserLogin(String userid, String password) throws NamingException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement("select userid,password from users where userid=? and password=? and status='A'");
			pstmt.setString(1,userid);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
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
		return false;
	}
}
