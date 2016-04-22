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
		String sql = " select userid,password,u.uid,r.roleid,name,rs.rightid,rightoptions,"
				+ " link from users u,roles r , rights rs , userrolemapping ur,"
				+ " role_right_mapping rm where "
				+" userid=? and password=? and u.uid=ur.uid and "
				+" r.roleid=ur.roleid and r.roleid=rm.roleid and rs.rightid=rm.rightid";
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
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
