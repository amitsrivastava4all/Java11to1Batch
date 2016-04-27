package com.brainmentors.ims.common.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.brainmentors.ims.common.utils.ConfigReader;

public interface CommonDAO {
public static Connection getConnection() throws NamingException, SQLException{
	Connection con = null;
	Context ctx = null;
	ctx = new InitialContext();
	DataSource ds = (DataSource) ctx.lookup(ConfigReader.getJNDI());
	con = ds.getConnection();
	return con;
	
}
}
