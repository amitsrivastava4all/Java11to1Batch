package com.brainmentors.ims.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CommonUtils {
	private CommonUtils(){}
	public static String convertStackTraceToString(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

}
