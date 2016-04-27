package com.brainmentors.ims.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.brainmentors.ims.cache.dto.CacheDTO;

public class CacheDAO {
private CacheDAO(){}
public static List<CacheDTO> getData(String key) throws NamingException, SQLException{
	String sql = "select * from commongenericparams where dkey=? and status='A'";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<CacheDTO> cacheList = new ArrayList<>();
	try
	{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,key);
		rs = pstmt.executeQuery();
		while(rs.next()){
			CacheDTO cache = new CacheDTO();
			cache.setKey(rs.getString("dkey"));
			cache.setValue(rs.getString("val"));
			cache.setDesc(rs.getString("descr"));
			cacheList.add(cache);
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
	return cacheList;
}
}
