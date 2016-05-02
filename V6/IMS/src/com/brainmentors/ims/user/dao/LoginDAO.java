package com.brainmentors.ims.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.brainmentors.ims.common.dao.CommonDAO;
import com.brainmentors.ims.user.dto.User;
import com.brainmentors.ims.user.dto.UserRights;

public class LoginDAO {
	private Logger logger = Logger.getLogger(LoginDAO.class);
	public User isUserLogin(String userid, String password) throws NamingException, SQLException{
		logger.debug("Inside isUserLogin "+userid+" ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserRights> userRightsList =new ArrayList<>();
		User user = null;
		
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
			while(rs.next()){
				if(user==null){
				user = new User();
				user.setUserid(rs.getString("userid"));
				user.setRole(rs.getString("name"));
				}
				UserRights userRights  = new UserRights();
				userRights.setRightName(rs.getString("rightoptions"));
				userRights.setRightLink(rs.getString("link"));
				userRightsList.add(userRights);
			}
			if(user!=null){
				user.setRights(userRightsList);
			}
			/*if(rs.next()){
				return true;
			}*/
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
		logger.debug("Inside isUserLogin Ends "+userid+" ");
		return user;
	}
}
