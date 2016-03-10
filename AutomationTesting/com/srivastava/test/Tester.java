package com.srivastava.test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.srivastava.excel.ExcelReaderWriter;
import com.srivastava.excel.TestCase;

public class Tester {
	
	public void doTest(ArrayList<TestCase> list,File file) throws Exception{
		int rowCount = 0;
		if(list!=null && list.size()>0){
			for(TestCase testCase : list){
				rowCount++;
				Object object = Class.forName(testCase.getClassName()).newInstance();
				Method methods[] = object.getClass().getDeclaredMethods();
				for(Method method : methods){
					if(method.getName().equals(testCase.getMethodName())){
						Class params[]= method.getParameterTypes();
						Method m = object.getClass().getDeclaredMethod(testCase.getMethodName(),params);
						String parameters[] = testCase.getInputArgs().split(",");
						Object[] intParams = new Object[parameters.length];
						int index = 0;
						for(String p :parameters){
							intParams[index] = Integer.parseInt(p);
							index++;
						}
						Object result = m.invoke(object, intParams);
						System.out.println("Result is "+result+" "+testCase.getExpected());
						if(((Integer)result).intValue()==Integer.parseInt(testCase.getExpected())){
							result = "Pass";
						}
						else{
							result = "Fail";
						}
						ExcelReaderWriter.writeExcel(file, result.toString(),rowCount);
					break;
					}
				}
			}
		}
		
	}

}
