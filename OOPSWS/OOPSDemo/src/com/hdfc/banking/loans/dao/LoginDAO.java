package com.hdfc.banking.loans.dao;

import java.util.logging.LogRecord;

import com.hdfc.banking.loans.dto.LoginDTO;

public class LoginDAO {
	
	public boolean doLogin(LoginDTO loginDTO){
		if(loginDTO.getUserid().equals(loginDTO.getPassword()) 
				&& loginDTO.getPinCode().equals("123")){
			return true;
		}
		else
		{
			return false;
		}
	}

}
