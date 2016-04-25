package com.brainmentors.ims.common.utils;

import java.util.ResourceBundle;

public class ConfigReader {
	private ConfigReader(){}
public static final ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getProjectName(){
		return rb.getString("projectname");
}
	public static String getProjectFullName(){
		return rb.getString("projectfullname");
}
	
	public static String getJNDI(){
		return rb.getString("jndiname");
	}
	
}
