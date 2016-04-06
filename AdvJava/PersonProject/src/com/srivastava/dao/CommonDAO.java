package com.srivastava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Common DAO interface is Used for Storing the Connection Information
public interface CommonDAO {
public static Connection createConnection() throws ClassNotFoundException, SQLException{
	ResourceBundle rb = readResourceBundle();
	String driverName = rb.getString("drivername"); 
	Class.forName(driverName);
	String url = rb.getString("dburl");
	String userid = rb.getString("userid");
	String password =rb.getString("password");
	Connection con = DriverManager.getConnection(url,userid,password);
	return con;
}
public static ResourceBundle readResourceBundle(){
	ResourceBundle rb = ResourceBundle.getBundle("db");
	return rb;
}
}
